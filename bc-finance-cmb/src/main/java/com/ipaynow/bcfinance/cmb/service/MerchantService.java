package com.ipaynow.bcfinance.cmb.service;

import com.alibaba.fastjson.JSON;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.ipaynow.bcfinance.cmb.contract.helper.MerchantHelper;
import com.ipaynow.bcfinance.dao.JoinMerchantMapper;
import com.ipaynow.bcfinance.domain.BlockChainAccount;
import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.JoinMerchant;
import com.ipaynow.bcfinance.enums.*;
import com.ipaynow.bcfinance.thread.RunnableWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ytw
 * @date 2019/7/9
 * description:
 */
@Service
public class MerchantService {

    private Logger logger = LoggerFactory.getLogger(MerchantService.class);

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;
    @Resource
    private JoinMerchantMapper joinMerchantMapper;
    @Resource
    private ChainTransService chainTransService;
    @Resource
    private BlockChainAccountService blockChainAccountService;
    @Resource
    private MerchantHelper merchantHelper;


    public void sendMerchant2ChainTask(Date startTime, Date endTime) {
        //查询可以发送到招行链的商户
        List<JoinMerchant> joinMerchants = joinMerchantMapper.selectCmbSendableList(StatusEnum.NORMAL.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), ChainEnum.CMB.getCode(), OperationTypeEnum.MERCHANT_OPEN.getCode(), startTime, endTime);
        logger.info("发送商户信息到招行链，本次待发送商户信息总数={}", joinMerchants.size());
        for (JoinMerchant joinMerchant : joinMerchants) {
            threadPoolExecutor.submit(RunnableWrapper.wrap(() -> {
                sendMerchant2Chain(joinMerchant);
            }));
        }
    }

    private void sendMerchant2Chain(JoinMerchant joinMerchant) {
        if (joinMerchant.getPlatformIdOfIPayNow() == null) {
            logger.error("发送商户信息到招行链失败, 商户平台id为null, joinMerchant={}", JSON.toJSONString(joinMerchant));
            return;
        }
        //查询商户所属平台的区块链账户
        BlockChainAccount blockChainAccountP = blockChainAccountService.queryOne(joinMerchant.getPlatformIdOfIPayNow(), AccountTypeEnum.PLANTFORM);
        if (blockChainAccountP == null) {
            logger.error("发送商户信息到招行链失败, 找不到商户所属平台的BlockChainAccount信息, joinMerchant={}", JSON.toJSONString(joinMerchant));
            return;
        }
        //查询商户的区块链账户
        BlockChainAccount blockChainAccountM = blockChainAccountService.queryOne(joinMerchant.getUserIdOfIPayNow(), AccountTypeEnum.MERCHANT);
        if (blockChainAccountM == null) {
            logger.error("发送商户信息到招行链失败, 找不到商户的BlockChainAccount信息, joinMerchant={}", JSON.toJSONString(joinMerchant));
            return;
        }
        //发送到招行链
        TransactionReceipt transactionReceipt = merchantHelper.add(joinMerchant.getUserIdOfIPayNow(), blockChainAccountM.getAccAddress(), blockChainAccountP.getUserIdOfIPayNow());
        //保存上链交易信息
        ChainTrans chainTrans = new ChainTrans(joinMerchant.getUserIdOfIPayNow(), ChainEnum.CMB.getCode(), transactionReceipt.getTransactionHash(), OperationTypeEnum.MERCHANT_OPEN.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
        chainTransService.insert(chainTrans);
    }


    /**
     * 查询平台信息发送到Merchant合约
     *
     * @param startTime
     * @param endTime
     */
    public void sendPlatform2ChainTask(Date startTime, Date endTime) {
        List<BlockChainAccount> blockChainAccounts = blockChainAccountService.queryList(AccountTypeEnum.PLANTFORM, startTime, endTime);
        //过滤掉已经发送过Merchant合约的平台数据
        blockChainAccounts.removeIf((blockChainAccount) -> {
            return chainTransService.queryOne(blockChainAccount.getUserIdOfIPayNow(), OperationTypeEnum.PLATFORM, ChainEnum.CMB, ChainStatusEnum.CHAIN_UP) != null;
        });
        logger.info("查询平台信息发送到Merchant合约, 本次查询到可发送的平台信息数={}", blockChainAccounts.size());
        for (BlockChainAccount blockChainAccount : blockChainAccounts) {
            threadPoolExecutor.submit(RunnableWrapper.wrap(() -> {
                sendPlatform2Chain(blockChainAccount);
            }));
        }
    }

    public void sendPlatform2Chain(BlockChainAccount blockChainAccount) {
        TransactionReceipt transactionReceipt = merchantHelper.addPlatform(blockChainAccount.getUserIdOfIPayNow(), blockChainAccount.getAccAddress());
        //保存上链交易信息
        ChainTrans chainTrans = new ChainTrans(blockChainAccount.getUserIdOfIPayNow(), ChainEnum.CMB.getCode(), transactionReceipt.getTransactionHash(), OperationTypeEnum.PLATFORM.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
        chainTransService.insert(chainTrans);
    }


}
