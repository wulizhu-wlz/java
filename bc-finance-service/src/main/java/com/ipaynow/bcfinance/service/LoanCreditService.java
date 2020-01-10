package com.ipaynow.bcfinance.service;


import com.github.pagehelper.PageInfo;
import com.ipaynow.bcfinance.domain.LoanCredit;
import com.ipaynow.bcfinance.domain.LoanCreditExample;
import com.ipaynow.bcfinance.domain.LoanCreditSum;
import com.ipaynow.bcfinance.expcetion.BusinessException;

import java.util.Date;
import java.util.List;

/**
 * @author ytw
 * @date 2019/6/19
 * description:
 */
public interface LoanCreditService {

    public LoanCredit queryLoanCreditById(Long loanId, boolean isHistory);

    public void saveLoanInfo(LoanCredit loanCredit);

    public List<LoanCredit> queryByDate(Date startTime, Date endTime) throws BusinessException;

    List<LoanCredit> queryList(LoanCreditExample example);

    public List<LoanCredit> queryByMhtAndPlat(String merchantId, String platformId);

    public void updateById(LoanCredit loanCredit);

    public List<LoanCredit> queryInit() throws BusinessException;

    public PageInfo<LoanCredit> getLoanCreditByPage(
            int currentPage, int pageSize, String code, String realLoanStartTime, String realLoanEndTime,
            String userIdOfIPayNowOfCreditor, String userIdOfIPayNowOfDebtor,
            String creditorName, String debtorName
    ) throws BusinessException;

    public int getLoanCredit(String code, String realLoanStartTime, String realLoanEndTime,
                                   String userIdOfIPayNowOfCreditor, String userIdOfIPayNowOfDebtor,
                                   String creditorName, String debtorName);

    public List<LoanCredit> queryLoanCreditList(String merchantId, String platformId,Date realLoanTimeFrom, Date realLoanTimeTo);

    LoanCreditSum getSum(String merchantId, String realLoanTimeFrom, String realLoanTimeTo);

}
