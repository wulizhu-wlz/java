package com.ipaynow.bcfinance.dao;

import com.ipaynow.bcfinance.domain.JoinMerchant;
import com.ipaynow.bcfinance.domain.JoinMerchantExample;

import java.util.Date;
import java.util.List;

import com.ipaynow.bcfinance.enums.ChainEnum;
import com.ipaynow.bcfinance.enums.ChainStatusEnum;
import com.ipaynow.bcfinance.enums.OperationTypeEnum;
import com.ipaynow.bcfinance.enums.StatusEnum;
import org.apache.ibatis.annotations.Param;

public interface JoinMerchantMapper {
    long countByExample(JoinMerchantExample example);

    int deleteByExample(JoinMerchantExample example);

    int deleteByPrimaryKey(Integer idOfTbMerchantUser);

    int insert(JoinMerchant record);

    int insertSelective(JoinMerchant record);

    List<JoinMerchant> selectByExample(JoinMerchantExample example);

    List<JoinMerchant> selectByMerchantUserId(@Param("idOfTbMerchantUser") Integer idOfTbMerchantUser,@Param("userIdOfIPayNow") String userIdOfIPayNow, @Param("mchName") String mchName);

    JoinMerchant selectByPrimaryKey(Integer idOfTbMerchantUser);

    int updateByExampleSelective(@Param("record") JoinMerchant record, @Param("example") JoinMerchantExample example);

    int updateByExample(@Param("record") JoinMerchant record, @Param("example") JoinMerchantExample example);

    int updateByPrimaryKeySelective(JoinMerchant record);

    int updateByPrimaryKey(JoinMerchant record);

    /**
     * 查询可以发送到招行链的商户list
     * @param status
     * @param chainStatus
     * @param chainId
     * @param operationType
     * @return
     */
    List<JoinMerchant> selectCmbSendableList(@Param("status") Byte status, @Param("chainStatus") Byte chainStatus, @Param("chainId") Byte chainId, @Param("operationType") Byte operationType, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}