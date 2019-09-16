package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BProgramChannelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BProgramChannelExample() {
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

        public Criteria andFPassNumberIsNull() {
            addCriterion("f_pass_number is null");
            return (Criteria) this;
        }

        public Criteria andFPassNumberIsNotNull() {
            addCriterion("f_pass_number is not null");
            return (Criteria) this;
        }

        public Criteria andFPassNumberEqualTo(String value) {
            addCriterion("f_pass_number =", value, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberNotEqualTo(String value) {
            addCriterion("f_pass_number <>", value, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberGreaterThan(String value) {
            addCriterion("f_pass_number >", value, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_pass_number >=", value, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberLessThan(String value) {
            addCriterion("f_pass_number <", value, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberLessThanOrEqualTo(String value) {
            addCriterion("f_pass_number <=", value, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberLike(String value) {
            addCriterion("f_pass_number like", value, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberNotLike(String value) {
            addCriterion("f_pass_number not like", value, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberIn(List<String> values) {
            addCriterion("f_pass_number in", values, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberNotIn(List<String> values) {
            addCriterion("f_pass_number not in", values, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberBetween(String value1, String value2) {
            addCriterion("f_pass_number between", value1, value2, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFPassNumberNotBetween(String value1, String value2) {
            addCriterion("f_pass_number not between", value1, value2, "fPassNumber");
            return (Criteria) this;
        }

        public Criteria andFModulationIsNull() {
            addCriterion("f_modulation is null");
            return (Criteria) this;
        }

        public Criteria andFModulationIsNotNull() {
            addCriterion("f_modulation is not null");
            return (Criteria) this;
        }

        public Criteria andFModulationEqualTo(String value) {
            addCriterion("f_modulation =", value, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationNotEqualTo(String value) {
            addCriterion("f_modulation <>", value, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationGreaterThan(String value) {
            addCriterion("f_modulation >", value, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationGreaterThanOrEqualTo(String value) {
            addCriterion("f_modulation >=", value, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationLessThan(String value) {
            addCriterion("f_modulation <", value, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationLessThanOrEqualTo(String value) {
            addCriterion("f_modulation <=", value, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationLike(String value) {
            addCriterion("f_modulation like", value, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationNotLike(String value) {
            addCriterion("f_modulation not like", value, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationIn(List<String> values) {
            addCriterion("f_modulation in", values, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationNotIn(List<String> values) {
            addCriterion("f_modulation not in", values, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationBetween(String value1, String value2) {
            addCriterion("f_modulation between", value1, value2, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFModulationNotBetween(String value1, String value2) {
            addCriterion("f_modulation not between", value1, value2, "fModulation");
            return (Criteria) this;
        }

        public Criteria andFPassNameIsNull() {
            addCriterion("f_pass_name is null");
            return (Criteria) this;
        }

        public Criteria andFPassNameIsNotNull() {
            addCriterion("f_pass_name is not null");
            return (Criteria) this;
        }

        public Criteria andFPassNameEqualTo(String value) {
            addCriterion("f_pass_name =", value, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameNotEqualTo(String value) {
            addCriterion("f_pass_name <>", value, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameGreaterThan(String value) {
            addCriterion("f_pass_name >", value, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_pass_name >=", value, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameLessThan(String value) {
            addCriterion("f_pass_name <", value, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameLessThanOrEqualTo(String value) {
            addCriterion("f_pass_name <=", value, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameLike(String value) {
            addCriterion("f_pass_name like", value, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameNotLike(String value) {
            addCriterion("f_pass_name not like", value, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameIn(List<String> values) {
            addCriterion("f_pass_name in", values, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameNotIn(List<String> values) {
            addCriterion("f_pass_name not in", values, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameBetween(String value1, String value2) {
            addCriterion("f_pass_name between", value1, value2, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassNameNotBetween(String value1, String value2) {
            addCriterion("f_pass_name not between", value1, value2, "fPassName");
            return (Criteria) this;
        }

        public Criteria andFPassTypeIsNull() {
            addCriterion("f_pass_type is null");
            return (Criteria) this;
        }

        public Criteria andFPassTypeIsNotNull() {
            addCriterion("f_pass_type is not null");
            return (Criteria) this;
        }

        public Criteria andFPassTypeEqualTo(Integer value) {
            addCriterion("f_pass_type =", value, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFPassTypeNotEqualTo(Integer value) {
            addCriterion("f_pass_type <>", value, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFPassTypeGreaterThan(Integer value) {
            addCriterion("f_pass_type >", value, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFPassTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_pass_type >=", value, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFPassTypeLessThan(Integer value) {
            addCriterion("f_pass_type <", value, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFPassTypeLessThanOrEqualTo(Integer value) {
            addCriterion("f_pass_type <=", value, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFPassTypeIn(List<Integer> values) {
            addCriterion("f_pass_type in", values, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFPassTypeNotIn(List<Integer> values) {
            addCriterion("f_pass_type not in", values, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFPassTypeBetween(Integer value1, Integer value2) {
            addCriterion("f_pass_type between", value1, value2, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFPassTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_pass_type not between", value1, value2, "fPassType");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceIsNull() {
            addCriterion("f_control_device is null");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceIsNotNull() {
            addCriterion("f_control_device is not null");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceEqualTo(Integer value) {
            addCriterion("f_control_device =", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceNotEqualTo(Integer value) {
            addCriterion("f_control_device <>", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceGreaterThan(Integer value) {
            addCriterion("f_control_device >", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_control_device >=", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceLessThan(Integer value) {
            addCriterion("f_control_device <", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceLessThanOrEqualTo(Integer value) {
            addCriterion("f_control_device <=", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceIn(List<Integer> values) {
            addCriterion("f_control_device in", values, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceNotIn(List<Integer> values) {
            addCriterion("f_control_device not in", values, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceBetween(Integer value1, Integer value2) {
            addCriterion("f_control_device between", value1, value2, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceNotBetween(Integer value1, Integer value2) {
            addCriterion("f_control_device not between", value1, value2, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaIsNull() {
            addCriterion("f_broadcast_area is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaIsNotNull() {
            addCriterion("f_broadcast_area is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaEqualTo(String value) {
            addCriterion("f_broadcast_area =", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotEqualTo(String value) {
            addCriterion("f_broadcast_area <>", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaGreaterThan(String value) {
            addCriterion("f_broadcast_area >", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaGreaterThanOrEqualTo(String value) {
            addCriterion("f_broadcast_area >=", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaLessThan(String value) {
            addCriterion("f_broadcast_area <", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaLessThanOrEqualTo(String value) {
            addCriterion("f_broadcast_area <=", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaLike(String value) {
            addCriterion("f_broadcast_area like", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotLike(String value) {
            addCriterion("f_broadcast_area not like", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaIn(List<String> values) {
            addCriterion("f_broadcast_area in", values, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotIn(List<String> values) {
            addCriterion("f_broadcast_area not in", values, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaBetween(String value1, String value2) {
            addCriterion("f_broadcast_area between", value1, value2, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotBetween(String value1, String value2) {
            addCriterion("f_broadcast_area not between", value1, value2, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFPriorityIsNull() {
            addCriterion("f_priority is null");
            return (Criteria) this;
        }

        public Criteria andFPriorityIsNotNull() {
            addCriterion("f_priority is not null");
            return (Criteria) this;
        }

        public Criteria andFPriorityEqualTo(Byte value) {
            addCriterion("f_priority =", value, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFPriorityNotEqualTo(Byte value) {
            addCriterion("f_priority <>", value, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFPriorityGreaterThan(Byte value) {
            addCriterion("f_priority >", value, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFPriorityGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_priority >=", value, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFPriorityLessThan(Byte value) {
            addCriterion("f_priority <", value, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFPriorityLessThanOrEqualTo(Byte value) {
            addCriterion("f_priority <=", value, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFPriorityIn(List<Byte> values) {
            addCriterion("f_priority in", values, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFPriorityNotIn(List<Byte> values) {
            addCriterion("f_priority not in", values, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFPriorityBetween(Byte value1, Byte value2) {
            addCriterion("f_priority between", value1, value2, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFPriorityNotBetween(Byte value1, Byte value2) {
            addCriterion("f_priority not between", value1, value2, "fPriority");
            return (Criteria) this;
        }

        public Criteria andFNitIdIsNull() {
            addCriterion("f_nit_id is null");
            return (Criteria) this;
        }

        public Criteria andFNitIdIsNotNull() {
            addCriterion("f_nit_id is not null");
            return (Criteria) this;
        }

        public Criteria andFNitIdEqualTo(String value) {
            addCriterion("f_nit_id =", value, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdNotEqualTo(String value) {
            addCriterion("f_nit_id <>", value, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdGreaterThan(String value) {
            addCriterion("f_nit_id >", value, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_nit_id >=", value, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdLessThan(String value) {
            addCriterion("f_nit_id <", value, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdLessThanOrEqualTo(String value) {
            addCriterion("f_nit_id <=", value, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdLike(String value) {
            addCriterion("f_nit_id like", value, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdNotLike(String value) {
            addCriterion("f_nit_id not like", value, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdIn(List<String> values) {
            addCriterion("f_nit_id in", values, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdNotIn(List<String> values) {
            addCriterion("f_nit_id not in", values, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdBetween(String value1, String value2) {
            addCriterion("f_nit_id between", value1, value2, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFNitIdNotBetween(String value1, String value2) {
            addCriterion("f_nit_id not between", value1, value2, "fNitId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdIsNull() {
            addCriterion("f_pcrp_id is null");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdIsNotNull() {
            addCriterion("f_pcrp_id is not null");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdEqualTo(String value) {
            addCriterion("f_pcrp_id =", value, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdNotEqualTo(String value) {
            addCriterion("f_pcrp_id <>", value, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdGreaterThan(String value) {
            addCriterion("f_pcrp_id >", value, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_pcrp_id >=", value, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdLessThan(String value) {
            addCriterion("f_pcrp_id <", value, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdLessThanOrEqualTo(String value) {
            addCriterion("f_pcrp_id <=", value, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdLike(String value) {
            addCriterion("f_pcrp_id like", value, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdNotLike(String value) {
            addCriterion("f_pcrp_id not like", value, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdIn(List<String> values) {
            addCriterion("f_pcrp_id in", values, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdNotIn(List<String> values) {
            addCriterion("f_pcrp_id not in", values, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdBetween(String value1, String value2) {
            addCriterion("f_pcrp_id between", value1, value2, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFPcrpIdNotBetween(String value1, String value2) {
            addCriterion("f_pcrp_id not between", value1, value2, "fPcrpId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdIsNull() {
            addCriterion("f_service_id is null");
            return (Criteria) this;
        }

        public Criteria andFServiceIdIsNotNull() {
            addCriterion("f_service_id is not null");
            return (Criteria) this;
        }

        public Criteria andFServiceIdEqualTo(String value) {
            addCriterion("f_service_id =", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdNotEqualTo(String value) {
            addCriterion("f_service_id <>", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdGreaterThan(String value) {
            addCriterion("f_service_id >", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_service_id >=", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdLessThan(String value) {
            addCriterion("f_service_id <", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdLessThanOrEqualTo(String value) {
            addCriterion("f_service_id <=", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdLike(String value) {
            addCriterion("f_service_id like", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdNotLike(String value) {
            addCriterion("f_service_id not like", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdIn(List<String> values) {
            addCriterion("f_service_id in", values, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdNotIn(List<String> values) {
            addCriterion("f_service_id not in", values, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdBetween(String value1, String value2) {
            addCriterion("f_service_id between", value1, value2, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdNotBetween(String value1, String value2) {
            addCriterion("f_service_id not between", value1, value2, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFTsIdIsNull() {
            addCriterion("f_ts_id is null");
            return (Criteria) this;
        }

        public Criteria andFTsIdIsNotNull() {
            addCriterion("f_ts_id is not null");
            return (Criteria) this;
        }

        public Criteria andFTsIdEqualTo(String value) {
            addCriterion("f_ts_id =", value, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdNotEqualTo(String value) {
            addCriterion("f_ts_id <>", value, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdGreaterThan(String value) {
            addCriterion("f_ts_id >", value, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_ts_id >=", value, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdLessThan(String value) {
            addCriterion("f_ts_id <", value, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdLessThanOrEqualTo(String value) {
            addCriterion("f_ts_id <=", value, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdLike(String value) {
            addCriterion("f_ts_id like", value, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdNotLike(String value) {
            addCriterion("f_ts_id not like", value, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdIn(List<String> values) {
            addCriterion("f_ts_id in", values, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdNotIn(List<String> values) {
            addCriterion("f_ts_id not in", values, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdBetween(String value1, String value2) {
            addCriterion("f_ts_id between", value1, value2, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFTsIdNotBetween(String value1, String value2) {
            addCriterion("f_ts_id not between", value1, value2, "fTsId");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeIsNull() {
            addCriterion("f_media_type is null");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeIsNotNull() {
            addCriterion("f_media_type is not null");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeEqualTo(Integer value) {
            addCriterion("f_media_type =", value, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeNotEqualTo(Integer value) {
            addCriterion("f_media_type <>", value, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeGreaterThan(Integer value) {
            addCriterion("f_media_type >", value, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_media_type >=", value, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeLessThan(Integer value) {
            addCriterion("f_media_type <", value, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeLessThanOrEqualTo(Integer value) {
            addCriterion("f_media_type <=", value, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeIn(List<Integer> values) {
            addCriterion("f_media_type in", values, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeNotIn(List<Integer> values) {
            addCriterion("f_media_type not in", values, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeBetween(Integer value1, Integer value2) {
            addCriterion("f_media_type between", value1, value2, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_media_type not between", value1, value2, "fMediaType");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlIsNull() {
            addCriterion("f_media_url is null");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlIsNotNull() {
            addCriterion("f_media_url is not null");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlEqualTo(String value) {
            addCriterion("f_media_url =", value, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlNotEqualTo(String value) {
            addCriterion("f_media_url <>", value, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlGreaterThan(String value) {
            addCriterion("f_media_url >", value, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlGreaterThanOrEqualTo(String value) {
            addCriterion("f_media_url >=", value, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlLessThan(String value) {
            addCriterion("f_media_url <", value, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlLessThanOrEqualTo(String value) {
            addCriterion("f_media_url <=", value, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlLike(String value) {
            addCriterion("f_media_url like", value, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlNotLike(String value) {
            addCriterion("f_media_url not like", value, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlIn(List<String> values) {
            addCriterion("f_media_url in", values, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlNotIn(List<String> values) {
            addCriterion("f_media_url not in", values, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlBetween(String value1, String value2) {
            addCriterion("f_media_url between", value1, value2, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFMediaUrlNotBetween(String value1, String value2) {
            addCriterion("f_media_url not between", value1, value2, "fMediaUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioPidIsNull() {
            addCriterion("f_audio_pid is null");
            return (Criteria) this;
        }

        public Criteria andFAudioPidIsNotNull() {
            addCriterion("f_audio_pid is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioPidEqualTo(String value) {
            addCriterion("f_audio_pid =", value, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidNotEqualTo(String value) {
            addCriterion("f_audio_pid <>", value, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidGreaterThan(String value) {
            addCriterion("f_audio_pid >", value, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidGreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_pid >=", value, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidLessThan(String value) {
            addCriterion("f_audio_pid <", value, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidLessThanOrEqualTo(String value) {
            addCriterion("f_audio_pid <=", value, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidLike(String value) {
            addCriterion("f_audio_pid like", value, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidNotLike(String value) {
            addCriterion("f_audio_pid not like", value, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidIn(List<String> values) {
            addCriterion("f_audio_pid in", values, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidNotIn(List<String> values) {
            addCriterion("f_audio_pid not in", values, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidBetween(String value1, String value2) {
            addCriterion("f_audio_pid between", value1, value2, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFAudioPidNotBetween(String value1, String value2) {
            addCriterion("f_audio_pid not between", value1, value2, "fAudioPid");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputIsNull() {
            addCriterion("f_rds_output is null");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputIsNotNull() {
            addCriterion("f_rds_output is not null");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputEqualTo(String value) {
            addCriterion("f_rds_output =", value, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputNotEqualTo(String value) {
            addCriterion("f_rds_output <>", value, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputGreaterThan(String value) {
            addCriterion("f_rds_output >", value, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputGreaterThanOrEqualTo(String value) {
            addCriterion("f_rds_output >=", value, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputLessThan(String value) {
            addCriterion("f_rds_output <", value, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputLessThanOrEqualTo(String value) {
            addCriterion("f_rds_output <=", value, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputLike(String value) {
            addCriterion("f_rds_output like", value, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputNotLike(String value) {
            addCriterion("f_rds_output not like", value, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputIn(List<String> values) {
            addCriterion("f_rds_output in", values, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputNotIn(List<String> values) {
            addCriterion("f_rds_output not in", values, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputBetween(String value1, String value2) {
            addCriterion("f_rds_output between", value1, value2, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFRdsOutputNotBetween(String value1, String value2) {
            addCriterion("f_rds_output not between", value1, value2, "fRdsOutput");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressIsNull() {
            addCriterion("f_output_address is null");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressIsNotNull() {
            addCriterion("f_output_address is not null");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressEqualTo(String value) {
            addCriterion("f_output_address =", value, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressNotEqualTo(String value) {
            addCriterion("f_output_address <>", value, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressGreaterThan(String value) {
            addCriterion("f_output_address >", value, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressGreaterThanOrEqualTo(String value) {
            addCriterion("f_output_address >=", value, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressLessThan(String value) {
            addCriterion("f_output_address <", value, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressLessThanOrEqualTo(String value) {
            addCriterion("f_output_address <=", value, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressLike(String value) {
            addCriterion("f_output_address like", value, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressNotLike(String value) {
            addCriterion("f_output_address not like", value, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressIn(List<String> values) {
            addCriterion("f_output_address in", values, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressNotIn(List<String> values) {
            addCriterion("f_output_address not in", values, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressBetween(String value1, String value2) {
            addCriterion("f_output_address between", value1, value2, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputAddressNotBetween(String value1, String value2) {
            addCriterion("f_output_address not between", value1, value2, "fOutputAddress");
            return (Criteria) this;
        }

        public Criteria andFOutputPortIsNull() {
            addCriterion("f_output_port is null");
            return (Criteria) this;
        }

        public Criteria andFOutputPortIsNotNull() {
            addCriterion("f_output_port is not null");
            return (Criteria) this;
        }

        public Criteria andFOutputPortEqualTo(Short value) {
            addCriterion("f_output_port =", value, "fOutputPort");
            return (Criteria) this;
        }

        public Criteria andFOutputPortNotEqualTo(Short value) {
            addCriterion("f_output_port <>", value, "fOutputPort");
            return (Criteria) this;
        }

        public Criteria andFOutputPortGreaterThan(Short value) {
            addCriterion("f_output_port >", value, "fOutputPort");
            return (Criteria) this;
        }

        public Criteria andFOutputPortGreaterThanOrEqualTo(Short value) {
            addCriterion("f_output_port >=", value, "fOutputPort");
            return (Criteria) this;
        }

        public Criteria andFOutputPortLessThan(Short value) {
            addCriterion("f_output_port <", value, "fOutputPort");
            return (Criteria) this;
        }

        public Criteria andFOutputPortLessThanOrEqualTo(Short value) {
            addCriterion("f_output_port <=", value, "fOutputPort");
            return (Criteria) this;
        }

        public Criteria andFOutputPortIn(List<Short> values) {
            addCriterion("f_output_port in", values, "fOutputPort");
            return (Criteria) this;
        }

        public Criteria andFOutputPortNotIn(List<Short> values) {
            addCriterion("f_output_port not in", values, "fOutputPort");
            return (Criteria) this;
        }

        public Criteria andFOutputPortBetween(Short value1, Short value2) {
            addCriterion("f_output_port between", value1, value2, "fOutputPort");
            return (Criteria) this;
        }

        public Criteria andFOutputPortNotBetween(Short value1, Short value2) {
            addCriterion("f_output_port not between", value1, value2, "fOutputPort");
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