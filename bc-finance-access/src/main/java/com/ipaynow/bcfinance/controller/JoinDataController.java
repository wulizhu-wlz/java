package com.ipaynow.bcfinance.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ipaynow.bcfinance.dto.LoanCreditDto;
import com.ipaynow.bcfinance.dto.MerchantStatisticsDto;
import com.ipaynow.bcfinance.dto.NewMerchantDto;
import com.ipaynow.bcfinance.dto.RepaymentDto;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.enums.TaskTypeEnum;
import com.ipaynow.bcfinance.environment.Environment;
import com.ipaynow.bcfinance.expcetion.BaseException;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.service.AssetStatementService;
import com.ipaynow.bcfinance.service.JoinFinancialService;
import com.ipaynow.bcfinance.service.MerchantService;
import com.ipaynow.bcfinance.utils.ParamValidateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ytw
 * @date 2019/6/20
 * description: 九盈数据接收controller
 */
@Controller
public class JoinDataController {

    private static Logger logger = LogManager.getLogger(JoinDataController.class);


    @Resource
    private JoinFinancialService financialService;
    @Resource
    private AssetStatementService assetStatementService;
    @Resource
    private MerchantService merchantService;
    @Autowired
    private Environment environment;


    @RequestMapping(value = "joinp2ploandata")
    @ResponseBody
    public String receiveData(String message) {
        logger.info("获取九盈数据message={}", message);
        JSONObject responseJSON = new JSONObject();
        String responseTime = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
        try {
            //签名校验
            environment.signVerify(message);
            //处理九盈传过来的数据
            processMessage(message);
            responseJSON.put("responseCode", ExceptionEnum.SUCCESS.getCode());
            responseJSON.put("responseMsg", ExceptionEnum.SUCCESS.getDesc());
            responseJSON.put("responseTime", responseTime);
            return responseJSON.toJSONString();
        } catch (BaseException e) {
            logger.error("【处理九盈数据异常】", e);
            responseJSON.put("responseCode", e.getCode());
            responseJSON.put("responseMsg", e.getDesc());
            responseJSON.put("responseTime", responseTime);
        } catch (Exception e) {
            logger.error("【处理九盈数据异常】", e);
            responseJSON.put("responseCode", ExceptionEnum.SYSTEM_ERROR.getCode());
            responseJSON.put("responseMsg", ExceptionEnum.SYSTEM_ERROR.getDesc());
            responseJSON.put("responseTime", responseTime);
        }
        return responseJSON.toJSONString();
    }

    private void processMessage(String message) throws BaseException {
        JSONObject jsonObject = JSON.parseObject(message);
        JSONObject data = jsonObject.getJSONObject("data");
        TaskTypeEnum taskTypeEnum = TaskTypeEnum.getByCode(data.getByte("type"));
        switch (taskTypeEnum) {
            case MERCHANT_USER_DATA:
                //处理用户数据
                NewMerchantDto newMerchantDto = data.toJavaObject(NewMerchantDto.class);
                merchantService.addMerchant(newMerchantDto);
                break;
            case SUPPLY_CHAIN_CREDIT:
                //处理融资业务
                LoanCreditDto loanCreditDto = data.toJavaObject(LoanCreditDto.class);
                ParamValidateUtil.validate(loanCreditDto);
                financialService.processLoan(loanCreditDto);
                break;
            case SUPPLY_CHAIN_REFUND:
                //处理融资还款业务
                RepaymentDto repaymentDto = data.toJavaObject(RepaymentDto.class);
                ParamValidateUtil.validate(repaymentDto);
                financialService.processRepayment(repaymentDto);
                break;
            case MERCHANT_BUSINESS_DATA:
                //处理商户平台业务数据
                MerchantStatisticsDto merchantStatisticsDto = data.toJavaObject(MerchantStatisticsDto.class);
                assetStatementService.processMerchantStatistic(merchantStatisticsDto);
                break;
            default:
                throw new BusinessException(ExceptionEnum.TYPE_ERROR);
        }
    }


}

