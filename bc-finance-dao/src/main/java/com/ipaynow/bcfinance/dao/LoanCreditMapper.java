package com.ipaynow.bcfinance.dao;

import com.ipaynow.bcfinance.domain.LoanCredit;
import com.ipaynow.bcfinance.domain.LoanCreditExample;

import java.util.Date;
import java.util.List;

import com.ipaynow.bcfinance.domain.LoanCreditSum;
import com.ipaynow.bcfinance.enums.OperationTypeEnum;
import org.apache.ibatis.annotations.Param;

public interface LoanCreditMapper {
    int countByExample(LoanCreditExample example);

    int deleteByExample(LoanCreditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoanCredit record);

    int insertSelective(LoanCredit record);

    List<LoanCredit> selectByExample(LoanCreditExample example);

    List<LoanCredit> selectAssetsCredit();

    LoanCredit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoanCredit record, @Param("example") LoanCreditExample example);

    int updateByExample(@Param("record") LoanCredit record, @Param("example") LoanCreditExample example);

    int updateByPrimaryKeySelective(LoanCredit record);

    int updateByPrimaryKey(LoanCredit record);


    List<LoanCredit> selectCmbList(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    LoanCreditSum getSummary(@Param(value = "debtorUserId") String debtorUserId, @Param(value = "realLoanTimeFrom")String realLoanTimeFrom, @Param(value = "realLoanTimeTo") String realLoanTimeTo );

}