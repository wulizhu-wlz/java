package com.ipaynow.bcfinance.chain.contract.adapter;

import com.alibaba.fastjson.JSON;
import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.chain.contract.*;
import com.ipaynow.bcfinance.enums.ContractEnum;
import com.ipaynow.bcfinance.service.ContractService;
import com.ipaynow.bcfinance.thread.DeploySynchronizer;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author ytw
 * @date 2019/6/26
 * description:
 */
@Component
public class FinanceTradeFatoryDeployAdapter extends AbstractContractDeployAdapter<FinanceTradeFactory> {

    private final Logger logger = LoggerFactory.getLogger(FinanceTradeFatoryDeployAdapter.class);

    @Autowired
    private ContractService contractService;


    @Override
    public String doDeploy(BlockChainConfigHolder blockChainConfigHolder) {
        try {
            CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
            RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(blockChainConfigHolder.getIpaynowPrivateKey()));

            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            String accountContractAddress = contractService.queryContractAddress(ContractEnum.AccountFactory.name());
            String assetContractAddress = contractService.queryContractAddress(ContractEnum.AssetStatementFactory.name());
            String financeProductFactoryAddress = contractService.queryContractAddress(ContractEnum.FinanceProductFactory.name());
            String cooperationAddress = contractService.queryContractAddress(ContractEnum.Cooperation.name());

            FinanceProductFactory financeProductFactory = FinanceProductFactory.load(financeProductFactoryAddress, citAj, rawTransactionManager);
            RemoteCall<TransactionReceipt> call1 = financeProductFactory.issuesFinanceProduct(BigInteger.valueOf(12L), "productA", 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
            call1.send();
            RemoteCall<String> financeProduct = financeProductFactory.getFinanceProduct(BigInteger.valueOf(12L));
            String financeProductAddress = financeProduct.send();

            RemoteCall<FinanceTradeFactory> deploy = FinanceTradeFactory.deploy(citAj, rawTransactionManager, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, "", BigInteger.ONE, financeProductAddress, accountContractAddress, assetContractAddress, cooperationAddress, blockChainConfigHolder.getIpaynowAddress());

            FinanceTradeFactory financeTradeFactory = deploy.send();
            return financeTradeFactory.getContractAddress();
        } catch (Exception e) {
            logger.error("【部署合约失败,合约名：{}】，blockChainConfigHolder={}", contractName(), JSON.toJSONString(blockChainConfigHolder), e);
            return null;
        }
    }

    @Override
    protected void doDepolyBefore(BlockChainConfigHolder blockChainConfigHolder, DeploySynchronizer deploySynchronizer) {
        ContractEnum[] waitContracts = new ContractEnum[]{ContractEnum.AccountFactory, ContractEnum.AssetStatementFactory, ContractEnum.FinanceProductFactory, ContractEnum.Cooperation};
        CountDownLatch countDownLatch = new CountDownLatch(waitContracts.length);
        deploySynchronizer.register(countDownLatch, waitContracts);
        logger.info("【等待其它合约部署完成...】, waitContracts={}", Arrays.toString(waitContracts));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            logger.error("【合约部署失败】", e);
        }

    }
}
