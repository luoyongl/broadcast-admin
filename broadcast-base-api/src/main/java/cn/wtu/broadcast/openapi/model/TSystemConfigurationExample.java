package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSystemConfigurationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSystemConfigurationExample() {
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

        public Criteria andFConfigurationTypeIsNull() {
            addCriterion("f_configuration_type is null");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeIsNotNull() {
            addCriterion("f_configuration_type is not null");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeEqualTo(String value) {
            addCriterion("f_configuration_type =", value, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeNotEqualTo(String value) {
            addCriterion("f_configuration_type <>", value, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeGreaterThan(String value) {
            addCriterion("f_configuration_type >", value, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_configuration_type >=", value, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeLessThan(String value) {
            addCriterion("f_configuration_type <", value, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeLessThanOrEqualTo(String value) {
            addCriterion("f_configuration_type <=", value, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeLike(String value) {
            addCriterion("f_configuration_type like", value, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeNotLike(String value) {
            addCriterion("f_configuration_type not like", value, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeIn(List<String> values) {
            addCriterion("f_configuration_type in", values, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeNotIn(List<String> values) {
            addCriterion("f_configuration_type not in", values, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeBetween(String value1, String value2) {
            addCriterion("f_configuration_type between", value1, value2, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationTypeNotBetween(String value1, String value2) {
            addCriterion("f_configuration_type not between", value1, value2, "fConfigurationType");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameIsNull() {
            addCriterion("f_configuration_name is null");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameIsNotNull() {
            addCriterion("f_configuration_name is not null");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameEqualTo(String value) {
            addCriterion("f_configuration_name =", value, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameNotEqualTo(String value) {
            addCriterion("f_configuration_name <>", value, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameGreaterThan(String value) {
            addCriterion("f_configuration_name >", value, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_configuration_name >=", value, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameLessThan(String value) {
            addCriterion("f_configuration_name <", value, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameLessThanOrEqualTo(String value) {
            addCriterion("f_configuration_name <=", value, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameLike(String value) {
            addCriterion("f_configuration_name like", value, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameNotLike(String value) {
            addCriterion("f_configuration_name not like", value, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameIn(List<String> values) {
            addCriterion("f_configuration_name in", values, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameNotIn(List<String> values) {
            addCriterion("f_configuration_name not in", values, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameBetween(String value1, String value2) {
            addCriterion("f_configuration_name between", value1, value2, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationNameNotBetween(String value1, String value2) {
            addCriterion("f_configuration_name not between", value1, value2, "fConfigurationName");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueIsNull() {
            addCriterion("f_configuration_value is null");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueIsNotNull() {
            addCriterion("f_configuration_value is not null");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueEqualTo(String value) {
            addCriterion("f_configuration_value =", value, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueNotEqualTo(String value) {
            addCriterion("f_configuration_value <>", value, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueGreaterThan(String value) {
            addCriterion("f_configuration_value >", value, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueGreaterThanOrEqualTo(String value) {
            addCriterion("f_configuration_value >=", value, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueLessThan(String value) {
            addCriterion("f_configuration_value <", value, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueLessThanOrEqualTo(String value) {
            addCriterion("f_configuration_value <=", value, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueLike(String value) {
            addCriterion("f_configuration_value like", value, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueNotLike(String value) {
            addCriterion("f_configuration_value not like", value, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueIn(List<String> values) {
            addCriterion("f_configuration_value in", values, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueNotIn(List<String> values) {
            addCriterion("f_configuration_value not in", values, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueBetween(String value1, String value2) {
            addCriterion("f_configuration_value between", value1, value2, "fConfigurationValue");
            return (Criteria) this;
        }

        public Criteria andFConfigurationValueNotBetween(String value1, String value2) {
            addCriterion("f_configuration_value not between", value1, value2, "fConfigurationValue");
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