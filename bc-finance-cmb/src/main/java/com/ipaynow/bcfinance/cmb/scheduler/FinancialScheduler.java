package com.ipaynow.bcfinance.cmb.scheduler;

import com.ipaynow.bcfinance.cmb.service.LoanCreditService;
import com.ipaynow.bcfinance.cmb.service.MerchantService;
import com.ipaynow.bcfinance.domain.LoanCredit;
import com.ipaynow.bcfinance.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ytw
 * @date 2019/7/9
 * description:商户定时任务调度
 */
@Component
public class FinancialScheduler {

    private Logger logger = LoggerFactory.getLogger(FinancialScheduler.class);
    @Resource
    private LoanCreditService loanCreditService;


    @Scheduled(cron = "0 30 21,22 * * ?")
    public void taskToday() {
        Date startTime = DateUtil.getOneDayFirstDate(new Date());
        Date endTime = DateUtil.getOneDayLastTime(new Date());
        logger.info("放款定时任务调度taskToday，startTime={}, endTime={}", startTime, endTime);
        loanCreditService.loanCreditTask(startTime, endTime);
    }

    @Scheduled(cron = "0 0 11,16 * * ?")
    public void taskYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.getOneDayFirstDate(new Date()));
        calendar.add(Calendar.DATE, -1);
        Date startTime = calendar.getTime();
        Date endTime = DateUtil.getOneDayLastTime(startTime);
        logger.info("放款定时任务调度taskYesterday，startTime={}, endTime={}", startTime, endTime);
        loanCreditService.loanCreditTask(startTime, endTime);
    }


  /*  @Scheduled(cron = "0 30 13 * * ?")
    public void taskTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.JANUARY, 1, 0, 0, 0);
        Date startTime = calendar.getTime();
        Date endTime = new Date();
        logger.info("商户定时任务调度taskYesterday，startTime={}, endTime={}", startTime, endTime);
        loanCreditService.loanCreditTask(startTime, endTime);
    }*/
}
