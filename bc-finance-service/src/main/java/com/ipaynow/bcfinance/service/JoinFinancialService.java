package com.ipaynow.bcfinance.service;

import com.ipaynow.bcfinance.dto.LoanCreditDto;
import com.ipaynow.bcfinance.dto.RepaymentDto;

/**
 * @author ytw
 * @date 2019/6/19
 * description:
 */
public interface JoinFinancialService {

    /**
     * 处理融资业务
     *
     * @param loanCreditDto
     */
    public void processLoan(LoanCreditDto loanCreditDto);

    /**
     * 处理融资还款
     *
     * @param repaymentDto
     */
    public void processRepayment(RepaymentDto repaymentDto);
}
