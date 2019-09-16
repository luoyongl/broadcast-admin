package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BBroadcastDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBroadcastDataExample() {
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

        public Criteria andFBroadcastNameIsNull() {
            addCriterion("f_broadcast_name is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameIsNotNull() {
            addCriterion("f_broadcast_name is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameEqualTo(String value) {
            addCriterion("f_broadcast_name =", value, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameNotEqualTo(String value) {
            addCriterion("f_broadcast_name <>", value, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameGreaterThan(String value) {
            addCriterion("f_broadcast_name >", value, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_broadcast_name >=", value, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameLessThan(String value) {
            addCriterion("f_broadcast_name <", value, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameLessThanOrEqualTo(String value) {
            addCriterion("f_broadcast_name <=", value, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameLike(String value) {
            addCriterion("f_broadcast_name like", value, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameNotLike(String value) {
            addCriterion("f_broadcast_name not like", value, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameIn(List<String> values) {
            addCriterion("f_broadcast_name in", values, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameNotIn(List<String> values) {
            addCriterion("f_broadcast_name not in", values, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameBetween(String value1, String value2) {
            addCriterion("f_broadcast_name between", value1, value2, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastNameNotBetween(String value1, String value2) {
            addCriterion("f_broadcast_name not between", value1, value2, "fBroadcastName");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeIsNull() {
            addCriterion("f_broadcast_type is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeIsNotNull() {
            addCriterion("f_broadcast_type is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeEqualTo(Byte value) {
            addCriterion("f_broadcast_type =", value, "fBroadcastType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeNotEqualTo(Byte value) {
            addCriterion("f_broadcast_type <>", value, "fBroadcastType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeGreaterThan(Byte value) {
            addCriterion("f_broadcast_type >", value, "fBroadcastType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_broadcast_type >=", value, "fBroadcastType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeLessThan(Byte value) {
            addCriterion("f_broadcast_type <", value, "fBroadcastType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_broadcast_type <=", value, "fBroadcastType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeIn(List<Byte> values) {
            addCriterion("f_broadcast_type in", values, "fBroadcastType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeNotIn(List<Byte> values) {
            addCriterion("f_broadcast_type not in", values, "fBroadcastType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_broadcast_type between", value1, value2, "fBroadcastType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_broadcast_type not between", value1, value2, "fBroadcastType");
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

        public Criteria andFDeviceResourcecodeIsNull() {
            addCriterion("f_device_resourcecode is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeIsNotNull() {
            addCriterion("f_device_resourcecode is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeEqualTo(String value) {
            addCriterion("f_device_resourcecode =", value, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeNotEqualTo(String value) {
            addCriterion("f_device_resourcecode <>", value, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeGreaterThan(String value) {
            addCriterion("f_device_resourcecode >", value, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_resourcecode >=", value, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeLessThan(String value) {
            addCriterion("f_device_resourcecode <", value, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeLessThanOrEqualTo(String value) {
            addCriterion("f_device_resourcecode <=", value, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeLike(String value) {
            addCriterion("f_device_resourcecode like", value, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeNotLike(String value) {
            addCriterion("f_device_resourcecode not like", value, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeIn(List<String> values) {
            addCriterion("f_device_resourcecode in", values, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeNotIn(List<String> values) {
            addCriterion("f_device_resourcecode not in", values, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeBetween(String value1, String value2) {
            addCriterion("f_device_resourcecode between", value1, value2, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourcecodeNotBetween(String value1, String value2) {
            addCriterion("f_device_resourcecode not between", value1, value2, "fDeviceResourcecode");
            return (Criteria) this;
        }

        public Criteria andFProgramPassIsNull() {
            addCriterion("f_program_pass is null");
            return (Criteria) this;
        }

        public Criteria andFProgramPassIsNotNull() {
            addCriterion("f_program_pass is not null");
            return (Criteria) this;
        }

        public Criteria andFProgramPassEqualTo(String value) {
            addCriterion("f_program_pass =", value, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassNotEqualTo(String value) {
            addCriterion("f_program_pass <>", value, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassGreaterThan(String value) {
            addCriterion("f_program_pass >", value, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassGreaterThanOrEqualTo(String value) {
            addCriterion("f_program_pass >=", value, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassLessThan(String value) {
            addCriterion("f_program_pass <", value, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassLessThanOrEqualTo(String value) {
            addCriterion("f_program_pass <=", value, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassLike(String value) {
            addCriterion("f_program_pass like", value, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassNotLike(String value) {
            addCriterion("f_program_pass not like", value, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassIn(List<String> values) {
            addCriterion("f_program_pass in", values, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassNotIn(List<String> values) {
            addCriterion("f_program_pass not in", values, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassBetween(String value1, String value2) {
            addCriterion("f_program_pass between", value1, value2, "fProgramPass");
            return (Criteria) this;
        }

        public Criteria andFProgramPassNotBetween(String value1, String value2) {
            addCriterion("f_program_pass not between", value1, value2, "fProgramPass");
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

        public Criteria andFVolumeControlIsNull() {
            addCriterion("f_volume_control is null");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlIsNotNull() {
            addCriterion("f_volume_control is not null");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlEqualTo(Byte value) {
            addCriterion("f_volume_control =", value, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlNotEqualTo(Byte value) {
            addCriterion("f_volume_control <>", value, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlGreaterThan(Byte value) {
            addCriterion("f_volume_control >", value, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_volume_control >=", value, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlLessThan(Byte value) {
            addCriterion("f_volume_control <", value, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlLessThanOrEqualTo(Byte value) {
            addCriterion("f_volume_control <=", value, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlIn(List<Byte> values) {
            addCriterion("f_volume_control in", values, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlNotIn(List<Byte> values) {
            addCriterion("f_volume_control not in", values, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlBetween(Byte value1, Byte value2) {
            addCriterion("f_volume_control between", value1, value2, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFVolumeControlNotBetween(Byte value1, Byte value2) {
            addCriterion("f_volume_control not between", value1, value2, "fVolumeControl");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleIsNull() {
            addCriterion("f_broadcast_style is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleIsNotNull() {
            addCriterion("f_broadcast_style is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleEqualTo(Boolean value) {
            addCriterion("f_broadcast_style =", value, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleNotEqualTo(Boolean value) {
            addCriterion("f_broadcast_style <>", value, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleGreaterThan(Boolean value) {
            addCriterion("f_broadcast_style >", value, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_broadcast_style >=", value, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleLessThan(Boolean value) {
            addCriterion("f_broadcast_style <", value, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleLessThanOrEqualTo(Boolean value) {
            addCriterion("f_broadcast_style <=", value, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleIn(List<Boolean> values) {
            addCriterion("f_broadcast_style in", values, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleNotIn(List<Boolean> values) {
            addCriterion("f_broadcast_style not in", values, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleBetween(Boolean value1, Boolean value2) {
            addCriterion("f_broadcast_style between", value1, value2, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFBroadcastStyleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_broadcast_style not between", value1, value2, "fBroadcastStyle");
            return (Criteria) this;
        }

        public Criteria andFPassSelectIsNull() {
            addCriterion("f_pass_select is null");
            return (Criteria) this;
        }

        public Criteria andFPassSelectIsNotNull() {
            addCriterion("f_pass_select is not null");
            return (Criteria) this;
        }

        public Criteria andFPassSelectEqualTo(Integer value) {
            addCriterion("f_pass_select =", value, "fPassSelect");
            return (Criteria) this;
        }

        public Criteria andFPassSelectNotEqualTo(Integer value) {
            addCriterion("f_pass_select <>", value, "fPassSelect");
            return (Criteria) this;
        }

        public Criteria andFPassSelectGreaterThan(Integer value) {
            addCriterion("f_pass_select >", value, "fPassSelect");
            return (Criteria) this;
        }

        public Criteria andFPassSelectGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_pass_select >=", value, "fPassSelect");
            return (Criteria) this;
        }

        public Criteria andFPassSelectLessThan(Integer value) {
            addCriterion("f_pass_select <", value, "fPassSelect");
            return (Criteria) this;
        }

        public Criteria andFPassSelectLessThanOrEqualTo(Integer value) {
            addCriterion("f_pass_select <=", value, "fPassSelect");
            return (Criteria) this;
        }

        public Criteria andFPassSelectIn(List<Integer> values) {
            addCriterion("f_pass_select in", values, "fPassSelect");
            return (Criteria) this;
        }

        public Criteria andFPassSelectNotIn(List<Integer> values) {
            addCriterion("f_pass_select not in", values, "fPassSelect");
            return (Criteria) this;
        }

        public Criteria andFPassSelectBetween(Integer value1, Integer value2) {
            addCriterion("f_pass_select between", value1, value2, "fPassSelect");
            return (Criteria) this;
        }

        public Criteria andFPassSelectNotBetween(Integer value1, Integer value2) {
            addCriterion("f_pass_select not between", value1, value2, "fPassSelect");
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

        public Criteria andFTextContentIsNull() {
            addCriterion("f_text_content is null");
            return (Criteria) this;
        }

        public Criteria andFTextContentIsNotNull() {
            addCriterion("f_text_content is not null");
            return (Criteria) this;
        }

        public Criteria andFTextContentEqualTo(String value) {
            addCriterion("f_text_content =", value, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentNotEqualTo(String value) {
            addCriterion("f_text_content <>", value, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentGreaterThan(String value) {
            addCriterion("f_text_content >", value, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentGreaterThanOrEqualTo(String value) {
            addCriterion("f_text_content >=", value, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentLessThan(String value) {
            addCriterion("f_text_content <", value, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentLessThanOrEqualTo(String value) {
            addCriterion("f_text_content <=", value, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentLike(String value) {
            addCriterion("f_text_content like", value, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentNotLike(String value) {
            addCriterion("f_text_content not like", value, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentIn(List<String> values) {
            addCriterion("f_text_content in", values, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentNotIn(List<String> values) {
            addCriterion("f_text_content not in", values, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentBetween(String value1, String value2) {
            addCriterion("f_text_content between", value1, value2, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextContentNotBetween(String value1, String value2) {
            addCriterion("f_text_content not between", value1, value2, "fTextContent");
            return (Criteria) this;
        }

        public Criteria andFTextUrlIsNull() {
            addCriterion("f_text_url is null");
            return (Criteria) this;
        }

        public Criteria andFTextUrlIsNotNull() {
            addCriterion("f_text_url is not null");
            return (Criteria) this;
        }

        public Criteria andFTextUrlEqualTo(String value) {
            addCriterion("f_text_url =", value, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlNotEqualTo(String value) {
            addCriterion("f_text_url <>", value, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlGreaterThan(String value) {
            addCriterion("f_text_url >", value, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlGreaterThanOrEqualTo(String value) {
            addCriterion("f_text_url >=", value, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlLessThan(String value) {
            addCriterion("f_text_url <", value, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlLessThanOrEqualTo(String value) {
            addCriterion("f_text_url <=", value, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlLike(String value) {
            addCriterion("f_text_url like", value, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlNotLike(String value) {
            addCriterion("f_text_url not like", value, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlIn(List<String> values) {
            addCriterion("f_text_url in", values, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlNotIn(List<String> values) {
            addCriterion("f_text_url not in", values, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlBetween(String value1, String value2) {
            addCriterion("f_text_url between", value1, value2, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFTextUrlNotBetween(String value1, String value2) {
            addCriterion("f_text_url not between", value1, value2, "fTextUrl");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeIsNull() {
            addCriterion("f_effective_time is null");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeIsNotNull() {
            addCriterion("f_effective_time is not null");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeEqualTo(Date value) {
            addCriterion("f_effective_time =", value, "fEffectiveTime");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeNotEqualTo(Date value) {
            addCriterion("f_effective_time <>", value, "fEffectiveTime");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeGreaterThan(Date value) {
            addCriterion("f_effective_time >", value, "fEffectiveTime");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_effective_time >=", value, "fEffectiveTime");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeLessThan(Date value) {
            addCriterion("f_effective_time <", value, "fEffectiveTime");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_effective_time <=", value, "fEffectiveTime");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeIn(List<Date> values) {
            addCriterion("f_effective_time in", values, "fEffectiveTime");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeNotIn(List<Date> values) {
            addCriterion("f_effective_time not in", values, "fEffectiveTime");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeBetween(Date value1, Date value2) {
            addCriterion("f_effective_time between", value1, value2, "fEffectiveTime");
            return (Criteria) this;
        }

        public Criteria andFEffectiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_effective_time not between", value1, value2, "fEffectiveTime");
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

        public Criteria andFMessageCommandTypeIsNull() {
            addCriterion("f_message_command_type is null");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeIsNotNull() {
            addCriterion("f_message_command_type is not null");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeEqualTo(String value) {
            addCriterion("f_message_command_type =", value, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeNotEqualTo(String value) {
            addCriterion("f_message_command_type <>", value, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeGreaterThan(String value) {
            addCriterion("f_message_command_type >", value, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_message_command_type >=", value, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeLessThan(String value) {
            addCriterion("f_message_command_type <", value, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeLessThanOrEqualTo(String value) {
            addCriterion("f_message_command_type <=", value, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeLike(String value) {
            addCriterion("f_message_command_type like", value, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeNotLike(String value) {
            addCriterion("f_message_command_type not like", value, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeIn(List<String> values) {
            addCriterion("f_message_command_type in", values, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeNotIn(List<String> values) {
            addCriterion("f_message_command_type not in", values, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeBetween(String value1, String value2) {
            addCriterion("f_message_command_type between", value1, value2, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFMessageCommandTypeNotBetween(String value1, String value2) {
            addCriterion("f_message_command_type not between", value1, value2, "fMessageCommandType");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountIsNull() {
            addCriterion("f_broadcast_terminal_count is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountIsNotNull() {
            addCriterion("f_broadcast_terminal_count is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountEqualTo(Integer value) {
            addCriterion("f_broadcast_terminal_count =", value, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountNotEqualTo(Integer value) {
            addCriterion("f_broadcast_terminal_count <>", value, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountGreaterThan(Integer value) {
            addCriterion("f_broadcast_terminal_count >", value, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_broadcast_terminal_count >=", value, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountLessThan(Integer value) {
            addCriterion("f_broadcast_terminal_count <", value, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountLessThanOrEqualTo(Integer value) {
            addCriterion("f_broadcast_terminal_count <=", value, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountIn(List<Integer> values) {
            addCriterion("f_broadcast_terminal_count in", values, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountNotIn(List<Integer> values) {
            addCriterion("f_broadcast_terminal_count not in", values, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountBetween(Integer value1, Integer value2) {
            addCriterion("f_broadcast_terminal_count between", value1, value2, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFBroadcastTerminalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("f_broadcast_terminal_count not between", value1, value2, "fBroadcastTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountIsNull() {
            addCriterion("f_response_terminal_count is null");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountIsNotNull() {
            addCriterion("f_response_terminal_count is not null");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountEqualTo(Integer value) {
            addCriterion("f_response_terminal_count =", value, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountNotEqualTo(Integer value) {
            addCriterion("f_response_terminal_count <>", value, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountGreaterThan(Integer value) {
            addCriterion("f_response_terminal_count >", value, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_response_terminal_count >=", value, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountLessThan(Integer value) {
            addCriterion("f_response_terminal_count <", value, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountLessThanOrEqualTo(Integer value) {
            addCriterion("f_response_terminal_count <=", value, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountIn(List<Integer> values) {
            addCriterion("f_response_terminal_count in", values, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountNotIn(List<Integer> values) {
            addCriterion("f_response_terminal_count not in", values, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountBetween(Integer value1, Integer value2) {
            addCriterion("f_response_terminal_count between", value1, value2, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFResponseTerminalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("f_response_terminal_count not between", value1, value2, "fResponseTerminalCount");
            return (Criteria) this;
        }

        public Criteria andFStateIsNull() {
            addCriterion("f_state is null");
            return (Criteria) this;
        }

        public Criteria andFStateIsNotNull() {
            addCriterion("f_state is not null");
            return (Criteria) this;
        }

        public Criteria andFStateEqualTo(Byte value) {
            addCriterion("f_state =", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotEqualTo(Byte value) {
            addCriterion("f_state <>", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateGreaterThan(Byte value) {
            addCriterion("f_state >", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_state >=", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateLessThan(Byte value) {
            addCriterion("f_state <", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateLessThanOrEqualTo(Byte value) {
            addCriterion("f_state <=", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateIn(List<Byte> values) {
            addCriterion("f_state in", values, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotIn(List<Byte> values) {
            addCriterion("f_state not in", values, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateBetween(Byte value1, Byte value2) {
            addCriterion("f_state between", value1, value2, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotBetween(Byte value1, Byte value2) {
            addCriterion("f_state not between", value1, value2, "fState");
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

        public Criteria andFEndTimeIsNull() {
            addCriterion("f_end_time is null");
            return (Criteria) this;
        }

        public Criteria andFEndTimeIsNotNull() {
            addCriterion("f_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andFEndTimeEqualTo(Date value) {
            addCriterion("f_end_time =", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeNotEqualTo(Date value) {
            addCriterion("f_end_time <>", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeGreaterThan(Date value) {
            addCriterion("f_end_time >", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_end_time >=", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeLessThan(Date value) {
            addCriterion("f_end_time <", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_end_time <=", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeIn(List<Date> values) {
            addCriterion("f_end_time in", values, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeNotIn(List<Date> values) {
            addCriterion("f_end_time not in", values, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeBetween(Date value1, Date value2) {
            addCriterion("f_end_time between", value1, value2, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_end_time not between", value1, value2, "fEndTime");
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