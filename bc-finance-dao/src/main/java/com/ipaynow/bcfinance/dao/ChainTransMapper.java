package com.ipaynow.bcfinance.dao;

import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.ChainTransExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChainTransMapper {
    long countByExample(ChainTransExample example);

    int deleteByExample(ChainTransExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChainTrans record);

    int insertSelective(ChainTrans record);

    List<ChainTrans> selectByExample(ChainTransExample example);

    ChainTrans selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChainTrans record, @Param("example") ChainTransExample example);

    int updateByExample(@Param("record") ChainTrans record, @Param("example") ChainTransExample example);

    int updateByPrimaryKeySelective(ChainTrans record);

    int updateByPrimaryKey(ChainTrans record);


}