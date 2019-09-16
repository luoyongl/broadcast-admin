package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BDeviceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDeviceInfoExample() {
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

        public Criteria andFIdIsNull() {
            addCriterion("f_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("f_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Integer value) {
            addCriterion("f_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Integer value) {
            addCriterion("f_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Integer value) {
            addCriterion("f_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Integer value) {
            addCriterion("f_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Integer> values) {
            addCriterion("f_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Integer> values) {
            addCriterion("f_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Integer value1, Integer value2) {
            addCriterion("f_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeIsNull() {
            addCriterion("f_device_type is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeIsNotNull() {
            addCriterion("f_device_type is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeEqualTo(Byte value) {
            addCriterion("f_device_type =", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotEqualTo(Byte value) {
            addCriterion("f_device_type <>", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeGreaterThan(Byte value) {
            addCriterion("f_device_type >", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_device_type >=", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeLessThan(Byte value) {
            addCriterion("f_device_type <", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_device_type <=", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeIn(List<Byte> values) {
            addCriterion("f_device_type in", values, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotIn(List<Byte> values) {
            addCriterion("f_device_type not in", values, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_device_type between", value1, value2, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_device_type not between", value1, value2, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameIsNull() {
            addCriterion("f_device_name is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameIsNotNull() {
            addCriterion("f_device_name is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameEqualTo(String value) {
            addCriterion("f_device_name =", value, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameNotEqualTo(String value) {
            addCriterion("f_device_name <>", value, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameGreaterThan(String value) {
            addCriterion("f_device_name >", value, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_name >=", value, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameLessThan(String value) {
            addCriterion("f_device_name <", value, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("f_device_name <=", value, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameLike(String value) {
            addCriterion("f_device_name like", value, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameNotLike(String value) {
            addCriterion("f_device_name not like", value, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameIn(List<String> values) {
            addCriterion("f_device_name in", values, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameNotIn(List<String> values) {
            addCriterion("f_device_name not in", values, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameBetween(String value1, String value2) {
            addCriterion("f_device_name between", value1, value2, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceNameNotBetween(String value1, String value2) {
            addCriterion("f_device_name not between", value1, value2, "fDeviceName");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeIsNull() {
            addCriterion("f_device_resource_code is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeIsNotNull() {
            addCriterion("f_device_resource_code is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeEqualTo(String value) {
            addCriterion("f_device_resource_code =", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotEqualTo(String value) {
            addCriterion("f_device_resource_code <>", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeGreaterThan(String value) {
            addCriterion("f_device_resource_code >", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_resource_code >=", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeLessThan(String value) {
            addCriterion("f_device_resource_code <", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeLessThanOrEqualTo(String value) {
            addCriterion("f_device_resource_code <=", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeLike(String value) {
            addCriterion("f_device_resource_code like", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotLike(String value) {
            addCriterion("f_device_resource_code not like", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeIn(List<String> values) {
            addCriterion("f_device_resource_code in", values, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotIn(List<String> values) {
            addCriterion("f_device_resource_code not in", values, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeBetween(String value1, String value2) {
            addCriterion("f_device_resource_code between", value1, value2, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotBetween(String value1, String value2) {
            addCriterion("f_device_resource_code not between", value1, value2, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateIsNull() {
            addCriterion("f_device_state is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateIsNotNull() {
            addCriterion("f_device_state is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateEqualTo(String value) {
            addCriterion("f_device_state =", value, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateNotEqualTo(String value) {
            addCriterion("f_device_state <>", value, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateGreaterThan(String value) {
            addCriterion("f_device_state >", value, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_state >=", value, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateLessThan(String value) {
            addCriterion("f_device_state <", value, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateLessThanOrEqualTo(String value) {
            addCriterion("f_device_state <=", value, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateLike(String value) {
            addCriterion("f_device_state like", value, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateNotLike(String value) {
            addCriterion("f_device_state not like", value, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateIn(List<String> values) {
            addCriterion("f_device_state in", values, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateNotIn(List<String> values) {
            addCriterion("f_device_state not in", values, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateBetween(String value1, String value2) {
            addCriterion("f_device_state between", value1, value2, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFDeviceStateNotBetween(String value1, String value2) {
            addCriterion("f_device_state not between", value1, value2, "fDeviceState");
            return (Criteria) this;
        }

        public Criteria andFNumberIsNull() {
            addCriterion("f_number is null");
            return (Criteria) this;
        }

        public Criteria andFNumberIsNotNull() {
            addCriterion("f_number is not null");
            return (Criteria) this;
        }

        public Criteria andFNumberEqualTo(String value) {
            addCriterion("f_number =", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberNotEqualTo(String value) {
            addCriterion("f_number <>", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberGreaterThan(String value) {
            addCriterion("f_number >", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_number >=", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberLessThan(String value) {
            addCriterion("f_number <", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberLessThanOrEqualTo(String value) {
            addCriterion("f_number <=", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberLike(String value) {
            addCriterion("f_number like", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberNotLike(String value) {
            addCriterion("f_number not like", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberIn(List<String> values) {
            addCriterion("f_number in", values, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberNotIn(List<String> values) {
            addCriterion("f_number not in", values, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberBetween(String value1, String value2) {
            addCriterion("f_number between", value1, value2, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberNotBetween(String value1, String value2) {
            addCriterion("f_number not between", value1, value2, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageIsNull() {
            addCriterion("f_device_image is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageIsNotNull() {
            addCriterion("f_device_image is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageEqualTo(String value) {
            addCriterion("f_device_image =", value, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageNotEqualTo(String value) {
            addCriterion("f_device_image <>", value, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageGreaterThan(String value) {
            addCriterion("f_device_image >", value, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_image >=", value, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageLessThan(String value) {
            addCriterion("f_device_image <", value, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageLessThanOrEqualTo(String value) {
            addCriterion("f_device_image <=", value, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageLike(String value) {
            addCriterion("f_device_image like", value, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageNotLike(String value) {
            addCriterion("f_device_image not like", value, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageIn(List<String> values) {
            addCriterion("f_device_image in", values, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageNotIn(List<String> values) {
            addCriterion("f_device_image not in", values, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageBetween(String value1, String value2) {
            addCriterion("f_device_image between", value1, value2, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceImageNotBetween(String value1, String value2) {
            addCriterion("f_device_image not between", value1, value2, "fDeviceImage");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpIsNull() {
            addCriterion("f_device_ip is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpIsNotNull() {
            addCriterion("f_device_ip is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpEqualTo(String value) {
            addCriterion("f_device_ip =", value, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpNotEqualTo(String value) {
            addCriterion("f_device_ip <>", value, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpGreaterThan(String value) {
            addCriterion("f_device_ip >", value, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_ip >=", value, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpLessThan(String value) {
            addCriterion("f_device_ip <", value, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpLessThanOrEqualTo(String value) {
            addCriterion("f_device_ip <=", value, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpLike(String value) {
            addCriterion("f_device_ip like", value, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpNotLike(String value) {
            addCriterion("f_device_ip not like", value, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpIn(List<String> values) {
            addCriterion("f_device_ip in", values, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpNotIn(List<String> values) {
            addCriterion("f_device_ip not in", values, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpBetween(String value1, String value2) {
            addCriterion("f_device_ip between", value1, value2, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDeviceIpNotBetween(String value1, String value2) {
            addCriterion("f_device_ip not between", value1, value2, "fDeviceIp");
            return (Criteria) this;
        }

        public Criteria andFDevicePortIsNull() {
            addCriterion("f_device_port is null");
            return (Criteria) this;
        }

        public Criteria andFDevicePortIsNotNull() {
            addCriterion("f_device_port is not null");
            return (Criteria) this;
        }

        public Criteria andFDevicePortEqualTo(String value) {
            addCriterion("f_device_port =", value, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortNotEqualTo(String value) {
            addCriterion("f_device_port <>", value, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortGreaterThan(String value) {
            addCriterion("f_device_port >", value, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_port >=", value, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortLessThan(String value) {
            addCriterion("f_device_port <", value, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortLessThanOrEqualTo(String value) {
            addCriterion("f_device_port <=", value, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortLike(String value) {
            addCriterion("f_device_port like", value, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortNotLike(String value) {
            addCriterion("f_device_port not like", value, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortIn(List<String> values) {
            addCriterion("f_device_port in", values, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortNotIn(List<String> values) {
            addCriterion("f_device_port not in", values, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortBetween(String value1, String value2) {
            addCriterion("f_device_port between", value1, value2, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDevicePortNotBetween(String value1, String value2) {
            addCriterion("f_device_port not between", value1, value2, "fDevicePort");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelIsNull() {
            addCriterion("f_device_model is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelIsNotNull() {
            addCriterion("f_device_model is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelEqualTo(String value) {
            addCriterion("f_device_model =", value, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelNotEqualTo(String value) {
            addCriterion("f_device_model <>", value, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelGreaterThan(String value) {
            addCriterion("f_device_model >", value, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_model >=", value, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelLessThan(String value) {
            addCriterion("f_device_model <", value, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelLessThanOrEqualTo(String value) {
            addCriterion("f_device_model <=", value, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelLike(String value) {
            addCriterion("f_device_model like", value, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelNotLike(String value) {
            addCriterion("f_device_model not like", value, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelIn(List<String> values) {
            addCriterion("f_device_model in", values, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelNotIn(List<String> values) {
            addCriterion("f_device_model not in", values, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelBetween(String value1, String value2) {
            addCriterion("f_device_model between", value1, value2, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFDeviceModelNotBetween(String value1, String value2) {
            addCriterion("f_device_model not between", value1, value2, "fDeviceModel");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeIsNull() {
            addCriterion("f_physical_code is null");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeIsNotNull() {
            addCriterion("f_physical_code is not null");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeEqualTo(String value) {
            addCriterion("f_physical_code =", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeNotEqualTo(String value) {
            addCriterion("f_physical_code <>", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeGreaterThan(String value) {
            addCriterion("f_physical_code >", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_physical_code >=", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeLessThan(String value) {
            addCriterion("f_physical_code <", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeLessThanOrEqualTo(String value) {
            addCriterion("f_physical_code <=", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeLike(String value) {
            addCriterion("f_physical_code like", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeNotLike(String value) {
            addCriterion("f_physical_code not like", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeIn(List<String> values) {
            addCriterion("f_physical_code in", values, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeNotIn(List<String> values) {
            addCriterion("f_physical_code not in", values, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeBetween(String value1, String value2) {
            addCriterion("f_physical_code between", value1, value2, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeNotBetween(String value1, String value2) {
            addCriterion("f_physical_code not between", value1, value2, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFLocationIsNull() {
            addCriterion("f_location is null");
            return (Criteria) this;
        }

        public Criteria andFLocationIsNotNull() {
            addCriterion("f_location is not null");
            return (Criteria) this;
        }

        public Criteria andFLocationEqualTo(Integer value) {
            addCriterion("f_location =", value, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFLocationNotEqualTo(Integer value) {
            addCriterion("f_location <>", value, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFLocationGreaterThan(Integer value) {
            addCriterion("f_location >", value, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFLocationGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_location >=", value, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFLocationLessThan(Integer value) {
            addCriterion("f_location <", value, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFLocationLessThanOrEqualTo(Integer value) {
            addCriterion("f_location <=", value, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFLocationIn(List<Integer> values) {
            addCriterion("f_location in", values, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFLocationNotIn(List<Integer> values) {
            addCriterion("f_location not in", values, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFLocationBetween(Integer value1, Integer value2) {
            addCriterion("f_location between", value1, value2, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFLocationNotBetween(Integer value1, Integer value2) {
            addCriterion("f_location not between", value1, value2, "fLocation");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressIsNull() {
            addCriterion("f_install_address is null");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressIsNotNull() {
            addCriterion("f_install_address is not null");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressEqualTo(String value) {
            addCriterion("f_install_address =", value, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressNotEqualTo(String value) {
            addCriterion("f_install_address <>", value, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressGreaterThan(String value) {
            addCriterion("f_install_address >", value, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressGreaterThanOrEqualTo(String value) {
            addCriterion("f_install_address >=", value, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressLessThan(String value) {
            addCriterion("f_install_address <", value, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressLessThanOrEqualTo(String value) {
            addCriterion("f_install_address <=", value, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressLike(String value) {
            addCriterion("f_install_address like", value, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressNotLike(String value) {
            addCriterion("f_install_address not like", value, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressIn(List<String> values) {
            addCriterion("f_install_address in", values, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressNotIn(List<String> values) {
            addCriterion("f_install_address not in", values, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressBetween(String value1, String value2) {
            addCriterion("f_install_address between", value1, value2, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFInstallAddressNotBetween(String value1, String value2) {
            addCriterion("f_install_address not between", value1, value2, "fInstallAddress");
            return (Criteria) this;
        }

        public Criteria andFLongitudeIsNull() {
            addCriterion("f_longitude is null");
            return (Criteria) this;
        }

        public Criteria andFLongitudeIsNotNull() {
            addCriterion("f_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andFLongitudeEqualTo(String value) {
            addCriterion("f_longitude =", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeNotEqualTo(String value) {
            addCriterion("f_longitude <>", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeGreaterThan(String value) {
            addCriterion("f_longitude >", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("f_longitude >=", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeLessThan(String value) {
            addCriterion("f_longitude <", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeLessThanOrEqualTo(String value) {
            addCriterion("f_longitude <=", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeLike(String value) {
            addCriterion("f_longitude like", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeNotLike(String value) {
            addCriterion("f_longitude not like", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeIn(List<String> values) {
            addCriterion("f_longitude in", values, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeNotIn(List<String> values) {
            addCriterion("f_longitude not in", values, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeBetween(String value1, String value2) {
            addCriterion("f_longitude between", value1, value2, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeNotBetween(String value1, String value2) {
            addCriterion("f_longitude not between", value1, value2, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFDimensionIsNull() {
            addCriterion("f_dimension is null");
            return (Criteria) this;
        }

        public Criteria andFDimensionIsNotNull() {
            addCriterion("f_dimension is not null");
            return (Criteria) this;
        }

        public Criteria andFDimensionEqualTo(String value) {
            addCriterion("f_dimension =", value, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionNotEqualTo(String value) {
            addCriterion("f_dimension <>", value, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionGreaterThan(String value) {
            addCriterion("f_dimension >", value, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionGreaterThanOrEqualTo(String value) {
            addCriterion("f_dimension >=", value, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionLessThan(String value) {
            addCriterion("f_dimension <", value, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionLessThanOrEqualTo(String value) {
            addCriterion("f_dimension <=", value, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionLike(String value) {
            addCriterion("f_dimension like", value, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionNotLike(String value) {
            addCriterion("f_dimension not like", value, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionIn(List<String> values) {
            addCriterion("f_dimension in", values, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionNotIn(List<String> values) {
            addCriterion("f_dimension not in", values, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionBetween(String value1, String value2) {
            addCriterion("f_dimension between", value1, value2, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFDimensionNotBetween(String value1, String value2) {
            addCriterion("f_dimension not between", value1, value2, "fDimension");
            return (Criteria) this;
        }

        public Criteria andFUrlIsNull() {
            addCriterion("f_url is null");
            return (Criteria) this;
        }

        public Criteria andFUrlIsNotNull() {
            addCriterion("f_url is not null");
            return (Criteria) this;
        }

        public Criteria andFUrlEqualTo(String value) {
            addCriterion("f_url =", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlNotEqualTo(String value) {
            addCriterion("f_url <>", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlGreaterThan(String value) {
            addCriterion("f_url >", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlGreaterThanOrEqualTo(String value) {
            addCriterion("f_url >=", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlLessThan(String value) {
            addCriterion("f_url <", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlLessThanOrEqualTo(String value) {
            addCriterion("f_url <=", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlLike(String value) {
            addCriterion("f_url like", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlNotLike(String value) {
            addCriterion("f_url not like", value, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlIn(List<String> values) {
            addCriterion("f_url in", values, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlNotIn(List<String> values) {
            addCriterion("f_url not in", values, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlBetween(String value1, String value2) {
            addCriterion("f_url between", value1, value2, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFUrlNotBetween(String value1, String value2) {
            addCriterion("f_url not between", value1, value2, "fUrl");
            return (Criteria) this;
        }

        public Criteria andFEnableStateIsNull() {
            addCriterion("f_enable_state is null");
            return (Criteria) this;
        }

        public Criteria andFEnableStateIsNotNull() {
            addCriterion("f_enable_state is not null");
            return (Criteria) this;
        }

        public Criteria andFEnableStateEqualTo(Boolean value) {
            addCriterion("f_enable_state =", value, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFEnableStateNotEqualTo(Boolean value) {
            addCriterion("f_enable_state <>", value, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFEnableStateGreaterThan(Boolean value) {
            addCriterion("f_enable_state >", value, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFEnableStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_enable_state >=", value, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFEnableStateLessThan(Boolean value) {
            addCriterion("f_enable_state <", value, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFEnableStateLessThanOrEqualTo(Boolean value) {
            addCriterion("f_enable_state <=", value, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFEnableStateIn(List<Boolean> values) {
            addCriterion("f_enable_state in", values, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFEnableStateNotIn(List<Boolean> values) {
            addCriterion("f_enable_state not in", values, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFEnableStateBetween(Boolean value1, Boolean value2) {
            addCriterion("f_enable_state between", value1, value2, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFEnableStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_enable_state not between", value1, value2, "fEnableState");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandIsNull() {
            addCriterion("f_device_band is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandIsNotNull() {
            addCriterion("f_device_band is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandEqualTo(String value) {
            addCriterion("f_device_band =", value, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandNotEqualTo(String value) {
            addCriterion("f_device_band <>", value, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandGreaterThan(String value) {
            addCriterion("f_device_band >", value, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_band >=", value, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandLessThan(String value) {
            addCriterion("f_device_band <", value, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandLessThanOrEqualTo(String value) {
            addCriterion("f_device_band <=", value, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandLike(String value) {
            addCriterion("f_device_band like", value, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandNotLike(String value) {
            addCriterion("f_device_band not like", value, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandIn(List<String> values) {
            addCriterion("f_device_band in", values, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandNotIn(List<String> values) {
            addCriterion("f_device_band not in", values, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandBetween(String value1, String value2) {
            addCriterion("f_device_band between", value1, value2, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFDeviceBandNotBetween(String value1, String value2) {
            addCriterion("f_device_band not between", value1, value2, "fDeviceBand");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidIsNull() {
            addCriterion("f_accept_command_pid is null");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidIsNotNull() {
            addCriterion("f_accept_command_pid is not null");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidEqualTo(String value) {
            addCriterion("f_accept_command_pid =", value, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidNotEqualTo(String value) {
            addCriterion("f_accept_command_pid <>", value, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidGreaterThan(String value) {
            addCriterion("f_accept_command_pid >", value, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidGreaterThanOrEqualTo(String value) {
            addCriterion("f_accept_command_pid >=", value, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidLessThan(String value) {
            addCriterion("f_accept_command_pid <", value, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidLessThanOrEqualTo(String value) {
            addCriterion("f_accept_command_pid <=", value, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidLike(String value) {
            addCriterion("f_accept_command_pid like", value, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidNotLike(String value) {
            addCriterion("f_accept_command_pid not like", value, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidIn(List<String> values) {
            addCriterion("f_accept_command_pid in", values, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidNotIn(List<String> values) {
            addCriterion("f_accept_command_pid not in", values, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidBetween(String value1, String value2) {
            addCriterion("f_accept_command_pid between", value1, value2, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFAcceptCommandPidNotBetween(String value1, String value2) {
            addCriterion("f_accept_command_pid not between", value1, value2, "fAcceptCommandPid");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelIsNull() {
            addCriterion("f_display_level is null");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelIsNotNull() {
            addCriterion("f_display_level is not null");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelEqualTo(String value) {
            addCriterion("f_display_level =", value, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelNotEqualTo(String value) {
            addCriterion("f_display_level <>", value, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelGreaterThan(String value) {
            addCriterion("f_display_level >", value, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelGreaterThanOrEqualTo(String value) {
            addCriterion("f_display_level >=", value, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelLessThan(String value) {
            addCriterion("f_display_level <", value, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelLessThanOrEqualTo(String value) {
            addCriterion("f_display_level <=", value, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelLike(String value) {
            addCriterion("f_display_level like", value, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelNotLike(String value) {
            addCriterion("f_display_level not like", value, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelIn(List<String> values) {
            addCriterion("f_display_level in", values, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelNotIn(List<String> values) {
            addCriterion("f_display_level not in", values, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelBetween(String value1, String value2) {
            addCriterion("f_display_level between", value1, value2, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFDisplayLevelNotBetween(String value1, String value2) {
            addCriterion("f_display_level not between", value1, value2, "fDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNull() {
            addCriterion("f_remark is null");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNotNull() {
            addCriterion("f_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFRemarkEqualTo(String value) {
            addCriterion("f_remark =", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotEqualTo(String value) {
            addCriterion("f_remark <>", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThan(String value) {
            addCriterion("f_remark >", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("f_remark >=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThan(String value) {
            addCriterion("f_remark <", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThanOrEqualTo(String value) {
            addCriterion("f_remark <=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLike(String value) {
            addCriterion("f_remark like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotLike(String value) {
            addCriterion("f_remark not like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkIn(List<String> values) {
            addCriterion("f_remark in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotIn(List<String> values) {
            addCriterion("f_remark not in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkBetween(String value1, String value2) {
            addCriterion("f_remark between", value1, value2, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotBetween(String value1, String value2) {
            addCriterion("f_remark not between", value1, value2, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFCertificateIsNull() {
            addCriterion("f_certificate is null");
            return (Criteria) this;
        }

        public Criteria andFCertificateIsNotNull() {
            addCriterion("f_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andFCertificateEqualTo(String value) {
            addCriterion("f_certificate =", value, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateNotEqualTo(String value) {
            addCriterion("f_certificate <>", value, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateGreaterThan(String value) {
            addCriterion("f_certificate >", value, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("f_certificate >=", value, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateLessThan(String value) {
            addCriterion("f_certificate <", value, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateLessThanOrEqualTo(String value) {
            addCriterion("f_certificate <=", value, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateLike(String value) {
            addCriterion("f_certificate like", value, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateNotLike(String value) {
            addCriterion("f_certificate not like", value, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateIn(List<String> values) {
            addCriterion("f_certificate in", values, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateNotIn(List<String> values) {
            addCriterion("f_certificate not in", values, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateBetween(String value1, String value2) {
            addCriterion("f_certificate between", value1, value2, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFCertificateNotBetween(String value1, String value2) {
            addCriterion("f_certificate not between", value1, value2, "fCertificate");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeIsNull() {
            addCriterion("f_scheme_type is null");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeIsNotNull() {
            addCriterion("f_scheme_type is not null");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeEqualTo(String value) {
            addCriterion("f_scheme_type =", value, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeNotEqualTo(String value) {
            addCriterion("f_scheme_type <>", value, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeGreaterThan(String value) {
            addCriterion("f_scheme_type >", value, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_scheme_type >=", value, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeLessThan(String value) {
            addCriterion("f_scheme_type <", value, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeLessThanOrEqualTo(String value) {
            addCriterion("f_scheme_type <=", value, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeLike(String value) {
            addCriterion("f_scheme_type like", value, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeNotLike(String value) {
            addCriterion("f_scheme_type not like", value, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeIn(List<String> values) {
            addCriterion("f_scheme_type in", values, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeNotIn(List<String> values) {
            addCriterion("f_scheme_type not in", values, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeBetween(String value1, String value2) {
            addCriterion("f_scheme_type between", value1, value2, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFSchemeTypeNotBetween(String value1, String value2) {
            addCriterion("f_scheme_type not between", value1, value2, "fSchemeType");
            return (Criteria) this;
        }

        public Criteria andFMaintainerIsNull() {
            addCriterion("f_maintainer is null");
            return (Criteria) this;
        }

        public Criteria andFMaintainerIsNotNull() {
            addCriterion("f_maintainer is not null");
            return (Criteria) this;
        }

        public Criteria andFMaintainerEqualTo(String value) {
            addCriterion("f_maintainer =", value, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerNotEqualTo(String value) {
            addCriterion("f_maintainer <>", value, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerGreaterThan(String value) {
            addCriterion("f_maintainer >", value, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerGreaterThanOrEqualTo(String value) {
            addCriterion("f_maintainer >=", value, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerLessThan(String value) {
            addCriterion("f_maintainer <", value, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerLessThanOrEqualTo(String value) {
            addCriterion("f_maintainer <=", value, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerLike(String value) {
            addCriterion("f_maintainer like", value, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerNotLike(String value) {
            addCriterion("f_maintainer not like", value, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerIn(List<String> values) {
            addCriterion("f_maintainer in", values, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerNotIn(List<String> values) {
            addCriterion("f_maintainer not in", values, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerBetween(String value1, String value2) {
            addCriterion("f_maintainer between", value1, value2, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFMaintainerNotBetween(String value1, String value2) {
            addCriterion("f_maintainer not between", value1, value2, "fMaintainer");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeIsNull() {
            addCriterion("f_protocol_type is null");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeIsNotNull() {
            addCriterion("f_protocol_type is not null");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeEqualTo(String value) {
            addCriterion("f_protocol_type =", value, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeNotEqualTo(String value) {
            addCriterion("f_protocol_type <>", value, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeGreaterThan(String value) {
            addCriterion("f_protocol_type >", value, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_protocol_type >=", value, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeLessThan(String value) {
            addCriterion("f_protocol_type <", value, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeLessThanOrEqualTo(String value) {
            addCriterion("f_protocol_type <=", value, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeLike(String value) {
            addCriterion("f_protocol_type like", value, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeNotLike(String value) {
            addCriterion("f_protocol_type not like", value, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeIn(List<String> values) {
            addCriterion("f_protocol_type in", values, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeNotIn(List<String> values) {
            addCriterion("f_protocol_type not in", values, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeBetween(String value1, String value2) {
            addCriterion("f_protocol_type between", value1, value2, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFProtocolTypeNotBetween(String value1, String value2) {
            addCriterion("f_protocol_type not between", value1, value2, "fProtocolType");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoIsNull() {
            addCriterion("f_manufacturer_info is null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoIsNotNull() {
            addCriterion("f_manufacturer_info is not null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoEqualTo(String value) {
            addCriterion("f_manufacturer_info =", value, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoNotEqualTo(String value) {
            addCriterion("f_manufacturer_info <>", value, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoGreaterThan(String value) {
            addCriterion("f_manufacturer_info >", value, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoGreaterThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_info >=", value, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoLessThan(String value) {
            addCriterion("f_manufacturer_info <", value, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoLessThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_info <=", value, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoLike(String value) {
            addCriterion("f_manufacturer_info like", value, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoNotLike(String value) {
            addCriterion("f_manufacturer_info not like", value, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoIn(List<String> values) {
            addCriterion("f_manufacturer_info in", values, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoNotIn(List<String> values) {
            addCriterion("f_manufacturer_info not in", values, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoBetween(String value1, String value2) {
            addCriterion("f_manufacturer_info between", value1, value2, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerInfoNotBetween(String value1, String value2) {
            addCriterion("f_manufacturer_info not between", value1, value2, "fManufacturerInfo");
            return (Criteria) this;
        }

        public Criteria andFNvrIsNull() {
            addCriterion("f_nvr is null");
            return (Criteria) this;
        }

        public Criteria andFNvrIsNotNull() {
            addCriterion("f_nvr is not null");
            return (Criteria) this;
        }

        public Criteria andFNvrEqualTo(Integer value) {
            addCriterion("f_nvr =", value, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFNvrNotEqualTo(Integer value) {
            addCriterion("f_nvr <>", value, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFNvrGreaterThan(Integer value) {
            addCriterion("f_nvr >", value, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFNvrGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_nvr >=", value, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFNvrLessThan(Integer value) {
            addCriterion("f_nvr <", value, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFNvrLessThanOrEqualTo(Integer value) {
            addCriterion("f_nvr <=", value, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFNvrIn(List<Integer> values) {
            addCriterion("f_nvr in", values, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFNvrNotIn(List<Integer> values) {
            addCriterion("f_nvr not in", values, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFNvrBetween(Integer value1, Integer value2) {
            addCriterion("f_nvr between", value1, value2, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFNvrNotBetween(Integer value1, Integer value2) {
            addCriterion("f_nvr not between", value1, value2, "fNvr");
            return (Criteria) this;
        }

        public Criteria andFChannelModelIsNull() {
            addCriterion("f_channel_model is null");
            return (Criteria) this;
        }

        public Criteria andFChannelModelIsNotNull() {
            addCriterion("f_channel_model is not null");
            return (Criteria) this;
        }

        public Criteria andFChannelModelEqualTo(String value) {
            addCriterion("f_channel_model =", value, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelNotEqualTo(String value) {
            addCriterion("f_channel_model <>", value, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelGreaterThan(String value) {
            addCriterion("f_channel_model >", value, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelGreaterThanOrEqualTo(String value) {
            addCriterion("f_channel_model >=", value, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelLessThan(String value) {
            addCriterion("f_channel_model <", value, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelLessThanOrEqualTo(String value) {
            addCriterion("f_channel_model <=", value, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelLike(String value) {
            addCriterion("f_channel_model like", value, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelNotLike(String value) {
            addCriterion("f_channel_model not like", value, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelIn(List<String> values) {
            addCriterion("f_channel_model in", values, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelNotIn(List<String> values) {
            addCriterion("f_channel_model not in", values, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelBetween(String value1, String value2) {
            addCriterion("f_channel_model between", value1, value2, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFChannelModelNotBetween(String value1, String value2) {
            addCriterion("f_channel_model not between", value1, value2, "fChannelModel");
            return (Criteria) this;
        }

        public Criteria andFLoginNameIsNull() {
            addCriterion("f_login_name is null");
            return (Criteria) this;
        }

        public Criteria andFLoginNameIsNotNull() {
            addCriterion("f_login_name is not null");
            return (Criteria) this;
        }

        public Criteria andFLoginNameEqualTo(String value) {
            addCriterion("f_login_name =", value, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameNotEqualTo(String value) {
            addCriterion("f_login_name <>", value, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameGreaterThan(String value) {
            addCriterion("f_login_name >", value, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_login_name >=", value, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameLessThan(String value) {
            addCriterion("f_login_name <", value, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameLessThanOrEqualTo(String value) {
            addCriterion("f_login_name <=", value, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameLike(String value) {
            addCriterion("f_login_name like", value, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameNotLike(String value) {
            addCriterion("f_login_name not like", value, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameIn(List<String> values) {
            addCriterion("f_login_name in", values, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameNotIn(List<String> values) {
            addCriterion("f_login_name not in", values, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameBetween(String value1, String value2) {
            addCriterion("f_login_name between", value1, value2, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginNameNotBetween(String value1, String value2) {
            addCriterion("f_login_name not between", value1, value2, "fLoginName");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordIsNull() {
            addCriterion("f_login_password is null");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordIsNotNull() {
            addCriterion("f_login_password is not null");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordEqualTo(String value) {
            addCriterion("f_login_password =", value, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordNotEqualTo(String value) {
            addCriterion("f_login_password <>", value, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordGreaterThan(String value) {
            addCriterion("f_login_password >", value, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("f_login_password >=", value, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordLessThan(String value) {
            addCriterion("f_login_password <", value, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("f_login_password <=", value, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordLike(String value) {
            addCriterion("f_login_password like", value, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordNotLike(String value) {
            addCriterion("f_login_password not like", value, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordIn(List<String> values) {
            addCriterion("f_login_password in", values, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordNotIn(List<String> values) {
            addCriterion("f_login_password not in", values, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordBetween(String value1, String value2) {
            addCriterion("f_login_password between", value1, value2, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("f_login_password not between", value1, value2, "fLoginPassword");
            return (Criteria) this;
        }

        public Criteria andFChannelContentIsNull() {
            addCriterion("f_channel_content is null");
            return (Criteria) this;
        }

        public Criteria andFChannelContentIsNotNull() {
            addCriterion("f_channel_content is not null");
            return (Criteria) this;
        }

        public Criteria andFChannelContentEqualTo(String value) {
            addCriterion("f_channel_content =", value, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentNotEqualTo(String value) {
            addCriterion("f_channel_content <>", value, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentGreaterThan(String value) {
            addCriterion("f_channel_content >", value, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentGreaterThanOrEqualTo(String value) {
            addCriterion("f_channel_content >=", value, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentLessThan(String value) {
            addCriterion("f_channel_content <", value, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentLessThanOrEqualTo(String value) {
            addCriterion("f_channel_content <=", value, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentLike(String value) {
            addCriterion("f_channel_content like", value, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentNotLike(String value) {
            addCriterion("f_channel_content not like", value, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentIn(List<String> values) {
            addCriterion("f_channel_content in", values, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentNotIn(List<String> values) {
            addCriterion("f_channel_content not in", values, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentBetween(String value1, String value2) {
            addCriterion("f_channel_content between", value1, value2, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelContentNotBetween(String value1, String value2) {
            addCriterion("f_channel_content not between", value1, value2, "fChannelContent");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberIsNull() {
            addCriterion("f_channel_number is null");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberIsNotNull() {
            addCriterion("f_channel_number is not null");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberEqualTo(String value) {
            addCriterion("f_channel_number =", value, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberNotEqualTo(String value) {
            addCriterion("f_channel_number <>", value, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberGreaterThan(String value) {
            addCriterion("f_channel_number >", value, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_channel_number >=", value, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberLessThan(String value) {
            addCriterion("f_channel_number <", value, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberLessThanOrEqualTo(String value) {
            addCriterion("f_channel_number <=", value, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberLike(String value) {
            addCriterion("f_channel_number like", value, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberNotLike(String value) {
            addCriterion("f_channel_number not like", value, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberIn(List<String> values) {
            addCriterion("f_channel_number in", values, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberNotIn(List<String> values) {
            addCriterion("f_channel_number not in", values, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberBetween(String value1, String value2) {
            addCriterion("f_channel_number between", value1, value2, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFChannelNumberNotBetween(String value1, String value2) {
            addCriterion("f_channel_number not between", value1, value2, "fChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionIsNull() {
            addCriterion("f_hardware_version is null");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionIsNotNull() {
            addCriterion("f_hardware_version is not null");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionEqualTo(String value) {
            addCriterion("f_hardware_version =", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNotEqualTo(String value) {
            addCriterion("f_hardware_version <>", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionGreaterThan(String value) {
            addCriterion("f_hardware_version >", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionGreaterThanOrEqualTo(String value) {
            addCriterion("f_hardware_version >=", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionLessThan(String value) {
            addCriterion("f_hardware_version <", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionLessThanOrEqualTo(String value) {
            addCriterion("f_hardware_version <=", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionLike(String value) {
            addCriterion("f_hardware_version like", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNotLike(String value) {
            addCriterion("f_hardware_version not like", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionIn(List<String> values) {
            addCriterion("f_hardware_version in", values, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNotIn(List<String> values) {
            addCriterion("f_hardware_version not in", values, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionBetween(String value1, String value2) {
            addCriterion("f_hardware_version between", value1, value2, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNotBetween(String value1, String value2) {
            addCriterion("f_hardware_version not between", value1, value2, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionIsNull() {
            addCriterion("f_software_version is null");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionIsNotNull() {
            addCriterion("f_software_version is not null");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionEqualTo(String value) {
            addCriterion("f_software_version =", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNotEqualTo(String value) {
            addCriterion("f_software_version <>", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionGreaterThan(String value) {
            addCriterion("f_software_version >", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionGreaterThanOrEqualTo(String value) {
            addCriterion("f_software_version >=", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionLessThan(String value) {
            addCriterion("f_software_version <", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionLessThanOrEqualTo(String value) {
            addCriterion("f_software_version <=", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionLike(String value) {
            addCriterion("f_software_version like", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNotLike(String value) {
            addCriterion("f_software_version not like", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionIn(List<String> values) {
            addCriterion("f_software_version in", values, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNotIn(List<String> values) {
            addCriterion("f_software_version not in", values, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionBetween(String value1, String value2) {
            addCriterion("f_software_version between", value1, value2, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNotBetween(String value1, String value2) {
            addCriterion("f_software_version not between", value1, value2, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFPowerIsNull() {
            addCriterion("f_power is null");
            return (Criteria) this;
        }

        public Criteria andFPowerIsNotNull() {
            addCriterion("f_power is not null");
            return (Criteria) this;
        }

        public Criteria andFPowerEqualTo(String value) {
            addCriterion("f_power =", value, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerNotEqualTo(String value) {
            addCriterion("f_power <>", value, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerGreaterThan(String value) {
            addCriterion("f_power >", value, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerGreaterThanOrEqualTo(String value) {
            addCriterion("f_power >=", value, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerLessThan(String value) {
            addCriterion("f_power <", value, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerLessThanOrEqualTo(String value) {
            addCriterion("f_power <=", value, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerLike(String value) {
            addCriterion("f_power like", value, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerNotLike(String value) {
            addCriterion("f_power not like", value, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerIn(List<String> values) {
            addCriterion("f_power in", values, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerNotIn(List<String> values) {
            addCriterion("f_power not in", values, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerBetween(String value1, String value2) {
            addCriterion("f_power between", value1, value2, "fPower");
            return (Criteria) this;
        }

        public Criteria andFPowerNotBetween(String value1, String value2) {
            addCriterion("f_power not between", value1, value2, "fPower");
            return (Criteria) this;
        }

        public Criteria andFVoltageIsNull() {
            addCriterion("f_voltage is null");
            return (Criteria) this;
        }

        public Criteria andFVoltageIsNotNull() {
            addCriterion("f_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andFVoltageEqualTo(String value) {
            addCriterion("f_voltage =", value, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageNotEqualTo(String value) {
            addCriterion("f_voltage <>", value, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageGreaterThan(String value) {
            addCriterion("f_voltage >", value, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("f_voltage >=", value, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageLessThan(String value) {
            addCriterion("f_voltage <", value, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageLessThanOrEqualTo(String value) {
            addCriterion("f_voltage <=", value, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageLike(String value) {
            addCriterion("f_voltage like", value, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageNotLike(String value) {
            addCriterion("f_voltage not like", value, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageIn(List<String> values) {
            addCriterion("f_voltage in", values, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageNotIn(List<String> values) {
            addCriterion("f_voltage not in", values, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageBetween(String value1, String value2) {
            addCriterion("f_voltage between", value1, value2, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFVoltageNotBetween(String value1, String value2) {
            addCriterion("f_voltage not between", value1, value2, "fVoltage");
            return (Criteria) this;
        }

        public Criteria andFRfLevelIsNull() {
            addCriterion("f_rf_level is null");
            return (Criteria) this;
        }

        public Criteria andFRfLevelIsNotNull() {
            addCriterion("f_rf_level is not null");
            return (Criteria) this;
        }

        public Criteria andFRfLevelEqualTo(String value) {
            addCriterion("f_rf_level =", value, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelNotEqualTo(String value) {
            addCriterion("f_rf_level <>", value, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelGreaterThan(String value) {
            addCriterion("f_rf_level >", value, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelGreaterThanOrEqualTo(String value) {
            addCriterion("f_rf_level >=", value, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelLessThan(String value) {
            addCriterion("f_rf_level <", value, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelLessThanOrEqualTo(String value) {
            addCriterion("f_rf_level <=", value, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelLike(String value) {
            addCriterion("f_rf_level like", value, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelNotLike(String value) {
            addCriterion("f_rf_level not like", value, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelIn(List<String> values) {
            addCriterion("f_rf_level in", values, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelNotIn(List<String> values) {
            addCriterion("f_rf_level not in", values, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelBetween(String value1, String value2) {
            addCriterion("f_rf_level between", value1, value2, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFRfLevelNotBetween(String value1, String value2) {
            addCriterion("f_rf_level not between", value1, value2, "fRfLevel");
            return (Criteria) this;
        }

        public Criteria andFResCodingIsNull() {
            addCriterion("f_res_coding is null");
            return (Criteria) this;
        }

        public Criteria andFResCodingIsNotNull() {
            addCriterion("f_res_coding is not null");
            return (Criteria) this;
        }

        public Criteria andFResCodingEqualTo(String value) {
            addCriterion("f_res_coding =", value, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingNotEqualTo(String value) {
            addCriterion("f_res_coding <>", value, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingGreaterThan(String value) {
            addCriterion("f_res_coding >", value, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingGreaterThanOrEqualTo(String value) {
            addCriterion("f_res_coding >=", value, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingLessThan(String value) {
            addCriterion("f_res_coding <", value, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingLessThanOrEqualTo(String value) {
            addCriterion("f_res_coding <=", value, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingLike(String value) {
            addCriterion("f_res_coding like", value, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingNotLike(String value) {
            addCriterion("f_res_coding not like", value, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingIn(List<String> values) {
            addCriterion("f_res_coding in", values, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingNotIn(List<String> values) {
            addCriterion("f_res_coding not in", values, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingBetween(String value1, String value2) {
            addCriterion("f_res_coding between", value1, value2, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResCodingNotBetween(String value1, String value2) {
            addCriterion("f_res_coding not between", value1, value2, "fResCoding");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeIsNull() {
            addCriterion("f_res_type_code is null");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeIsNotNull() {
            addCriterion("f_res_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeEqualTo(String value) {
            addCriterion("f_res_type_code =", value, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeNotEqualTo(String value) {
            addCriterion("f_res_type_code <>", value, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeGreaterThan(String value) {
            addCriterion("f_res_type_code >", value, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_res_type_code >=", value, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeLessThan(String value) {
            addCriterion("f_res_type_code <", value, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("f_res_type_code <=", value, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeLike(String value) {
            addCriterion("f_res_type_code like", value, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeNotLike(String value) {
            addCriterion("f_res_type_code not like", value, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeIn(List<String> values) {
            addCriterion("f_res_type_code in", values, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeNotIn(List<String> values) {
            addCriterion("f_res_type_code not in", values, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeBetween(String value1, String value2) {
            addCriterion("f_res_type_code between", value1, value2, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeCodeNotBetween(String value1, String value2) {
            addCriterion("f_res_type_code not between", value1, value2, "fResTypeCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeIsNull() {
            addCriterion("f_res_type_sequence_code is null");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeIsNotNull() {
            addCriterion("f_res_type_sequence_code is not null");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeEqualTo(String value) {
            addCriterion("f_res_type_sequence_code =", value, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeNotEqualTo(String value) {
            addCriterion("f_res_type_sequence_code <>", value, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeGreaterThan(String value) {
            addCriterion("f_res_type_sequence_code >", value, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_res_type_sequence_code >=", value, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeLessThan(String value) {
            addCriterion("f_res_type_sequence_code <", value, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeLessThanOrEqualTo(String value) {
            addCriterion("f_res_type_sequence_code <=", value, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeLike(String value) {
            addCriterion("f_res_type_sequence_code like", value, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeNotLike(String value) {
            addCriterion("f_res_type_sequence_code not like", value, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeIn(List<String> values) {
            addCriterion("f_res_type_sequence_code in", values, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeNotIn(List<String> values) {
            addCriterion("f_res_type_sequence_code not in", values, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeBetween(String value1, String value2) {
            addCriterion("f_res_type_sequence_code between", value1, value2, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResTypeSequenceCodeNotBetween(String value1, String value2) {
            addCriterion("f_res_type_sequence_code not between", value1, value2, "fResTypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeIsNull() {
            addCriterion("f_res_subtype_code is null");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeIsNotNull() {
            addCriterion("f_res_subtype_code is not null");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeEqualTo(String value) {
            addCriterion("f_res_subtype_code =", value, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeNotEqualTo(String value) {
            addCriterion("f_res_subtype_code <>", value, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeGreaterThan(String value) {
            addCriterion("f_res_subtype_code >", value, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_res_subtype_code >=", value, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeLessThan(String value) {
            addCriterion("f_res_subtype_code <", value, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeLessThanOrEqualTo(String value) {
            addCriterion("f_res_subtype_code <=", value, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeLike(String value) {
            addCriterion("f_res_subtype_code like", value, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeNotLike(String value) {
            addCriterion("f_res_subtype_code not like", value, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeIn(List<String> values) {
            addCriterion("f_res_subtype_code in", values, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeNotIn(List<String> values) {
            addCriterion("f_res_subtype_code not in", values, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeBetween(String value1, String value2) {
            addCriterion("f_res_subtype_code between", value1, value2, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeCodeNotBetween(String value1, String value2) {
            addCriterion("f_res_subtype_code not between", value1, value2, "fResSubtypeCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeIsNull() {
            addCriterion("f_res_subtype_sequence_code is null");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeIsNotNull() {
            addCriterion("f_res_subtype_sequence_code is not null");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeEqualTo(String value) {
            addCriterion("f_res_subtype_sequence_code =", value, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeNotEqualTo(String value) {
            addCriterion("f_res_subtype_sequence_code <>", value, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeGreaterThan(String value) {
            addCriterion("f_res_subtype_sequence_code >", value, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_res_subtype_sequence_code >=", value, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeLessThan(String value) {
            addCriterion("f_res_subtype_sequence_code <", value, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeLessThanOrEqualTo(String value) {
            addCriterion("f_res_subtype_sequence_code <=", value, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeLike(String value) {
            addCriterion("f_res_subtype_sequence_code like", value, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeNotLike(String value) {
            addCriterion("f_res_subtype_sequence_code not like", value, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeIn(List<String> values) {
            addCriterion("f_res_subtype_sequence_code in", values, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeNotIn(List<String> values) {
            addCriterion("f_res_subtype_sequence_code not in", values, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeBetween(String value1, String value2) {
            addCriterion("f_res_subtype_sequence_code between", value1, value2, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFResSubtypeSequenceCodeNotBetween(String value1, String value2) {
            addCriterion("f_res_subtype_sequence_code not between", value1, value2, "fResSubtypeSequenceCode");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagIsNull() {
            addCriterion("f_support_ip_flag is null");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagIsNotNull() {
            addCriterion("f_support_ip_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagEqualTo(Boolean value) {
            addCriterion("f_support_ip_flag =", value, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagNotEqualTo(Boolean value) {
            addCriterion("f_support_ip_flag <>", value, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagGreaterThan(Boolean value) {
            addCriterion("f_support_ip_flag >", value, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_support_ip_flag >=", value, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagLessThan(Boolean value) {
            addCriterion("f_support_ip_flag <", value, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("f_support_ip_flag <=", value, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagIn(List<Boolean> values) {
            addCriterion("f_support_ip_flag in", values, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagNotIn(List<Boolean> values) {
            addCriterion("f_support_ip_flag not in", values, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("f_support_ip_flag between", value1, value2, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportIpFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_support_ip_flag not between", value1, value2, "fSupportIpFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagIsNull() {
            addCriterion("f_support_rds_flag is null");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagIsNotNull() {
            addCriterion("f_support_rds_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagEqualTo(Boolean value) {
            addCriterion("f_support_rds_flag =", value, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagNotEqualTo(Boolean value) {
            addCriterion("f_support_rds_flag <>", value, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagGreaterThan(Boolean value) {
            addCriterion("f_support_rds_flag >", value, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_support_rds_flag >=", value, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagLessThan(Boolean value) {
            addCriterion("f_support_rds_flag <", value, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("f_support_rds_flag <=", value, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagIn(List<Boolean> values) {
            addCriterion("f_support_rds_flag in", values, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagNotIn(List<Boolean> values) {
            addCriterion("f_support_rds_flag not in", values, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("f_support_rds_flag between", value1, value2, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportRdsFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_support_rds_flag not between", value1, value2, "fSupportRdsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagIsNull() {
            addCriterion("f_support_dtmb_ts_flag is null");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagIsNotNull() {
            addCriterion("f_support_dtmb_ts_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagEqualTo(Boolean value) {
            addCriterion("f_support_dtmb_ts_flag =", value, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagNotEqualTo(Boolean value) {
            addCriterion("f_support_dtmb_ts_flag <>", value, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagGreaterThan(Boolean value) {
            addCriterion("f_support_dtmb_ts_flag >", value, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_support_dtmb_ts_flag >=", value, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagLessThan(Boolean value) {
            addCriterion("f_support_dtmb_ts_flag <", value, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("f_support_dtmb_ts_flag <=", value, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagIn(List<Boolean> values) {
            addCriterion("f_support_dtmb_ts_flag in", values, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagNotIn(List<Boolean> values) {
            addCriterion("f_support_dtmb_ts_flag not in", values, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("f_support_dtmb_ts_flag between", value1, value2, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDtmbTsFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_support_dtmb_ts_flag not between", value1, value2, "fSupportDtmbTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagIsNull() {
            addCriterion("f_support_dvbc_ts_flag is null");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagIsNotNull() {
            addCriterion("f_support_dvbc_ts_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagEqualTo(Boolean value) {
            addCriterion("f_support_dvbc_ts_flag =", value, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagNotEqualTo(Boolean value) {
            addCriterion("f_support_dvbc_ts_flag <>", value, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagGreaterThan(Boolean value) {
            addCriterion("f_support_dvbc_ts_flag >", value, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_support_dvbc_ts_flag >=", value, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagLessThan(Boolean value) {
            addCriterion("f_support_dvbc_ts_flag <", value, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("f_support_dvbc_ts_flag <=", value, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagIn(List<Boolean> values) {
            addCriterion("f_support_dvbc_ts_flag in", values, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagNotIn(List<Boolean> values) {
            addCriterion("f_support_dvbc_ts_flag not in", values, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("f_support_dvbc_ts_flag between", value1, value2, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSupportDvbcTsFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_support_dvbc_ts_flag not between", value1, value2, "fSupportDvbcTsFlag");
            return (Criteria) this;
        }

        public Criteria andFSortIsNull() {
            addCriterion("f_sort is null");
            return (Criteria) this;
        }

        public Criteria andFSortIsNotNull() {
            addCriterion("f_sort is not null");
            return (Criteria) this;
        }

        public Criteria andFSortEqualTo(Byte value) {
            addCriterion("f_sort =", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortNotEqualTo(Byte value) {
            addCriterion("f_sort <>", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortGreaterThan(Byte value) {
            addCriterion("f_sort >", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_sort >=", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortLessThan(Byte value) {
            addCriterion("f_sort <", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortLessThanOrEqualTo(Byte value) {
            addCriterion("f_sort <=", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortIn(List<Byte> values) {
            addCriterion("f_sort in", values, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortNotIn(List<Byte> values) {
            addCriterion("f_sort not in", values, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortBetween(Byte value1, Byte value2) {
            addCriterion("f_sort between", value1, value2, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortNotBetween(Byte value1, Byte value2) {
            addCriterion("f_sort not between", value1, value2, "fSort");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNull() {
            addCriterion("f_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNotNull() {
            addCriterion("f_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeEqualTo(Date value) {
            addCriterion("f_create_time =", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotEqualTo(Date value) {
            addCriterion("f_create_time <>", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThan(Date value) {
            addCriterion("f_create_time >", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_create_time >=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThan(Date value) {
            addCriterion("f_create_time <", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_create_time <=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIn(List<Date> values) {
            addCriterion("f_create_time in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotIn(List<Date> values) {
            addCriterion("f_create_time not in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeBetween(Date value1, Date value2) {
            addCriterion("f_create_time between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_create_time not between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdIsNull() {
            addCriterion("f_creator_id is null");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdIsNotNull() {
            addCriterion("f_creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdEqualTo(Integer value) {
            addCriterion("f_creator_id =", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdNotEqualTo(Integer value) {
            addCriterion("f_creator_id <>", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdGreaterThan(Integer value) {
            addCriterion("f_creator_id >", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_creator_id >=", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdLessThan(Integer value) {
            addCriterion("f_creator_id <", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_creator_id <=", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdIn(List<Integer> values) {
            addCriterion("f_creator_id in", values, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdNotIn(List<Integer> values) {
            addCriterion("f_creator_id not in", values, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("f_creator_id between", value1, value2, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_creator_id not between", value1, value2, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIsNull() {
            addCriterion("f_update_time is null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIsNotNull() {
            addCriterion("f_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeEqualTo(Date value) {
            addCriterion("f_update_time =", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotEqualTo(Date value) {
            addCriterion("f_update_time <>", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeGreaterThan(Date value) {
            addCriterion("f_update_time >", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_update_time >=", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeLessThan(Date value) {
            addCriterion("f_update_time <", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_update_time <=", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIn(List<Date> values) {
            addCriterion("f_update_time in", values, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotIn(List<Date> values) {
            addCriterion("f_update_time not in", values, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("f_update_time between", value1, value2, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_update_time not between", value1, value2, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdIsNull() {
            addCriterion("f_operator_id is null");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdIsNotNull() {
            addCriterion("f_operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdEqualTo(Integer value) {
            addCriterion("f_operator_id =", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdNotEqualTo(Integer value) {
            addCriterion("f_operator_id <>", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdGreaterThan(Integer value) {
            addCriterion("f_operator_id >", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_operator_id >=", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdLessThan(Integer value) {
            addCriterion("f_operator_id <", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_operator_id <=", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdIn(List<Integer> values) {
            addCriterion("f_operator_id in", values, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdNotIn(List<Integer> values) {
            addCriterion("f_operator_id not in", values, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("f_operator_id between", value1, value2, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_operator_id not between", value1, value2, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagIsNull() {
            addCriterion("f_delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagIsNotNull() {
            addCriterion("f_delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagEqualTo(Boolean value) {
            addCriterion("f_delete_flag =", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagNotEqualTo(Boolean value) {
            addCriterion("f_delete_flag <>", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagGreaterThan(Boolean value) {
            addCriterion("f_delete_flag >", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_delete_flag >=", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagLessThan(Boolean value) {
            addCriterion("f_delete_flag <", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("f_delete_flag <=", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagIn(List<Boolean> values) {
            addCriterion("f_delete_flag in", values, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagNotIn(List<Boolean> values) {
            addCriterion("f_delete_flag not in", values, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("f_delete_flag between", value1, value2, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_delete_flag not between", value1, value2, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFBackTimeIsNull() {
            addCriterion("f_back_time is null");
            return (Criteria) this;
        }

        public Criteria andFBackTimeIsNotNull() {
            addCriterion("f_back_time is not null");
            return (Criteria) this;
        }

        public Criteria andFBackTimeEqualTo(Date value) {
            addCriterion("f_back_time =", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeNotEqualTo(Date value) {
            addCriterion("f_back_time <>", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeGreaterThan(Date value) {
            addCriterion("f_back_time >", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_back_time >=", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeLessThan(Date value) {
            addCriterion("f_back_time <", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_back_time <=", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeIn(List<Date> values) {
            addCriterion("f_back_time in", values, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeNotIn(List<Date> values) {
            addCriterion("f_back_time not in", values, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeBetween(Date value1, Date value2) {
            addCriterion("f_back_time between", value1, value2, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_back_time not between", value1, value2, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeIsNull() {
            addCriterion("f_logic_code is null");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeIsNotNull() {
            addCriterion("f_logic_code is not null");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeEqualTo(String value) {
            addCriterion("f_logic_code =", value, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeNotEqualTo(String value) {
            addCriterion("f_logic_code <>", value, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeGreaterThan(String value) {
            addCriterion("f_logic_code >", value, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_logic_code >=", value, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeLessThan(String value) {
            addCriterion("f_logic_code <", value, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeLessThanOrEqualTo(String value) {
            addCriterion("f_logic_code <=", value, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeLike(String value) {
            addCriterion("f_logic_code like", value, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeNotLike(String value) {
            addCriterion("f_logic_code not like", value, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeIn(List<String> values) {
            addCriterion("f_logic_code in", values, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeNotIn(List<String> values) {
            addCriterion("f_logic_code not in", values, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeBetween(String value1, String value2) {
            addCriterion("f_logic_code between", value1, value2, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFLogicCodeNotBetween(String value1, String value2) {
            addCriterion("f_logic_code not between", value1, value2, "fLogicCode");
            return (Criteria) this;
        }

        public Criteria andFBackModeIsNull() {
            addCriterion("f_back_mode is null");
            return (Criteria) this;
        }

        public Criteria andFBackModeIsNotNull() {
            addCriterion("f_back_mode is not null");
            return (Criteria) this;
        }

        public Criteria andFBackModeEqualTo(String value) {
            addCriterion("f_back_mode =", value, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeNotEqualTo(String value) {
            addCriterion("f_back_mode <>", value, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeGreaterThan(String value) {
            addCriterion("f_back_mode >", value, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeGreaterThanOrEqualTo(String value) {
            addCriterion("f_back_mode >=", value, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeLessThan(String value) {
            addCriterion("f_back_mode <", value, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeLessThanOrEqualTo(String value) {
            addCriterion("f_back_mode <=", value, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeLike(String value) {
            addCriterion("f_back_mode like", value, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeNotLike(String value) {
            addCriterion("f_back_mode not like", value, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeIn(List<String> values) {
            addCriterion("f_back_mode in", values, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeNotIn(List<String> values) {
            addCriterion("f_back_mode not in", values, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeBetween(String value1, String value2) {
            addCriterion("f_back_mode between", value1, value2, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFBackModeNotBetween(String value1, String value2) {
            addCriterion("f_back_mode not between", value1, value2, "fBackMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeIsNull() {
            addCriterion("f_network_mode is null");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeIsNotNull() {
            addCriterion("f_network_mode is not null");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeEqualTo(String value) {
            addCriterion("f_network_mode =", value, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeNotEqualTo(String value) {
            addCriterion("f_network_mode <>", value, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeGreaterThan(String value) {
            addCriterion("f_network_mode >", value, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeGreaterThanOrEqualTo(String value) {
            addCriterion("f_network_mode >=", value, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeLessThan(String value) {
            addCriterion("f_network_mode <", value, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeLessThanOrEqualTo(String value) {
            addCriterion("f_network_mode <=", value, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeLike(String value) {
            addCriterion("f_network_mode like", value, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeNotLike(String value) {
            addCriterion("f_network_mode not like", value, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeIn(List<String> values) {
            addCriterion("f_network_mode in", values, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeNotIn(List<String> values) {
            addCriterion("f_network_mode not in", values, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeBetween(String value1, String value2) {
            addCriterion("f_network_mode between", value1, value2, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFNetworkModeNotBetween(String value1, String value2) {
            addCriterion("f_network_mode not between", value1, value2, "fNetworkMode");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentIsNull() {
            addCriterion("f_power_current is null");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentIsNotNull() {
            addCriterion("f_power_current is not null");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentEqualTo(String value) {
            addCriterion("f_power_current =", value, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentNotEqualTo(String value) {
            addCriterion("f_power_current <>", value, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentGreaterThan(String value) {
            addCriterion("f_power_current >", value, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentGreaterThanOrEqualTo(String value) {
            addCriterion("f_power_current >=", value, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentLessThan(String value) {
            addCriterion("f_power_current <", value, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentLessThanOrEqualTo(String value) {
            addCriterion("f_power_current <=", value, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentLike(String value) {
            addCriterion("f_power_current like", value, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentNotLike(String value) {
            addCriterion("f_power_current not like", value, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentIn(List<String> values) {
            addCriterion("f_power_current in", values, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentNotIn(List<String> values) {
            addCriterion("f_power_current not in", values, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentBetween(String value1, String value2) {
            addCriterion("f_power_current between", value1, value2, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFPowerCurrentNotBetween(String value1, String value2) {
            addCriterion("f_power_current not between", value1, value2, "fPowerCurrent");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateIsNull() {
            addCriterion("f_broadcast_state is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateIsNotNull() {
            addCriterion("f_broadcast_state is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateEqualTo(String value) {
            addCriterion("f_broadcast_state =", value, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateNotEqualTo(String value) {
            addCriterion("f_broadcast_state <>", value, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateGreaterThan(String value) {
            addCriterion("f_broadcast_state >", value, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateGreaterThanOrEqualTo(String value) {
            addCriterion("f_broadcast_state >=", value, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateLessThan(String value) {
            addCriterion("f_broadcast_state <", value, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateLessThanOrEqualTo(String value) {
            addCriterion("f_broadcast_state <=", value, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateLike(String value) {
            addCriterion("f_broadcast_state like", value, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateNotLike(String value) {
            addCriterion("f_broadcast_state not like", value, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateIn(List<String> values) {
            addCriterion("f_broadcast_state in", values, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateNotIn(List<String> values) {
            addCriterion("f_broadcast_state not in", values, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateBetween(String value1, String value2) {
            addCriterion("f_broadcast_state between", value1, value2, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStateNotBetween(String value1, String value2) {
            addCriterion("f_broadcast_state not between", value1, value2, "fBroadcastState");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeIsNull() {
            addCriterion("f_device_volume is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeIsNotNull() {
            addCriterion("f_device_volume is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeEqualTo(String value) {
            addCriterion("f_device_volume =", value, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeNotEqualTo(String value) {
            addCriterion("f_device_volume <>", value, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeGreaterThan(String value) {
            addCriterion("f_device_volume >", value, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_volume >=", value, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeLessThan(String value) {
            addCriterion("f_device_volume <", value, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeLessThanOrEqualTo(String value) {
            addCriterion("f_device_volume <=", value, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeLike(String value) {
            addCriterion("f_device_volume like", value, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeNotLike(String value) {
            addCriterion("f_device_volume not like", value, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeIn(List<String> values) {
            addCriterion("f_device_volume in", values, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeNotIn(List<String> values) {
            addCriterion("f_device_volume not in", values, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeBetween(String value1, String value2) {
            addCriterion("f_device_volume between", value1, value2, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDeviceVolumeNotBetween(String value1, String value2) {
            addCriterion("f_device_volume not between", value1, value2, "fDeviceVolume");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeIsNull() {
            addCriterion("f_digital_television_radio_mode is null");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeIsNotNull() {
            addCriterion("f_digital_television_radio_mode is not null");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeEqualTo(String value) {
            addCriterion("f_digital_television_radio_mode =", value, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeNotEqualTo(String value) {
            addCriterion("f_digital_television_radio_mode <>", value, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeGreaterThan(String value) {
            addCriterion("f_digital_television_radio_mode >", value, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeGreaterThanOrEqualTo(String value) {
            addCriterion("f_digital_television_radio_mode >=", value, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeLessThan(String value) {
            addCriterion("f_digital_television_radio_mode <", value, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeLessThanOrEqualTo(String value) {
            addCriterion("f_digital_television_radio_mode <=", value, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeLike(String value) {
            addCriterion("f_digital_television_radio_mode like", value, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeNotLike(String value) {
            addCriterion("f_digital_television_radio_mode not like", value, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeIn(List<String> values) {
            addCriterion("f_digital_television_radio_mode in", values, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeNotIn(List<String> values) {
            addCriterion("f_digital_television_radio_mode not in", values, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeBetween(String value1, String value2) {
            addCriterion("f_digital_television_radio_mode between", value1, value2, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioModeNotBetween(String value1, String value2) {
            addCriterion("f_digital_television_radio_mode not between", value1, value2, "fDigitalTelevisionRadioMode");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateIsNull() {
            addCriterion("f_digital_television_radio_rate is null");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateIsNotNull() {
            addCriterion("f_digital_television_radio_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateEqualTo(String value) {
            addCriterion("f_digital_television_radio_rate =", value, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateNotEqualTo(String value) {
            addCriterion("f_digital_television_radio_rate <>", value, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateGreaterThan(String value) {
            addCriterion("f_digital_television_radio_rate >", value, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateGreaterThanOrEqualTo(String value) {
            addCriterion("f_digital_television_radio_rate >=", value, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateLessThan(String value) {
            addCriterion("f_digital_television_radio_rate <", value, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateLessThanOrEqualTo(String value) {
            addCriterion("f_digital_television_radio_rate <=", value, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateLike(String value) {
            addCriterion("f_digital_television_radio_rate like", value, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateNotLike(String value) {
            addCriterion("f_digital_television_radio_rate not like", value, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateIn(List<String> values) {
            addCriterion("f_digital_television_radio_rate in", values, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateNotIn(List<String> values) {
            addCriterion("f_digital_television_radio_rate not in", values, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateBetween(String value1, String value2) {
            addCriterion("f_digital_television_radio_rate between", value1, value2, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionRadioRateNotBetween(String value1, String value2) {
            addCriterion("f_digital_television_radio_rate not between", value1, value2, "fDigitalTelevisionRadioRate");
            return (Criteria) this;
        }

        public Criteria andFQmaIsNull() {
            addCriterion("f_qma is null");
            return (Criteria) this;
        }

        public Criteria andFQmaIsNotNull() {
            addCriterion("f_qma is not null");
            return (Criteria) this;
        }

        public Criteria andFQmaEqualTo(String value) {
            addCriterion("f_qma =", value, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaNotEqualTo(String value) {
            addCriterion("f_qma <>", value, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaGreaterThan(String value) {
            addCriterion("f_qma >", value, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaGreaterThanOrEqualTo(String value) {
            addCriterion("f_qma >=", value, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaLessThan(String value) {
            addCriterion("f_qma <", value, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaLessThanOrEqualTo(String value) {
            addCriterion("f_qma <=", value, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaLike(String value) {
            addCriterion("f_qma like", value, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaNotLike(String value) {
            addCriterion("f_qma not like", value, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaIn(List<String> values) {
            addCriterion("f_qma in", values, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaNotIn(List<String> values) {
            addCriterion("f_qma not in", values, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaBetween(String value1, String value2) {
            addCriterion("f_qma between", value1, value2, "fQma");
            return (Criteria) this;
        }

        public Criteria andFQmaNotBetween(String value1, String value2) {
            addCriterion("f_qma not between", value1, value2, "fQma");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityIsNull() {
            addCriterion("f_digital_television_signal_quality is null");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityIsNotNull() {
            addCriterion("f_digital_television_signal_quality is not null");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityEqualTo(String value) {
            addCriterion("f_digital_television_signal_quality =", value, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityNotEqualTo(String value) {
            addCriterion("f_digital_television_signal_quality <>", value, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityGreaterThan(String value) {
            addCriterion("f_digital_television_signal_quality >", value, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityGreaterThanOrEqualTo(String value) {
            addCriterion("f_digital_television_signal_quality >=", value, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityLessThan(String value) {
            addCriterion("f_digital_television_signal_quality <", value, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityLessThanOrEqualTo(String value) {
            addCriterion("f_digital_television_signal_quality <=", value, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityLike(String value) {
            addCriterion("f_digital_television_signal_quality like", value, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityNotLike(String value) {
            addCriterion("f_digital_television_signal_quality not like", value, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityIn(List<String> values) {
            addCriterion("f_digital_television_signal_quality in", values, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityNotIn(List<String> values) {
            addCriterion("f_digital_television_signal_quality not in", values, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityBetween(String value1, String value2) {
            addCriterion("f_digital_television_signal_quality between", value1, value2, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalQualityNotBetween(String value1, String value2) {
            addCriterion("f_digital_television_signal_quality not between", value1, value2, "fDigitalTelevisionSignalQuality");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListIsNull() {
            addCriterion("f_signal_rate_list is null");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListIsNotNull() {
            addCriterion("f_signal_rate_list is not null");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListEqualTo(String value) {
            addCriterion("f_signal_rate_list =", value, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListNotEqualTo(String value) {
            addCriterion("f_signal_rate_list <>", value, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListGreaterThan(String value) {
            addCriterion("f_signal_rate_list >", value, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListGreaterThanOrEqualTo(String value) {
            addCriterion("f_signal_rate_list >=", value, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListLessThan(String value) {
            addCriterion("f_signal_rate_list <", value, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListLessThanOrEqualTo(String value) {
            addCriterion("f_signal_rate_list <=", value, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListLike(String value) {
            addCriterion("f_signal_rate_list like", value, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListNotLike(String value) {
            addCriterion("f_signal_rate_list not like", value, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListIn(List<String> values) {
            addCriterion("f_signal_rate_list in", values, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListNotIn(List<String> values) {
            addCriterion("f_signal_rate_list not in", values, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListBetween(String value1, String value2) {
            addCriterion("f_signal_rate_list between", value1, value2, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalRateListNotBetween(String value1, String value2) {
            addCriterion("f_signal_rate_list not between", value1, value2, "fSignalRateList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListIsNull() {
            addCriterion("f_signal_strength_list is null");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListIsNotNull() {
            addCriterion("f_signal_strength_list is not null");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListEqualTo(String value) {
            addCriterion("f_signal_strength_list =", value, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListNotEqualTo(String value) {
            addCriterion("f_signal_strength_list <>", value, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListGreaterThan(String value) {
            addCriterion("f_signal_strength_list >", value, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListGreaterThanOrEqualTo(String value) {
            addCriterion("f_signal_strength_list >=", value, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListLessThan(String value) {
            addCriterion("f_signal_strength_list <", value, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListLessThanOrEqualTo(String value) {
            addCriterion("f_signal_strength_list <=", value, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListLike(String value) {
            addCriterion("f_signal_strength_list like", value, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListNotLike(String value) {
            addCriterion("f_signal_strength_list not like", value, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListIn(List<String> values) {
            addCriterion("f_signal_strength_list in", values, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListNotIn(List<String> values) {
            addCriterion("f_signal_strength_list not in", values, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListBetween(String value1, String value2) {
            addCriterion("f_signal_strength_list between", value1, value2, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFSignalStrengthListNotBetween(String value1, String value2) {
            addCriterion("f_signal_strength_list not between", value1, value2, "fSignalStrengthList");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthIsNull() {
            addCriterion("f_digital_television_signal_strength is null");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthIsNotNull() {
            addCriterion("f_digital_television_signal_strength is not null");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthEqualTo(String value) {
            addCriterion("f_digital_television_signal_strength =", value, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthNotEqualTo(String value) {
            addCriterion("f_digital_television_signal_strength <>", value, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthGreaterThan(String value) {
            addCriterion("f_digital_television_signal_strength >", value, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthGreaterThanOrEqualTo(String value) {
            addCriterion("f_digital_television_signal_strength >=", value, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthLessThan(String value) {
            addCriterion("f_digital_television_signal_strength <", value, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthLessThanOrEqualTo(String value) {
            addCriterion("f_digital_television_signal_strength <=", value, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthLike(String value) {
            addCriterion("f_digital_television_signal_strength like", value, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthNotLike(String value) {
            addCriterion("f_digital_television_signal_strength not like", value, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthIn(List<String> values) {
            addCriterion("f_digital_television_signal_strength in", values, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthNotIn(List<String> values) {
            addCriterion("f_digital_television_signal_strength not in", values, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthBetween(String value1, String value2) {
            addCriterion("f_digital_television_signal_strength between", value1, value2, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFDigitalTelevisionSignalStrengthNotBetween(String value1, String value2) {
            addCriterion("f_digital_television_signal_strength not between", value1, value2, "fDigitalTelevisionSignalStrength");
            return (Criteria) this;
        }

        public Criteria andFCodeIsNull() {
            addCriterion("f_code is null");
            return (Criteria) this;
        }

        public Criteria andFCodeIsNotNull() {
            addCriterion("f_code is not null");
            return (Criteria) this;
        }

        public Criteria andFCodeEqualTo(String value) {
            addCriterion("f_code =", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotEqualTo(String value) {
            addCriterion("f_code <>", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeGreaterThan(String value) {
            addCriterion("f_code >", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_code >=", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeLessThan(String value) {
            addCriterion("f_code <", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeLessThanOrEqualTo(String value) {
            addCriterion("f_code <=", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeLike(String value) {
            addCriterion("f_code like", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotLike(String value) {
            addCriterion("f_code not like", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeIn(List<String> values) {
            addCriterion("f_code in", values, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotIn(List<String> values) {
            addCriterion("f_code not in", values, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeBetween(String value1, String value2) {
            addCriterion("f_code between", value1, value2, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotBetween(String value1, String value2) {
            addCriterion("f_code not between", value1, value2, "fCode");
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