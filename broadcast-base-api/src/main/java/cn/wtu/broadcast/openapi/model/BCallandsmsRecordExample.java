package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BCallandsmsRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BCallandsmsRecordExample() {
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

        public Criteria andFAreaIsNull() {
            addCriterion("f_area is null");
            return (Criteria) this;
        }

        public Criteria andFAreaIsNotNull() {
            addCriterion("f_area is not null");
            return (Criteria) this;
        }

        public Criteria andFAreaEqualTo(Integer value) {
            addCriterion("f_area =", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaNotEqualTo(Integer value) {
            addCriterion("f_area <>", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaGreaterThan(Integer value) {
            addCriterion("f_area >", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_area >=", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaLessThan(Integer value) {
            addCriterion("f_area <", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaLessThanOrEqualTo(Integer value) {
            addCriterion("f_area <=", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaIn(List<Integer> values) {
            addCriterion("f_area in", values, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaNotIn(List<Integer> values) {
            addCriterion("f_area not in", values, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaBetween(Integer value1, Integer value2) {
            addCriterion("f_area between", value1, value2, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("f_area not between", value1, value2, "fArea");
            return (Criteria) this;
        }

        public Criteria andFCallTimeIsNull() {
            addCriterion("f_call_time is null");
            return (Criteria) this;
        }

        public Criteria andFCallTimeIsNotNull() {
            addCriterion("f_call_time is not null");
            return (Criteria) this;
        }

        public Criteria andFCallTimeEqualTo(Integer value) {
            addCriterion("f_call_time =", value, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFCallTimeNotEqualTo(Integer value) {
            addCriterion("f_call_time <>", value, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFCallTimeGreaterThan(Integer value) {
            addCriterion("f_call_time >", value, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFCallTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_call_time >=", value, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFCallTimeLessThan(Integer value) {
            addCriterion("f_call_time <", value, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFCallTimeLessThanOrEqualTo(Integer value) {
            addCriterion("f_call_time <=", value, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFCallTimeIn(List<Integer> values) {
            addCriterion("f_call_time in", values, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFCallTimeNotIn(List<Integer> values) {
            addCriterion("f_call_time not in", values, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFCallTimeBetween(Integer value1, Integer value2) {
            addCriterion("f_call_time between", value1, value2, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFCallTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_call_time not between", value1, value2, "fCallTime");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeIsNull() {
            addCriterion("f_telephone_type is null");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeIsNotNull() {
            addCriterion("f_telephone_type is not null");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeEqualTo(Byte value) {
            addCriterion("f_telephone_type =", value, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeNotEqualTo(Byte value) {
            addCriterion("f_telephone_type <>", value, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeGreaterThan(Byte value) {
            addCriterion("f_telephone_type >", value, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_telephone_type >=", value, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeLessThan(Byte value) {
            addCriterion("f_telephone_type <", value, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_telephone_type <=", value, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeIn(List<Byte> values) {
            addCriterion("f_telephone_type in", values, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeNotIn(List<Byte> values) {
            addCriterion("f_telephone_type not in", values, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_telephone_type between", value1, value2, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_telephone_type not between", value1, value2, "fTelephoneType");
            return (Criteria) this;
        }

        public Criteria andFSmsContentIsNull() {
            addCriterion("f_sms_content is null");
            return (Criteria) this;
        }

        public Criteria andFSmsContentIsNotNull() {
            addCriterion("f_sms_content is not null");
            return (Criteria) this;
        }

        public Criteria andFSmsContentEqualTo(String value) {
            addCriterion("f_sms_content =", value, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentNotEqualTo(String value) {
            addCriterion("f_sms_content <>", value, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentGreaterThan(String value) {
            addCriterion("f_sms_content >", value, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentGreaterThanOrEqualTo(String value) {
            addCriterion("f_sms_content >=", value, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentLessThan(String value) {
            addCriterion("f_sms_content <", value, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentLessThanOrEqualTo(String value) {
            addCriterion("f_sms_content <=", value, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentLike(String value) {
            addCriterion("f_sms_content like", value, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentNotLike(String value) {
            addCriterion("f_sms_content not like", value, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentIn(List<String> values) {
            addCriterion("f_sms_content in", values, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentNotIn(List<String> values) {
            addCriterion("f_sms_content not in", values, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentBetween(String value1, String value2) {
            addCriterion("f_sms_content between", value1, value2, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFSmsContentNotBetween(String value1, String value2) {
            addCriterion("f_sms_content not between", value1, value2, "fSmsContent");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlIsNull() {
            addCriterion("f_audio_url is null");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlIsNotNull() {
            addCriterion("f_audio_url is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlEqualTo(String value) {
            addCriterion("f_audio_url =", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlNotEqualTo(String value) {
            addCriterion("f_audio_url <>", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlGreaterThan(String value) {
            addCriterion("f_audio_url >", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlGreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_url >=", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlLessThan(String value) {
            addCriterion("f_audio_url <", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlLessThanOrEqualTo(String value) {
            addCriterion("f_audio_url <=", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlLike(String value) {
            addCriterion("f_audio_url like", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlNotLike(String value) {
            addCriterion("f_audio_url not like", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlIn(List<String> values) {
            addCriterion("f_audio_url in", values, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlNotIn(List<String> values) {
            addCriterion("f_audio_url not in", values, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlBetween(String value1, String value2) {
            addCriterion("f_audio_url between", value1, value2, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlNotBetween(String value1, String value2) {
            addCriterion("f_audio_url not between", value1, value2, "fAudioUrl");
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