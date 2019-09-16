package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class TAdministrativeDivision implements Serializable {
    private Integer fId;

    private String fCode;

    private String fName;

    private String fLongitude;

    private String fLatitude;

    private Integer fParentNode;

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

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode == null ? null : fCode.trim();
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfLongitude() {
        return fLongitude;
    }

    public void setfLongitude(String fLongitude) {
        this.fLongitude = fLongitude == null ? null : fLongitude.trim();
    }

    public String getfLatitude() {
        return fLatitude;
    }

    public void setfLatitude(String fLatitude) {
        this.fLatitude = fLatitude == null ? null : fLatitude.trim();
    }

    public Integer getfParentNode() {
        return fParentNode;
    }

    public void setfParentNode(Integer fParentNode) {
        this.fParentNode = fParentNode;
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
        TAdministrativeDivision other = (TAdministrativeDivision) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfCode() == null ? other.getfCode() == null : this.getfCode().equals(other.getfCode()))
            && (this.getfName() == null ? other.getfName() == null : this.getfName().equals(other.getfName()))
            && (this.getfLongitude() == null ? other.getfLongitude() == null : this.getfLongitude().equals(other.getfLongitude()))
            && (this.getfLatitude() == null ? other.getfLatitude() == null : this.getfLatitude().equals(other.getfLatitude()))
            && (this.getfParentNode() == null ? other.getfParentNode() == null : this.getfParentNode().equals(other.getfParentNode()))
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
        result = prime * result + ((getfCode() == null) ? 0 : getfCode().hashCode());
        result = prime * result + ((getfName() == null) ? 0 : getfName().hashCode());
        result = prime * result + ((getfLongitude() == null) ? 0 : getfLongitude().hashCode());
        result = prime * result + ((getfLatitude() == null) ? 0 : getfLatitude().hashCode());
        result = prime * result + ((getfParentNode() == null) ? 0 : getfParentNode().hashCode());
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
        sb.append(", fCode=").append(fCode);
        sb.append(", fName=").append(fName);
        sb.append(", fLongitude=").append(fLongitude);
        sb.append(", fLatitude=").append(fLatitude);
        sb.append(", fParentNode=").append(fParentNode);
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