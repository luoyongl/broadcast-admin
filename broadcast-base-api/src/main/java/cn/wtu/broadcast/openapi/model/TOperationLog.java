package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class TOperationLog implements Serializable {
    private Integer fId;

    private Integer fUserid;

    private String fUsername;

    private Date fOperationTime;

    private Byte fOperationType;

    private String fOperationContent;

    private String fOperationResult;

    private String fIp;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfUserid() {
        return fUserid;
    }

    public void setfUserid(Integer fUserid) {
        this.fUserid = fUserid;
    }

    public String getfUsername() {
        return fUsername;
    }

    public void setfUsername(String fUsername) {
        this.fUsername = fUsername == null ? null : fUsername.trim();
    }

    public Date getfOperationTime() {
        return fOperationTime;
    }

    public void setfOperationTime(Date fOperationTime) {
        this.fOperationTime = fOperationTime;
    }

    public Byte getfOperationType() {
        return fOperationType;
    }

    public void setfOperationType(Byte fOperationType) {
        this.fOperationType = fOperationType;
    }

    public String getfOperationContent() {
        return fOperationContent;
    }

    public void setfOperationContent(String fOperationContent) {
        this.fOperationContent = fOperationContent == null ? null : fOperationContent.trim();
    }

    public String getfOperationResult() {
        return fOperationResult;
    }

    public void setfOperationResult(String fOperationResult) {
        this.fOperationResult = fOperationResult == null ? null : fOperationResult.trim();
    }

    public String getfIp() {
        return fIp;
    }

    public void setfIp(String fIp) {
        this.fIp = fIp == null ? null : fIp.trim();
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
        TOperationLog other = (TOperationLog) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfUserid() == null ? other.getfUserid() == null : this.getfUserid().equals(other.getfUserid()))
            && (this.getfUsername() == null ? other.getfUsername() == null : this.getfUsername().equals(other.getfUsername()))
            && (this.getfOperationTime() == null ? other.getfOperationTime() == null : this.getfOperationTime().equals(other.getfOperationTime()))
            && (this.getfOperationType() == null ? other.getfOperationType() == null : this.getfOperationType().equals(other.getfOperationType()))
            && (this.getfOperationContent() == null ? other.getfOperationContent() == null : this.getfOperationContent().equals(other.getfOperationContent()))
            && (this.getfOperationResult() == null ? other.getfOperationResult() == null : this.getfOperationResult().equals(other.getfOperationResult()))
            && (this.getfIp() == null ? other.getfIp() == null : this.getfIp().equals(other.getfIp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfUserid() == null) ? 0 : getfUserid().hashCode());
        result = prime * result + ((getfUsername() == null) ? 0 : getfUsername().hashCode());
        result = prime * result + ((getfOperationTime() == null) ? 0 : getfOperationTime().hashCode());
        result = prime * result + ((getfOperationType() == null) ? 0 : getfOperationType().hashCode());
        result = prime * result + ((getfOperationContent() == null) ? 0 : getfOperationContent().hashCode());
        result = prime * result + ((getfOperationResult() == null) ? 0 : getfOperationResult().hashCode());
        result = prime * result + ((getfIp() == null) ? 0 : getfIp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fUserid=").append(fUserid);
        sb.append(", fUsername=").append(fUsername);
        sb.append(", fOperationTime=").append(fOperationTime);
        sb.append(", fOperationType=").append(fOperationType);
        sb.append(", fOperationContent=").append(fOperationContent);
        sb.append(", fOperationResult=").append(fOperationResult);
        sb.append(", fIp=").append(fIp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}