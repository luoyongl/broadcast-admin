package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BWhitelistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BWhitelistExample() {
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

        public Criteria andFAssociatedIdIsNull() {
            addCriterion("f_associated_id is null");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdIsNotNull() {
            addCriterion("f_associated_id is not null");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdEqualTo(String value) {
            addCriterion("f_associated_id =", value, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdNotEqualTo(String value) {
            addCriterion("f_associated_id <>", value, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdGreaterThan(String value) {
            addCriterion("f_associated_id >", value, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_associated_id >=", value, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdLessThan(String value) {
            addCriterion("f_associated_id <", value, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdLessThanOrEqualTo(String value) {
            addCriterion("f_associated_id <=", value, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdLike(String value) {
            addCriterion("f_associated_id like", value, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdNotLike(String value) {
            addCriterion("f_associated_id not like", value, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdIn(List<String> values) {
            addCriterion("f_associated_id in", values, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdNotIn(List<String> values) {
            addCriterion("f_associated_id not in", values, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdBetween(String value1, String value2) {
            addCriterion("f_associated_id between", value1, value2, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFAssociatedIdNotBetween(String value1, String value2) {
            addCriterion("f_associated_id not between", value1, value2, "fAssociatedId");
            return (Criteria) this;
        }

        public Criteria andFOperTypeIsNull() {
            addCriterion("f_oper_type is null");
            return (Criteria) this;
        }

        public Criteria andFOperTypeIsNotNull() {
            addCriterion("f_oper_type is not null");
            return (Criteria) this;
        }

        public Criteria andFOperTypeEqualTo(Integer value) {
            addCriterion("f_oper_type =", value, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFOperTypeNotEqualTo(Integer value) {
            addCriterion("f_oper_type <>", value, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFOperTypeGreaterThan(Integer value) {
            addCriterion("f_oper_type >", value, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFOperTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_oper_type >=", value, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFOperTypeLessThan(Integer value) {
            addCriterion("f_oper_type <", value, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFOperTypeLessThanOrEqualTo(Integer value) {
            addCriterion("f_oper_type <=", value, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFOperTypeIn(List<Integer> values) {
            addCriterion("f_oper_type in", values, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFOperTypeNotIn(List<Integer> values) {
            addCriterion("f_oper_type not in", values, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFOperTypeBetween(Integer value1, Integer value2) {
            addCriterion("f_oper_type between", value1, value2, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFOperTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_oper_type not between", value1, value2, "fOperType");
            return (Criteria) this;
        }

        public Criteria andFNameIsNull() {
            addCriterion("f_name is null");
            return (Criteria) this;
        }

        public Criteria andFNameIsNotNull() {
            addCriterion("f_name is not null");
            return (Criteria) this;
        }

        public Criteria andFNameEqualTo(String value) {
            addCriterion("f_name =", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotEqualTo(String value) {
            addCriterion("f_name <>", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThan(String value) {
            addCriterion("f_name >", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_name >=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThan(String value) {
            addCriterion("f_name <", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThanOrEqualTo(String value) {
            addCriterion("f_name <=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLike(String value) {
            addCriterion("f_name like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotLike(String value) {
            addCriterion("f_name not like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameIn(List<String> values) {
            addCriterion("f_name in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotIn(List<String> values) {
            addCriterion("f_name not in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameBetween(String value1, String value2) {
            addCriterion("f_name between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotBetween(String value1, String value2) {
            addCriterion("f_name not between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberIsNull() {
            addCriterion("f_telephone_number is null");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberIsNotNull() {
            addCriterion("f_telephone_number is not null");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberEqualTo(String value) {
            addCriterion("f_telephone_number =", value, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberNotEqualTo(String value) {
            addCriterion("f_telephone_number <>", value, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberGreaterThan(String value) {
            addCriterion("f_telephone_number >", value, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_telephone_number >=", value, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberLessThan(String value) {
            addCriterion("f_telephone_number <", value, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberLessThanOrEqualTo(String value) {
            addCriterion("f_telephone_number <=", value, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberLike(String value) {
            addCriterion("f_telephone_number like", value, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberNotLike(String value) {
            addCriterion("f_telephone_number not like", value, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberIn(List<String> values) {
            addCriterion("f_telephone_number in", values, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberNotIn(List<String> values) {
            addCriterion("f_telephone_number not in", values, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberBetween(String value1, String value2) {
            addCriterion("f_telephone_number between", value1, value2, "fTelephoneNumber");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNumberNotBetween(String value1, String value2) {
            addCriterion("f_telephone_number not between", value1, value2, "fTelephoneNumber");
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

        public Criteria andFPermitIsNull() {
            addCriterion("f_permit is null");
            return (Criteria) this;
        }

        public Criteria andFPermitIsNotNull() {
            addCriterion("f_permit is not null");
            return (Criteria) this;
        }

        public Criteria andFPermitEqualTo(Byte value) {
            addCriterion("f_permit =", value, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFPermitNotEqualTo(Byte value) {
            addCriterion("f_permit <>", value, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFPermitGreaterThan(Byte value) {
            addCriterion("f_permit >", value, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFPermitGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_permit >=", value, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFPermitLessThan(Byte value) {
            addCriterion("f_permit <", value, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFPermitLessThanOrEqualTo(Byte value) {
            addCriterion("f_permit <=", value, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFPermitIn(List<Byte> values) {
            addCriterion("f_permit in", values, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFPermitNotIn(List<Byte> values) {
            addCriterion("f_permit not in", values, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFPermitBetween(Byte value1, Byte value2) {
            addCriterion("f_permit between", value1, value2, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFPermitNotBetween(Byte value1, Byte value2) {
            addCriterion("f_permit not between", value1, value2, "fPermit");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationIsNull() {
            addCriterion("f_whitelist_location is null");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationIsNotNull() {
            addCriterion("f_whitelist_location is not null");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationEqualTo(Integer value) {
            addCriterion("f_whitelist_location =", value, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationNotEqualTo(Integer value) {
            addCriterion("f_whitelist_location <>", value, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationGreaterThan(Integer value) {
            addCriterion("f_whitelist_location >", value, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_whitelist_location >=", value, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationLessThan(Integer value) {
            addCriterion("f_whitelist_location <", value, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationLessThanOrEqualTo(Integer value) {
            addCriterion("f_whitelist_location <=", value, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationIn(List<Integer> values) {
            addCriterion("f_whitelist_location in", values, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationNotIn(List<Integer> values) {
            addCriterion("f_whitelist_location not in", values, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationBetween(Integer value1, Integer value2) {
            addCriterion("f_whitelist_location between", value1, value2, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFWhitelistLocationNotBetween(Integer value1, Integer value2) {
            addCriterion("f_whitelist_location not between", value1, value2, "fWhitelistLocation");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeIsNull() {
            addCriterion("f_permission_area_code is null");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeIsNotNull() {
            addCriterion("f_permission_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeEqualTo(String value) {
            addCriterion("f_permission_area_code =", value, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeNotEqualTo(String value) {
            addCriterion("f_permission_area_code <>", value, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeGreaterThan(String value) {
            addCriterion("f_permission_area_code >", value, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_permission_area_code >=", value, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeLessThan(String value) {
            addCriterion("f_permission_area_code <", value, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("f_permission_area_code <=", value, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeLike(String value) {
            addCriterion("f_permission_area_code like", value, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeNotLike(String value) {
            addCriterion("f_permission_area_code not like", value, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeIn(List<String> values) {
            addCriterion("f_permission_area_code in", values, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeNotIn(List<String> values) {
            addCriterion("f_permission_area_code not in", values, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeBetween(String value1, String value2) {
            addCriterion("f_permission_area_code between", value1, value2, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFPermissionAreaCodeNotBetween(String value1, String value2) {
            addCriterion("f_permission_area_code not between", value1, value2, "fPermissionAreaCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeIsNull() {
            addCriterion("f_resource_code is null");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeIsNotNull() {
            addCriterion("f_resource_code is not null");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeEqualTo(String value) {
            addCriterion("f_resource_code =", value, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeNotEqualTo(String value) {
            addCriterion("f_resource_code <>", value, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeGreaterThan(String value) {
            addCriterion("f_resource_code >", value, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_resource_code >=", value, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeLessThan(String value) {
            addCriterion("f_resource_code <", value, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeLessThanOrEqualTo(String value) {
            addCriterion("f_resource_code <=", value, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeLike(String value) {
            addCriterion("f_resource_code like", value, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeNotLike(String value) {
            addCriterion("f_resource_code not like", value, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeIn(List<String> values) {
            addCriterion("f_resource_code in", values, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeNotIn(List<String> values) {
            addCriterion("f_resource_code not in", values, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeBetween(String value1, String value2) {
            addCriterion("f_resource_code between", value1, value2, "fResourceCode");
            return (Criteria) this;
        }

        public Criteria andFResourceCodeNotBetween(String value1, String value2) {
            addCriterion("f_resource_code not between", value1, value2, "fResourceCode");
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