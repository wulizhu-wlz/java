package com.ipaynow.bcfinance.service;

import com.ipaynow.bcfinance.domain.ChainTrans;

import java.util.List;

/**
 * @author ytw
 * @date 2019/6/27
 * description:
 */
public interface ChainTransService {

    void add(ChainTrans chainTrans);

    void updateByBusinessIdAndChainId(ChainTrans chainTrans,byte operationType);

    List<ChainTrans> queryByBusinessIdAndType(long businessId, byte operationType);

}
