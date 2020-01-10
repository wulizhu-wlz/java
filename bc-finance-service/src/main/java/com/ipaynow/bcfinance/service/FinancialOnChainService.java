package com.ipaynow.bcfinance.service;


import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.chain.contract.FinanceRepayToken;
import com.ipaynow.bcfinance.chain.contract.FinanceTrade;
import com.ipaynow.bcfinance.chain.contract.FinanceTradeFactory;
import com.ipaynow.bcfinance.domain.LoanCredit;
import com.ipaynow.bcfinance.dto.RepayRespDto;
import com.ipaynow.bcfinance.enums.ContractEnum;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @author ytw
 * @date 2019/6/19
 * description:
 */
@Service
public class FinancialOnChainService {

    private final static Logger logger = LogManager.getLogger(FinancialOnChainService.class);

    @Autowired
    private BlockChainConfigHolder blockChainConfigHolder;

    @Autowired
    private ContractService contractService;

    private String tradeFactoryName = "FinanceTradeFactory";


    /**
     * 融资申请
     *
     * @param financeCreditId 融资id
     * @param creditorId      债权人id
     * @param debtorId        债务人id
     * @return
     */
    public String apply(List<BigInteger> assestList, BigInteger financeCreditId, String creditorId, String debtorId, String debtorKey) {
        try {
            logger.info("融资申请上链开始,financeCreditId:{},creditorId:{},debtorId:{}", financeCreditId, creditorId, debtorId);
            String financeTradeFactoryAddress = contractService.queryContractAddress(ContractEnum.FinanceTradeFactory.name());
            CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
            RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(debtorKey));

            FinanceTradeFactory financeTradeFactory = FinanceTradeFactory.load(financeTradeFactoryAddress, citAj, rawTransactionManager);
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = financeTradeFactory.createFinanceTrade(assestList, financeCreditId, creditorId, debtorId, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
            TransactionReceipt transactionReceipt = remoteCall.send();
            if (StringUtils.isNotEmpty(transactionReceipt.getErrorMessage())) {
                logger.error("融资申请上链失败，financeCreditId:{},creditorId:{},debtorId:{}，errorMsg:{}", financeCreditId, creditorId, debtorId, transactionReceipt.getErrorMessage());
                throw new BusinessException(ExceptionEnum.CHAIN_ERROR);
            }
            return transactionReceipt.getTransactionHash();
        } catch (BusinessException e) {
            logger.error("融资申请上链失败", e);
            throw e;
        } catch (Exception e) {
            logger.error("融资申请上链失败", e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 融资受理
     *
     * @param financeCreditId 融资id
     * @return
     */
    public String accept(BigInteger financeCreditId, String creditKey) {
        try {
            logger.info("融资受理上链开始,financeCreditId:{}", financeCreditId);
            String financeTradeFactoryAddress = contractService.queryContractAddress(ContractEnum.FinanceTradeFactory.name());
            CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
            RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(creditKey));

            FinanceTradeFactory financeTradeFactory = FinanceTradeFactory.load(financeTradeFactoryAddress, citAj, rawTransactionManager);
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<String> trade = financeTradeFactory.getFinanceTrade(financeCreditId);
            FinanceTrade financeTrade = FinanceTrade.load(trade.send(), citAj, rawTransactionManager);
            RemoteCall<TransactionReceipt> accept = financeTrade.accept(financeCreditId, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
            TransactionReceipt receipt = accept.send();
            if (StringUtils.isNotEmpty(receipt.getErrorMessage())) {
                logger.error("融资受理返回errMsg不为空，上链失败");
                throw new BusinessException(ExceptionEnum.CHAIN_ERROR);
            }
            return receipt.getTransactionHash();
        } catch (BusinessException e) {
            logger.error("融资受理上链失败", e);
            throw e;
        } catch (Exception e) {
            logger.error("融资受理上链失败", e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }

    }

    /**
     * 放款
     *
     * @param financeCreditId 融资id
     * @param amount          金额
     * @return
     */
    public String loan(BigInteger financeCreditId, BigInteger amount, String creditKey) {
        try {
            logger.info("放款上链开始,financeCreditId:{},amount:{}", financeCreditId, amount);
            String financeTradeFactoryAddress = contractService.queryContractAddress(ContractEnum.FinanceTradeFactory.name());
            CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
            RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(creditKey));

            FinanceTradeFactory financeTradeFactory = FinanceTradeFactory.load(financeTradeFactoryAddress, citAj, rawTransactionManager);
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<String> trade = financeTradeFactory.getFinanceTrade(financeCreditId);
            FinanceTrade financeTrade = FinanceTrade.load(trade.send(), citAj, rawTransactionManager);
            RemoteCall<TransactionReceipt> accept = financeTrade.loan(financeCreditId, amount, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
            TransactionReceipt receipt = accept.send();
            if (StringUtils.isNotEmpty(receipt.getErrorMessage())) {
                logger.error("放款上链返回errMsg不为空，上链失败");
                throw new BusinessException(ExceptionEnum.CHAIN_ERROR);
            }
            return receipt.getTransactionHash();
        } catch (BusinessException e) {
            logger.error("放款上链失败", e);
            throw e;
        } catch (Exception e) {
            logger.error("放款上链失败", e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 还款
     *
     * @param financeCreditId   融资id
     * @param repayId           还款id
     * @param amount            还款金额
     * @param repayPrinciple    还款本金
     * @param financeRateAmount 还款利息
     * @param status            状态
     * @param creditorId        债权人id
     * @param debtorId          债务人id
     * @return
     */
    public RepayRespDto repay(BigInteger financeCreditId, BigInteger repayId, BigInteger amount, BigInteger repayPrinciple, BigInteger financeRateAmount, BigInteger status, String creditorId, String debtorId, String debtorKey) {
        try {
            logger.info("还款上链开始,financeCreditId:{},repayId:{},amount:{},creditorId:{},debtorId", financeCreditId, repayId, amount, creditorId, debtorId);
            String financeTradeFactoryAddress = contractService.queryContractAddress(ContractEnum.FinanceTradeFactory.name());
            CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
            RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(debtorKey));

            FinanceTradeFactory financeTradeFactory = FinanceTradeFactory.load(financeTradeFactoryAddress, citAj, rawTransactionManager);
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<String> trade = financeTradeFactory.getFinanceTrade(financeCreditId);
            FinanceTrade financeTrade = FinanceTrade.load(trade.send(), citAj, rawTransactionManager);
            RemoteCall<TransactionReceipt> accept = financeTrade.repay(financeCreditId, repayId, amount, repayPrinciple, financeRateAmount, status, creditorId, debtorId, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
            TransactionReceipt receipt = accept.send();
            if (StringUtils.isNotEmpty(receipt.getErrorMessage())) {
                logger.error("还款上链返回的errMsg不为空，上链失败,repayId:{},errMsg:{}", repayId, receipt.getErrorMessage());
                throw new BusinessException(ExceptionEnum.CHAIN_ERROR);
            }
            String repayToken = financeTrade.getFinanceRepayToken().send();
            FinanceRepayToken financeRepayToken = FinanceRepayToken.load(repayToken, citAj, rawTransactionManager);
            List<FinanceRepayToken.DoCreateRepayRecordEventResponse> recordEvents = financeRepayToken.getDoCreateRepayRecordEvents(receipt);
            String recordAddress = recordEvents.get(0).recordAddress;

            RepayRespDto respDto = new RepayRespDto();
            respDto.setRecordAddress(recordAddress);
            respDto.setTxHash(receipt.getTransactionHash());
            return respDto;
        } catch (BusinessException e) {
            logger.error("还款上链失败", e);
            throw e;
        } catch (Exception e) {
            logger.error("还款上链失败", e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

}
