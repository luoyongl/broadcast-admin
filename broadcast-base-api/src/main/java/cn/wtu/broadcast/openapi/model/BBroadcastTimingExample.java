package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BBroadcastTimingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBroadcastTimingExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andFPlanNameIsNull() {
            addCriterion("f_plan_name is null");
            return (Criteria) this;
        }

        public Criteria andFPlanNameIsNotNull() {
            addCriterion("f_plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andFPlanNameEqualTo(String value) {
            addCriterion("f_plan_name =", value, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameNotEqualTo(String value) {
            addCriterion("f_plan_name <>", value, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameGreaterThan(String value) {
            addCriterion("f_plan_name >", value, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_plan_name >=", value, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameLessThan(String value) {
            addCriterion("f_plan_name <", value, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameLessThanOrEqualTo(String value) {
            addCriterion("f_plan_name <=", value, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameLike(String value) {
            addCriterion("f_plan_name like", value, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameNotLike(String value) {
            addCriterion("f_plan_name not like", value, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameIn(List<String> values) {
            addCriterion("f_plan_name in", values, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameNotIn(List<String> values) {
            addCriterion("f_plan_name not in", values, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameBetween(String value1, String value2) {
            addCriterion("f_plan_name between", value1, value2, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFPlanNameNotBetween(String value1, String value2) {
            addCriterion("f_plan_name not between", value1, value2, "fPlanName");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeIsNull() {
            addCriterion("f_message_type is null");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeIsNotNull() {
            addCriterion("f_message_type is not null");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeEqualTo(Integer value) {
            addCriterion("f_message_type =", value, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeNotEqualTo(Integer value) {
            addCriterion("f_message_type <>", value, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeGreaterThan(Integer value) {
            addCriterion("f_message_type >", value, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_message_type >=", value, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeLessThan(Integer value) {
            addCriterion("f_message_type <", value, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("f_message_type <=", value, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeIn(List<Integer> values) {
            addCriterion("f_message_type in", values, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeNotIn(List<Integer> values) {
            addCriterion("f_message_type not in", values, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeBetween(Integer value1, Integer value2) {
            addCriterion("f_message_type between", value1, value2, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFMessageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_message_type not between", value1, value2, "fMessageType");
            return (Criteria) this;
        }

        public Criteria andFVolumeIsNull() {
            addCriterion("f_volume is null");
            return (Criteria) this;
        }

        public Criteria andFVolumeIsNotNull() {
            addCriterion("f_volume is not null");
            return (Criteria) this;
        }

        public Criteria andFVolumeEqualTo(Integer value) {
            addCriterion("f_volume =", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeNotEqualTo(Integer value) {
            addCriterion("f_volume <>", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeGreaterThan(Integer value) {
            addCriterion("f_volume >", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_volume >=", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeLessThan(Integer value) {
            addCriterion("f_volume <", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("f_volume <=", value, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeIn(List<Integer> values) {
            addCriterion("f_volume in", values, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeNotIn(List<Integer> values) {
            addCriterion("f_volume not in", values, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeBetween(Integer value1, Integer value2) {
            addCriterion("f_volume between", value1, value2, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_volume not between", value1, value2, "fVolume");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelIsNull() {
            addCriterion("f_message_level is null");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelIsNotNull() {
            addCriterion("f_message_level is not null");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelEqualTo(Integer value) {
            addCriterion("f_message_level =", value, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelNotEqualTo(Integer value) {
            addCriterion("f_message_level <>", value, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelGreaterThan(Integer value) {
            addCriterion("f_message_level >", value, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_message_level >=", value, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelLessThan(Integer value) {
            addCriterion("f_message_level <", value, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelLessThanOrEqualTo(Integer value) {
            addCriterion("f_message_level <=", value, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelIn(List<Integer> values) {
            addCriterion("f_message_level in", values, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelNotIn(List<Integer> values) {
            addCriterion("f_message_level not in", values, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelBetween(Integer value1, Integer value2) {
            addCriterion("f_message_level between", value1, value2, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFMessageLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("f_message_level not between", value1, value2, "fMessageLevel");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryIsNull() {
            addCriterion("f_drill_category is null");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryIsNotNull() {
            addCriterion("f_drill_category is not null");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryEqualTo(Integer value) {
            addCriterion("f_drill_category =", value, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryNotEqualTo(Integer value) {
            addCriterion("f_drill_category <>", value, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryGreaterThan(Integer value) {
            addCriterion("f_drill_category >", value, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_drill_category >=", value, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryLessThan(Integer value) {
            addCriterion("f_drill_category <", value, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("f_drill_category <=", value, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryIn(List<Integer> values) {
            addCriterion("f_drill_category in", values, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryNotIn(List<Integer> values) {
            addCriterion("f_drill_category not in", values, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryBetween(Integer value1, Integer value2) {
            addCriterion("f_drill_category between", value1, value2, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFDrillCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("f_drill_category not between", value1, value2, "fDrillCategory");
            return (Criteria) this;
        }

        public Criteria andFAudioFileIsNull() {
            addCriterion("f_audio_file is null");
            return (Criteria) this;
        }

        public Criteria andFAudioFileIsNotNull() {
            addCriterion("f_audio_file is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioFileEqualTo(String value) {
            addCriterion("f_audio_file =", value, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileNotEqualTo(String value) {
            addCriterion("f_audio_file <>", value, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileGreaterThan(String value) {
            addCriterion("f_audio_file >", value, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileGreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_file >=", value, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileLessThan(String value) {
            addCriterion("f_audio_file <", value, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileLessThanOrEqualTo(String value) {
            addCriterion("f_audio_file <=", value, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileLike(String value) {
            addCriterion("f_audio_file like", value, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileNotLike(String value) {
            addCriterion("f_audio_file not like", value, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileIn(List<String> values) {
            addCriterion("f_audio_file in", values, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileNotIn(List<String> values) {
            addCriterion("f_audio_file not in", values, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileBetween(String value1, String value2) {
            addCriterion("f_audio_file between", value1, value2, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFAudioFileNotBetween(String value1, String value2) {
            addCriterion("f_audio_file not between", value1, value2, "fAudioFile");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioIsNull() {
            addCriterion("f_frequent_audio is null");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioIsNotNull() {
            addCriterion("f_frequent_audio is not null");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioEqualTo(Integer value) {
            addCriterion("f_frequent_audio =", value, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioNotEqualTo(Integer value) {
            addCriterion("f_frequent_audio <>", value, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioGreaterThan(Integer value) {
            addCriterion("f_frequent_audio >", value, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_frequent_audio >=", value, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioLessThan(Integer value) {
            addCriterion("f_frequent_audio <", value, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioLessThanOrEqualTo(Integer value) {
            addCriterion("f_frequent_audio <=", value, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioIn(List<Integer> values) {
            addCriterion("f_frequent_audio in", values, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioNotIn(List<Integer> values) {
            addCriterion("f_frequent_audio not in", values, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioBetween(Integer value1, Integer value2) {
            addCriterion("f_frequent_audio between", value1, value2, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFFrequentAudioNotBetween(Integer value1, Integer value2) {
            addCriterion("f_frequent_audio not between", value1, value2, "fFrequentAudio");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaIsNull() {
            addCriterion("f_broadcast_area is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaIsNotNull() {
            addCriterion("f_broadcast_area is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaEqualTo(String value) {
            addCriterion("f_broadcast_area =", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotEqualTo(String value) {
            addCriterion("f_broadcast_area <>", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaGreaterThan(String value) {
            addCriterion("f_broadcast_area >", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaGreaterThanOrEqualTo(String value) {
            addCriterion("f_broadcast_area >=", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaLessThan(String value) {
            addCriterion("f_broadcast_area <", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaLessThanOrEqualTo(String value) {
            addCriterion("f_broadcast_area <=", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaLike(String value) {
            addCriterion("f_broadcast_area like", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotLike(String value) {
            addCriterion("f_broadcast_area not like", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaIn(List<String> values) {
            addCriterion("f_broadcast_area in", values, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotIn(List<String> values) {
            addCriterion("f_broadcast_area not in", values, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaBetween(String value1, String value2) {
            addCriterion("f_broadcast_area between", value1, value2, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotBetween(String value1, String value2) {
            addCriterion("f_broadcast_area not between", value1, value2, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFStartDateIsNull() {
            addCriterion("f_start_date is null");
            return (Criteria) this;
        }

        public Criteria andFStartDateIsNotNull() {
            addCriterion("f_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andFStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("f_start_date =", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("f_start_date <>", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("f_start_date >", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_start_date >=", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateLessThan(Date value) {
            addCriterionForJDBCDate("f_start_date <", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_start_date <=", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("f_start_date in", values, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("f_start_date not in", values, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_start_date between", value1, value2, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_start_date not between", value1, value2, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateIsNull() {
            addCriterion("f_end_date is null");
            return (Criteria) this;
        }

        public Criteria andFEndDateIsNotNull() {
            addCriterion("f_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andFEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("f_end_date =", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("f_end_date <>", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("f_end_date >", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_end_date >=", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateLessThan(Date value) {
            addCriterionForJDBCDate("f_end_date <", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_end_date <=", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("f_end_date in", values, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("f_end_date not in", values, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_end_date between", value1, value2, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_end_date not between", value1, value2, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekIsNull() {
            addCriterion("f_choose_week is null");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekIsNotNull() {
            addCriterion("f_choose_week is not null");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekEqualTo(String value) {
            addCriterion("f_choose_week =", value, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekNotEqualTo(String value) {
            addCriterion("f_choose_week <>", value, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekGreaterThan(String value) {
            addCriterion("f_choose_week >", value, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekGreaterThanOrEqualTo(String value) {
            addCriterion("f_choose_week >=", value, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekLessThan(String value) {
            addCriterion("f_choose_week <", value, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekLessThanOrEqualTo(String value) {
            addCriterion("f_choose_week <=", value, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekLike(String value) {
            addCriterion("f_choose_week like", value, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekNotLike(String value) {
            addCriterion("f_choose_week not like", value, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekIn(List<String> values) {
            addCriterion("f_choose_week in", values, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekNotIn(List<String> values) {
            addCriterion("f_choose_week not in", values, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekBetween(String value1, String value2) {
            addCriterion("f_choose_week between", value1, value2, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFChooseWeekNotBetween(String value1, String value2) {
            addCriterion("f_choose_week not between", value1, value2, "fChooseWeek");
            return (Criteria) this;
        }

        public Criteria andFStartTimeIsNull() {
            addCriterion("f_start_time is null");
            return (Criteria) this;
        }

        public Criteria andFStartTimeIsNotNull() {
            addCriterion("f_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andFStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("f_start_time =", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("f_start_time <>", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("f_start_time >", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_start_time >=", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("f_start_time <", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_start_time <=", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("f_start_time in", values, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("f_start_time not in", values, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_start_time between", value1, value2, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_start_time not between", value1, value2, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeIsNull() {
            addCriterion("f_end_time is null");
            return (Criteria) this;
        }

        public Criteria andFEndTimeIsNotNull() {
            addCriterion("f_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andFEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("f_end_time =", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("f_end_time <>", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("f_end_time >", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_end_time >=", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("f_end_time <", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_end_time <=", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("f_end_time in", values, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("f_end_time not in", values, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_end_time between", value1, value2, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_end_time not between", value1, value2, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalIsNull() {
            addCriterion("f_time_interval is null");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalIsNotNull() {
            addCriterion("f_time_interval is not null");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalEqualTo(Integer value) {
            addCriterion("f_time_interval =", value, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalNotEqualTo(Integer value) {
            addCriterion("f_time_interval <>", value, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalGreaterThan(Integer value) {
            addCriterion("f_time_interval >", value, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_time_interval >=", value, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalLessThan(Integer value) {
            addCriterion("f_time_interval <", value, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("f_time_interval <=", value, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalIn(List<Integer> values) {
            addCriterion("f_time_interval in", values, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalNotIn(List<Integer> values) {
            addCriterion("f_time_interval not in", values, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalBetween(Integer value1, Integer value2) {
            addCriterion("f_time_interval between", value1, value2, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFTimeIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("f_time_interval not between", value1, value2, "fTimeInterval");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeIsNull() {
            addCriterion("f_single_broadcast_time is null");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeIsNotNull() {
            addCriterion("f_single_broadcast_time is not null");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeEqualTo(Date value) {
            addCriterion("f_single_broadcast_time =", value, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeNotEqualTo(Date value) {
            addCriterion("f_single_broadcast_time <>", value, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeGreaterThan(Date value) {
            addCriterion("f_single_broadcast_time >", value, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_single_broadcast_time >=", value, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeLessThan(Date value) {
            addCriterion("f_single_broadcast_time <", value, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_single_broadcast_time <=", value, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeIn(List<Date> values) {
            addCriterion("f_single_broadcast_time in", values, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeNotIn(List<Date> values) {
            addCriterion("f_single_broadcast_time not in", values, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeBetween(Date value1, Date value2) {
            addCriterion("f_single_broadcast_time between", value1, value2, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFSingleBroadcastTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_single_broadcast_time not between", value1, value2, "fSingleBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeIsNull() {
            addCriterion("f_repeate_time is null");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeIsNotNull() {
            addCriterion("f_repeate_time is not null");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeEqualTo(Integer value) {
            addCriterion("f_repeate_time =", value, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeNotEqualTo(Integer value) {
            addCriterion("f_repeate_time <>", value, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeGreaterThan(Integer value) {
            addCriterion("f_repeate_time >", value, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_repeate_time >=", value, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeLessThan(Integer value) {
            addCriterion("f_repeate_time <", value, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("f_repeate_time <=", value, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeIn(List<Integer> values) {
            addCriterion("f_repeate_time in", values, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeNotIn(List<Integer> values) {
            addCriterion("f_repeate_time not in", values, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeBetween(Integer value1, Integer value2) {
            addCriterion("f_repeate_time between", value1, value2, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFRepeateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_repeate_time not between", value1, value2, "fRepeateTime");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceIsNull() {
            addCriterion("f_control_device is null");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceIsNotNull() {
            addCriterion("f_control_device is not null");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceEqualTo(Integer value) {
            addCriterion("f_control_device =", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceNotEqualTo(Integer value) {
            addCriterion("f_control_device <>", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceGreaterThan(Integer value) {
            addCriterion("f_control_device >", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_control_device >=", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceLessThan(Integer value) {
            addCriterion("f_control_device <", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceLessThanOrEqualTo(Integer value) {
            addCriterion("f_control_device <=", value, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceIn(List<Integer> values) {
            addCriterion("f_control_device in", values, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceNotIn(List<Integer> values) {
            addCriterion("f_control_device not in", values, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceBetween(Integer value1, Integer value2) {
            addCriterion("f_control_device between", value1, value2, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFControlDeviceNotBetween(Integer value1, Integer value2) {
            addCriterion("f_control_device not between", value1, value2, "fControlDevice");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelIsNull() {
            addCriterion("f_device_channel is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelIsNotNull() {
            addCriterion("f_device_channel is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelEqualTo(Integer value) {
            addCriterion("f_device_channel =", value, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNotEqualTo(Integer value) {
            addCriterion("f_device_channel <>", value, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelGreaterThan(Integer value) {
            addCriterion("f_device_channel >", value, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_device_channel >=", value, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelLessThan(Integer value) {
            addCriterion("f_device_channel <", value, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelLessThanOrEqualTo(Integer value) {
            addCriterion("f_device_channel <=", value, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelIn(List<Integer> values) {
            addCriterion("f_device_channel in", values, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNotIn(List<Integer> values) {
            addCriterion("f_device_channel not in", values, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelBetween(Integer value1, Integer value2) {
            addCriterion("f_device_channel between", value1, value2, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("f_device_channel not between", value1, value2, "fDeviceChannel");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToIsNull() {
            addCriterion("f_broadcast_to is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToIsNotNull() {
            addCriterion("f_broadcast_to is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToEqualTo(String value) {
            addCriterion("f_broadcast_to =", value, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToNotEqualTo(String value) {
            addCriterion("f_broadcast_to <>", value, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToGreaterThan(String value) {
            addCriterion("f_broadcast_to >", value, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToGreaterThanOrEqualTo(String value) {
            addCriterion("f_broadcast_to >=", value, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToLessThan(String value) {
            addCriterion("f_broadcast_to <", value, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToLessThanOrEqualTo(String value) {
            addCriterion("f_broadcast_to <=", value, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToLike(String value) {
            addCriterion("f_broadcast_to like", value, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToNotLike(String value) {
            addCriterion("f_broadcast_to not like", value, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToIn(List<String> values) {
            addCriterion("f_broadcast_to in", values, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToNotIn(List<String> values) {
            addCriterion("f_broadcast_to not in", values, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToBetween(String value1, String value2) {
            addCriterion("f_broadcast_to between", value1, value2, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFBroadcastToNotBetween(String value1, String value2) {
            addCriterion("f_broadcast_to not between", value1, value2, "fBroadcastTo");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceIsNull() {
            addCriterion("f_message_source is null");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceIsNotNull() {
            addCriterion("f_message_source is not null");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceEqualTo(Integer value) {
            addCriterion("f_message_source =", value, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceNotEqualTo(Integer value) {
            addCriterion("f_message_source <>", value, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceGreaterThan(Integer value) {
            addCriterion("f_message_source >", value, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_message_source >=", value, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceLessThan(Integer value) {
            addCriterion("f_message_source <", value, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceLessThanOrEqualTo(Integer value) {
            addCriterion("f_message_source <=", value, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceIn(List<Integer> values) {
            addCriterion("f_message_source in", values, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceNotIn(List<Integer> values) {
            addCriterion("f_message_source not in", values, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceBetween(Integer value1, Integer value2) {
            addCriterion("f_message_source between", value1, value2, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFMessageSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("f_message_source not between", value1, value2, "fMessageSource");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeIsNull() {
            addCriterion("f_last_broadcast_time is null");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeIsNotNull() {
            addCriterion("f_last_broadcast_time is not null");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeEqualTo(Date value) {
            addCriterion("f_last_broadcast_time =", value, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeNotEqualTo(Date value) {
            addCriterion("f_last_broadcast_time <>", value, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeGreaterThan(Date value) {
            addCriterion("f_last_broadcast_time >", value, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_last_broadcast_time >=", value, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeLessThan(Date value) {
            addCriterion("f_last_broadcast_time <", value, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_last_broadcast_time <=", value, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeIn(List<Date> values) {
            addCriterion("f_last_broadcast_time in", values, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeNotIn(List<Date> values) {
            addCriterion("f_last_broadcast_time not in", values, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeBetween(Date value1, Date value2) {
            addCriterion("f_last_broadcast_time between", value1, value2, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFLastBroadcastTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_last_broadcast_time not between", value1, value2, "fLastBroadcastTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesIsNull() {
            addCriterion("f_broadcasted_times is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesIsNotNull() {
            addCriterion("f_broadcasted_times is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesEqualTo(Integer value) {
            addCriterion("f_broadcasted_times =", value, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesNotEqualTo(Integer value) {
            addCriterion("f_broadcasted_times <>", value, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesGreaterThan(Integer value) {
            addCriterion("f_broadcasted_times >", value, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_broadcasted_times >=", value, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesLessThan(Integer value) {
            addCriterion("f_broadcasted_times <", value, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesLessThanOrEqualTo(Integer value) {
            addCriterion("f_broadcasted_times <=", value, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesIn(List<Integer> values) {
            addCriterion("f_broadcasted_times in", values, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesNotIn(List<Integer> values) {
            addCriterion("f_broadcasted_times not in", values, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesBetween(Integer value1, Integer value2) {
            addCriterion("f_broadcasted_times between", value1, value2, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFBroadcastedTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("f_broadcasted_times not between", value1, value2, "fBroadcastedTimes");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagIsNull() {
            addCriterion("f_review_flag is null");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagIsNotNull() {
            addCriterion("f_review_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagEqualTo(Byte value) {
            addCriterion("f_review_flag =", value, "fReviewFlag");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagNotEqualTo(Byte value) {
            addCriterion("f_review_flag <>", value, "fReviewFlag");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagGreaterThan(Byte value) {
            addCriterion("f_review_flag >", value, "fReviewFlag");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_review_flag >=", value, "fReviewFlag");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagLessThan(Byte value) {
            addCriterion("f_review_flag <", value, "fReviewFlag");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagLessThanOrEqualTo(Byte value) {
            addCriterion("f_review_flag <=", value, "fReviewFlag");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagIn(List<Byte> values) {
            addCriterion("f_review_flag in", values, "fReviewFlag");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagNotIn(List<Byte> values) {
            addCriterion("f_review_flag not in", values, "fReviewFlag");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagBetween(Byte value1, Byte value2) {
            addCriterion("f_review_flag between", value1, value2, "fReviewFlag");
            return (Criteria) this;
        }

        public Criteria andFReviewFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("f_review_flag not between", value1, value2, "fReviewFlag");
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

        public Criteria andFBeginTimeIsNull() {
            addCriterion("f_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeIsNotNull() {
            addCriterion("f_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeEqualTo(Date value) {
            addCriterion("f_begin_time =", value, "fBeginTime");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeNotEqualTo(Date value) {
            addCriterion("f_begin_time <>", value, "fBeginTime");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeGreaterThan(Date value) {
            addCriterion("f_begin_time >", value, "fBeginTime");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_begin_time >=", value, "fBeginTime");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeLessThan(Date value) {
            addCriterion("f_begin_time <", value, "fBeginTime");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_begin_time <=", value, "fBeginTime");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeIn(List<Date> values) {
            addCriterion("f_begin_time in", values, "fBeginTime");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeNotIn(List<Date> values) {
            addCriterion("f_begin_time not in", values, "fBeginTime");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeBetween(Date value1, Date value2) {
            addCriterion("f_begin_time between", value1, value2, "fBeginTime");
            return (Criteria) this;
        }

        public Criteria andFBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_begin_time not between", value1, value2, "fBeginTime");
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