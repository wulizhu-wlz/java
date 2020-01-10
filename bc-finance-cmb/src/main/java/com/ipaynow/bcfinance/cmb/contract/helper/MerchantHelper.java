package com.ipaynow.bcfinance.cmb.contract.helper;

import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.cmb.config.CmbChainConfigHolder;
import com.ipaynow.bcfinance.cmb.contract.Merchant;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigInteger;

/**
 * @author ytw
 * @date 2019/7/11
 * description:
 */
@Service
public class MerchantHelper {

    private Logger logger = LoggerFactory.getLogger(MerchantHelper.class);
    @Resource
    private CmbChainConfigHolder cmbChainConfigHolder;


    /**
     * 发送商户和平台关联信息到Merchant合约
     *
     * @param merchantIdOfIPaynow  商户ipaynowId
     * @param merchantAccAddress   商户Account合约地址
     * @param plantformIdOfIPaynow 平台ipaynowId
     * @return
     */
    public TransactionReceipt add(String merchantIdOfIPaynow, String merchantAccAddress, String plantformIdOfIPaynow) {
        logger.info("发送商户信息到招行链, merchantIdOfIPaynow={}, merchantAccAddress={}, plantformIdOfIPaynow={}", merchantIdOfIPaynow, merchantAccAddress, plantformIdOfIPaynow);
        CITAj citAj = CITAj.build(new HttpService(cmbChainConfigHolder.getIp()));
        RawTransactionManager transactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(cmbChainConfigHolder.getIpaynowPrivateKey()));

        Merchant merchant = Merchant.load(cmbChainConfigHolder.contract.getMerchantAddress(), citAj, transactionManager);
        TransactionReceipt transactionReceipt;
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = merchant.add(merchantIdOfIPaynow, merchantAccAddress, plantformIdOfIPaynow, 900000L, String.valueOf(System.nanoTime()), validUntilBlock, 2,BigInteger.valueOf(cmbChainConfigHolder.getChainId()), "");
            transactionReceipt = remoteCall.send();
        } catch (Exception e) {
            logger.error("发送商户信息到招行链失败", e);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
        if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
            logger.error("发送商户信息到招行链失败, 合约接口返回errorMsg={}", transactionReceipt.getErrorMessage());
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
        logger.info("发送商户信息到招行链成功, transactionHash={}", transactionReceipt.getTransactionHash());
        return transactionReceipt;
    }


    /**
     * 发送平台信息到Merchant合约
     *
     * @param platformIdOfIpaynow
     * @param accAddress
     * @return
     */
    public TransactionReceipt addPlatform(String platformIdOfIpaynow, String accAddress) {
        logger.info("发送平台信息到招行链, platformIdOfIpaynow={}, accAddress={}", platformIdOfIpaynow, accAddress);
        CITAj citAj = CITAj.build(new HttpService(cmbChainConfigHolder.getIp()));
        RawTransactionManager transactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(cmbChainConfigHolder.getIpaynowPrivateKey()));
        Merchant merchant = Merchant.load(cmbChainConfigHolder.contract.getMerchantAddress(), citAj, transactionManager);
        TransactionReceipt transactionReceipt;
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = merchant.addPlatform(platformIdOfIpaynow, accAddress, 200000L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.valueOf(cmbChainConfigHolder.getChainId()), "");
            transactionReceipt = remoteCall.send();
        } catch (Exception e) {
            logger.error("发送平台信息到招行链失败", e);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
        if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
            logger.error("发送平台信息到招行链失败, 合约接口返回errorMsg={}", transactionReceipt.getErrorMessage());
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
        logger.info("发送平台信息到招行链成功, platformIdOfIpaynow={}, transactionHash={}", platformIdOfIpaynow, transactionReceipt.getTransactionHash());
        return transactionReceipt;
    }

}
