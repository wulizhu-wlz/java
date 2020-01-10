package com.ipaynow.bcfinance.dao;

import com.ipaynow.bcfinance.domain.LoanRepay;
import com.ipaynow.bcfinance.domain.LoanRepayExample;

import java.util.Date;
import java.util.List;

import com.ipaynow.bcfinance.domain.LoanRepaySum;
import org.apache.ibatis.annotations.Param;

public interface LoanRepayMapper {
    int countByExample(LoanRepayExample example);

    int deleteByExample(LoanRepayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoanRepay record);

    int insertSelective(LoanRepay record);

    List<LoanRepay> selectByExample(LoanRepayExample example);

    LoanRepay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoanRepay record, @Param("example") LoanRepayExample example);

    int updateByExample(@Param("record") LoanRepay record, @Param("example") LoanRepayExample example);

    int updateByPrimaryKeySelective(LoanRepay record);

    int updateByPrimaryKey(LoanRepay record);

    LoanRepaySum getSummary(@Param(value = "debtor_user_id") String debtor_user_id);


    List<LoanRepay> selectSendCmbList(@Param("startTime")Date startTime, @Param("endTime") Date endTime);
}