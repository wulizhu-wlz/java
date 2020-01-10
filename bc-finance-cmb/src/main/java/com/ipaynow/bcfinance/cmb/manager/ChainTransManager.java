package com.ipaynow.bcfinance.cmb.manager;

import com.ipaynow.bcfinance.dao.ChainTransMapper;
import com.ipaynow.bcfinance.domain.ChainTrans;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ytw
 * @date 2019/7/10
 * description:
 */
@Service
public class ChainTransManager {

    @Resource
    private ChainTransMapper chainTransMapper;

    @Transactional
    public void save(ChainTrans... chainTrans){
        for (ChainTrans chainTran : chainTrans) {
            chainTransMapper.insertSelective(chainTran);
        }
    }
}
