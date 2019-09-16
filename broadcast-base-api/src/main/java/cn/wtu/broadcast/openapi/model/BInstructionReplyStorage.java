package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BInstructionReplyStorage implements Serializable {
    private Integer fId;

    private String fHeadmark;

    private String fVersion;

    private String fTag;

    private String fPacktype;

    private String fSource;

    private String fDatatype;

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

    public String getfHeadmark() {
        return fHeadmark;
    }

    public void setfHeadmark(String fHeadmark) {
        this.fHeadmark = fHeadmark == null ? null : fHeadmark.trim();
    }

    public String getfVersion() {
        return fVersion;
    }

    public void setfVersion(String fVersion) {
        this.fVersion = fVersion == null ? null : fVersion.trim();
    }

    public String getfTag() {
        return fTag;
    }

    public void setfTag(String fTag) {
        this.fTag = fTag == null ? null : fTag.trim();
    }

    public String getfPacktype() {
        return fPacktype;
    }

    public void setfPacktype(String fPacktype) {
        this.fPacktype = fPacktype == null ? null : fPacktype.trim();
    }

    public String getfSource() {
        return fSource;
    }

    public void setfSource(String fSource) {
        this.fSource = fSource == null ? null : fSource.trim();
    }

    public String getfDatatype() {
        return fDatatype;
    }

    public void setfDatatype(String fDatatype) {
        this.fDatatype = fDatatype == null ? null : fDatatype.trim();
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
        BInstructionReplyStorage other = (BInstructionReplyStorage) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfHeadmark() == null ? other.getfHeadmark() == null : this.getfHeadmark().equals(other.getfHeadmark()))
            && (this.getfVersion() == null ? other.getfVersion() == null : this.getfVersion().equals(other.getfVersion()))
            && (this.getfTag() == null ? other.getfTag() == null : this.getfTag().equals(other.getfTag()))
            && (this.getfPacktype() == null ? other.getfPacktype() == null : this.getfPacktype().equals(other.getfPacktype()))
            && (this.getfSource() == null ? other.getfSource() == null : this.getfSource().equals(other.getfSource()))
            && (this.getfDatatype() == null ? other.getfDatatype() == null : this.getfDatatype().equals(other.getfDatatype()))
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
        result = prime * result + ((getfHeadmark() == null) ? 0 : getfHeadmark().hashCode());
        result = prime * result + ((getfVersion() == null) ? 0 : getfVersion().hashCode());
        result = prime * result + ((getfTag() == null) ? 0 : getfTag().hashCode());
        result = prime * result + ((getfPacktype() == null) ? 0 : getfPacktype().hashCode());
        result = prime * result + ((getfSource() == null) ? 0 : getfSource().hashCode());
        result = prime * result + ((getfDatatype() == null) ? 0 : getfDatatype().hashCode());
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
        sb.append(", fHeadmark=").append(fHeadmark);
        sb.append(", fVersion=").append(fVersion);
        sb.append(", fTag=").append(fTag);
        sb.append(", fPacktype=").append(fPacktype);
        sb.append(", fSource=").append(fSource);
        sb.append(", fDatatype=").append(fDatatype);
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