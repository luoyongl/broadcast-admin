package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BDeviceParameterSet implements Serializable {
    private Integer fId;

    private Integer fDeviceId;

    private String fDeviceResourceCode;

    private Integer fAdapterRebackType;

    private Integer fAdapterRebackCycle;

    private String fAdapterRebackAddress;

    private String fQueryCode;

    private Integer fVolume;

    private String fDeviceIp;

    private String fDeviceSubnetMask;

    private String fDeviceGateway;

    private Integer fDeviceSwitchOption;

    private Integer fTsSettingFrequency;

    private Integer fTsSettingSymbolRate;

    private Integer fTsSettingQam;

    private Date fCalibrationTime;

    private Integer fOperator;

    private Date fOperateTime;

    private Date fUpdateTime;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfDeviceId() {
        return fDeviceId;
    }

    public void setfDeviceId(Integer fDeviceId) {
        this.fDeviceId = fDeviceId;
    }

    public String getfDeviceResourceCode() {
        return fDeviceResourceCode;
    }

    public void setfDeviceResourceCode(String fDeviceResourceCode) {
        this.fDeviceResourceCode = fDeviceResourceCode == null ? null : fDeviceResourceCode.trim();
    }

    public Integer getfAdapterRebackType() {
        return fAdapterRebackType;
    }

    public void setfAdapterRebackType(Integer fAdapterRebackType) {
        this.fAdapterRebackType = fAdapterRebackType;
    }

    public Integer getfAdapterRebackCycle() {
        return fAdapterRebackCycle;
    }

    public void setfAdapterRebackCycle(Integer fAdapterRebackCycle) {
        this.fAdapterRebackCycle = fAdapterRebackCycle;
    }

    public String getfAdapterRebackAddress() {
        return fAdapterRebackAddress;
    }

    public void setfAdapterRebackAddress(String fAdapterRebackAddress) {
        this.fAdapterRebackAddress = fAdapterRebackAddress == null ? null : fAdapterRebackAddress.trim();
    }

    public String getfQueryCode() {
        return fQueryCode;
    }

    public void setfQueryCode(String fQueryCode) {
        this.fQueryCode = fQueryCode == null ? null : fQueryCode.trim();
    }

    public Integer getfVolume() {
        return fVolume;
    }

    public void setfVolume(Integer fVolume) {
        this.fVolume = fVolume;
    }

    public String getfDeviceIp() {
        return fDeviceIp;
    }

    public void setfDeviceIp(String fDeviceIp) {
        this.fDeviceIp = fDeviceIp == null ? null : fDeviceIp.trim();
    }

    public String getfDeviceSubnetMask() {
        return fDeviceSubnetMask;
    }

    public void setfDeviceSubnetMask(String fDeviceSubnetMask) {
        this.fDeviceSubnetMask = fDeviceSubnetMask == null ? null : fDeviceSubnetMask.trim();
    }

    public String getfDeviceGateway() {
        return fDeviceGateway;
    }

    public void setfDeviceGateway(String fDeviceGateway) {
        this.fDeviceGateway = fDeviceGateway == null ? null : fDeviceGateway.trim();
    }

    public Integer getfDeviceSwitchOption() {
        return fDeviceSwitchOption;
    }

    public void setfDeviceSwitchOption(Integer fDeviceSwitchOption) {
        this.fDeviceSwitchOption = fDeviceSwitchOption;
    }

    public Integer getfTsSettingFrequency() {
        return fTsSettingFrequency;
    }

    public void setfTsSettingFrequency(Integer fTsSettingFrequency) {
        this.fTsSettingFrequency = fTsSettingFrequency;
    }

    public Integer getfTsSettingSymbolRate() {
        return fTsSettingSymbolRate;
    }

    public void setfTsSettingSymbolRate(Integer fTsSettingSymbolRate) {
        this.fTsSettingSymbolRate = fTsSettingSymbolRate;
    }

    public Integer getfTsSettingQam() {
        return fTsSettingQam;
    }

    public void setfTsSettingQam(Integer fTsSettingQam) {
        this.fTsSettingQam = fTsSettingQam;
    }

    public Date getfCalibrationTime() {
        return fCalibrationTime;
    }

    public void setfCalibrationTime(Date fCalibrationTime) {
        this.fCalibrationTime = fCalibrationTime;
    }

    public Integer getfOperator() {
        return fOperator;
    }

    public void setfOperator(Integer fOperator) {
        this.fOperator = fOperator;
    }

    public Date getfOperateTime() {
        return fOperateTime;
    }

    public void setfOperateTime(Date fOperateTime) {
        this.fOperateTime = fOperateTime;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BDeviceParameterSet other = (BDeviceParameterSet) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfDeviceId() == null ? other.getfDeviceId() == null : this.getfDeviceId().equals(other.getfDeviceId()))
            && (this.getfDeviceResourceCode() == null ? other.getfDeviceResourceCode() == null : this.getfDeviceResourceCode().equals(other.getfDeviceResourceCode()))
            && (this.getfAdapterRebackType() == null ? other.getfAdapterRebackType() == null : this.getfAdapterRebackType().equals(other.getfAdapterRebackType()))
            && (this.getfAdapterRebackCycle() == null ? other.getfAdapterRebackCycle() == null : this.getfAdapterRebackCycle().equals(other.getfAdapterRebackCycle()))
            && (this.getfAdapterRebackAddress() == null ? other.getfAdapterRebackAddress() == null : this.getfAdapterRebackAddress().equals(other.getfAdapterRebackAddress()))
            && (this.getfQueryCode() == null ? other.getfQueryCode() == null : this.getfQueryCode().equals(other.getfQueryCode()))
            && (this.getfVolume() == null ? other.getfVolume() == null : this.getfVolume().equals(other.getfVolume()))
            && (this.getfDeviceIp() == null ? other.getfDeviceIp() == null : this.getfDeviceIp().equals(other.getfDeviceIp()))
            && (this.getfDeviceSubnetMask() == null ? other.getfDeviceSubnetMask() == null : this.getfDeviceSubnetMask().equals(other.getfDeviceSubnetMask()))
            && (this.getfDeviceGateway() == null ? other.getfDeviceGateway() == null : this.getfDeviceGateway().equals(other.getfDeviceGateway()))
            && (this.getfDeviceSwitchOption() == null ? other.getfDeviceSwitchOption() == null : this.getfDeviceSwitchOption().equals(other.getfDeviceSwitchOption()))
            && (this.getfTsSettingFrequency() == null ? other.getfTsSettingFrequency() == null : this.getfTsSettingFrequency().equals(other.getfTsSettingFrequency()))
            && (this.getfTsSettingSymbolRate() == null ? other.getfTsSettingSymbolRate() == null : this.getfTsSettingSymbolRate().equals(other.getfTsSettingSymbolRate()))
            && (this.getfTsSettingQam() == null ? other.getfTsSettingQam() == null : this.getfTsSettingQam().equals(other.getfTsSettingQam()))
            && (this.getfCalibrationTime() == null ? other.getfCalibrationTime() == null : this.getfCalibrationTime().equals(other.getfCalibrationTime()))
            && (this.getfOperator() == null ? other.getfOperator() == null : this.getfOperator().equals(other.getfOperator()))
            && (this.getfOperateTime() == null ? other.getfOperateTime() == null : this.getfOperateTime().equals(other.getfOperateTime()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfDeviceId() == null) ? 0 : getfDeviceId().hashCode());
        result = prime * result + ((getfDeviceResourceCode() == null) ? 0 : getfDeviceResourceCode().hashCode());
        result = prime * result + ((getfAdapterRebackType() == null) ? 0 : getfAdapterRebackType().hashCode());
        result = prime * result + ((getfAdapterRebackCycle() == null) ? 0 : getfAdapterRebackCycle().hashCode());
        result = prime * result + ((getfAdapterRebackAddress() == null) ? 0 : getfAdapterRebackAddress().hashCode());
        result = prime * result + ((getfQueryCode() == null) ? 0 : getfQueryCode().hashCode());
        result = prime * result + ((getfVolume() == null) ? 0 : getfVolume().hashCode());
        result = prime * result + ((getfDeviceIp() == null) ? 0 : getfDeviceIp().hashCode());
        result = prime * result + ((getfDeviceSubnetMask() == null) ? 0 : getfDeviceSubnetMask().hashCode());
        result = prime * result + ((getfDeviceGateway() == null) ? 0 : getfDeviceGateway().hashCode());
        result = prime * result + ((getfDeviceSwitchOption() == null) ? 0 : getfDeviceSwitchOption().hashCode());
        result = prime * result + ((getfTsSettingFrequency() == null) ? 0 : getfTsSettingFrequency().hashCode());
        result = prime * result + ((getfTsSettingSymbolRate() == null) ? 0 : getfTsSettingSymbolRate().hashCode());
        result = prime * result + ((getfTsSettingQam() == null) ? 0 : getfTsSettingQam().hashCode());
        result = prime * result + ((getfCalibrationTime() == null) ? 0 : getfCalibrationTime().hashCode());
        result = prime * result + ((getfOperator() == null) ? 0 : getfOperator().hashCode());
        result = prime * result + ((getfOperateTime() == null) ? 0 : getfOperateTime().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fDeviceId=").append(fDeviceId);
        sb.append(", fDeviceResourceCode=").append(fDeviceResourceCode);
        sb.append(", fAdapterRebackType=").append(fAdapterRebackType);
        sb.append(", fAdapterRebackCycle=").append(fAdapterRebackCycle);
        sb.append(", fAdapterRebackAddress=").append(fAdapterRebackAddress);
        sb.append(", fQueryCode=").append(fQueryCode);
        sb.append(", fVolume=").append(fVolume);
        sb.append(", fDeviceIp=").append(fDeviceIp);
        sb.append(", fDeviceSubnetMask=").append(fDeviceSubnetMask);
        sb.append(", fDeviceGateway=").append(fDeviceGateway);
        sb.append(", fDeviceSwitchOption=").append(fDeviceSwitchOption);
        sb.append(", fTsSettingFrequency=").append(fTsSettingFrequency);
        sb.append(", fTsSettingSymbolRate=").append(fTsSettingSymbolRate);
        sb.append(", fTsSettingQam=").append(fTsSettingQam);
        sb.append(", fCalibrationTime=").append(fCalibrationTime);
        sb.append(", fOperator=").append(fOperator);
        sb.append(", fOperateTime=").append(fOperateTime);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}