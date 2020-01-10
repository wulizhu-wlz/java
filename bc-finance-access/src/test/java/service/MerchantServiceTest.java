package service;

import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tx.RawTransactionManager;
import com.github.pagehelper.PageInfo;
import com.ipaynow.bcfinance.BcFinanceApplication;
import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.chain.contract.Account;
import com.ipaynow.bcfinance.domain.*;
import com.ipaynow.bcfinance.dto.JoinMerchantDtoForPage;
import com.ipaynow.bcfinance.dto.MerchantPlatformDto;
import com.ipaynow.bcfinance.dto.NewMerchantDto;
import com.ipaynow.bcfinance.dto.OpenMerchantDto;
import com.ipaynow.bcfinance.service.*;
import com.ipaynow.bcfinance.utils.PageResponseUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author ytw
 * @date 2019/6/25
 * description:
 */
@SpringBootTest(classes = BcFinanceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MerchantServiceTest {

    private static Logger  logger =  Logger.getAnonymousLogger();

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private BlockChainConfigHolder blockChainConfigHolder;

    @Autowired
    private MerchantPlatformService merchantPlatformService;

    @Autowired
    private LoanCreditService loanCreditService;

    @Autowired
    private RepaymentService repaymentService;


    @Test
    public void processMerchantService(){
        NewMerchantDto newMerchantDto = new NewMerchantDto();
        newMerchantDto.setIotmu(332);
        newMerchantDto.setUioipn("mch2017080715020980660301885");
        newMerchantDto.setMn("测试商户");
        merchantService.addMerchant(newMerchantDto);

    }


    @Test
    public void processOpenMerchant(){
        OpenMerchantDto openMerchantDto = new OpenMerchantDto();
        openMerchantDto.setUserIdOfIPayNowOfCreditor("101");
        openMerchantDto.setUserIdOfIPayNowOfDebtor("1");
        openMerchantDto.setCreditorName("测试平台1");
        platformService.openMerchant(openMerchantDto, new BlockChainAccount());

    }


    @Test
    public void testOwner(){
        String contractAddress = "0xa18beae3929a552d3fcd8122965c3d1490e75ff3";
        CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
        RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey("9a43401d523e2b9fa34bf15c156a8cafebf2d73c47b6dcd135532a167e3cbcdc"));
        Account account = Account.load(contractAddress, citAj, rawTransactionManager);
        try {
            RemoteCall<Boolean> remoteCall = account.checkIsMyUser("e7cb543fce275189eeb4d854f9a7eee44f4fab7e");
            Boolean result = remoteCall.send();
            System.out.println(result);
        }catch (Exception e){

        }

    }

    @Test
    public void testDeploy(){
        System.out.println("success");
    }

    @Test
    public void test(){
        logger.info("success");
    }

    @Test
    public void merchantPlatformService(){
        MerchantPlatformBusiness param = new MerchantPlatformBusiness();
        param.setIdOfTbMerchantUser(3);
         param.setPlatformName("京东");
        param.setStatisticalBeginDate("2019-06-24");
        param.setStatisticalEndDate("2019-06-24");
        try {
            PageInfo<MerchantPlatformDto> result = merchantPlatformService.getMerchantPlatformBusinessList(param, 1, 3);
            result.getList().forEach(ss ->{
                logger.info(ss.toString());
            }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void merchantPlatformServiceSummary() {


      //  String userIdOfIPayNow ="222222";
        String userIdOfIPayNow =null;
        String  mchName =null;
      //  int idOfTbMerchantUser  = 222222;
        Integer idOfTbMerchantUser =null;
       // String realLoanTimeFrom ="2019-06-27";
        String realLoanTimeFrom =null;
       // String realLoanTimeTo ="2019-06-27";

        String realLoanTimeTo =null;
        int currentPage =1;
        int pageSize =10;
        PageInfo<JoinMerchant> pageInfo =  merchantService.getJoinUserList(idOfTbMerchantUser, userIdOfIPayNow, mchName, currentPage, pageSize);
        List<JoinMerchantDtoForPage>  result =  pageInfo.getList().stream().map(joinMerchant -> {
            JoinMerchantDtoForPage joinMerchantDtoForPage = new JoinMerchantDtoForPage();
            BeanUtils.copyProperties(joinMerchant, joinMerchantDtoForPage);
            LoanCreditSum loanCreditSum = loanCreditService.getSum(joinMerchant.getUserIdOfIPayNow(), realLoanTimeFrom, realLoanTimeTo);
            joinMerchantDtoForPage.setNumberOfDebt(loanCreditSum.getLoanNumSummary());
            joinMerchantDtoForPage.setDebtAmount(loanCreditSum.getLoanAmountSummary().longValue());
            LoanRepaySum loanRepaySum = repaymentService.getSum(joinMerchant.getUserIdOfIPayNow());
            joinMerchantDtoForPage.setRefundAmount(loanRepaySum.getRepayAmountSummary().longValue());
             return joinMerchantDtoForPage;
        }).collect(Collectors.toList());

        result.forEach( joinMerchantDtoForPage -> {
            logger.info(joinMerchantDtoForPage.toString());
        });
       String        pageListJSONString =  PageResponseUtil.getSuccessPageJSONString(currentPage, pageInfo.getPageNum(),pageInfo.getPageSize(),  pageInfo.getTotal(), result);
        logger.info(pageListJSONString);


    }
    @Test
    public void addPlatForm(){
        String platFormId = "mchId20151105000000000000000000000000011";
        String platFormName="深圳市前海现在商业保理有限公司";
        platformService.addPlatform(platFormId,platFormName);
    }
}
