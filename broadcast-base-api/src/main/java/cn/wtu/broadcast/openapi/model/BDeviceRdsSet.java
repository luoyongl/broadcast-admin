package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BDeviceRdsSet implements Serializable {
    private Integer fId;

    private Integer fParameterSetId;

    private String fDeviceResourceCode;

    private Integer fRdsPriority;

    private Double fRdsFrequency;

    private Integer fOperator;

    private Date fOperateTime;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfParameterSetId() {
        return fParameterSetId;
    }

    public void setfParameterSetId(Integer fParameterSetId) {
        this.fParameterSetId = fParameterSetId;
    }

    public String getfDeviceResourceCode() {
        return fDeviceResourceCode;
    }

    public void setfDeviceResourceCode(String fDeviceResourceCode) {
        this.fDeviceResourceCode = fDeviceResourceCode == null ? null : fDeviceResourceCode.trim();
    }

    public Integer getfRdsPriority() {
        return fRdsPriority;
    }

    public void setfRdsPriority(Integer fRdsPriority) {
        this.fRdsPriority = fRdsPriority;
    }

    public Double getfRdsFrequency() {
        return fRdsFrequency;
    }

    public void setfRdsFrequency(Double fRdsFrequency) {
        this.fRdsFrequency = fRdsFrequency;
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
        BDeviceRdsSet other = (BDeviceRdsSet) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfParameterSetId() == null ? other.getfParameterSetId() == null : this.getfParameterSetId().equals(other.getfParameterSetId()))
            && (this.getfDeviceResourceCode() == null ? other.getfDeviceResourceCode() == null : this.getfDeviceResourceCode().equals(other.getfDeviceResourceCode()))
            && (this.getfRdsPriority() == null ? other.getfRdsPriority() == null : this.getfRdsPriority().equals(other.getfRdsPriority()))
            && (this.getfRdsFrequency() == null ? other.getfRdsFrequency() == null : this.getfRdsFrequency().equals(other.getfRdsFrequency()))
            && (this.getfOperator() == null ? other.getfOperator() == null : this.getfOperator().equals(other.getfOperator()))
            && (this.getfOperateTime() == null ? other.getfOperateTime() == null : this.getfOperateTime().equals(other.getfOperateTime()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfParameterSetId() == null) ? 0 : getfParameterSetId().hashCode());
        result = prime * result + ((getfDeviceResourceCode() == null) ? 0 : getfDeviceResourceCode().hashCode());
        result = prime * result + ((getfRdsPriority() == null) ? 0 : getfRdsPriority().hashCode());
        result = prime * result + ((getfRdsFrequency() == null) ? 0 : getfRdsFrequency().hashCode());
        result = prime * result + ((getfOperator() == null) ? 0 : getfOperator().hashCode());
        result = prime * result + ((getfOperateTime() == null) ? 0 : getfOperateTime().hashCode());
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
        sb.append(", fParameterSetId=").append(fParameterSetId);
        sb.append(", fDeviceResourceCode=").append(fDeviceResourceCode);
        sb.append(", fRdsPriority=").append(fRdsPriority);
        sb.append(", fRdsFrequency=").append(fRdsFrequency);
        sb.append(", fOperator=").append(fOperator);
        sb.append(", fOperateTime=").append(fOperateTime);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}