package com.ipaynow.bcfinance.chain.contract.adapter;


import com.alibaba.fastjson.JSON;
import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tx.Contract;
import com.cryptape.cita.tx.RawTransactionManager;
import com.cryptape.cita.tx.TransactionManager;
import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.ValidationException;
import com.ipaynow.bcfinance.thread.DeploySynchronizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author ytw
 * @date 2019/6/26
 * description: ContractDeployAdapter接口的基础实现
 * 泛型T：合约Class
 */

public abstract class AbstractContractDeployAdapter<T> implements ContractDeployAdapter {

    private final Logger logger = LoggerFactory.getLogger(AbstractContractDeployAdapter.class);

    private Class contractClass;


    /**
     * 从泛型中获取合约Class
     *
     * @return
     */
    public AbstractContractDeployAdapter() {
        //从泛型中获取合约Class
        ResolvableType resolvableType = ResolvableType.forClass(this.getClass()).as(AbstractContractDeployAdapter.class);
        ResolvableType generic = resolvableType.getGeneric(0);
        contractClass = generic.resolve();
        if (contractClass == null) {
            throw new ValidationException(ExceptionEnum.DEPLOY_CONTRACT_CLASS_NOT_FOUND);
        }
    }

    @Override
    public String contractName() {
        return contractClass.getSimpleName();
    }

    @Override
    public Class contractClass() {
        return contractClass;
    }

    @Override
    public String deploy(BlockChainConfigHolder blockChainConfigHolder, DeploySynchronizer deploySynchronizer) {
        doDepolyBefore(blockChainConfigHolder, deploySynchronizer);
        return doDeploy(blockChainConfigHolder);
    }

    /**
     * 部署合约
     *
     * @param blockChainConfigHolder 配置文件信息
     * @return 合约地址
     */

    protected String doDeploy(BlockChainConfigHolder blockChainConfigHolder) {
        try {
            CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
            RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(blockChainConfigHolder.getIpaynowPrivateKey()));
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            Class[] paramterTypes = {CITAj.class, TransactionManager.class, Long.class, String.class, Long.class, Integer.class, String.class, BigInteger.class, String.class};
            Method method = contractClass.getDeclaredMethod("deploy", paramterTypes);
            Object[] params = {citAj, rawTransactionManager, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, "", BigInteger.ONE, blockChainConfigHolder.getIpaynowAddress()};
            RemoteCall<T> remoteCall = (RemoteCall<T>) method.invoke(null, params);
            T t = remoteCall.send();
            String contractAddress;
            if (t instanceof Contract) {
                contractAddress = ((Contract) t).getContractAddress();
            } else {
                Method getContractAddressMethod = t.getClass().getMethod("getContractAddress");
                contractAddress = (String) getContractAddressMethod.invoke(t);
            }
            return contractAddress;
        } catch (Exception e) {
            logger.error("【部署合约失败,合约名={}】，blockChainConfigHolder={}", contractName(), JSON.toJSONString(blockChainConfigHolder), e);
            return null;
        }
    }


    protected void doDepolyBefore(BlockChainConfigHolder blockChainConfigHolder, DeploySynchronizer deploySynchronizer){}

    @Override
    public String toString() {
        return contractName();
    }

}
