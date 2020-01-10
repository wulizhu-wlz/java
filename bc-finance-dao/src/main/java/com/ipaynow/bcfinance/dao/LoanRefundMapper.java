package com.ipaynow.bcfinance.dao;

import com.ipaynow.bcfinance.domain.LoanRefund;
import com.ipaynow.bcfinance.domain.LoanRefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoanRefundMapper {
    int countByExample(LoanRefundExample example);

    int deleteByExample(LoanRefundExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanRefund record);

    int insertSelective(LoanRefund record);

    List<LoanRefund> selectByExample(LoanRefundExample example);

    LoanRefund selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanRefund record, @Param("example") LoanRefundExample example);

    int updateByExample(@Param("record") LoanRefund record, @Param("example") LoanRefundExample example);

    int updateByPrimaryKeySelective(LoanRefund record);

    int updateByPrimaryKey(LoanRefund record);
}