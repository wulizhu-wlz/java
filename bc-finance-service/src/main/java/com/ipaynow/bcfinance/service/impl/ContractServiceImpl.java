package com.ipaynow.bcfinance.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.ipaynow.bcfinance.dao.ContractMapper;
import com.ipaynow.bcfinance.domain.Contract;
import com.ipaynow.bcfinance.domain.ContractExample;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.enums.IsDeleteEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.service.ContractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author ytw
 * @date 2019/6/27
 * description:
 */
@Slf4j
@Service
public class ContractServiceImpl implements ContractService {

    Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(30).build();

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public String queryContractAddress(String contractName) {
        try {
            return cache.get(contractName, () -> {
                ContractExample example = new ContractExample();
                example.createCriteria()
                        .andContractNameEqualTo(contractName)
                        .andIsDeleteEqualTo(IsDeleteEnum.NO.getCode());
                List<Contract> contracts = contractMapper.selectByExample(example);
                if (contracts.isEmpty()) {
                    log.error("合约地址不存在, contractName={}", contractName);
                    throw new BusinessException(ExceptionEnum.CONTRACT_ADDR_NOT_EXIST);
                }
                String contractAddress = contracts.get(0).getAddress();
                log.info("获取合约地址，查询数据库, contractName={}, contractAddress={}", contractName, contractAddress);
                return contractAddress;
            });
        } catch (ExecutionException e) {
            log.error("获取合约地址失败, contractName={}", contractName, e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 更新数据库
     */
    @Override
    @Transactional
    public void update(String contractName, String contractAddress) {
        ContractExample example = new ContractExample();
        Contract contract = new Contract(contractName, contractAddress, 1, new Date());
        example.clear();
        ContractExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(IsDeleteEnum.NO.getCode())
                .andContractNameEqualTo(contractName);
        //查询库中是否有该合约记录
        List<Contract> contracts = contractMapper.selectByExample(example);
        //如果库中已经有该合约的信息，将之前的合约信息逻辑删除，然后新的合约信息版本号+1
        if (!contracts.isEmpty()) {
            Contract contractDB = contracts.get(0);
            contractDB.setIsDelete(IsDeleteEnum.YES.getCode());
            contract.setVersion(contractDB.getVersion() + 1);
            contractMapper.updateByPrimaryKey(contractDB);
        }
        //保存合约信息
        contractMapper.insertSelective(contract);
    }
}
