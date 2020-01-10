package com.ipaynow.bcfinance.dto;

import lombok.Data;

/**
 * Created by ipaynow0407 on 2017/10/16.
 */
@Data
public class LoanCreditDtoForPage {
    private Integer id;

    private String code;

    private String userIdOfIPayNowOfCreditor;

    private String userIdOfIPayNowOfDebtor;

    private String creditorName;

    private String debtorName;

    private String accountDelta;

    private String rate;

    private String realLoanTime;

    private String transHash;



}
