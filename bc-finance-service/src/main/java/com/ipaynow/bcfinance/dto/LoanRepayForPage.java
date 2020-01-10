package com.ipaynow.bcfinance.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class LoanRepayForPage {
    private String refundAmount;

    private String refundDate;

    private String refundPrinciple;

    private String refundPrincipleNotPayback;

    private String refundRate;

    private String refundRateNotPayback;

    private String shouldRefundPrinciple;

    private String shouldRefundRate;

    private String transHash;
}