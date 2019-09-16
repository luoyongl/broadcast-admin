package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BBroadcastDevice implements Serializable {
    private Integer fId;

    private Integer fBroadcastId;

    private Boolean fIsTimingBroadcast;

    private Integer fDeviceId;

    private Date fBroadcastSendTime;

    private Date fDeviceAnswerTime;

    private Integer fAnswerTimeNum;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfBroadcastId() {
        return fBroadcastId;
    }

    public void setfBroadcastId(Integer fBroadcastId) {
        this.fBroadcastId = fBroadcastId;
    }

    public Boolean getfIsTimingBroadcast() {
        return fIsTimingBroadcast;
    }

    public void setfIsTimingBroadcast(Boolean fIsTimingBroadcast) {
        this.fIsTimingBroadcast = fIsTimingBroadcast;
    }

    public Integer getfDeviceId() {
        return fDeviceId;
    }

    public void setfDeviceId(Integer fDeviceId) {
        this.fDeviceId = fDeviceId;
    }

    public Date getfBroadcastSendTime() {
        return fBroadcastSendTime;
    }

    public void setfBroadcastSendTime(Date fBroadcastSendTime) {
        this.fBroadcastSendTime = fBroadcastSendTime;
    }

    public Date getfDeviceAnswerTime() {
        return fDeviceAnswerTime;
    }

    public void setfDeviceAnswerTime(Date fDeviceAnswerTime) {
        this.fDeviceAnswerTime = fDeviceAnswerTime;
    }

    public Integer getfAnswerTimeNum() {
        return fAnswerTimeNum;
    }

    public void setfAnswerTimeNum(Integer fAnswerTimeNum) {
        this.fAnswerTimeNum = fAnswerTimeNum;
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
        BBroadcastDevice other = (BBroadcastDevice) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfBroadcastId() == null ? other.getfBroadcastId() == null : this.getfBroadcastId().equals(other.getfBroadcastId()))
            && (this.getfIsTimingBroadcast() == null ? other.getfIsTimingBroadcast() == null : this.getfIsTimingBroadcast().equals(other.getfIsTimingBroadcast()))
            && (this.getfDeviceId() == null ? other.getfDeviceId() == null : this.getfDeviceId().equals(other.getfDeviceId()))
            && (this.getfBroadcastSendTime() == null ? other.getfBroadcastSendTime() == null : this.getfBroadcastSendTime().equals(other.getfBroadcastSendTime()))
            && (this.getfDeviceAnswerTime() == null ? other.getfDeviceAnswerTime() == null : this.getfDeviceAnswerTime().equals(other.getfDeviceAnswerTime()))
            && (this.getfAnswerTimeNum() == null ? other.getfAnswerTimeNum() == null : this.getfAnswerTimeNum().equals(other.getfAnswerTimeNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfBroadcastId() == null) ? 0 : getfBroadcastId().hashCode());
        result = prime * result + ((getfIsTimingBroadcast() == null) ? 0 : getfIsTimingBroadcast().hashCode());
        result = prime * result + ((getfDeviceId() == null) ? 0 : getfDeviceId().hashCode());
        result = prime * result + ((getfBroadcastSendTime() == null) ? 0 : getfBroadcastSendTime().hashCode());
        result = prime * result + ((getfDeviceAnswerTime() == null) ? 0 : getfDeviceAnswerTime().hashCode());
        result = prime * result + ((getfAnswerTimeNum() == null) ? 0 : getfAnswerTimeNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fBroadcastId=").append(fBroadcastId);
        sb.append(", fIsTimingBroadcast=").append(fIsTimingBroadcast);
        sb.append(", fDeviceId=").append(fDeviceId);
        sb.append(", fBroadcastSendTime=").append(fBroadcastSendTime);
        sb.append(", fDeviceAnswerTime=").append(fDeviceAnswerTime);
        sb.append(", fAnswerTimeNum=").append(fAnswerTimeNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}