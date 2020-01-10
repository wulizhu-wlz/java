package com.ipaynow.bcfinance.dto;

import lombok.Data;

@Data
public class JoinMerchantDtoForPage {
    private int idOfTbMerchantUser;

    private String userIdOfIPayNow;

    private String mchName;

    private Integer creditId;

    private Integer numberOfCredit;

    private Integer numberOfDebt;

    private Long creditAmount;

    private Long debtAmount;


    private Long refundAmount;

    private Byte loanChannel;

    private String accountAddress;
}
