package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BDeviceParameterSetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDeviceParameterSetExample() {
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

        public Criteria andFDeviceIdIsNull() {
            addCriterion("f_device_id is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdIsNotNull() {
            addCriterion("f_device_id is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdEqualTo(Integer value) {
            addCriterion("f_device_id =", value, "fDeviceId");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdNotEqualTo(Integer value) {
            addCriterion("f_device_id <>", value, "fDeviceId");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdGreaterThan(Integer value) {
            addCriterion("f_device_id >", value, "fDeviceId");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_device_id >=", value, "fDeviceId");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdLessThan(Integer value) {
            addCriterion("f_device_id <", value, "fDeviceId");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_device_id <=", value, "fDeviceId");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdIn(List<Integer> values) {
            addCriterion("f_device_id in", values, "fDeviceId");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdNotIn(List<Integer> values) {
            addCriterion("f_device_id not in", values, "fDeviceId");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("f_device_id between", value1, value2, "fDeviceId");
            return (Criteria) this;
        }

        public Criteria andFDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_device_id not between", value1, value2, "fDeviceId");
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

        public Criteria andFAdapterRebackTypeIsNull() {
            addCriterion("f_adapter_reback_type is null");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeIsNotNull() {
            addCriterion("f_adapter_reback_type is not null");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeEqualTo(Integer value) {
            addCriterion("f_adapter_reback_type =", value, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeNotEqualTo(Integer value) {
            addCriterion("f_adapter_reback_type <>", value, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeGreaterThan(Integer value) {
            addCriterion("f_adapter_reback_type >", value, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_adapter_reback_type >=", value, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeLessThan(Integer value) {
            addCriterion("f_adapter_reback_type <", value, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeLessThanOrEqualTo(Integer value) {
            addCriterion("f_adapter_reback_type <=", value, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeIn(List<Integer> values) {
            addCriterion("f_adapter_reback_type in", values, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeNotIn(List<Integer> values) {
            addCriterion("f_adapter_reback_type not in", values, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeBetween(Integer value1, Integer value2) {
            addCriterion("f_adapter_reback_type between", value1, value2, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_adapter_reback_type not between", value1, value2, "fAdapterRebackType");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleIsNull() {
            addCriterion("f_adapter_reback_cycle is null");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleIsNotNull() {
            addCriterion("f_adapter_reback_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleEqualTo(Integer value) {
            addCriterion("f_adapter_reback_cycle =", value, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleNotEqualTo(Integer value) {
            addCriterion("f_adapter_reback_cycle <>", value, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleGreaterThan(Integer value) {
            addCriterion("f_adapter_reback_cycle >", value, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_adapter_reback_cycle >=", value, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleLessThan(Integer value) {
            addCriterion("f_adapter_reback_cycle <", value, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleLessThanOrEqualTo(Integer value) {
            addCriterion("f_adapter_reback_cycle <=", value, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleIn(List<Integer> values) {
            addCriterion("f_adapter_reback_cycle in", values, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleNotIn(List<Integer> values) {
            addCriterion("f_adapter_reback_cycle not in", values, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleBetween(Integer value1, Integer value2) {
            addCriterion("f_adapter_reback_cycle between", value1, value2, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("f_adapter_reback_cycle not between", value1, value2, "fAdapterRebackCycle");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressIsNull() {
            addCriterion("f_adapter_reback_address is null");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressIsNotNull() {
            addCriterion("f_adapter_reback_address is not null");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressEqualTo(String value) {
            addCriterion("f_adapter_reback_address =", value, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressNotEqualTo(String value) {
            addCriterion("f_adapter_reback_address <>", value, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressGreaterThan(String value) {
            addCriterion("f_adapter_reback_address >", value, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressGreaterThanOrEqualTo(String value) {
            addCriterion("f_adapter_reback_address >=", value, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressLessThan(String value) {
            addCriterion("f_adapter_reback_address <", value, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressLessThanOrEqualTo(String value) {
            addCriterion("f_adapter_reback_address <=", value, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressLike(String value) {
            addCriterion("f_adapter_reback_address like", value, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressNotLike(String value) {
            addCriterion("f_adapter_reback_address not like", value, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressIn(List<String> values) {
            addCriterion("f_adapter_reback_address in", values, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressNotIn(List<String> values) {
            addCriterion("f_adapter_reback_address not in", values, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressBetween(String value1, String value2) {
            addCriterion("f_adapter_reback_address between", value1, value2, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFAdapterRebackAddressNotBetween(String value1, String value2) {
            addCriterion("f_adapter_reback_address not between", value1, value2, "fAdapterRebackAddress");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeIsNull() {
            addCriterion("f_query_code is null");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeIsNotNull() {
            addCriterion("f_query_code is not null");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeEqualTo(String value) {
            addCriterion("f_query_code =", value, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeNotEqualTo(String value) {
            addCriterion("f_query_code <>", value, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeGreaterThan(String value) {
            addCriterion("f_query_code >", value, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_query_code >=", value, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeLessThan(String value) {
            addCriterion("f_query_code <", value, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeLessThanOrEqualTo(String value) {
            addCriterion("f_query_code <=", value, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeLike(String value) {
            addCriterion("f_query_code like", value, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeNotLike(String value) {
            addCriterion("f_query_code not like", value, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeIn(List<String> values) {
            addCriterion("f_query_code in", values, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeNotIn(List<String> values) {
            addCriterion("f_query_code not in", values, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeBetween(String value1, String value2) {
            addCriterion("f_query_code between", value1, value2, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFQueryCodeNotBetween(String value1, String value2) {
            addCriterion("f_query_code not between", value1, value2, "fQueryCode");
            return (Criteria) this;
        }

        public Criteria andFVolumeIsNull() {
            addCriterion("f_volume is null");
            return (Criteria) this;
        }

        public Criteria andFVolumeIsNotNull() {
            addCriterion("f_volume is not null");
            return (Criteria) this;
        }

        public Criteria andFVolumeEqualTo(Integer value) {
            addCriterion("f_volume =", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeNotEqualTo(Integer value) {
            addCriterion("f_volume <>", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeGreaterThan(Integer value) {
            addCriterion("f_volume >", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_volume >=", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeLessThan(Integer value) {
            addCriterion("f_volume <", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("f_volume <=", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeIn(List<Integer> values) {
            addCriterion("f_volume in", values, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeNotIn(List<Integer> values) {
            addCriterion("f_volume not in", values, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeBetween(Integer value1, Integer value2) {
            addCriterion("f_volume between", value1, value2, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_volume not between", value1, value2, "fVolume");
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

        public Criteria andFDeviceSubnetMaskIsNull() {
            addCriterion("f_device_subnet_mask is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskIsNotNull() {
            addCriterion("f_device_subnet_mask is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskEqualTo(String value) {
            addCriterion("f_device_subnet_mask =", value, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskNotEqualTo(String value) {
            addCriterion("f_device_subnet_mask <>", value, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskGreaterThan(String value) {
            addCriterion("f_device_subnet_mask >", value, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_subnet_mask >=", value, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskLessThan(String value) {
            addCriterion("f_device_subnet_mask <", value, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskLessThanOrEqualTo(String value) {
            addCriterion("f_device_subnet_mask <=", value, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskLike(String value) {
            addCriterion("f_device_subnet_mask like", value, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskNotLike(String value) {
            addCriterion("f_device_subnet_mask not like", value, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskIn(List<String> values) {
            addCriterion("f_device_subnet_mask in", values, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskNotIn(List<String> values) {
            addCriterion("f_device_subnet_mask not in", values, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskBetween(String value1, String value2) {
            addCriterion("f_device_subnet_mask between", value1, value2, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceSubnetMaskNotBetween(String value1, String value2) {
            addCriterion("f_device_subnet_mask not between", value1, value2, "fDeviceSubnetMask");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayIsNull() {
            addCriterion("f_device_gateway is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayIsNotNull() {
            addCriterion("f_device_gateway is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayEqualTo(String value) {
            addCriterion("f_device_gateway =", value, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayNotEqualTo(String value) {
            addCriterion("f_device_gateway <>", value, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayGreaterThan(String value) {
            addCriterion("f_device_gateway >", value, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_gateway >=", value, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayLessThan(String value) {
            addCriterion("f_device_gateway <", value, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayLessThanOrEqualTo(String value) {
            addCriterion("f_device_gateway <=", value, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayLike(String value) {
            addCriterion("f_device_gateway like", value, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayNotLike(String value) {
            addCriterion("f_device_gateway not like", value, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayIn(List<String> values) {
            addCriterion("f_device_gateway in", values, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayNotIn(List<String> values) {
            addCriterion("f_device_gateway not in", values, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayBetween(String value1, String value2) {
            addCriterion("f_device_gateway between", value1, value2, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceGatewayNotBetween(String value1, String value2) {
            addCriterion("f_device_gateway not between", value1, value2, "fDeviceGateway");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionIsNull() {
            addCriterion("f_device_switch_option is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionIsNotNull() {
            addCriterion("f_device_switch_option is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionEqualTo(Integer value) {
            addCriterion("f_device_switch_option =", value, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionNotEqualTo(Integer value) {
            addCriterion("f_device_switch_option <>", value, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionGreaterThan(Integer value) {
            addCriterion("f_device_switch_option >", value, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_device_switch_option >=", value, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionLessThan(Integer value) {
            addCriterion("f_device_switch_option <", value, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionLessThanOrEqualTo(Integer value) {
            addCriterion("f_device_switch_option <=", value, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionIn(List<Integer> values) {
            addCriterion("f_device_switch_option in", values, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionNotIn(List<Integer> values) {
            addCriterion("f_device_switch_option not in", values, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionBetween(Integer value1, Integer value2) {
            addCriterion("f_device_switch_option between", value1, value2, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFDeviceSwitchOptionNotBetween(Integer value1, Integer value2) {
            addCriterion("f_device_switch_option not between", value1, value2, "fDeviceSwitchOption");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyIsNull() {
            addCriterion("f_ts_setting_frequency is null");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyIsNotNull() {
            addCriterion("f_ts_setting_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyEqualTo(Integer value) {
            addCriterion("f_ts_setting_frequency =", value, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyNotEqualTo(Integer value) {
            addCriterion("f_ts_setting_frequency <>", value, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyGreaterThan(Integer value) {
            addCriterion("f_ts_setting_frequency >", value, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_ts_setting_frequency >=", value, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyLessThan(Integer value) {
            addCriterion("f_ts_setting_frequency <", value, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("f_ts_setting_frequency <=", value, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyIn(List<Integer> values) {
            addCriterion("f_ts_setting_frequency in", values, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyNotIn(List<Integer> values) {
            addCriterion("f_ts_setting_frequency not in", values, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("f_ts_setting_frequency between", value1, value2, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("f_ts_setting_frequency not between", value1, value2, "fTsSettingFrequency");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateIsNull() {
            addCriterion("f_ts_setting_symbol_rate is null");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateIsNotNull() {
            addCriterion("f_ts_setting_symbol_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateEqualTo(Integer value) {
            addCriterion("f_ts_setting_symbol_rate =", value, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateNotEqualTo(Integer value) {
            addCriterion("f_ts_setting_symbol_rate <>", value, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateGreaterThan(Integer value) {
            addCriterion("f_ts_setting_symbol_rate >", value, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_ts_setting_symbol_rate >=", value, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateLessThan(Integer value) {
            addCriterion("f_ts_setting_symbol_rate <", value, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateLessThanOrEqualTo(Integer value) {
            addCriterion("f_ts_setting_symbol_rate <=", value, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateIn(List<Integer> values) {
            addCriterion("f_ts_setting_symbol_rate in", values, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateNotIn(List<Integer> values) {
            addCriterion("f_ts_setting_symbol_rate not in", values, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateBetween(Integer value1, Integer value2) {
            addCriterion("f_ts_setting_symbol_rate between", value1, value2, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingSymbolRateNotBetween(Integer value1, Integer value2) {
            addCriterion("f_ts_setting_symbol_rate not between", value1, value2, "fTsSettingSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamIsNull() {
            addCriterion("f_ts_setting_qam is null");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamIsNotNull() {
            addCriterion("f_ts_setting_qam is not null");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamEqualTo(Integer value) {
            addCriterion("f_ts_setting_qam =", value, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamNotEqualTo(Integer value) {
            addCriterion("f_ts_setting_qam <>", value, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamGreaterThan(Integer value) {
            addCriterion("f_ts_setting_qam >", value, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_ts_setting_qam >=", value, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamLessThan(Integer value) {
            addCriterion("f_ts_setting_qam <", value, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamLessThanOrEqualTo(Integer value) {
            addCriterion("f_ts_setting_qam <=", value, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamIn(List<Integer> values) {
            addCriterion("f_ts_setting_qam in", values, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamNotIn(List<Integer> values) {
            addCriterion("f_ts_setting_qam not in", values, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamBetween(Integer value1, Integer value2) {
            addCriterion("f_ts_setting_qam between", value1, value2, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFTsSettingQamNotBetween(Integer value1, Integer value2) {
            addCriterion("f_ts_setting_qam not between", value1, value2, "fTsSettingQam");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeIsNull() {
            addCriterion("f_calibration_time is null");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeIsNotNull() {
            addCriterion("f_calibration_time is not null");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeEqualTo(Date value) {
            addCriterion("f_calibration_time =", value, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeNotEqualTo(Date value) {
            addCriterion("f_calibration_time <>", value, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeGreaterThan(Date value) {
            addCriterion("f_calibration_time >", value, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_calibration_time >=", value, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeLessThan(Date value) {
            addCriterion("f_calibration_time <", value, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_calibration_time <=", value, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeIn(List<Date> values) {
            addCriterion("f_calibration_time in", values, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeNotIn(List<Date> values) {
            addCriterion("f_calibration_time not in", values, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeBetween(Date value1, Date value2) {
            addCriterion("f_calibration_time between", value1, value2, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFCalibrationTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_calibration_time not between", value1, value2, "fCalibrationTime");
            return (Criteria) this;
        }

        public Criteria andFOperatorIsNull() {
            addCriterion("f_operator is null");
            return (Criteria) this;
        }

        public Criteria andFOperatorIsNotNull() {
            addCriterion("f_operator is not null");
            return (Criteria) this;
        }

        public Criteria andFOperatorEqualTo(Integer value) {
            addCriterion("f_operator =", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorNotEqualTo(Integer value) {
            addCriterion("f_operator <>", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorGreaterThan(Integer value) {
            addCriterion("f_operator >", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_operator >=", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorLessThan(Integer value) {
            addCriterion("f_operator <", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("f_operator <=", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorIn(List<Integer> values) {
            addCriterion("f_operator in", values, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorNotIn(List<Integer> values) {
            addCriterion("f_operator not in", values, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorBetween(Integer value1, Integer value2) {
            addCriterion("f_operator between", value1, value2, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("f_operator not between", value1, value2, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeIsNull() {
            addCriterion("f_operate_time is null");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeIsNotNull() {
            addCriterion("f_operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeEqualTo(Date value) {
            addCriterion("f_operate_time =", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeNotEqualTo(Date value) {
            addCriterion("f_operate_time <>", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeGreaterThan(Date value) {
            addCriterion("f_operate_time >", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_operate_time >=", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeLessThan(Date value) {
            addCriterion("f_operate_time <", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_operate_time <=", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeIn(List<Date> values) {
            addCriterion("f_operate_time in", values, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeNotIn(List<Date> values) {
            addCriterion("f_operate_time not in", values, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeBetween(Date value1, Date value2) {
            addCriterion("f_operate_time between", value1, value2, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_operate_time not between", value1, value2, "fOperateTime");
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