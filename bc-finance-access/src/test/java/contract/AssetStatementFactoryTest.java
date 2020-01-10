package contract;

import com.alibaba.fastjson.JSON;
import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tuples.generated.Tuple8;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.BcFinanceApplication;
import com.ipaynow.bcfinance.chain.contract.*;
import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.dto.AccountRespDto;
import com.ipaynow.bcfinance.service.AccountService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.List;

/**
 * @author ytw
 * @date 2019/6/24
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BcFinanceApplication.class)
public class AssetStatementFactoryTest {

    @Autowired
    private BlockChainConfigHolder blockChainConfigHolder;

    private CITAj citAj;

    private RawTransactionManager rawTransactionManager;

    @Autowired
    private AccountService accountService;

    @Before
    public void before() {
        citAj = CITAj.build(new HttpService("http://103.244.232.19:1338"));
        rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey("745b85ab7eac2bfaebf6f459a03bd5b48f628e61c6e4be2728152da4f2eabca5"));

    }

    @Test
    public void deploy() throws Exception {
        long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
        RemoteCall<AssetStatementFactory> remoteCall = AssetStatementFactory.deploy(citAj, rawTransactionManager, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, "", BigInteger.ONE, "0x20fc3d75db663d0bee8c512fe2db66ed8d829300");
        AssetStatementFactory assetStatementFactory = remoteCall.send();
        System.out.println(assetStatementFactory.getContractAddress());
    }

    @Test
    public void tes() throws Exception {
        AccountFactory accountFactory = AccountFactory.load("0x7c23e190a64a49e77049068a07e114fda0b8e49e", citAj, rawTransactionManager);
        String s = accountFactory.getAccountAddr("mchId20170221000000000000000000000000013").send();
        Account account = Account.load(s, citAj, rawTransactionManager);

        Boolean ff = account.checkIsMyUser("47c435a67121c47017b2dfac4889e24ffb420373").send();
        System.out.println("result:" + ff);
        System.out.println("address:" + s);
    }

    @Test
    public void financeRepayRecordTest() throws Exception {
        FinanceTradeFactory financeTradeFactory = FinanceTradeFactory.load("0x483bf8762ee71a97c348f4c8bbe303402d7928e9", citAj, rawTransactionManager);
        String financeTrade = financeTradeFactory.getFinanceTrade(BigInteger.valueOf(1032)).send();
        FinanceTrade financeTrade1 = FinanceTrade.load(financeTrade, citAj, rawTransactionManager);
        String token = financeTrade1.getFinanceRepayToken().send();
        FinanceRepayToken financeRepayToken = FinanceRepayToken.load(token, citAj, rawTransactionManager);
//        Boolean aBoolean = financeRepayToken.isPayoff().send();
//        System.out.println("result:" + aBoolean);

        List list = financeRepayToken.getAllRepayRecords().send();
        System.out.println("records:" + JSON.toJSONString(list));
        FinanceRepayRecord record = FinanceRepayRecord.load(list.get(0).toString(), citAj, rawTransactionManager);
        FinanceRepayRecord record1 = FinanceRepayRecord.load(list.get(1).toString(), citAj, rawTransactionManager);
        FinanceRepayRecord record2 = FinanceRepayRecord.load(list.get(2).toString(), citAj, rawTransactionManager);
        Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String> send = record.getFinanceRepayRecord().send();
        System.out.println("record:" + JSON.toJSONString(send) + ",223Address:" + list.get(0).toString());

        Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String> send1 = record1.getFinanceRepayRecord().send();
        System.out.println("record1:" + JSON.toJSONString(send1) + ",224Address" + list.get(0).toString());

        Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String> send2 = record2.getFinanceRepayRecord().send();
        System.out.println("record2:" + JSON.toJSONString(send2));

//        BlockChainAccount platForm = new BlockChainAccount();
//        platForm.setPrivateKey("8112c971f6e46b087ae10e364bd98d367a2a044d0a711136668c8aaa768c1b5d");
//        platForm.setAccAddress("0x769b623afbf194486930d9051310f2d41326a3a5");
//        AccountRespDto accountOpenRespDto = accountService.openAccount("0x2a23715fd98f03f4b67b9913fbeeb699da7adc85", platForm);
    }


}
