package com.ipaynow.bcfinance.manager;

import com.ipaynow.bcfinance.dao.*;
import com.ipaynow.bcfinance.domain.*;
import com.ipaynow.bcfinance.dto.RepayRespDto;
import com.ipaynow.bcfinance.enums.*;
import com.ipaynow.bcfinance.service.ChainTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author ytw
 * @date 2019/6/28
 * description: 融资相关事物操作
 */
@Component
public class FinanceManager {

    @Autowired
    private MerchantPlatformBusinessMapper merchantPlatformBusinessMapper;
    @Autowired
    private ChainTransMapper chainTransMapper;

    @Autowired
    private LoanCreditMapper loanCreditMapper;

    @Autowired
    private LoanRepayMapper loanRepayMapper;

    @Autowired
    private ChainTransService chainTransService;


    @Transactional
    public void saveLoanInfo(ChainTrans chainTrans, LoanCredit loanCredit) {
        chainTransMapper.insertSelective(chainTrans);
        loanCreditMapper.insertSelective(loanCredit);
    }

    @Transactional
    public void saveRepayInfo(LoanRepay loanRepay, ChainTrans chainTrans, boolean isHistory) {
        //如果是不是历史数据插入还款记录，否则不操作还款记录
        if (!isHistory) {
            loanRepayMapper.insertSelective(loanRepay);
        }
        ChainTransExample example = new ChainTransExample();
        example.createCriteria().andOperationTypeEqualTo(OperationTypeEnum.REPAY.getCode()).andBuinessIdEqualTo(String.valueOf(loanRepay.getId())).andChainIdEqualTo(ChainEnum.IPAYNOW.getCode());
        List<ChainTrans> repay = chainTransMapper.selectByExample(example);
        //trans不为空则插入数据，否则不做操作
        if (CollectionUtils.isEmpty(repay)) {
            chainTransMapper.insertSelective(chainTrans);
        }
    }

    @Transactional
    public void updateLoanInfo(ChainTrans chainTrans, String transHash, OperationTypeEnum operationTypeEnum, CreditStatusEnum creditStatusEnum, long loanId) {
        chainTrans.setChainStatus(ChainStatusEnum.CHAIN_UP.getCode());
        chainTrans.setTransHash(transHash);
        chainTrans.setId(null);
        chainTrans.setModifiedTime(new Date());
        chainTrans.setOperationType(operationTypeEnum.getCode());
        chainTransMapper.insertSelective(chainTrans);
        LoanCredit loanCredit = new LoanCredit();
        loanCredit.setStatus(creditStatusEnum.getCode());
        loanCredit.setId(loanId);
        loanCreditMapper.updateByPrimaryKeySelective(loanCredit);
    }

    @Transactional
    public void updateApplyInfo(ChainTrans chainTrans, String transHash, CreditStatusEnum creditStatusEnum, long loanId, String assetsIds) {
        ChainTrans trans = new ChainTrans();
        ChainTransExample example = new ChainTransExample();
        example.createCriteria().andBuinessIdEqualTo(chainTrans.getBuinessId()).andOperationTypeEqualTo(OperationTypeEnum.APPLY.getCode());
        trans.setModifiedTime(new Date());
        trans.setTransHash(transHash);
        trans.setChainStatus(ChainStatusEnum.CHAIN_UP.getCode());
        chainTransMapper.updateByExampleSelective(trans, example);

        LoanCredit loanCredit = new LoanCredit();
        loanCredit.setStatus(creditStatusEnum.getCode());
        loanCredit.setId(loanId);
        loanCredit.setAssetId(assetsIds);
        loanCredit.setModifiedTime(new Date());
        loanCreditMapper.updateByPrimaryKeySelective(loanCredit);
    }

    @Transactional
    public void updateRepayInfo(Long transId, RepayRespDto respDto, OperationTypeEnum operationTypeEnum, long repayId) {
        ChainTrans trans = new ChainTrans();
        trans.setId(transId);
        trans.setChainStatus(ChainStatusEnum.CHAIN_UP.getCode());
        trans.setTransHash(respDto.getTxHash());
        trans.setOperationType(operationTypeEnum.getCode());
        chainTransMapper.updateByPrimaryKeySelective(trans);

        LoanRepay loanRepay = new LoanRepay();
        loanRepay.setChainStatus(ChainStatusEnum.CHAIN_UP.getCode());
        loanRepay.setStatus(RepayStatusEnum.DONE.getCode());
        loanRepay.setId(repayId);
        loanRepay.setRepayRecordAddress(respDto.getRecordAddress());
        loanRepayMapper.updateByPrimaryKeySelective(loanRepay);

    }

    @Transactional
    public void addOrUpdateTrans(long buinessId, String assetsIds, List<ChainTrans> chainTransList, OperationTypeEnum operationTypeEnum, CreditStatusEnum creditStatusEnum, String transHash) {
        if (CollectionUtils.isEmpty(chainTransList)) {
            ChainTrans chainTrans = new ChainTrans();
            chainTrans.setTransHash(transHash);
            chainTrans.setBuinessId(String.valueOf(buinessId));
            chainTrans.setOperationType(operationTypeEnum.getCode());
            chainTrans.setChainId(ChainEnum.IPAYNOW.getCode());
            chainTrans.setCreatedTime(new Date());
            chainTrans.setModifiedTime(new Date());
            chainTrans.setChainStatus(ChainStatusEnum.CHAIN_UP.getCode());
            chainTransService.add(chainTrans);
        } else {
            ChainTrans chainTrans = new ChainTrans();
            chainTrans.setChainStatus(ChainStatusEnum.CHAIN_UP.getCode());
            chainTrans.setTransHash(transHash);
            chainTrans.setChainId(ChainEnum.IPAYNOW.getCode());
            chainTrans.setModifiedTime(new Date());
            chainTrans.setBuinessId(String.valueOf(buinessId));
            chainTransService.updateByBusinessIdAndChainId(chainTrans, operationTypeEnum.getCode());
        }
        LoanCredit loanCredit = new LoanCredit();
        loanCredit.setId(buinessId);
        loanCredit.setStatus(creditStatusEnum.getCode());
        loanCredit.setModifiedTime(new Date());
        loanCredit.setAssetId(assetsIds);
        loanCreditMapper.updateByPrimaryKeySelective(loanCredit);
    }


}
