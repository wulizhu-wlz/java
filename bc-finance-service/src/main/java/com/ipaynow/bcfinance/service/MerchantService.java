package com.ipaynow.bcfinance.service;

import com.github.pagehelper.PageInfo;
import com.ipaynow.bcfinance.domain.JoinMerchant;
import com.ipaynow.bcfinance.dto.NewMerchantDto;
import com.ipaynow.bcfinance.expcetion.BusinessException;

import java.util.Date;
import java.util.List;

/**
 * Created by hai on 2019/6/25.
 */
public interface MerchantService {
    void addMerchant(NewMerchantDto merchantDto) throws BusinessException;

    JoinMerchant queryMerchant(Integer idOfTbMerchantUser) throws BusinessException;

    void restoreHistoryMerchant(Date startTime, Date endTime);

    JoinMerchant queryMerchant(String userIdOfIpayNow) throws BusinessException;

    PageInfo<JoinMerchant> getJoinUserList(Integer idOfTbMerchantUser, String userIdOfIPayNow, String mchName, int currentPage, int pageSize);

    List<JoinMerchant> queryByDbtorIdAndCreditId(String debtorId,String creditId);

    //PageInfo<JoinMerchant> getJoinUserList(Integer idOfTbMerchantUser, String userIdOfIPayNow, String mchName, int currentPage, int pageSize);

    //long getJoinUserCount(Integer idOfTbMerchantUser, String userIdOfIPayNow, String mchName);

}
