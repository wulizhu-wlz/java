package com.ipaynow.bcfinance.service.impl;

import com.alibaba.fastjson.JSON;
import com.cryptape.cita.crypto.Credentials;
import com.cryptape.cita.crypto.sm2.SM2;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.protocol.http.HttpService;
import com.cryptape.cita.tx.RawTransactionManager;
import com.ipaynow.bcfinance.builder.MerchantPlatFormBusinessBuilder;
import com.ipaynow.bcfinance.chain.BlockChainConfigHolder;
import com.ipaynow.bcfinance.chain.contract.AssetStatementFactory;
import com.ipaynow.bcfinance.dao.MerchantPlatformBusinessMapper;
import com.ipaynow.bcfinance.domain.ChainTrans;
import com.ipaynow.bcfinance.domain.JoinMerchant;
import com.ipaynow.bcfinance.domain.MerchantPlatformBusiness;
import com.ipaynow.bcfinance.domain.MerchantPlatformBusinessExample;
import com.ipaynow.bcfinance.dto.MerchantStatisticsDto;
import com.ipaynow.bcfinance.enums.*;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.manager.MerchantManager;
import com.ipaynow.bcfinance.service.AssetStatementService;
import com.ipaynow.bcfinance.service.ContractService;
import com.ipaynow.bcfinance.service.MerchantService;
import com.ipaynow.bcfinance.thread.RunnableWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author ytw
 * @date 2019/7/1
 * description:
 */
@Slf4j
@Service
public class AssetStatementServiceImpl implements AssetStatementService {

    @Resource(name = "commonThreadPool")
    private ExecutorService executorService;
    @Autowired
    private MerchantPlatformBusinessMapper merchantPlatformBusinessMapper;
    @Autowired
    private ContractService contractService;
    @Autowired
    private BlockChainConfigHolder blockChainConfigHolder;
    @Autowired
    private MerchantManager merchantManager;
    @Autowired
    private MerchantService merchantService;


    @Override
    public void restoreAssetStatement(Date startDate, Date endDate) {
        MerchantPlatformBusinessExample example = new MerchantPlatformBusinessExample();
        MerchantPlatformBusinessExample.Criteria criteria = example.createCriteria()
                .andChainStatusEqualTo(ChainStatusEnum.CHAIN_DOWN.getCode());
        example.setOrderByClause("id DESC");
        if (startDate != null && endDate != null) {
            criteria.andCreatedTimeBetween(startDate, endDate);
        }
        List<MerchantPlatformBusiness> merchantPlatformBusinesses = merchantPlatformBusinessMapper.selectByExample(example);
        log.info("准备迁移商户平台统计数据, count={}", merchantPlatformBusinesses.size());
        for (MerchantPlatformBusiness merchantPlatformBusiness : merchantPlatformBusinesses) {
            executorService.submit(RunnableWrapper.wrap(() -> {
                sendIpayNowChain(merchantPlatformBusiness);
            }));
        }
    }

