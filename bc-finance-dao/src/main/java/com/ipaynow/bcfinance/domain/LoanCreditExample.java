package com.ipaynow.bcfinance.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanCreditExample {
    protected String orderByClause;

    protected boolean distinct;


    protected List<Criteria> oredCriteria;

    public LoanCreditExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLoanCodeIsNull() {
            addCriterion("loan_code is null");
            return (Criteria) this;
        }

        public Criteria andLoanCodeIsNotNull() {
            addCriterion("loan_code is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCodeEqualTo(String value) {
            addCriterion("loan_code =", value, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeNotEqualTo(String value) {
            addCriterion("loan_code <>", value, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeGreaterThan(String value) {
            addCriterion("loan_code >", value, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_code >=", value, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeLessThan(String value) {
            addCriterion("loan_code <", value, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeLessThanOrEqualTo(String value) {
            addCriterion("loan_code <=", value, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeLike(String value) {
            addCriterion("loan_code like", value, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeNotLike(String value) {
            addCriterion("loan_code not like", value, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeIn(List<String> values) {
            addCriterion("loan_code in", values, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeNotIn(List<String> values) {
            addCriterion("loan_code not in", values, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeBetween(String value1, String value2) {
            addCriterion("loan_code between", value1, value2, "loanCode");
            return (Criteria) this;
        }

        public Criteria andLoanCodeNotBetween(String value1, String value2) {
            addCriterion("loan_code not between", value1, value2, "loanCode");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdIsNull() {
            addCriterion("creditor_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdIsNotNull() {
            addCriterion("creditor_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdEqualTo(String value) {
            addCriterion("creditor_user_id =", value, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdNotEqualTo(String value) {
            addCriterion("creditor_user_id <>", value, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdGreaterThan(String value) {
            addCriterion("creditor_user_id >", value, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("creditor_user_id >=", value, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdLessThan(String value) {
            addCriterion("creditor_user_id <", value, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdLessThanOrEqualTo(String value) {
            addCriterion("creditor_user_id <=", value, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdLike(String value) {
            addCriterion("creditor_user_id like", value, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdNotLike(String value) {
            addCriterion("creditor_user_id not like", value, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdIn(List<String> values) {
            addCriterion("creditor_user_id in", values, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdNotIn(List<String> values) {
            addCriterion("creditor_user_id not in", values, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdBetween(String value1, String value2) {
            addCriterion("creditor_user_id between", value1, value2, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorUserIdNotBetween(String value1, String value2) {
            addCriterion("creditor_user_id not between", value1, value2, "creditorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdIsNull() {
            addCriterion("debtor_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdIsNotNull() {
            addCriterion("debtor_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdEqualTo(String value) {
            addCriterion("debtor_user_id =", value, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdNotEqualTo(String value) {
            addCriterion("debtor_user_id <>", value, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdGreaterThan(String value) {
            addCriterion("debtor_user_id >", value, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("debtor_user_id >=", value, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdLessThan(String value) {
            addCriterion("debtor_user_id <", value, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdLessThanOrEqualTo(String value) {
            addCriterion("debtor_user_id <=", value, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdLike(String value) {
            addCriterion("debtor_user_id like", value, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdNotLike(String value) {
            addCriterion("debtor_user_id not like", value, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdIn(List<String> values) {
            addCriterion("debtor_user_id in", values, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdNotIn(List<String> values) {
            addCriterion("debtor_user_id not in", values, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdBetween(String value1, String value2) {
            addCriterion("debtor_user_id between", value1, value2, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andDebtorUserIdNotBetween(String value1, String value2) {
            addCriterion("debtor_user_id not between", value1, value2, "debtorUserId");
            return (Criteria) this;
        }

        public Criteria andCreditorNameIsNull() {
            addCriterion("creditor_name is null");
            return (Criteria) this;
        }

        public Criteria andCreditorNameIsNotNull() {
            addCriterion("creditor_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreditorNameEqualTo(String value) {
            addCriterion("creditor_name =", value, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameNotEqualTo(String value) {
            addCriterion("creditor_name <>", value, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameGreaterThan(String value) {
            addCriterion("creditor_name >", value, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameGreaterThanOrEqualTo(String value) {
            addCriterion("creditor_name >=", value, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameLessThan(String value) {
            addCriterion("creditor_name <", value, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameLessThanOrEqualTo(String value) {
            addCriterion("creditor_name <=", value, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameLike(String value) {
            addCriterion("creditor_name like", value, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameNotLike(String value) {
            addCriterion("creditor_name not like", value, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameIn(List<String> values) {
            addCriterion("creditor_name in", values, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameNotIn(List<String> values) {
            addCriterion("creditor_name not in", values, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameBetween(String value1, String value2) {
            addCriterion("creditor_name between", value1, value2, "creditorName");
            return (Criteria) this;
        }

        public Criteria andCreditorNameNotBetween(String value1, String value2) {
            addCriterion("creditor_name not between", value1, value2, "creditorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameIsNull() {
            addCriterion("debtor_name is null");
            return (Criteria) this;
        }

        public Criteria andDebtorNameIsNotNull() {
            addCriterion("debtor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDebtorNameEqualTo(String value) {
            addCriterion("debtor_name =", value, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameNotEqualTo(String value) {
            addCriterion("debtor_name <>", value, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameGreaterThan(String value) {
            addCriterion("debtor_name >", value, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameGreaterThanOrEqualTo(String value) {
            addCriterion("debtor_name >=", value, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameLessThan(String value) {
            addCriterion("debtor_name <", value, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameLessThanOrEqualTo(String value) {
            addCriterion("debtor_name <=", value, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameLike(String value) {
            addCriterion("debtor_name like", value, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameNotLike(String value) {
            addCriterion("debtor_name not like", value, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameIn(List<String> values) {
            addCriterion("debtor_name in", values, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameNotIn(List<String> values) {
            addCriterion("debtor_name not in", values, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameBetween(String value1, String value2) {
            addCriterion("debtor_name between", value1, value2, "debtorName");
            return (Criteria) this;
        }

        public Criteria andDebtorNameNotBetween(String value1, String value2) {
            addCriterion("debtor_name not between", value1, value2, "debtorName");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountIsNull() {
            addCriterion("financing_amount is null");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountIsNotNull() {
            addCriterion("financing_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountEqualTo(BigDecimal value) {
            addCriterion("financing_amount =", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotEqualTo(BigDecimal value) {
            addCriterion("financing_amount <>", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountGreaterThan(BigDecimal value) {
            addCriterion("financing_amount >", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("financing_amount >=", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountLessThan(BigDecimal value) {
            addCriterion("financing_amount <", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("financing_amount <=", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountIn(List<BigDecimal> values) {
            addCriterion("financing_amount in", values, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotIn(List<BigDecimal> values) {
            addCriterion("financing_amount not in", values, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financing_amount between", value1, value2, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financing_amount not between", value1, value2, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingRateIsNull() {
            addCriterion("financing_rate is null");
            return (Criteria) this;
        }

        public Criteria andFinancingRateIsNotNull() {
            addCriterion("financing_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingRateEqualTo(String value) {
            addCriterion("financing_rate =", value, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateNotEqualTo(String value) {
            addCriterion("financing_rate <>", value, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateGreaterThan(String value) {
            addCriterion("financing_rate >", value, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateGreaterThanOrEqualTo(String value) {
            addCriterion("financing_rate >=", value, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateLessThan(String value) {
            addCriterion("financing_rate <", value, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateLessThanOrEqualTo(String value) {
            addCriterion("financing_rate <=", value, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateLike(String value) {
            addCriterion("financing_rate like", value, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateNotLike(String value) {
            addCriterion("financing_rate not like", value, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateIn(List<String> values) {
            addCriterion("financing_rate in", values, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateNotIn(List<String> values) {
            addCriterion("financing_rate not in", values, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateBetween(String value1, String value2) {
            addCriterion("financing_rate between", value1, value2, "financingRate");
            return (Criteria) this;
        }

        public Criteria andFinancingRateNotBetween(String value1, String value2) {
            addCriterion("financing_rate not between", value1, value2, "financingRate");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeIsNull() {
            addCriterion("real_loan_time is null");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeIsNotNull() {
            addCriterion("real_loan_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeEqualTo(String value) {
            addCriterion("real_loan_time =", value, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeNotEqualTo(String value) {
            addCriterion("real_loan_time <>", value, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeGreaterThan(String value) {
            addCriterion("real_loan_time >", value, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeGreaterThanOrEqualTo(String value) {
            addCriterion("real_loan_time >=", value, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeLessThan(String value) {
            addCriterion("real_loan_time <", value, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeLessThanOrEqualTo(String value) {
            addCriterion("real_loan_time <=", value, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeLike(String value) {
            addCriterion("real_loan_time like", value, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeNotLike(String value) {
            addCriterion("real_loan_time not like", value, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeIn(List<String> values) {
            addCriterion("real_loan_time in", values, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeNotIn(List<String> values) {
            addCriterion("real_loan_time not in", values, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeBetween(String value1, String value2) {
            addCriterion("real_loan_time between", value1, value2, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andRealLoanTimeNotBetween(String value1, String value2) {
            addCriterion("real_loan_time not between", value1, value2, "realLoanTime");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("extend is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("extend is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("extend =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("extend <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("extend >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("extend >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("extend <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("extend <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("extend like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("extend not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("extend in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("extend not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("extend between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("extend not between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAssetIdIsNull() {
            addCriterion("asset_id is null");
            return (Criteria) this;
        }

        public Criteria andAssetIdIsNotNull() {
            addCriterion("asset_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssetIdEqualTo(String value) {
            addCriterion("asset_id =", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdNotEqualTo(String value) {
            addCriterion("asset_id <>", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdGreaterThan(String value) {
            addCriterion("asset_id >", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdGreaterThanOrEqualTo(String value) {
            addCriterion("asset_id >=", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdLessThan(String value) {
            addCriterion("asset_id <", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdLessThanOrEqualTo(String value) {
            addCriterion("asset_id <=", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdLike(String value) {
            addCriterion("asset_id like", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdNotLike(String value) {
            addCriterion("asset_id not like", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdIn(List<String> values) {
            addCriterion("asset_id in", values, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdNotIn(List<String> values) {
            addCriterion("asset_id not in", values, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdBetween(String value1, String value2) {
            addCriterion("asset_id between", value1, value2, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdNotBetween(String value1, String value2) {
            addCriterion("asset_id not between", value1, value2, "assetId");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}