package com.ipaynow.bcfinance.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ipaynow.bcfinance.dao.ChainTransMapper;
import com.ipaynow.bcfinance.dao.LoanCreditMapper;
import com.ipaynow.bcfinance.dao.MerchantPlatformBusinessMapper;
import com.ipaynow.bcfinance.domain.*;
import com.ipaynow.bcfinance.dto.LoanCreditDtoForPage;
import com.ipaynow.bcfinance.enums.*;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.service.LoanCreditDo2DtoService;
import com.ipaynow.bcfinance.service.LoanCreditService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wu
 * @createTime 2019/6/21
 */
@Service
public class LoanCreditServiceImpl implements LoanCreditService {

    private static final Logger logger = LogManager.getLogger(LoanCreditServiceImpl.class);

    @Resource
    private LoanCreditMapper loanCreditMapper;

    @Resource
    private ChainTransMapper chainTransMapper;

    @Resource
    private MerchantPlatformBusinessMapper businessMapper;


    @Override
    public LoanCredit queryLoanCreditById(Long loanId, boolean isHistory) {
        try {
            if (isHistory) {
                LoanCreditExample example = new LoanCreditExample();
                LoanCreditExample.Criteria criteria = example.createCriteria();
                criteria.andStatusNotEqualTo(FinancialStatusEnum.INIT.getCode());
                criteria.andIdEqualTo(loanId);
                List<LoanCredit> loanCredits = loanCreditMapper.selectByExample(example);
                if (CollectionUtils.isEmpty(loanCredits)) {
                    return null;
                }
                return loanCredits.get(0);
            } else {
                return loanCreditMapper.selectByPrimaryKey(loanId);
            }
        } catch (Exception e) {
            logger.error("根据id查询融资数据异常,id:{}", loanId, e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public void saveLoanInfo(LoanCredit loanCredit) {
        try {
            loanCreditMapper.insertSelective(loanCredit);
        } catch (Exception e) {
            logger.error("插入融资信息数据异常,loanCredit:{}", JSON.toJSON(loanCredit), e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public List<LoanCredit> queryByDate(Date startTime, Date endTime) throws BusinessException {
        try {
            LoanCreditExample example = new LoanCreditExample();
            example.setOrderByClause("created_time desc");
            LoanCreditExample.Criteria criteria = example.createCriteria();
            if (startTime != null) {
                criteria.andCreatedTimeGreaterThan(startTime);
            }
            if (endTime != null) {
                criteria.andCreatedTimeLessThan(endTime);
            }
            criteria.andStatusEqualTo(FinancialStatusEnum.INIT.getCode());
            return loanCreditMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("查询融资数据异常,startTime:{},endTime:{}", startTime, endTime, e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public List<LoanCredit> queryList(LoanCreditExample example) {
        return loanCreditMapper.selectByExample(example);
    }


    @Override
    public List<LoanCredit> queryByMhtAndPlat(String merchantId, String platformId) {
        try {
            LoanCreditExample example = new LoanCreditExample();
            example.createCriteria().andStatusNotEqualTo(CreditStatusEnum.INIT.getCode()).andDebtorUserIdEqualTo(merchantId).andCreditorUserIdEqualTo(platformId);
            return loanCreditMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("根据商户和平台信息查询融资数据异常,merchantId:{},platformId:{}", merchantId, platformId, e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public void updateById(LoanCredit loanCredit) {
        loanCreditMapper.updateByPrimaryKeySelective(loanCredit);
    }

    @Override
    public List<LoanCredit> queryInit() throws BusinessException {
        return loanCreditMapper.selectAssetsCredit();
    }

    public PageInfo<LoanCredit> getLoanCreditByPage(
            int currentPage, int pageSize, String code, String realLoanStartTime, String realLoanEndTime,
            String userIdOfIPayNowOfCreditor, String userIdOfIPayNowOfDebtor,
            String creditorName, String debtorName
    ) throws BusinessException {
        try {
            PageHelper.startPage(currentPage, pageSize);
            LoanCreditExample loanCreditExample = new LoanCreditExample();
            LoanCreditExample.Criteria criteria = loanCreditExample.createCriteria();
            loanCreditExample.setOrderByClause("real_loan_time desc");
            criteria.andStatusEqualTo(CreditStatusEnum.LOAN.getCode());
            if (StringUtils.isNotBlank(code)) {
                criteria.andLoanCodeLike("%" + code + "%");
            }
            if (StringUtils.isNotBlank(userIdOfIPayNowOfCreditor)) {
                criteria.andCreditorUserIdLike("%" + userIdOfIPayNowOfCreditor + "%");
            }
            if (StringUtils.isNotBlank(userIdOfIPayNowOfDebtor)) {
                criteria.andDebtorUserIdLike("%" + userIdOfIPayNowOfDebtor + "%");
            }
            if (StringUtils.isNotBlank(realLoanStartTime)) {
                criteria.andRealLoanTimeGreaterThanOrEqualTo(realLoanStartTime);
            }
            if (StringUtils.isNotBlank(realLoanEndTime)) {
                criteria.andRealLoanTimeLessThanOrEqualTo(realLoanEndTime);
            }
            if (StringUtils.isNotBlank(creditorName)) {
                criteria.andCreditorNameLike("%" + creditorName + "%");
            }
            if (StringUtils.isNotBlank(debtorName)) {
                criteria.andDebtorNameLike("%" + debtorName + "%");
            }
            List<LoanCredit> loanCredits = loanCreditMapper.selectByExample(loanCreditExample);
            PageInfo<LoanCredit> pageInfo = new PageInfo<>(loanCredits);
            return pageInfo;
        } catch (Exception e) {
            logger.error("分页查询借款数据失败 code:{}", code, e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public int getLoanCredit(String code, String realLoanStartTime, String realLoanEndTime, String userIdOfIPayNowOfCreditor, String userIdOfIPayNowOfDebtor, String creditorName, String debtorName) {
        return 0;
    }

    @Override
    public List<LoanCredit> queryLoanCreditList(String merchantId, String platformId, Date realLoanTimeFrom, Date realLoanTimeTo) {


        LoanCreditExample example = new LoanCreditExample();
        LoanCreditExample.Criteria criteria = example.createCriteria()
                .andStatusNotEqualTo(CreditStatusEnum.INIT.getCode());
        if (realLoanTimeFrom != null) {
            criteria.andCreatedTimeGreaterThan(realLoanTimeFrom);
        }
        if (realLoanTimeTo != null) {
            criteria.andCreatedTimeLessThan(realLoanTimeTo);
        }
        criteria.andDebtorUserIdEqualTo(merchantId).andCreditorUserIdEqualTo(platformId);
        return loanCreditMapper.selectByExample(example);
    }

    @Override
    public LoanCreditSum getSum(String debtorUserId, String realLoanTimeFrom, String realLoanTimeTo) {
        return loanCreditMapper.getSummary(debtorUserId, realLoanTimeFrom, realLoanTimeTo);
    }


}