package com.ipaynow.bcfinance.domain;

import java.math.BigDecimal;
import java.util.Date;

public class LoanCredit {
    private Long id;

    private String loanCode;

    private String creditorUserId;

    private String debtorUserId;

    private String creditorName;

    private String debtorName;

    private BigDecimal financingAmount;

    private String financingRate;

    private String realLoanTime;

    private String extend;

    private Byte status;

    private String assetId;

    private Date createdTime;

    private Date modifiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    public String getCreditorUserId() {
        return creditorUserId;
    }

    public void setCreditorUserId(String creditorUserId) {
        this.creditorUserId = creditorUserId;
    }

    public String getDebtorUserId() {
        return debtorUserId;
    }

    public void setDebtorUserId(String debtorUserId) {
        this.debtorUserId = debtorUserId;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public BigDecimal getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(BigDecimal financingAmount) {
        this.financingAmount = financingAmount;
    }

    public String getFinancingRate() {
        return financingRate;
    }

    public void setFinancingRate(String financingRate) {
        this.financingRate = financingRate;
    }

    public String getRealLoanTime() {
        return realLoanTime;
    }

    public void setRealLoanTime(String realLoanTime) {
        this.realLoanTime = realLoanTime;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
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
}