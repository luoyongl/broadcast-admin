package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BTeletextTerminal implements Serializable {
    private Integer fId;

    private String fTerminalName;

    private String fMac;

    private String fResourceCode;

    private Byte fDeviceType;

    private String fRemark;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private String fBroadcastArea;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfTerminalName() {
        return fTerminalName;
    }

    public void setfTerminalName(String fTerminalName) {
        this.fTerminalName = fTerminalName == null ? null : fTerminalName.trim();
    }

    public String getfMac() {
        return fMac;
    }

    public void setfMac(String fMac) {
        this.fMac = fMac == null ? null : fMac.trim();
    }

    public String getfResourceCode() {
        return fResourceCode;
    }

    public void setfResourceCode(String fResourceCode) {
        this.fResourceCode = fResourceCode == null ? null : fResourceCode.trim();
    }

    public Byte getfDeviceType() {
        return fDeviceType;
    }

    public void setfDeviceType(Byte fDeviceType) {
        this.fDeviceType = fDeviceType;
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
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

    public String getfBroadcastArea() {
        return fBroadcastArea;
    }

    public void setfBroadcastArea(String fBroadcastArea) {
        this.fBroadcastArea = fBroadcastArea == null ? null : fBroadcastArea.trim();
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
        BTeletextTerminal other = (BTeletextTerminal) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfTerminalName() == null ? other.getfTerminalName() == null : this.getfTerminalName().equals(other.getfTerminalName()))
            && (this.getfMac() == null ? other.getfMac() == null : this.getfMac().equals(other.getfMac()))
            && (this.getfResourceCode() == null ? other.getfResourceCode() == null : this.getfResourceCode().equals(other.getfResourceCode()))
            && (this.getfDeviceType() == null ? other.getfDeviceType() == null : this.getfDeviceType().equals(other.getfDeviceType()))
            && (this.getfRemark() == null ? other.getfRemark() == null : this.getfRemark().equals(other.getfRemark()))
            && (this.getfSort() == null ? other.getfSort() == null : this.getfSort().equals(other.getfSort()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()))
            && (this.getfBroadcastArea() == null ? other.getfBroadcastArea() == null : this.getfBroadcastArea().equals(other.getfBroadcastArea()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfTerminalName() == null) ? 0 : getfTerminalName().hashCode());
        result = prime * result + ((getfMac() == null) ? 0 : getfMac().hashCode());
        result = prime * result + ((getfResourceCode() == null) ? 0 : getfResourceCode().hashCode());
        result = prime * result + ((getfDeviceType() == null) ? 0 : getfDeviceType().hashCode());
        result = prime * result + ((getfRemark() == null) ? 0 : getfRemark().hashCode());
        result = prime * result + ((getfSort() == null) ? 0 : getfSort().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        result = prime * result + ((getfBroadcastArea() == null) ? 0 : getfBroadcastArea().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fTerminalName=").append(fTerminalName);
        sb.append(", fMac=").append(fMac);
        sb.append(", fResourceCode=").append(fResourceCode);
        sb.append(", fDeviceType=").append(fDeviceType);
        sb.append(", fRemark=").append(fRemark);
        sb.append(", fSort=").append(fSort);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", fBroadcastArea=").append(fBroadcastArea);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}