package com.ipaynow.bcfinance.service.impl;

import com.alibaba.fastjson.JSON;
import com.ipaynow.bcfinance.dao.BlockChainAccountMapper;
import com.ipaynow.bcfinance.domain.*;
import com.ipaynow.bcfinance.dto.OpenMerchantDto;
import com.ipaynow.bcfinance.dto.RepayRespDto;
import com.ipaynow.bcfinance.enums.*;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.manager.FinanceManager;
import com.ipaynow.bcfinance.service.*;
import com.ipaynow.bcfinance.utils.LockKey;
import com.ipaynow.bcfinance.utils.MoneyUtil;
import com.ipaynow.bcfinance.dto.LoanCreditDto;
import com.ipaynow.bcfinance.dto.RepaymentDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author wu
 * @createTime 2019/6/21
 */
@Service
public class JoinFinancialServiceImpl implements JoinFinancialService {

    private static Logger logger = LogManager.getLogger(JoinFinancialServiceImpl.class);

    @Autowired
    private LoanCreditService loanCreditService;

    @Autowired
    private RepaymentService repaymentService;

    @Autowired
    private ChainTransService chainTransService;

    @Autowired
    private AssetStatementService assetStatementService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private FinanceManager financeManager;

    @Autowired
    private FinancialOnChainService financialOnChainService;

    @Autowired
    private BlockChainAccountMapper blockChainAccountMapper;

    @Autowired
    private MerchantService merchantService;

    /**
     * 锁粒度 --> 锁对象
     */
    private ConcurrentHashMap<LockKey, Object> locks = new ConcurrentHashMap<>();

