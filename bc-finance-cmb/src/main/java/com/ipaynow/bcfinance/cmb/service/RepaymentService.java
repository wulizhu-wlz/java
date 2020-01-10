package com.ipaynow.bcfinance.cmb.service;

import com.alibaba.fastjson.JSON;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.ipaynow.bcfinance.cmb.contract.helper.FinancialHelper;
import com.ipaynow.bcfinance.dao.LoanRepayMapper;
import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.LoanCredit;
import com.ipaynow.bcfinance.domain.LoanRepay;
import com.ipaynow.bcfinance.enums.*;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.thread.RunnableWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ytw
 * @date 2019/7/10
 * description:
 */
@Service
public class RepaymentService {

    private final Logger logger = LoggerFactory.getLogger(RepaymentService.class);

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;
    @Resource
    private LoanRepayMapper loanRepayMapper;
    @Resource
    private ChainTransService chainTransService;
    @Resource
    FinancialHelper financialHelper;
    @Resource
    private LoanCreditService loanCreditService;
    @Resource
    private BlockChainAccountService blockChainAccountService;

    public void repayTask(Date startTime, Date endTime) {
        List<LoanRepay> loanRepays = loanRepayMapper.selectSendCmbList(startTime, endTime);
        logger.info("发送还款数据到招行链，count={}, startTime={}, endTime={}", loanRepays.size(), startTime, endTime);
        for (LoanRepay loanRepay : loanRepays) {
            threadPoolExecutor.submit(RunnableWrapper.wrap(() -> {
                repay(loanRepay);
            }));
        }
    }

    public void repay(LoanRepay loanRepay) {
        //查找还款信息ipaynow链交易记录
        ChainTrans chainTransIpaynow = chainTransService.queryOne(loanRepay.getId().toString(), OperationTypeEnum.REPAY, ChainEnum.IPAYNOW, ChainStatusEnum.CHAIN_UP);
        if (chainTransIpaynow == null) {
            logger.error("还款数据发送招行链失败, 没有找到ipaynow链交易信息 loanRepay={}", JSON.toJSONString(loanRepay));
            return;
        }
        LoanCredit loanCredit = loanCreditService.queryById(loanRepay.getLoanCreditId());
        if (loanCredit == null) {
            logger.error("还款数据发送招行链失败, 没有找到放款信息, loanRepay={}", JSON.toJSONString(loanRepay));
            return;
        }
        //查询商户区块链账户信息
        BlockChainAccount blockChainAccountM = blockChainAccountService.queryOne(loanCredit.getDebtorUserId(), AccountTypeEnum.MERCHANT);
        if (blockChainAccountM == null) {
            logger.error("发送还款数据到招行链失败, 商户区块链账户信息不存在");
            throw new BusinessException(ExceptionEnum.BLOCK_CHAIN_ACCOUNT_M_NOT_FOUND);
        }
        //查询平台区块链账户信息
        BlockChainAccount blockChainAccountP = blockChainAccountService.queryOne(loanCredit.getCreditorUserId(), AccountTypeEnum.PLANTFORM);
        if (blockChainAccountP == null) {
            logger.error("发送还款数据到招行链失败, 平台区块链账户信息不存在");
            throw new BusinessException(ExceptionEnum.BLOCK_CHAIN_ACCOUNT_P_NOT_FOUND);
        }
        TransactionReceipt transactionReceipt = financialHelper.repay(loanRepay.getId().toString(), loanCredit.getId().toString(), blockChainAccountP.getAccAddress(), blockChainAccountM.getAccAddress(), chainTransIpaynow.getTransHash());
        //生成并保存交易信息
        ChainTrans chainTrans = new ChainTrans(loanRepay.getId().toString(), ChainEnum.CMB.getCode(), transactionReceipt.getTransactionHash(), OperationTypeEnum.REPAY.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
        chainTransService.insert(chainTrans);
    }
}
