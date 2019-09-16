package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BSystemInfoRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSystemInfoRecordExample() {
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

        public Criteria andFInfoTypeIsNull() {
            addCriterion("f_info_type is null");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeIsNotNull() {
            addCriterion("f_info_type is not null");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeEqualTo(Byte value) {
            addCriterion("f_info_type =", value, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeNotEqualTo(Byte value) {
            addCriterion("f_info_type <>", value, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeGreaterThan(Byte value) {
            addCriterion("f_info_type >", value, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_info_type >=", value, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeLessThan(Byte value) {
            addCriterion("f_info_type <", value, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_info_type <=", value, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeIn(List<Byte> values) {
            addCriterion("f_info_type in", values, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeNotIn(List<Byte> values) {
            addCriterion("f_info_type not in", values, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_info_type between", value1, value2, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFInfoTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_info_type not between", value1, value2, "fInfoType");
            return (Criteria) this;
        }

        public Criteria andFTotalValueIsNull() {
            addCriterion("f_total_value is null");
            return (Criteria) this;
        }

        public Criteria andFTotalValueIsNotNull() {
            addCriterion("f_total_value is not null");
            return (Criteria) this;
        }

        public Criteria andFTotalValueEqualTo(Long value) {
            addCriterion("f_total_value =", value, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFTotalValueNotEqualTo(Long value) {
            addCriterion("f_total_value <>", value, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFTotalValueGreaterThan(Long value) {
            addCriterion("f_total_value >", value, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFTotalValueGreaterThanOrEqualTo(Long value) {
            addCriterion("f_total_value >=", value, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFTotalValueLessThan(Long value) {
            addCriterion("f_total_value <", value, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFTotalValueLessThanOrEqualTo(Long value) {
            addCriterion("f_total_value <=", value, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFTotalValueIn(List<Long> values) {
            addCriterion("f_total_value in", values, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFTotalValueNotIn(List<Long> values) {
            addCriterion("f_total_value not in", values, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFTotalValueBetween(Long value1, Long value2) {
            addCriterion("f_total_value between", value1, value2, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFTotalValueNotBetween(Long value1, Long value2) {
            addCriterion("f_total_value not between", value1, value2, "fTotalValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueIsNull() {
            addCriterion("f_used_value is null");
            return (Criteria) this;
        }

        public Criteria andFUsedValueIsNotNull() {
            addCriterion("f_used_value is not null");
            return (Criteria) this;
        }

        public Criteria andFUsedValueEqualTo(Long value) {
            addCriterion("f_used_value =", value, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueNotEqualTo(Long value) {
            addCriterion("f_used_value <>", value, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueGreaterThan(Long value) {
            addCriterion("f_used_value >", value, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueGreaterThanOrEqualTo(Long value) {
            addCriterion("f_used_value >=", value, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueLessThan(Long value) {
            addCriterion("f_used_value <", value, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueLessThanOrEqualTo(Long value) {
            addCriterion("f_used_value <=", value, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueIn(List<Long> values) {
            addCriterion("f_used_value in", values, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueNotIn(List<Long> values) {
            addCriterion("f_used_value not in", values, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueBetween(Long value1, Long value2) {
            addCriterion("f_used_value between", value1, value2, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFUsedValueNotBetween(Long value1, Long value2) {
            addCriterion("f_used_value not between", value1, value2, "fUsedValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueIsNull() {
            addCriterion("f_free_value is null");
            return (Criteria) this;
        }

        public Criteria andFFreeValueIsNotNull() {
            addCriterion("f_free_value is not null");
            return (Criteria) this;
        }

        public Criteria andFFreeValueEqualTo(Long value) {
            addCriterion("f_free_value =", value, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueNotEqualTo(Long value) {
            addCriterion("f_free_value <>", value, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueGreaterThan(Long value) {
            addCriterion("f_free_value >", value, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueGreaterThanOrEqualTo(Long value) {
            addCriterion("f_free_value >=", value, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueLessThan(Long value) {
            addCriterion("f_free_value <", value, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueLessThanOrEqualTo(Long value) {
            addCriterion("f_free_value <=", value, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueIn(List<Long> values) {
            addCriterion("f_free_value in", values, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueNotIn(List<Long> values) {
            addCriterion("f_free_value not in", values, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueBetween(Long value1, Long value2) {
            addCriterion("f_free_value between", value1, value2, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFFreeValueNotBetween(Long value1, Long value2) {
            addCriterion("f_free_value not between", value1, value2, "fFreeValue");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedIsNull() {
            addCriterion("f_percent_used is null");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedIsNotNull() {
            addCriterion("f_percent_used is not null");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedEqualTo(String value) {
            addCriterion("f_percent_used =", value, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedNotEqualTo(String value) {
            addCriterion("f_percent_used <>", value, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedGreaterThan(String value) {
            addCriterion("f_percent_used >", value, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedGreaterThanOrEqualTo(String value) {
            addCriterion("f_percent_used >=", value, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedLessThan(String value) {
            addCriterion("f_percent_used <", value, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedLessThanOrEqualTo(String value) {
            addCriterion("f_percent_used <=", value, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedLike(String value) {
            addCriterion("f_percent_used like", value, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedNotLike(String value) {
            addCriterion("f_percent_used not like", value, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedIn(List<String> values) {
            addCriterion("f_percent_used in", values, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedNotIn(List<String> values) {
            addCriterion("f_percent_used not in", values, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedBetween(String value1, String value2) {
            addCriterion("f_percent_used between", value1, value2, "fPercentUsed");
            return (Criteria) this;
        }

        public Criteria andFPercentUsedNotBetween(String value1, String value2) {
            addCriterion("f_percent_used not between", value1, value2, "fPercentUsed");
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