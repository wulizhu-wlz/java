package com.ipaynow.bcfinance.service;

import com.github.pagehelper.PageInfo;
import com.ipaynow.bcfinance.domain.LoanCredit;
import com.ipaynow.bcfinance.domain.LoanRepay;
import com.ipaynow.bcfinance.domain.LoanRepaySum;
import com.ipaynow.bcfinance.expcetion.BusinessException;

import java.util.Date;
import java.util.List;

/**
 * @author ytw
 * @date 2019/6/19
 * description:
 */
public interface RepaymentService {

    public LoanRepay queryRepayById(Long repaymentId,boolean isHistory);

    public void saveRepaymentInfo(LoanRepay loanRefund);

    public List<LoanRepay> queryByDate(Date startTime, Date endTime);

    public List<LoanRepay> queryInit() throws BusinessException;

    public PageInfo<LoanRepay> getRepayedLoanCredit(int currentPage, int pageSize, int idSlLoanCreditLog) throws BusinessException;


    public long getRepayedLoanCreditCount(int idSlLoanCreditLog) throws  BusinessException;

    public LoanRepaySum getSum(String debtorUserId) throws  BusinessException;

}
