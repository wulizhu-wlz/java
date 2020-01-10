package com.ipaynow.bcfinance.builder;

import com.ipaynow.bcfinance.domain.MerchantPlatformBusiness;
import com.ipaynow.bcfinance.dto.MerchantStatisticsDto;
import com.ipaynow.bcfinance.enums.ChainStatusEnum;

import java.util.Date;

/**
 * @author ytw
 * @date 2019/6/24
 * description:
 */
public class MerchantPlatFormBusinessBuilder {

    public static MerchantPlatformBusiness convert2MerchantPlatformBusiness(MerchantStatisticsDto merchantStatisticsDto){
        if (merchantStatisticsDto == null) return null;
        MerchantPlatformBusiness merchantPlatformBusiness = new MerchantPlatformBusiness();
        merchantPlatformBusiness.setIdOfTbMerchantUser(Integer.valueOf(merchantStatisticsDto.getIotmu()));
        merchantPlatformBusiness.setPlatformName(merchantStatisticsDto.getPn());
        merchantPlatformBusiness.setStockAmount(merchantStatisticsDto.getSa());
        merchantPlatformBusiness.setSoldForSettlementAmount(merchantStatisticsDto.getSfsa());
        merchantPlatformBusiness.setSettledForPaymentAmount(merchantStatisticsDto.getSfpa());
        merchantPlatformBusiness.setStockTurnOverRatio(merchantStatisticsDto.getStor());
        merchantPlatformBusiness.setReturnRate(merchantStatisticsDto.getRr());
        merchantPlatformBusiness.setStatisticalDate(merchantStatisticsDto.getSd());
        merchantPlatformBusiness.setChainStatus(ChainStatusEnum.CHAIN_DOWN.getCode());
        merchantPlatformBusiness.setCreatedTime(new Date());
        return merchantPlatformBusiness;
    }
}
