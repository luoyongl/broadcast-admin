package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BCallandsmsRecord implements Serializable {
    private Integer fId;

    private String fTelephoneNumber;

    private Integer fControlDevice;

    private Date fCreateTime;

    private String fName;

    private Date fUpdateTime;

    private Integer fCreatorId;

    private Integer fOperatorId;

    private Integer fArea;

    private Integer fCallTime;

    private Byte fTelephoneType;

    private String fSmsContent;

    private String fAudioUrl;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfTelephoneNumber() {
        return fTelephoneNumber;
    }

    public void setfTelephoneNumber(String fTelephoneNumber) {
        this.fTelephoneNumber = fTelephoneNumber == null ? null : fTelephoneNumber.trim();
    }

    public Integer getfControlDevice() {
        return fControlDevice;
    }

    public void setfControlDevice(Integer fControlDevice) {
        this.fControlDevice = fControlDevice;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    public Integer getfCreatorId() {
        return fCreatorId;
    }

    public void setfCreatorId(Integer fCreatorId) {
        this.fCreatorId = fCreatorId;
    }

    public Integer getfOperatorId() {
        return fOperatorId;
    }

    public void setfOperatorId(Integer fOperatorId) {
        this.fOperatorId = fOperatorId;
    }

    public Integer getfArea() {
        return fArea;
    }

    public void setfArea(Integer fArea) {
        this.fArea = fArea;
    }

    public Integer getfCallTime() {
        return fCallTime;
    }

    public void setfCallTime(Integer fCallTime) {
        this.fCallTime = fCallTime;
    }

    public Byte getfTelephoneType() {
        return fTelephoneType;
    }

    public void setfTelephoneType(Byte fTelephoneType) {
        this.fTelephoneType = fTelephoneType;
    }

    public String getfSmsContent() {
        return fSmsContent;
    }

    public void setfSmsContent(String fSmsContent) {
        this.fSmsContent = fSmsContent == null ? null : fSmsContent.trim();
    }

    public String getfAudioUrl() {
        return fAudioUrl;
    }

    public void setfAudioUrl(String fAudioUrl) {
        this.fAudioUrl = fAudioUrl == null ? null : fAudioUrl.trim();
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
        BCallandsmsRecord other = (BCallandsmsRecord) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfTelephoneNumber() == null ? other.getfTelephoneNumber() == null : this.getfTelephoneNumber().equals(other.getfTelephoneNumber()))
            && (this.getfControlDevice() == null ? other.getfControlDevice() == null : this.getfControlDevice().equals(other.getfControlDevice()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfName() == null ? other.getfName() == null : this.getfName().equals(other.getfName()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfArea() == null ? other.getfArea() == null : this.getfArea().equals(other.getfArea()))
            && (this.getfCallTime() == null ? other.getfCallTime() == null : this.getfCallTime().equals(other.getfCallTime()))
            && (this.getfTelephoneType() == null ? other.getfTelephoneType() == null : this.getfTelephoneType().equals(other.getfTelephoneType()))
            && (this.getfSmsContent() == null ? other.getfSmsContent() == null : this.getfSmsContent().equals(other.getfSmsContent()))
            && (this.getfAudioUrl() == null ? other.getfAudioUrl() == null : this.getfAudioUrl().equals(other.getfAudioUrl()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfTelephoneNumber() == null) ? 0 : getfTelephoneNumber().hashCode());
        result = prime * result + ((getfControlDevice() == null) ? 0 : getfControlDevice().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfName() == null) ? 0 : getfName().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfArea() == null) ? 0 : getfArea().hashCode());
        result = prime * result + ((getfCallTime() == null) ? 0 : getfCallTime().hashCode());
        result = prime * result + ((getfTelephoneType() == null) ? 0 : getfTelephoneType().hashCode());
        result = prime * result + ((getfSmsContent() == null) ? 0 : getfSmsContent().hashCode());
        result = prime * result + ((getfAudioUrl() == null) ? 0 : getfAudioUrl().hashCode());
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
        sb.append(", fTelephoneNumber=").append(fTelephoneNumber);
        sb.append(", fControlDevice=").append(fControlDevice);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fName=").append(fName);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fArea=").append(fArea);
        sb.append(", fCallTime=").append(fCallTime);
        sb.append(", fTelephoneType=").append(fTelephoneType);
        sb.append(", fSmsContent=").append(fSmsContent);
        sb.append(", fAudioUrl=").append(fAudioUrl);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}