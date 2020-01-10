package com.ipaynow.bcfinance.cmb;

import com.ipaynow.bcfinance.cmb.service.MerchantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantServiceTests {

    @Resource
    private MerchantService merchantService;

    @Test
    public void sendMerchant2ChainTask() {
        Calendar c1 = Calendar.getInstance();
        c1.set(2017, Calendar.NOVEMBER, 17, 0, 0, 0);
        Date startTime = c1.getTime();
        c1.set(2019, Calendar.DECEMBER, 25, 23, 59, 59);
        Date endTime = c1.getTime();
        merchantService.sendMerchant2ChainTask(startTime, endTime);
        try {
            Thread.sleep(1000 * 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void sendPlantform2ChainTask() {
        Calendar c1 = Calendar.getInstance();
        c1.set(2019, Calendar.DECEMBER, 27, 0, 0, 0);
        Date startTime = c1.getTime();
        c1.set(2019, Calendar.DECEMBER, 27, 23, 59, 59);
        Date endTime = c1.getTime();
        System.out.println(startTime);
        merchantService.sendPlatform2ChainTask(startTime, endTime);
        try {
            Thread.sleep(2000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
