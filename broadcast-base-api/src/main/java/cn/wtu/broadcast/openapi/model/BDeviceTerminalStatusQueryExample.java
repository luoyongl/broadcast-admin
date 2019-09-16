package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.List;

public class BDeviceTerminalStatusQueryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDeviceTerminalStatusQueryExample() {
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

        public Criteria andFTerminalVolumeIsNull() {
            addCriterion("f_terminal_volume is null");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeIsNotNull() {
            addCriterion("f_terminal_volume is not null");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeEqualTo(Integer value) {
            addCriterion("f_terminal_volume =", value, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeNotEqualTo(Integer value) {
            addCriterion("f_terminal_volume <>", value, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeGreaterThan(Integer value) {
            addCriterion("f_terminal_volume >", value, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_terminal_volume >=", value, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeLessThan(Integer value) {
            addCriterion("f_terminal_volume <", value, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("f_terminal_volume <=", value, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeIn(List<Integer> values) {
            addCriterion("f_terminal_volume in", values, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeNotIn(List<Integer> values) {
            addCriterion("f_terminal_volume not in", values, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeBetween(Integer value1, Integer value2) {
            addCriterion("f_terminal_volume between", value1, value2, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFTerminalVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_terminal_volume not between", value1, value2, "fTerminalVolume");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressIsNull() {
            addCriterion("f_local_address is null");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressIsNotNull() {
            addCriterion("f_local_address is not null");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressEqualTo(String value) {
            addCriterion("f_local_address =", value, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressNotEqualTo(String value) {
            addCriterion("f_local_address <>", value, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressGreaterThan(String value) {
            addCriterion("f_local_address >", value, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressGreaterThanOrEqualTo(String value) {
            addCriterion("f_local_address >=", value, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressLessThan(String value) {
            addCriterion("f_local_address <", value, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressLessThanOrEqualTo(String value) {
            addCriterion("f_local_address <=", value, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressLike(String value) {
            addCriterion("f_local_address like", value, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressNotLike(String value) {
            addCriterion("f_local_address not like", value, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressIn(List<String> values) {
            addCriterion("f_local_address in", values, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressNotIn(List<String> values) {
            addCriterion("f_local_address not in", values, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressBetween(String value1, String value2) {
            addCriterion("f_local_address between", value1, value2, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFLocalAddressNotBetween(String value1, String value2) {
            addCriterion("f_local_address not between", value1, value2, "fLocalAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressIsNull() {
            addCriterion("f_return_address is null");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressIsNotNull() {
            addCriterion("f_return_address is not null");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressEqualTo(String value) {
            addCriterion("f_return_address =", value, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressNotEqualTo(String value) {
            addCriterion("f_return_address <>", value, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressGreaterThan(String value) {
            addCriterion("f_return_address >", value, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressGreaterThanOrEqualTo(String value) {
            addCriterion("f_return_address >=", value, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressLessThan(String value) {
            addCriterion("f_return_address <", value, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressLessThanOrEqualTo(String value) {
            addCriterion("f_return_address <=", value, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressLike(String value) {
            addCriterion("f_return_address like", value, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressNotLike(String value) {
            addCriterion("f_return_address not like", value, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressIn(List<String> values) {
            addCriterion("f_return_address in", values, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressNotIn(List<String> values) {
            addCriterion("f_return_address not in", values, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressBetween(String value1, String value2) {
            addCriterion("f_return_address between", value1, value2, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFReturnAddressNotBetween(String value1, String value2) {
            addCriterion("f_return_address not between", value1, value2, "fReturnAddress");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeIsNull() {
            addCriterion("f_terminal_resource_code is null");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeIsNotNull() {
            addCriterion("f_terminal_resource_code is not null");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeEqualTo(String value) {
            addCriterion("f_terminal_resource_code =", value, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeNotEqualTo(String value) {
            addCriterion("f_terminal_resource_code <>", value, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeGreaterThan(String value) {
            addCriterion("f_terminal_resource_code >", value, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_terminal_resource_code >=", value, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeLessThan(String value) {
            addCriterion("f_terminal_resource_code <", value, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeLessThanOrEqualTo(String value) {
            addCriterion("f_terminal_resource_code <=", value, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeLike(String value) {
            addCriterion("f_terminal_resource_code like", value, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeNotLike(String value) {
            addCriterion("f_terminal_resource_code not like", value, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeIn(List<String> values) {
            addCriterion("f_terminal_resource_code in", values, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeNotIn(List<String> values) {
            addCriterion("f_terminal_resource_code not in", values, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeBetween(String value1, String value2) {
            addCriterion("f_terminal_resource_code between", value1, value2, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFTerminalResourceCodeNotBetween(String value1, String value2) {
            addCriterion("f_terminal_resource_code not between", value1, value2, "fTerminalResourceCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeIsNull() {
            addCriterion("f_physical_address_code is null");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeIsNotNull() {
            addCriterion("f_physical_address_code is not null");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeEqualTo(String value) {
            addCriterion("f_physical_address_code =", value, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeNotEqualTo(String value) {
            addCriterion("f_physical_address_code <>", value, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeGreaterThan(String value) {
            addCriterion("f_physical_address_code >", value, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_physical_address_code >=", value, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeLessThan(String value) {
            addCriterion("f_physical_address_code <", value, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeLessThanOrEqualTo(String value) {
            addCriterion("f_physical_address_code <=", value, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeLike(String value) {
            addCriterion("f_physical_address_code like", value, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeNotLike(String value) {
            addCriterion("f_physical_address_code not like", value, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeIn(List<String> values) {
            addCriterion("f_physical_address_code in", values, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeNotIn(List<String> values) {
            addCriterion("f_physical_address_code not in", values, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeBetween(String value1, String value2) {
            addCriterion("f_physical_address_code between", value1, value2, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressCodeNotBetween(String value1, String value2) {
            addCriterion("f_physical_address_code not between", value1, value2, "fPhysicalAddressCode");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionIsNull() {
            addCriterion("f_working_condition is null");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionIsNotNull() {
            addCriterion("f_working_condition is not null");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionEqualTo(String value) {
            addCriterion("f_working_condition =", value, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionNotEqualTo(String value) {
            addCriterion("f_working_condition <>", value, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionGreaterThan(String value) {
            addCriterion("f_working_condition >", value, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionGreaterThanOrEqualTo(String value) {
            addCriterion("f_working_condition >=", value, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionLessThan(String value) {
            addCriterion("f_working_condition <", value, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionLessThanOrEqualTo(String value) {
            addCriterion("f_working_condition <=", value, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionLike(String value) {
            addCriterion("f_working_condition like", value, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionNotLike(String value) {
            addCriterion("f_working_condition not like", value, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionIn(List<String> values) {
            addCriterion("f_working_condition in", values, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionNotIn(List<String> values) {
            addCriterion("f_working_condition not in", values, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionBetween(String value1, String value2) {
            addCriterion("f_working_condition between", value1, value2, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFWorkingConditionNotBetween(String value1, String value2) {
            addCriterion("f_working_condition not between", value1, value2, "fWorkingCondition");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeIsNull() {
            addCriterion("f_fault_code is null");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeIsNotNull() {
            addCriterion("f_fault_code is not null");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeEqualTo(String value) {
            addCriterion("f_fault_code =", value, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeNotEqualTo(String value) {
            addCriterion("f_fault_code <>", value, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeGreaterThan(String value) {
            addCriterion("f_fault_code >", value, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_fault_code >=", value, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeLessThan(String value) {
            addCriterion("f_fault_code <", value, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeLessThanOrEqualTo(String value) {
            addCriterion("f_fault_code <=", value, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeLike(String value) {
            addCriterion("f_fault_code like", value, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeNotLike(String value) {
            addCriterion("f_fault_code not like", value, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeIn(List<String> values) {
            addCriterion("f_fault_code in", values, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeNotIn(List<String> values) {
            addCriterion("f_fault_code not in", values, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeBetween(String value1, String value2) {
            addCriterion("f_fault_code between", value1, value2, "fFaultCode");
            return (Criteria) this;
        }

        public Criteria andFFaultCodeNotBetween(String value1, String value2) {
            addCriterion("f_fault_code not between", value1, value2, "fFaultCode");
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

        public Criteria andFDeviceTypeEqualTo(String value) {
            addCriterion("f_device_type =", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotEqualTo(String value) {
            addCriterion("f_device_type <>", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeGreaterThan(String value) {
            addCriterion("f_device_type >", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_type >=", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeLessThan(String value) {
            addCriterion("f_device_type <", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("f_device_type <=", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeLike(String value) {
            addCriterion("f_device_type like", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotLike(String value) {
            addCriterion("f_device_type not like", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeIn(List<String> values) {
            addCriterion("f_device_type in", values, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotIn(List<String> values) {
            addCriterion("f_device_type not in", values, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeBetween(String value1, String value2) {
            addCriterion("f_device_type between", value1, value2, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("f_device_type not between", value1, value2, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberIsNull() {
            addCriterion("f_hardware_version_number is null");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberIsNotNull() {
            addCriterion("f_hardware_version_number is not null");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberEqualTo(String value) {
            addCriterion("f_hardware_version_number =", value, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberNotEqualTo(String value) {
            addCriterion("f_hardware_version_number <>", value, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberGreaterThan(String value) {
            addCriterion("f_hardware_version_number >", value, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_hardware_version_number >=", value, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberLessThan(String value) {
            addCriterion("f_hardware_version_number <", value, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberLessThanOrEqualTo(String value) {
            addCriterion("f_hardware_version_number <=", value, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberLike(String value) {
            addCriterion("f_hardware_version_number like", value, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberNotLike(String value) {
            addCriterion("f_hardware_version_number not like", value, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberIn(List<String> values) {
            addCriterion("f_hardware_version_number in", values, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberNotIn(List<String> values) {
            addCriterion("f_hardware_version_number not in", values, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberBetween(String value1, String value2) {
            addCriterion("f_hardware_version_number between", value1, value2, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNumberNotBetween(String value1, String value2) {
            addCriterion("f_hardware_version_number not between", value1, value2, "fHardwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberIsNull() {
            addCriterion("f_software_version_number is null");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberIsNotNull() {
            addCriterion("f_software_version_number is not null");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberEqualTo(String value) {
            addCriterion("f_software_version_number =", value, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberNotEqualTo(String value) {
            addCriterion("f_software_version_number <>", value, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberGreaterThan(String value) {
            addCriterion("f_software_version_number >", value, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_software_version_number >=", value, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberLessThan(String value) {
            addCriterion("f_software_version_number <", value, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberLessThanOrEqualTo(String value) {
            addCriterion("f_software_version_number <=", value, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberLike(String value) {
            addCriterion("f_software_version_number like", value, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberNotLike(String value) {
            addCriterion("f_software_version_number not like", value, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberIn(List<String> values) {
            addCriterion("f_software_version_number in", values, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberNotIn(List<String> values) {
            addCriterion("f_software_version_number not in", values, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberBetween(String value1, String value2) {
            addCriterion("f_software_version_number between", value1, value2, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNumberNotBetween(String value1, String value2) {
            addCriterion("f_software_version_number not between", value1, value2, "fSoftwareVersionNumber");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusIsNull() {
            addCriterion("f_fm_signal_status is null");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusIsNotNull() {
            addCriterion("f_fm_signal_status is not null");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusEqualTo(String value) {
            addCriterion("f_fm_signal_status =", value, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusNotEqualTo(String value) {
            addCriterion("f_fm_signal_status <>", value, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusGreaterThan(String value) {
            addCriterion("f_fm_signal_status >", value, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("f_fm_signal_status >=", value, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusLessThan(String value) {
            addCriterion("f_fm_signal_status <", value, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusLessThanOrEqualTo(String value) {
            addCriterion("f_fm_signal_status <=", value, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusLike(String value) {
            addCriterion("f_fm_signal_status like", value, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusNotLike(String value) {
            addCriterion("f_fm_signal_status not like", value, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusIn(List<String> values) {
            addCriterion("f_fm_signal_status in", values, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusNotIn(List<String> values) {
            addCriterion("f_fm_signal_status not in", values, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusBetween(String value1, String value2) {
            addCriterion("f_fm_signal_status between", value1, value2, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFFmSignalStatusNotBetween(String value1, String value2) {
            addCriterion("f_fm_signal_status not between", value1, value2, "fFmSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusIsNull() {
            addCriterion("f_cable_signal_status is null");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusIsNotNull() {
            addCriterion("f_cable_signal_status is not null");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusEqualTo(String value) {
            addCriterion("f_cable_signal_status =", value, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusNotEqualTo(String value) {
            addCriterion("f_cable_signal_status <>", value, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusGreaterThan(String value) {
            addCriterion("f_cable_signal_status >", value, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("f_cable_signal_status >=", value, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusLessThan(String value) {
            addCriterion("f_cable_signal_status <", value, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusLessThanOrEqualTo(String value) {
            addCriterion("f_cable_signal_status <=", value, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusLike(String value) {
            addCriterion("f_cable_signal_status like", value, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusNotLike(String value) {
            addCriterion("f_cable_signal_status not like", value, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusIn(List<String> values) {
            addCriterion("f_cable_signal_status in", values, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusNotIn(List<String> values) {
            addCriterion("f_cable_signal_status not in", values, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusBetween(String value1, String value2) {
            addCriterion("f_cable_signal_status between", value1, value2, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableSignalStatusNotBetween(String value1, String value2) {
            addCriterion("f_cable_signal_status not between", value1, value2, "fCableSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusIsNull() {
            addCriterion("f_ground_wireless_signal_status is null");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusIsNotNull() {
            addCriterion("f_ground_wireless_signal_status is not null");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusEqualTo(String value) {
            addCriterion("f_ground_wireless_signal_status =", value, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusNotEqualTo(String value) {
            addCriterion("f_ground_wireless_signal_status <>", value, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusGreaterThan(String value) {
            addCriterion("f_ground_wireless_signal_status >", value, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("f_ground_wireless_signal_status >=", value, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusLessThan(String value) {
            addCriterion("f_ground_wireless_signal_status <", value, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusLessThanOrEqualTo(String value) {
            addCriterion("f_ground_wireless_signal_status <=", value, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusLike(String value) {
            addCriterion("f_ground_wireless_signal_status like", value, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusNotLike(String value) {
            addCriterion("f_ground_wireless_signal_status not like", value, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusIn(List<String> values) {
            addCriterion("f_ground_wireless_signal_status in", values, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusNotIn(List<String> values) {
            addCriterion("f_ground_wireless_signal_status not in", values, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusBetween(String value1, String value2) {
            addCriterion("f_ground_wireless_signal_status between", value1, value2, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessSignalStatusNotBetween(String value1, String value2) {
            addCriterion("f_ground_wireless_signal_status not between", value1, value2, "fGroundWirelessSignalStatus");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyIsNull() {
            addCriterion("f_cable_frequency is null");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyIsNotNull() {
            addCriterion("f_cable_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyEqualTo(String value) {
            addCriterion("f_cable_frequency =", value, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyNotEqualTo(String value) {
            addCriterion("f_cable_frequency <>", value, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyGreaterThan(String value) {
            addCriterion("f_cable_frequency >", value, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("f_cable_frequency >=", value, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyLessThan(String value) {
            addCriterion("f_cable_frequency <", value, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyLessThanOrEqualTo(String value) {
            addCriterion("f_cable_frequency <=", value, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyLike(String value) {
            addCriterion("f_cable_frequency like", value, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyNotLike(String value) {
            addCriterion("f_cable_frequency not like", value, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyIn(List<String> values) {
            addCriterion("f_cable_frequency in", values, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyNotIn(List<String> values) {
            addCriterion("f_cable_frequency not in", values, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyBetween(String value1, String value2) {
            addCriterion("f_cable_frequency between", value1, value2, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFCableFrequencyNotBetween(String value1, String value2) {
            addCriterion("f_cable_frequency not between", value1, value2, "fCableFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyIsNull() {
            addCriterion("f_ground_wireless_frequency is null");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyIsNotNull() {
            addCriterion("f_ground_wireless_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyEqualTo(String value) {
            addCriterion("f_ground_wireless_frequency =", value, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyNotEqualTo(String value) {
            addCriterion("f_ground_wireless_frequency <>", value, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyGreaterThan(String value) {
            addCriterion("f_ground_wireless_frequency >", value, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("f_ground_wireless_frequency >=", value, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyLessThan(String value) {
            addCriterion("f_ground_wireless_frequency <", value, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyLessThanOrEqualTo(String value) {
            addCriterion("f_ground_wireless_frequency <=", value, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyLike(String value) {
            addCriterion("f_ground_wireless_frequency like", value, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyNotLike(String value) {
            addCriterion("f_ground_wireless_frequency not like", value, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyIn(List<String> values) {
            addCriterion("f_ground_wireless_frequency in", values, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyNotIn(List<String> values) {
            addCriterion("f_ground_wireless_frequency not in", values, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyBetween(String value1, String value2) {
            addCriterion("f_ground_wireless_frequency between", value1, value2, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFGroundWirelessFrequencyNotBetween(String value1, String value2) {
            addCriterion("f_ground_wireless_frequency not between", value1, value2, "fGroundWirelessFrequency");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListIsNull() {
            addCriterion("f_fm_frequency_scan_list is null");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListIsNotNull() {
            addCriterion("f_fm_frequency_scan_list is not null");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListEqualTo(String value) {
            addCriterion("f_fm_frequency_scan_list =", value, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListNotEqualTo(String value) {
            addCriterion("f_fm_frequency_scan_list <>", value, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListGreaterThan(String value) {
            addCriterion("f_fm_frequency_scan_list >", value, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListGreaterThanOrEqualTo(String value) {
            addCriterion("f_fm_frequency_scan_list >=", value, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListLessThan(String value) {
            addCriterion("f_fm_frequency_scan_list <", value, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListLessThanOrEqualTo(String value) {
            addCriterion("f_fm_frequency_scan_list <=", value, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListLike(String value) {
            addCriterion("f_fm_frequency_scan_list like", value, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListNotLike(String value) {
            addCriterion("f_fm_frequency_scan_list not like", value, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListIn(List<String> values) {
            addCriterion("f_fm_frequency_scan_list in", values, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListNotIn(List<String> values) {
            addCriterion("f_fm_frequency_scan_list not in", values, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListBetween(String value1, String value2) {
            addCriterion("f_fm_frequency_scan_list between", value1, value2, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmFrequencyScanListNotBetween(String value1, String value2) {
            addCriterion("f_fm_frequency_scan_list not between", value1, value2, "fFmFrequencyScanList");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointIsNull() {
            addCriterion("f_fm_current_frequency_point is null");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointIsNotNull() {
            addCriterion("f_fm_current_frequency_point is not null");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointEqualTo(String value) {
            addCriterion("f_fm_current_frequency_point =", value, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointNotEqualTo(String value) {
            addCriterion("f_fm_current_frequency_point <>", value, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointGreaterThan(String value) {
            addCriterion("f_fm_current_frequency_point >", value, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointGreaterThanOrEqualTo(String value) {
            addCriterion("f_fm_current_frequency_point >=", value, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointLessThan(String value) {
            addCriterion("f_fm_current_frequency_point <", value, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointLessThanOrEqualTo(String value) {
            addCriterion("f_fm_current_frequency_point <=", value, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointLike(String value) {
            addCriterion("f_fm_current_frequency_point like", value, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointNotLike(String value) {
            addCriterion("f_fm_current_frequency_point not like", value, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointIn(List<String> values) {
            addCriterion("f_fm_current_frequency_point in", values, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointNotIn(List<String> values) {
            addCriterion("f_fm_current_frequency_point not in", values, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointBetween(String value1, String value2) {
            addCriterion("f_fm_current_frequency_point between", value1, value2, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmCurrentFrequencyPointNotBetween(String value1, String value2) {
            addCriterion("f_fm_current_frequency_point not between", value1, value2, "fFmCurrentFrequencyPoint");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeIsNull() {
            addCriterion("f_fm_maintenance_instruction_mode is null");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeIsNotNull() {
            addCriterion("f_fm_maintenance_instruction_mode is not null");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeEqualTo(String value) {
            addCriterion("f_fm_maintenance_instruction_mode =", value, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeNotEqualTo(String value) {
            addCriterion("f_fm_maintenance_instruction_mode <>", value, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeGreaterThan(String value) {
            addCriterion("f_fm_maintenance_instruction_mode >", value, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeGreaterThanOrEqualTo(String value) {
            addCriterion("f_fm_maintenance_instruction_mode >=", value, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeLessThan(String value) {
            addCriterion("f_fm_maintenance_instruction_mode <", value, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeLessThanOrEqualTo(String value) {
            addCriterion("f_fm_maintenance_instruction_mode <=", value, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeLike(String value) {
            addCriterion("f_fm_maintenance_instruction_mode like", value, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeNotLike(String value) {
            addCriterion("f_fm_maintenance_instruction_mode not like", value, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeIn(List<String> values) {
            addCriterion("f_fm_maintenance_instruction_mode in", values, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeNotIn(List<String> values) {
            addCriterion("f_fm_maintenance_instruction_mode not in", values, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeBetween(String value1, String value2) {
            addCriterion("f_fm_maintenance_instruction_mode between", value1, value2, "fFmMaintenanceInstructionMode");
            return (Criteria) this;
        }

        public Criteria andFFmMaintenanceInstructionModeNotBetween(String value1, String value2) {
            addCriterion("f_fm_maintenance_instruction_mode not between", value1, value2, "fFmMaintenanceInstructionMode");
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