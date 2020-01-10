package com.ipaynow.bcfinance.cmb;

import com.ipaynow.bcfinance.cmb.service.LoanCreditService;
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
public class LoanCreditServiceTests {

    @Resource
    private LoanCreditService loanCreditService;

    @Test
    public void loanCreditTask() {
        Calendar c1 = Calendar.getInstance();
        c1.set(2017, Calendar.NOVEMBER, 17, 0, 0, 0);
        Date startTime = c1.getTime();
        c1.set(2019, Calendar.AUGUST, 1, 23, 59, 59);
        Date endTime = c1.getTime();
        loanCreditService.loanCreditTask(startTime ,endTime);
        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
