package com.ipaynow.bcfinance.task;


import com.ipaynow.bcfinance.domain.LoanCredit;
import com.ipaynow.bcfinance.domain.LoanRepay;
import com.ipaynow.bcfinance.service.*;
import com.ipaynow.bcfinance.thread.RunnableWrapper;
import com.ipaynow.bcfinance.utils.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by ipaynow0407 on 2017/10/16.
 */
//@Component
@Configuration
@EnableScheduling
public class TaskService {

    @Autowired
    private LoanCreditService loanCreditService;


    @Autowired
    private HistoryDataService historyDataService;

    @Autowired
    private RepaymentService repaymentService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private AssetStatementService assetStatementService;


    private final static Logger logger = LogManager.getLogger(TaskService.class);

    @Scheduled(cron = "0 0 22 * * ?")
    public void loanCreditTask() {
        //查询出带有资产的未上链的融资数据
        List<LoanCredit> creditList = loanCreditService.queryInit();
        logger.info("定时处理借款数据开始，待处理的条数:{}", creditList.size(), LocalDateTime.now());
        historyDataService.restoreLoan(creditList);
    }


    @Scheduled(cron = "0 30 22 * * ?")
    public void loanRepayTask() {
        List<LoanRepay> repayList = repaymentService.queryInit();
        logger.info("定时处理还款数据开始,待处理的条数:{}", repayList.size(), LocalDateTime.now());
        historyDataService.restoreRepay(repayList);
    }

    @Scheduled(cron = "0 0 21 * * ?")
    private void merchantTask() {

        Calendar calendar = Calendar.getInstance();
        Date endTime = calendar.getTime();
        calendar.add(Calendar.DATE, -2);
        Date startTime = calendar.getTime();
        merchantService.restoreHistoryMerchant(startTime, endTime);
        logger.info("merchantService sync: " + endTime);

    }

    @Scheduled(cron = "0 30 21 * * ?")
    private void merchantBusinessTask() {
        Calendar calendar = Calendar.getInstance();
        Date endTime = calendar.getTime();
        calendar.add(Calendar.DATE, -2);
        Date startTime = calendar.getTime();
        assetStatementService.restoreAssetStatement(startTime, endTime);
        logger.info("assetStatementService sync: " + endTime);

    }


}
