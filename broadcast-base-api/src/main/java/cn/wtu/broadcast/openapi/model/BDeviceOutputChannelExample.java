package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BDeviceOutputChannelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDeviceOutputChannelExample() {
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

        public Criteria andFOutputChannelIdIsNull() {
            addCriterion("f_output_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdIsNotNull() {
            addCriterion("f_output_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdEqualTo(Integer value) {
            addCriterion("f_output_channel_id =", value, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdNotEqualTo(Integer value) {
            addCriterion("f_output_channel_id <>", value, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdGreaterThan(Integer value) {
            addCriterion("f_output_channel_id >", value, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_output_channel_id >=", value, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdLessThan(Integer value) {
            addCriterion("f_output_channel_id <", value, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_output_channel_id <=", value, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdIn(List<Integer> values) {
            addCriterion("f_output_channel_id in", values, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdNotIn(List<Integer> values) {
            addCriterion("f_output_channel_id not in", values, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("f_output_channel_id between", value1, value2, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_output_channel_id not between", value1, value2, "fOutputChannelId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdIsNull() {
            addCriterion("f_parameter_set_id is null");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdIsNotNull() {
            addCriterion("f_parameter_set_id is not null");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdEqualTo(Integer value) {
            addCriterion("f_parameter_set_id =", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdNotEqualTo(Integer value) {
            addCriterion("f_parameter_set_id <>", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdGreaterThan(Integer value) {
            addCriterion("f_parameter_set_id >", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_parameter_set_id >=", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdLessThan(Integer value) {
            addCriterion("f_parameter_set_id <", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_parameter_set_id <=", value, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdIn(List<Integer> values) {
            addCriterion("f_parameter_set_id in", values, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdNotIn(List<Integer> values) {
            addCriterion("f_parameter_set_id not in", values, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdBetween(Integer value1, Integer value2) {
            addCriterion("f_parameter_set_id between", value1, value2, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFParameterSetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_parameter_set_id not between", value1, value2, "fParameterSetId");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeIsNull() {
            addCriterion("f_device_resource_code is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeIsNotNull() {
            addCriterion("f_device_resource_code is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeEqualTo(String value) {
            addCriterion("f_device_resource_code =", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotEqualTo(String value) {
            addCriterion("f_device_resource_code <>", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeGreaterThan(String value) {
            addCriterion("f_device_resource_code >", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_resource_code >=", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeLessThan(String value) {
            addCriterion("f_device_resource_code <", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeLessThanOrEqualTo(String value) {
            addCriterion("f_device_resource_code <=", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeLike(String value) {
            addCriterion("f_device_resource_code like", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotLike(String value) {
            addCriterion("f_device_resource_code not like", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeIn(List<String> values) {
            addCriterion("f_device_resource_code in", values, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotIn(List<String> values) {
            addCriterion("f_device_resource_code not in", values, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeBetween(String value1, String value2) {
            addCriterion("f_device_resource_code between", value1, value2, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotBetween(String value1, String value2) {
            addCriterion("f_device_resource_code not between", value1, value2, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeIsNull() {
            addCriterion("f_device_channel_type is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeIsNotNull() {
            addCriterion("f_device_channel_type is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeEqualTo(String value) {
            addCriterion("f_device_channel_type =", value, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeNotEqualTo(String value) {
            addCriterion("f_device_channel_type <>", value, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeGreaterThan(String value) {
            addCriterion("f_device_channel_type >", value, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_channel_type >=", value, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeLessThan(String value) {
            addCriterion("f_device_channel_type <", value, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeLessThanOrEqualTo(String value) {
            addCriterion("f_device_channel_type <=", value, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeLike(String value) {
            addCriterion("f_device_channel_type like", value, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeNotLike(String value) {
            addCriterion("f_device_channel_type not like", value, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeIn(List<String> values) {
            addCriterion("f_device_channel_type in", values, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeNotIn(List<String> values) {
            addCriterion("f_device_channel_type not in", values, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeBetween(String value1, String value2) {
            addCriterion("f_device_channel_type between", value1, value2, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFDeviceChannelTypeNotBetween(String value1, String value2) {
            addCriterion("f_device_channel_type not between", value1, value2, "fDeviceChannelType");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberIsNull() {
            addCriterion("f_output_channel_number is null");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberIsNotNull() {
            addCriterion("f_output_channel_number is not null");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberEqualTo(Integer value) {
            addCriterion("f_output_channel_number =", value, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberNotEqualTo(Integer value) {
            addCriterion("f_output_channel_number <>", value, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberGreaterThan(Integer value) {
            addCriterion("f_output_channel_number >", value, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_output_channel_number >=", value, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberLessThan(Integer value) {
            addCriterion("f_output_channel_number <", value, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberLessThanOrEqualTo(Integer value) {
            addCriterion("f_output_channel_number <=", value, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberIn(List<Integer> values) {
            addCriterion("f_output_channel_number in", values, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberNotIn(List<Integer> values) {
            addCriterion("f_output_channel_number not in", values, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberBetween(Integer value1, Integer value2) {
            addCriterion("f_output_channel_number between", value1, value2, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFOutputChannelNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("f_output_channel_number not between", value1, value2, "fOutputChannelNumber");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqIsNull() {
            addCriterion("f_sub_channel_freq is null");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqIsNotNull() {
            addCriterion("f_sub_channel_freq is not null");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqEqualTo(String value) {
            addCriterion("f_sub_channel_freq =", value, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqNotEqualTo(String value) {
            addCriterion("f_sub_channel_freq <>", value, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqGreaterThan(String value) {
            addCriterion("f_sub_channel_freq >", value, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqGreaterThanOrEqualTo(String value) {
            addCriterion("f_sub_channel_freq >=", value, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqLessThan(String value) {
            addCriterion("f_sub_channel_freq <", value, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqLessThanOrEqualTo(String value) {
            addCriterion("f_sub_channel_freq <=", value, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqLike(String value) {
            addCriterion("f_sub_channel_freq like", value, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqNotLike(String value) {
            addCriterion("f_sub_channel_freq not like", value, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqIn(List<String> values) {
            addCriterion("f_sub_channel_freq in", values, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqNotIn(List<String> values) {
            addCriterion("f_sub_channel_freq not in", values, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqBetween(String value1, String value2) {
            addCriterion("f_sub_channel_freq between", value1, value2, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFSubChannelFreqNotBetween(String value1, String value2) {
            addCriterion("f_sub_channel_freq not between", value1, value2, "fSubChannelFreq");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdIsNull() {
            addCriterion("f_original_network_id is null");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdIsNotNull() {
            addCriterion("f_original_network_id is not null");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdEqualTo(Integer value) {
            addCriterion("f_original_network_id =", value, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdNotEqualTo(Integer value) {
            addCriterion("f_original_network_id <>", value, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdGreaterThan(Integer value) {
            addCriterion("f_original_network_id >", value, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_original_network_id >=", value, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdLessThan(Integer value) {
            addCriterion("f_original_network_id <", value, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_original_network_id <=", value, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdIn(List<Integer> values) {
            addCriterion("f_original_network_id in", values, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdNotIn(List<Integer> values) {
            addCriterion("f_original_network_id not in", values, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdBetween(Integer value1, Integer value2) {
            addCriterion("f_original_network_id between", value1, value2, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFOriginalNetworkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_original_network_id not between", value1, value2, "fOriginalNetworkId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdIsNull() {
            addCriterion("f_details_channel_transport_stream_id is null");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdIsNotNull() {
            addCriterion("f_details_channel_transport_stream_id is not null");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdEqualTo(Integer value) {
            addCriterion("f_details_channel_transport_stream_id =", value, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdNotEqualTo(Integer value) {
            addCriterion("f_details_channel_transport_stream_id <>", value, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdGreaterThan(Integer value) {
            addCriterion("f_details_channel_transport_stream_id >", value, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_details_channel_transport_stream_id >=", value, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdLessThan(Integer value) {
            addCriterion("f_details_channel_transport_stream_id <", value, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_details_channel_transport_stream_id <=", value, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdIn(List<Integer> values) {
            addCriterion("f_details_channel_transport_stream_id in", values, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdNotIn(List<Integer> values) {
            addCriterion("f_details_channel_transport_stream_id not in", values, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdBetween(Integer value1, Integer value2) {
            addCriterion("f_details_channel_transport_stream_id between", value1, value2, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelTransportStreamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_details_channel_transport_stream_id not between", value1, value2, "fDetailsChannelTransportStreamId");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberIsNull() {
            addCriterion("f_details_channel_program_number is null");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberIsNotNull() {
            addCriterion("f_details_channel_program_number is not null");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberEqualTo(Integer value) {
            addCriterion("f_details_channel_program_number =", value, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberNotEqualTo(Integer value) {
            addCriterion("f_details_channel_program_number <>", value, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberGreaterThan(Integer value) {
            addCriterion("f_details_channel_program_number >", value, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_details_channel_program_number >=", value, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberLessThan(Integer value) {
            addCriterion("f_details_channel_program_number <", value, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberLessThanOrEqualTo(Integer value) {
            addCriterion("f_details_channel_program_number <=", value, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberIn(List<Integer> values) {
            addCriterion("f_details_channel_program_number in", values, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberNotIn(List<Integer> values) {
            addCriterion("f_details_channel_program_number not in", values, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberBetween(Integer value1, Integer value2) {
            addCriterion("f_details_channel_program_number between", value1, value2, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelProgramNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("f_details_channel_program_number not between", value1, value2, "fDetailsChannelProgramNumber");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidIsNull() {
            addCriterion("f_details_channel_pcr_pid is null");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidIsNotNull() {
            addCriterion("f_details_channel_pcr_pid is not null");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidEqualTo(Integer value) {
            addCriterion("f_details_channel_pcr_pid =", value, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidNotEqualTo(Integer value) {
            addCriterion("f_details_channel_pcr_pid <>", value, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidGreaterThan(Integer value) {
            addCriterion("f_details_channel_pcr_pid >", value, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_details_channel_pcr_pid >=", value, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidLessThan(Integer value) {
            addCriterion("f_details_channel_pcr_pid <", value, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidLessThanOrEqualTo(Integer value) {
            addCriterion("f_details_channel_pcr_pid <=", value, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidIn(List<Integer> values) {
            addCriterion("f_details_channel_pcr_pid in", values, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidNotIn(List<Integer> values) {
            addCriterion("f_details_channel_pcr_pid not in", values, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidBetween(Integer value1, Integer value2) {
            addCriterion("f_details_channel_pcr_pid between", value1, value2, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFDetailsChannelPcrPidNotBetween(Integer value1, Integer value2) {
            addCriterion("f_details_channel_pcr_pid not between", value1, value2, "fDetailsChannelPcrPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidIsNull() {
            addCriterion("f_elementary_pid is null");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidIsNotNull() {
            addCriterion("f_elementary_pid is not null");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidEqualTo(Integer value) {
            addCriterion("f_elementary_pid =", value, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidNotEqualTo(Integer value) {
            addCriterion("f_elementary_pid <>", value, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidGreaterThan(Integer value) {
            addCriterion("f_elementary_pid >", value, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_elementary_pid >=", value, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidLessThan(Integer value) {
            addCriterion("f_elementary_pid <", value, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidLessThanOrEqualTo(Integer value) {
            addCriterion("f_elementary_pid <=", value, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidIn(List<Integer> values) {
            addCriterion("f_elementary_pid in", values, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidNotIn(List<Integer> values) {
            addCriterion("f_elementary_pid not in", values, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidBetween(Integer value1, Integer value2) {
            addCriterion("f_elementary_pid between", value1, value2, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFElementaryPidNotBetween(Integer value1, Integer value2) {
            addCriterion("f_elementary_pid not between", value1, value2, "fElementaryPid");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateIsNull() {
            addCriterion("f_device_out_channel_state is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateIsNotNull() {
            addCriterion("f_device_out_channel_state is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateEqualTo(String value) {
            addCriterion("f_device_out_channel_state =", value, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateNotEqualTo(String value) {
            addCriterion("f_device_out_channel_state <>", value, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateGreaterThan(String value) {
            addCriterion("f_device_out_channel_state >", value, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_out_channel_state >=", value, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateLessThan(String value) {
            addCriterion("f_device_out_channel_state <", value, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateLessThanOrEqualTo(String value) {
            addCriterion("f_device_out_channel_state <=", value, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateLike(String value) {
            addCriterion("f_device_out_channel_state like", value, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateNotLike(String value) {
            addCriterion("f_device_out_channel_state not like", value, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateIn(List<String> values) {
            addCriterion("f_device_out_channel_state in", values, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateNotIn(List<String> values) {
            addCriterion("f_device_out_channel_state not in", values, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateBetween(String value1, String value2) {
            addCriterion("f_device_out_channel_state between", value1, value2, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelStateNotBetween(String value1, String value2) {
            addCriterion("f_device_out_channel_state not between", value1, value2, "fDeviceOutChannelState");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaIsNull() {
            addCriterion("f_device_out_channel_control_area is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaIsNotNull() {
            addCriterion("f_device_out_channel_control_area is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaEqualTo(String value) {
            addCriterion("f_device_out_channel_control_area =", value, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaNotEqualTo(String value) {
            addCriterion("f_device_out_channel_control_area <>", value, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaGreaterThan(String value) {
            addCriterion("f_device_out_channel_control_area >", value, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_out_channel_control_area >=", value, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaLessThan(String value) {
            addCriterion("f_device_out_channel_control_area <", value, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaLessThanOrEqualTo(String value) {
            addCriterion("f_device_out_channel_control_area <=", value, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaLike(String value) {
            addCriterion("f_device_out_channel_control_area like", value, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaNotLike(String value) {
            addCriterion("f_device_out_channel_control_area not like", value, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaIn(List<String> values) {
            addCriterion("f_device_out_channel_control_area in", values, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaNotIn(List<String> values) {
            addCriterion("f_device_out_channel_control_area not in", values, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaBetween(String value1, String value2) {
            addCriterion("f_device_out_channel_control_area between", value1, value2, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFDeviceOutChannelControlAreaNotBetween(String value1, String value2) {
            addCriterion("f_device_out_channel_control_area not between", value1, value2, "fDeviceOutChannelControlArea");
            return (Criteria) this;
        }

        public Criteria andFOperatorIsNull() {
            addCriterion("f_operator is null");
            return (Criteria) this;
        }

        public Criteria andFOperatorIsNotNull() {
            addCriterion("f_operator is not null");
            return (Criteria) this;
        }

        public Criteria andFOperatorEqualTo(Integer value) {
            addCriterion("f_operator =", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorNotEqualTo(Integer value) {
            addCriterion("f_operator <>", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorGreaterThan(Integer value) {
            addCriterion("f_operator >", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_operator >=", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorLessThan(Integer value) {
            addCriterion("f_operator <", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("f_operator <=", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorIn(List<Integer> values) {
            addCriterion("f_operator in", values, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorNotIn(List<Integer> values) {
            addCriterion("f_operator not in", values, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorBetween(Integer value1, Integer value2) {
            addCriterion("f_operator between", value1, value2, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("f_operator not between", value1, value2, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeIsNull() {
            addCriterion("f_operate_time is null");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeIsNotNull() {
            addCriterion("f_operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeEqualTo(Date value) {
            addCriterion("f_operate_time =", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeNotEqualTo(Date value) {
            addCriterion("f_operate_time <>", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeGreaterThan(Date value) {
            addCriterion("f_operate_time >", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_operate_time >=", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeLessThan(Date value) {
            addCriterion("f_operate_time <", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_operate_time <=", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeIn(List<Date> values) {
            addCriterion("f_operate_time in", values, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeNotIn(List<Date> values) {
            addCriterion("f_operate_time not in", values, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeBetween(Date value1, Date value2) {
            addCriterion("f_operate_time between", value1, value2, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_operate_time not between", value1, value2, "fOperateTime");
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