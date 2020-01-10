package com.ipaynow.bcfinance.domain;

import java.util.Date;

public class JoinMerchant {
    private Integer idOfTbMerchantUser;

    private String userIdOfIPayNow;

    private String mchName;

    private String platformIdOfIPayNow;

    private Byte status;

    private Byte chainStatus;

    private Date createdTime;

    private Date modifiedTime;

    private String accountAddress  ;

    public Integer getIdOfTbMerchantUser() {
        return idOfTbMerchantUser;
    }

    public void setIdOfTbMerchantUser(Integer idOfTbMerchantUser) {
        this.idOfTbMerchantUser = idOfTbMerchantUser;
    }

    public String getUserIdOfIPayNow() {
        return userIdOfIPayNow;
    }

    public void setUserIdOfIPayNow(String userIdOfIPayNow) {
        this.userIdOfIPayNow = userIdOfIPayNow;
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName;
    }

    public String getPlatformIdOfIPayNow() {
        return platformIdOfIPayNow;
    }

    public void setPlatformIdOfIPayNow(String platformIdOfIPayNow) {
        this.platformIdOfIPayNow = platformIdOfIPayNow;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getChainStatus() {
        return chainStatus;
    }

    public void setChainStatus(Byte chainStatus) {
        this.chainStatus = chainStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }
}