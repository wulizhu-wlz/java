package com.ipaynow.bcfinance.domain;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class LoanCreditSum {

    private BigDecimal LoanAmountSummary;

    private int LoanNumSummary;

}
