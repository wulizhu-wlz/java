package com.ipaynow.bcfinance.service;


import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.LoanCredit;
import com.ipaynow.bcfinance.dto.LoanCreditDtoForPage;
import com.ipaynow.bcfinance.enums.CreditStatusEnum;
import com.ipaynow.bcfinance.enums.OperationTypeEnum;
import com.ipaynow.bcfinance.utils.MoneyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ipaynow0407 on 2017/10/16.
 */
@Service
public class LoanCreditDo2DtoService {

    @Autowired
    private ChainTransService chainTransService;

    public LoanCreditDtoForPage loanCreditDo2Dto(LoanCredit loanCredit) {
        if (null == loanCredit) {
            return null;
        }
        LoanCreditDtoForPage loanCreditDtoForPage = new LoanCreditDtoForPage();
        if (loanCredit.getStatus() == CreditStatusEnum.LOAN.getCode()) {
            List<ChainTrans> list = chainTransService.queryByBusinessIdAndType(loanCredit.getId(), OperationTypeEnum.LOAN.getCode());
            loanCreditDtoForPage.setTransHash(list.get(0).getTransHash());
        }
        BeanUtils.copyProperties(loanCredit, loanCreditDtoForPage);
        loanCreditDtoForPage.setCode(loanCredit.getLoanCode());
        loanCreditDtoForPage.setRate(loanCredit.getFinancingRate());
        loanCreditDtoForPage.setUserIdOfIPayNowOfCreditor(loanCredit.getCreditorUserId());
        loanCreditDtoForPage.setUserIdOfIPayNowOfDebtor(loanCredit.getDebtorUserId());
        loanCreditDtoForPage.setRealLoanTime(loanCredit.getRealLoanTime());
        loanCreditDtoForPage.setId(loanCredit.getId().intValue());
        String accountDetla = String.valueOf(MoneyUtil.cent2yuan(String.valueOf(loanCredit.getFinancingAmount())));
        loanCreditDtoForPage.setAccountDelta(accountDetla);
        return loanCreditDtoForPage;
    }

    public List<LoanCreditDtoForPage> loanCreditDo2Dto(List<LoanCredit> loanCreditList) {
        if (null == loanCreditList) {
            return null;
        }
        List<LoanCreditDtoForPage> loanCreditDtoForPageList = new ArrayList<LoanCreditDtoForPage>();
        for (LoanCredit loanCredit : loanCreditList) {
            LoanCreditDtoForPage loanCreditDtoForPage = loanCreditDo2Dto(loanCredit);
            loanCreditDtoForPageList.add(loanCreditDtoForPage);
        }
        return loanCreditDtoForPageList;
    }
}
