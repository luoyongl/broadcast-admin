package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;

public class TRoleAndResourceLink implements Serializable {
    private Integer fRoleResourcesId;

    private Integer fRoleId;

    private Integer fResourcesId;

    private static final long serialVersionUID = 1L;

    public Integer getfRoleResourcesId() {
        return fRoleResourcesId;
    }

    public void setfRoleResourcesId(Integer fRoleResourcesId) {
        this.fRoleResourcesId = fRoleResourcesId;
    }

    public Integer getfRoleId() {
        return fRoleId;
    }

    public void setfRoleId(Integer fRoleId) {
        this.fRoleId = fRoleId;
    }

    public Integer getfResourcesId() {
        return fResourcesId;
    }

    public void setfResourcesId(Integer fResourcesId) {
        this.fResourcesId = fResourcesId;
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
        TRoleAndResourceLink other = (TRoleAndResourceLink) that;
        return (this.getfRoleResourcesId() == null ? other.getfRoleResourcesId() == null : this.getfRoleResourcesId().equals(other.getfRoleResourcesId()))
            && (this.getfRoleId() == null ? other.getfRoleId() == null : this.getfRoleId().equals(other.getfRoleId()))
            && (this.getfResourcesId() == null ? other.getfResourcesId() == null : this.getfResourcesId().equals(other.getfResourcesId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfRoleResourcesId() == null) ? 0 : getfRoleResourcesId().hashCode());
        result = prime * result + ((getfRoleId() == null) ? 0 : getfRoleId().hashCode());
        result = prime * result + ((getfResourcesId() == null) ? 0 : getfResourcesId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fRoleResourcesId=").append(fRoleResourcesId);
        sb.append(", fRoleId=").append(fRoleId);
        sb.append(", fResourcesId=").append(fResourcesId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}