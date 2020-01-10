package com.ipaynow.bcfinance.service;


import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.LoanCredit;
import com.ipaynow.bcfinance.domain.LoanRepay;
import com.ipaynow.bcfinance.dto.LoanCreditDtoForPage;
import com.ipaynow.bcfinance.dto.LoanRepayForPage;
import com.ipaynow.bcfinance.enums.ChainStatusEnum;
import com.ipaynow.bcfinance.enums.OperationTypeEnum;
import com.ipaynow.bcfinance.utils.MoneyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ipaynow0407 on 2017/10/16.
 */
@Service
public class LoanRepayDo2DtoService {

    @Autowired
    private ChainTransService chainTransService;

    public LoanRepayForPage loanRepayDo2Dto(LoanRepay loanRepay) {
        if (null == loanRepay) {
            return null;
        }
        LoanRepayForPage loanRepayForPage = new LoanRepayForPage();
        if (loanRepay.getChainStatus() == ChainStatusEnum.CHAIN_UP.getCode()) {
            List<ChainTrans> list = chainTransService.queryByBusinessIdAndType(loanRepay.getId(), OperationTypeEnum.REPAY.getCode());
            loanRepayForPage.setTransHash(list.get(0).getTransHash());
        }
        loanRepayForPage.setRefundAmount(String.valueOf(MoneyUtil.cent2yuan(String.valueOf(loanRepay.getRepayAmount()))));
        loanRepayForPage.setRefundDate(loanRepay.getRepayDate());
        loanRepayForPage.setRefundPrinciple(String.valueOf(MoneyUtil.cent2yuan(String.valueOf(loanRepay.getRepayPrinciple()))));
        loanRepayForPage.setShouldRefundRate(String.valueOf(MoneyUtil.cent2yuan(String.valueOf(loanRepay.getShouldRepayRate()))));
        loanRepayForPage.setRefundRate(String.valueOf(MoneyUtil.cent2yuan(String.valueOf(loanRepay.getRepayRate()))));
        loanRepayForPage.setShouldRefundPrinciple(String.valueOf(MoneyUtil.cent2yuan(String.valueOf(loanRepay.getShouldRepayPrinciple()))));
        loanRepayForPage.setRefundRateNotPayback(String.valueOf(MoneyUtil.cent2yuan(String.valueOf(loanRepay.getShouldRepayRate().subtract(loanRepay.getRepayRate())))));
        loanRepayForPage.setRefundPrincipleNotPayback(String.valueOf(MoneyUtil.cent2yuan(String.valueOf(loanRepay.getShouldRepayPrinciple().subtract(loanRepay.getRepayPrinciple())))));
        return loanRepayForPage;
    }

    public List<LoanRepayForPage> loanRepayDo2Dto(List<LoanRepay> loanRepays) {
        if (null == loanRepays) {
            return null;
        }
        List<LoanRepayForPage> loanCreditDtoForPageList = new ArrayList<LoanRepayForPage>();
        for (LoanRepay loanRepay : loanRepays) {
            LoanRepayForPage loanRepayForPage = loanRepayDo2Dto(loanRepay);
            loanCreditDtoForPageList.add(loanRepayForPage);
        }
        return loanCreditDtoForPageList;
    }
}
