package com.ipaynow.bcfinance.chain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ytw
 * @date 2019/6/24
 * description:
 */
@Component
@ConfigurationProperties(prefix = "bc")
public class BlockChainConfigHolder {

    private String ip;

    private String ipaynowPrivateKey;

    private String ipaynowAddress;

    public String getIpaynowAddress() {
        return ipaynowAddress;
    }

    public void setIpaynowAddress(String ipaynowAddress) {
        this.ipaynowAddress = ipaynowAddress;
    }

    public String getIpaynowPrivateKey() {
        return ipaynowPrivateKey;
    }

    public void setIpaynowPrivateKey(String ipaynowPrivateKey) {
        this.ipaynowPrivateKey = ipaynowPrivateKey;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


}
