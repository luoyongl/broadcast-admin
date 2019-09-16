package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BDeviceOutputChannel implements Serializable {
    private Integer fId;

    private Integer fOutputChannelId;

    private Integer fParameterSetId;

    private String fDeviceResourceCode;

    private String fDeviceChannelType;

    private Integer fOutputChannelNumber;

    private String fSubChannelFreq;

    private Integer fOriginalNetworkId;

    private Integer fDetailsChannelTransportStreamId;

    private Integer fDetailsChannelProgramNumber;

    private Integer fDetailsChannelPcrPid;

    private Integer fElementaryPid;

    private String fDeviceOutChannelState;

    private String fDeviceOutChannelControlArea;

    private Integer fOperator;

    private Date fOperateTime;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfOutputChannelId() {
        return fOutputChannelId;
    }

    public void setfOutputChannelId(Integer fOutputChannelId) {
        this.fOutputChannelId = fOutputChannelId;
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

    public String getfDeviceChannelType() {
        return fDeviceChannelType;
    }

    public void setfDeviceChannelType(String fDeviceChannelType) {
        this.fDeviceChannelType = fDeviceChannelType == null ? null : fDeviceChannelType.trim();
    }

    public Integer getfOutputChannelNumber() {
        return fOutputChannelNumber;
    }

    public void setfOutputChannelNumber(Integer fOutputChannelNumber) {
        this.fOutputChannelNumber = fOutputChannelNumber;
    }

    public String getfSubChannelFreq() {
        return fSubChannelFreq;
    }

    public void setfSubChannelFreq(String fSubChannelFreq) {
        this.fSubChannelFreq = fSubChannelFreq == null ? null : fSubChannelFreq.trim();
    }

    public Integer getfOriginalNetworkId() {
        return fOriginalNetworkId;
    }

    public void setfOriginalNetworkId(Integer fOriginalNetworkId) {
        this.fOriginalNetworkId = fOriginalNetworkId;
    }

    public Integer getfDetailsChannelTransportStreamId() {
        return fDetailsChannelTransportStreamId;
    }

    public void setfDetailsChannelTransportStreamId(Integer fDetailsChannelTransportStreamId) {
        this.fDetailsChannelTransportStreamId = fDetailsChannelTransportStreamId;
    }

    public Integer getfDetailsChannelProgramNumber() {
        return fDetailsChannelProgramNumber;
    }

    public void setfDetailsChannelProgramNumber(Integer fDetailsChannelProgramNumber) {
        this.fDetailsChannelProgramNumber = fDetailsChannelProgramNumber;
    }

    public Integer getfDetailsChannelPcrPid() {
        return fDetailsChannelPcrPid;
    }

    public void setfDetailsChannelPcrPid(Integer fDetailsChannelPcrPid) {
        this.fDetailsChannelPcrPid = fDetailsChannelPcrPid;
    }

    public Integer getfElementaryPid() {
        return fElementaryPid;
    }

    public void setfElementaryPid(Integer fElementaryPid) {
        this.fElementaryPid = fElementaryPid;
    }

    public String getfDeviceOutChannelState() {
        return fDeviceOutChannelState;
    }

    public void setfDeviceOutChannelState(String fDeviceOutChannelState) {
        this.fDeviceOutChannelState = fDeviceOutChannelState == null ? null : fDeviceOutChannelState.trim();
    }

    public String getfDeviceOutChannelControlArea() {
        return fDeviceOutChannelControlArea;
    }

    public void setfDeviceOutChannelControlArea(String fDeviceOutChannelControlArea) {
        this.fDeviceOutChannelControlArea = fDeviceOutChannelControlArea == null ? null : fDeviceOutChannelControlArea.trim();
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
        BDeviceOutputChannel other = (BDeviceOutputChannel) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfOutputChannelId() == null ? other.getfOutputChannelId() == null : this.getfOutputChannelId().equals(other.getfOutputChannelId()))
            && (this.getfParameterSetId() == null ? other.getfParameterSetId() == null : this.getfParameterSetId().equals(other.getfParameterSetId()))
            && (this.getfDeviceResourceCode() == null ? other.getfDeviceResourceCode() == null : this.getfDeviceResourceCode().equals(other.getfDeviceResourceCode()))
            && (this.getfDeviceChannelType() == null ? other.getfDeviceChannelType() == null : this.getfDeviceChannelType().equals(other.getfDeviceChannelType()))
            && (this.getfOutputChannelNumber() == null ? other.getfOutputChannelNumber() == null : this.getfOutputChannelNumber().equals(other.getfOutputChannelNumber()))
            && (this.getfSubChannelFreq() == null ? other.getfSubChannelFreq() == null : this.getfSubChannelFreq().equals(other.getfSubChannelFreq()))
            && (this.getfOriginalNetworkId() == null ? other.getfOriginalNetworkId() == null : this.getfOriginalNetworkId().equals(other.getfOriginalNetworkId()))
            && (this.getfDetailsChannelTransportStreamId() == null ? other.getfDetailsChannelTransportStreamId() == null : this.getfDetailsChannelTransportStreamId().equals(other.getfDetailsChannelTransportStreamId()))
            && (this.getfDetailsChannelProgramNumber() == null ? other.getfDetailsChannelProgramNumber() == null : this.getfDetailsChannelProgramNumber().equals(other.getfDetailsChannelProgramNumber()))
            && (this.getfDetailsChannelPcrPid() == null ? other.getfDetailsChannelPcrPid() == null : this.getfDetailsChannelPcrPid().equals(other.getfDetailsChannelPcrPid()))
            && (this.getfElementaryPid() == null ? other.getfElementaryPid() == null : this.getfElementaryPid().equals(other.getfElementaryPid()))
            && (this.getfDeviceOutChannelState() == null ? other.getfDeviceOutChannelState() == null : this.getfDeviceOutChannelState().equals(other.getfDeviceOutChannelState()))
            && (this.getfDeviceOutChannelControlArea() == null ? other.getfDeviceOutChannelControlArea() == null : this.getfDeviceOutChannelControlArea().equals(other.getfDeviceOutChannelControlArea()))
            && (this.getfOperator() == null ? other.getfOperator() == null : this.getfOperator().equals(other.getfOperator()))
            && (this.getfOperateTime() == null ? other.getfOperateTime() == null : this.getfOperateTime().equals(other.getfOperateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfOutputChannelId() == null) ? 0 : getfOutputChannelId().hashCode());
        result = prime * result + ((getfParameterSetId() == null) ? 0 : getfParameterSetId().hashCode());
        result = prime * result + ((getfDeviceResourceCode() == null) ? 0 : getfDeviceResourceCode().hashCode());
        result = prime * result + ((getfDeviceChannelType() == null) ? 0 : getfDeviceChannelType().hashCode());
        result = prime * result + ((getfOutputChannelNumber() == null) ? 0 : getfOutputChannelNumber().hashCode());
        result = prime * result + ((getfSubChannelFreq() == null) ? 0 : getfSubChannelFreq().hashCode());
        result = prime * result + ((getfOriginalNetworkId() == null) ? 0 : getfOriginalNetworkId().hashCode());
        result = prime * result + ((getfDetailsChannelTransportStreamId() == null) ? 0 : getfDetailsChannelTransportStreamId().hashCode());
        result = prime * result + ((getfDetailsChannelProgramNumber() == null) ? 0 : getfDetailsChannelProgramNumber().hashCode());
        result = prime * result + ((getfDetailsChannelPcrPid() == null) ? 0 : getfDetailsChannelPcrPid().hashCode());
        result = prime * result + ((getfElementaryPid() == null) ? 0 : getfElementaryPid().hashCode());
        result = prime * result + ((getfDeviceOutChannelState() == null) ? 0 : getfDeviceOutChannelState().hashCode());
        result = prime * result + ((getfDeviceOutChannelControlArea() == null) ? 0 : getfDeviceOutChannelControlArea().hashCode());
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
        sb.append(", fOutputChannelId=").append(fOutputChannelId);
        sb.append(", fParameterSetId=").append(fParameterSetId);
        sb.append(", fDeviceResourceCode=").append(fDeviceResourceCode);
        sb.append(", fDeviceChannelType=").append(fDeviceChannelType);
        sb.append(", fOutputChannelNumber=").append(fOutputChannelNumber);
        sb.append(", fSubChannelFreq=").append(fSubChannelFreq);
        sb.append(", fOriginalNetworkId=").append(fOriginalNetworkId);
        sb.append(", fDetailsChannelTransportStreamId=").append(fDetailsChannelTransportStreamId);
        sb.append(", fDetailsChannelProgramNumber=").append(fDetailsChannelProgramNumber);
        sb.append(", fDetailsChannelPcrPid=").append(fDetailsChannelPcrPid);
        sb.append(", fElementaryPid=").append(fElementaryPid);
        sb.append(", fDeviceOutChannelState=").append(fDeviceOutChannelState);
        sb.append(", fDeviceOutChannelControlArea=").append(fDeviceOutChannelControlArea);
        sb.append(", fOperator=").append(fOperator);
        sb.append(", fOperateTime=").append(fOperateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}