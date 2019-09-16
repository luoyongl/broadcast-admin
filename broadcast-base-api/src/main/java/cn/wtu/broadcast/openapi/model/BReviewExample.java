package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BReviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BReviewExample() {
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

        public Criteria andFBigClassificationIsNull() {
            addCriterion("f_big_classification is null");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationIsNotNull() {
            addCriterion("f_big_classification is not null");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationEqualTo(Byte value) {
            addCriterion("f_big_classification =", value, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationNotEqualTo(Byte value) {
            addCriterion("f_big_classification <>", value, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationGreaterThan(Byte value) {
            addCriterion("f_big_classification >", value, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_big_classification >=", value, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationLessThan(Byte value) {
            addCriterion("f_big_classification <", value, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationLessThanOrEqualTo(Byte value) {
            addCriterion("f_big_classification <=", value, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationIn(List<Byte> values) {
            addCriterion("f_big_classification in", values, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationNotIn(List<Byte> values) {
            addCriterion("f_big_classification not in", values, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationBetween(Byte value1, Byte value2) {
            addCriterion("f_big_classification between", value1, value2, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFBigClassificationNotBetween(Byte value1, Byte value2) {
            addCriterion("f_big_classification not between", value1, value2, "fBigClassification");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeIsNull() {
            addCriterion("f_review_type is null");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeIsNotNull() {
            addCriterion("f_review_type is not null");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeEqualTo(Byte value) {
            addCriterion("f_review_type =", value, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeNotEqualTo(Byte value) {
            addCriterion("f_review_type <>", value, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeGreaterThan(Byte value) {
            addCriterion("f_review_type >", value, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_review_type >=", value, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeLessThan(Byte value) {
            addCriterion("f_review_type <", value, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_review_type <=", value, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeIn(List<Byte> values) {
            addCriterion("f_review_type in", values, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeNotIn(List<Byte> values) {
            addCriterion("f_review_type not in", values, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_review_type between", value1, value2, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_review_type not between", value1, value2, "fReviewType");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdIsNull() {
            addCriterion("f_review_object_id is null");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdIsNotNull() {
            addCriterion("f_review_object_id is not null");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdEqualTo(Integer value) {
            addCriterion("f_review_object_id =", value, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdNotEqualTo(Integer value) {
            addCriterion("f_review_object_id <>", value, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdGreaterThan(Integer value) {
            addCriterion("f_review_object_id >", value, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_review_object_id >=", value, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdLessThan(Integer value) {
            addCriterion("f_review_object_id <", value, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_review_object_id <=", value, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdIn(List<Integer> values) {
            addCriterion("f_review_object_id in", values, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdNotIn(List<Integer> values) {
            addCriterion("f_review_object_id not in", values, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdBetween(Integer value1, Integer value2) {
            addCriterion("f_review_object_id between", value1, value2, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewObjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_review_object_id not between", value1, value2, "fReviewObjectId");
            return (Criteria) this;
        }

        public Criteria andFReviewResultIsNull() {
            addCriterion("f_review_result is null");
            return (Criteria) this;
        }

        public Criteria andFReviewResultIsNotNull() {
            addCriterion("f_review_result is not null");
            return (Criteria) this;
        }

        public Criteria andFReviewResultEqualTo(Byte value) {
            addCriterion("f_review_result =", value, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewResultNotEqualTo(Byte value) {
            addCriterion("f_review_result <>", value, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewResultGreaterThan(Byte value) {
            addCriterion("f_review_result >", value, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewResultGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_review_result >=", value, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewResultLessThan(Byte value) {
            addCriterion("f_review_result <", value, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewResultLessThanOrEqualTo(Byte value) {
            addCriterion("f_review_result <=", value, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewResultIn(List<Byte> values) {
            addCriterion("f_review_result in", values, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewResultNotIn(List<Byte> values) {
            addCriterion("f_review_result not in", values, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewResultBetween(Byte value1, Byte value2) {
            addCriterion("f_review_result between", value1, value2, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewResultNotBetween(Byte value1, Byte value2) {
            addCriterion("f_review_result not between", value1, value2, "fReviewResult");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeIsNull() {
            addCriterion("f_review_time is null");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeIsNotNull() {
            addCriterion("f_review_time is not null");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeEqualTo(Date value) {
            addCriterion("f_review_time =", value, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeNotEqualTo(Date value) {
            addCriterion("f_review_time <>", value, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeGreaterThan(Date value) {
            addCriterion("f_review_time >", value, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_review_time >=", value, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeLessThan(Date value) {
            addCriterion("f_review_time <", value, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_review_time <=", value, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeIn(List<Date> values) {
            addCriterion("f_review_time in", values, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeNotIn(List<Date> values) {
            addCriterion("f_review_time not in", values, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeBetween(Date value1, Date value2) {
            addCriterion("f_review_time between", value1, value2, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_review_time not between", value1, value2, "fReviewTime");
            return (Criteria) this;
        }

        public Criteria andFReviewerIsNull() {
            addCriterion("f_reviewer is null");
            return (Criteria) this;
        }

        public Criteria andFReviewerIsNotNull() {
            addCriterion("f_reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andFReviewerEqualTo(Integer value) {
            addCriterion("f_reviewer =", value, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFReviewerNotEqualTo(Integer value) {
            addCriterion("f_reviewer <>", value, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFReviewerGreaterThan(Integer value) {
            addCriterion("f_reviewer >", value, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFReviewerGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_reviewer >=", value, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFReviewerLessThan(Integer value) {
            addCriterion("f_reviewer <", value, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFReviewerLessThanOrEqualTo(Integer value) {
            addCriterion("f_reviewer <=", value, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFReviewerIn(List<Integer> values) {
            addCriterion("f_reviewer in", values, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFReviewerNotIn(List<Integer> values) {
            addCriterion("f_reviewer not in", values, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFReviewerBetween(Integer value1, Integer value2) {
            addCriterion("f_reviewer between", value1, value2, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFReviewerNotBetween(Integer value1, Integer value2) {
            addCriterion("f_reviewer not between", value1, value2, "fReviewer");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNull() {
            addCriterion("f_remark is null");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNotNull() {
            addCriterion("f_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFRemarkEqualTo(String value) {
            addCriterion("f_remark =", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotEqualTo(String value) {
            addCriterion("f_remark <>", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThan(String value) {
            addCriterion("f_remark >", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("f_remark >=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThan(String value) {
            addCriterion("f_remark <", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThanOrEqualTo(String value) {
            addCriterion("f_remark <=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLike(String value) {
            addCriterion("f_remark like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotLike(String value) {
            addCriterion("f_remark not like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkIn(List<String> values) {
            addCriterion("f_remark in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotIn(List<String> values) {
            addCriterion("f_remark not in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkBetween(String value1, String value2) {
            addCriterion("f_remark between", value1, value2, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotBetween(String value1, String value2) {
            addCriterion("f_remark not between", value1, value2, "fRemark");
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