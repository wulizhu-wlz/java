package com.ipaynow.bcfinance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanRefundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoanRefundExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogIsNull() {
            addCriterion("id_sl_loan_credit_log is null");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogIsNotNull() {
            addCriterion("id_sl_loan_credit_log is not null");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogEqualTo(Integer value) {
            addCriterion("id_sl_loan_credit_log =", value, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogNotEqualTo(Integer value) {
            addCriterion("id_sl_loan_credit_log <>", value, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogGreaterThan(Integer value) {
            addCriterion("id_sl_loan_credit_log >", value, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_sl_loan_credit_log >=", value, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogLessThan(Integer value) {
            addCriterion("id_sl_loan_credit_log <", value, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogLessThanOrEqualTo(Integer value) {
            addCriterion("id_sl_loan_credit_log <=", value, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogIn(List<Integer> values) {
            addCriterion("id_sl_loan_credit_log in", values, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogNotIn(List<Integer> values) {
            addCriterion("id_sl_loan_credit_log not in", values, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogBetween(Integer value1, Integer value2) {
            addCriterion("id_sl_loan_credit_log between", value1, value2, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andIdSlLoanCreditLogNotBetween(Integer value1, Integer value2) {
            addCriterion("id_sl_loan_credit_log not between", value1, value2, "idSlLoanCreditLog");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(String value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(String value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(String value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(String value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(String value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(String value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLike(String value) {
            addCriterion("refund_amount like", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotLike(String value) {
            addCriterion("refund_amount not like", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<String> values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<String> values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(String value1, String value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(String value1, String value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleIsNull() {
            addCriterion("refund_principle is null");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleIsNotNull() {
            addCriterion("refund_principle is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleEqualTo(String value) {
            addCriterion("refund_principle =", value, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleNotEqualTo(String value) {
            addCriterion("refund_principle <>", value, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleGreaterThan(String value) {
            addCriterion("refund_principle >", value, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleGreaterThanOrEqualTo(String value) {
            addCriterion("refund_principle >=", value, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleLessThan(String value) {
            addCriterion("refund_principle <", value, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleLessThanOrEqualTo(String value) {
            addCriterion("refund_principle <=", value, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleLike(String value) {
            addCriterion("refund_principle like", value, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleNotLike(String value) {
            addCriterion("refund_principle not like", value, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleIn(List<String> values) {
            addCriterion("refund_principle in", values, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleNotIn(List<String> values) {
            addCriterion("refund_principle not in", values, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleBetween(String value1, String value2) {
            addCriterion("refund_principle between", value1, value2, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundPrincipleNotBetween(String value1, String value2) {
            addCriterion("refund_principle not between", value1, value2, "refundPrinciple");
            return (Criteria) this;
        }

        public Criteria andRefundRateIsNull() {
            addCriterion("refund_rate is null");
            return (Criteria) this;
        }

        public Criteria andRefundRateIsNotNull() {
            addCriterion("refund_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRefundRateEqualTo(String value) {
            addCriterion("refund_rate =", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotEqualTo(String value) {
            addCriterion("refund_rate <>", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateGreaterThan(String value) {
            addCriterion("refund_rate >", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateGreaterThanOrEqualTo(String value) {
            addCriterion("refund_rate >=", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateLessThan(String value) {
            addCriterion("refund_rate <", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateLessThanOrEqualTo(String value) {
            addCriterion("refund_rate <=", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateLike(String value) {
            addCriterion("refund_rate like", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotLike(String value) {
            addCriterion("refund_rate not like", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateIn(List<String> values) {
            addCriterion("refund_rate in", values, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotIn(List<String> values) {
            addCriterion("refund_rate not in", values, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateBetween(String value1, String value2) {
            addCriterion("refund_rate between", value1, value2, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotBetween(String value1, String value2) {
            addCriterion("refund_rate not between", value1, value2, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundDateIsNull() {
            addCriterion("refund_date is null");
            return (Criteria) this;
        }

        public Criteria andRefundDateIsNotNull() {
            addCriterion("refund_date is not null");
            return (Criteria) this;
        }

        public Criteria andRefundDateEqualTo(String value) {
            addCriterion("refund_date =", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateNotEqualTo(String value) {
            addCriterion("refund_date <>", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateGreaterThan(String value) {
            addCriterion("refund_date >", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateGreaterThanOrEqualTo(String value) {
            addCriterion("refund_date >=", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateLessThan(String value) {
            addCriterion("refund_date <", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateLessThanOrEqualTo(String value) {
            addCriterion("refund_date <=", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateLike(String value) {
            addCriterion("refund_date like", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateNotLike(String value) {
            addCriterion("refund_date not like", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateIn(List<String> values) {
            addCriterion("refund_date in", values, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateNotIn(List<String> values) {
            addCriterion("refund_date not in", values, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateBetween(String value1, String value2) {
            addCriterion("refund_date between", value1, value2, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateNotBetween(String value1, String value2) {
            addCriterion("refund_date not between", value1, value2, "refundDate");
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

        public Criteria andRepayStatusIsNull() {
            addCriterion("repay_status is null");
            return (Criteria) this;
        }

        public Criteria andRepayStatusIsNotNull() {
            addCriterion("repay_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepayStatusEqualTo(Byte value) {
            addCriterion("repay_status =", value, "repayStatus");
            return (Criteria) this;
        }

        public Criteria andRepayStatusNotEqualTo(Byte value) {
            addCriterion("repay_status <>", value, "repayStatus");
            return (Criteria) this;
        }

        public Criteria andRepayStatusGreaterThan(Byte value) {
            addCriterion("repay_status >", value, "repayStatus");
            return (Criteria) this;
        }

        public Criteria andRepayStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("repay_status >=", value, "repayStatus");
            return (Criteria) this;
        }

        public Criteria andRepayStatusLessThan(Byte value) {
            addCriterion("repay_status <", value, "repayStatus");
            return (Criteria) this;
        }

        public Criteria andRepayStatusLessThanOrEqualTo(Byte value) {
            addCriterion("repay_status <=", value, "repayStatus");
            return (Criteria) this;
        }

        public Criteria andRepayStatusIn(List<Byte> values) {
            addCriterion("repay_status in", values, "repayStatus");
            return (Criteria) this;
        }

        public Criteria andRepayStatusNotIn(List<Byte> values) {
            addCriterion("repay_status not in", values, "repayStatus");
            return (Criteria) this;
        }

        public Criteria andRepayStatusBetween(Byte value1, Byte value2) {
            addCriterion("repay_status between", value1, value2, "repayStatus");
            return (Criteria) this;
        }

        public Criteria andRepayStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("repay_status not between", value1, value2, "repayStatus");
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