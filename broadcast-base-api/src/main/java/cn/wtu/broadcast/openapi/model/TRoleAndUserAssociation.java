package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;

public class TRoleAndUserAssociation implements Serializable {
    private Integer fRoleAndUserId;

    private Integer fRoleId;

    private Integer fUserId;

    private static final long serialVersionUID = 1L;

    public Integer getfRoleAndUserId() {
        return fRoleAndUserId;
    }

    public void setfRoleAndUserId(Integer fRoleAndUserId) {
        this.fRoleAndUserId = fRoleAndUserId;
    }

    public Integer getfRoleId() {
        return fRoleId;
    }

    public void setfRoleId(Integer fRoleId) {
        this.fRoleId = fRoleId;
    }

    public Integer getfUserId() {
        return fUserId;
    }

    public void setfUserId(Integer fUserId) {
        this.fUserId = fUserId;
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
        TRoleAndUserAssociation other = (TRoleAndUserAssociation) that;
        return (this.getfRoleAndUserId() == null ? other.getfRoleAndUserId() == null : this.getfRoleAndUserId().equals(other.getfRoleAndUserId()))
            && (this.getfRoleId() == null ? other.getfRoleId() == null : this.getfRoleId().equals(other.getfRoleId()))
            && (this.getfUserId() == null ? other.getfUserId() == null : this.getfUserId().equals(other.getfUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfRoleAndUserId() == null) ? 0 : getfRoleAndUserId().hashCode());
        result = prime * result + ((getfRoleId() == null) ? 0 : getfRoleId().hashCode());
        result = prime * result + ((getfUserId() == null) ? 0 : getfUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fRoleAndUserId=").append(fRoleAndUserId);
        sb.append(", fRoleId=").append(fRoleId);
        sb.append(", fUserId=").append(fUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}