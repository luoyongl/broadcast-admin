package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BBroadcastDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBroadcastDeviceExample() {
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

        public Criteria andFBroadcastIdIsNull() {
            addCriterion("f_broadcast_id is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdIsNotNull() {
            addCriterion("f_broadcast_id is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdEqualTo(Integer value) {
            addCriterion("f_broadcast_id =", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdNotEqualTo(Integer value) {
            addCriterion("f_broadcast_id <>", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdGreaterThan(Integer value) {
            addCriterion("f_broadcast_id >", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_broadcast_id >=", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdLessThan(Integer value) {
            addCriterion("f_broadcast_id <", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_broadcast_id <=", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdIn(List<Integer> values) {
            addCriterion("f_broadcast_id in", values, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdNotIn(List<Integer> values) {
            addCriterion("f_broadcast_id not in", values, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdBetween(Integer value1, Integer value2) {
            addCriterion("f_broadcast_id between", value1, value2, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_broadcast_id not between", value1, value2, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastIsNull() {
            addCriterion("f_is_timing_broadcast is null");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastIsNotNull() {
            addCriterion("f_is_timing_broadcast is not null");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastEqualTo(Boolean value) {
            addCriterion("f_is_timing_broadcast =", value, "fIsTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastNotEqualTo(Boolean value) {
            addCriterion("f_is_timing_broadcast <>", value, "fIsTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastGreaterThan(Boolean value) {
            addCriterion("f_is_timing_broadcast >", value, "fIsTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_is_timing_broadcast >=", value, "fIsTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastLessThan(Boolean value) {
            addCriterion("f_is_timing_broadcast <", value, "fIsTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastLessThanOrEqualTo(Boolean value) {
            addCriterion("f_is_timing_broadcast <=", value, "fIsTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastIn(List<Boolean> values) {
            addCriterion("f_is_timing_broadcast in", values, "fIsTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastNotIn(List<Boolean> values) {
            addCriterion("f_is_timing_broadcast not in", values, "fIsTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastBetween(Boolean value1, Boolean value2) {
            addCriterion("f_is_timing_broadcast between", value1, value2, "fIsTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFIsTimingBroadcastNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_is_timing_broadcast not between", value1, value2, "fIsTimingBroadcast");
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

        public Criteria andFBroadcastSendTimeIsNull() {
            addCriterion("f_broadcast_send_time is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeIsNotNull() {
            addCriterion("f_broadcast_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeEqualTo(Date value) {
            addCriterion("f_broadcast_send_time =", value, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeNotEqualTo(Date value) {
            addCriterion("f_broadcast_send_time <>", value, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeGreaterThan(Date value) {
            addCriterion("f_broadcast_send_time >", value, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_broadcast_send_time >=", value, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeLessThan(Date value) {
            addCriterion("f_broadcast_send_time <", value, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_broadcast_send_time <=", value, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeIn(List<Date> values) {
            addCriterion("f_broadcast_send_time in", values, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeNotIn(List<Date> values) {
            addCriterion("f_broadcast_send_time not in", values, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeBetween(Date value1, Date value2) {
            addCriterion("f_broadcast_send_time between", value1, value2, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_broadcast_send_time not between", value1, value2, "fBroadcastSendTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeIsNull() {
            addCriterion("f_device_answer_time is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeIsNotNull() {
            addCriterion("f_device_answer_time is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeEqualTo(Date value) {
            addCriterion("f_device_answer_time =", value, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeNotEqualTo(Date value) {
            addCriterion("f_device_answer_time <>", value, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeGreaterThan(Date value) {
            addCriterion("f_device_answer_time >", value, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_device_answer_time >=", value, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeLessThan(Date value) {
            addCriterion("f_device_answer_time <", value, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_device_answer_time <=", value, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeIn(List<Date> values) {
            addCriterion("f_device_answer_time in", values, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeNotIn(List<Date> values) {
            addCriterion("f_device_answer_time not in", values, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeBetween(Date value1, Date value2) {
            addCriterion("f_device_answer_time between", value1, value2, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFDeviceAnswerTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_device_answer_time not between", value1, value2, "fDeviceAnswerTime");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumIsNull() {
            addCriterion("f_answer_time_num is null");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumIsNotNull() {
            addCriterion("f_answer_time_num is not null");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumEqualTo(Integer value) {
            addCriterion("f_answer_time_num =", value, "fAnswerTimeNum");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumNotEqualTo(Integer value) {
            addCriterion("f_answer_time_num <>", value, "fAnswerTimeNum");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumGreaterThan(Integer value) {
            addCriterion("f_answer_time_num >", value, "fAnswerTimeNum");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_answer_time_num >=", value, "fAnswerTimeNum");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumLessThan(Integer value) {
            addCriterion("f_answer_time_num <", value, "fAnswerTimeNum");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumLessThanOrEqualTo(Integer value) {
            addCriterion("f_answer_time_num <=", value, "fAnswerTimeNum");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumIn(List<Integer> values) {
            addCriterion("f_answer_time_num in", values, "fAnswerTimeNum");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumNotIn(List<Integer> values) {
            addCriterion("f_answer_time_num not in", values, "fAnswerTimeNum");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumBetween(Integer value1, Integer value2) {
            addCriterion("f_answer_time_num between", value1, value2, "fAnswerTimeNum");
            return (Criteria) this;
        }

        public Criteria andFAnswerTimeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("f_answer_time_num not between", value1, value2, "fAnswerTimeNum");
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