package com.ipaynow.bcfinance.controller;

import com.github.pagehelper.PageInfo;
import com.ipaynow.bcfinance.domain.*;
import com.ipaynow.bcfinance.dto.JoinMerchantDtoForPage;
import com.ipaynow.bcfinance.dto.LoanCreditDtoForPage;
import com.ipaynow.bcfinance.dto.LoanRepayForPage;
import com.ipaynow.bcfinance.dto.MerchantPlatformDto;
import com.ipaynow.bcfinance.service.*;
import com.ipaynow.bcfinance.utils.PageResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

import static com.ipaynow.bcfinance.utils.PageResponseUtil.getSuccessPageJSONString;


/**
 * @author ytw
 * @date 2019/6/20
 * description: 九盈数据接收controller
 */
@Controller
public class QueryController {

    private static Logger logger = LogManager.getLogger(QueryController.class);

    @Autowired
    private LoanCreditService loanCreditService;

    @Autowired
    private RepaymentService repaymentService;

    @Autowired
    private LoanCreditDo2DtoService loanCreditDo2DtoService;

    @Autowired
    private LoanRepayDo2DtoService loanRepayDo2DtoService;

    @Autowired
    private MerchantPlatformService merchantPlatformService;
    @Autowired
    private MerchantService  merchantService  ;


    @RequestMapping(value = "getLoanCreditPageList.do")
    @ResponseBody
    public String getLoanCreditPageList(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
                                        @RequestParam(value = "code", required = false) String code,
                                        @RequestParam(value = "realLoanStartTime", required = false) String realLoanStartTime,
                                        @RequestParam(value = "realLoanEndTime", required = false) String realLoanEndTime,
                                        @RequestParam(value = "userIdOfIPayNowOfCreditor", required = false) String userIdOfIPayNowOfCreditor,
                                        @RequestParam(value = "userIdOfIPayNowOfDebtor", required = false) String userIdOfIPayNowOfDebtor,
                                        @RequestParam(value = "creditorName", required = false) String creditorName,
                                        @RequestParam(value = "debtorName", required = false) String debtorName
    ) {
        String pageListJSONString = null;
        try {
            PageInfo<LoanCredit> pageInfo = loanCreditService.getLoanCreditByPage(currentPage, pageSize, code, realLoanStartTime,
                    realLoanEndTime, userIdOfIPayNowOfCreditor, userIdOfIPayNowOfDebtor,
                    creditorName, debtorName);
            List<LoanCreditDtoForPage> creditDtoForPages = loanCreditDo2DtoService.loanCreditDo2Dto(pageInfo.getList());
            pageListJSONString = PageResponseUtil.getSuccessPageJSONString(currentPage, pageInfo.getPageNum(), pageSize, pageInfo.getTotal(), creditDtoForPages);
            return pageListJSONString;
        } catch (Exception e) {
            logger.error("查询借款数据失败", e);
            pageListJSONString = PageResponseUtil.getSystemErrorPageJSONString();
        }
        return pageListJSONString;
    }

