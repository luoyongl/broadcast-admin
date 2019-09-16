package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BInstructionSendreplyStorage implements Serializable {
    private Integer fId;

    private String fSendDirectives;

    private String fRespondInstructions;

    private Date fCreateTime;

    private Date fUpdtateTime;

    private Integer fCreateId;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfSendDirectives() {
        return fSendDirectives;
    }

    public void setfSendDirectives(String fSendDirectives) {
        this.fSendDirectives = fSendDirectives == null ? null : fSendDirectives.trim();
    }

    public String getfRespondInstructions() {
        return fRespondInstructions;
    }

    public void setfRespondInstructions(String fRespondInstructions) {
        this.fRespondInstructions = fRespondInstructions == null ? null : fRespondInstructions.trim();
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Date getfUpdtateTime() {
        return fUpdtateTime;
    }

    public void setfUpdtateTime(Date fUpdtateTime) {
        this.fUpdtateTime = fUpdtateTime;
    }

    public Integer getfCreateId() {
        return fCreateId;
    }

    public void setfCreateId(Integer fCreateId) {
        this.fCreateId = fCreateId;
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
        BInstructionSendreplyStorage other = (BInstructionSendreplyStorage) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfSendDirectives() == null ? other.getfSendDirectives() == null : this.getfSendDirectives().equals(other.getfSendDirectives()))
            && (this.getfRespondInstructions() == null ? other.getfRespondInstructions() == null : this.getfRespondInstructions().equals(other.getfRespondInstructions()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfUpdtateTime() == null ? other.getfUpdtateTime() == null : this.getfUpdtateTime().equals(other.getfUpdtateTime()))
            && (this.getfCreateId() == null ? other.getfCreateId() == null : this.getfCreateId().equals(other.getfCreateId()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfSendDirectives() == null) ? 0 : getfSendDirectives().hashCode());
        result = prime * result + ((getfRespondInstructions() == null) ? 0 : getfRespondInstructions().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfUpdtateTime() == null) ? 0 : getfUpdtateTime().hashCode());
        result = prime * result + ((getfCreateId() == null) ? 0 : getfCreateId().hashCode());
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
        sb.append(", fSendDirectives=").append(fSendDirectives);
        sb.append(", fRespondInstructions=").append(fRespondInstructions);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fUpdtateTime=").append(fUpdtateTime);
        sb.append(", fCreateId=").append(fCreateId);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}