package com.ipaynow.bcfinance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlockChainAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlockChainAccountExample() {
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

        public Criteria andPrivateKeyIsNull() {
            addCriterion("private_key is null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNotNull() {
            addCriterion("private_key is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyEqualTo(String value) {
            addCriterion("private_key =", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotEqualTo(String value) {
            addCriterion("private_key <>", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThan(String value) {
            addCriterion("private_key >", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("private_key >=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThan(String value) {
            addCriterion("private_key <", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("private_key <=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLike(String value) {
            addCriterion("private_key like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotLike(String value) {
            addCriterion("private_key not like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIn(List<String> values) {
            addCriterion("private_key in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotIn(List<String> values) {
            addCriterion("private_key not in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyBetween(String value1, String value2) {
            addCriterion("private_key between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("private_key not between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNull() {
            addCriterion("public_key is null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNotNull() {
            addCriterion("public_key is not null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyEqualTo(String value) {
            addCriterion("public_key =", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotEqualTo(String value) {
            addCriterion("public_key <>", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThan(String value) {
            addCriterion("public_key >", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("public_key >=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThan(String value) {
            addCriterion("public_key <", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("public_key <=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLike(String value) {
            addCriterion("public_key like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotLike(String value) {
            addCriterion("public_key not like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIn(List<String> values) {
            addCriterion("public_key in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotIn(List<String> values) {
            addCriterion("public_key not in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyBetween(String value1, String value2) {
            addCriterion("public_key between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotBetween(String value1, String value2) {
            addCriterion("public_key not between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAccAddressIsNull() {
            addCriterion("acc_address is null");
            return (Criteria) this;
        }

        public Criteria andAccAddressIsNotNull() {
            addCriterion("acc_address is not null");
            return (Criteria) this;
        }

        public Criteria andAccAddressEqualTo(String value) {
            addCriterion("acc_address =", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressNotEqualTo(String value) {
            addCriterion("acc_address <>", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressGreaterThan(String value) {
            addCriterion("acc_address >", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressGreaterThanOrEqualTo(String value) {
            addCriterion("acc_address >=", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressLessThan(String value) {
            addCriterion("acc_address <", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressLessThanOrEqualTo(String value) {
            addCriterion("acc_address <=", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressLike(String value) {
            addCriterion("acc_address like", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressNotLike(String value) {
            addCriterion("acc_address not like", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressIn(List<String> values) {
            addCriterion("acc_address in", values, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressNotIn(List<String> values) {
            addCriterion("acc_address not in", values, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressBetween(String value1, String value2) {
            addCriterion("acc_address between", value1, value2, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressNotBetween(String value1, String value2) {
            addCriterion("acc_address not between", value1, value2, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Byte value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Byte value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Byte value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Byte value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Byte value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Byte> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Byte> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Byte value1, Byte value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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