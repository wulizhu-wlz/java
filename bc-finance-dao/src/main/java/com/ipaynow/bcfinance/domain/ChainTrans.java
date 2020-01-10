package com.ipaynow.bcfinance.domain;

import java.util.Date;

public class ChainTrans {

    public ChainTrans() {
    }

    public ChainTrans(String buinessId, Byte chainId, String transHash, Byte operationType, Byte chainStatus, Date createdTime) {
        this.buinessId = buinessId;
        this.chainId = chainId;
        this.transHash = transHash;
        this.operationType = operationType;
        this.chainStatus = chainStatus;
        this.createdTime = createdTime;
    }
    private Long id;

    private String buinessId;

    private Byte chainId;

    private String transHash;

    private Byte operationType;

    private Byte chainStatus;

    private Date createdTime;

    private Date modifiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuinessId() {
        return buinessId;
    }

    public void setBuinessId(String buinessId) {
        this.buinessId = buinessId;
    }

    public Byte getChainId() {
        return chainId;
    }

    public void setChainId(Byte chainId) {
        this.chainId = chainId;
    }

    public String getTransHash() {
        return transHash;
    }

    public void setTransHash(String transHash) {
        this.transHash = transHash;
    }

    public Byte getOperationType() {
        return operationType;
    }

    public void setOperationType(Byte operationType) {
        this.operationType = operationType;
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
}