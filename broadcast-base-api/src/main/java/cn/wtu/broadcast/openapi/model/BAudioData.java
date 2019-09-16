package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LENOVO
 *
 */
public class BAudioData implements Serializable {
    private Integer fId;

    private String fAudioName;

    private String fAudioUrl;
    
    private String fAudioSize;
    
    private String fAudioType;

	private Integer fTime;

    private Integer fBitRate;

    private BigDecimal fSampleRate;

    private String fRemark;

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

    public String getfAudioName() {
        return fAudioName;
    }

    public void setfAudioName(String fAudioName) {
        this.fAudioName = fAudioName == null ? null : fAudioName.trim();
    }

    public String getfAudioUrl() {
        return fAudioUrl;
    }

    public void setfAudioUrl(String fAudioUrl) {
        this.fAudioUrl = fAudioUrl == null ? null : fAudioUrl.trim();
    }

    public String getfAudioSize() {
		return fAudioSize;
	}

	public void setfAudioSize(String fAudioSize) {
		this.fAudioSize = fAudioSize;
	}
    
    public Integer getfTime() {
        return fTime;
    }

    public void setfTime(Integer fTime) {
        this.fTime = fTime;
    }

    public Integer getfBitRate() {
        return fBitRate;
    }

    public void setfBitRate(Integer fBitRate) {
        this.fBitRate = fBitRate;
    }

    public BigDecimal getfSampleRate() {
        return fSampleRate;
    }

    public void setfSampleRate(BigDecimal fSampleRate) {
        this.fSampleRate = fSampleRate;
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
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
    
    public String getfAudioType() {
		return fAudioType;
	}

	public void setfAudioType(String fAudioType) {
		this.fAudioType = fAudioType;
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
        BAudioData other = (BAudioData) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfAudioName() == null ? other.getfAudioName() == null : this.getfAudioName().equals(other.getfAudioName()))
            && (this.getfAudioUrl() == null ? other.getfAudioUrl() == null : this.getfAudioUrl().equals(other.getfAudioUrl()))
            && (this.getfAudioSize() == null ? other.getfAudioSize() == null : this.getfAudioSize().equals(other.getfAudioSize()))
            && (this.getfTime() == null ? other.getfTime() == null : this.getfTime().equals(other.getfTime()))
            && (this.getfBitRate() == null ? other.getfBitRate() == null : this.getfBitRate().equals(other.getfBitRate()))
            && (this.getfSampleRate() == null ? other.getfSampleRate() == null : this.getfSampleRate().equals(other.getfSampleRate()))
            && (this.getfRemark() == null ? other.getfRemark() == null : this.getfRemark().equals(other.getfRemark()))
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
        result = prime * result + ((getfAudioName() == null) ? 0 : getfAudioName().hashCode());
        result = prime * result + ((getfAudioUrl() == null) ? 0 : getfAudioUrl().hashCode());
        result = prime * result + ((getfAudioSize() == null) ? 0 : getfAudioSize().hashCode());
        result = prime * result + ((getfTime() == null) ? 0 : getfTime().hashCode());
        result = prime * result + ((getfBitRate() == null) ? 0 : getfBitRate().hashCode());
        result = prime * result + ((getfSampleRate() == null) ? 0 : getfSampleRate().hashCode());
        result = prime * result + ((getfRemark() == null) ? 0 : getfRemark().hashCode());
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
        sb.append(", fAudioName=").append(fAudioName);
        sb.append(", fAudioUrl=").append(fAudioUrl);
        sb.append(", fAudioSize=").append(fAudioSize);
        sb.append(", fTime=").append(fTime);
        sb.append(", fBitRate=").append(fBitRate);
        sb.append(", fSampleRate=").append(fSampleRate);
        sb.append(", fRemark=").append(fRemark);
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