package com.ipaynow.bcfinance.service.impl;

import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.chain.contract.Account;
import com.ipaynow.bcfinance.chain.contract.AccountFactory;
import com.ipaynow.bcfinance.chain.contract.Cooperation;
import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.dto.AccountRespDto;
import com.ipaynow.bcfinance.enums.ContractEnum;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.service.AccountService;
import com.ipaynow.bcfinance.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by hai on 2019/6/28.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private BlockChainConfigHolder blockChainConfigHolder;

    @Autowired
    private ContractService contractService;

    @Override
    public AccountRespDto account2Chain(BlockChainAccount blockChainAccount, String accountName,boolean isModify) throws BusinessException {
        AccountRespDto respDto = new AccountRespDto();
        String contractAddress = contractService.queryContractAddress(ContractEnum.AccountFactory.name());
        CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
        RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(blockChainAccount.getPrivateKey()));
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall;
            TransactionReceipt transactionReceipt;
            if (!isModify) {
                AccountFactory accountFactory = AccountFactory.load(contractAddress, citAj, rawTransactionManager);
                remoteCall = accountFactory.createAccount(blockChainAccount.getUserIdOfIPayNow(), new BigInteger(blockChainAccount.getAccountType().toString()), accountName, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
                transactionReceipt = remoteCall.send();
                if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
                    logger.error("商户信息上链失败 userIdOfIPayNow={},errorMessage={}", blockChainAccount.getUserIdOfIPayNow(), transactionReceipt.getErrorMessage());
                    throw new BusinessException(ExceptionEnum.SEND_CHAIN_ERROR);
                }
                List<AccountFactory.AccountContractCreatedEventResponse> createdEventResponses = accountFactory.getAccountContractCreatedEvents(transactionReceipt);
                AccountFactory.AccountContractCreatedEventResponse createdEventResponse = createdEventResponses.get(0);
                respDto.setAccountAddr(createdEventResponse.accountAddr);
            } else{
                Account account = Account.load(blockChainAccount.getAccAddress(),citAj,rawTransactionManager);
                remoteCall = account.setAccName(accountName,9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
                transactionReceipt = remoteCall.send();
                if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
                    logger.error("商户信息上链失败 userIdOfIPayNow={},errorMessage={}", blockChainAccount.getUserIdOfIPayNow(), transactionReceipt.getErrorMessage());
                    throw new BusinessException(ExceptionEnum.SEND_CHAIN_ERROR);
                }
                respDto.setAccountAddr(blockChainAccount.getAccAddress());
            }
            respDto.setTxHash(transactionReceipt.getTransactionHash());
            logger.info("商户信息上链成功,userIdOfIPayNow={},respDto={}", blockChainAccount.getUserIdOfIPayNow(), respDto);
            return respDto;
        } catch (Exception e) {
            logger.error("商户信息上链失败 userIdOfIPayNow={}", blockChainAccount.getUserIdOfIPayNow(), e);
            throw new BusinessException(ExceptionEnum.SEND_CHAIN_ERROR);
        }
    }


    @Override
    public AccountRespDto openAccount(String accountAddr, BlockChainAccount platformAccount) throws BusinessException {
        String contractAddress = contractService.queryContractAddress(ContractEnum.AccountFactory.name());
        CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
        RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(platformAccount.getPrivateKey()));
        AccountFactory accountFactory = AccountFactory.load(contractAddress, citAj, rawTransactionManager);
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = accountFactory.openAccount(accountAddr, platformAccount.getAccAddress(), 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
            TransactionReceipt transactionReceipt = remoteCall.send();
            if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
                logger.error("商户开通上链失败 accountAddr={},errorMessage={}", accountAddr, transactionReceipt.getErrorMessage());
                throw new BusinessException(ExceptionEnum.SEND_CHAIN_ERROR);
            }
            AccountRespDto respDto = new AccountRespDto();
            respDto.setAccountAddr(accountAddr);
            respDto.setTxHash(transactionReceipt.getTransactionHash());
            logger.info("商户开通上链成功,accountAddr={},platformAddr={},respDto={}", accountAddr,platformAccount.getAccAddress(), respDto);
            return respDto;
        } catch (Exception e) {
            logger.error("商户开通上链失败 accountAddr={},platformAddr={}", accountAddr, platformAccount.getAccAddress(), e);
            throw new BusinessException(ExceptionEnum.SEND_CHAIN_ERROR);
        }
    }


    @Override
    public AccountRespDto addCooperation(String accountAddr, BlockChainAccount platformAccount) throws BusinessException {
        String contractAddress = contractService.queryContractAddress(ContractEnum.Cooperation.name());
        CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
        RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(platformAccount.getPrivateKey()));
        Cooperation cooperation = Cooperation.load(contractAddress, citAj, rawTransactionManager);
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = cooperation.addCooperation(platformAccount.getAccAddress(), accountAddr, 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
            TransactionReceipt transactionReceipt = remoteCall.send();
            if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
                logger.error("建立合作关系上链失败 accountAddr={},errorMessage={}", accountAddr, transactionReceipt.getErrorMessage());
                throw new BusinessException(ExceptionEnum.SEND_CHAIN_ERROR);
            }
            AccountRespDto respDto = new AccountRespDto();
            respDto.setAccountAddr(accountAddr);
            respDto.setTxHash(transactionReceipt.getTransactionHash());
            logger.info("建立合作关系上链成功,accountAddr={},respDto={}", accountAddr, respDto);
            return respDto;
        } catch (Exception e) {
            logger.error("建立合作关系上链失败 accountAddr={}", accountAddr);
            throw new BusinessException(ExceptionEnum.SEND_CHAIN_ERROR);
        }
    }


}
