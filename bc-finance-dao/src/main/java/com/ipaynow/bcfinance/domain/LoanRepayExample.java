package com.ipaynow.bcfinance.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanRepayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoanRepayExample() {
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

        public Criteria andLoanCreditIdIsNull() {
            addCriterion("loan_credit_id is null");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdIsNotNull() {
            addCriterion("loan_credit_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdEqualTo(Long value) {
            addCriterion("loan_credit_id =", value, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdNotEqualTo(Long value) {
            addCriterion("loan_credit_id <>", value, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdGreaterThan(Long value) {
            addCriterion("loan_credit_id >", value, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdGreaterThanOrEqualTo(Long value) {
            addCriterion("loan_credit_id >=", value, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdLessThan(Long value) {
            addCriterion("loan_credit_id <", value, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdLessThanOrEqualTo(Long value) {
            addCriterion("loan_credit_id <=", value, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdIn(List<Long> values) {
            addCriterion("loan_credit_id in", values, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdNotIn(List<Long> values) {
            addCriterion("loan_credit_id not in", values, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdBetween(Long value1, Long value2) {
            addCriterion("loan_credit_id between", value1, value2, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andLoanCreditIdNotBetween(Long value1, Long value2) {
            addCriterion("loan_credit_id not between", value1, value2, "loanCreditId");
            return (Criteria) this;
        }

        public Criteria andRepayAmountIsNull() {
            addCriterion("repay_amount is null");
            return (Criteria) this;
        }

        public Criteria andRepayAmountIsNotNull() {
            addCriterion("repay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRepayAmountEqualTo(BigDecimal value) {
            addCriterion("repay_amount =", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountNotEqualTo(BigDecimal value) {
            addCriterion("repay_amount <>", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountGreaterThan(BigDecimal value) {
            addCriterion("repay_amount >", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_amount >=", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountLessThan(BigDecimal value) {
            addCriterion("repay_amount <", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_amount <=", value, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountIn(List<BigDecimal> values) {
            addCriterion("repay_amount in", values, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountNotIn(List<BigDecimal> values) {
            addCriterion("repay_amount not in", values, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_amount between", value1, value2, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_amount not between", value1, value2, "repayAmount");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleIsNull() {
            addCriterion("repay_principle is null");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleIsNotNull() {
            addCriterion("repay_principle is not null");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleEqualTo(BigDecimal value) {
            addCriterion("repay_principle =", value, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleNotEqualTo(BigDecimal value) {
            addCriterion("repay_principle <>", value, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleGreaterThan(BigDecimal value) {
            addCriterion("repay_principle >", value, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_principle >=", value, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleLessThan(BigDecimal value) {
            addCriterion("repay_principle <", value, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_principle <=", value, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleIn(List<BigDecimal> values) {
            addCriterion("repay_principle in", values, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleNotIn(List<BigDecimal> values) {
            addCriterion("repay_principle not in", values, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_principle between", value1, value2, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayPrincipleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_principle not between", value1, value2, "repayPrinciple");
            return (Criteria) this;
        }

        public Criteria andRepayRateIsNull() {
            addCriterion("repay_rate is null");
            return (Criteria) this;
        }

        public Criteria andRepayRateIsNotNull() {
            addCriterion("repay_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRepayRateEqualTo(BigDecimal value) {
            addCriterion("repay_rate =", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateNotEqualTo(BigDecimal value) {
            addCriterion("repay_rate <>", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateGreaterThan(BigDecimal value) {
            addCriterion("repay_rate >", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_rate >=", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateLessThan(BigDecimal value) {
            addCriterion("repay_rate <", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_rate <=", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateIn(List<BigDecimal> values) {
            addCriterion("repay_rate in", values, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateNotIn(List<BigDecimal> values) {
            addCriterion("repay_rate not in", values, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_rate between", value1, value2, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_rate not between", value1, value2, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayDateIsNull() {
            addCriterion("repay_date is null");
            return (Criteria) this;
        }

        public Criteria andRepayDateIsNotNull() {
            addCriterion("repay_date is not null");
            return (Criteria) this;
        }

        public Criteria andRepayDateEqualTo(String value) {
            addCriterion("repay_date =", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateNotEqualTo(String value) {
            addCriterion("repay_date <>", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateGreaterThan(String value) {
            addCriterion("repay_date >", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateGreaterThanOrEqualTo(String value) {
            addCriterion("repay_date >=", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateLessThan(String value) {
            addCriterion("repay_date <", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateLessThanOrEqualTo(String value) {
            addCriterion("repay_date <=", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateLike(String value) {
            addCriterion("repay_date like", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateNotLike(String value) {
            addCriterion("repay_date not like", value, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateIn(List<String> values) {
            addCriterion("repay_date in", values, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateNotIn(List<String> values) {
            addCriterion("repay_date not in", values, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateBetween(String value1, String value2) {
            addCriterion("repay_date between", value1, value2, "repayDate");
            return (Criteria) this;
        }

        public Criteria andRepayDateNotBetween(String value1, String value2) {
            addCriterion("repay_date not between", value1, value2, "repayDate");
            return (Criteria) this;
        }

        public Criteria andChainStatusIsNull() {
            addCriterion("chain_status is null");
            return (Criteria) this;
        }

        public Criteria andChainStatusIsNotNull() {
            addCriterion("chain_status is not null");
            return (Criteria) this;
        }

        public Criteria andChainStatusEqualTo(Byte value) {
            addCriterion("chain_status =", value, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andChainStatusNotEqualTo(Byte value) {
            addCriterion("chain_status <>", value, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andChainStatusGreaterThan(Byte value) {
            addCriterion("chain_status >", value, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andChainStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("chain_status >=", value, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andChainStatusLessThan(Byte value) {
            addCriterion("chain_status <", value, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andChainStatusLessThanOrEqualTo(Byte value) {
            addCriterion("chain_status <=", value, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andChainStatusIn(List<Byte> values) {
            addCriterion("chain_status in", values, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andChainStatusNotIn(List<Byte> values) {
            addCriterion("chain_status not in", values, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andChainStatusBetween(Byte value1, Byte value2) {
            addCriterion("chain_status between", value1, value2, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andChainStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("chain_status not between", value1, value2, "chainStatus");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleIsNull() {
            addCriterion("should_repay_principle is null");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleIsNotNull() {
            addCriterion("should_repay_principle is not null");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleEqualTo(BigDecimal value) {
            addCriterion("should_repay_principle =", value, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleNotEqualTo(BigDecimal value) {
            addCriterion("should_repay_principle <>", value, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleGreaterThan(BigDecimal value) {
            addCriterion("should_repay_principle >", value, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("should_repay_principle >=", value, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleLessThan(BigDecimal value) {
            addCriterion("should_repay_principle <", value, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("should_repay_principle <=", value, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleIn(List<BigDecimal> values) {
            addCriterion("should_repay_principle in", values, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleNotIn(List<BigDecimal> values) {
            addCriterion("should_repay_principle not in", values, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("should_repay_principle between", value1, value2, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayPrincipleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("should_repay_principle not between", value1, value2, "shouldRepayPrinciple");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateIsNull() {
            addCriterion("should_repay_rate is null");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateIsNotNull() {
            addCriterion("should_repay_rate is not null");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateEqualTo(BigDecimal value) {
            addCriterion("should_repay_rate =", value, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateNotEqualTo(BigDecimal value) {
            addCriterion("should_repay_rate <>", value, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateGreaterThan(BigDecimal value) {
            addCriterion("should_repay_rate >", value, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("should_repay_rate >=", value, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateLessThan(BigDecimal value) {
            addCriterion("should_repay_rate <", value, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("should_repay_rate <=", value, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateIn(List<BigDecimal> values) {
            addCriterion("should_repay_rate in", values, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateNotIn(List<BigDecimal> values) {
            addCriterion("should_repay_rate not in", values, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("should_repay_rate between", value1, value2, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andShouldRepayRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("should_repay_rate not between", value1, value2, "shouldRepayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressIsNull() {
            addCriterion("repay_record_address is null");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressIsNotNull() {
            addCriterion("repay_record_address is not null");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressEqualTo(String value) {
            addCriterion("repay_record_address =", value, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressNotEqualTo(String value) {
            addCriterion("repay_record_address <>", value, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressGreaterThan(String value) {
            addCriterion("repay_record_address >", value, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressGreaterThanOrEqualTo(String value) {
            addCriterion("repay_record_address >=", value, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressLessThan(String value) {
            addCriterion("repay_record_address <", value, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressLessThanOrEqualTo(String value) {
            addCriterion("repay_record_address <=", value, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressLike(String value) {
            addCriterion("repay_record_address like", value, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressNotLike(String value) {
            addCriterion("repay_record_address not like", value, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressIn(List<String> values) {
            addCriterion("repay_record_address in", values, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressNotIn(List<String> values) {
            addCriterion("repay_record_address not in", values, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressBetween(String value1, String value2) {
            addCriterion("repay_record_address between", value1, value2, "repayRecordAddress");
            return (Criteria) this;
        }

        public Criteria andRepayRecordAddressNotBetween(String value1, String value2) {
            addCriterion("repay_record_address not between", value1, value2, "repayRecordAddress");
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