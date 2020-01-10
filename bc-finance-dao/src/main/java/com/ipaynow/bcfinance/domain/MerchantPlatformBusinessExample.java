package com.ipaynow.bcfinance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantPlatformBusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantPlatformBusinessExample() {
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

        public Criteria andPlatformNameIsNull() {
            addCriterion("platform_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNotNull() {
            addCriterion("platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameEqualTo(String value) {
            addCriterion("platform_name =", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotEqualTo(String value) {
            addCriterion("platform_name <>", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThan(String value) {
            addCriterion("platform_name >", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("platform_name >=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThan(String value) {
            addCriterion("platform_name <", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThanOrEqualTo(String value) {
            addCriterion("platform_name <=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLike(String value) {
            addCriterion("platform_name like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotLike(String value) {
            addCriterion("platform_name not like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIn(List<String> values) {
            addCriterion("platform_name in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotIn(List<String> values) {
            addCriterion("platform_name not in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameBetween(String value1, String value2) {
            addCriterion("platform_name between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotBetween(String value1, String value2) {
            addCriterion("platform_name not between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andStockAmountIsNull() {
            addCriterion("stock_amount is null");
            return (Criteria) this;
        }

        public Criteria andStockAmountIsNotNull() {
            addCriterion("stock_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStockAmountEqualTo(String value) {
            addCriterion("stock_amount =", value, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountNotEqualTo(String value) {
            addCriterion("stock_amount <>", value, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountGreaterThan(String value) {
            addCriterion("stock_amount >", value, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountGreaterThanOrEqualTo(String value) {
            addCriterion("stock_amount >=", value, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountLessThan(String value) {
            addCriterion("stock_amount <", value, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountLessThanOrEqualTo(String value) {
            addCriterion("stock_amount <=", value, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountLike(String value) {
            addCriterion("stock_amount like", value, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountNotLike(String value) {
            addCriterion("stock_amount not like", value, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountIn(List<String> values) {
            addCriterion("stock_amount in", values, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountNotIn(List<String> values) {
            addCriterion("stock_amount not in", values, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountBetween(String value1, String value2) {
            addCriterion("stock_amount between", value1, value2, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andStockAmountNotBetween(String value1, String value2) {
            addCriterion("stock_amount not between", value1, value2, "stockAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountIsNull() {
            addCriterion("sold_for_settlement_amount is null");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountIsNotNull() {
            addCriterion("sold_for_settlement_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountEqualTo(String value) {
            addCriterion("sold_for_settlement_amount =", value, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountNotEqualTo(String value) {
            addCriterion("sold_for_settlement_amount <>", value, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountGreaterThan(String value) {
            addCriterion("sold_for_settlement_amount >", value, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountGreaterThanOrEqualTo(String value) {
            addCriterion("sold_for_settlement_amount >=", value, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountLessThan(String value) {
            addCriterion("sold_for_settlement_amount <", value, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountLessThanOrEqualTo(String value) {
            addCriterion("sold_for_settlement_amount <=", value, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountLike(String value) {
            addCriterion("sold_for_settlement_amount like", value, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountNotLike(String value) {
            addCriterion("sold_for_settlement_amount not like", value, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountIn(List<String> values) {
            addCriterion("sold_for_settlement_amount in", values, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountNotIn(List<String> values) {
            addCriterion("sold_for_settlement_amount not in", values, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountBetween(String value1, String value2) {
            addCriterion("sold_for_settlement_amount between", value1, value2, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSoldForSettlementAmountNotBetween(String value1, String value2) {
            addCriterion("sold_for_settlement_amount not between", value1, value2, "soldForSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountIsNull() {
            addCriterion("settled_for_payment_amount is null");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountIsNotNull() {
            addCriterion("settled_for_payment_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountEqualTo(String value) {
            addCriterion("settled_for_payment_amount =", value, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountNotEqualTo(String value) {
            addCriterion("settled_for_payment_amount <>", value, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountGreaterThan(String value) {
            addCriterion("settled_for_payment_amount >", value, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountGreaterThanOrEqualTo(String value) {
            addCriterion("settled_for_payment_amount >=", value, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountLessThan(String value) {
            addCriterion("settled_for_payment_amount <", value, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountLessThanOrEqualTo(String value) {
            addCriterion("settled_for_payment_amount <=", value, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountLike(String value) {
            addCriterion("settled_for_payment_amount like", value, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountNotLike(String value) {
            addCriterion("settled_for_payment_amount not like", value, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountIn(List<String> values) {
            addCriterion("settled_for_payment_amount in", values, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountNotIn(List<String> values) {
            addCriterion("settled_for_payment_amount not in", values, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountBetween(String value1, String value2) {
            addCriterion("settled_for_payment_amount between", value1, value2, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andSettledForPaymentAmountNotBetween(String value1, String value2) {
            addCriterion("settled_for_payment_amount not between", value1, value2, "settledForPaymentAmount");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioIsNull() {
            addCriterion("stock_turn_over_ratio is null");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioIsNotNull() {
            addCriterion("stock_turn_over_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioEqualTo(String value) {
            addCriterion("stock_turn_over_ratio =", value, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioNotEqualTo(String value) {
            addCriterion("stock_turn_over_ratio <>", value, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioGreaterThan(String value) {
            addCriterion("stock_turn_over_ratio >", value, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioGreaterThanOrEqualTo(String value) {
            addCriterion("stock_turn_over_ratio >=", value, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioLessThan(String value) {
            addCriterion("stock_turn_over_ratio <", value, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioLessThanOrEqualTo(String value) {
            addCriterion("stock_turn_over_ratio <=", value, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioLike(String value) {
            addCriterion("stock_turn_over_ratio like", value, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioNotLike(String value) {
            addCriterion("stock_turn_over_ratio not like", value, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioIn(List<String> values) {
            addCriterion("stock_turn_over_ratio in", values, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioNotIn(List<String> values) {
            addCriterion("stock_turn_over_ratio not in", values, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioBetween(String value1, String value2) {
            addCriterion("stock_turn_over_ratio between", value1, value2, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andStockTurnOverRatioNotBetween(String value1, String value2) {
            addCriterion("stock_turn_over_ratio not between", value1, value2, "stockTurnOverRatio");
            return (Criteria) this;
        }

        public Criteria andReturnRateIsNull() {
            addCriterion("return_rate is null");
            return (Criteria) this;
        }

        public Criteria andReturnRateIsNotNull() {
            addCriterion("return_rate is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRateEqualTo(String value) {
            addCriterion("return_rate =", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateNotEqualTo(String value) {
            addCriterion("return_rate <>", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateGreaterThan(String value) {
            addCriterion("return_rate >", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateGreaterThanOrEqualTo(String value) {
            addCriterion("return_rate >=", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateLessThan(String value) {
            addCriterion("return_rate <", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateLessThanOrEqualTo(String value) {
            addCriterion("return_rate <=", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateLike(String value) {
            addCriterion("return_rate like", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateNotLike(String value) {
            addCriterion("return_rate not like", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateIn(List<String> values) {
            addCriterion("return_rate in", values, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateNotIn(List<String> values) {
            addCriterion("return_rate not in", values, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateBetween(String value1, String value2) {
            addCriterion("return_rate between", value1, value2, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateNotBetween(String value1, String value2) {
            addCriterion("return_rate not between", value1, value2, "returnRate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateIsNull() {
            addCriterion("statistical_date is null");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateIsNotNull() {
            addCriterion("statistical_date is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateEqualTo(String value) {
            addCriterion("statistical_date =", value, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateNotEqualTo(String value) {
            addCriterion("statistical_date <>", value, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateGreaterThan(String value) {
            addCriterion("statistical_date >", value, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateGreaterThanOrEqualTo(String value) {
            addCriterion("statistical_date >=", value, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateLessThan(String value) {
            addCriterion("statistical_date <", value, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateLessThanOrEqualTo(String value) {
            addCriterion("statistical_date <=", value, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateLike(String value) {
            addCriterion("statistical_date like", value, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateNotLike(String value) {
            addCriterion("statistical_date not like", value, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateIn(List<String> values) {
            addCriterion("statistical_date in", values, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateNotIn(List<String> values) {
            addCriterion("statistical_date not in", values, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateBetween(String value1, String value2) {
            addCriterion("statistical_date between", value1, value2, "statisticalDate");
            return (Criteria) this;
        }

        public Criteria andStatisticalDateNotBetween(String value1, String value2) {
            addCriterion("statistical_date not between", value1, value2, "statisticalDate");
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

        public Criteria andAssetAddressIsNull() {
            addCriterion("asset_address is null");
            return (Criteria) this;
        }

        public Criteria andAssetAddressIsNotNull() {
            addCriterion("asset_address is not null");
            return (Criteria) this;
        }

        public Criteria andAssetAddressEqualTo(String value) {
            addCriterion("asset_address =", value, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressNotEqualTo(String value) {
            addCriterion("asset_address <>", value, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressGreaterThan(String value) {
            addCriterion("asset_address >", value, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressGreaterThanOrEqualTo(String value) {
            addCriterion("asset_address >=", value, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressLessThan(String value) {
            addCriterion("asset_address <", value, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressLessThanOrEqualTo(String value) {
            addCriterion("asset_address <=", value, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressLike(String value) {
            addCriterion("asset_address like", value, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressNotLike(String value) {
            addCriterion("asset_address not like", value, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressIn(List<String> values) {
            addCriterion("asset_address in", values, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressNotIn(List<String> values) {
            addCriterion("asset_address not in", values, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressBetween(String value1, String value2) {
            addCriterion("asset_address between", value1, value2, "assetAddress");
            return (Criteria) this;
        }

        public Criteria andAssetAddressNotBetween(String value1, String value2) {
            addCriterion("asset_address not between", value1, value2, "assetAddress");
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