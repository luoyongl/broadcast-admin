package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BDeviceInputChannelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDeviceInputChannelExample() {
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

        public Criteria andFInputChannelIdIsNull() {
            addCriterion("f_input_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdIsNotNull() {
            addCriterion("f_input_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdEqualTo(Integer value) {
            addCriterion("f_input_channel_id =", value, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdNotEqualTo(Integer value) {
            addCriterion("f_input_channel_id <>", value, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdGreaterThan(Integer value) {
            addCriterion("f_input_channel_id >", value, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_input_channel_id >=", value, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdLessThan(Integer value) {
            addCriterion("f_input_channel_id <", value, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_input_channel_id <=", value, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdIn(List<Integer> values) {
            addCriterion("f_input_channel_id in", values, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdNotIn(List<Integer> values) {
            addCriterion("f_input_channel_id not in", values, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("f_input_channel_id between", value1, value2, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFInputChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_input_channel_id not between", value1, value2, "fInputChannelId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdIsNull() {
            addCriterion("f_parameter_set_id is null");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdIsNotNull() {
            addCriterion("f_parameter_set_id is not null");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdEqualTo(Integer value) {
            addCriterion("f_parameter_set_id =", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdNotEqualTo(Integer value) {
            addCriterion("f_parameter_set_id <>", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdGreaterThan(Integer value) {
            addCriterion("f_parameter_set_id >", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_parameter_set_id >=", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdLessThan(Integer value) {
            addCriterion("f_parameter_set_id <", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_parameter_set_id <=", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdIn(List<Integer> values) {
            addCriterion("f_parameter_set_id in", values, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdNotIn(List<Integer> values) {
            addCriterion("f_parameter_set_id not in", values, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdBetween(Integer value1, Integer value2) {
            addCriterion("f_parameter_set_id between", value1, value2, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_parameter_set_id not between", value1, value2, "fParameterSetId");
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

        public Criteria andFDeviceChannelNameIsNull() {
            addCriterion("f_device_channel_name is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameIsNotNull() {
            addCriterion("f_device_channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameEqualTo(String value) {
            addCriterion("f_device_channel_name =", value, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameNotEqualTo(String value) {
            addCriterion("f_device_channel_name <>", value, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameGreaterThan(String value) {
            addCriterion("f_device_channel_name >", value, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_channel_name >=", value, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameLessThan(String value) {
            addCriterion("f_device_channel_name <", value, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameLessThanOrEqualTo(String value) {
            addCriterion("f_device_channel_name <=", value, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameLike(String value) {
            addCriterion("f_device_channel_name like", value, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameNotLike(String value) {
            addCriterion("f_device_channel_name not like", value, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameIn(List<String> values) {
            addCriterion("f_device_channel_name in", values, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameNotIn(List<String> values) {
            addCriterion("f_device_channel_name not in", values, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameBetween(String value1, String value2) {
            addCriterion("f_device_channel_name between", value1, value2, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNameNotBetween(String value1, String value2) {
            addCriterion("f_device_channel_name not between", value1, value2, "fDeviceChannelName");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberIsNull() {
            addCriterion("f_input_channel_number is null");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberIsNotNull() {
            addCriterion("f_input_channel_number is not null");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberEqualTo(Integer value) {
            addCriterion("f_input_channel_number =", value, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberNotEqualTo(Integer value) {
            addCriterion("f_input_channel_number <>", value, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberGreaterThan(Integer value) {
            addCriterion("f_input_channel_number >", value, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_input_channel_number >=", value, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberLessThan(Integer value) {
            addCriterion("f_input_channel_number <", value, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberLessThanOrEqualTo(Integer value) {
            addCriterion("f_input_channel_number <=", value, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberIn(List<Integer> values) {
            addCriterion("f_input_channel_number in", values, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberNotIn(List<Integer> values) {
            addCriterion("f_input_channel_number not in", values, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberBetween(Integer value1, Integer value2) {
            addCriterion("f_input_channel_number between", value1, value2, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("f_input_channel_number not between", value1, value2, "fInputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupIsNull() {
            addCriterion("f_input_channel_group is null");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupIsNotNull() {
            addCriterion("f_input_channel_group is not null");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupEqualTo(Integer value) {
            addCriterion("f_input_channel_group =", value, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupNotEqualTo(Integer value) {
            addCriterion("f_input_channel_group <>", value, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupGreaterThan(Integer value) {
            addCriterion("f_input_channel_group >", value, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_input_channel_group >=", value, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupLessThan(Integer value) {
            addCriterion("f_input_channel_group <", value, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupLessThanOrEqualTo(Integer value) {
            addCriterion("f_input_channel_group <=", value, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupIn(List<Integer> values) {
            addCriterion("f_input_channel_group in", values, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupNotIn(List<Integer> values) {
            addCriterion("f_input_channel_group not in", values, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupBetween(Integer value1, Integer value2) {
            addCriterion("f_input_channel_group between", value1, value2, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFInputChannelGroupNotBetween(Integer value1, Integer value2) {
            addCriterion("f_input_channel_group not between", value1, value2, "fInputChannelGroup");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateIsNull() {
            addCriterion("f_device_channel_state is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateIsNotNull() {
            addCriterion("f_device_channel_state is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateEqualTo(String value) {
            addCriterion("f_device_channel_state =", value, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateNotEqualTo(String value) {
            addCriterion("f_device_channel_state <>", value, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateGreaterThan(String value) {
            addCriterion("f_device_channel_state >", value, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_channel_state >=", value, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateLessThan(String value) {
            addCriterion("f_device_channel_state <", value, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateLessThanOrEqualTo(String value) {
            addCriterion("f_device_channel_state <=", value, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateLike(String value) {
            addCriterion("f_device_channel_state like", value, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateNotLike(String value) {
            addCriterion("f_device_channel_state not like", value, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateIn(List<String> values) {
            addCriterion("f_device_channel_state in", values, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateNotIn(List<String> values) {
            addCriterion("f_device_channel_state not in", values, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateBetween(String value1, String value2) {
            addCriterion("f_device_channel_state between", value1, value2, "fDeviceChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelStateNotBetween(String value1, String value2) {
            addCriterion("f_device_channel_state not between", value1, value2, "fDeviceChannelState");
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