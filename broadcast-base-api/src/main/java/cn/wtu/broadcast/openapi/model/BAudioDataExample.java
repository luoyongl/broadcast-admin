package cn.wtu.broadcast.openapi.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BAudioDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BAudioDataExample() {
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

        public Criteria andFAudioNameIsNull() {
            addCriterion("f_audio_name is null");
            return (Criteria) this;
        }

        public Criteria andFAudioNameIsNotNull() {
            addCriterion("f_audio_name is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioNameEqualTo(String value) {
            addCriterion("f_audio_name =", value, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameNotEqualTo(String value) {
            addCriterion("f_audio_name <>", value, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameGreaterThan(String value) {
            addCriterion("f_audio_name >", value, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_name >=", value, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameLessThan(String value) {
            addCriterion("f_audio_name <", value, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameLessThanOrEqualTo(String value) {
            addCriterion("f_audio_name <=", value, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameLike(String value) {
            addCriterion("f_audio_name like", value, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameNotLike(String value) {
            addCriterion("f_audio_name not like", value, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameIn(List<String> values) {
            addCriterion("f_audio_name in", values, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameNotIn(List<String> values) {
            addCriterion("f_audio_name not in", values, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameBetween(String value1, String value2) {
            addCriterion("f_audio_name between", value1, value2, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioNameNotBetween(String value1, String value2) {
            addCriterion("f_audio_name not between", value1, value2, "fAudioName");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeIsNull() {
            addCriterion("f_audio_size is null");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeIsNotNull() {
            addCriterion("f_audio_size is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeEqualTo(String value) {
            addCriterion("f_audio_size =", value, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeNotEqualTo(String value) {
            addCriterion("f_audio_size <>", value, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeGreaterThan(String value) {
            addCriterion("f_audio_size >", value, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeGreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_size >=", value, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeLessThan(String value) {
            addCriterion("f_audio_size <", value, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeLessThanOrEqualTo(String value) {
            addCriterion("f_audio_size <=", value, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeLike(String value) {
            addCriterion("f_audio_size like", value, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeNotLike(String value) {
            addCriterion("f_audio_size not like", value, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeIn(List<String> values) {
            addCriterion("f_audio_size in", values, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeNotIn(List<String> values) {
            addCriterion("f_audio_size not in", values, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeBetween(String value1, String value2) {
            addCriterion("f_audio_size between", value1, value2, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioSizeNotBetween(String value1, String value2) {
            addCriterion("f_audio_size not between", value1, value2, "fAudioSize");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlIsNull() {
            addCriterion("f_audio_url is null");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlIsNotNull() {
            addCriterion("f_audio_url is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlEqualTo(String value) {
            addCriterion("f_audio_url =", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlNotEqualTo(String value) {
            addCriterion("f_audio_url <>", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlGreaterThan(String value) {
            addCriterion("f_audio_url >", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlGreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_url >=", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlLessThan(String value) {
            addCriterion("f_audio_url <", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlLessThanOrEqualTo(String value) {
            addCriterion("f_audio_url <=", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlLike(String value) {
            addCriterion("f_audio_url like", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlNotLike(String value) {
            addCriterion("f_audio_url not like", value, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlIn(List<String> values) {
            addCriterion("f_audio_url in", values, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlNotIn(List<String> values) {
            addCriterion("f_audio_url not in", values, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlBetween(String value1, String value2) {
            addCriterion("f_audio_url between", value1, value2, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFAudioUrlNotBetween(String value1, String value2) {
            addCriterion("f_audio_url not between", value1, value2, "fAudioUrl");
            return (Criteria) this;
        }

        public Criteria andFTimeIsNull() {
            addCriterion("f_time is null");
            return (Criteria) this;
        }

        public Criteria andFTimeIsNotNull() {
            addCriterion("f_time is not null");
            return (Criteria) this;
        }

        public Criteria andFTimeEqualTo(Integer value) {
            addCriterion("f_time =", value, "fTime");
            return (Criteria) this;
        }

        public Criteria andFTimeNotEqualTo(Integer value) {
            addCriterion("f_time <>", value, "fTime");
            return (Criteria) this;
        }

        public Criteria andFTimeGreaterThan(Integer value) {
            addCriterion("f_time >", value, "fTime");
            return (Criteria) this;
        }

        public Criteria andFTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_time >=", value, "fTime");
            return (Criteria) this;
        }

        public Criteria andFTimeLessThan(Integer value) {
            addCriterion("f_time <", value, "fTime");
            return (Criteria) this;
        }

        public Criteria andFTimeLessThanOrEqualTo(Integer value) {
            addCriterion("f_time <=", value, "fTime");
            return (Criteria) this;
        }

        public Criteria andFTimeIn(List<Integer> values) {
            addCriterion("f_time in", values, "fTime");
            return (Criteria) this;
        }

        public Criteria andFTimeNotIn(List<Integer> values) {
            addCriterion("f_time not in", values, "fTime");
            return (Criteria) this;
        }

        public Criteria andFTimeBetween(Integer value1, Integer value2) {
            addCriterion("f_time between", value1, value2, "fTime");
            return (Criteria) this;
        }

        public Criteria andFTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_time not between", value1, value2, "fTime");
            return (Criteria) this;
        }

        public Criteria andFBitRateIsNull() {
            addCriterion("f_bit_rate is null");
            return (Criteria) this;
        }

        public Criteria andFBitRateIsNotNull() {
            addCriterion("f_bit_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFBitRateEqualTo(Integer value) {
            addCriterion("f_bit_rate =", value, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFBitRateNotEqualTo(Integer value) {
            addCriterion("f_bit_rate <>", value, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFBitRateGreaterThan(Integer value) {
            addCriterion("f_bit_rate >", value, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFBitRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_bit_rate >=", value, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFBitRateLessThan(Integer value) {
            addCriterion("f_bit_rate <", value, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFBitRateLessThanOrEqualTo(Integer value) {
            addCriterion("f_bit_rate <=", value, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFBitRateIn(List<Integer> values) {
            addCriterion("f_bit_rate in", values, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFBitRateNotIn(List<Integer> values) {
            addCriterion("f_bit_rate not in", values, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFBitRateBetween(Integer value1, Integer value2) {
            addCriterion("f_bit_rate between", value1, value2, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFBitRateNotBetween(Integer value1, Integer value2) {
            addCriterion("f_bit_rate not between", value1, value2, "fBitRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateIsNull() {
            addCriterion("f_sample_rate is null");
            return (Criteria) this;
        }

        public Criteria andFSampleRateIsNotNull() {
            addCriterion("f_sample_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFSampleRateEqualTo(BigDecimal value) {
            addCriterion("f_sample_rate =", value, "fSampleRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateNotEqualTo(BigDecimal value) {
            addCriterion("f_sample_rate <>", value, "fSampleRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateGreaterThan(BigDecimal value) {
            addCriterion("f_sample_rate >", value, "fSampleRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("f_sample_rate >=", value, "fSampleRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateLessThan(BigDecimal value) {
            addCriterion("f_sample_rate <", value, "fSampleRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("f_sample_rate <=", value, "fSampleRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateIn(List<BigDecimal> values) {
            addCriterion("f_sample_rate in", values, "fSampleRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateNotIn(List<BigDecimal> values) {
            addCriterion("f_sample_rate not in", values, "fSampleRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("f_sample_rate between", value1, value2, "fSampleRate");
            return (Criteria) this;
        }

        public Criteria andFSampleRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("f_sample_rate not between", value1, value2, "fSampleRate");
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