    @RequestMapping(value = "getLoanRefundPageList.do")
    @ResponseBody
    public String getLoanRefundPageList(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
                                        @RequestParam(value = "idSlLoanCreditLog", required = true) int idSlLoanCreditLog
    ) {
        String pageListJSONString = null;
        try {
            PageInfo<LoanRepay> pageInfo = repaymentService.getRepayedLoanCredit(currentPage, pageSize, idSlLoanCreditLog);
            List<LoanRepayForPage> pageList = loanRepayDo2DtoService.loanRepayDo2Dto(pageInfo.getList());
            pageListJSONString = PageResponseUtil.getSuccessPageJSONString(currentPage, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(), pageList);
            return pageListJSONString;
        } catch (Exception e) {
            logger.error("查询还款数据异常", e);
            pageListJSONString = PageResponseUtil.getSystemErrorPageJSONString();
        }
        return pageListJSONString;
    }
    @RequestMapping(value = "getMerchantPlatformBusinessPageList.do")
    @ResponseBody
    public String getMerchantPlatformBusinessPageList(@RequestParam(value = "idOfTbMerchantUser", required = false) Integer idOfTbMerchantUser,
                                                      @RequestParam(value = "platformName", required = false) String platformName,
                                                      @RequestParam(value = "statisticalBeginDate", required = false) String statisticalBeginDate,
                                                      @RequestParam(value = "statisticalEndDate", required = false) String statisticalEndDate,
                                                      @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
                                                      @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) {
        MerchantPlatformBusiness param = new MerchantPlatformBusiness();
        param.setIdOfTbMerchantUser(idOfTbMerchantUser);
        param.setPlatformName(platformName);
        param.setStatisticalBeginDate(statisticalBeginDate);
        param.setStatisticalEndDate(statisticalEndDate);
        String pageListJSONString ;
        try {
            PageInfo<MerchantPlatformDto> pageInfo = merchantPlatformService.getMerchantPlatformBusinessList(param, currentPage, pageSize);
            pageListJSONString = PageResponseUtil.getSuccessPageJSONString(currentPage,pageInfo.getPageNum(), pageSize, pageInfo.getTotal(), pageInfo.getList());
            return pageListJSONString;
        } catch (Exception e) {
            logger.error("getMerchantPlatformBusinessPageList Exception {} ",e.getMessage());
            pageListJSONString =  PageResponseUtil.getSystemErrorPageJSONString();
        }
        return pageListJSONString;
    }

    @RequestMapping(value = "getMerchantDebtList.do")
    @ResponseBody
    public String getMerchantDebtList(@RequestParam(value = "idOfTbMerchantUser", required = false) Integer idOfTbMerchantUser,
                                      @RequestParam(value = "userIdOfIPayNow", required = false) String userIdOfIPayNow,
                                      @RequestParam(value = "mchName", required = false) String mchName,
                                      @RequestParam(value = "realLoanTimeFrom", required = false) String realLoanTimeFrom,
                                      @RequestParam(value = "realLoanTimeTo", required = false) String realLoanTimeTo,
                                      @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) {
        String pageListJSONString ;
        try {
            PageInfo<JoinMerchant> pageInfo =  merchantService.getJoinUserList(idOfTbMerchantUser, userIdOfIPayNow, mchName, currentPage, pageSize);
             List<JoinMerchantDtoForPage>  result =  pageInfo.getList().stream().map(joinMerchant -> {
                JoinMerchantDtoForPage joinMerchantDtoForPage = new JoinMerchantDtoForPage();
                BeanUtils.copyProperties(joinMerchant, joinMerchantDtoForPage);
                LoanCreditSum loanCreditSum = loanCreditService.getSum(joinMerchant.getUserIdOfIPayNow(), realLoanTimeFrom, realLoanTimeTo);
                joinMerchantDtoForPage.setNumberOfDebt(loanCreditSum.getLoanNumSummary());
                joinMerchantDtoForPage.setDebtAmount(loanCreditSum.getLoanAmountSummary().longValue());
                LoanRepaySum loanRepaySum = repaymentService.getSum(joinMerchant.getUserIdOfIPayNow());
                joinMerchantDtoForPage.setRefundAmount(loanRepaySum.getRepayAmountSummary().longValue());
                 return joinMerchantDtoForPage;
            }).collect(Collectors.toList());

            pageListJSONString =  PageResponseUtil.getSuccessPageJSONString(currentPage, pageInfo.getPageNum(),pageInfo.getPageSize(),  pageInfo.getTotal(), result);
            return pageListJSONString;
        } catch (Exception e) {
            logger.error(e.getMessage());
            pageListJSONString = PageResponseUtil.getSystemErrorPageJSONString();
        }
        return pageListJSONString;
    }

}

