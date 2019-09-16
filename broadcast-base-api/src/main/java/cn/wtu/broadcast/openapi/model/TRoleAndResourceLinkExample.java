package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.List;

public class TRoleAndResourceLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRoleAndResourceLinkExample() {
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

        public Criteria andFRoleResourcesIdIsNull() {
            addCriterion("f_role_resources_id is null");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdIsNotNull() {
            addCriterion("f_role_resources_id is not null");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdEqualTo(Integer value) {
            addCriterion("f_role_resources_id =", value, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdNotEqualTo(Integer value) {
            addCriterion("f_role_resources_id <>", value, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdGreaterThan(Integer value) {
            addCriterion("f_role_resources_id >", value, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_role_resources_id >=", value, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdLessThan(Integer value) {
            addCriterion("f_role_resources_id <", value, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_role_resources_id <=", value, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdIn(List<Integer> values) {
            addCriterion("f_role_resources_id in", values, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdNotIn(List<Integer> values) {
            addCriterion("f_role_resources_id not in", values, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdBetween(Integer value1, Integer value2) {
            addCriterion("f_role_resources_id between", value1, value2, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleResourcesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_role_resources_id not between", value1, value2, "fRoleResourcesId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdIsNull() {
            addCriterion("f_role_id is null");
            return (Criteria) this;
        }

        public Criteria andFRoleIdIsNotNull() {
            addCriterion("f_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andFRoleIdEqualTo(Integer value) {
            addCriterion("f_role_id =", value, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdNotEqualTo(Integer value) {
            addCriterion("f_role_id <>", value, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdGreaterThan(Integer value) {
            addCriterion("f_role_id >", value, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_role_id >=", value, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdLessThan(Integer value) {
            addCriterion("f_role_id <", value, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_role_id <=", value, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdIn(List<Integer> values) {
            addCriterion("f_role_id in", values, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdNotIn(List<Integer> values) {
            addCriterion("f_role_id not in", values, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("f_role_id between", value1, value2, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_role_id not between", value1, value2, "fRoleId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdIsNull() {
            addCriterion("f_resources_id is null");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdIsNotNull() {
            addCriterion("f_resources_id is not null");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdEqualTo(Integer value) {
            addCriterion("f_resources_id =", value, "fResourcesId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdNotEqualTo(Integer value) {
            addCriterion("f_resources_id <>", value, "fResourcesId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdGreaterThan(Integer value) {
            addCriterion("f_resources_id >", value, "fResourcesId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_resources_id >=", value, "fResourcesId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdLessThan(Integer value) {
            addCriterion("f_resources_id <", value, "fResourcesId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_resources_id <=", value, "fResourcesId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdIn(List<Integer> values) {
            addCriterion("f_resources_id in", values, "fResourcesId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdNotIn(List<Integer> values) {
            addCriterion("f_resources_id not in", values, "fResourcesId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdBetween(Integer value1, Integer value2) {
            addCriterion("f_resources_id between", value1, value2, "fResourcesId");
            return (Criteria) this;
        }

        public Criteria andFResourcesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_resources_id not between", value1, value2, "fResourcesId");
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