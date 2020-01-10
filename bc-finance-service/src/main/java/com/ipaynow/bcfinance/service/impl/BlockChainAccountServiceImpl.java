package com.ipaynow.bcfinance.service.impl;

import com.ipaynow.bcfinance.dao.BlockChainAccountMapper;
import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.domain.BlockChainAccountExample;
import com.ipaynow.bcfinance.enums.AccountTypeEnum;
import com.ipaynow.bcfinance.service.BlockChainAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ytw
 * @date 2019/7/18
 * description:
 */
@Service
public class BlockChainAccountServiceImpl implements BlockChainAccountService {

    @Resource
    private BlockChainAccountMapper blockChainAccountMapper;


    @Override
    public BlockChainAccount queryOne(String userIdOfIpaynow, AccountTypeEnum accountType) {
        BlockChainAccountExample blockChainAccountExample = new BlockChainAccountExample();
        blockChainAccountExample.createCriteria()
                .andUserIdOfIPayNowEqualTo(userIdOfIpaynow)
                .andAccountTypeEqualTo(accountType.getCode());
        List<BlockChainAccount> blockChainAccountList = blockChainAccountMapper.selectByExample(blockChainAccountExample);
        if (blockChainAccountList.isEmpty()) {
            return null;
        }
        return blockChainAccountList.get(0);
    }

    @Override
    public Integer nextPlatformIdOfTbMerchantUser() {
        BlockChainAccountExample blockChainAccountExample = new BlockChainAccountExample();
        blockChainAccountExample.createCriteria().andAccountTypeEqualTo(AccountTypeEnum.PLANTFORM.getCode());
        blockChainAccountExample.setOrderByClause("id_of_tb_merchant_user desc");
        List<BlockChainAccount> blockChainAccountList = blockChainAccountMapper.selectByExample(blockChainAccountExample);
        //生成idOfTbMerchantUser
        return (blockChainAccountList.get(0).getIdOfTbMerchantUser() + 1);
    }
}
