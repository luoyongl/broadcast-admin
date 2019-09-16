package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BInstructionReplyStorageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BInstructionReplyStorageExample() {
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

        public Criteria andFHeadmarkIsNull() {
            addCriterion("f_headMark is null");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkIsNotNull() {
            addCriterion("f_headMark is not null");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkEqualTo(String value) {
            addCriterion("f_headMark =", value, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkNotEqualTo(String value) {
            addCriterion("f_headMark <>", value, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkGreaterThan(String value) {
            addCriterion("f_headMark >", value, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkGreaterThanOrEqualTo(String value) {
            addCriterion("f_headMark >=", value, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkLessThan(String value) {
            addCriterion("f_headMark <", value, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkLessThanOrEqualTo(String value) {
            addCriterion("f_headMark <=", value, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkLike(String value) {
            addCriterion("f_headMark like", value, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkNotLike(String value) {
            addCriterion("f_headMark not like", value, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkIn(List<String> values) {
            addCriterion("f_headMark in", values, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkNotIn(List<String> values) {
            addCriterion("f_headMark not in", values, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkBetween(String value1, String value2) {
            addCriterion("f_headMark between", value1, value2, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFHeadmarkNotBetween(String value1, String value2) {
            addCriterion("f_headMark not between", value1, value2, "fHeadmark");
            return (Criteria) this;
        }

        public Criteria andFVersionIsNull() {
            addCriterion("f_version is null");
            return (Criteria) this;
        }

        public Criteria andFVersionIsNotNull() {
            addCriterion("f_version is not null");
            return (Criteria) this;
        }

        public Criteria andFVersionEqualTo(String value) {
            addCriterion("f_version =", value, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionNotEqualTo(String value) {
            addCriterion("f_version <>", value, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionGreaterThan(String value) {
            addCriterion("f_version >", value, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionGreaterThanOrEqualTo(String value) {
            addCriterion("f_version >=", value, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionLessThan(String value) {
            addCriterion("f_version <", value, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionLessThanOrEqualTo(String value) {
            addCriterion("f_version <=", value, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionLike(String value) {
            addCriterion("f_version like", value, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionNotLike(String value) {
            addCriterion("f_version not like", value, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionIn(List<String> values) {
            addCriterion("f_version in", values, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionNotIn(List<String> values) {
            addCriterion("f_version not in", values, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionBetween(String value1, String value2) {
            addCriterion("f_version between", value1, value2, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFVersionNotBetween(String value1, String value2) {
            addCriterion("f_version not between", value1, value2, "fVersion");
            return (Criteria) this;
        }

        public Criteria andFTagIsNull() {
            addCriterion("f_tag is null");
            return (Criteria) this;
        }

        public Criteria andFTagIsNotNull() {
            addCriterion("f_tag is not null");
            return (Criteria) this;
        }

        public Criteria andFTagEqualTo(String value) {
            addCriterion("f_tag =", value, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagNotEqualTo(String value) {
            addCriterion("f_tag <>", value, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagGreaterThan(String value) {
            addCriterion("f_tag >", value, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagGreaterThanOrEqualTo(String value) {
            addCriterion("f_tag >=", value, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagLessThan(String value) {
            addCriterion("f_tag <", value, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagLessThanOrEqualTo(String value) {
            addCriterion("f_tag <=", value, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagLike(String value) {
            addCriterion("f_tag like", value, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagNotLike(String value) {
            addCriterion("f_tag not like", value, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagIn(List<String> values) {
            addCriterion("f_tag in", values, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagNotIn(List<String> values) {
            addCriterion("f_tag not in", values, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagBetween(String value1, String value2) {
            addCriterion("f_tag between", value1, value2, "fTag");
            return (Criteria) this;
        }

        public Criteria andFTagNotBetween(String value1, String value2) {
            addCriterion("f_tag not between", value1, value2, "fTag");
            return (Criteria) this;
        }

        public Criteria andFPacktypeIsNull() {
            addCriterion("f_packType is null");
            return (Criteria) this;
        }

        public Criteria andFPacktypeIsNotNull() {
            addCriterion("f_packType is not null");
            return (Criteria) this;
        }

        public Criteria andFPacktypeEqualTo(String value) {
            addCriterion("f_packType =", value, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeNotEqualTo(String value) {
            addCriterion("f_packType <>", value, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeGreaterThan(String value) {
            addCriterion("f_packType >", value, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_packType >=", value, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeLessThan(String value) {
            addCriterion("f_packType <", value, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeLessThanOrEqualTo(String value) {
            addCriterion("f_packType <=", value, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeLike(String value) {
            addCriterion("f_packType like", value, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeNotLike(String value) {
            addCriterion("f_packType not like", value, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeIn(List<String> values) {
            addCriterion("f_packType in", values, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeNotIn(List<String> values) {
            addCriterion("f_packType not in", values, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeBetween(String value1, String value2) {
            addCriterion("f_packType between", value1, value2, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFPacktypeNotBetween(String value1, String value2) {
            addCriterion("f_packType not between", value1, value2, "fPacktype");
            return (Criteria) this;
        }

        public Criteria andFSourceIsNull() {
            addCriterion("f_source is null");
            return (Criteria) this;
        }

        public Criteria andFSourceIsNotNull() {
            addCriterion("f_source is not null");
            return (Criteria) this;
        }

        public Criteria andFSourceEqualTo(String value) {
            addCriterion("f_source =", value, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceNotEqualTo(String value) {
            addCriterion("f_source <>", value, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceGreaterThan(String value) {
            addCriterion("f_source >", value, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceGreaterThanOrEqualTo(String value) {
            addCriterion("f_source >=", value, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceLessThan(String value) {
            addCriterion("f_source <", value, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceLessThanOrEqualTo(String value) {
            addCriterion("f_source <=", value, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceLike(String value) {
            addCriterion("f_source like", value, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceNotLike(String value) {
            addCriterion("f_source not like", value, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceIn(List<String> values) {
            addCriterion("f_source in", values, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceNotIn(List<String> values) {
            addCriterion("f_source not in", values, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceBetween(String value1, String value2) {
            addCriterion("f_source between", value1, value2, "fSource");
            return (Criteria) this;
        }

        public Criteria andFSourceNotBetween(String value1, String value2) {
            addCriterion("f_source not between", value1, value2, "fSource");
            return (Criteria) this;
        }

        public Criteria andFDatatypeIsNull() {
            addCriterion("f_dataType is null");
            return (Criteria) this;
        }

        public Criteria andFDatatypeIsNotNull() {
            addCriterion("f_dataType is not null");
            return (Criteria) this;
        }

        public Criteria andFDatatypeEqualTo(String value) {
            addCriterion("f_dataType =", value, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeNotEqualTo(String value) {
            addCriterion("f_dataType <>", value, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeGreaterThan(String value) {
            addCriterion("f_dataType >", value, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_dataType >=", value, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeLessThan(String value) {
            addCriterion("f_dataType <", value, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeLessThanOrEqualTo(String value) {
            addCriterion("f_dataType <=", value, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeLike(String value) {
            addCriterion("f_dataType like", value, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeNotLike(String value) {
            addCriterion("f_dataType not like", value, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeIn(List<String> values) {
            addCriterion("f_dataType in", values, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeNotIn(List<String> values) {
            addCriterion("f_dataType not in", values, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeBetween(String value1, String value2) {
            addCriterion("f_dataType between", value1, value2, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFDatatypeNotBetween(String value1, String value2) {
            addCriterion("f_dataType not between", value1, value2, "fDatatype");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsIsNull() {
            addCriterion("f_respond_instructions is null");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsIsNotNull() {
            addCriterion("f_respond_instructions is not null");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsEqualTo(String value) {
            addCriterion("f_respond_instructions =", value, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsNotEqualTo(String value) {
            addCriterion("f_respond_instructions <>", value, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsGreaterThan(String value) {
            addCriterion("f_respond_instructions >", value, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsGreaterThanOrEqualTo(String value) {
            addCriterion("f_respond_instructions >=", value, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsLessThan(String value) {
            addCriterion("f_respond_instructions <", value, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsLessThanOrEqualTo(String value) {
            addCriterion("f_respond_instructions <=", value, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsLike(String value) {
            addCriterion("f_respond_instructions like", value, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsNotLike(String value) {
            addCriterion("f_respond_instructions not like", value, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsIn(List<String> values) {
            addCriterion("f_respond_instructions in", values, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsNotIn(List<String> values) {
            addCriterion("f_respond_instructions not in", values, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsBetween(String value1, String value2) {
            addCriterion("f_respond_instructions between", value1, value2, "fRespondInstructions");
            return (Criteria) this;
        }

        public Criteria andFRespondInstructionsNotBetween(String value1, String value2) {
            addCriterion("f_respond_instructions not between", value1, value2, "fRespondInstructions");
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

        public Criteria andFUpdtateTimeIsNull() {
            addCriterion("f_updtate_time is null");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeIsNotNull() {
            addCriterion("f_updtate_time is not null");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeEqualTo(Date value) {
            addCriterion("f_updtate_time =", value, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeNotEqualTo(Date value) {
            addCriterion("f_updtate_time <>", value, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeGreaterThan(Date value) {
            addCriterion("f_updtate_time >", value, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_updtate_time >=", value, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeLessThan(Date value) {
            addCriterion("f_updtate_time <", value, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_updtate_time <=", value, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeIn(List<Date> values) {
            addCriterion("f_updtate_time in", values, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeNotIn(List<Date> values) {
            addCriterion("f_updtate_time not in", values, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeBetween(Date value1, Date value2) {
            addCriterion("f_updtate_time between", value1, value2, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdtateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_updtate_time not between", value1, value2, "fUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateIdIsNull() {
            addCriterion("f_create_id is null");
            return (Criteria) this;
        }

        public Criteria andFCreateIdIsNotNull() {
            addCriterion("f_create_id is not null");
            return (Criteria) this;
        }

        public Criteria andFCreateIdEqualTo(Integer value) {
            addCriterion("f_create_id =", value, "fCreateId");
            return (Criteria) this;
        }

        public Criteria andFCreateIdNotEqualTo(Integer value) {
            addCriterion("f_create_id <>", value, "fCreateId");
            return (Criteria) this;
        }

        public Criteria andFCreateIdGreaterThan(Integer value) {
            addCriterion("f_create_id >", value, "fCreateId");
            return (Criteria) this;
        }

        public Criteria andFCreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_create_id >=", value, "fCreateId");
            return (Criteria) this;
        }

        public Criteria andFCreateIdLessThan(Integer value) {
            addCriterion("f_create_id <", value, "fCreateId");
            return (Criteria) this;
        }

        public Criteria andFCreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_create_id <=", value, "fCreateId");
            return (Criteria) this;
        }

        public Criteria andFCreateIdIn(List<Integer> values) {
            addCriterion("f_create_id in", values, "fCreateId");
            return (Criteria) this;
        }

        public Criteria andFCreateIdNotIn(List<Integer> values) {
            addCriterion("f_create_id not in", values, "fCreateId");
            return (Criteria) this;
        }

        public Criteria andFCreateIdBetween(Integer value1, Integer value2) {
            addCriterion("f_create_id between", value1, value2, "fCreateId");
            return (Criteria) this;
        }

        public Criteria andFCreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_create_id not between", value1, value2, "fCreateId");
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