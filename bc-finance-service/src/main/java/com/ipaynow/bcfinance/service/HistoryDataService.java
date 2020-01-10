package com.ipaynow.bcfinance.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ipaynow.bcfinance.dao.BlockChainAccountMapper;
import com.ipaynow.bcfinance.dao.LoanRepayMapper;
import com.ipaynow.bcfinance.dao.LoanRefundMapper;
import com.ipaynow.bcfinance.domain.*;
import com.ipaynow.bcfinance.dto.LoanCreditDto;
import com.ipaynow.bcfinance.dto.RepaymentDto;
import com.ipaynow.bcfinance.enums.ChainStatusEnum;
import com.ipaynow.bcfinance.enums.RepayStatusEnum;
import com.ipaynow.bcfinance.service.impl.JoinFinancialServiceImpl;
import com.ipaynow.bcfinance.thread.RunnableWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author ytw
 * @date 2019/6/19
 * description:
 */
@Service
public class HistoryDataService {

    private static Logger logger = LogManager.getLogger(JoinFinancialServiceImpl.class);

    @Resource
    private LoanCreditService loanCreditService;

    @Resource
    private RepaymentService repaymentService;

    @Resource
    private JoinFinancialService financialService;

    @Resource
    private LoanRefundMapper loanRefundMapper;

    @Resource
    private LoanRepayMapper loanRepayMapper;
    @Resource(name = "commonThreadPool")
    private ExecutorService executorService;
    @Resource
    private BlockChainAccountMapper blockChainAccountMapper;


    public void restoreLoanData(Date startTime, Date endTime) {
        List<LoanCredit> loanCreditList = loanCreditService.queryByDate(startTime, endTime);
        logger.info("恢复融资历史数据开始,待处理的条数为:{}", loanCreditList.size());
        restoreLoan(loanCreditList);
    }

    public void restoreLoan(List<LoanCredit> loanCreditList) {
        for (LoanCredit loanCredit : loanCreditList) {
            executorService.submit(RunnableWrapper.wrap(() -> {
                LoanCreditDto loanCreditDto = new LoanCreditDto();
                try {
                    loanCreditDto.setId(loanCredit.getId());
                    loanCreditDto.setCode(loanCredit.getLoanCode());
                    loanCreditDto.setType(Long.valueOf(loanCredit.getStatus().toString()));
                    loanCreditDto.setHistory(true);
                    loanCreditDto.setRate(loanCredit.getFinancingRate());
                    loanCreditDto.setCreditorName(loanCredit.getCreditorName());
                    loanCreditDto.setDebtorName(loanCredit.getDebtorName());
                    loanCreditDto.setUserIdOfIPayNowOfCreditor(loanCredit.getCreditorUserId());
                    loanCreditDto.setUserIdOfIPayNowOfDebtor(loanCredit.getDebtorUserId());
                    loanCreditDto.setAccountDelta(String.valueOf(loanCredit.getFinancingAmount().longValue()));
                    loanCreditDto.setRealLoanTime(loanCredit.getRealLoanTime());
                    financialService.processLoan(loanCreditDto);
                } catch (Exception e) {
                    logger.error("恢复借款历史数据异常, loanCreditDto={}", loanCreditDto, e);
                }
            }));
        }
    }

    public void restoreRepaymentData(Date startTime, Date endTime) {
        List<LoanRepay> repaymentList = repaymentService.queryByDate(startTime, endTime);
        logger.info("恢复还款历史数据开始,待处理的条数为:{}", repaymentList.size());
        restoreRepay(repaymentList);

    }

    public void restoreRepay(List<LoanRepay> repaymentList) {
        for (LoanRepay repayment : repaymentList) {
            executorService.submit(RunnableWrapper.wrap(() -> {
                RepaymentDto repaymentDto = new RepaymentDto();
                try {
                    repaymentDto.setId(repayment.getId());
                    repaymentDto.setIdSlLoanCreditLog(repayment.getLoanCreditId());
                    repaymentDto.setRefundDate(repayment.getRepayDate());
                    repaymentDto.setRefundAmount(repayment.getRepayAmount().toPlainString());
                    repaymentDto.setRefundRate(repayment.getRepayRate().toPlainString());
                    repaymentDto.setShouldRefundPrinciple(repayment.getShouldRepayPrinciple().toPlainString());
                    repaymentDto.setShouldRefundRate(repayment.getShouldRepayRate().toPlainString());
                    repaymentDto.setHistory(true);
                    repaymentDto.setRefundPrinciple(String.valueOf(repayment.getRepayPrinciple().longValue()));
                    financialService.processRepayment(repaymentDto);
                } catch (Exception e) {
                    logger.error("恢复融资数据异常!loanId:{}", repayment.getId(), e);
                }
            }));

        }
    }

    public void restoreRepayData() {
        List<LoanRefund> loanRefunds = loanRefundMapper.selectByExample(new LoanRefundExample());
        logger.info("恢复数据库loan_refunds数据开始,待处理的条数为:{}", loanRefunds.size());
        for (LoanRefund refund : loanRefunds) {
            executorService.submit(() -> {
                try {
                    JSONObject extend = JSON.parseObject(refund.getExtend());
                    LoanRepay loanRepay = new LoanRepay();
                    loanRepay.setId(Long.valueOf(refund.getId()));
                    loanRepay.setShouldRepayPrinciple(BigDecimal.valueOf(Long.parseLong(extend.get("shouldRefundRate").toString())));
                    loanRepay.setShouldRepayRate(BigDecimal.valueOf(Long.parseLong(extend.get("shouldRefundPrinciple").toString())));
                    loanRepay.setChainStatus(ChainStatusEnum.CHAIN_DOWN.getCode());
                    loanRepay.setStatus(RepayStatusEnum.DONE.getCode());
                    loanRepayMapper.updateByPrimaryKeySelective(loanRepay);
                    logger.info("恢复数据,当前数据id为:refundId:{}", refund.getId());
                } catch (Exception e) {
                    logger.error("恢复数据库数据失败,refundId:{}", refund.getId(), e);
                }
            });

        }
    }
}
