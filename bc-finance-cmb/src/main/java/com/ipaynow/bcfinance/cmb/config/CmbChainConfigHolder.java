package com.ipaynow.bcfinance.cmb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ytw
 * @date 2019/7/9
 * description:招行链配置信息
 */
@Component
@ConfigurationProperties(prefix = "cmb.bc")
public class CmbChainConfigHolder {

    private String ip;

    private String ipaynowPrivateKey;

    private String ipaynowAddress;

    public Contract contract;

    public Long chainId;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpaynowPrivateKey() {
        return ipaynowPrivateKey;
    }

    public void setIpaynowPrivateKey(String ipaynowPrivateKey) {
        this.ipaynowPrivateKey = ipaynowPrivateKey;
    }

    public String getIpaynowAddress() {
        return ipaynowAddress;
    }

    public void setIpaynowAddress(String ipaynowAddress) {
        this.ipaynowAddress = ipaynowAddress;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public static class Contract {

        /**
         * Merchant合约地址
         */
        private String merchantAddress;

        /**
         * Financial合约地址
         */
        private String financialAddress;

        public String getFinancialAddress() {
            return financialAddress;
        }

        public void setFinancialAddress(String financialAddress) {
            this.financialAddress = financialAddress;
        }

        public String getMerchantAddress() {
            return merchantAddress;
        }

        public void setMerchantAddress(String merchantAddress) {
            this.merchantAddress = merchantAddress;
        }
    }
}
