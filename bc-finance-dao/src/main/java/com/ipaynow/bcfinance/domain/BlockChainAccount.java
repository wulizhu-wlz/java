package com.ipaynow.bcfinance.domain;

import java.util.Date;

public class BlockChainAccount {
    private Integer id;

    private Integer idOfTbMerchantUser;

    private String userIdOfIPayNow;

    private String privateKey;

    private String publicKey;

    private String address;

    private String accAddress;

    private Byte accountType;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccAddress() {
        return accAddress;
    }

    public void setAccAddress(String accAddress) {
        this.accAddress = accAddress;
    }

    public Byte getAccountType() {
        return accountType;
    }

    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}