package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAlarmPrincipalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAlarmPrincipalExample() {
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

        public Criteria andFPrincipalIsNull() {
            addCriterion("f_principal is null");
            return (Criteria) this;
        }

        public Criteria andFPrincipalIsNotNull() {
            addCriterion("f_principal is not null");
            return (Criteria) this;
        }

        public Criteria andFPrincipalEqualTo(String value) {
            addCriterion("f_principal =", value, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalNotEqualTo(String value) {
            addCriterion("f_principal <>", value, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalGreaterThan(String value) {
            addCriterion("f_principal >", value, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("f_principal >=", value, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalLessThan(String value) {
            addCriterion("f_principal <", value, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalLessThanOrEqualTo(String value) {
            addCriterion("f_principal <=", value, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalLike(String value) {
            addCriterion("f_principal like", value, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalNotLike(String value) {
            addCriterion("f_principal not like", value, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalIn(List<String> values) {
            addCriterion("f_principal in", values, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalNotIn(List<String> values) {
            addCriterion("f_principal not in", values, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalBetween(String value1, String value2) {
            addCriterion("f_principal between", value1, value2, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFPrincipalNotBetween(String value1, String value2) {
            addCriterion("f_principal not between", value1, value2, "fPrincipal");
            return (Criteria) this;
        }

        public Criteria andFAreaIsNull() {
            addCriterion("f_area is null");
            return (Criteria) this;
        }

        public Criteria andFAreaIsNotNull() {
            addCriterion("f_area is not null");
            return (Criteria) this;
        }

        public Criteria andFAreaEqualTo(Integer value) {
            addCriterion("f_area =", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaNotEqualTo(Integer value) {
            addCriterion("f_area <>", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaGreaterThan(Integer value) {
            addCriterion("f_area >", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_area >=", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaLessThan(Integer value) {
            addCriterion("f_area <", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaLessThanOrEqualTo(Integer value) {
            addCriterion("f_area <=", value, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaIn(List<Integer> values) {
            addCriterion("f_area in", values, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaNotIn(List<Integer> values) {
            addCriterion("f_area not in", values, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaBetween(Integer value1, Integer value2) {
            addCriterion("f_area between", value1, value2, "fArea");
            return (Criteria) this;
        }

        public Criteria andFAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("f_area not between", value1, value2, "fArea");
            return (Criteria) this;
        }

        public Criteria andFCareerIsNull() {
            addCriterion("f_career is null");
            return (Criteria) this;
        }

        public Criteria andFCareerIsNotNull() {
            addCriterion("f_career is not null");
            return (Criteria) this;
        }

        public Criteria andFCareerEqualTo(String value) {
            addCriterion("f_career =", value, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerNotEqualTo(String value) {
            addCriterion("f_career <>", value, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerGreaterThan(String value) {
            addCriterion("f_career >", value, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerGreaterThanOrEqualTo(String value) {
            addCriterion("f_career >=", value, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerLessThan(String value) {
            addCriterion("f_career <", value, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerLessThanOrEqualTo(String value) {
            addCriterion("f_career <=", value, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerLike(String value) {
            addCriterion("f_career like", value, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerNotLike(String value) {
            addCriterion("f_career not like", value, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerIn(List<String> values) {
            addCriterion("f_career in", values, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerNotIn(List<String> values) {
            addCriterion("f_career not in", values, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerBetween(String value1, String value2) {
            addCriterion("f_career between", value1, value2, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFCareerNotBetween(String value1, String value2) {
            addCriterion("f_career not between", value1, value2, "fCareer");
            return (Criteria) this;
        }

        public Criteria andFTelephoneIsNull() {
            addCriterion("f_telephone is null");
            return (Criteria) this;
        }

        public Criteria andFTelephoneIsNotNull() {
            addCriterion("f_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andFTelephoneEqualTo(String value) {
            addCriterion("f_telephone =", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNotEqualTo(String value) {
            addCriterion("f_telephone <>", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneGreaterThan(String value) {
            addCriterion("f_telephone >", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("f_telephone >=", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneLessThan(String value) {
            addCriterion("f_telephone <", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneLessThanOrEqualTo(String value) {
            addCriterion("f_telephone <=", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneLike(String value) {
            addCriterion("f_telephone like", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNotLike(String value) {
            addCriterion("f_telephone not like", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneIn(List<String> values) {
            addCriterion("f_telephone in", values, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNotIn(List<String> values) {
            addCriterion("f_telephone not in", values, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneBetween(String value1, String value2) {
            addCriterion("f_telephone between", value1, value2, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNotBetween(String value1, String value2) {
            addCriterion("f_telephone not between", value1, value2, "fTelephone");
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