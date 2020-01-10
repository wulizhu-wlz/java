package com.ipaynow.bcfinance.cmb.service;

import com.alibaba.fastjson.JSON;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.ipaynow.bcfinance.cmb.contract.helper.FinancialHelper;
import com.ipaynow.bcfinance.cmb.manager.ChainTransManager;
import com.ipaynow.bcfinance.dao.LoanCreditMapper;
import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.LoanCredit;
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
public class LoanCreditService {

    private final Logger logger = LoggerFactory.getLogger(LoanCreditService.class);

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;
    @Resource
    private LoanCreditMapper loanCreditMapper;
    @Resource
    private ChainTransService chainTransService;
    @Resource
    ChainTransManager chainTransManager;
    @Resource
    private FinancialHelper financialHelper;
    @Resource
    private BlockChainAccountService blockChainAccountService;

    public void loanCreditTask(Date startTime, Date endTime) {
        //查询已经发送到ipaynow链，还没发送到招行链的融资申请数据
        List<LoanCredit> loanCredits = loanCreditMapper.selectCmbList(startTime, endTime);
        logger.info("本次发送招行链的融资申请记录count={}", loanCredits.size());
        for (LoanCredit loanCredit : loanCredits) {
            threadPoolExecutor.submit(RunnableWrapper.wrap(() -> {
                loanCredit(loanCredit);
            }));
        }
    }

    /**
     * 将融资数据发送到招行链
     * 通过合约接口的幂等性和数据库事务，过程中任何一个操作失败都将在下次重试
     * @param loanCredit
     */
    private void loanCredit(LoanCredit loanCredit) {
        //融资申请
        ChainTrans chainTransApply = applyFinancing(loanCredit);
        //受理
        ChainTrans chainTransAccept = acceptFinance(loanCredit);
        //放款
        ChainTrans chainTransLoan = loan(loanCredit);
        logger.info("融资信息发送financial合约成功，保存交易信息到数据库, loanId={}", loanCredit.getId());
        //保存交易信息
        chainTransManager.save(chainTransApply, chainTransAccept, chainTransLoan);
    }

    private ChainTrans applyFinancing(LoanCredit loanCredit) {
        //查询出ipaynow链的交易信息
        ChainTrans chainTransIpaynow = chainTransService.queryOne(loanCredit.getId().toString(), OperationTypeEnum.APPLY, ChainEnum.IPAYNOW, ChainStatusEnum.CHAIN_UP);
        if (chainTransIpaynow == null) {
            logger.error("发送融资申请数据到招行链失败，没有找到ipaynow链的交易信息, loanCredit={}", JSON.toJSONString(loanCredit));
            throw new BusinessException(ExceptionEnum.CMB_NOT_FOUND_IPAYNOW_TRANS);
        }
        //查询商户区块链账户信息
        BlockChainAccount blockChainAccountM = blockChainAccountService.queryOne(loanCredit.getDebtorUserId(), AccountTypeEnum.MERCHANT);
        if (blockChainAccountM == null) {
            logger.error("发送融资申请数据到招行链失败, 商户区块链账户信息不存在, loanCredit={}", JSON.toJSONString(loanCredit));
            throw new BusinessException(ExceptionEnum.BLOCK_CHAIN_ACCOUNT_M_NOT_FOUND);
        }
        //查询平台区块链账户信息
        BlockChainAccount blockChainAccountP = blockChainAccountService.queryOne(loanCredit.getCreditorUserId(), AccountTypeEnum.PLANTFORM);
        if (blockChainAccountP == null) {
            logger.error("发送融资申请数据到招行链失败, 平台区块链账户信息不存在");
            throw new BusinessException(ExceptionEnum.BLOCK_CHAIN_ACCOUNT_P_NOT_FOUND);
        }
        //发送融资申请到招行链
        TransactionReceipt transactionReceipt = financialHelper.applyFinancing(loanCredit.getId().toString(), blockChainAccountP.getAccAddress(), blockChainAccountM.getAccAddress(), chainTransIpaynow.getTransHash());
        //生成招行链交易信息
        return new ChainTrans(loanCredit.getId().toString(), ChainEnum.CMB.getCode(), transactionReceipt.getTransactionHash(), OperationTypeEnum.APPLY.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
    }

    private ChainTrans acceptFinance(LoanCredit loanCredit) {
        //查询出ipaynow链的交易信息
        ChainTrans chainTransIpaynow = chainTransService.queryOne(loanCredit.getId().toString(), OperationTypeEnum.ACCEPT, ChainEnum.IPAYNOW, ChainStatusEnum.CHAIN_UP);
        if (chainTransIpaynow == null) {
            logger.error("发送融资受理数据到招行链失败，没有找到ipaynow链的交易信息, loanCredit={}", JSON.toJSONString(loanCredit));
            throw new BusinessException(ExceptionEnum.CMB_NOT_FOUND_IPAYNOW_TRANS);
        }
        //发送融资受理到招行链
        TransactionReceipt transactionReceipt = financialHelper.acceptFinance(loanCredit.getId().toString(), chainTransIpaynow.getTransHash());
        //生成招行链交易信息
        return new ChainTrans(loanCredit.getId().toString(), ChainEnum.CMB.getCode(), transactionReceipt.getTransactionHash(), OperationTypeEnum.ACCEPT.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
    }

    private ChainTrans loan(LoanCredit loanCredit) {
        //查询出ipaynow链的交易信息
        ChainTrans chainTransIpaynow = chainTransService.queryOne(loanCredit.getId().toString(), OperationTypeEnum.LOAN, ChainEnum.IPAYNOW, ChainStatusEnum.CHAIN_UP);
        if (chainTransIpaynow == null) {
            logger.error("发送融资放款数据到招行链失败，没有找到ipaynow链的交易信息, loanCredit={}", JSON.toJSONString(loanCredit));
            throw new BusinessException(ExceptionEnum.CMB_NOT_FOUND_IPAYNOW_TRANS);
        }
        //发送融资受理到招行链
        TransactionReceipt transactionReceipt = financialHelper.loan(loanCredit.getId().toString(), chainTransIpaynow.getTransHash());
        //生成招行链交易信息
        return new ChainTrans(loanCredit.getId().toString(), ChainEnum.CMB.getCode(), transactionReceipt.getTransactionHash(), OperationTypeEnum.LOAN.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
    }

    public LoanCredit queryById(Long id){
        return loanCreditMapper.selectByPrimaryKey(id);
    }

}
