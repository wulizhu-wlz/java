package com.ipaynow.bcfinance.cmb.contract.helper;

import com.alibaba.fastjson.JSON;
import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tuples.generated.Tuple2;
import com.cryptape.cita.tuples.generated.Tuple4;
import com.cryptape.cita.tuples.generated.Tuple6;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.cmb.config.CmbChainConfigHolder;
import com.ipaynow.bcfinance.cmb.contract.Financial;

import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

/**
 * @author ytw
 * @date 2019/7/10
 * description:
 */
@Component
public class FinancialHelper {

    private final Logger logger = LoggerFactory.getLogger(FinancialHelper.class);

    @Resource
    private CmbChainConfigHolder cmbChainConfigHolder;


    public TransactionReceipt applyFinancing(String loanId, String creditorAccAddress, String debtorAccAddress, String transHash) {
        CITAj citAj = CITAj.build(new HttpService(cmbChainConfigHolder.getIp()));
        RawTransactionManager transactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(cmbChainConfigHolder.getIpaynowPrivateKey()));

        Financial financial = Financial.load(cmbChainConfigHolder.contract.getFinancialAddress(), citAj, transactionManager);
        TransactionReceipt transactionReceipt;
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = financial.applyFinancing(debtorAccAddress, creditorAccAddress, loanId, hexStringToByteArray(transHash),
                    200000L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.valueOf(cmbChainConfigHolder.getChainId()), "");
            transactionReceipt = remoteCall.send();
        } catch (Exception e) {
            logger.error("发送融资申请信息到Financial合约失败, loanId={}, transHash={}", loanId, transHash, e);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
        if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
            logger.error("发送融资申请信息到Financial合约失败, 合约接口返回errorMsg={}, loanId={}, transHash={}", transactionReceipt.getErrorMessage(), loanId, transHash);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERR_MSG);
        }
        logger.info("发送融资申请信息到Financial合约成功, loanId={}, transactionHash={}", loanId, transactionReceipt.getTransactionHash());
        return transactionReceipt;
    }

    public TransactionReceipt acceptFinance(String loanId, String transHash) {
        CITAj citAj = CITAj.build(new HttpService(cmbChainConfigHolder.getIp()));
        RawTransactionManager transactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(cmbChainConfigHolder.getIpaynowPrivateKey()));
        Financial financial = Financial.load(cmbChainConfigHolder.contract.getFinancialAddress(), citAj, transactionManager);
        TransactionReceipt transactionReceipt;
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = financial.accept(loanId, hexStringToByteArray(transHash),
                    200000L, String.valueOf(System.nanoTime()), validUntilBlock, 2,BigInteger.valueOf(cmbChainConfigHolder.getChainId()), "");
            transactionReceipt = remoteCall.send();
        } catch (Exception e) {
            logger.error("发送融资受理信息到Financial合约失败, loanId={}, transHash={}", e);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
        if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
            logger.error("发送融资受理信息到Financial合约失败, 合约接口返回errorMsg={}, loanId={}, transHash={}", transactionReceipt.getErrorMessage(), loanId, transHash);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERR_MSG);
        }
        logger.info("发送融资受理信息到Financial合约成功, loanId={}, transactionHash={}", loanId, transactionReceipt.getTransactionHash());
        return transactionReceipt;
    }

    public TransactionReceipt loan(String loanId, String transHash) {
        CITAj citAj = CITAj.build(new HttpService(cmbChainConfigHolder.getIp()));
        RawTransactionManager transactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(cmbChainConfigHolder.getIpaynowPrivateKey()));
        Financial financial = Financial.load(cmbChainConfigHolder.contract.getFinancialAddress(), citAj, transactionManager);
        TransactionReceipt transactionReceipt;
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = financial.loan(loanId, hexStringToByteArray(transHash),
                    200000L, String.valueOf(System.nanoTime()), validUntilBlock, 2,BigInteger.valueOf(cmbChainConfigHolder.getChainId()), "");
            transactionReceipt = remoteCall.send();
        } catch (Exception e) {
            logger.error("发送融资放款信息到Financial合约失败, loanId={}, transHash={}", JSON.toJSONString(loanId), transHash, e);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
        if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
            logger.error("发送融资放款信息到Financial合约失败, 合约接口返回errorMsg={}, loanId={}, transHash={}", transactionReceipt.getErrorMessage(), JSON.toJSONString(loanId), transHash);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERR_MSG);
        }
        logger.info("发送融资放款信息到Financial合约成功, loanId={}, transactionHash={}", loanId, transactionReceipt.getTransactionHash());
        return transactionReceipt;
    }

    public TransactionReceipt repay(String loanRepayId, String loanId, String creditorAccAddress, String debtorAccAddress, String transHash) {
        CITAj citAj = CITAj.build(new HttpService(cmbChainConfigHolder.getIp()));
        RawTransactionManager transactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(cmbChainConfigHolder.getIpaynowPrivateKey()));
        Financial financial = Financial.load(cmbChainConfigHolder.contract.getFinancialAddress(), citAj, transactionManager);
        TransactionReceipt transactionReceipt;
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = financial.repay(debtorAccAddress, creditorAccAddress, loanId, loanRepayId,
                    hexStringToByteArray(transHash), 200000L, String.valueOf(System.nanoTime()), validUntilBlock, 2,BigInteger.valueOf(cmbChainConfigHolder.getChainId()), "");
            transactionReceipt = remoteCall.send();
        } catch (Exception e) {
            logger.error("发送融资放款信息到Financial合约失败, loanRepayId={}, transHash={}", loanRepayId, transHash, e);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
        if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
            logger.error("发送融资放款信息到Financial合约失败, 合约接口返回errorMsg={}, loanRepayId={}, transHash={}", transactionReceipt.getErrorMessage(), loanRepayId, transHash);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERR_MSG);
        }
        logger.info("发送还款信息到Financial合约成功, loanRepayId={}, transactionHash={}", loanRepayId, transactionReceipt.getTransactionHash());
        return transactionReceipt;
    }

    public Tuple6<String, String, byte[], byte[], byte[], BigInteger> queryloan(String loanId) {
        CITAj citAj = CITAj.build(new HttpService(cmbChainConfigHolder.getIp()));
        RawTransactionManager transactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(cmbChainConfigHolder.getIpaynowPrivateKey()));
        Financial financial = Financial.load(cmbChainConfigHolder.contract.getFinancialAddress(), citAj, transactionManager);
        try {
            RemoteCall<Tuple6<String, String, byte[], byte[], byte[], BigInteger>> remoteCall = financial.queryloan(loanId);
            Tuple6<String, String, byte[], byte[], byte[], BigInteger> result = remoteCall.send();
            return result;
        } catch (Exception e) {
            logger.error("Financial合约查询融资信息失败, loanId={}", loanId, e);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
    }

    public Tuple4<String, String, String, byte[]> queryRepay(String repayId) {
        CITAj citAj = CITAj.build(new HttpService(cmbChainConfigHolder.getIp()));
        RawTransactionManager transactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(cmbChainConfigHolder.getIpaynowPrivateKey()));
        Financial financial = Financial.load(cmbChainConfigHolder.contract.getFinancialAddress(), citAj, transactionManager);
        try {
            RemoteCall<Tuple4<String, String, String, byte[]>> remoteCall = financial.queryRepay(repayId);
            Tuple4<String, String, String, byte[]> result = remoteCall.send();
            return result;
        } catch (Exception e) {
            logger.error("Financial合约查询还款信息失败, repayId={}", repayId, e);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
    }


    public Tuple2<List<byte[]>, List<byte[]>> queryRepayByLoanId(String loanId) {
        CITAj citAj = CITAj.build(new HttpService(cmbChainConfigHolder.getIp()));
        RawTransactionManager transactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(cmbChainConfigHolder.getIpaynowPrivateKey()));
        Financial financial = Financial.load(cmbChainConfigHolder.contract.getFinancialAddress(), citAj, transactionManager);
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<Tuple2<List<byte[]>, List<byte[]>>> remoteCall = financial.queryRepayByLoanId(loanId);
            return remoteCall.send();
        } catch (Exception e) {
            logger.error("Financial合约查询融资还款记录失败, loanId={}", loanId, e);
            throw new BusinessException(ExceptionEnum.CMB_CHAIN_ERROR);
        }
    }

    /**
     * 16进制表示的字符串转换为字节数组
     *
     * @param hexString 16进制表示的字符串
     * @return byte[] 字节数组
     */
    public static byte[] hexStringToByteArray(String hexString) {
        if (hexString.length() == 66) {
            hexString = hexString.substring(2);
        }
        int len = hexString.length();
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
                    .digit(hexString.charAt(i + 1), 16));
        }
        return bytes;
    }

}
