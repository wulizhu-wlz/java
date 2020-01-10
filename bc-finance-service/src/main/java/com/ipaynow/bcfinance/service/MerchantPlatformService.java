package com.ipaynow.bcfinance.service;

import com.github.pagehelper.PageInfo;
import com.ipaynow.bcfinance.domain.MerchantPlatformBusiness;
import com.ipaynow.bcfinance.dto.MerchantPlatformDto;

public interface MerchantPlatformService {

    PageInfo<MerchantPlatformDto> getMerchantPlatformBusinessList(MerchantPlatformBusiness merchantPlatformBusiness,
                                                                  int currentPage, int pageSize) throws Exception;
    //long getMerchantPlatBusinessCount(int idOfTbMerchantUser, String platformName, String statisticalBeginDate, String statisticalEndDate);
}
