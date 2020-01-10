package com.ipaynow.bcfinance.cmb;

import com.ipaynow.bcfinance.cmb.service.RepaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ytw
 * @date 2019/7/11
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepaymentServiceTests {

    @Resource
    private RepaymentService repaymentService;


    @Test
    public void repay(){
        Calendar c1 = Calendar.getInstance();
        c1.set(2017, Calendar.NOVEMBER, 20, 0, 0, 0);
        Date startTime = c1.getTime();
        c1.set(2019, Calendar.NOVEMBER, 9, 23, 59, 59);
        Date endTime = c1.getTime();
        repaymentService.repayTask(startTime ,endTime);
        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
