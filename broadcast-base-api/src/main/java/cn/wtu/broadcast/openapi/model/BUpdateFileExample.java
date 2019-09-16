package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BUpdateFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BUpdateFileExample() {
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

        public Criteria andFNumberIsNull() {
            addCriterion("f_number is null");
            return (Criteria) this;
        }

        public Criteria andFNumberIsNotNull() {
            addCriterion("f_number is not null");
            return (Criteria) this;
        }

        public Criteria andFNumberEqualTo(String value) {
            addCriterion("f_number =", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberNotEqualTo(String value) {
            addCriterion("f_number <>", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberGreaterThan(String value) {
            addCriterion("f_number >", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_number >=", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberLessThan(String value) {
            addCriterion("f_number <", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberLessThanOrEqualTo(String value) {
            addCriterion("f_number <=", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberLike(String value) {
            addCriterion("f_number like", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberNotLike(String value) {
            addCriterion("f_number not like", value, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberIn(List<String> values) {
            addCriterion("f_number in", values, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberNotIn(List<String> values) {
            addCriterion("f_number not in", values, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberBetween(String value1, String value2) {
            addCriterion("f_number between", value1, value2, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFNumberNotBetween(String value1, String value2) {
            addCriterion("f_number not between", value1, value2, "fNumber");
            return (Criteria) this;
        }

        public Criteria andFFileNameIsNull() {
            addCriterion("f_file_name is null");
            return (Criteria) this;
        }

        public Criteria andFFileNameIsNotNull() {
            addCriterion("f_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFFileNameEqualTo(String value) {
            addCriterion("f_file_name =", value, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameNotEqualTo(String value) {
            addCriterion("f_file_name <>", value, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameGreaterThan(String value) {
            addCriterion("f_file_name >", value, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_file_name >=", value, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameLessThan(String value) {
            addCriterion("f_file_name <", value, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameLessThanOrEqualTo(String value) {
            addCriterion("f_file_name <=", value, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameLike(String value) {
            addCriterion("f_file_name like", value, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameNotLike(String value) {
            addCriterion("f_file_name not like", value, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameIn(List<String> values) {
            addCriterion("f_file_name in", values, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameNotIn(List<String> values) {
            addCriterion("f_file_name not in", values, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameBetween(String value1, String value2) {
            addCriterion("f_file_name between", value1, value2, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileNameNotBetween(String value1, String value2) {
            addCriterion("f_file_name not between", value1, value2, "fFileName");
            return (Criteria) this;
        }

        public Criteria andFFileAddressIsNull() {
            addCriterion("f_file_address is null");
            return (Criteria) this;
        }

        public Criteria andFFileAddressIsNotNull() {
            addCriterion("f_file_address is not null");
            return (Criteria) this;
        }

        public Criteria andFFileAddressEqualTo(String value) {
            addCriterion("f_file_address =", value, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressNotEqualTo(String value) {
            addCriterion("f_file_address <>", value, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressGreaterThan(String value) {
            addCriterion("f_file_address >", value, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressGreaterThanOrEqualTo(String value) {
            addCriterion("f_file_address >=", value, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressLessThan(String value) {
            addCriterion("f_file_address <", value, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressLessThanOrEqualTo(String value) {
            addCriterion("f_file_address <=", value, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressLike(String value) {
            addCriterion("f_file_address like", value, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressNotLike(String value) {
            addCriterion("f_file_address not like", value, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressIn(List<String> values) {
            addCriterion("f_file_address in", values, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressNotIn(List<String> values) {
            addCriterion("f_file_address not in", values, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressBetween(String value1, String value2) {
            addCriterion("f_file_address between", value1, value2, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFFileAddressNotBetween(String value1, String value2) {
            addCriterion("f_file_address not between", value1, value2, "fFileAddress");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberIsNull() {
            addCriterion("f_manufacturer_number is null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberIsNotNull() {
            addCriterion("f_manufacturer_number is not null");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberEqualTo(String value) {
            addCriterion("f_manufacturer_number =", value, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberNotEqualTo(String value) {
            addCriterion("f_manufacturer_number <>", value, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberGreaterThan(String value) {
            addCriterion("f_manufacturer_number >", value, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_number >=", value, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberLessThan(String value) {
            addCriterion("f_manufacturer_number <", value, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberLessThanOrEqualTo(String value) {
            addCriterion("f_manufacturer_number <=", value, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberLike(String value) {
            addCriterion("f_manufacturer_number like", value, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberNotLike(String value) {
            addCriterion("f_manufacturer_number not like", value, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberIn(List<String> values) {
            addCriterion("f_manufacturer_number in", values, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberNotIn(List<String> values) {
            addCriterion("f_manufacturer_number not in", values, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberBetween(String value1, String value2) {
            addCriterion("f_manufacturer_number between", value1, value2, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFManufacturerNumberNotBetween(String value1, String value2) {
            addCriterion("f_manufacturer_number not between", value1, value2, "fManufacturerNumber");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeIsNull() {
            addCriterion("f_device_type is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeIsNotNull() {
            addCriterion("f_device_type is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeEqualTo(Integer value) {
            addCriterion("f_device_type =", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotEqualTo(Integer value) {
            addCriterion("f_device_type <>", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeGreaterThan(Integer value) {
            addCriterion("f_device_type >", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_device_type >=", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeLessThan(Integer value) {
            addCriterion("f_device_type <", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("f_device_type <=", value, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeIn(List<Integer> values) {
            addCriterion("f_device_type in", values, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotIn(List<Integer> values) {
            addCriterion("f_device_type not in", values, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeBetween(Integer value1, Integer value2) {
            addCriterion("f_device_type between", value1, value2, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFDeviceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_device_type not between", value1, value2, "fDeviceType");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionIsNull() {
            addCriterion("f_hardware_version is null");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionIsNotNull() {
            addCriterion("f_hardware_version is not null");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionEqualTo(String value) {
            addCriterion("f_hardware_version =", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNotEqualTo(String value) {
            addCriterion("f_hardware_version <>", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionGreaterThan(String value) {
            addCriterion("f_hardware_version >", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionGreaterThanOrEqualTo(String value) {
            addCriterion("f_hardware_version >=", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionLessThan(String value) {
            addCriterion("f_hardware_version <", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionLessThanOrEqualTo(String value) {
            addCriterion("f_hardware_version <=", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionLike(String value) {
            addCriterion("f_hardware_version like", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNotLike(String value) {
            addCriterion("f_hardware_version not like", value, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionIn(List<String> values) {
            addCriterion("f_hardware_version in", values, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNotIn(List<String> values) {
            addCriterion("f_hardware_version not in", values, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionBetween(String value1, String value2) {
            addCriterion("f_hardware_version between", value1, value2, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFHardwareVersionNotBetween(String value1, String value2) {
            addCriterion("f_hardware_version not between", value1, value2, "fHardwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionIsNull() {
            addCriterion("f_old_software_version is null");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionIsNotNull() {
            addCriterion("f_old_software_version is not null");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionEqualTo(String value) {
            addCriterion("f_old_software_version =", value, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionNotEqualTo(String value) {
            addCriterion("f_old_software_version <>", value, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionGreaterThan(String value) {
            addCriterion("f_old_software_version >", value, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionGreaterThanOrEqualTo(String value) {
            addCriterion("f_old_software_version >=", value, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionLessThan(String value) {
            addCriterion("f_old_software_version <", value, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionLessThanOrEqualTo(String value) {
            addCriterion("f_old_software_version <=", value, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionLike(String value) {
            addCriterion("f_old_software_version like", value, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionNotLike(String value) {
            addCriterion("f_old_software_version not like", value, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionIn(List<String> values) {
            addCriterion("f_old_software_version in", values, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionNotIn(List<String> values) {
            addCriterion("f_old_software_version not in", values, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionBetween(String value1, String value2) {
            addCriterion("f_old_software_version between", value1, value2, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFOldSoftwareVersionNotBetween(String value1, String value2) {
            addCriterion("f_old_software_version not between", value1, value2, "fOldSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionIsNull() {
            addCriterion("f_software_version is null");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionIsNotNull() {
            addCriterion("f_software_version is not null");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionEqualTo(String value) {
            addCriterion("f_software_version =", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNotEqualTo(String value) {
            addCriterion("f_software_version <>", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionGreaterThan(String value) {
            addCriterion("f_software_version >", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionGreaterThanOrEqualTo(String value) {
            addCriterion("f_software_version >=", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionLessThan(String value) {
            addCriterion("f_software_version <", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionLessThanOrEqualTo(String value) {
            addCriterion("f_software_version <=", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionLike(String value) {
            addCriterion("f_software_version like", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNotLike(String value) {
            addCriterion("f_software_version not like", value, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionIn(List<String> values) {
            addCriterion("f_software_version in", values, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNotIn(List<String> values) {
            addCriterion("f_software_version not in", values, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionBetween(String value1, String value2) {
            addCriterion("f_software_version between", value1, value2, "fSoftwareVersion");
            return (Criteria) this;
        }

        public Criteria andFSoftwareVersionNotBetween(String value1, String value2) {
            addCriterion("f_software_version not between", value1, value2, "fSoftwareVersion");
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

        public Criteria andFUpdateFlagIsNull() {
            addCriterion("f_update_flag is null");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagIsNotNull() {
            addCriterion("f_update_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagEqualTo(Boolean value) {
            addCriterion("f_update_flag =", value, "fUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagNotEqualTo(Boolean value) {
            addCriterion("f_update_flag <>", value, "fUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagGreaterThan(Boolean value) {
            addCriterion("f_update_flag >", value, "fUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_update_flag >=", value, "fUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagLessThan(Boolean value) {
            addCriterion("f_update_flag <", value, "fUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("f_update_flag <=", value, "fUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagIn(List<Boolean> values) {
            addCriterion("f_update_flag in", values, "fUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagNotIn(List<Boolean> values) {
            addCriterion("f_update_flag not in", values, "fUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("f_update_flag between", value1, value2, "fUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andFUpdateFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_update_flag not between", value1, value2, "fUpdateFlag");
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

        public Criteria andFUpdateTypeIsNull() {
            addCriterion("f_update_type is null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeIsNotNull() {
            addCriterion("f_update_type is not null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeEqualTo(Byte value) {
            addCriterion("f_update_type =", value, "fUpdateType");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeNotEqualTo(Byte value) {
            addCriterion("f_update_type <>", value, "fUpdateType");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeGreaterThan(Byte value) {
            addCriterion("f_update_type >", value, "fUpdateType");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_update_type >=", value, "fUpdateType");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeLessThan(Byte value) {
            addCriterion("f_update_type <", value, "fUpdateType");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_update_type <=", value, "fUpdateType");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeIn(List<Byte> values) {
            addCriterion("f_update_type in", values, "fUpdateType");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeNotIn(List<Byte> values) {
            addCriterion("f_update_type not in", values, "fUpdateType");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_update_type between", value1, value2, "fUpdateType");
            return (Criteria) this;
        }

        public Criteria andFUpdateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_update_type not between", value1, value2, "fUpdateType");
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