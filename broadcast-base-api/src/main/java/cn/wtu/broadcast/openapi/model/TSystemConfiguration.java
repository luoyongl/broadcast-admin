package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class TSystemConfiguration implements Serializable {
    private Integer fId;

    private Byte fBigClassification;

    private String fConfigurationType;

    private String fConfigurationName;

    private String fConfigurationValue;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Byte getfBigClassification() {
        return fBigClassification;
    }

    public void setfBigClassification(Byte fBigClassification) {
        this.fBigClassification = fBigClassification;
    }

    public String getfConfigurationType() {
        return fConfigurationType;
    }

    public void setfConfigurationType(String fConfigurationType) {
        this.fConfigurationType = fConfigurationType == null ? null : fConfigurationType.trim();
    }

    public String getfConfigurationName() {
        return fConfigurationName;
    }

    public void setfConfigurationName(String fConfigurationName) {
        this.fConfigurationName = fConfigurationName == null ? null : fConfigurationName.trim();
    }

    public String getfConfigurationValue() {
        return fConfigurationValue;
    }

    public void setfConfigurationValue(String fConfigurationValue) {
        this.fConfigurationValue = fConfigurationValue == null ? null : fConfigurationValue.trim();
    }

    public Byte getfSort() {
        return fSort;
    }

    public void setfSort(Byte fSort) {
        this.fSort = fSort;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Integer getfCreatorId() {
        return fCreatorId;
    }

    public void setfCreatorId(Integer fCreatorId) {
        this.fCreatorId = fCreatorId;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    public Integer getfOperatorId() {
        return fOperatorId;
    }

    public void setfOperatorId(Integer fOperatorId) {
        this.fOperatorId = fOperatorId;
    }

    public Boolean getfDeleteFlag() {
        return fDeleteFlag;
    }

    public void setfDeleteFlag(Boolean fDeleteFlag) {
        this.fDeleteFlag = fDeleteFlag;
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
        TSystemConfiguration other = (TSystemConfiguration) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfBigClassification() == null ? other.getfBigClassification() == null : this.getfBigClassification().equals(other.getfBigClassification()))
            && (this.getfConfigurationType() == null ? other.getfConfigurationType() == null : this.getfConfigurationType().equals(other.getfConfigurationType()))
            && (this.getfConfigurationName() == null ? other.getfConfigurationName() == null : this.getfConfigurationName().equals(other.getfConfigurationName()))
            && (this.getfConfigurationValue() == null ? other.getfConfigurationValue() == null : this.getfConfigurationValue().equals(other.getfConfigurationValue()))
            && (this.getfSort() == null ? other.getfSort() == null : this.getfSort().equals(other.getfSort()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfBigClassification() == null) ? 0 : getfBigClassification().hashCode());
        result = prime * result + ((getfConfigurationType() == null) ? 0 : getfConfigurationType().hashCode());
        result = prime * result + ((getfConfigurationName() == null) ? 0 : getfConfigurationName().hashCode());
        result = prime * result + ((getfConfigurationValue() == null) ? 0 : getfConfigurationValue().hashCode());
        result = prime * result + ((getfSort() == null) ? 0 : getfSort().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fBigClassification=").append(fBigClassification);
        sb.append(", fConfigurationType=").append(fConfigurationType);
        sb.append(", fConfigurationName=").append(fConfigurationName);
        sb.append(", fConfigurationValue=").append(fConfigurationValue);
        sb.append(", fSort=").append(fSort);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}