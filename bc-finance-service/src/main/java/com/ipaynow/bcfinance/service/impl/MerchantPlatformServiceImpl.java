package com.ipaynow.bcfinance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ipaynow.bcfinance.dao.MerchantPlatformBusinessMapper;
import com.ipaynow.bcfinance.domain.MerchantPlatformBusiness;
import com.ipaynow.bcfinance.domain.MerchantPlatformBusinessExample;
import com.ipaynow.bcfinance.dto.MerchantPlatformDto;
import com.ipaynow.bcfinance.enums.ChainStatusEnum;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.service.MerchantPlatformService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MerchantPlatformServiceImpl implements MerchantPlatformService {

    private static Logger logger = LoggerFactory.getLogger(MerchantPlatformService.class);
    @Autowired
    MerchantPlatformBusinessMapper merchantPlatformBusinessMapper;

    @Override
    public PageInfo<MerchantPlatformDto> getMerchantPlatformBusinessList(MerchantPlatformBusiness merchantPlatformBusiness, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        Integer idOfTbMerchantUser = merchantPlatformBusiness.getIdOfTbMerchantUser();;
        MerchantPlatformBusinessExample example  = new MerchantPlatformBusinessExample();
        MerchantPlatformBusinessExample.Criteria criteria = example.createCriteria();
        if (idOfTbMerchantUser != null){
            criteria.andIdOfTbMerchantUserEqualTo(idOfTbMerchantUser);
        }
        String platformName = merchantPlatformBusiness.getPlatformName();
        if (StringUtils.isNotBlank(platformName)) {
            criteria.andPlatformNameLike("%" + platformName + "%");
        }
        String statisticalBeginDate = merchantPlatformBusiness.getStatisticalBeginDate();
        if (StringUtils.isNotBlank(statisticalBeginDate)) {
            criteria.andStatisticalDateGreaterThanOrEqualTo(statisticalBeginDate);
        }
        String  statisticalEndDate = merchantPlatformBusiness.getStatisticalEndDate();
        if (StringUtils.isNotBlank(statisticalEndDate)) {
            criteria.andStatisticalDateLessThanOrEqualTo(statisticalEndDate);
        }
        criteria.andChainStatusEqualTo(ChainStatusEnum.CHAIN_UP.getCode());
        try{
        List<MerchantPlatformBusiness> list = merchantPlatformBusinessMapper.selectByExample(example);
        List<MerchantPlatformDto>  pages =list.stream().map(this::convertToMerchantPlatformDto).collect(Collectors.toList());
        return   new PageInfo<>(pages);
    } catch (Exception e) {
        logger.error("分页查询获取商户平台记录总数异常 借方记录id:{}", merchantPlatformBusiness, e.getMessage());
        throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
    }
  }

    private MerchantPlatformDto convertToMerchantPlatformDto(MerchantPlatformBusiness merchantPlatformBusiness){
        MerchantPlatformDto  dto   = new MerchantPlatformDto();
        BeanUtils.copyProperties(merchantPlatformBusiness,dto);
        return dto;
    }
}
