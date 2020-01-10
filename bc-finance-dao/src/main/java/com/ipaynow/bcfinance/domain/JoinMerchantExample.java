package com.ipaynow.bcfinance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JoinMerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JoinMerchantExample() {
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

        public Criteria andIdOfTbMerchantUserIsNull() {
            addCriterion("id_of_tb_merchant_user is null");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserIsNotNull() {
            addCriterion("id_of_tb_merchant_user is not null");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserEqualTo(Integer value) {
            addCriterion("id_of_tb_merchant_user =", value, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserNotEqualTo(Integer value) {
            addCriterion("id_of_tb_merchant_user <>", value, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserGreaterThan(Integer value) {
            addCriterion("id_of_tb_merchant_user >", value, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_of_tb_merchant_user >=", value, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserLessThan(Integer value) {
            addCriterion("id_of_tb_merchant_user <", value, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserLessThanOrEqualTo(Integer value) {
            addCriterion("id_of_tb_merchant_user <=", value, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserIn(List<Integer> values) {
            addCriterion("id_of_tb_merchant_user in", values, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserNotIn(List<Integer> values) {
            addCriterion("id_of_tb_merchant_user not in", values, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserBetween(Integer value1, Integer value2) {
            addCriterion("id_of_tb_merchant_user between", value1, value2, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andIdOfTbMerchantUserNotBetween(Integer value1, Integer value2) {
            addCriterion("id_of_tb_merchant_user not between", value1, value2, "idOfTbMerchantUser");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowIsNull() {
            addCriterion("user_id_of_i_pay_now is null");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowIsNotNull() {
            addCriterion("user_id_of_i_pay_now is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowEqualTo(String value) {
            addCriterion("user_id_of_i_pay_now =", value, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowNotEqualTo(String value) {
            addCriterion("user_id_of_i_pay_now <>", value, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowGreaterThan(String value) {
            addCriterion("user_id_of_i_pay_now >", value, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowGreaterThanOrEqualTo(String value) {
            addCriterion("user_id_of_i_pay_now >=", value, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowLessThan(String value) {
            addCriterion("user_id_of_i_pay_now <", value, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowLessThanOrEqualTo(String value) {
            addCriterion("user_id_of_i_pay_now <=", value, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowLike(String value) {
            addCriterion("user_id_of_i_pay_now like", value, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowNotLike(String value) {
            addCriterion("user_id_of_i_pay_now not like", value, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowIn(List<String> values) {
            addCriterion("user_id_of_i_pay_now in", values, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowNotIn(List<String> values) {
            addCriterion("user_id_of_i_pay_now not in", values, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowBetween(String value1, String value2) {
            addCriterion("user_id_of_i_pay_now between", value1, value2, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andUserIdOfIPayNowNotBetween(String value1, String value2) {
            addCriterion("user_id_of_i_pay_now not between", value1, value2, "userIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andMchNameIsNull() {
            addCriterion("mch_name is null");
            return (Criteria) this;
        }

        public Criteria andMchNameIsNotNull() {
            addCriterion("mch_name is not null");
            return (Criteria) this;
        }

        public Criteria andMchNameEqualTo(String value) {
            addCriterion("mch_name =", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotEqualTo(String value) {
            addCriterion("mch_name <>", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameGreaterThan(String value) {
            addCriterion("mch_name >", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameGreaterThanOrEqualTo(String value) {
            addCriterion("mch_name >=", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameLessThan(String value) {
            addCriterion("mch_name <", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameLessThanOrEqualTo(String value) {
            addCriterion("mch_name <=", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameLike(String value) {
            addCriterion("mch_name like", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotLike(String value) {
            addCriterion("mch_name not like", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameIn(List<String> values) {
            addCriterion("mch_name in", values, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotIn(List<String> values) {
            addCriterion("mch_name not in", values, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameBetween(String value1, String value2) {
            addCriterion("mch_name between", value1, value2, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotBetween(String value1, String value2) {
            addCriterion("mch_name not between", value1, value2, "mchName");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowIsNull() {
            addCriterion("platform_id_of_i_pay_now is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowIsNotNull() {
            addCriterion("platform_id_of_i_pay_now is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowEqualTo(String value) {
            addCriterion("platform_id_of_i_pay_now =", value, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowNotEqualTo(String value) {
            addCriterion("platform_id_of_i_pay_now <>", value, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowGreaterThan(String value) {
            addCriterion("platform_id_of_i_pay_now >", value, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowGreaterThanOrEqualTo(String value) {
            addCriterion("platform_id_of_i_pay_now >=", value, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowLessThan(String value) {
            addCriterion("platform_id_of_i_pay_now <", value, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowLessThanOrEqualTo(String value) {
            addCriterion("platform_id_of_i_pay_now <=", value, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowLike(String value) {
            addCriterion("platform_id_of_i_pay_now like", value, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowNotLike(String value) {
            addCriterion("platform_id_of_i_pay_now not like", value, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowIn(List<String> values) {
            addCriterion("platform_id_of_i_pay_now in", values, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowNotIn(List<String> values) {
            addCriterion("platform_id_of_i_pay_now not in", values, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowBetween(String value1, String value2) {
            addCriterion("platform_id_of_i_pay_now between", value1, value2, "platformIdOfIPayNow");
            return (Criteria) this;
        }

        public Criteria andPlatformIdOfIPayNowNotBetween(String value1, String value2) {
            addCriterion("platform_id_of_i_pay_now not between", value1, value2, "platformIdOfIPayNow");
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