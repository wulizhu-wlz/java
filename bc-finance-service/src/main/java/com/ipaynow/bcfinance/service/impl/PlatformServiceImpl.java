package com.ipaynow.bcfinance.service.impl;

import com.alibaba.fastjson.JSON;
import com.cryptape.cita.crypto.ECKeyPair;
import com.cryptape.cita.crypto.Keys;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.crypto.sm2.SM2KeyPair;
import com.cryptape.cita.crypto.sm2.SM2Keys;
import com.ipaynow.bcfinance.dao.BlockChainAccountMapper;
import com.ipaynow.bcfinance.dao.JoinMerchantMapper;
import com.ipaynow.bcfinance.domain.*;
import com.ipaynow.bcfinance.dto.AccountRespDto;
import com.ipaynow.bcfinance.dto.OpenMerchantDto;
import com.ipaynow.bcfinance.enums.*;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.manager.MerchantManager;
import com.ipaynow.bcfinance.service.AccountService;
import com.ipaynow.bcfinance.service.BlockChainAccountService;
import com.ipaynow.bcfinance.service.PlatformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hai on 2019/6/28.
 */

@Service
public class PlatformServiceImpl implements PlatformService {

    private static Logger logger = LoggerFactory.getLogger(PlatformServiceImpl.class);

    @Resource
    private JoinMerchantMapper joinMerchantMapper;

    @Resource
    private BlockChainAccountMapper blockChainAccountMapper;

    @Resource
    private AccountService accountService;

    @Autowired
    private MerchantManager merchantManager;
    @Autowired
    private BlockChainAccountService blockChainAccountService;
    // 平台ipaynowId --> 读写锁
    private ConcurrentHashMap<String, ReadWriteLock> locks = new ConcurrentHashMap<>();

