package com.ipaynow.bcfinance.domain;

import java.util.Date;

public class MerchantPlatformBusiness {
    private Long id;

    private Integer idOfTbMerchantUser;

    private String userIdOfIPayNow;

    private String platformName;

    private String stockAmount;

    private String soldForSettlementAmount;

    private String settledForPaymentAmount;

    private String stockTurnOverRatio;

    private String returnRate;

    private String statisticalDate;

    private String transHash;

    private String assetAddress;

    private Byte chainStatus;

    private Date createdTime;

    private Date modifiedTime;

    private String  statisticalBeginDate;

    private String  statisticalEndDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(String stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getSoldForSettlementAmount() {
        return soldForSettlementAmount;
    }

    public void setSoldForSettlementAmount(String soldForSettlementAmount) {
        this.soldForSettlementAmount = soldForSettlementAmount;
    }

    public String getSettledForPaymentAmount() {
        return settledForPaymentAmount;
    }

    public void setSettledForPaymentAmount(String settledForPaymentAmount) {
        this.settledForPaymentAmount = settledForPaymentAmount;
    }

    public String getStockTurnOverRatio() {
        return stockTurnOverRatio;
    }

    public void setStockTurnOverRatio(String stockTurnOverRatio) {
        this.stockTurnOverRatio = stockTurnOverRatio;
    }

    public String getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(String returnRate) {
        this.returnRate = returnRate;
    }

    public String getStatisticalDate() {
        return statisticalDate;
    }

    public void setStatisticalDate(String statisticalDate) {
        this.statisticalDate = statisticalDate;
    }

    public String getTransHash() {
        return transHash;
    }

    public void setTransHash(String transHash) {
        this.transHash = transHash;
    }

    public String getAssetAddress() {
        return assetAddress;
    }

    public void setAssetAddress(String assetAddress) {
        this.assetAddress = assetAddress;
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


    public String getStatisticalBeginDate() {
        return statisticalBeginDate;
    }

    public void setStatisticalBeginDate(String statisticalBeginDate) {
        this.statisticalBeginDate = statisticalBeginDate;
    }

    public String getStatisticalEndDate() {
        return statisticalEndDate;
    }

    public void setStatisticalEndDate(String statisticalEndDate) {
        this.statisticalEndDate = statisticalEndDate;
    }
}