    @Override
    public void processLoan(LoanCreditDto loanCreditDto) {
        try {
            logger.info("借款数据处理开始,param:{}", JSON.toJSONString(loanCreditDto));
            LoanCredit bfLoanCredit = loanCreditService.queryLoanCreditById(loanCreditDto.getId(), loanCreditDto.isHistory);

            if (bfLoanCredit != null) {
                logger.error("融资数据重复!param:{}", JSON.toJSONString(loanCreditDto));
                throw new BusinessException(ExceptionEnum.DUP_CREDIT_DATA);
            }
            ChainTrans chainTrans = new ChainTrans();
            LoanCredit loanCredit = new LoanCredit();
            //如果不是历史数据先入库，上链后更新状态
            if (!loanCreditDto.isHistory) {
                //保存融资信息,交易信息
                loanCredit = generateLoanInfo(loanCreditDto);
                chainTrans = generateChainTrans(String.valueOf(loanCreditDto.getId()), OperationTypeEnum.APPLY);
                //loanCreditService.saveLoanInfo(loanCredit);
                financeManager.saveLoanInfo(chainTrans, loanCredit);
                List<ChainTrans> transes = chainTransService.queryByBusinessIdAndType(loanCreditDto.getId(), OperationTypeEnum.APPLY.getCode());
                chainTrans.setId(transes.get(0).getId());
            }
            List<MerchantPlatformBusiness> businessList = assetStatementService.queryAssets(loanCreditDto.getUserIdOfIPayNowOfDebtor(), loanCreditDto.getRealLoanTime());
            if (CollectionUtils.isEmpty(businessList)) {
                logger.error("找不到债务人对应的资产信息!param:{}", JSON.toJSONString(loanCreditDto));
                throw new BusinessException(ExceptionEnum.NO_ASSETS_ERROR);
            }
            List<BigInteger> assetsList = businessList.stream().map(assets -> BigInteger.valueOf(assets.getId())).collect(Collectors.toList());
            String assetsIds = businessList.stream().map(s -> String.valueOf(s.getId())).collect(Collectors.joining(","));
            //添加平台
            BlockChainAccount blockChainAccountP = platformService.addPlatform(loanCreditDto.getUserIdOfIPayNowOfCreditor(), loanCreditDto.getCreditorName());
            //创建锁粒度对象
            LockKey lockKey = new LockKey(loanCreditDto.getUserIdOfIPayNowOfDebtor(), loanCreditDto.getUserIdOfIPayNowOfCreditor());
            //putIfAbsent原子操作
            locks.putIfAbsent(lockKey, new Object());
            List<JoinMerchant> merchantLists;
            //同步查询
            synchronized (locks.get(lockKey)) {
                merchantLists = merchantService.queryByDbtorIdAndCreditId(loanCreditDto.getUserIdOfIPayNowOfDebtor(), loanCreditDto.getUserIdOfIPayNowOfCreditor());
                if (CollectionUtils.isEmpty(merchantLists)) {
                    logger.info("查询到该平台和商户是第一次交易,建立商户和平台的合作关系,creditorId:{},debtor:{}", loanCreditDto.getUserIdOfIPayNowOfCreditor(), loanCreditDto.getUserIdOfIPayNowOfDebtor());
                    OpenMerchantDto openMerchantDto = new OpenMerchantDto();
                    openMerchantDto.setCreditorName(loanCreditDto.getCreditorName());
                    openMerchantDto.setUserIdOfIPayNowOfCreditor(loanCreditDto.getUserIdOfIPayNowOfCreditor());
                    openMerchantDto.setUserIdOfIPayNowOfDebtor(loanCreditDto.getUserIdOfIPayNowOfDebtor());
                    platformService.openMerchant(openMerchantDto, blockChainAccountP);
                }
                //将锁删除，避免内存泄漏
                locks.remove(lockKey);
            }

            BlockChainAccount creditAccount = getChainAccount(loanCreditDto.getUserIdOfIPayNowOfCreditor());
            BlockChainAccount debtorAccount = getChainAccount(loanCreditDto.getUserIdOfIPayNowOfDebtor());
            if (loanCreditDto.isHistory) {
                logger.info("恢复历史数据上链,并更新数据库,creditId:{},assetsIds:{},param:{}", loanCreditDto.getId(), assetsIds, JSON.toJSONString(loanCreditDto));
                restoreHistoryData(loanCreditDto, assetsIds, assetsList, creditAccount.getPrivateKey(), debtorAccount.getPrivateKey());
            } else {
                logger.info("发送融资信息上链,并更新数据库,creditId:{},param:{}", loanCreditDto.getId(), JSON.toJSONString(loanCreditDto));
                loanToChain(chainTrans, loanCredit, assetsIds, assetsList, creditAccount.getPrivateKey(), debtorAccount.getPrivateKey());
            }
            logger.info("借款数据处理结束,creditId:{}", loanCreditDto.getId());
        } catch (BusinessException e) {
            logger.error("融资失败,param:{}", JSON.toJSONString(loanCreditDto), e);
            throw e;
        } catch (Exception e) {
            logger.error("融资失败,param:{}", JSON.toJSONString(loanCreditDto), e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }

    }

    @Override
    public void processRepayment(RepaymentDto repaymentDto) {
        try {
            logger.info("还款数据处理开始,param:{}", JSON.toJSONString(repaymentDto));
            LoanRepay loanRefund = repaymentService.queryRepayById(repaymentDto.getId(), repaymentDto.history);
            if (loanRefund != null) {
                logger.error("还款数据重复!param:{}", JSON.toJSONString(repaymentDto));
                throw new BusinessException(ExceptionEnum.DUP_REFUND_DATA);
            }
            //保存还款信息
            LoanRepay loanRepay = generateRepaymentInfo(repaymentDto);
            ChainTrans chainTrans = generateChainTrans(String.valueOf(repaymentDto.getId()), OperationTypeEnum.REPAY);
            financeManager.saveRepayInfo(loanRepay, chainTrans, repaymentDto.isHistory());

            LoanCredit bfLoanCredit = loanCreditService.queryLoanCreditById(repaymentDto.getIdSlLoanCreditLog(), repaymentDto.history);
            if (bfLoanCredit == null || bfLoanCredit.getStatus() == CreditStatusEnum.INIT.getCode()) {
                logger.error("没有对应的已上链的借款数据!param:{}", JSON.toJSONString(repaymentDto));
                throw new BusinessException(ExceptionEnum.LOAN_NOT_EXIST);
            }

            BlockChainAccount debtorAccount = getChainAccount(bfLoanCredit.getDebtorUserId());

            //还款上链
            RepayRespDto repay = financialOnChainService.repay(BigInteger.valueOf(loanRepay.getLoanCreditId()), BigInteger.valueOf(loanRepay.getId()), new BigInteger(String.valueOf(loanRepay.getRepayAmount())), new BigInteger(String.valueOf(loanRepay.getRepayPrinciple())), new BigInteger(String.valueOf(loanRepay.getRepayRate())), BigInteger.valueOf(loanRepay.getStatus()), bfLoanCredit.getCreditorUserId(), bfLoanCredit.getDebtorUserId(), debtorAccount.getPrivateKey());
            logger.info("还款上链成功,准备更新trans信息,idSlLoanCreditLog:{},repayId:{},transHash:{}", repaymentDto.getIdSlLoanCreditLog(), repaymentDto.getId(), repay.getTxHash());
            List<ChainTrans> transList = chainTransService.queryByBusinessIdAndType(loanRepay.getId(), OperationTypeEnum.REPAY.getCode());
            if (CollectionUtils.isEmpty(transList)) {
                throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
            }
            chainTrans.setId(transList.get(0).getId());
            financeManager.updateRepayInfo(chainTrans.getId(), repay, OperationTypeEnum.REPAY, loanRepay.getId());
            logger.info("还款数据处理结束");
        } catch (BusinessException e) {
            logger.error("还款失败,param:{}", JSON.toJSONString(repaymentDto), e);
            throw e;
        } catch (Exception e) {
            logger.error("还款失败,param:{}", JSON.toJSONString(repaymentDto), e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    private BlockChainAccount getChainAccount(String userId) {
        BlockChainAccountExample example = new BlockChainAccountExample();
        example.createCriteria().andUserIdOfIPayNowEqualTo(userId);
        List<BlockChainAccount> blockChainAccount = blockChainAccountMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(blockChainAccount)) {
            throw new BusinessException(ExceptionEnum.NO_ACCOUNT_ERROR);
        }
        return blockChainAccount.get(0);
    }

    private void restoreHistoryData(LoanCreditDto loanCreditDto, String assetsIds, List<BigInteger> assetsList, String creditKey, String debtorKey) {
        try {
            //融资申请上链
            String applyHash = financialOnChainService.apply(assetsList, BigInteger.valueOf(loanCreditDto.getId()), loanCreditDto.getUserIdOfIPayNowOfCreditor(), loanCreditDto.getUserIdOfIPayNowOfDebtor(), debtorKey);
            List<ChainTrans> applyList = chainTransService.queryByBusinessIdAndType(loanCreditDto.getId(), OperationTypeEnum.APPLY.getCode());
            financeManager.addOrUpdateTrans(loanCreditDto.getId(), assetsIds, applyList, OperationTypeEnum.APPLY, CreditStatusEnum.APPLY, applyHash);
            //融资受理上链
            String acceptHash = financialOnChainService.accept(BigInteger.valueOf(loanCreditDto.getId()), creditKey);
            List<ChainTrans> acceptList = chainTransService.queryByBusinessIdAndType(loanCreditDto.getId(), OperationTypeEnum.ACCEPT.getCode());
            financeManager.addOrUpdateTrans(loanCreditDto.getId(), assetsIds, acceptList, OperationTypeEnum.ACCEPT, CreditStatusEnum.ACCEPT, acceptHash);

            //放款上链
            String loanHash = financialOnChainService.loan(BigInteger.valueOf(loanCreditDto.getId()), BigInteger.valueOf(Long.parseLong(loanCreditDto.getAccountDelta())), creditKey);
            List<ChainTrans> loanList = chainTransService.queryByBusinessIdAndType(loanCreditDto.getId(), OperationTypeEnum.LOAN.getCode());
            financeManager.addOrUpdateTrans(loanCreditDto.getId(), assetsIds, loanList, OperationTypeEnum.LOAN, CreditStatusEnum.LOAN, loanHash);

        } catch (BusinessException e) {
            logger.error("历史数据上链失败!", e);
            throw e;
        } catch (Exception e) {
            logger.error("历史数据上链以及更新数据库失败", e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }


    private void loanToChain(ChainTrans chainTrans, LoanCredit loanCredit, String assetsIds, List<BigInteger> assetsList, String creditKey, String debtorKey) {
        try {
            //融资申请上链
            String applyHash = financialOnChainService.apply(assetsList, BigInteger.valueOf(loanCredit.getId()), loanCredit.getCreditorUserId(), loanCredit.getDebtorUserId(), debtorKey);
            financeManager.updateApplyInfo(chainTrans, applyHash, CreditStatusEnum.APPLY, loanCredit.getId(), assetsIds);
            //融资受理上链
            String acceptHash = financialOnChainService.accept(BigInteger.valueOf(loanCredit.getId()), creditKey);
            financeManager.updateLoanInfo(chainTrans, acceptHash, OperationTypeEnum.ACCEPT, CreditStatusEnum.ACCEPT, loanCredit.getId());
            //放款上链
            String loanHash = financialOnChainService.loan(BigInteger.valueOf(loanCredit.getId()), loanCredit.getFinancingAmount().toBigInteger(), creditKey);
            financeManager.updateLoanInfo(chainTrans, loanHash, OperationTypeEnum.LOAN, CreditStatusEnum.LOAN, loanCredit.getId());

        } catch (BusinessException e) {
            logger.error("借款数据上链失败!", e);
            throw e;
        } catch (Exception e) {
            logger.error("借款数据上链以及更新数据库失败", e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }

    }


    private LoanCredit generateLoanInfo(LoanCreditDto loanCreditDto) {
        LoanCredit loanCredit = new LoanCredit();
        loanCredit.setId(loanCreditDto.getId());
        loanCredit.setLoanCode(loanCreditDto.getCode());
        loanCredit.setCreditorUserId(loanCreditDto.getUserIdOfIPayNowOfCreditor());
        loanCredit.setDebtorUserId(loanCreditDto.getUserIdOfIPayNowOfDebtor());
        loanCredit.setDebtorName(loanCreditDto.getDebtorName());
        loanCredit.setCreditorName(loanCreditDto.getCreditorName());
        loanCredit.setStatus(CreditStatusEnum.INIT.getCode());
        loanCredit.setFinancingAmount(BigDecimal.valueOf(Long.parseLong(loanCreditDto.getAccountDelta())));
        loanCredit.setFinancingRate(loanCreditDto.getRate());
        loanCredit.setDebtorName(loanCreditDto.getDebtorName());
        loanCredit.setRealLoanTime(loanCreditDto.getRealLoanTime());
        loanCredit.setCreatedTime(new Date());
        loanCredit.setModifiedTime(new Date());
        return loanCredit;
    }

    private LoanRepay generateRepaymentInfo(RepaymentDto repaymentDto) {
        LoanRepay loanRepay = new LoanRepay();
        loanRepay.setId(repaymentDto.getId());
        loanRepay.setLoanCreditId(repaymentDto.getIdSlLoanCreditLog());
        loanRepay.setChainStatus(ChainStatusEnum.CHAIN_DOWN.getCode());
        loanRepay.setRepayAmount(BigDecimal.valueOf(Long.parseLong(repaymentDto.getRefundAmount())));
        loanRepay.setRepayPrinciple(BigDecimal.valueOf(Long.parseLong(repaymentDto.getRefundPrinciple())));
        loanRepay.setRepayRate(new BigDecimal(repaymentDto.getRefundRate()));
        loanRepay.setRepayDate(repaymentDto.getRefundDate());
        loanRepay.setShouldRepayPrinciple(BigDecimal.valueOf(Long.parseLong(repaymentDto.getShouldRefundPrinciple())));
        loanRepay.setShouldRepayRate(BigDecimal.valueOf(MoneyUtil.yuan2cent(repaymentDto.getShouldRefundRate())));
        loanRepay.setStatus(RepayStatusEnum.INIT.getCode());
        loanRepay.setCreatedTime(new Date());
        loanRepay.setModifiedTime(new Date());
        return loanRepay;
    }

    private ChainTrans generateChainTrans(String businessId, OperationTypeEnum operationTypeEnum) {
        ChainTrans chainTrans = new ChainTrans();
        chainTrans.setBuinessId(businessId);
        chainTrans.setChainId(ChainEnum.IPAYNOW.getCode());
        chainTrans.setOperationType(operationTypeEnum.getCode());
        chainTrans.setChainStatus(ChainStatusEnum.CHAIN_DOWN.getCode());
        chainTrans.setCreatedTime(new Date());
        chainTrans.setModifiedTime(new Date());
        return chainTrans;
    }

}