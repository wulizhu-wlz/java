package com.ipaynow.bcfinance.controller;

import com.alibaba.fastjson.JSONObject;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.service.AssetStatementService;
import com.ipaynow.bcfinance.service.HistoryDataService;
import com.ipaynow.bcfinance.service.MerchantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ytw
 * @date 2019/6/20
 * description: 九盈历史数据controller
 */
@Controller
public class HistoryDataController {

    private final static Logger logger = LogManager.getLogger(HistoryDataController.class);

    @Resource
    private HistoryDataService historyDataService;
    @Resource
    private AssetStatementService assetStatementService;
    @Resource
    private MerchantService merchantService;


    @RequestMapping(value = "restoreLoanData.do")
    @ResponseBody
    public String restoreLoanData(Date startDate, Date endDate) {
        logger.info("恢复融资历史数据,startDate:{},endDate:{}", startDate, endDate);
        JSONObject responseJSON = new JSONObject();
        try {
            historyDataService.restoreLoanData(startDate, endDate);
            responseJSON.put("responseCode", ExceptionEnum.SUCCESS.getCode());
            responseJSON.put("responseMsg", ExceptionEnum.SUCCESS.getDesc());
        } catch (Exception e) {
            logger.error("【恢复融资历史数据异常】", e);
            responseJSON.put("responseCode", ExceptionEnum.SYSTEM_ERROR.getCode());
            responseJSON.put("responseMsg", ExceptionEnum.SYSTEM_ERROR.getDesc());
        }
        return responseJSON.toJSONString();
    }

    @RequestMapping("restoreRepaymentData.do")
    @ResponseBody
    public String restoreRepaymentData(Date startDate, Date endDate) {
        logger.info("恢复还款历史数据,startDate:{},endDate:{}", startDate, endDate);
        JSONObject responseJSON = new JSONObject();
        try {
            historyDataService.restoreRepaymentData(startDate, endDate);
            responseJSON.put("responseCode", ExceptionEnum.SUCCESS.getCode());
            responseJSON.put("responseMsg", ExceptionEnum.SUCCESS.getDesc());
        } catch (Exception e) {
            logger.error("【恢复还款历史数据异常】", e);
            responseJSON.put("responseCode", ExceptionEnum.SYSTEM_ERROR.getCode());
            responseJSON.put("responseMsg", ExceptionEnum.SYSTEM_ERROR.getDesc());
        }
        return responseJSON.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/restoreAssetStatement.do")
    public String restoreAssetStatement(Date startDate, Date endDate) {
        logger.info("restoreAssetStatement入参, startDate={}， endDate={}", startDate, endDate);
        assetStatementService.restoreAssetStatement(startDate, endDate);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/restoreHistoryMerchant.do")
    public String restoreHistoryMerchant(Date startDate, Date endDate) {
        logger.info("restoreHistoryMerchant入参, startDate={}， endDate={}", startDate, endDate);
        merchantService.restoreHistoryMerchant(startDate, endDate);
        return "success";
    }


    @ResponseBody
    @RequestMapping("/restoreDBRepayData.do")
    public String restoreRepayData() {
        historyDataService.restoreRepayData();
        return "success";
    }
}

