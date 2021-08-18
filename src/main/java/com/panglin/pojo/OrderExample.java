package com.panglin.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringIsNull() {
            addCriterion("create_time_string is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringIsNotNull() {
            addCriterion("create_time_string is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringEqualTo(String value) {
            addCriterion("create_time_string =", value, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringNotEqualTo(String value) {
            addCriterion("create_time_string <>", value, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringGreaterThan(String value) {
            addCriterion("create_time_string >", value, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringGreaterThanOrEqualTo(String value) {
            addCriterion("create_time_string >=", value, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringLessThan(String value) {
            addCriterion("create_time_string <", value, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringLessThanOrEqualTo(String value) {
            addCriterion("create_time_string <=", value, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringLike(String value) {
            addCriterion("create_time_string like", value, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringNotLike(String value) {
            addCriterion("create_time_string not like", value, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringIn(List<String> values) {
            addCriterion("create_time_string in", values, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringNotIn(List<String> values) {
            addCriterion("create_time_string not in", values, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringBetween(String value1, String value2) {
            addCriterion("create_time_string between", value1, value2, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andCreateTimeStringNotBetween(String value1, String value2) {
            addCriterion("create_time_string not between", value1, value2, "createTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringIsNull() {
            addCriterion("pay_time_string is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringIsNotNull() {
            addCriterion("pay_time_string is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringEqualTo(String value) {
            addCriterion("pay_time_string =", value, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringNotEqualTo(String value) {
            addCriterion("pay_time_string <>", value, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringGreaterThan(String value) {
            addCriterion("pay_time_string >", value, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringGreaterThanOrEqualTo(String value) {
            addCriterion("pay_time_string >=", value, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringLessThan(String value) {
            addCriterion("pay_time_string <", value, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringLessThanOrEqualTo(String value) {
            addCriterion("pay_time_string <=", value, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringLike(String value) {
            addCriterion("pay_time_string like", value, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringNotLike(String value) {
            addCriterion("pay_time_string not like", value, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringIn(List<String> values) {
            addCriterion("pay_time_string in", values, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringNotIn(List<String> values) {
            addCriterion("pay_time_string not in", values, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringBetween(String value1, String value2) {
            addCriterion("pay_time_string between", value1, value2, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPayTimeStringNotBetween(String value1, String value2) {
            addCriterion("pay_time_string not between", value1, value2, "payTimeString");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Integer value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Integer value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Integer value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Integer value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Integer> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Integer> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringIsNull() {
            addCriterion("order_state_string is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringIsNotNull() {
            addCriterion("order_state_string is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringEqualTo(String value) {
            addCriterion("order_state_string =", value, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringNotEqualTo(String value) {
            addCriterion("order_state_string <>", value, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringGreaterThan(String value) {
            addCriterion("order_state_string >", value, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringGreaterThanOrEqualTo(String value) {
            addCriterion("order_state_string >=", value, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringLessThan(String value) {
            addCriterion("order_state_string <", value, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringLessThanOrEqualTo(String value) {
            addCriterion("order_state_string <=", value, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringLike(String value) {
            addCriterion("order_state_string like", value, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringNotLike(String value) {
            addCriterion("order_state_string not like", value, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringIn(List<String> values) {
            addCriterion("order_state_string in", values, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringNotIn(List<String> values) {
            addCriterion("order_state_string not in", values, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringBetween(String value1, String value2) {
            addCriterion("order_state_string between", value1, value2, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andOrderStateStringNotBetween(String value1, String value2) {
            addCriterion("order_state_string not between", value1, value2, "orderStateString");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdIsNull() {
            addCriterion("pay_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdIsNotNull() {
            addCriterion("pay_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdEqualTo(Integer value) {
            addCriterion("pay_admin_id =", value, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdNotEqualTo(Integer value) {
            addCriterion("pay_admin_id <>", value, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdGreaterThan(Integer value) {
            addCriterion("pay_admin_id >", value, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_admin_id >=", value, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdLessThan(Integer value) {
            addCriterion("pay_admin_id <", value, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("pay_admin_id <=", value, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdIn(List<Integer> values) {
            addCriterion("pay_admin_id in", values, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdNotIn(List<Integer> values) {
            addCriterion("pay_admin_id not in", values, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("pay_admin_id between", value1, value2, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andPayAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_admin_id not between", value1, value2, "payAdminId");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityIsNull() {
            addCriterion("water_or_electricity is null");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityIsNotNull() {
            addCriterion("water_or_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityEqualTo(Integer value) {
            addCriterion("water_or_electricity =", value, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityNotEqualTo(Integer value) {
            addCriterion("water_or_electricity <>", value, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityGreaterThan(Integer value) {
            addCriterion("water_or_electricity >", value, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityGreaterThanOrEqualTo(Integer value) {
            addCriterion("water_or_electricity >=", value, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityLessThan(Integer value) {
            addCriterion("water_or_electricity <", value, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityLessThanOrEqualTo(Integer value) {
            addCriterion("water_or_electricity <=", value, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityIn(List<Integer> values) {
            addCriterion("water_or_electricity in", values, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityNotIn(List<Integer> values) {
            addCriterion("water_or_electricity not in", values, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityBetween(Integer value1, Integer value2) {
            addCriterion("water_or_electricity between", value1, value2, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityNotBetween(Integer value1, Integer value2) {
            addCriterion("water_or_electricity not between", value1, value2, "waterOrElectricity");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringIsNull() {
            addCriterion("water_or_electricity_string is null");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringIsNotNull() {
            addCriterion("water_or_electricity_string is not null");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringEqualTo(String value) {
            addCriterion("water_or_electricity_string =", value, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringNotEqualTo(String value) {
            addCriterion("water_or_electricity_string <>", value, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringGreaterThan(String value) {
            addCriterion("water_or_electricity_string >", value, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringGreaterThanOrEqualTo(String value) {
            addCriterion("water_or_electricity_string >=", value, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringLessThan(String value) {
            addCriterion("water_or_electricity_string <", value, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringLessThanOrEqualTo(String value) {
            addCriterion("water_or_electricity_string <=", value, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringLike(String value) {
            addCriterion("water_or_electricity_string like", value, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringNotLike(String value) {
            addCriterion("water_or_electricity_string not like", value, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringIn(List<String> values) {
            addCriterion("water_or_electricity_string in", values, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringNotIn(List<String> values) {
            addCriterion("water_or_electricity_string not in", values, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringBetween(String value1, String value2) {
            addCriterion("water_or_electricity_string between", value1, value2, "waterOrElectricityString");
            return (Criteria) this;
        }

        public Criteria andWaterOrElectricityStringNotBetween(String value1, String value2) {
            addCriterion("water_or_electricity_string not between", value1, value2, "waterOrElectricityString");
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