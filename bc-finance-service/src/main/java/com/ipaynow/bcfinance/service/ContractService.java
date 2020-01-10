package com.ipaynow.bcfinance.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author ytw
 * @date 2019/6/27
 * description: 合约地址service
 */
public interface ContractService {

    /**
     * 根据合约名获取合约地址
     * @param contractName 合约名
     * @return 合约地址
     */
    String queryContractAddress(String contractName);

    @Transactional
    void update(String contractName, String contractAddress);
}
