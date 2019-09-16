package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserExample() {
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

        public Criteria andFAccountIsNull() {
            addCriterion("f_account is null");
            return (Criteria) this;
        }

        public Criteria andFAccountIsNotNull() {
            addCriterion("f_account is not null");
            return (Criteria) this;
        }

        public Criteria andFAccountEqualTo(String value) {
            addCriterion("f_account =", value, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountNotEqualTo(String value) {
            addCriterion("f_account <>", value, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountGreaterThan(String value) {
            addCriterion("f_account >", value, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountGreaterThanOrEqualTo(String value) {
            addCriterion("f_account >=", value, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountLessThan(String value) {
            addCriterion("f_account <", value, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountLessThanOrEqualTo(String value) {
            addCriterion("f_account <=", value, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountLike(String value) {
            addCriterion("f_account like", value, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountNotLike(String value) {
            addCriterion("f_account not like", value, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountIn(List<String> values) {
            addCriterion("f_account in", values, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountNotIn(List<String> values) {
            addCriterion("f_account not in", values, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountBetween(String value1, String value2) {
            addCriterion("f_account between", value1, value2, "fAccount");
            return (Criteria) this;
        }

        public Criteria andFAccountNotBetween(String value1, String value2) {
            addCriterion("f_account not between", value1, value2, "fAccount");
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

        public Criteria andFPasswordIsNull() {
            addCriterion("f_password is null");
            return (Criteria) this;
        }

        public Criteria andFPasswordIsNotNull() {
            addCriterion("f_password is not null");
            return (Criteria) this;
        }

        public Criteria andFPasswordEqualTo(String value) {
            addCriterion("f_password =", value, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordNotEqualTo(String value) {
            addCriterion("f_password <>", value, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordGreaterThan(String value) {
            addCriterion("f_password >", value, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("f_password >=", value, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordLessThan(String value) {
            addCriterion("f_password <", value, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordLessThanOrEqualTo(String value) {
            addCriterion("f_password <=", value, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordLike(String value) {
            addCriterion("f_password like", value, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordNotLike(String value) {
            addCriterion("f_password not like", value, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordIn(List<String> values) {
            addCriterion("f_password in", values, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordNotIn(List<String> values) {
            addCriterion("f_password not in", values, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordBetween(String value1, String value2) {
            addCriterion("f_password between", value1, value2, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFPasswordNotBetween(String value1, String value2) {
            addCriterion("f_password not between", value1, value2, "fPassword");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionIsNull() {
            addCriterion("f_respective_region is null");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionIsNotNull() {
            addCriterion("f_respective_region is not null");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionEqualTo(Integer value) {
            addCriterion("f_respective_region =", value, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionNotEqualTo(Integer value) {
            addCriterion("f_respective_region <>", value, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionGreaterThan(Integer value) {
            addCriterion("f_respective_region >", value, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_respective_region >=", value, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionLessThan(Integer value) {
            addCriterion("f_respective_region <", value, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionLessThanOrEqualTo(Integer value) {
            addCriterion("f_respective_region <=", value, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionIn(List<Integer> values) {
            addCriterion("f_respective_region in", values, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionNotIn(List<Integer> values) {
            addCriterion("f_respective_region not in", values, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionBetween(Integer value1, Integer value2) {
            addCriterion("f_respective_region between", value1, value2, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFRespectiveRegionNotBetween(Integer value1, Integer value2) {
            addCriterion("f_respective_region not between", value1, value2, "fRespectiveRegion");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitIsNull() {
            addCriterion("f_subordinate_unit is null");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitIsNotNull() {
            addCriterion("f_subordinate_unit is not null");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitEqualTo(String value) {
            addCriterion("f_subordinate_unit =", value, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitNotEqualTo(String value) {
            addCriterion("f_subordinate_unit <>", value, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitGreaterThan(String value) {
            addCriterion("f_subordinate_unit >", value, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitGreaterThanOrEqualTo(String value) {
            addCriterion("f_subordinate_unit >=", value, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitLessThan(String value) {
            addCriterion("f_subordinate_unit <", value, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitLessThanOrEqualTo(String value) {
            addCriterion("f_subordinate_unit <=", value, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitLike(String value) {
            addCriterion("f_subordinate_unit like", value, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitNotLike(String value) {
            addCriterion("f_subordinate_unit not like", value, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitIn(List<String> values) {
            addCriterion("f_subordinate_unit in", values, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitNotIn(List<String> values) {
            addCriterion("f_subordinate_unit not in", values, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitBetween(String value1, String value2) {
            addCriterion("f_subordinate_unit between", value1, value2, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFSubordinateUnitNotBetween(String value1, String value2) {
            addCriterion("f_subordinate_unit not between", value1, value2, "fSubordinateUnit");
            return (Criteria) this;
        }

        public Criteria andFDutiesIsNull() {
            addCriterion("f_duties is null");
            return (Criteria) this;
        }

        public Criteria andFDutiesIsNotNull() {
            addCriterion("f_duties is not null");
            return (Criteria) this;
        }

        public Criteria andFDutiesEqualTo(String value) {
            addCriterion("f_duties =", value, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesNotEqualTo(String value) {
            addCriterion("f_duties <>", value, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesGreaterThan(String value) {
            addCriterion("f_duties >", value, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesGreaterThanOrEqualTo(String value) {
            addCriterion("f_duties >=", value, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesLessThan(String value) {
            addCriterion("f_duties <", value, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesLessThanOrEqualTo(String value) {
            addCriterion("f_duties <=", value, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesLike(String value) {
            addCriterion("f_duties like", value, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesNotLike(String value) {
            addCriterion("f_duties not like", value, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesIn(List<String> values) {
            addCriterion("f_duties in", values, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesNotIn(List<String> values) {
            addCriterion("f_duties not in", values, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesBetween(String value1, String value2) {
            addCriterion("f_duties between", value1, value2, "fDuties");
            return (Criteria) this;
        }

        public Criteria andFDutiesNotBetween(String value1, String value2) {
            addCriterion("f_duties not between", value1, value2, "fDuties");
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

        public Criteria andFIsAuditAutomaticIsNull() {
            addCriterion("f_is_audit_automatic is null");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticIsNotNull() {
            addCriterion("f_is_audit_automatic is not null");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticEqualTo(Boolean value) {
            addCriterion("f_is_audit_automatic =", value, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticNotEqualTo(Boolean value) {
            addCriterion("f_is_audit_automatic <>", value, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticGreaterThan(Boolean value) {
            addCriterion("f_is_audit_automatic >", value, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_is_audit_automatic >=", value, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticLessThan(Boolean value) {
            addCriterion("f_is_audit_automatic <", value, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticLessThanOrEqualTo(Boolean value) {
            addCriterion("f_is_audit_automatic <=", value, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticIn(List<Boolean> values) {
            addCriterion("f_is_audit_automatic in", values, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticNotIn(List<Boolean> values) {
            addCriterion("f_is_audit_automatic not in", values, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticBetween(Boolean value1, Boolean value2) {
            addCriterion("f_is_audit_automatic between", value1, value2, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsAuditAutomaticNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_is_audit_automatic not between", value1, value2, "fIsAuditAutomatic");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanIsNull() {
            addCriterion("f_is_linkman is null");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanIsNotNull() {
            addCriterion("f_is_linkman is not null");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanEqualTo(Boolean value) {
            addCriterion("f_is_linkman =", value, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanNotEqualTo(Boolean value) {
            addCriterion("f_is_linkman <>", value, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanGreaterThan(Boolean value) {
            addCriterion("f_is_linkman >", value, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_is_linkman >=", value, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanLessThan(Boolean value) {
            addCriterion("f_is_linkman <", value, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanLessThanOrEqualTo(Boolean value) {
            addCriterion("f_is_linkman <=", value, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanIn(List<Boolean> values) {
            addCriterion("f_is_linkman in", values, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanNotIn(List<Boolean> values) {
            addCriterion("f_is_linkman not in", values, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanBetween(Boolean value1, Boolean value2) {
            addCriterion("f_is_linkman between", value1, value2, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsLinkmanNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_is_linkman not between", value1, value2, "fIsLinkman");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveIsNull() {
            addCriterion("f_is_effective is null");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveIsNotNull() {
            addCriterion("f_is_effective is not null");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveEqualTo(Boolean value) {
            addCriterion("f_is_effective =", value, "fIsEffective");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveNotEqualTo(Boolean value) {
            addCriterion("f_is_effective <>", value, "fIsEffective");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveGreaterThan(Boolean value) {
            addCriterion("f_is_effective >", value, "fIsEffective");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_is_effective >=", value, "fIsEffective");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveLessThan(Boolean value) {
            addCriterion("f_is_effective <", value, "fIsEffective");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveLessThanOrEqualTo(Boolean value) {
            addCriterion("f_is_effective <=", value, "fIsEffective");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveIn(List<Boolean> values) {
            addCriterion("f_is_effective in", values, "fIsEffective");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveNotIn(List<Boolean> values) {
            addCriterion("f_is_effective not in", values, "fIsEffective");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveBetween(Boolean value1, Boolean value2) {
            addCriterion("f_is_effective between", value1, value2, "fIsEffective");
            return (Criteria) this;
        }

        public Criteria andFIsEffectiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_is_effective not between", value1, value2, "fIsEffective");
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