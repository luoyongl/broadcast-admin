package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BProgramChannel implements Serializable {
    private Integer fId;

    private String fPassNumber;

    private String fModulation;

    private String fPassName;

    private Integer fPassType;

    private Integer fControlDevice;

    private String fBroadcastArea;

    private Byte fPriority;

    private String fNitId;

    private String fPcrpId;

    private String fServiceId;

    private String fTsId;

    private Integer fMediaType;

    private String fMediaUrl;

    private String fAudioPid;

    private String fRdsOutput;

    private String fOutputAddress;

    private Short fOutputPort;

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

    public String getfPassNumber() {
        return fPassNumber;
    }

    public void setfPassNumber(String fPassNumber) {
        this.fPassNumber = fPassNumber == null ? null : fPassNumber.trim();
    }

    public String getfModulation() {
        return fModulation;
    }

    public void setfModulation(String fModulation) {
        this.fModulation = fModulation == null ? null : fModulation.trim();
    }

    public String getfPassName() {
        return fPassName;
    }

    public void setfPassName(String fPassName) {
        this.fPassName = fPassName == null ? null : fPassName.trim();
    }

    public Integer getfPassType() {
        return fPassType;
    }

    public void setfPassType(Integer fPassType) {
        this.fPassType = fPassType;
    }

    public Integer getfControlDevice() {
        return fControlDevice;
    }

    public void setfControlDevice(Integer fControlDevice) {
        this.fControlDevice = fControlDevice;
    }

    public String getfBroadcastArea() {
        return fBroadcastArea;
    }

    public void setfBroadcastArea(String fBroadcastArea) {
        this.fBroadcastArea = fBroadcastArea == null ? null : fBroadcastArea.trim();
    }

    public Byte getfPriority() {
        return fPriority;
    }

    public void setfPriority(Byte fPriority) {
        this.fPriority = fPriority;
    }

    public String getfNitId() {
        return fNitId;
    }

    public void setfNitId(String fNitId) {
        this.fNitId = fNitId == null ? null : fNitId.trim();
    }

    public String getfPcrpId() {
        return fPcrpId;
    }

    public void setfPcrpId(String fPcrpId) {
        this.fPcrpId = fPcrpId == null ? null : fPcrpId.trim();
    }

    public String getfServiceId() {
        return fServiceId;
    }

    public void setfServiceId(String fServiceId) {
        this.fServiceId = fServiceId == null ? null : fServiceId.trim();
    }

    public String getfTsId() {
        return fTsId;
    }

    public void setfTsId(String fTsId) {
        this.fTsId = fTsId == null ? null : fTsId.trim();
    }

    public Integer getfMediaType() {
        return fMediaType;
    }

    public void setfMediaType(Integer fMediaType) {
        this.fMediaType = fMediaType;
    }

    public String getfMediaUrl() {
        return fMediaUrl;
    }

    public void setfMediaUrl(String fMediaUrl) {
        this.fMediaUrl = fMediaUrl == null ? null : fMediaUrl.trim();
    }

    public String getfAudioPid() {
        return fAudioPid;
    }

    public void setfAudioPid(String fAudioPid) {
        this.fAudioPid = fAudioPid == null ? null : fAudioPid.trim();
    }

    public String getfRdsOutput() {
        return fRdsOutput;
    }

    public void setfRdsOutput(String fRdsOutput) {
        this.fRdsOutput = fRdsOutput == null ? null : fRdsOutput.trim();
    }

    public String getfOutputAddress() {
        return fOutputAddress;
    }

    public void setfOutputAddress(String fOutputAddress) {
        this.fOutputAddress = fOutputAddress == null ? null : fOutputAddress.trim();
    }

    public Short getfOutputPort() {
        return fOutputPort;
    }

    public void setfOutputPort(Short fOutputPort) {
        this.fOutputPort = fOutputPort;
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
        BProgramChannel other = (BProgramChannel) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfPassNumber() == null ? other.getfPassNumber() == null : this.getfPassNumber().equals(other.getfPassNumber()))
            && (this.getfModulation() == null ? other.getfModulation() == null : this.getfModulation().equals(other.getfModulation()))
            && (this.getfPassName() == null ? other.getfPassName() == null : this.getfPassName().equals(other.getfPassName()))
            && (this.getfPassType() == null ? other.getfPassType() == null : this.getfPassType().equals(other.getfPassType()))
            && (this.getfControlDevice() == null ? other.getfControlDevice() == null : this.getfControlDevice().equals(other.getfControlDevice()))
            && (this.getfBroadcastArea() == null ? other.getfBroadcastArea() == null : this.getfBroadcastArea().equals(other.getfBroadcastArea()))
            && (this.getfPriority() == null ? other.getfPriority() == null : this.getfPriority().equals(other.getfPriority()))
            && (this.getfNitId() == null ? other.getfNitId() == null : this.getfNitId().equals(other.getfNitId()))
            && (this.getfPcrpId() == null ? other.getfPcrpId() == null : this.getfPcrpId().equals(other.getfPcrpId()))
            && (this.getfServiceId() == null ? other.getfServiceId() == null : this.getfServiceId().equals(other.getfServiceId()))
            && (this.getfTsId() == null ? other.getfTsId() == null : this.getfTsId().equals(other.getfTsId()))
            && (this.getfMediaType() == null ? other.getfMediaType() == null : this.getfMediaType().equals(other.getfMediaType()))
            && (this.getfMediaUrl() == null ? other.getfMediaUrl() == null : this.getfMediaUrl().equals(other.getfMediaUrl()))
            && (this.getfAudioPid() == null ? other.getfAudioPid() == null : this.getfAudioPid().equals(other.getfAudioPid()))
            && (this.getfRdsOutput() == null ? other.getfRdsOutput() == null : this.getfRdsOutput().equals(other.getfRdsOutput()))
            && (this.getfOutputAddress() == null ? other.getfOutputAddress() == null : this.getfOutputAddress().equals(other.getfOutputAddress()))
            && (this.getfOutputPort() == null ? other.getfOutputPort() == null : this.getfOutputPort().equals(other.getfOutputPort()))
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
        result = prime * result + ((getfPassNumber() == null) ? 0 : getfPassNumber().hashCode());
        result = prime * result + ((getfModulation() == null) ? 0 : getfModulation().hashCode());
        result = prime * result + ((getfPassName() == null) ? 0 : getfPassName().hashCode());
        result = prime * result + ((getfPassType() == null) ? 0 : getfPassType().hashCode());
        result = prime * result + ((getfControlDevice() == null) ? 0 : getfControlDevice().hashCode());
        result = prime * result + ((getfBroadcastArea() == null) ? 0 : getfBroadcastArea().hashCode());
        result = prime * result + ((getfPriority() == null) ? 0 : getfPriority().hashCode());
        result = prime * result + ((getfNitId() == null) ? 0 : getfNitId().hashCode());
        result = prime * result + ((getfPcrpId() == null) ? 0 : getfPcrpId().hashCode());
        result = prime * result + ((getfServiceId() == null) ? 0 : getfServiceId().hashCode());
        result = prime * result + ((getfTsId() == null) ? 0 : getfTsId().hashCode());
        result = prime * result + ((getfMediaType() == null) ? 0 : getfMediaType().hashCode());
        result = prime * result + ((getfMediaUrl() == null) ? 0 : getfMediaUrl().hashCode());
        result = prime * result + ((getfAudioPid() == null) ? 0 : getfAudioPid().hashCode());
        result = prime * result + ((getfRdsOutput() == null) ? 0 : getfRdsOutput().hashCode());
        result = prime * result + ((getfOutputAddress() == null) ? 0 : getfOutputAddress().hashCode());
        result = prime * result + ((getfOutputPort() == null) ? 0 : getfOutputPort().hashCode());
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
        sb.append(", fPassNumber=").append(fPassNumber);
        sb.append(", fModulation=").append(fModulation);
        sb.append(", fPassName=").append(fPassName);
        sb.append(", fPassType=").append(fPassType);
        sb.append(", fControlDevice=").append(fControlDevice);
        sb.append(", fBroadcastArea=").append(fBroadcastArea);
        sb.append(", fPriority=").append(fPriority);
        sb.append(", fNitId=").append(fNitId);
        sb.append(", fPcrpId=").append(fPcrpId);
        sb.append(", fServiceId=").append(fServiceId);
        sb.append(", fTsId=").append(fTsId);
        sb.append(", fMediaType=").append(fMediaType);
        sb.append(", fMediaUrl=").append(fMediaUrl);
        sb.append(", fAudioPid=").append(fAudioPid);
        sb.append(", fRdsOutput=").append(fRdsOutput);
        sb.append(", fOutputAddress=").append(fOutputAddress);
        sb.append(", fOutputPort=").append(fOutputPort);
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