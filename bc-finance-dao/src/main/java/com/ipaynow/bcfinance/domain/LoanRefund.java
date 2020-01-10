package com.ipaynow.bcfinance.domain;

import java.util.Date;

public class LoanRefund {
    private Integer id;

    private Integer idSlLoanCreditLog;

    private String refundAmount;

    private String refundPrinciple;

    private String refundRate;

    private String refundDate;

    private String extend;

    private Byte repayStatus;

    private Date createdTime;

    private Date modifiedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSlLoanCreditLog() {
        return idSlLoanCreditLog;
    }

    public void setIdSlLoanCreditLog(Integer idSlLoanCreditLog) {
        this.idSlLoanCreditLog = idSlLoanCreditLog;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundPrinciple() {
        return refundPrinciple;
    }

    public void setRefundPrinciple(String refundPrinciple) {
        this.refundPrinciple = refundPrinciple;
    }

    public String getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(String refundRate) {
        this.refundRate = refundRate;
    }

    public String getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(String refundDate) {
        this.refundDate = refundDate;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public Byte getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(Byte repayStatus) {
        this.repayStatus = repayStatus;
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