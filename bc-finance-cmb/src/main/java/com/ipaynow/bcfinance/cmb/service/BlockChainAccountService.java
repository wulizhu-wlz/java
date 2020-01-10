package com.ipaynow.bcfinance.cmb.service;

import com.ipaynow.bcfinance.dao.BlockChainAccountMapper;
import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.domain.BlockChainAccountExample;
import com.ipaynow.bcfinance.enums.AccountTypeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ytw
 * @date 2019/7/9
 * description:
 */
@Service
public class BlockChainAccountService {

    @Resource
    private BlockChainAccountMapper blockChainAccountMapper;


    /**
     * 查询区块链账户
     *
     * @param idOfIPayNOW 商户/平台的ipaynowId
     * @param accountType 账户类型
     * @return
     */
    public BlockChainAccount queryOne(String idOfIPayNOW, AccountTypeEnum accountType) {
        //查询商户所属平台的区块链账户
        BlockChainAccountExample example = new BlockChainAccountExample();
        example.createCriteria()
                .andUserIdOfIPayNowEqualTo(idOfIPayNOW)
                .andAccountTypeEqualTo(accountType.getCode());
        List<BlockChainAccount> blockChainAccounts = blockChainAccountMapper.selectByExample(example);
        if (blockChainAccounts.isEmpty()) {
            return null;
        }
        return blockChainAccounts.get(0);
    }

    public List<BlockChainAccount> queryList(AccountTypeEnum accountType, Date startTime, Date endTime) {
        BlockChainAccountExample example = new BlockChainAccountExample();
        BlockChainAccountExample.Criteria criteria = example.createCriteria()
                .andAccountTypeEqualTo(accountType.getCode());
        if (startTime != null && endTime != null) {
            criteria.andCreateTimeBetween(startTime, endTime);
        }
        return blockChainAccountMapper.selectByExample(example);
    }

}
