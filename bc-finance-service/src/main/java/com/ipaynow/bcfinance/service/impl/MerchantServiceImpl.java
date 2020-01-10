package com.ipaynow.bcfinance.service.impl;

import com.alibaba.fastjson.JSON;
import com.cryptape.cita.crypto.ECKeyPair;
import com.cryptape.cita.crypto.Keys;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.crypto.sm2.SM2KeyPair;
import com.cryptape.cita.crypto.sm2.SM2Keys;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ipaynow.bcfinance.dao.BlockChainAccountMapper;
import com.ipaynow.bcfinance.dao.JoinMerchantMapper;
import com.ipaynow.bcfinance.domain.*;
import com.ipaynow.bcfinance.dto.AccountRespDto;
import com.ipaynow.bcfinance.dto.NewMerchantDto;
import com.ipaynow.bcfinance.enums.*;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.manager.MerchantManager;
import com.ipaynow.bcfinance.service.AccountService;
import com.ipaynow.bcfinance.service.LoanCreditService;
import com.ipaynow.bcfinance.service.MerchantService;
import com.ipaynow.bcfinance.thread.RunnableWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * Created by hai on 2019/6/25.
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    private static Logger logger = LoggerFactory.getLogger(MerchantServiceImpl.class);


    @Resource
    private JoinMerchantMapper joinMerchantMapper;
    @Resource
    private BlockChainAccountMapper blockChainAccountMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private LoanCreditService loanCreditService;
    @Resource
    private MerchantManager merchantManager;
    @Resource(name = "commonThreadPool")
    private ExecutorService executorService;

    @Override
    public void addMerchant(NewMerchantDto merchantDto) throws BusinessException {
        boolean isModify = false;
        JoinMerchant joinMerchant = null;
        JoinMerchantExample joinMerchantExample = new JoinMerchantExample();
        joinMerchantExample.createCriteria().andUserIdOfIPayNowEqualTo(merchantDto.getUioipn());
        List<JoinMerchant> joinMerchantList = joinMerchantMapper.selectByExample(joinMerchantExample);
        if (joinMerchantList != null && joinMerchantList.size() > 0) {
            joinMerchant = joinMerchantList.get(0);
        }
        if (joinMerchant != null && !joinMerchant.getMchName().equals(merchantDto.getMn())) {
            isModify = true;
        }
        joinMerchant = saveOrUpdateJoinMerchant(merchantDto, joinMerchant);
        BlockChainAccount blockChainAccount;

        BlockChainAccountExample blockChainAccountExample = new BlockChainAccountExample();
        blockChainAccountExample.createCriteria().andIdOfTbMerchantUserEqualTo(merchantDto.getIotmu());
        List<BlockChainAccount> blockChainAccountList = blockChainAccountMapper.selectByExample(blockChainAccountExample);
        if (blockChainAccountList == null || blockChainAccountList.size() == 0) {
            blockChainAccount = new BlockChainAccount();
            blockChainAccount.setUserIdOfIPayNow(merchantDto.getUioipn());
            blockChainAccount.setIdOfTbMerchantUser(merchantDto.getIotmu());
            blockChainAccount.setAccountType(AccountTypeEnum.MERCHANT.getCode());
            blockChainAccount.setCreateTime(new Date());
            SM2 sm2 = new SM2();
            SM2KeyPair keyPair;
            try {
                keyPair = sm2.generateKeyPair();
                String publicKey = keyPair.getPublicKey().getXCoord().toString();
                blockChainAccount.setPrivateKey(keyPair.getPrivateKey().toString(16));
                blockChainAccount.setPublicKey(publicKey);
                blockChainAccount.setAddress(SM2Keys.getAddress(publicKey));
            } catch (Exception e) {
                logger.error("创建区块链账户失败 id={}", merchantDto.getIotmu(), e);
                throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
            }
            blockChainAccountMapper.insertSelective(blockChainAccount);

        } else {
            blockChainAccount = blockChainAccountList.get(0);
        }
        AccountRespDto respDto = accountService.account2Chain(blockChainAccount, joinMerchant.getMchName(), isModify);
        //保存到上链记录表
        OperationTypeEnum operationType = OperationTypeEnum.MERCHANT_REG;
        if (isModify)
            operationType = OperationTypeEnum.MERCHANT_MODIFY;
        ChainTrans chainTrans = new ChainTrans(merchantDto.getUioipn(), ChainEnum.IPAYNOW.getCode(), respDto.getTxHash(), operationType.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
        blockChainAccount.setAccAddress(respDto.getAccountAddr());
        joinMerchant.setChainStatus(ChainStatusEnum.CHAIN_UP.getCode());
        merchantManager.updateMerchantInfoForAccountCreate(blockChainAccount, chainTrans, joinMerchant);
    }


    private JoinMerchant saveOrUpdateJoinMerchant(NewMerchantDto merchantDto, JoinMerchant joinMerchant) throws BusinessException {
        if (joinMerchant != null) {
            if (joinMerchant.getMchName().equals(merchantDto.getMn())) {
                logger.error("商户已创建，userIdOfIPayNow={}", merchantDto.getUioipn());
                throw new BusinessException(ExceptionEnum.MERCHANT_EXISTED);
            }
            //商户名称不一样，说明，商户做了名称变更
            joinMerchant.setMchName(merchantDto.getMn());
            joinMerchantMapper.updateByPrimaryKeySelective(joinMerchant);
        } else {
            joinMerchant = new JoinMerchant();
            joinMerchant.setIdOfTbMerchantUser(merchantDto.getIotmu());
            joinMerchant.setMchName(merchantDto.getMn());
            joinMerchant.setUserIdOfIPayNow(merchantDto.getUioipn());
            joinMerchant.setCreatedTime(new Date());
            int result = joinMerchantMapper.insertSelective(joinMerchant);
            if (result != 1)
                throw new BusinessException(ExceptionEnum.DATA_ERROR);
        }
        return joinMerchant;
    }

    @Override
    public JoinMerchant queryMerchant(String userIdOfIpayNow) throws BusinessException {
        JoinMerchantExample example = new JoinMerchantExample();
        example.createCriteria().andUserIdOfIPayNowEqualTo(userIdOfIpayNow);
        List<JoinMerchant> merchantList = joinMerchantMapper.selectByExample(example);
        return merchantList.get(0);
    }

    @Override
    public PageInfo<JoinMerchant> getJoinUserList(Integer idOfTbMerchantUser, String userIdOfIPayNow, String mchName, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<JoinMerchant> merchantList = joinMerchantMapper.selectByMerchantUserId(idOfTbMerchantUser, userIdOfIPayNow, mchName);
        PageInfo<JoinMerchant> pageInfo = new PageInfo<>(merchantList);
        return pageInfo;
    }

    @Override
    public List<JoinMerchant> queryByDbtorIdAndCreditId(String debtorId, String creditId) {
        JoinMerchantExample example = new JoinMerchantExample();
        example.createCriteria().andStatusEqualTo(StatusEnum.NORMAL.getCode()).andUserIdOfIPayNowEqualTo(debtorId).andPlatformIdOfIPayNowEqualTo(creditId);
        return joinMerchantMapper.selectByExample(example);
    }


    @Override
    public JoinMerchant queryMerchant(Integer idOfTbMerchantUser) throws BusinessException {
        JoinMerchantExample example = new JoinMerchantExample();
        example.createCriteria().andIdOfTbMerchantUserEqualTo(idOfTbMerchantUser);
        List<JoinMerchant> merchantList = joinMerchantMapper.selectByExample(example);
        return merchantList.get(0);
    }

    /**
     * 数据迁移
     */
    @Override
    public void restoreHistoryMerchant(Date startTime, Date endTime) {

        JoinMerchantExample joinMerchantExample = new JoinMerchantExample();
        JoinMerchantExample.Criteria criteria = joinMerchantExample.createCriteria()
                .andChainStatusEqualTo(ChainStatusEnum.CHAIN_DOWN.getCode());
        if (startTime != null && endTime != null) {
            criteria.andCreatedTimeBetween(startTime, endTime);
        }
        List<JoinMerchant> joinMerchants = joinMerchantMapper.selectByExample(joinMerchantExample);
        logger.info("准备迁移商户数据, count={}", joinMerchants.size());
        for (JoinMerchant joinMerchant : joinMerchants) {
            executorService.submit(RunnableWrapper.wrap(() -> {
                doRestoreMerchant(joinMerchant);
            }));
        }
    }

    private void doRestoreMerchant(JoinMerchant joinMerchant) {
        logger.info("开始迁移商户数据, idOfTbMerchantUser={}", joinMerchant.getIdOfTbMerchantUser());
        //避免添加重复数据
        BlockChainAccountExample blockChainAccountExample = new BlockChainAccountExample();
        blockChainAccountExample.createCriteria()
                .andUserIdOfIPayNowEqualTo(joinMerchant.getUserIdOfIPayNow())
                .andIdOfTbMerchantUserEqualTo(joinMerchant.getIdOfTbMerchantUser())
                .andAccountTypeEqualTo(AccountTypeEnum.MERCHANT.getCode());
        List<BlockChainAccount> blockChainAccounts = blockChainAccountMapper.selectByExample(blockChainAccountExample);
        if (!blockChainAccounts.isEmpty()) {
            logger.info("迁移商户数据中, 已存在BlockChainAccount, 跳过", JSON.toJSONString(blockChainAccounts));
            return;
        }
        BlockChainAccount blockChainAccount = new BlockChainAccount();
        blockChainAccount.setIdOfTbMerchantUser(joinMerchant.getIdOfTbMerchantUser());
        blockChainAccount.setUserIdOfIPayNow(joinMerchant.getUserIdOfIPayNow());
        blockChainAccount.setAccountType(AccountTypeEnum.MERCHANT.getCode());
        blockChainAccount.setCreateTime(new Date());
        try {
            SM2KeyPair keyPair = new SM2().generateKeyPair();
            String publicKey = keyPair.getPublicKey().getXCoord().toString();
            blockChainAccount.setPrivateKey(keyPair.getPrivateKey().toString(16));
            blockChainAccount.setPublicKey(publicKey);
            blockChainAccount.setAddress(SM2Keys.getAddress(publicKey));
        } catch (Exception e) {
            logger.error("迁移商户数据中, 创建区块链账户失败, userIdOfIPayNow={}", joinMerchant.getUserIdOfIPayNow(), e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
        //发送到链上
        AccountRespDto accountRespDto = accountService.account2Chain(blockChainAccount, joinMerchant.getMchName(), false);
        //保存到上链记录表
        ChainTrans chainTrans = new ChainTrans(joinMerchant.getUserIdOfIPayNow(), ChainEnum.IPAYNOW.getCode(), accountRespDto.getTxHash(), OperationTypeEnum.MERCHANT_REG.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
        blockChainAccount.setAccAddress(accountRespDto.getAccountAddr());
        joinMerchant.setChainStatus(ChainStatusEnum.CHAIN_UP.getCode());
        merchantManager.restoreMerchant(blockChainAccount, chainTrans, joinMerchant);
        logger.info("迁移商户数据成功, idOfTbMerchantUser={}", joinMerchant.getIdOfTbMerchantUser());
    }

}
