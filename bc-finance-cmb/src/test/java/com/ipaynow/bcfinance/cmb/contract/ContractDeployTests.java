package com.ipaynow.bcfinance.cmb.contract;

import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tuples.generated.Tuple2;
import com.cryptape.cita.tuples.generated.Tuple4;
import com.cryptape.cita.tuples.generated.Tuple6;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.cmb.config.CmbChainConfigHolder;
import com.ipaynow.bcfinance.cmb.contract.helper.FinancialHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ytw
 * @date 2019/7/11
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractDeployTests {

    @Autowired
    private CmbChainConfigHolder configHolder;

    @Test
    public void deployContract() {
        try {

            CITAj citAj = CITAj.build(new HttpService(configHolder.getIp()));
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(configHolder.getIpaynowPrivateKey()));

            RemoteCall<Merchant> merchantRemoteCall = Merchant.deploy(citAj, rawTransactionManager, 9999999L, BigInteger.valueOf(System.currentTimeMillis()).toString(), validUntilBlock, 2, "", BigInteger.ONE,configHolder.getIpaynowAddress());
            Merchant merchant = merchantRemoteCall.send();
            String merchantContractAddress = merchant.getContractAddress();
            System.out.println("merchantContractAddress:" + merchantContractAddress);

            RemoteCall<Financial> financialRemoteCall = Financial.deploy(citAj, rawTransactionManager, 9999999L, BigInteger.valueOf(System.currentTimeMillis()).toString(), validUntilBlock, 2, "", BigInteger.ONE, merchantContractAddress);
            String financialContractAddress = financialRemoteCall.send().getContractAddress();
            System.out.println("financialContractAddress:" + financialContractAddress);

        } catch (Exception e) {
            System.out.println("合约部署失败" + e);
        }
    }

}
