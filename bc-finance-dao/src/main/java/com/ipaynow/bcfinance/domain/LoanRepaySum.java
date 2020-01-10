package com.ipaynow.bcfinance.domain;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class LoanRepaySum {

    private BigDecimal repayAmountSummary;

    private int repayNumSummary;

}
