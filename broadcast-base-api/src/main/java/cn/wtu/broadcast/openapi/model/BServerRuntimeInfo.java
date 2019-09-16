package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BServerRuntimeInfo implements Serializable {
    private Integer fId;

    private Integer fServerType;

    private Integer fServerState;

    private Date fCreatTime;

    private Date fUpdateTime;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfServerType() {
        return fServerType;
    }

    public void setfServerType(Integer fServerType) {
        this.fServerType = fServerType;
    }

    public Integer getfServerState() {
        return fServerState;
    }

    public void setfServerState(Integer fServerState) {
        this.fServerState = fServerState;
    }

    public Date getfCreatTime() {
        return fCreatTime;
    }

    public void setfCreatTime(Date fCreatTime) {
        this.fCreatTime = fCreatTime;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
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
        BServerRuntimeInfo other = (BServerRuntimeInfo) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfServerType() == null ? other.getfServerType() == null : this.getfServerType().equals(other.getfServerType()))
            && (this.getfServerState() == null ? other.getfServerState() == null : this.getfServerState().equals(other.getfServerState()))
            && (this.getfCreatTime() == null ? other.getfCreatTime() == null : this.getfCreatTime().equals(other.getfCreatTime()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfServerType() == null) ? 0 : getfServerType().hashCode());
        result = prime * result + ((getfServerState() == null) ? 0 : getfServerState().hashCode());
        result = prime * result + ((getfCreatTime() == null) ? 0 : getfCreatTime().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fServerType=").append(fServerType);
        sb.append(", fServerState=").append(fServerState);
        sb.append(", fCreatTime=").append(fCreatTime);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}