package com.ipaynow.bcfinance.dto;

/**
 * Created by hai on 2019/6/28.
 */
public class AccountRespDto {
    private String txHash;
    private String accountAddr;

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getAccountAddr() {
        return accountAddr;
    }

    public void setAccountAddr(String accountAddr) {
        this.accountAddr = accountAddr;
    }

    @Override
    public String toString() {
        return "AccountRespDto{" +
                "txHash='" + txHash + '\'' +
                ", accountAddr='" + accountAddr + '\'' +
                '}';
    }
}
