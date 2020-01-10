package contract;

import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.chain.contract.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author ytw
 * @date 2019/6/24
 * description:
 */
public class FinanceTradeTest {

    private CITAj citAj;

    private RawTransactionManager platformTransactionManager;


    private RawTransactionManager merchantTransactionManager;

    private Logger logger = Logger.getAnonymousLogger();


    private String superAdmin = "0x20fc3d75db663d0bee8c512fe2db66ed8d829300";

    @Before
    public void before() {
        String platformKey = "57eb39dd09900aad6f194686e3a8d11a3caa283275bc20fa910b81b2a0cf9417";
        String merchantKey = "c52a8e78674e45ded21eeea7037ef34bb8cf8caee27a9831e0bb422eccde03bc";

        citAj = CITAj.build(new HttpService("http://192.168.51.45:1337"));
        platformTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(platformKey));
        merchantTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(merchantKey));
    }

    @Test
    public void deploy() throws Exception {

        long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;


        RemoteCall<Cooperation> remoteCallDeploy=   Cooperation.deploy(citAj, platformTransactionManager, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, "", BigInteger.ONE, superAdmin);
        Cooperation platformCooperation  = remoteCallDeploy.send();
        String  cooperationAddress = platformCooperation.getContractAddress();

        logger.info("cooperation: " + cooperationAddress);

        Cooperation merchantCooperation   = Cooperation.load(cooperationAddress,citAj, merchantTransactionManager);


        RemoteCall<AssetStatementFactory> remoteCall = AssetStatementFactory.deploy(citAj, platformTransactionManager, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, "", BigInteger.ONE, superAdmin);
        AssetStatementFactory assetStatementFactory = remoteCall.send();
        String assetStatementFactoryAddress = assetStatementFactory.getContractAddress();
        logger.info("assetStatementFactory: " + assetStatementFactoryAddress);

        BigInteger id = BigInteger.valueOf(1890);
        BigInteger merchantNo = BigInteger.valueOf(340);
        String plantName = "京东y00d66";
        BigInteger stockAmount = BigInteger.ZERO;
        BigInteger settleAmount = BigInteger.valueOf(136640);
        BigInteger repayAmount = BigInteger.valueOf(4553512);

        String overRatio = "-1.0";
        String returnRatio = "-1.0";
        String statisticalDate = "2017-11-13";
        RemoteCall<TransactionReceipt> createAssetStatement = assetStatementFactory.createAssetStatement(id, merchantNo, plantName, stockAmount, settleAmount, repayAmount, overRatio, returnRatio, statisticalDate, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        createAssetStatement.send();

        RemoteCall<AccountFactory> accountFactoryDeploy = AccountFactory.deploy(citAj, platformTransactionManager, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, "", BigInteger.ONE, superAdmin);
        AccountFactory platformAccountFactory = accountFactoryDeploy.send();

        String accountFactoryAddress = platformAccountFactory.getContractAddress();
        logger.info("accountFactory: " + accountFactoryAddress);
       AccountFactory merchantAccountFactoryDeploy = AccountFactory.load(accountFactoryAddress, citAj, merchantTransactionManager);

        RemoteCall<TransactionReceipt> createAccountA = platformAccountFactory.createAccount("123", BigInteger.ZERO, "a", 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        createAccountA.send();

        RemoteCall<TransactionReceipt> createAccountB = merchantAccountFactoryDeploy.createAccount("456", BigInteger.ONE, "b", 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        createAccountB.send();

        String accountA = platformAccountFactory.getAccountAddr("123").send();

        logger.info("accountA: " + accountA);

        String accountB = platformAccountFactory.getAccountAddr("456").send();

        logger.info("accountB: " + accountB);


        RemoteCall<TransactionReceipt> platformAddCooperation = platformCooperation.addCooperation(accountA ,accountB, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        TransactionReceipt platformAddCooperationReceipt = platformAddCooperation.send();
        logger.info("platformAddCooperationReceipt: " + platformAddCooperationReceipt.getErrorMessage());

        RemoteCall<TransactionReceipt> merchantAddCooperation = merchantCooperation.addCooperation(accountB , accountA, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        TransactionReceipt  merchantAddCooperationReceipt =        merchantAddCooperation.send();

        logger.info("merchantAddCooperationReceipt: " + merchantAddCooperationReceipt.getErrorMessage());

        RemoteCall<FinanceProductFactory> financeProductFactoryDeploy = FinanceProductFactory.deploy(citAj, platformTransactionManager, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, "", BigInteger.ONE, superAdmin);
        FinanceProductFactory financeProductFactory = financeProductFactoryDeploy.send();
        logger.info("FinanceProductFactoryAddress: " + financeProductFactory.getContractAddress());

        // String financeProductFactoryAddress = "";
        //  FinanceProductFactory  financeProductFactory =  FinanceProductFactory.load(financeProductFactoryAddress,citAj,platformTransactionManager);
        BigInteger productId = BigInteger.valueOf(22);
        RemoteCall<TransactionReceipt> issuesFinanceProduct = financeProductFactory.issuesFinanceProduct(productId, "prodcutA", 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");

        String issuesFinanceProductErrorMessage = issuesFinanceProduct.send().getErrorMessage();
        logger.info("issuesFinanceProductErrorMessage: " + issuesFinanceProductErrorMessage);

        String product = financeProductFactory.getFinanceProduct(productId).send();

        logger.info("product: " + product);

        RemoteCall<FinanceTradeFactory> deploy = FinanceTradeFactory.deploy(citAj, platformTransactionManager,
                9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, "", BigInteger.ONE,
                product, accountFactoryAddress, assetStatementFactoryAddress,cooperationAddress, superAdmin);

        FinanceTradeFactory financeTradeFactory = deploy.send();
        //  BigInteger id  = BigInteger.valueOf(1890);
        List<BigInteger> asset = new ArrayList<>();
        asset.add(id);
        BigInteger creditId = BigInteger.valueOf(10004);

        RemoteCall<TransactionReceipt> createFinanceTrade = financeTradeFactory.createFinanceTrade(asset, creditId, "123", "456", 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");

        String createFinanceTradeErrorMessage = createFinanceTrade.send().getErrorMessage();
        logger.info("createFinanceTradeErrorMessage: " + createFinanceTradeErrorMessage);

        String tradeAddress = financeTradeFactory.getFinanceTrade(creditId).send();

        logger.info("tradeAddress: " + tradeAddress);
        FinanceTrade platformTrade = FinanceTrade.load(tradeAddress, citAj, platformTransactionManager);

        FinanceTrade merchantTrade = FinanceTrade.load(tradeAddress, citAj, merchantTransactionManager);

        RemoteCall<TransactionReceipt> accept = platformTrade.accept(creditId, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        TransactionReceipt acceptReceipt = accept.send();
        String acceptReceiptErrorMessage = acceptReceipt.getErrorMessage();
        logger.info("acceptReceiptErrorMessage: " + acceptReceiptErrorMessage);

         BigInteger totalAmount = BigInteger.valueOf(1000000);
        RemoteCall<TransactionReceipt> loan =  platformTrade.loan(creditId, totalAmount, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");


        TransactionReceipt loanReceipt = loan.send();
        String loanReceiptErrorMessage = loanReceipt.getErrorMessage();
        logger.info("loanReceiptErrorMessage: " + loanReceiptErrorMessage);

        BigInteger repayIdA = BigInteger.valueOf(10001);
        RemoteCall<TransactionReceipt> repayA = merchantTrade.repay(creditId, repayIdA, BigInteger.valueOf(500000), BigInteger.valueOf(500000), BigInteger.valueOf(10000), BigInteger.ONE, "123", "456", 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        TransactionReceipt repayAReceipt = repayA.send();
        String repayAReceiptErrorMessage = repayAReceipt.getErrorMessage();
        logger.info("repayAReceiptErrorMessage: " + repayAReceiptErrorMessage);


        BigInteger repayIdB = BigInteger.valueOf(10002);
        RemoteCall<TransactionReceipt> repayB = merchantTrade.repay(creditId, repayIdB, BigInteger.valueOf(500000), BigInteger.valueOf(500000), BigInteger.valueOf(10000), BigInteger.ONE, "123", "456", 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        TransactionReceipt repayBReceipt = repayB.send();
        String repayBReceiptErrorMessage = repayBReceipt.getErrorMessage();
        logger.info("repayBReceiptErrorMessage: " + repayBReceiptErrorMessage);

        BigInteger stage = platformTrade.stage().send();
        logger.info("stage: " + stage);
        stage = merchantTrade.stage().send();
        logger.info("stage: " + stage);
        BigInteger repayIdC = BigInteger.valueOf(10003);
        RemoteCall<TransactionReceipt> repayC = merchantTrade.repay(creditId, repayIdC, BigInteger.valueOf(500000), BigInteger.valueOf(500000), BigInteger.valueOf(10000), BigInteger.ONE, "123", "456", 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
        TransactionReceipt repayCReceipt = repayC.send();
        String repayCReceiptErrorMessage = repayCReceipt.getErrorMessage();
        logger.info("repayCReceiptErrorMessage: " + repayCReceiptErrorMessage);


    }


}