    @Override
    public List<MerchantPlatformBusiness> queryAssets(String userId, String date) {
        try {
            MerchantPlatformBusinessExample example = new MerchantPlatformBusinessExample();
            example.createCriteria().andUserIdOfIPayNowEqualTo(userId).andChainStatusEqualTo(ChainStatusEnum.CHAIN_UP.getCode()).andStatisticalDateEqualTo(date);
            List<MerchantPlatformBusiness> platformBusinessList = merchantPlatformBusinessMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(platformBusinessList)) {
                return platformBusinessList;
            }
            MerchantPlatformBusinessExample businessExample = new MerchantPlatformBusinessExample();
            businessExample.setOrderByClause("statistical_date DESC");
            businessExample.createCriteria().andUserIdOfIPayNowEqualTo(userId).andChainStatusEqualTo(ChainStatusEnum.CHAIN_UP.getCode()).
                    andStatisticalDateLessThan(date);
            List<MerchantPlatformBusiness> businessList = merchantPlatformBusinessMapper.selectByExample(businessExample);
            if (CollectionUtils.isEmpty(businessList)) {
                throw new BusinessException(ExceptionEnum.NO_ASSETS_ERROR);
            }
            List<MerchantPlatformBusiness> businesses = businessList.subList(0, 1);
            return businesses;
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public void processMerchantStatistic(MerchantStatisticsDto merchantStatisticsDto) {
        //保存到数据库
        MerchantPlatformBusiness merchantPlatformBusiness = MerchantPlatFormBusinessBuilder.convert2MerchantPlatformBusiness(merchantStatisticsDto);
        if (merchantPlatformBusiness == null) {
            log.error("商户平台统计数据为null, merchantStatisticsDto={}", JSON.toJSONString(merchantStatisticsDto));
        }
        addMerchantPlatformBusiness(merchantPlatformBusiness);
        //发送到链上
        executorService.submit(() -> {
            sendIpayNowChain(merchantPlatformBusiness);
        });
    }

    @Override
    public void addMerchantPlatformBusiness(MerchantPlatformBusiness merchantPlatformBusiness) {
        JoinMerchant joinMerchant = merchantService.queryMerchant(merchantPlatformBusiness.getIdOfTbMerchantUser());
        if (joinMerchant == null) {
            log.error("新增商户平台统计数据, 找不到商户信息. idOfTbMerchantUser={}", merchantPlatformBusiness.getIdOfTbMerchantUser());
            throw new BusinessException(ExceptionEnum.NO_MERCHANT_ERROR);
        }
        MerchantPlatformBusinessExample example = new MerchantPlatformBusinessExample();
        // 判断是否有重复数据
        example.createCriteria()
                .andIdOfTbMerchantUserEqualTo(joinMerchant.getIdOfTbMerchantUser())
                .andStatisticalDateEqualTo(merchantPlatformBusiness.getStatisticalDate())
                .andPlatformNameEqualTo(merchantPlatformBusiness.getPlatformName())
                .andStockAmountEqualTo(merchantPlatformBusiness.getStockAmount())
                .andSoldForSettlementAmountEqualTo(merchantPlatformBusiness.getSoldForSettlementAmount())
                .andSettledForPaymentAmountEqualTo(merchantPlatformBusiness.getSettledForPaymentAmount());
        List<MerchantPlatformBusiness> statisticList = merchantPlatformBusinessMapper.selectByExample(example);
        if (!statisticList.isEmpty()) {
            log.error("商户平台统计数据重复, merchantPlatformBusiness={}", JSON.toJSONString(merchantPlatformBusiness));
            throw new BusinessException(ExceptionEnum.ASSETMENT_DUPLICATE);
        }
        merchantPlatformBusiness.setUserIdOfIPayNow(joinMerchant.getUserIdOfIPayNow());
        merchantPlatformBusinessMapper.insertSelective(merchantPlatformBusiness);
    }

    @Override
    public void sendIpayNowChain(MerchantPlatformBusiness merchantPlatformBusiness) {
        log.info("发送商户平台统计数据上链, merchantPlatformBusiness={}", JSON.toJSONString(merchantPlatformBusiness));
        String contractAddress = contractService.queryContractAddress(ContractEnum.AssetStatementFactory.name());
        CITAj citAj = CITAj.build(new HttpService(blockChainConfigHolder.getIp()));
        RawTransactionManager rawTransactionManager = RawTransactionManager.createSM2Manager(citAj, new SM2().fromPrivateKey(blockChainConfigHolder.getIpaynowPrivateKey()));

        AssetStatementFactory assetStatementFactory = AssetStatementFactory.load(contractAddress, citAj, rawTransactionManager);
        try {
            long validUntilBlock = citAj.appBlockNumber().send().getBlockNumber().longValue() + 80;
            RemoteCall<TransactionReceipt> remoteCall = assetStatementFactory.createAssetStatement(BigInteger.valueOf(merchantPlatformBusiness.getId()), BigInteger.valueOf(merchantPlatformBusiness.getIdOfTbMerchantUser()), merchantPlatformBusiness.getPlatformName(), BigInteger.valueOf(Long.valueOf(merchantPlatformBusiness.getStockAmount())), BigInteger.valueOf(Long.valueOf(merchantPlatformBusiness.getSoldForSettlementAmount())), BigInteger.valueOf(Long.valueOf(merchantPlatformBusiness.getSettledForPaymentAmount())), merchantPlatformBusiness.getStockTurnOverRatio(), merchantPlatformBusiness.getReturnRate(), merchantPlatformBusiness.getStatisticalDate(), 9999999L, String.valueOf(System.nanoTime()), validUntilBlock, 2, BigInteger.ONE, "");
            TransactionReceipt transactionReceipt = remoteCall.send();
            if (log.isDebugEnabled()) {
                log.debug("transactionReceipt={}", JSON.toJSONString(transactionReceipt));
            }
            if (!StringUtils.isEmpty(transactionReceipt.getErrorMessage())) {
                log.error("【商户平台统计信息发送链上失败】，merchantPlatformBusiness={}, errorMsg={}", JSON.toJSONString(merchantPlatformBusiness), transactionReceipt.getErrorMessage());
                return;
            }
            List<AssetStatementFactory.DoCreateAssetStatementEventResponse> events = assetStatementFactory.getDoCreateAssetStatementEvents(transactionReceipt);
            AssetStatementFactory.DoCreateAssetStatementEventResponse doCreateAssetStatementEventResponse = events.get(0);
            log.info("【商户平台统计信息发送链上成功，更新数据库】，id={}", merchantPlatformBusiness.getId());
            //更新上链信息
            merchantPlatformBusiness.setTransHash(transactionReceipt.getTransactionHash());
            merchantPlatformBusiness.setChainStatus(ChainStatusEnum.CHAIN_UP.getCode());
            merchantPlatformBusiness.setAssetAddress(doCreateAssetStatementEventResponse.assetStatementAddr);
            //保存到上链记录表
            ChainTrans chainTrans = new ChainTrans(merchantPlatformBusiness.getId().toString(), ChainEnum.IPAYNOW.getCode(), transactionReceipt.getTransactionHash(), OperationTypeEnum.ASSET.getCode(), ChainStatusEnum.CHAIN_UP.getCode(), new Date());
            merchantManager.updateChainInfo(merchantPlatformBusiness, chainTrans);
        } catch (Exception e) {
            log.error("【商户统计信息发送到链上失败】，merchantPlatformBusiness={}", JSON.toJSONString(merchantPlatformBusiness), e);
        }
    }

}
