package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class TResource implements Serializable {
    private Integer fId;

    private Byte fResourceClassification;

    private String fResourceName;

    private Integer fParentResource;

    private String fResourcePath;

    private String fPermissionCode;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private String fResourceIco;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Byte getfResourceClassification() {
        return fResourceClassification;
    }

    public void setfResourceClassification(Byte fResourceClassification) {
        this.fResourceClassification = fResourceClassification;
    }

    public String getfResourceName() {
        return fResourceName;
    }

    public void setfResourceName(String fResourceName) {
        this.fResourceName = fResourceName == null ? null : fResourceName.trim();
    }

    public Integer getfParentResource() {
        return fParentResource;
    }

    public void setfParentResource(Integer fParentResource) {
        this.fParentResource = fParentResource;
    }

    public String getfResourcePath() {
        return fResourcePath;
    }

    public void setfResourcePath(String fResourcePath) {
        this.fResourcePath = fResourcePath == null ? null : fResourcePath.trim();
    }

    public String getfPermissionCode() {
        return fPermissionCode;
    }

    public void setfPermissionCode(String fPermissionCode) {
        this.fPermissionCode = fPermissionCode == null ? null : fPermissionCode.trim();
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

    public String getfResourceIco() {
        return fResourceIco;
    }

    public void setfResourceIco(String fResourceIco) {
        this.fResourceIco = fResourceIco == null ? null : fResourceIco.trim();
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
        TResource other = (TResource) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfResourceClassification() == null ? other.getfResourceClassification() == null : this.getfResourceClassification().equals(other.getfResourceClassification()))
            && (this.getfResourceName() == null ? other.getfResourceName() == null : this.getfResourceName().equals(other.getfResourceName()))
            && (this.getfParentResource() == null ? other.getfParentResource() == null : this.getfParentResource().equals(other.getfParentResource()))
            && (this.getfResourcePath() == null ? other.getfResourcePath() == null : this.getfResourcePath().equals(other.getfResourcePath()))
            && (this.getfPermissionCode() == null ? other.getfPermissionCode() == null : this.getfPermissionCode().equals(other.getfPermissionCode()))
            && (this.getfSort() == null ? other.getfSort() == null : this.getfSort().equals(other.getfSort()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()))
            && (this.getfResourceIco() == null ? other.getfResourceIco() == null : this.getfResourceIco().equals(other.getfResourceIco()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfResourceClassification() == null) ? 0 : getfResourceClassification().hashCode());
        result = prime * result + ((getfResourceName() == null) ? 0 : getfResourceName().hashCode());
        result = prime * result + ((getfParentResource() == null) ? 0 : getfParentResource().hashCode());
        result = prime * result + ((getfResourcePath() == null) ? 0 : getfResourcePath().hashCode());
        result = prime * result + ((getfPermissionCode() == null) ? 0 : getfPermissionCode().hashCode());
        result = prime * result + ((getfSort() == null) ? 0 : getfSort().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        result = prime * result + ((getfResourceIco() == null) ? 0 : getfResourceIco().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fResourceClassification=").append(fResourceClassification);
        sb.append(", fResourceName=").append(fResourceName);
        sb.append(", fParentResource=").append(fParentResource);
        sb.append(", fResourcePath=").append(fResourcePath);
        sb.append(", fPermissionCode=").append(fPermissionCode);
        sb.append(", fSort=").append(fSort);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", fResourceIco=").append(fResourceIco);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}