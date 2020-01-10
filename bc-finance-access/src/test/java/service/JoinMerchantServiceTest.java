package service;

import com.ipaynow.bcfinance.BcFinanceApplication;
import com.ipaynow.bcfinance.dao.MerchantPlatformBusinessMapper;
import com.ipaynow.bcfinance.domain.MerchantPlatformBusiness;
import com.ipaynow.bcfinance.dto.MerchantStatisticsDto;
import com.ipaynow.bcfinance.service.AssetStatementService;
import com.ipaynow.bcfinance.task.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ytw
 * @date 2019/6/25
 * description:
 */
@SpringBootTest(classes = BcFinanceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JoinMerchantServiceTest {

    @Autowired
    private AssetStatementService assetStatementService;

    @Autowired
    private MerchantPlatformBusinessMapper businessMapper;

    @Autowired
    private TaskService taskService;


    @Test
    public void processMerchantStatistic() throws InterruptedException {
        MerchantStatisticsDto merchantStatisticsDto = new MerchantStatisticsDto();
        merchantStatisticsDto.setIotmu("2");
        merchantStatisticsDto.setPn("京东");
        merchantStatisticsDto.setSa("100");
        merchantStatisticsDto.setSfsa("100");
        merchantStatisticsDto.setSfpa("100");
        merchantStatisticsDto.setStor("1.0");
        merchantStatisticsDto.setRr("0.1");
        merchantStatisticsDto.setSd("2019-12-25");
        assetStatementService.processMerchantStatistic(merchantStatisticsDto);

        TimeUnit.SECONDS.sleep(60);
    }

    @Test
    public void ttt() throws InterruptedException {
        List<MerchantPlatformBusiness> businessList = assetStatementService.queryAssets("100", "2019-06-30");
        System.out.print(businessList);
    }

    @Test
    public void taskTest() {
        taskService.loanCreditTask();
        taskService.loanRepayTask();
    }


}
