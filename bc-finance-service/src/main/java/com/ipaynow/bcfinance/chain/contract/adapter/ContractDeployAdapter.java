package com.ipaynow.bcfinance.chain.contract.adapter;

import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.thread.DeploySynchronizer;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ytw
 * @date 2019/6/26
 * description: 合约部署适配器，用来适配合约的部署逻辑
 */
public interface ContractDeployAdapter {

    /**
     * 获取合约名
     *
     * @return 合约名
     */
    String contractName();

    /**
     * 获取合约类
     *
     * @return 合约类
     * */
    Class contractClass();

    /**
     * 部署合约
     *
     * @param blockChainConfigHolder 配置信息
     * @return 合约地址
     */
    String deploy(BlockChainConfigHolder blockChainConfigHolder, DeploySynchronizer deploySynchronizer);

}
