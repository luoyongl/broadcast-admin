package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TManufacturerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TManufacturerExample() {
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

        public Criteria andFManufacturerNoIsNull() {
            addCriterion("f_manufacturer_no is null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoIsNotNull() {
            addCriterion("f_manufacturer_no is not null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoEqualTo(String value) {
            addCriterion("f_manufacturer_no =", value, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoNotEqualTo(String value) {
            addCriterion("f_manufacturer_no <>", value, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoGreaterThan(String value) {
            addCriterion("f_manufacturer_no >", value, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoGreaterThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_no >=", value, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoLessThan(String value) {
            addCriterion("f_manufacturer_no <", value, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoLessThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_no <=", value, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoLike(String value) {
            addCriterion("f_manufacturer_no like", value, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoNotLike(String value) {
            addCriterion("f_manufacturer_no not like", value, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoIn(List<String> values) {
            addCriterion("f_manufacturer_no in", values, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoNotIn(List<String> values) {
            addCriterion("f_manufacturer_no not in", values, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoBetween(String value1, String value2) {
            addCriterion("f_manufacturer_no between", value1, value2, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNoNotBetween(String value1, String value2) {
            addCriterion("f_manufacturer_no not between", value1, value2, "fManufacturerNo");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameIsNull() {
            addCriterion("f_manufacturer_name is null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameIsNotNull() {
            addCriterion("f_manufacturer_name is not null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameEqualTo(String value) {
            addCriterion("f_manufacturer_name =", value, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameNotEqualTo(String value) {
            addCriterion("f_manufacturer_name <>", value, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameGreaterThan(String value) {
            addCriterion("f_manufacturer_name >", value, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_name >=", value, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameLessThan(String value) {
            addCriterion("f_manufacturer_name <", value, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameLessThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_name <=", value, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameLike(String value) {
            addCriterion("f_manufacturer_name like", value, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameNotLike(String value) {
            addCriterion("f_manufacturer_name not like", value, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameIn(List<String> values) {
            addCriterion("f_manufacturer_name in", values, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameNotIn(List<String> values) {
            addCriterion("f_manufacturer_name not in", values, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameBetween(String value1, String value2) {
            addCriterion("f_manufacturer_name between", value1, value2, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNameNotBetween(String value1, String value2) {
            addCriterion("f_manufacturer_name not between", value1, value2, "fManufacturerName");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressIsNull() {
            addCriterion("f_manufacturer_address is null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressIsNotNull() {
            addCriterion("f_manufacturer_address is not null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressEqualTo(String value) {
            addCriterion("f_manufacturer_address =", value, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressNotEqualTo(String value) {
            addCriterion("f_manufacturer_address <>", value, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressGreaterThan(String value) {
            addCriterion("f_manufacturer_address >", value, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_address >=", value, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressLessThan(String value) {
            addCriterion("f_manufacturer_address <", value, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressLessThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_address <=", value, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressLike(String value) {
            addCriterion("f_manufacturer_address like", value, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressNotLike(String value) {
            addCriterion("f_manufacturer_address not like", value, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressIn(List<String> values) {
            addCriterion("f_manufacturer_address in", values, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressNotIn(List<String> values) {
            addCriterion("f_manufacturer_address not in", values, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressBetween(String value1, String value2) {
            addCriterion("f_manufacturer_address between", value1, value2, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerAddressNotBetween(String value1, String value2) {
            addCriterion("f_manufacturer_address not between", value1, value2, "fManufacturerAddress");
            return (Criteria) this;
        }

        public Criteria andFLinkmanIsNull() {
            addCriterion("f_linkman is null");
            return (Criteria) this;
        }

        public Criteria andFLinkmanIsNotNull() {
            addCriterion("f_linkman is not null");
            return (Criteria) this;
        }

        public Criteria andFLinkmanEqualTo(String value) {
            addCriterion("f_linkman =", value, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanNotEqualTo(String value) {
            addCriterion("f_linkman <>", value, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanGreaterThan(String value) {
            addCriterion("f_linkman >", value, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("f_linkman >=", value, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanLessThan(String value) {
            addCriterion("f_linkman <", value, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanLessThanOrEqualTo(String value) {
            addCriterion("f_linkman <=", value, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanLike(String value) {
            addCriterion("f_linkman like", value, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanNotLike(String value) {
            addCriterion("f_linkman not like", value, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanIn(List<String> values) {
            addCriterion("f_linkman in", values, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanNotIn(List<String> values) {
            addCriterion("f_linkman not in", values, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanBetween(String value1, String value2) {
            addCriterion("f_linkman between", value1, value2, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFLinkmanNotBetween(String value1, String value2) {
            addCriterion("f_linkman not between", value1, value2, "fLinkman");
            return (Criteria) this;
        }

        public Criteria andFTelIsNull() {
            addCriterion("f_tel is null");
            return (Criteria) this;
        }

        public Criteria andFTelIsNotNull() {
            addCriterion("f_tel is not null");
            return (Criteria) this;
        }

        public Criteria andFTelEqualTo(String value) {
            addCriterion("f_tel =", value, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelNotEqualTo(String value) {
            addCriterion("f_tel <>", value, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelGreaterThan(String value) {
            addCriterion("f_tel >", value, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelGreaterThanOrEqualTo(String value) {
            addCriterion("f_tel >=", value, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelLessThan(String value) {
            addCriterion("f_tel <", value, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelLessThanOrEqualTo(String value) {
            addCriterion("f_tel <=", value, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelLike(String value) {
            addCriterion("f_tel like", value, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelNotLike(String value) {
            addCriterion("f_tel not like", value, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelIn(List<String> values) {
            addCriterion("f_tel in", values, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelNotIn(List<String> values) {
            addCriterion("f_tel not in", values, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelBetween(String value1, String value2) {
            addCriterion("f_tel between", value1, value2, "fTel");
            return (Criteria) this;
        }

        public Criteria andFTelNotBetween(String value1, String value2) {
            addCriterion("f_tel not between", value1, value2, "fTel");
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