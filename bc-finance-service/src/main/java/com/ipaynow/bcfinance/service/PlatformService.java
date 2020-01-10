package com.ipaynow.bcfinance.service;

import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.dto.OpenMerchantDto;
import com.ipaynow.bcfinance.expcetion.BusinessException;

/**
 * Created by hai on 2019/6/25.
 */
public interface PlatformService {
    void openMerchant(OpenMerchantDto openMerchantDto, BlockChainAccount platform) throws BusinessException;

    BlockChainAccount addPlatform(String userIdOfIPayNowOfCreditor, String creditorName) throws BusinessException;

}
