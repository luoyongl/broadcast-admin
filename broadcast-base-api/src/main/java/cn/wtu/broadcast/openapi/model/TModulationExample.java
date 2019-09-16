package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TModulationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TModulationExample() {
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

        public Criteria andFServiceIdIsNull() {
            addCriterion("f_service_id is null");
            return (Criteria) this;
        }

        public Criteria andFServiceIdIsNotNull() {
            addCriterion("f_service_id is not null");
            return (Criteria) this;
        }

        public Criteria andFServiceIdEqualTo(String value) {
            addCriterion("f_service_id =", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdNotEqualTo(String value) {
            addCriterion("f_service_id <>", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdGreaterThan(String value) {
            addCriterion("f_service_id >", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_service_id >=", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdLessThan(String value) {
            addCriterion("f_service_id <", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdLessThanOrEqualTo(String value) {
            addCriterion("f_service_id <=", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdLike(String value) {
            addCriterion("f_service_id like", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdNotLike(String value) {
            addCriterion("f_service_id not like", value, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdIn(List<String> values) {
            addCriterion("f_service_id in", values, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdNotIn(List<String> values) {
            addCriterion("f_service_id not in", values, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdBetween(String value1, String value2) {
            addCriterion("f_service_id between", value1, value2, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFServiceIdNotBetween(String value1, String value2) {
            addCriterion("f_service_id not between", value1, value2, "fServiceId");
            return (Criteria) this;
        }

        public Criteria andFPcrPidIsNull() {
            addCriterion("f_pcr_pid is null");
            return (Criteria) this;
        }

        public Criteria andFPcrPidIsNotNull() {
            addCriterion("f_pcr_pid is not null");
            return (Criteria) this;
        }

        public Criteria andFPcrPidEqualTo(String value) {
            addCriterion("f_pcr_pid =", value, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidNotEqualTo(String value) {
            addCriterion("f_pcr_pid <>", value, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidGreaterThan(String value) {
            addCriterion("f_pcr_pid >", value, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidGreaterThanOrEqualTo(String value) {
            addCriterion("f_pcr_pid >=", value, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidLessThan(String value) {
            addCriterion("f_pcr_pid <", value, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidLessThanOrEqualTo(String value) {
            addCriterion("f_pcr_pid <=", value, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidLike(String value) {
            addCriterion("f_pcr_pid like", value, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidNotLike(String value) {
            addCriterion("f_pcr_pid not like", value, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidIn(List<String> values) {
            addCriterion("f_pcr_pid in", values, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidNotIn(List<String> values) {
            addCriterion("f_pcr_pid not in", values, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidBetween(String value1, String value2) {
            addCriterion("f_pcr_pid between", value1, value2, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFPcrPidNotBetween(String value1, String value2) {
            addCriterion("f_pcr_pid not between", value1, value2, "fPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyIsNull() {
            addCriterion("f_dtmb_centre_frequency is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyIsNotNull() {
            addCriterion("f_dtmb_centre_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyEqualTo(String value) {
            addCriterion("f_dtmb_centre_frequency =", value, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyNotEqualTo(String value) {
            addCriterion("f_dtmb_centre_frequency <>", value, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyGreaterThan(String value) {
            addCriterion("f_dtmb_centre_frequency >", value, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_centre_frequency >=", value, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyLessThan(String value) {
            addCriterion("f_dtmb_centre_frequency <", value, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_centre_frequency <=", value, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyLike(String value) {
            addCriterion("f_dtmb_centre_frequency like", value, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyNotLike(String value) {
            addCriterion("f_dtmb_centre_frequency not like", value, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyIn(List<String> values) {
            addCriterion("f_dtmb_centre_frequency in", values, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyNotIn(List<String> values) {
            addCriterion("f_dtmb_centre_frequency not in", values, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyBetween(String value1, String value2) {
            addCriterion("f_dtmb_centre_frequency between", value1, value2, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbCentreFrequencyNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_centre_frequency not between", value1, value2, "fDtmbCentreFrequency");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecIsNull() {
            addCriterion("f_dtmb_FEC is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecIsNotNull() {
            addCriterion("f_dtmb_FEC is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecEqualTo(String value) {
            addCriterion("f_dtmb_FEC =", value, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecNotEqualTo(String value) {
            addCriterion("f_dtmb_FEC <>", value, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecGreaterThan(String value) {
            addCriterion("f_dtmb_FEC >", value, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_FEC >=", value, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecLessThan(String value) {
            addCriterion("f_dtmb_FEC <", value, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_FEC <=", value, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecLike(String value) {
            addCriterion("f_dtmb_FEC like", value, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecNotLike(String value) {
            addCriterion("f_dtmb_FEC not like", value, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecIn(List<String> values) {
            addCriterion("f_dtmb_FEC in", values, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecNotIn(List<String> values) {
            addCriterion("f_dtmb_FEC not in", values, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecBetween(String value1, String value2) {
            addCriterion("f_dtmb_FEC between", value1, value2, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbFecNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_FEC not between", value1, value2, "fDtmbFec");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationIsNull() {
            addCriterion("f_dtmb_modulation is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationIsNotNull() {
            addCriterion("f_dtmb_modulation is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationEqualTo(String value) {
            addCriterion("f_dtmb_modulation =", value, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationNotEqualTo(String value) {
            addCriterion("f_dtmb_modulation <>", value, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationGreaterThan(String value) {
            addCriterion("f_dtmb_modulation >", value, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_modulation >=", value, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationLessThan(String value) {
            addCriterion("f_dtmb_modulation <", value, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_modulation <=", value, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationLike(String value) {
            addCriterion("f_dtmb_modulation like", value, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationNotLike(String value) {
            addCriterion("f_dtmb_modulation not like", value, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationIn(List<String> values) {
            addCriterion("f_dtmb_modulation in", values, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationNotIn(List<String> values) {
            addCriterion("f_dtmb_modulation not in", values, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationBetween(String value1, String value2) {
            addCriterion("f_dtmb_modulation between", value1, value2, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_modulation not between", value1, value2, "fDtmbModulation");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierIsNull() {
            addCriterion("f_dtmb_Number_of_subcarrier is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierIsNotNull() {
            addCriterion("f_dtmb_Number_of_subcarrier is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierEqualTo(String value) {
            addCriterion("f_dtmb_Number_of_subcarrier =", value, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierNotEqualTo(String value) {
            addCriterion("f_dtmb_Number_of_subcarrier <>", value, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierGreaterThan(String value) {
            addCriterion("f_dtmb_Number_of_subcarrier >", value, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_Number_of_subcarrier >=", value, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierLessThan(String value) {
            addCriterion("f_dtmb_Number_of_subcarrier <", value, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_Number_of_subcarrier <=", value, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierLike(String value) {
            addCriterion("f_dtmb_Number_of_subcarrier like", value, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierNotLike(String value) {
            addCriterion("f_dtmb_Number_of_subcarrier not like", value, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierIn(List<String> values) {
            addCriterion("f_dtmb_Number_of_subcarrier in", values, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierNotIn(List<String> values) {
            addCriterion("f_dtmb_Number_of_subcarrier not in", values, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierBetween(String value1, String value2) {
            addCriterion("f_dtmb_Number_of_subcarrier between", value1, value2, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbNumberOfSubcarrierNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_Number_of_subcarrier not between", value1, value2, "fDtmbNumberOfSubcarrier");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeIsNull() {
            addCriterion("f_dtmb_frame_header_mode is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeIsNotNull() {
            addCriterion("f_dtmb_frame_header_mode is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeEqualTo(String value) {
            addCriterion("f_dtmb_frame_header_mode =", value, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeNotEqualTo(String value) {
            addCriterion("f_dtmb_frame_header_mode <>", value, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeGreaterThan(String value) {
            addCriterion("f_dtmb_frame_header_mode >", value, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_frame_header_mode >=", value, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeLessThan(String value) {
            addCriterion("f_dtmb_frame_header_mode <", value, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_frame_header_mode <=", value, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeLike(String value) {
            addCriterion("f_dtmb_frame_header_mode like", value, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeNotLike(String value) {
            addCriterion("f_dtmb_frame_header_mode not like", value, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeIn(List<String> values) {
            addCriterion("f_dtmb_frame_header_mode in", values, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeNotIn(List<String> values) {
            addCriterion("f_dtmb_frame_header_mode not in", values, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeBetween(String value1, String value2) {
            addCriterion("f_dtmb_frame_header_mode between", value1, value2, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbFrameHeaderModeNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_frame_header_mode not between", value1, value2, "fDtmbFrameHeaderMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeIsNull() {
            addCriterion("f_dtmb_interleaving_mode is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeIsNotNull() {
            addCriterion("f_dtmb_interleaving_mode is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeEqualTo(String value) {
            addCriterion("f_dtmb_interleaving_mode =", value, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeNotEqualTo(String value) {
            addCriterion("f_dtmb_interleaving_mode <>", value, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeGreaterThan(String value) {
            addCriterion("f_dtmb_interleaving_mode >", value, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_interleaving_mode >=", value, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeLessThan(String value) {
            addCriterion("f_dtmb_interleaving_mode <", value, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_interleaving_mode <=", value, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeLike(String value) {
            addCriterion("f_dtmb_interleaving_mode like", value, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeNotLike(String value) {
            addCriterion("f_dtmb_interleaving_mode not like", value, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeIn(List<String> values) {
            addCriterion("f_dtmb_interleaving_mode in", values, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeNotIn(List<String> values) {
            addCriterion("f_dtmb_interleaving_mode not in", values, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeBetween(String value1, String value2) {
            addCriterion("f_dtmb_interleaving_mode between", value1, value2, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbInterleavingModeNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_interleaving_mode not between", value1, value2, "fDtmbInterleavingMode");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagIsNull() {
            addCriterion("f_dtmb_other_frequency_flag is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagIsNotNull() {
            addCriterion("f_dtmb_other_frequency_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagEqualTo(String value) {
            addCriterion("f_dtmb_other_frequency_flag =", value, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagNotEqualTo(String value) {
            addCriterion("f_dtmb_other_frequency_flag <>", value, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagGreaterThan(String value) {
            addCriterion("f_dtmb_other_frequency_flag >", value, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_other_frequency_flag >=", value, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagLessThan(String value) {
            addCriterion("f_dtmb_other_frequency_flag <", value, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_other_frequency_flag <=", value, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagLike(String value) {
            addCriterion("f_dtmb_other_frequency_flag like", value, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagNotLike(String value) {
            addCriterion("f_dtmb_other_frequency_flag not like", value, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagIn(List<String> values) {
            addCriterion("f_dtmb_other_frequency_flag in", values, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagNotIn(List<String> values) {
            addCriterion("f_dtmb_other_frequency_flag not in", values, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagBetween(String value1, String value2) {
            addCriterion("f_dtmb_other_frequency_flag between", value1, value2, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbOtherFrequencyFlagNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_other_frequency_flag not between", value1, value2, "fDtmbOtherFrequencyFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagIsNull() {
            addCriterion("f_dtmb_sfn_mfn_flag is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagIsNotNull() {
            addCriterion("f_dtmb_sfn_mfn_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagEqualTo(String value) {
            addCriterion("f_dtmb_sfn_mfn_flag =", value, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagNotEqualTo(String value) {
            addCriterion("f_dtmb_sfn_mfn_flag <>", value, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagGreaterThan(String value) {
            addCriterion("f_dtmb_sfn_mfn_flag >", value, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_sfn_mfn_flag >=", value, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagLessThan(String value) {
            addCriterion("f_dtmb_sfn_mfn_flag <", value, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_sfn_mfn_flag <=", value, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagLike(String value) {
            addCriterion("f_dtmb_sfn_mfn_flag like", value, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagNotLike(String value) {
            addCriterion("f_dtmb_sfn_mfn_flag not like", value, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagIn(List<String> values) {
            addCriterion("f_dtmb_sfn_mfn_flag in", values, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagNotIn(List<String> values) {
            addCriterion("f_dtmb_sfn_mfn_flag not in", values, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagBetween(String value1, String value2) {
            addCriterion("f_dtmb_sfn_mfn_flag between", value1, value2, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDtmbSfnMfnFlagNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_sfn_mfn_flag not between", value1, value2, "fDtmbSfnMfnFlag");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyIsNull() {
            addCriterion("f_dvbc_frequency is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyIsNotNull() {
            addCriterion("f_dvbc_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyEqualTo(String value) {
            addCriterion("f_dvbc_frequency =", value, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyNotEqualTo(String value) {
            addCriterion("f_dvbc_frequency <>", value, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyGreaterThan(String value) {
            addCriterion("f_dvbc_frequency >", value, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("f_dvbc_frequency >=", value, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyLessThan(String value) {
            addCriterion("f_dvbc_frequency <", value, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyLessThanOrEqualTo(String value) {
            addCriterion("f_dvbc_frequency <=", value, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyLike(String value) {
            addCriterion("f_dvbc_frequency like", value, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyNotLike(String value) {
            addCriterion("f_dvbc_frequency not like", value, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyIn(List<String> values) {
            addCriterion("f_dvbc_frequency in", values, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyNotIn(List<String> values) {
            addCriterion("f_dvbc_frequency not in", values, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyBetween(String value1, String value2) {
            addCriterion("f_dvbc_frequency between", value1, value2, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFrequencyNotBetween(String value1, String value2) {
            addCriterion("f_dvbc_frequency not between", value1, value2, "fDvbcFrequency");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterIsNull() {
            addCriterion("f_dvbc_FEC_outer is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterIsNotNull() {
            addCriterion("f_dvbc_FEC_outer is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterEqualTo(String value) {
            addCriterion("f_dvbc_FEC_outer =", value, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterNotEqualTo(String value) {
            addCriterion("f_dvbc_FEC_outer <>", value, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterGreaterThan(String value) {
            addCriterion("f_dvbc_FEC_outer >", value, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterGreaterThanOrEqualTo(String value) {
            addCriterion("f_dvbc_FEC_outer >=", value, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterLessThan(String value) {
            addCriterion("f_dvbc_FEC_outer <", value, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterLessThanOrEqualTo(String value) {
            addCriterion("f_dvbc_FEC_outer <=", value, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterLike(String value) {
            addCriterion("f_dvbc_FEC_outer like", value, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterNotLike(String value) {
            addCriterion("f_dvbc_FEC_outer not like", value, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterIn(List<String> values) {
            addCriterion("f_dvbc_FEC_outer in", values, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterNotIn(List<String> values) {
            addCriterion("f_dvbc_FEC_outer not in", values, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterBetween(String value1, String value2) {
            addCriterion("f_dvbc_FEC_outer between", value1, value2, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecOuterNotBetween(String value1, String value2) {
            addCriterion("f_dvbc_FEC_outer not between", value1, value2, "fDvbcFecOuter");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerIsNull() {
            addCriterion("f_dvbc_FEC_inner is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerIsNotNull() {
            addCriterion("f_dvbc_FEC_inner is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerEqualTo(String value) {
            addCriterion("f_dvbc_FEC_inner =", value, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerNotEqualTo(String value) {
            addCriterion("f_dvbc_FEC_inner <>", value, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerGreaterThan(String value) {
            addCriterion("f_dvbc_FEC_inner >", value, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerGreaterThanOrEqualTo(String value) {
            addCriterion("f_dvbc_FEC_inner >=", value, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerLessThan(String value) {
            addCriterion("f_dvbc_FEC_inner <", value, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerLessThanOrEqualTo(String value) {
            addCriterion("f_dvbc_FEC_inner <=", value, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerLike(String value) {
            addCriterion("f_dvbc_FEC_inner like", value, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerNotLike(String value) {
            addCriterion("f_dvbc_FEC_inner not like", value, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerIn(List<String> values) {
            addCriterion("f_dvbc_FEC_inner in", values, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerNotIn(List<String> values) {
            addCriterion("f_dvbc_FEC_inner not in", values, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerBetween(String value1, String value2) {
            addCriterion("f_dvbc_FEC_inner between", value1, value2, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcFecInnerNotBetween(String value1, String value2) {
            addCriterion("f_dvbc_FEC_inner not between", value1, value2, "fDvbcFecInner");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationIsNull() {
            addCriterion("f_dvbc_modulation is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationIsNotNull() {
            addCriterion("f_dvbc_modulation is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationEqualTo(String value) {
            addCriterion("f_dvbc_modulation =", value, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationNotEqualTo(String value) {
            addCriterion("f_dvbc_modulation <>", value, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationGreaterThan(String value) {
            addCriterion("f_dvbc_modulation >", value, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationGreaterThanOrEqualTo(String value) {
            addCriterion("f_dvbc_modulation >=", value, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationLessThan(String value) {
            addCriterion("f_dvbc_modulation <", value, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationLessThanOrEqualTo(String value) {
            addCriterion("f_dvbc_modulation <=", value, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationLike(String value) {
            addCriterion("f_dvbc_modulation like", value, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationNotLike(String value) {
            addCriterion("f_dvbc_modulation not like", value, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationIn(List<String> values) {
            addCriterion("f_dvbc_modulation in", values, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationNotIn(List<String> values) {
            addCriterion("f_dvbc_modulation not in", values, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationBetween(String value1, String value2) {
            addCriterion("f_dvbc_modulation between", value1, value2, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationNotBetween(String value1, String value2) {
            addCriterion("f_dvbc_modulation not between", value1, value2, "fDvbcModulation");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateIsNull() {
            addCriterion("f_dvbc_symbol_rate is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateIsNotNull() {
            addCriterion("f_dvbc_symbol_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateEqualTo(String value) {
            addCriterion("f_dvbc_symbol_rate =", value, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateNotEqualTo(String value) {
            addCriterion("f_dvbc_symbol_rate <>", value, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateGreaterThan(String value) {
            addCriterion("f_dvbc_symbol_rate >", value, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateGreaterThanOrEqualTo(String value) {
            addCriterion("f_dvbc_symbol_rate >=", value, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateLessThan(String value) {
            addCriterion("f_dvbc_symbol_rate <", value, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateLessThanOrEqualTo(String value) {
            addCriterion("f_dvbc_symbol_rate <=", value, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateLike(String value) {
            addCriterion("f_dvbc_symbol_rate like", value, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateNotLike(String value) {
            addCriterion("f_dvbc_symbol_rate not like", value, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateIn(List<String> values) {
            addCriterion("f_dvbc_symbol_rate in", values, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateNotIn(List<String> values) {
            addCriterion("f_dvbc_symbol_rate not in", values, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateBetween(String value1, String value2) {
            addCriterion("f_dvbc_symbol_rate between", value1, value2, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolRateNotBetween(String value1, String value2) {
            addCriterion("f_dvbc_symbol_rate not between", value1, value2, "fDvbcSymbolRate");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterIsNull() {
            addCriterion("f_dtmb_modulation_parameter is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterIsNotNull() {
            addCriterion("f_dtmb_modulation_parameter is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterEqualTo(String value) {
            addCriterion("f_dtmb_modulation_parameter =", value, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterNotEqualTo(String value) {
            addCriterion("f_dtmb_modulation_parameter <>", value, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterGreaterThan(String value) {
            addCriterion("f_dtmb_modulation_parameter >", value, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_modulation_parameter >=", value, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterLessThan(String value) {
            addCriterion("f_dtmb_modulation_parameter <", value, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_modulation_parameter <=", value, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterLike(String value) {
            addCriterion("f_dtmb_modulation_parameter like", value, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterNotLike(String value) {
            addCriterion("f_dtmb_modulation_parameter not like", value, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterIn(List<String> values) {
            addCriterion("f_dtmb_modulation_parameter in", values, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterNotIn(List<String> values) {
            addCriterion("f_dtmb_modulation_parameter not in", values, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterBetween(String value1, String value2) {
            addCriterion("f_dtmb_modulation_parameter between", value1, value2, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDtmbModulationParameterNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_modulation_parameter not between", value1, value2, "fDtmbModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterIsNull() {
            addCriterion("f_dvbc_modulation_parameter is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterIsNotNull() {
            addCriterion("f_dvbc_modulation_parameter is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterEqualTo(String value) {
            addCriterion("f_dvbc_modulation_parameter =", value, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterNotEqualTo(String value) {
            addCriterion("f_dvbc_modulation_parameter <>", value, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterGreaterThan(String value) {
            addCriterion("f_dvbc_modulation_parameter >", value, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterGreaterThanOrEqualTo(String value) {
            addCriterion("f_dvbc_modulation_parameter >=", value, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterLessThan(String value) {
            addCriterion("f_dvbc_modulation_parameter <", value, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterLessThanOrEqualTo(String value) {
            addCriterion("f_dvbc_modulation_parameter <=", value, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterLike(String value) {
            addCriterion("f_dvbc_modulation_parameter like", value, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterNotLike(String value) {
            addCriterion("f_dvbc_modulation_parameter not like", value, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterIn(List<String> values) {
            addCriterion("f_dvbc_modulation_parameter in", values, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterNotIn(List<String> values) {
            addCriterion("f_dvbc_modulation_parameter not in", values, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterBetween(String value1, String value2) {
            addCriterion("f_dvbc_modulation_parameter between", value1, value2, "fDvbcModulationParameter");
            return (Criteria) this;
        }

        public Criteria andFDvbcModulationParameterNotBetween(String value1, String value2) {
            addCriterion("f_dvbc_modulation_parameter not between", value1, value2, "fDvbcModulationParameter");
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