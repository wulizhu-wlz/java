package contract;

import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.crypto.sm2.SM2KeyPair;
import com.cryptape.cita.crypto.sm2.SM2Keys;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.BcFinanceApplication;
import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.chain.contract.*;
import com.ipaynow.bcfinance.service.ContractService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ytw
 * @date 2019/6/24
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BcFinanceApplication.class)
public class FinanceTradeFactoryTest {

    @Autowired
    private BlockChainConfigHolder blockChainConfigHolder;

    private CITAj citAj;

    private RawTransactionManager rawTransactionManager;

    @Autowired
    private ContractService contractService;


    @Before
    public void before() {
        citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
        rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(blockChainConfigHolder.getIpaynowPrivateKey()));
    }

    @Test
    public void deploy() throws Exception {
        long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;

        String accountContractAddress = "0x6557e09b855de3b29227846b002d5bfd8d9137cd";

        String assetContractAddress = "0x888adf4db03771f80aa0902f6adb2c98964ab21c";

        String financeProductAddress = "0x7eed5e00d6a18ad1ef3648fbfcd5a8fbf751449a";

        /*RemoteCall<FinanceTradeFactory> deploy = FinanceTradeFactory.deploy(citAj, rawTransactionManager, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, "", BigInteger.ONE, financeProductAddress,accountContractAddress,assetContractAddress,blockChainConfigHolder.getIpaynowAddress());

        FinanceTradeFactory financeTradeFactory = deploy.send();
        System.out.println("financeTradeFactory:"+financeTradeFactory.getContractAddress());

        List<FinanceTradeFactory.DoCreateFinanceTradeFactoryEventResponse> responses = financeTradeFactory.getDoCreateFinanceTradeFactoryEvents(financeTradeFactory.getTransactionReceipt());

        FinanceTradeFactory tradeFactory = FinanceTradeFactory.load(financeTradeFactory.getContractAddress(), citAj, rawTransactionManager);
//        tradeFactory.registerAccountFactoryAddress(accountContractAddress, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "").send();
//        tradeFactory.registerProduct(financeProductAddr, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "").send();
//        System.out.println("FinanceTradeFactory:" + financeTradeFactory.getContractAddress());

        List<BigInteger> assetIds = new ArrayList<>();
        assetIds.add(BigInteger.valueOf(1960));
        RemoteCall<TransactionReceipt> call = tradeFactory.createFinanceTrade(assetIds,BigInteger.valueOf(108104), "12311154", "1111113", 99999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        TransactionReceipt receipt = call.send();
        List<FinanceTradeFactory.DoCreateFinanceTradeEventResponse> responses1 = tradeFactory.getDoCreateFinanceTradeEvents(receipt);
        String errorMessage = receipt.getErrorMessage();
        System.out.println("errorMessage:" + errorMessage);*/
    }
}
