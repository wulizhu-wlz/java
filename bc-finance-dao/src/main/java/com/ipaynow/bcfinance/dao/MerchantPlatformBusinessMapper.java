package com.ipaynow.bcfinance.dao;

import com.ipaynow.bcfinance.domain.MerchantPlatformBusiness;
import com.ipaynow.bcfinance.domain.MerchantPlatformBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantPlatformBusinessMapper {
    long countByExample(MerchantPlatformBusinessExample example);

    int deleteByExample(MerchantPlatformBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantPlatformBusiness record);

    int insertSelective(MerchantPlatformBusiness record);

    List<MerchantPlatformBusiness> selectByExample(MerchantPlatformBusinessExample example);

    MerchantPlatformBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantPlatformBusiness record, @Param("example") MerchantPlatformBusinessExample example);

    int updateByExample(@Param("record") MerchantPlatformBusiness record, @Param("example") MerchantPlatformBusinessExample example);

    int updateByPrimaryKeySelective(MerchantPlatformBusiness record);

    int updateByPrimaryKey(MerchantPlatformBusiness record);
}