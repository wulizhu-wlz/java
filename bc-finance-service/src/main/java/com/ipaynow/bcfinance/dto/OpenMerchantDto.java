package com.ipaynow.bcfinance.dto;

import javax.validation.constraints.NotEmpty;

/**
 * Created by hai on 2019/6/28.
 */
public class OpenMerchantDto {
    /**
     * 放款方支付商户号
     * */
    @NotEmpty
    public String userIdOfIPayNowOfCreditor;

    /**
     * 贷款方支付商户号
     * */
    @NotEmpty
    public String userIdOfIPayNowOfDebtor;


    /**
     * 放款方名称
     */
    @NotEmpty
    public String creditorName;


    public String getUserIdOfIPayNowOfCreditor() {
        return userIdOfIPayNowOfCreditor;
    }

    public void setUserIdOfIPayNowOfCreditor(String userIdOfIPayNowOfCreditor) {
        this.userIdOfIPayNowOfCreditor = userIdOfIPayNowOfCreditor;
    }

    public String getUserIdOfIPayNowOfDebtor() {
        return userIdOfIPayNowOfDebtor;
    }

    public void setUserIdOfIPayNowOfDebtor(String userIdOfIPayNowOfDebtor) {
        this.userIdOfIPayNowOfDebtor = userIdOfIPayNowOfDebtor;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }
}
