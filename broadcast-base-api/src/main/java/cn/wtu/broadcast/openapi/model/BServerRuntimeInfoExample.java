package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BServerRuntimeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BServerRuntimeInfoExample() {
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

        public Criteria andFServerTypeIsNull() {
            addCriterion("f_server_type is null");
            return (Criteria) this;
        }

        public Criteria andFServerTypeIsNotNull() {
            addCriterion("f_server_type is not null");
            return (Criteria) this;
        }

        public Criteria andFServerTypeEqualTo(Integer value) {
            addCriterion("f_server_type =", value, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerTypeNotEqualTo(Integer value) {
            addCriterion("f_server_type <>", value, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerTypeGreaterThan(Integer value) {
            addCriterion("f_server_type >", value, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_server_type >=", value, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerTypeLessThan(Integer value) {
            addCriterion("f_server_type <", value, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("f_server_type <=", value, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerTypeIn(List<Integer> values) {
            addCriterion("f_server_type in", values, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerTypeNotIn(List<Integer> values) {
            addCriterion("f_server_type not in", values, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerTypeBetween(Integer value1, Integer value2) {
            addCriterion("f_server_type between", value1, value2, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_server_type not between", value1, value2, "fServerType");
            return (Criteria) this;
        }

        public Criteria andFServerStateIsNull() {
            addCriterion("f_server_state is null");
            return (Criteria) this;
        }

        public Criteria andFServerStateIsNotNull() {
            addCriterion("f_server_state is not null");
            return (Criteria) this;
        }

        public Criteria andFServerStateEqualTo(Integer value) {
            addCriterion("f_server_state =", value, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFServerStateNotEqualTo(Integer value) {
            addCriterion("f_server_state <>", value, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFServerStateGreaterThan(Integer value) {
            addCriterion("f_server_state >", value, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFServerStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_server_state >=", value, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFServerStateLessThan(Integer value) {
            addCriterion("f_server_state <", value, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFServerStateLessThanOrEqualTo(Integer value) {
            addCriterion("f_server_state <=", value, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFServerStateIn(List<Integer> values) {
            addCriterion("f_server_state in", values, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFServerStateNotIn(List<Integer> values) {
            addCriterion("f_server_state not in", values, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFServerStateBetween(Integer value1, Integer value2) {
            addCriterion("f_server_state between", value1, value2, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFServerStateNotBetween(Integer value1, Integer value2) {
            addCriterion("f_server_state not between", value1, value2, "fServerState");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeIsNull() {
            addCriterion("f_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeIsNotNull() {
            addCriterion("f_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeEqualTo(Date value) {
            addCriterion("f_creat_time =", value, "fCreatTime");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeNotEqualTo(Date value) {
            addCriterion("f_creat_time <>", value, "fCreatTime");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeGreaterThan(Date value) {
            addCriterion("f_creat_time >", value, "fCreatTime");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_creat_time >=", value, "fCreatTime");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeLessThan(Date value) {
            addCriterion("f_creat_time <", value, "fCreatTime");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_creat_time <=", value, "fCreatTime");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeIn(List<Date> values) {
            addCriterion("f_creat_time in", values, "fCreatTime");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeNotIn(List<Date> values) {
            addCriterion("f_creat_time not in", values, "fCreatTime");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeBetween(Date value1, Date value2) {
            addCriterion("f_creat_time between", value1, value2, "fCreatTime");
            return (Criteria) this;
        }

        public Criteria andFCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_creat_time not between", value1, value2, "fCreatTime");
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