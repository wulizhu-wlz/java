package com.ipaynow.bcfinance.cmb.service;

import com.ipaynow.bcfinance.dao.ChainTransMapper;
import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.ChainTransExample;
import com.ipaynow.bcfinance.enums.ChainEnum;
import com.ipaynow.bcfinance.enums.ChainStatusEnum;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.enums.OperationTypeEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ytw
 * @date 2019/7/9
 * description:
 */
@Service
public class ChainTransService {


    @Resource
    private ChainTransMapper chainTransMapper;


    /**
     * 查询交易信息
     *
     * @param businessId
     * @param operationTypeEnum
     * @param chainEnum
     * @param chainStatusEnum
     */
    public ChainTrans queryOne(String businessId, OperationTypeEnum operationTypeEnum, ChainEnum chainEnum, ChainStatusEnum chainStatusEnum) {
        if (StringUtils.isEmpty(businessId) || operationTypeEnum == null || chainEnum == null || chainStatusEnum == null) {
            throw new BusinessException(ExceptionEnum.PARAM_ERROR);
        }
        ChainTransExample chainTransExample = new ChainTransExample();
        chainTransExample.createCriteria()
                .andBuinessIdEqualTo(businessId)
                .andOperationTypeEqualTo(operationTypeEnum.getCode())
                .andChainIdEqualTo(chainEnum.getCode())
                .andChainStatusEqualTo(chainStatusEnum.getCode());
        List<ChainTrans> chainTrans = chainTransMapper.selectByExample(chainTransExample);
        if (chainTrans.isEmpty()) {
            return null;
        }
        return chainTrans.get(0);
    }

    public void insert(ChainTrans chainTrans) {
        this.chainTransMapper.insertSelective(chainTrans);
    }

}
