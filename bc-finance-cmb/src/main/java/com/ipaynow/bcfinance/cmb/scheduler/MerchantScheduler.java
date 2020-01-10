package com.ipaynow.bcfinance.cmb.scheduler;

import com.ipaynow.bcfinance.cmb.service.MerchantService;
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
public class MerchantScheduler {

    private Logger logger = LoggerFactory.getLogger(MerchantScheduler.class);
    @Resource
    private MerchantService merchantService;

    /**
     * 发送当天的商户数据到Merchant合约
     */
    @Scheduled(cron = "0 0 21,22 * * ?")
    public void taskMerchantToday() {
        Date startTime = DateUtil.getOneDayFirstDate(new Date());
        Date endTime = DateUtil.getOneDayLastTime(new Date());
        logger.info("商户定时任务调度taskToday，startTime={}, endTime={}", startTime, endTime);
        merchantService.sendMerchant2ChainTask(startTime, endTime);
    }

    /**
     * 发送昨天的商户数据到Merchant合约
     */
    @Scheduled(cron = "0 30 10,15 * * ?")
    public void taskMerchantYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.getOneDayFirstDate(new Date()));
        calendar.add(Calendar.DATE, -1);
        Date startTime = calendar.getTime();
        Date endTime = DateUtil.getOneDayLastTime(startTime);
        logger.info("商户定时任务调度taskYesterday，startTime={}, endTime={}", startTime, endTime);
        merchantService.sendMerchant2ChainTask(startTime, endTime);
    }


    /**
     * 发送当天的平台数据到Merchant合约
     */
    @Scheduled(cron = "0 0 21,22 * * ?")
    public void taskPlantformToday() {
        Date date = new Date();
        Date startTime = DateUtil.getOneDayFirstDate(date);
        Date endTime = DateUtil.getOneDayLastTime(date);
        logger.info("商户定时任务调度taskYesterday，startTime={}, endTime={}", startTime, endTime);
        merchantService.sendPlatform2ChainTask(startTime, endTime);
    }

}
