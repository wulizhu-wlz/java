package com.ipaynow.bcfinance.dao;

import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.domain.BlockChainAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlockChainAccountMapper {
    long countByExample(BlockChainAccountExample example);

    int deleteByExample(BlockChainAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlockChainAccount record);

    int insertSelective(BlockChainAccount record);

    List<BlockChainAccount> selectByExample(BlockChainAccountExample example);

    BlockChainAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlockChainAccount record, @Param("example") BlockChainAccountExample example);

    int updateByExample(@Param("record") BlockChainAccount record, @Param("example") BlockChainAccountExample example);

    int updateByPrimaryKeySelective(BlockChainAccount record);

    int updateByPrimaryKey(BlockChainAccount record);
}