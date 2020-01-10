package com.ipaynow.bcfinance.manager;

import com.ipaynow.bcfinance.dao.BlockChainAccountMapper;
import com.ipaynow.bcfinance.dao.ChainTransMapper;
import com.ipaynow.bcfinance.dao.JoinMerchantMapper;
import com.ipaynow.bcfinance.dao.MerchantPlatformBusinessMapper;
import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.JoinMerchant;
import com.ipaynow.bcfinance.domain.MerchantPlatformBusiness;
import com.ipaynow.bcfinance.enums.ChainStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ytw
 * @date 2019/6/28
 * description: 商户事物操作
 */
@Component
public class MerchantManager {

    @Autowired
    private MerchantPlatformBusinessMapper merchantPlatformBusinessMapper;
    @Autowired
    private ChainTransMapper chainTransMapper;

    @Autowired
    private BlockChainAccountMapper blockChainAccountMapper;

    @Autowired
    private JoinMerchantMapper joinMerchantMapper;

    @Transactional
    public void updateChainInfo(MerchantPlatformBusiness merchantPlatformBusiness, ChainTrans chainTrans) {
        this.merchantPlatformBusinessMapper.updateByPrimaryKeySelective(merchantPlatformBusiness);
        chainTransMapper.insertSelective(chainTrans);
    }


    @Transactional
    public void updateMerchantInfoForAccountOpen(List<ChainTrans> chainTransList, JoinMerchant joinMerchant) {
        for(int i=0;i<chainTransList.size();i++)
            chainTransMapper.insertSelective(chainTransList.get(i));
        joinMerchantMapper.updateByPrimaryKeySelective(joinMerchant);
    }

    @Transactional
    public void updateMerchantInfoForAccountCreate(BlockChainAccount blockChainAccount, ChainTrans chainTrans, JoinMerchant joinMerchant) {
        updateAccountAndChainInfo(blockChainAccount,chainTrans);
        joinMerchantMapper.updateByPrimaryKeySelective(joinMerchant);
    }


    @Transactional
    public void updateAccountAndChainInfo(BlockChainAccount blockChainAccount, ChainTrans chainTrans) {
        blockChainAccountMapper.updateByPrimaryKeySelective(blockChainAccount);
        chainTransMapper.insertSelective(chainTrans);
    }

    @Transactional
    public void restoreMerchant(BlockChainAccount blockChainAccount, ChainTrans chainTrans, JoinMerchant joinMerchant){
        blockChainAccountMapper.insertSelective(blockChainAccount);
        chainTransMapper.insertSelective(chainTrans);
        joinMerchantMapper.updateByPrimaryKeySelective(joinMerchant);
    }

}
