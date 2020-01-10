package com.ipaynow.bcfinance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChainTransExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChainTransExample() {
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

        public Criteria andBuinessIdIsNull() {
            addCriterion("buiness_id is null");
            return (Criteria) this;
        }

        public Criteria andBuinessIdIsNotNull() {
            addCriterion("buiness_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuinessIdEqualTo(String value) {
            addCriterion("buiness_id =", value, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdNotEqualTo(String value) {
            addCriterion("buiness_id <>", value, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdGreaterThan(String value) {
            addCriterion("buiness_id >", value, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdGreaterThanOrEqualTo(String value) {
            addCriterion("buiness_id >=", value, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdLessThan(String value) {
            addCriterion("buiness_id <", value, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdLessThanOrEqualTo(String value) {
            addCriterion("buiness_id <=", value, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdLike(String value) {
            addCriterion("buiness_id like", value, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdNotLike(String value) {
            addCriterion("buiness_id not like", value, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdIn(List<String> values) {
            addCriterion("buiness_id in", values, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdNotIn(List<String> values) {
            addCriterion("buiness_id not in", values, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdBetween(String value1, String value2) {
            addCriterion("buiness_id between", value1, value2, "buinessId");
            return (Criteria) this;
        }

        public Criteria andBuinessIdNotBetween(String value1, String value2) {
            addCriterion("buiness_id not between", value1, value2, "buinessId");
            return (Criteria) this;
        }

        public Criteria andChainIdIsNull() {
            addCriterion("chain_id is null");
            return (Criteria) this;
        }

        public Criteria andChainIdIsNotNull() {
            addCriterion("chain_id is not null");
            return (Criteria) this;
        }

        public Criteria andChainIdEqualTo(Byte value) {
            addCriterion("chain_id =", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotEqualTo(Byte value) {
            addCriterion("chain_id <>", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThan(Byte value) {
            addCriterion("chain_id >", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("chain_id >=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThan(Byte value) {
            addCriterion("chain_id <", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThanOrEqualTo(Byte value) {
            addCriterion("chain_id <=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdIn(List<Byte> values) {
            addCriterion("chain_id in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotIn(List<Byte> values) {
            addCriterion("chain_id not in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdBetween(Byte value1, Byte value2) {
            addCriterion("chain_id between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotBetween(Byte value1, Byte value2) {
            addCriterion("chain_id not between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andTransHashIsNull() {
            addCriterion("trans_hash is null");
            return (Criteria) this;
        }

        public Criteria andTransHashIsNotNull() {
            addCriterion("trans_hash is not null");
            return (Criteria) this;
        }

        public Criteria andTransHashEqualTo(String value) {
            addCriterion("trans_hash =", value, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashNotEqualTo(String value) {
            addCriterion("trans_hash <>", value, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashGreaterThan(String value) {
            addCriterion("trans_hash >", value, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashGreaterThanOrEqualTo(String value) {
            addCriterion("trans_hash >=", value, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashLessThan(String value) {
            addCriterion("trans_hash <", value, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashLessThanOrEqualTo(String value) {
            addCriterion("trans_hash <=", value, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashLike(String value) {
            addCriterion("trans_hash like", value, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashNotLike(String value) {
            addCriterion("trans_hash not like", value, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashIn(List<String> values) {
            addCriterion("trans_hash in", values, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashNotIn(List<String> values) {
            addCriterion("trans_hash not in", values, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashBetween(String value1, String value2) {
            addCriterion("trans_hash between", value1, value2, "transHash");
            return (Criteria) this;
        }

        public Criteria andTransHashNotBetween(String value1, String value2) {
            addCriterion("trans_hash not between", value1, value2, "transHash");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNull() {
            addCriterion("operation_type is null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNotNull() {
            addCriterion("operation_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeEqualTo(Byte value) {
            addCriterion("operation_type =", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotEqualTo(Byte value) {
            addCriterion("operation_type <>", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThan(Byte value) {
            addCriterion("operation_type >", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("operation_type >=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThan(Byte value) {
            addCriterion("operation_type <", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThanOrEqualTo(Byte value) {
            addCriterion("operation_type <=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIn(List<Byte> values) {
            addCriterion("operation_type in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotIn(List<Byte> values) {
            addCriterion("operation_type not in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeBetween(Byte value1, Byte value2) {
            addCriterion("operation_type between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("operation_type not between", value1, value2, "operationType");
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