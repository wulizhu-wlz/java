package com.ipaynow.bcfinance.chain.contract;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.chain.contract.adapter.ContractDeployAdapter;
import com.ipaynow.bcfinance.expcetion.ValidationException;
import com.ipaynow.bcfinance.service.ContractService;
import com.ipaynow.bcfinance.thread.DeploySynchronizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

/**
 * @author ytw
 * @date 2019/6/26
 * description: 合约部署器
 */
@Slf4j
@Component
public class AutoContractDeployer implements ApplicationListener<ContextRefreshedEvent> {

    public static Object OK = new Object();

    /**
     * 启动参数
     */
    @Value("${contract:}")//默认值为空
    private String args;
    @Autowired
    private ContractService contractService;
    @Autowired
    private BlockChainConfigHolder blockChainConfigHolder;
    @Autowired
    private ExecutorService executorService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("contract参数={}", args);
        if (StringUtils.isEmpty(args)) {
            return;
            //throw new IllegalArgumentException("contract参数未指定. -Dcontract=参数, NONE:不需要部署合约 合约名:需要部署的合约类名(多个合约用逗号分隔) all:部署所有合约");
        }
        if ("NONE".equalsIgnoreCase(args)) {
            return;
        }
        ApplicationContext applicationContext = event.getApplicationContext();
        //部署所有合约
        if ("all".equalsIgnoreCase(args.trim())) {
            deployAll(applicationContext);
        } else {
            deployNecessary(applicationContext);
        }
        log.info("合约部署完成");
    }

    /**
     * 根据参数部署指定合约
     *
     * @param applicationContext
     */
    private void deployNecessary(ApplicationContext applicationContext) {
        DeploySynchronizer deploySynchronizer = new DeploySynchronizer();
        //解析出需要部署的合约名
        String[] contractNameArr = StringUtils.tokenizeToStringArray(args, ",; \t\n");
        List<String> contractNames = Arrays.asList(contractNameArr);
        log.info("需要部署的合约contractNames={}", JSON.toJSONString(contractNames));
        //需要部署的合约Adapter集合
        List<ContractDeployAdapter> contractDeployAdapters = new ArrayList<>(contractNames.size());
        Map<String, ContractDeployAdapter> contractDeployAdapterMap = applicationContext.getBeansOfType(ContractDeployAdapter.class);
        //筛选出需要部署的合约adapter
        contractDeployAdapterMap.values().forEach(contractDeployAdapter -> {
            if (contractNames.contains(contractDeployAdapter.contractName())) {
                contractDeployAdapters.add(contractDeployAdapter);
            } else {
                deploySynchronizer.deployed(contractDeployAdapter.contractName());
            }
        });
        invokeDoDeploy(contractDeployAdapters, deploySynchronizer);
        destoryBean(applicationContext, contractDeployAdapterMap.keySet());
    }

    /**
     * 部署所有合约
     *
     * @param applicationContext
     */
    private void deployAll(ApplicationContext applicationContext) {
        DeploySynchronizer deploySynchronizer = new DeploySynchronizer();
        Map<String, ContractDeployAdapter> contractDeployAdapterMap = applicationContext.getBeansOfType(ContractDeployAdapter.class);
        String contractNames = contractDeployAdapterMap.values().stream().map(ContractDeployAdapter::contractName).collect(Collectors.joining(","));
        log.info("部署所有合约, contractNames={}", contractNames);
        invokeDoDeploy(Lists.newArrayList(contractDeployAdapterMap.values()), deploySynchronizer);
    }

    private void invokeDoDeploy(List<ContractDeployAdapter> contractDeployAdapters,  DeploySynchronizer deploySynchronizer) {
        CountDownLatch countDownLatch = new CountDownLatch(contractDeployAdapters.size());
        for (ContractDeployAdapter contractDeployAdapter : contractDeployAdapters) {
            executorService.submit(() -> {
                try {
                    String contractName = contractDeployAdapter.contractName();
                    log.info("开始部署合约, 合约名={}", contractName);
                    String contractAddress = contractDeployAdapter.deploy(blockChainConfigHolder, deploySynchronizer);
                    if (contractAddress != null) {
                        log.info("合约部署成功, 合约名={}, contractAddress={}", contractName, contractAddress);
                        //将合约地址信息保存到数据库
                        contractService.update(contractName, contractAddress);
                        deploySynchronizer.deployed(contractName);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("合约部署失败", e);
        }
    }


    /**
     * 销毁bean
     *
     * @param applicationContext
     * @param contractDeployAdpterName
     */
    private void destoryBean(ApplicationContext applicationContext, Set<String> contractDeployAdpterName) {
        //销毁bean
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        contractDeployAdpterName.forEach(defaultListableBeanFactory::removeBeanDefinition);
        defaultListableBeanFactory.removeBeanDefinition("autoContractDeployer");
    }
}