    @Override
    public void openMerchant(OpenMerchantDto openMerchantDto, BlockChainAccount platform) throws BusinessException {
        JoinMerchantExample joinMerchantExample = new JoinMerchantExample();
        joinMerchantExample.createCriteria().andUserIdOfIPayNowEqualTo(openMerchantDto.getUserIdOfIPayNowOfDebtor());
        List<JoinMerchant> joinMerchantList = joinMerchantMapper.selectByExample(joinMerchantExample);
        if (joinMerchantList == null || joinMerchantList.size() == 0)
            throw new BusinessException(ExceptionEnum.NO_MERCHANT_ERROR);
        JoinMerchant joinMerchant = joinMerchantList.get(0);
        //查询商户区块链账户
        BlockChainAccount blockChainAccount = blockChainAccountService.queryOne(joinMerchant.getUserIdOfIPayNow(), AccountTypeEnum.MERCHANT);
        if (blockChainAccount == null) {
            logger.error("商户区块链账户信息不存在, merchantIpaynowId={}", joinMerchant.getUserIdOfIPayNow());
            throw new BusinessException(ExceptionEnum.NO_ACCOUNT_ERROR);
        }

        List<ChainTrans> updateChainTransList = new ArrayList<>();
        AccountRespDto accountOpenRespDto = accountService.openAccount(blockChainAccount.getAccAddress(), platform);
        ChainTrans chainTrans = new ChainTrans(openMerchantDto.getUserIdOfIPayNowOfDebtor(), ChainEnum.IPAYNOW.getCode(), accountOpenRespDto.getTxHash(), OperationTypeEnum.MERCHANT_OPEN.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
        updateChainTransList.add(chainTrans);

        AccountRespDto accountRespDto = accountService.addCooperation(blockChainAccount.getAccAddress(), platform);
        chainTrans = new ChainTrans(openMerchantDto.getUserIdOfIPayNowOfDebtor(), ChainEnum.IPAYNOW.getCode(), accountRespDto.getTxHash(), OperationTypeEnum.COOPERATION.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
        updateChainTransList.add(chainTrans);
        joinMerchant.setPlatformIdOfIPayNow(openMerchantDto.getUserIdOfIPayNowOfCreditor());
        joinMerchant.setStatus(StatusEnum.NORMAL.getCode());
        merchantManager.updateMerchantInfoForAccountOpen(updateChainTransList, joinMerchant);

    }

    /**
     * 添加平台账户
     * 假如已经有了账户，直接返回
     *
     * @param userIdOfIPayNowOfCreditor
     * @return
     * @throws BusinessException
     */
    @Override
    public BlockChainAccount addPlatform(String userIdOfIPayNowOfCreditor, String creditorName) throws BusinessException {
        //先直接查一下
        BlockChainAccount blockChainAccountP = blockChainAccountService.queryOne(userIdOfIPayNowOfCreditor, AccountTypeEnum.PLANTFORM);
        //平台已经存在区块链账户并且accAddress字段不为空，则直接返回
        if (blockChainAccountP != null && !StringUtils.isEmpty(blockChainAccountP.getAccAddress())) {
            return blockChainAccountP;
        }
        //走到这里有两种情况：
        // 1.不存在平台的区块链账户
        // 2.存在平台的区块链账户但accAddress字段为空(可能正在创建)
        locks.putIfAbsent(userIdOfIPayNowOfCreditor, new ReentrantReadWriteLock());
        //如果平台区块链账户存在但是accAddress为空(可能正在创建)，使用读锁再读一下
        ReadWriteLock readWriteLock = locks.get(userIdOfIPayNowOfCreditor);
        if (blockChainAccountP != null) {
            Lock readLock = readWriteLock.readLock();
            try {
                //读锁再读一下
                readLock.lock();
                blockChainAccountP = blockChainAccountService.queryOne(userIdOfIPayNowOfCreditor, AccountTypeEnum.PLANTFORM);
                if (!StringUtils.isEmpty(blockChainAccountP.getAccAddress())) {
                    return blockChainAccountP;
                }
                //读锁情况下再读到数据的accAddress为空，则可能数据有问题
                logger.error("平台数据已存在, 但是accAddress字段为空, blockChainAccountP={}", JSON.toJSONString(blockChainAccountP));
                throw new BusinessException(ExceptionEnum.BLOCK_CHAIN_ACCOUNT_P_INCOMPLETE_NOT_FOUND);
            } finally {
                readLock.unlock();
            }
        }
        Lock writeLock = readWriteLock.writeLock();
        try {
            //写锁，平台的区块链账户不存在，进行创建
            writeLock.lock();
            Integer idOfTbMerchantUser = blockChainAccountService.nextPlatformIdOfTbMerchantUser();
            BlockChainAccount blockChainAccount = new BlockChainAccount();
            blockChainAccount.setUserIdOfIPayNow(userIdOfIPayNowOfCreditor);
            blockChainAccount.setIdOfTbMerchantUser(idOfTbMerchantUser);
            blockChainAccount.setAccountType(AccountTypeEnum.PLANTFORM.getCode());
            blockChainAccount.setCreateTime(new Date());
            try {
                SM2KeyPair keyPair = new SM2().generateKeyPair();
                String publicKey = keyPair.getPublicKey().getXCoord().toString();
                blockChainAccount.setPrivateKey(keyPair.getPrivateKey().toString(16));
                blockChainAccount.setPublicKey(publicKey);
                blockChainAccount.setAddress(SM2Keys.getAddress(publicKey));
            } catch (Exception e) {
                logger.error("创建区块链账户失败 id=" + userIdOfIPayNowOfCreditor);
                throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
            }
            try {
                blockChainAccountMapper.insertSelective(blockChainAccount);
            } catch (Exception e) {
                logger.error("插入平台账户信息失败,尝试再次查询 blockChainAccount={}", JSON.toJSONString(blockChainAccount), e);
                BlockChainAccountExample example = new BlockChainAccountExample();
                example.createCriteria().andUserIdOfIPayNowEqualTo(userIdOfIPayNowOfCreditor);
                List<BlockChainAccount> list = blockChainAccountMapper.selectByExample(example);
                logger.info("插入平台账户信息失败, 再次查询结果, list={}", JSON.toJSONString(list));
                if (CollectionUtils.isEmpty(list)) {
                    throw new BusinessException(ExceptionEnum.NO_ACCOUNT_ERROR);
                }
                return list.get(0);
            }

            AccountRespDto respDto = accountService.account2Chain(blockChainAccount, creditorName, false);
            //保存到上链记录表
            ChainTrans chainTrans = new ChainTrans(blockChainAccount.getIdOfTbMerchantUser().toString(), ChainEnum.IPAYNOW.getCode(), respDto.getTxHash(), OperationTypeEnum.PLATFORM.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
            blockChainAccount.setAccAddress(respDto.getAccountAddr());
            merchantManager.updateAccountAndChainInfo(blockChainAccount, chainTrans);
            locks.remove(userIdOfIPayNowOfCreditor);
            return blockChainAccount;
        } finally {
            writeLock.unlock();
        }
    }


}
