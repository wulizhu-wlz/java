package com.ipaynow.bcfinance.service;

import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.enums.AccountTypeEnum;

/**
 * @author ytw
 * @date 2019/7/18
 * description:
 */
public interface BlockChainAccountService {
    BlockChainAccount queryOne(String userIdOfIpaynow, AccountTypeEnum accountType);

    Integer nextPlatformIdOfTbMerchantUser();
}
