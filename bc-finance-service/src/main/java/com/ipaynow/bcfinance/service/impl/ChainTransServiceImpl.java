package com.ipaynow.bcfinance.service.impl;

import com.ipaynow.bcfinance.dao.ChainTransMapper;
import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.ChainTransExample;
import com.ipaynow.bcfinance.enums.ChainEnum;
import com.ipaynow.bcfinance.service.ChainTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ytw
 * @date 2019/6/27
 * description:
 */
@Component
public class ChainTransServiceImpl implements ChainTransService {

    @Autowired
    private ChainTransMapper chainTransMapper;

    @Override
    public void add(ChainTrans chainTrans) {
        chainTransMapper.insertSelective(chainTrans);
    }

    @Override
    public void updateByBusinessIdAndChainId(ChainTrans chainTrans, byte operationType) {
        ChainTransExample example = new ChainTransExample();
        example.createCriteria().andBuinessIdEqualTo(chainTrans.getBuinessId()).andChainIdEqualTo(ChainEnum.IPAYNOW.getCode()).andOperationTypeEqualTo(operationType);
        chainTransMapper.updateByExampleSelective(chainTrans, example);
    }

    @Override
    public List<ChainTrans> queryByBusinessIdAndType(long businessId, byte operationType) {
        ChainTransExample example = new ChainTransExample();
        example.createCriteria().andBuinessIdEqualTo(String.valueOf(businessId)).andOperationTypeEqualTo(operationType).andChainIdEqualTo(ChainEnum.IPAYNOW.getCode());
        List<ChainTrans> chainTransList = chainTransMapper.selectByExample(example);
        return chainTransList;

    }
}
