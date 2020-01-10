package com.ipaynow.bcfinance.domain;

import java.math.BigDecimal;
import java.util.Date;

public class LoanRepay {
    private Long id;

    private Long loanCreditId;

    private BigDecimal repayAmount;

    private BigDecimal repayPrinciple;

    private BigDecimal repayRate;

    private String repayDate;

    private Byte chainStatus;

    private BigDecimal shouldRepayPrinciple;

    private BigDecimal shouldRepayRate;

    private String repayRecordAddress;

    private Byte status;

    private String extend;

    private Date createdTime;

    private Date modifiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoanCreditId() {
        return loanCreditId;
    }

    public void setLoanCreditId(Long loanCreditId) {
        this.loanCreditId = loanCreditId;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public BigDecimal getRepayPrinciple() {
        return repayPrinciple;
    }

    public void setRepayPrinciple(BigDecimal repayPrinciple) {
        this.repayPrinciple = repayPrinciple;
    }

    public BigDecimal getRepayRate() {
        return repayRate;
    }

    public void setRepayRate(BigDecimal repayRate) {
        this.repayRate = repayRate;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public Byte getChainStatus() {
        return chainStatus;
    }

    public void setChainStatus(Byte chainStatus) {
        this.chainStatus = chainStatus;
    }

    public BigDecimal getShouldRepayPrinciple() {
        return shouldRepayPrinciple;
    }

    public void setShouldRepayPrinciple(BigDecimal shouldRepayPrinciple) {
        this.shouldRepayPrinciple = shouldRepayPrinciple;
    }

    public BigDecimal getShouldRepayRate() {
        return shouldRepayRate;
    }

    public void setShouldRepayRate(BigDecimal shouldRepayRate) {
        this.shouldRepayRate = shouldRepayRate;
    }

    public String getRepayRecordAddress() {
        return repayRecordAddress;
    }

    public void setRepayRecordAddress(String repayRecordAddress) {
        this.repayRecordAddress = repayRecordAddress;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
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