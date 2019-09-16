package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDictionaryExample() {
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

        public Criteria andFDictionaryTypeIsNull() {
            addCriterion("f_dictionary_type is null");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeIsNotNull() {
            addCriterion("f_dictionary_type is not null");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeEqualTo(Integer value) {
            addCriterion("f_dictionary_type =", value, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeNotEqualTo(Integer value) {
            addCriterion("f_dictionary_type <>", value, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeGreaterThan(Integer value) {
            addCriterion("f_dictionary_type >", value, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_dictionary_type >=", value, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeLessThan(Integer value) {
            addCriterion("f_dictionary_type <", value, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeLessThanOrEqualTo(Integer value) {
            addCriterion("f_dictionary_type <=", value, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeIn(List<Integer> values) {
            addCriterion("f_dictionary_type in", values, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeNotIn(List<Integer> values) {
            addCriterion("f_dictionary_type not in", values, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeBetween(Integer value1, Integer value2) {
            addCriterion("f_dictionary_type between", value1, value2, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_dictionary_type not between", value1, value2, "fDictionaryType");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeIsNull() {
            addCriterion("f_dictionary_code is null");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeIsNotNull() {
            addCriterion("f_dictionary_code is not null");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeEqualTo(String value) {
            addCriterion("f_dictionary_code =", value, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeNotEqualTo(String value) {
            addCriterion("f_dictionary_code <>", value, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeGreaterThan(String value) {
            addCriterion("f_dictionary_code >", value, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_dictionary_code >=", value, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeLessThan(String value) {
            addCriterion("f_dictionary_code <", value, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeLessThanOrEqualTo(String value) {
            addCriterion("f_dictionary_code <=", value, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeLike(String value) {
            addCriterion("f_dictionary_code like", value, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeNotLike(String value) {
            addCriterion("f_dictionary_code not like", value, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeIn(List<String> values) {
            addCriterion("f_dictionary_code in", values, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeNotIn(List<String> values) {
            addCriterion("f_dictionary_code not in", values, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeBetween(String value1, String value2) {
            addCriterion("f_dictionary_code between", value1, value2, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryCodeNotBetween(String value1, String value2) {
            addCriterion("f_dictionary_code not between", value1, value2, "fDictionaryCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeIsNull() {
            addCriterion("f_third_code is null");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeIsNotNull() {
            addCriterion("f_third_code is not null");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeEqualTo(String value) {
            addCriterion("f_third_code =", value, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeNotEqualTo(String value) {
            addCriterion("f_third_code <>", value, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeGreaterThan(String value) {
            addCriterion("f_third_code >", value, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_third_code >=", value, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeLessThan(String value) {
            addCriterion("f_third_code <", value, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeLessThanOrEqualTo(String value) {
            addCriterion("f_third_code <=", value, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeLike(String value) {
            addCriterion("f_third_code like", value, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeNotLike(String value) {
            addCriterion("f_third_code not like", value, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeIn(List<String> values) {
            addCriterion("f_third_code in", values, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeNotIn(List<String> values) {
            addCriterion("f_third_code not in", values, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeBetween(String value1, String value2) {
            addCriterion("f_third_code between", value1, value2, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFThirdCodeNotBetween(String value1, String value2) {
            addCriterion("f_third_code not between", value1, value2, "fThirdCode");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentIsNull() {
            addCriterion("f_dictionary_content is null");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentIsNotNull() {
            addCriterion("f_dictionary_content is not null");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentEqualTo(String value) {
            addCriterion("f_dictionary_content =", value, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentNotEqualTo(String value) {
            addCriterion("f_dictionary_content <>", value, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentGreaterThan(String value) {
            addCriterion("f_dictionary_content >", value, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentGreaterThanOrEqualTo(String value) {
            addCriterion("f_dictionary_content >=", value, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentLessThan(String value) {
            addCriterion("f_dictionary_content <", value, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentLessThanOrEqualTo(String value) {
            addCriterion("f_dictionary_content <=", value, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentLike(String value) {
            addCriterion("f_dictionary_content like", value, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentNotLike(String value) {
            addCriterion("f_dictionary_content not like", value, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentIn(List<String> values) {
            addCriterion("f_dictionary_content in", values, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentNotIn(List<String> values) {
            addCriterion("f_dictionary_content not in", values, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentBetween(String value1, String value2) {
            addCriterion("f_dictionary_content between", value1, value2, "fDictionaryContent");
            return (Criteria) this;
        }

        public Criteria andFDictionaryContentNotBetween(String value1, String value2) {
            addCriterion("f_dictionary_content not between", value1, value2, "fDictionaryContent");
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