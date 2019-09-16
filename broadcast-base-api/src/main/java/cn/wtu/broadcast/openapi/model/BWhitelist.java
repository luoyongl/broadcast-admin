package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BWhitelist implements Serializable {
    private Integer fId;

    private String fAssociatedId;

    private Integer fOperType;

    private String fName;

    private String fTelephoneNumber;

    private Integer fControlDevice;

    private Byte fPermit;

    private Integer fWhitelistLocation;

    private String fPermissionAreaCode;

    private String fResourceCode;

    private Date fCreateTime;

    private Date fUpdateTime;

    private Integer fCreatorId;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfAssociatedId() {
        return fAssociatedId;
    }

    public void setfAssociatedId(String fAssociatedId) {
        this.fAssociatedId = fAssociatedId == null ? null : fAssociatedId.trim();
    }

    public Integer getfOperType() {
        return fOperType;
    }

    public void setfOperType(Integer fOperType) {
        this.fOperType = fOperType;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfTelephoneNumber() {
        return fTelephoneNumber;
    }

    public void setfTelephoneNumber(String fTelephoneNumber) {
        this.fTelephoneNumber = fTelephoneNumber == null ? null : fTelephoneNumber.trim();
    }

    public Integer getfControlDevice() {
        return fControlDevice;
    }

    public void setfControlDevice(Integer fControlDevice) {
        this.fControlDevice = fControlDevice;
    }

    public Byte getfPermit() {
        return fPermit;
    }

    public void setfPermit(Byte fPermit) {
        this.fPermit = fPermit;
    }

    public Integer getfWhitelistLocation() {
        return fWhitelistLocation;
    }

    public void setfWhitelistLocation(Integer fWhitelistLocation) {
        this.fWhitelistLocation = fWhitelistLocation;
    }

    public String getfPermissionAreaCode() {
        return fPermissionAreaCode;
    }

    public void setfPermissionAreaCode(String fPermissionAreaCode) {
        this.fPermissionAreaCode = fPermissionAreaCode == null ? null : fPermissionAreaCode.trim();
    }

    public String getfResourceCode() {
        return fResourceCode;
    }

    public void setfResourceCode(String fResourceCode) {
        this.fResourceCode = fResourceCode == null ? null : fResourceCode.trim();
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    public Integer getfCreatorId() {
        return fCreatorId;
    }

    public void setfCreatorId(Integer fCreatorId) {
        this.fCreatorId = fCreatorId;
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
        BWhitelist other = (BWhitelist) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfAssociatedId() == null ? other.getfAssociatedId() == null : this.getfAssociatedId().equals(other.getfAssociatedId()))
            && (this.getfOperType() == null ? other.getfOperType() == null : this.getfOperType().equals(other.getfOperType()))
            && (this.getfName() == null ? other.getfName() == null : this.getfName().equals(other.getfName()))
            && (this.getfTelephoneNumber() == null ? other.getfTelephoneNumber() == null : this.getfTelephoneNumber().equals(other.getfTelephoneNumber()))
            && (this.getfControlDevice() == null ? other.getfControlDevice() == null : this.getfControlDevice().equals(other.getfControlDevice()))
            && (this.getfPermit() == null ? other.getfPermit() == null : this.getfPermit().equals(other.getfPermit()))
            && (this.getfWhitelistLocation() == null ? other.getfWhitelistLocation() == null : this.getfWhitelistLocation().equals(other.getfWhitelistLocation()))
            && (this.getfPermissionAreaCode() == null ? other.getfPermissionAreaCode() == null : this.getfPermissionAreaCode().equals(other.getfPermissionAreaCode()))
            && (this.getfResourceCode() == null ? other.getfResourceCode() == null : this.getfResourceCode().equals(other.getfResourceCode()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfAssociatedId() == null) ? 0 : getfAssociatedId().hashCode());
        result = prime * result + ((getfOperType() == null) ? 0 : getfOperType().hashCode());
        result = prime * result + ((getfName() == null) ? 0 : getfName().hashCode());
        result = prime * result + ((getfTelephoneNumber() == null) ? 0 : getfTelephoneNumber().hashCode());
        result = prime * result + ((getfControlDevice() == null) ? 0 : getfControlDevice().hashCode());
        result = prime * result + ((getfPermit() == null) ? 0 : getfPermit().hashCode());
        result = prime * result + ((getfWhitelistLocation() == null) ? 0 : getfWhitelistLocation().hashCode());
        result = prime * result + ((getfPermissionAreaCode() == null) ? 0 : getfPermissionAreaCode().hashCode());
        result = prime * result + ((getfResourceCode() == null) ? 0 : getfResourceCode().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
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
        sb.append(", fAssociatedId=").append(fAssociatedId);
        sb.append(", fOperType=").append(fOperType);
        sb.append(", fName=").append(fName);
        sb.append(", fTelephoneNumber=").append(fTelephoneNumber);
        sb.append(", fControlDevice=").append(fControlDevice);
        sb.append(", fPermit=").append(fPermit);
        sb.append(", fWhitelistLocation=").append(fWhitelistLocation);
        sb.append(", fPermissionAreaCode=").append(fPermissionAreaCode);
        sb.append(", fResourceCode=").append(fResourceCode);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}