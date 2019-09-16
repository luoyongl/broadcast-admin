package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOperationLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOperationLogExample() {
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

        public Criteria andFUseridIsNull() {
            addCriterion("f_userid is null");
            return (Criteria) this;
        }

        public Criteria andFUseridIsNotNull() {
            addCriterion("f_userid is not null");
            return (Criteria) this;
        }

        public Criteria andFUseridEqualTo(Integer value) {
            addCriterion("f_userid =", value, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUseridNotEqualTo(Integer value) {
            addCriterion("f_userid <>", value, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUseridGreaterThan(Integer value) {
            addCriterion("f_userid >", value, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_userid >=", value, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUseridLessThan(Integer value) {
            addCriterion("f_userid <", value, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUseridLessThanOrEqualTo(Integer value) {
            addCriterion("f_userid <=", value, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUseridIn(List<Integer> values) {
            addCriterion("f_userid in", values, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUseridNotIn(List<Integer> values) {
            addCriterion("f_userid not in", values, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUseridBetween(Integer value1, Integer value2) {
            addCriterion("f_userid between", value1, value2, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("f_userid not between", value1, value2, "fUserid");
            return (Criteria) this;
        }

        public Criteria andFUsernameIsNull() {
            addCriterion("f_username is null");
            return (Criteria) this;
        }

        public Criteria andFUsernameIsNotNull() {
            addCriterion("f_username is not null");
            return (Criteria) this;
        }

        public Criteria andFUsernameEqualTo(String value) {
            addCriterion("f_username =", value, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameNotEqualTo(String value) {
            addCriterion("f_username <>", value, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameGreaterThan(String value) {
            addCriterion("f_username >", value, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("f_username >=", value, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameLessThan(String value) {
            addCriterion("f_username <", value, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameLessThanOrEqualTo(String value) {
            addCriterion("f_username <=", value, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameLike(String value) {
            addCriterion("f_username like", value, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameNotLike(String value) {
            addCriterion("f_username not like", value, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameIn(List<String> values) {
            addCriterion("f_username in", values, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameNotIn(List<String> values) {
            addCriterion("f_username not in", values, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameBetween(String value1, String value2) {
            addCriterion("f_username between", value1, value2, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFUsernameNotBetween(String value1, String value2) {
            addCriterion("f_username not between", value1, value2, "fUsername");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeIsNull() {
            addCriterion("f_operation_time is null");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeIsNotNull() {
            addCriterion("f_operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeEqualTo(Date value) {
            addCriterion("f_operation_time =", value, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeNotEqualTo(Date value) {
            addCriterion("f_operation_time <>", value, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeGreaterThan(Date value) {
            addCriterion("f_operation_time >", value, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_operation_time >=", value, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeLessThan(Date value) {
            addCriterion("f_operation_time <", value, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_operation_time <=", value, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeIn(List<Date> values) {
            addCriterion("f_operation_time in", values, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeNotIn(List<Date> values) {
            addCriterion("f_operation_time not in", values, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeBetween(Date value1, Date value2) {
            addCriterion("f_operation_time between", value1, value2, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_operation_time not between", value1, value2, "fOperationTime");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeIsNull() {
            addCriterion("f_operation_type is null");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeIsNotNull() {
            addCriterion("f_operation_type is not null");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeEqualTo(Byte value) {
            addCriterion("f_operation_type =", value, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeNotEqualTo(Byte value) {
            addCriterion("f_operation_type <>", value, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeGreaterThan(Byte value) {
            addCriterion("f_operation_type >", value, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_operation_type >=", value, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeLessThan(Byte value) {
            addCriterion("f_operation_type <", value, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_operation_type <=", value, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeIn(List<Byte> values) {
            addCriterion("f_operation_type in", values, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeNotIn(List<Byte> values) {
            addCriterion("f_operation_type not in", values, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_operation_type between", value1, value2, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_operation_type not between", value1, value2, "fOperationType");
            return (Criteria) this;
        }

        public Criteria andFOperationContentIsNull() {
            addCriterion("f_operation_content is null");
            return (Criteria) this;
        }

        public Criteria andFOperationContentIsNotNull() {
            addCriterion("f_operation_content is not null");
            return (Criteria) this;
        }

        public Criteria andFOperationContentEqualTo(String value) {
            addCriterion("f_operation_content =", value, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentNotEqualTo(String value) {
            addCriterion("f_operation_content <>", value, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentGreaterThan(String value) {
            addCriterion("f_operation_content >", value, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentGreaterThanOrEqualTo(String value) {
            addCriterion("f_operation_content >=", value, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentLessThan(String value) {
            addCriterion("f_operation_content <", value, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentLessThanOrEqualTo(String value) {
            addCriterion("f_operation_content <=", value, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentLike(String value) {
            addCriterion("f_operation_content like", value, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentNotLike(String value) {
            addCriterion("f_operation_content not like", value, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentIn(List<String> values) {
            addCriterion("f_operation_content in", values, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentNotIn(List<String> values) {
            addCriterion("f_operation_content not in", values, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentBetween(String value1, String value2) {
            addCriterion("f_operation_content between", value1, value2, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationContentNotBetween(String value1, String value2) {
            addCriterion("f_operation_content not between", value1, value2, "fOperationContent");
            return (Criteria) this;
        }

        public Criteria andFOperationResultIsNull() {
            addCriterion("f_operation_result is null");
            return (Criteria) this;
        }

        public Criteria andFOperationResultIsNotNull() {
            addCriterion("f_operation_result is not null");
            return (Criteria) this;
        }

        public Criteria andFOperationResultEqualTo(String value) {
            addCriterion("f_operation_result =", value, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultNotEqualTo(String value) {
            addCriterion("f_operation_result <>", value, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultGreaterThan(String value) {
            addCriterion("f_operation_result >", value, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultGreaterThanOrEqualTo(String value) {
            addCriterion("f_operation_result >=", value, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultLessThan(String value) {
            addCriterion("f_operation_result <", value, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultLessThanOrEqualTo(String value) {
            addCriterion("f_operation_result <=", value, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultLike(String value) {
            addCriterion("f_operation_result like", value, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultNotLike(String value) {
            addCriterion("f_operation_result not like", value, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultIn(List<String> values) {
            addCriterion("f_operation_result in", values, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultNotIn(List<String> values) {
            addCriterion("f_operation_result not in", values, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultBetween(String value1, String value2) {
            addCriterion("f_operation_result between", value1, value2, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFOperationResultNotBetween(String value1, String value2) {
            addCriterion("f_operation_result not between", value1, value2, "fOperationResult");
            return (Criteria) this;
        }

        public Criteria andFIpIsNull() {
            addCriterion("f_ip is null");
            return (Criteria) this;
        }

        public Criteria andFIpIsNotNull() {
            addCriterion("f_ip is not null");
            return (Criteria) this;
        }

        public Criteria andFIpEqualTo(String value) {
            addCriterion("f_ip =", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpNotEqualTo(String value) {
            addCriterion("f_ip <>", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpGreaterThan(String value) {
            addCriterion("f_ip >", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpGreaterThanOrEqualTo(String value) {
            addCriterion("f_ip >=", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpLessThan(String value) {
            addCriterion("f_ip <", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpLessThanOrEqualTo(String value) {
            addCriterion("f_ip <=", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpLike(String value) {
            addCriterion("f_ip like", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpNotLike(String value) {
            addCriterion("f_ip not like", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpIn(List<String> values) {
            addCriterion("f_ip in", values, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpNotIn(List<String> values) {
            addCriterion("f_ip not in", values, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpBetween(String value1, String value2) {
            addCriterion("f_ip between", value1, value2, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpNotBetween(String value1, String value2) {
            addCriterion("f_ip not between", value1, value2, "fIp");
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