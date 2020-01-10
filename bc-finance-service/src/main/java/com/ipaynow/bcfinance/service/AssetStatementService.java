package com.ipaynow.bcfinance.service;

import com.ipaynow.bcfinance.domain.MerchantPlatformBusiness;
import com.ipaynow.bcfinance.domain.MerchantPlatformBusinessExample;
import com.ipaynow.bcfinance.dto.MerchantStatisticsDto;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author ytw
 * @date 2019/7/1
 * description:
 */
public interface AssetStatementService {

    void processMerchantStatistic(MerchantStatisticsDto merchantStatisticsDto);

    void addMerchantPlatformBusiness(MerchantPlatformBusiness merchantPlatformBusiness);

    /**
     * 发送商户统计信息到链上
     *
     * @param merchantPlatformBusiness
     */
    void sendIpayNowChain(MerchantPlatformBusiness merchantPlatformBusiness);

    /**
     * 历史数据上链
     *
     * @param startDate
     * @param endDate
     */
    void restoreAssetStatement(Date startDate, Date endDate);

    List<MerchantPlatformBusiness> queryAssets(String id, String date);

}
