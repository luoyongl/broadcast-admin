package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BSystemInfoRecord implements Serializable {
    private Integer fId;

    private Byte fInfoType;

    private Long fTotalValue;

    private Long fUsedValue;

    private Long fFreeValue;

    private String fPercentUsed;

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

    public Byte getfInfoType() {
        return fInfoType;
    }

    public void setfInfoType(Byte fInfoType) {
        this.fInfoType = fInfoType;
    }

    public Long getfTotalValue() {
        return fTotalValue;
    }

    public void setfTotalValue(Long fTotalValue) {
        this.fTotalValue = fTotalValue;
    }

    public Long getfUsedValue() {
        return fUsedValue;
    }

    public void setfUsedValue(Long fUsedValue) {
        this.fUsedValue = fUsedValue;
    }

    public Long getfFreeValue() {
        return fFreeValue;
    }

    public void setfFreeValue(Long fFreeValue) {
        this.fFreeValue = fFreeValue;
    }

    public String getfPercentUsed() {
        return fPercentUsed;
    }

    public void setfPercentUsed(String fPercentUsed) {
        this.fPercentUsed = fPercentUsed == null ? null : fPercentUsed.trim();
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
        BSystemInfoRecord other = (BSystemInfoRecord) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfInfoType() == null ? other.getfInfoType() == null : this.getfInfoType().equals(other.getfInfoType()))
            && (this.getfTotalValue() == null ? other.getfTotalValue() == null : this.getfTotalValue().equals(other.getfTotalValue()))
            && (this.getfUsedValue() == null ? other.getfUsedValue() == null : this.getfUsedValue().equals(other.getfUsedValue()))
            && (this.getfFreeValue() == null ? other.getfFreeValue() == null : this.getfFreeValue().equals(other.getfFreeValue()))
            && (this.getfPercentUsed() == null ? other.getfPercentUsed() == null : this.getfPercentUsed().equals(other.getfPercentUsed()))
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
        result = prime * result + ((getfInfoType() == null) ? 0 : getfInfoType().hashCode());
        result = prime * result + ((getfTotalValue() == null) ? 0 : getfTotalValue().hashCode());
        result = prime * result + ((getfUsedValue() == null) ? 0 : getfUsedValue().hashCode());
        result = prime * result + ((getfFreeValue() == null) ? 0 : getfFreeValue().hashCode());
        result = prime * result + ((getfPercentUsed() == null) ? 0 : getfPercentUsed().hashCode());
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
        sb.append(", fInfoType=").append(fInfoType);
        sb.append(", fTotalValue=").append(fTotalValue);
        sb.append(", fUsedValue=").append(fUsedValue);
        sb.append(", fFreeValue=").append(fFreeValue);
        sb.append(", fPercentUsed=").append(fPercentUsed);
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