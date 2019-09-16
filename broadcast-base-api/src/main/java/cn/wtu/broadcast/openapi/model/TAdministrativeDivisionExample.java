package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAdministrativeDivisionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAdministrativeDivisionExample() {
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

        public Criteria andFCodeIsNull() {
            addCriterion("f_code is null");
            return (Criteria) this;
        }

        public Criteria andFCodeIsNotNull() {
            addCriterion("f_code is not null");
            return (Criteria) this;
        }

        public Criteria andFCodeEqualTo(String value) {
            addCriterion("f_code =", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotEqualTo(String value) {
            addCriterion("f_code <>", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeGreaterThan(String value) {
            addCriterion("f_code >", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_code >=", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeLessThan(String value) {
            addCriterion("f_code <", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeLessThanOrEqualTo(String value) {
            addCriterion("f_code <=", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeLike(String value) {
            addCriterion("f_code like", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotLike(String value) {
            addCriterion("f_code not like", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeIn(List<String> values) {
            addCriterion("f_code in", values, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotIn(List<String> values) {
            addCriterion("f_code not in", values, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeBetween(String value1, String value2) {
            addCriterion("f_code between", value1, value2, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotBetween(String value1, String value2) {
            addCriterion("f_code not between", value1, value2, "fCode");
            return (Criteria) this;
        }

        public Criteria andFNameIsNull() {
            addCriterion("f_name is null");
            return (Criteria) this;
        }

        public Criteria andFNameIsNotNull() {
            addCriterion("f_name is not null");
            return (Criteria) this;
        }

        public Criteria andFNameEqualTo(String value) {
            addCriterion("f_name =", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotEqualTo(String value) {
            addCriterion("f_name <>", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThan(String value) {
            addCriterion("f_name >", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_name >=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThan(String value) {
            addCriterion("f_name <", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThanOrEqualTo(String value) {
            addCriterion("f_name <=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLike(String value) {
            addCriterion("f_name like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotLike(String value) {
            addCriterion("f_name not like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameIn(List<String> values) {
            addCriterion("f_name in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotIn(List<String> values) {
            addCriterion("f_name not in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameBetween(String value1, String value2) {
            addCriterion("f_name between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotBetween(String value1, String value2) {
            addCriterion("f_name not between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFLongitudeIsNull() {
            addCriterion("f_longitude is null");
            return (Criteria) this;
        }

        public Criteria andFLongitudeIsNotNull() {
            addCriterion("f_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andFLongitudeEqualTo(String value) {
            addCriterion("f_longitude =", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeNotEqualTo(String value) {
            addCriterion("f_longitude <>", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeGreaterThan(String value) {
            addCriterion("f_longitude >", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("f_longitude >=", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeLessThan(String value) {
            addCriterion("f_longitude <", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeLessThanOrEqualTo(String value) {
            addCriterion("f_longitude <=", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeLike(String value) {
            addCriterion("f_longitude like", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeNotLike(String value) {
            addCriterion("f_longitude not like", value, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeIn(List<String> values) {
            addCriterion("f_longitude in", values, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeNotIn(List<String> values) {
            addCriterion("f_longitude not in", values, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeBetween(String value1, String value2) {
            addCriterion("f_longitude between", value1, value2, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLongitudeNotBetween(String value1, String value2) {
            addCriterion("f_longitude not between", value1, value2, "fLongitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeIsNull() {
            addCriterion("f_latitude is null");
            return (Criteria) this;
        }

        public Criteria andFLatitudeIsNotNull() {
            addCriterion("f_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andFLatitudeEqualTo(String value) {
            addCriterion("f_latitude =", value, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeNotEqualTo(String value) {
            addCriterion("f_latitude <>", value, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeGreaterThan(String value) {
            addCriterion("f_latitude >", value, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("f_latitude >=", value, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeLessThan(String value) {
            addCriterion("f_latitude <", value, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeLessThanOrEqualTo(String value) {
            addCriterion("f_latitude <=", value, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeLike(String value) {
            addCriterion("f_latitude like", value, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeNotLike(String value) {
            addCriterion("f_latitude not like", value, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeIn(List<String> values) {
            addCriterion("f_latitude in", values, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeNotIn(List<String> values) {
            addCriterion("f_latitude not in", values, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeBetween(String value1, String value2) {
            addCriterion("f_latitude between", value1, value2, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFLatitudeNotBetween(String value1, String value2) {
            addCriterion("f_latitude not between", value1, value2, "fLatitude");
            return (Criteria) this;
        }

        public Criteria andFParentNodeIsNull() {
            addCriterion("f_parent_node is null");
            return (Criteria) this;
        }

        public Criteria andFParentNodeIsNotNull() {
            addCriterion("f_parent_node is not null");
            return (Criteria) this;
        }

        public Criteria andFParentNodeEqualTo(Integer value) {
            addCriterion("f_parent_node =", value, "fParentNode");
            return (Criteria) this;
        }

        public Criteria andFParentNodeNotEqualTo(Integer value) {
            addCriterion("f_parent_node <>", value, "fParentNode");
            return (Criteria) this;
        }

        public Criteria andFParentNodeGreaterThan(Integer value) {
            addCriterion("f_parent_node >", value, "fParentNode");
            return (Criteria) this;
        }

        public Criteria andFParentNodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_parent_node >=", value, "fParentNode");
            return (Criteria) this;
        }

        public Criteria andFParentNodeLessThan(Integer value) {
            addCriterion("f_parent_node <", value, "fParentNode");
            return (Criteria) this;
        }

        public Criteria andFParentNodeLessThanOrEqualTo(Integer value) {
            addCriterion("f_parent_node <=", value, "fParentNode");
            return (Criteria) this;
        }

        public Criteria andFParentNodeIn(List<Integer> values) {
            addCriterion("f_parent_node in", values, "fParentNode");
            return (Criteria) this;
        }

        public Criteria andFParentNodeNotIn(List<Integer> values) {
            addCriterion("f_parent_node not in", values, "fParentNode");
            return (Criteria) this;
        }

        public Criteria andFParentNodeBetween(Integer value1, Integer value2) {
            addCriterion("f_parent_node between", value1, value2, "fParentNode");
            return (Criteria) this;
        }

        public Criteria andFParentNodeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_parent_node not between", value1, value2, "fParentNode");
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