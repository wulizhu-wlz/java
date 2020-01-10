package com.ipaynow.bcfinance.service;

import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.dto.AccountRespDto;
import com.ipaynow.bcfinance.expcetion.BusinessException;

/**
 * Created by hai on 2019/6/28.
 */
public interface AccountService {
    AccountRespDto account2Chain(BlockChainAccount blockChainAccount, String accountName,boolean isModify) throws BusinessException;

    AccountRespDto openAccount(String accountAddr, BlockChainAccount platformAccount) throws BusinessException;

    AccountRespDto addCooperation(String accountAddr, BlockChainAccount platformAccount) throws BusinessException;
}
