package com.ipaynow.bcfinance.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ipaynow.bcfinance.dao.LoanCreditMapper;
import com.ipaynow.bcfinance.dao.LoanRepayMapper;
import com.ipaynow.bcfinance.domain.*;
import com.ipaynow.bcfinance.enums.ChainStatusEnum;
import com.ipaynow.bcfinance.enums.CreditStatusEnum;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.service.RepaymentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wu
 * @createTime 2019/6/21
 */
@Service
public class RepaymentServiceImpl implements RepaymentService {

    private static final Logger logger = LogManager.getLogger(LoanCreditServiceImpl.class);

    @Resource
    private LoanRepayMapper loanRepayMapper;

    @Resource
    private LoanCreditMapper loanCreditMapper;

    @Override
    public LoanRepay queryRepayById(Long repaymentId, boolean isHistory) {
        try {
            if (isHistory) {
                LoanRepayExample example = new LoanRepayExample();
                example.createCriteria().andIdEqualTo(repaymentId).andChainStatusEqualTo(ChainStatusEnum.CHAIN_UP.getCode());
                List<LoanRepay> loanRepays = loanRepayMapper.selectByExample(example);
                if (CollectionUtils.isEmpty(loanRepays)) {
                    return null;
                }
                return loanRepays.get(0);
            }
            return loanRepayMapper.selectByPrimaryKey(repaymentId);
        } catch (Exception e) {
            logger.error("根据id查询还款数据异常,id:{}", repaymentId, e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public void saveRepaymentInfo(LoanRepay loanRefund) {
        try {
            loanRepayMapper.insertSelective(loanRefund);
        } catch (Exception e) {
            logger.error("插入还款信息数据异常,loanRefund:{}", JSON.toJSON(loanRefund), e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public List<LoanRepay> queryByDate(Date startTime, Date endTime) {
        try {
            LoanRepayExample example = new LoanRepayExample();
            LoanRepayExample.Criteria criteria = example.createCriteria();
            if (startTime != null) {
                criteria.andCreatedTimeGreaterThan(startTime);
            }
            if (endTime != null) {
                criteria.andCreatedTimeLessThan(endTime);
            }
            criteria.andChainStatusEqualTo(ChainStatusEnum.CHAIN_DOWN.getCode());
            return loanRepayMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("查询还款历史数据异常,startTime:{},endTime:{}", startTime, endTime, e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public List<LoanRepay> queryInit() throws BusinessException {
        LoanCreditExample creditExample = new LoanCreditExample();
        creditExample.createCriteria().andStatusEqualTo(CreditStatusEnum.LOAN.getCode());
        List<LoanCredit> loanCredits = loanCreditMapper.selectByExample(creditExample);
        List<Long> list = loanCredits.stream().distinct().map(loanCredit -> loanCredit.getId()).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        LoanRepayExample example = new LoanRepayExample();
        example.createCriteria().andChainStatusEqualTo(ChainStatusEnum.CHAIN_DOWN.getCode()).andLoanCreditIdIn(list);
        return loanRepayMapper.selectByExample(example);
    }

    @Override
    public PageInfo<LoanRepay> getRepayedLoanCredit(int currentPage, int pageSize, int idSlLoanCreditLog) throws BusinessException {
        try {
            PageHelper.startPage(currentPage, pageSize);
            LoanRepayExample loanRepayExample = new LoanRepayExample();
            LoanRepayExample.Criteria criteria = loanRepayExample.createCriteria();
            criteria.andLoanCreditIdEqualTo(Long.valueOf(idSlLoanCreditLog));
            criteria.andChainStatusEqualTo(ChainStatusEnum.CHAIN_UP.getCode());
            loanRepayExample.setOrderByClause("repay_date desc");
            List<LoanRepay> loanRepays = loanRepayMapper.selectByExample(loanRepayExample);
            PageInfo<LoanRepay> pageInfo = new PageInfo<>(loanRepays);
            return pageInfo;
        } catch (Exception e) {
            logger.error("分页查询获取指定借出id的借款记录总数异常 借方记录id:{}", idSlLoanCreditLog, e.getMessage());
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    public int getCountRepayedLoanRefund(int idSlLoanCreditLog) throws BusinessException {

        try {
            LoanRepayExample loanRepayExample = new LoanRepayExample();
            loanRepayExample.createCriteria()
                    .andLoanCreditIdEqualTo(Long.valueOf(idSlLoanCreditLog))
                    .andChainStatusEqualTo(ChainStatusEnum.CHAIN_UP.getCode());
            return loanRepayMapper.countByExample(loanRepayExample);
        } catch (Exception e) {
            logger.error("获取指定借出id的借款记录的贷方已还款记录总数异常 借方记录id:%s :%s", idSlLoanCreditLog, e.getMessage());
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public long getRepayedLoanCreditCount(int idSlLoanCreditLog) throws BusinessException {
        return 0;
    }

    @Override
    public LoanRepaySum getSum(String debtorUserId) throws BusinessException {
        return loanRepayMapper.getSummary(debtorUserId);
    }


}