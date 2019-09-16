package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BDeviceInputChannel implements Serializable {
    private Integer fId;

    private Integer fInputChannelId;

    private Integer fParameterSetId;

    private String fDeviceResourceCode;

    private String fDeviceChannelName;

    private Integer fInputChannelNumber;

    private Integer fInputChannelGroup;

    private String fDeviceChannelState;

    private Integer fOperator;

    private Date fOperateTime;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfInputChannelId() {
        return fInputChannelId;
    }

    public void setfInputChannelId(Integer fInputChannelId) {
        this.fInputChannelId = fInputChannelId;
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

    public String getfDeviceChannelName() {
        return fDeviceChannelName;
    }

    public void setfDeviceChannelName(String fDeviceChannelName) {
        this.fDeviceChannelName = fDeviceChannelName == null ? null : fDeviceChannelName.trim();
    }

    public Integer getfInputChannelNumber() {
        return fInputChannelNumber;
    }

    public void setfInputChannelNumber(Integer fInputChannelNumber) {
        this.fInputChannelNumber = fInputChannelNumber;
    }

    public Integer getfInputChannelGroup() {
        return fInputChannelGroup;
    }

    public void setfInputChannelGroup(Integer fInputChannelGroup) {
        this.fInputChannelGroup = fInputChannelGroup;
    }

    public String getfDeviceChannelState() {
        return fDeviceChannelState;
    }

    public void setfDeviceChannelState(String fDeviceChannelState) {
        this.fDeviceChannelState = fDeviceChannelState == null ? null : fDeviceChannelState.trim();
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
        BDeviceInputChannel other = (BDeviceInputChannel) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfInputChannelId() == null ? other.getfInputChannelId() == null : this.getfInputChannelId().equals(other.getfInputChannelId()))
            && (this.getfParameterSetId() == null ? other.getfParameterSetId() == null : this.getfParameterSetId().equals(other.getfParameterSetId()))
            && (this.getfDeviceResourceCode() == null ? other.getfDeviceResourceCode() == null : this.getfDeviceResourceCode().equals(other.getfDeviceResourceCode()))
            && (this.getfDeviceChannelName() == null ? other.getfDeviceChannelName() == null : this.getfDeviceChannelName().equals(other.getfDeviceChannelName()))
            && (this.getfInputChannelNumber() == null ? other.getfInputChannelNumber() == null : this.getfInputChannelNumber().equals(other.getfInputChannelNumber()))
            && (this.getfInputChannelGroup() == null ? other.getfInputChannelGroup() == null : this.getfInputChannelGroup().equals(other.getfInputChannelGroup()))
            && (this.getfDeviceChannelState() == null ? other.getfDeviceChannelState() == null : this.getfDeviceChannelState().equals(other.getfDeviceChannelState()))
            && (this.getfOperator() == null ? other.getfOperator() == null : this.getfOperator().equals(other.getfOperator()))
            && (this.getfOperateTime() == null ? other.getfOperateTime() == null : this.getfOperateTime().equals(other.getfOperateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfInputChannelId() == null) ? 0 : getfInputChannelId().hashCode());
        result = prime * result + ((getfParameterSetId() == null) ? 0 : getfParameterSetId().hashCode());
        result = prime * result + ((getfDeviceResourceCode() == null) ? 0 : getfDeviceResourceCode().hashCode());
        result = prime * result + ((getfDeviceChannelName() == null) ? 0 : getfDeviceChannelName().hashCode());
        result = prime * result + ((getfInputChannelNumber() == null) ? 0 : getfInputChannelNumber().hashCode());
        result = prime * result + ((getfInputChannelGroup() == null) ? 0 : getfInputChannelGroup().hashCode());
        result = prime * result + ((getfDeviceChannelState() == null) ? 0 : getfDeviceChannelState().hashCode());
        result = prime * result + ((getfOperator() == null) ? 0 : getfOperator().hashCode());
        result = prime * result + ((getfOperateTime() == null) ? 0 : getfOperateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fInputChannelId=").append(fInputChannelId);
        sb.append(", fParameterSetId=").append(fParameterSetId);
        sb.append(", fDeviceResourceCode=").append(fDeviceResourceCode);
        sb.append(", fDeviceChannelName=").append(fDeviceChannelName);
        sb.append(", fInputChannelNumber=").append(fInputChannelNumber);
        sb.append(", fInputChannelGroup=").append(fInputChannelGroup);
        sb.append(", fDeviceChannelState=").append(fDeviceChannelState);
        sb.append(", fOperator=").append(fOperator);
        sb.append(", fOperateTime=").append(fOperateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}