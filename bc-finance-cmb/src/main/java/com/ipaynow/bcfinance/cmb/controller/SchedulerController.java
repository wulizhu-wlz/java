package com.ipaynow.bcfinance.cmb.controller;

import com.ipaynow.bcfinance.cmb.service.LoanCreditService;
import com.ipaynow.bcfinance.cmb.service.MerchantService;
import com.ipaynow.bcfinance.cmb.service.RepaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ytw
 * @date 2019/7/16
 * description: 调度定时任务的controller
 */
@Controller
@RequestMapping("/scheduler")
public class SchedulerController {


    private Logger logger = LoggerFactory.getLogger(SchedulerController.class);

    @Resource
    private MerchantService merchantService;
    @Resource
    private LoanCreditService loanCreditService;
    @Resource
    private RepaymentService repaymentService;


    @RequestMapping("/merchantTask")
    @ResponseBody
    public String sendMerchant2ChainTask(Date startTime, Date endTime) {
        logger.info("sendMerchant2ChainTask方法入参, startTime={}, endTime={}", startTime, endTime);
        merchantService.sendMerchant2ChainTask(startTime, endTime);
        return "success";
    }

    @RequestMapping("/platformTask")
    @ResponseBody
    public String sendPlantform2ChainTask(Date startTime, Date endTime) {
        logger.info("sendPlantform2ChainTask方法入参, startTime={}, endTime={}", startTime, endTime);
        merchantService.sendPlatform2ChainTask(startTime, endTime);
        return "success";
    }

    @RequestMapping("/loanCreditTask")
    @ResponseBody
    public String loanCreditTask(Date startTime, Date endTime) {
        logger.info("loanCreditTask方法入参, startTime={}, endTime={}", startTime, endTime);
        loanCreditService.loanCreditTask(startTime, endTime);
        return "success";
    }

    @RequestMapping("/repayTask")
    @ResponseBody
    public String repayTask(Date startTime, Date endTime) {
        logger.info("repayTask方法入参, startTime={}, endTime={}", startTime, endTime);
        repaymentService.repayTask(startTime, endTime);
        return "success";
    }

}
