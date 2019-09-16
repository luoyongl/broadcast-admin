package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BBroadcastTiming implements Serializable {
    private Integer fId;

    private String fPlanName;

    private Integer fMessageType;

    private Integer fVolume;

    private Integer fMessageLevel;

    private Integer fDrillCategory;

    private String fAudioFile;

    private Integer fFrequentAudio;

    private String fBroadcastArea;

    private Date fStartDate;

    private Date fEndDate;

    private String fChooseWeek;

    private Date fStartTime;

    private Date fEndTime;

    private Integer fTimeInterval;

    private Date fSingleBroadcastTime;

    private Integer fRepeateTime;

    private Integer fControlDevice;

    private Integer fDeviceChannel;

    private String fBroadcastTo;

    private Integer fMessageSource;

    private Date fLastBroadcastTime;

    private Integer fBroadcastedTimes;

    private Byte fReviewFlag;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreateId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private Date fBeginTime;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfPlanName() {
        return fPlanName;
    }

    public void setfPlanName(String fPlanName) {
        this.fPlanName = fPlanName == null ? null : fPlanName.trim();
    }

    public Integer getfMessageType() {
        return fMessageType;
    }

    public void setfMessageType(Integer fMessageType) {
        this.fMessageType = fMessageType;
    }

    public Integer getfVolume() {
        return fVolume;
    }

    public void setfVolume(Integer fVolume) {
        this.fVolume = fVolume;
    }

    public Integer getfMessageLevel() {
        return fMessageLevel;
    }

    public void setfMessageLevel(Integer fMessageLevel) {
        this.fMessageLevel = fMessageLevel;
    }

    public Integer getfDrillCategory() {
        return fDrillCategory;
    }

    public void setfDrillCategory(Integer fDrillCategory) {
        this.fDrillCategory = fDrillCategory;
    }

    public String getfAudioFile() {
        return fAudioFile;
    }

    public void setfAudioFile(String fAudioFile) {
        this.fAudioFile = fAudioFile == null ? null : fAudioFile.trim();
    }

    public Integer getfFrequentAudio() {
        return fFrequentAudio;
    }

    public void setfFrequentAudio(Integer fFrequentAudio) {
        this.fFrequentAudio = fFrequentAudio;
    }

    public String getfBroadcastArea() {
        return fBroadcastArea;
    }

    public void setfBroadcastArea(String fBroadcastArea) {
        this.fBroadcastArea = fBroadcastArea == null ? null : fBroadcastArea.trim();
    }

    public Date getfStartDate() {
        return fStartDate;
    }

    public void setfStartDate(Date fStartDate) {
        this.fStartDate = fStartDate;
    }

    public Date getfEndDate() {
        return fEndDate;
    }

    public void setfEndDate(Date fEndDate) {
        this.fEndDate = fEndDate;
    }

    public String getfChooseWeek() {
        return fChooseWeek;
    }

    public void setfChooseWeek(String fChooseWeek) {
        this.fChooseWeek = fChooseWeek == null ? null : fChooseWeek.trim();
    }

    public Date getfStartTime() {
        return fStartTime;
    }

    public void setfStartTime(Date fStartTime) {
        this.fStartTime = fStartTime;
    }

    public Date getfEndTime() {
        return fEndTime;
    }

    public void setfEndTime(Date fEndTime) {
        this.fEndTime = fEndTime;
    }

    public Integer getfTimeInterval() {
        return fTimeInterval;
    }

    public void setfTimeInterval(Integer fTimeInterval) {
        this.fTimeInterval = fTimeInterval;
    }

    public Date getfSingleBroadcastTime() {
        return fSingleBroadcastTime;
    }

    public void setfSingleBroadcastTime(Date fSingleBroadcastTime) {
        this.fSingleBroadcastTime = fSingleBroadcastTime;
    }

    public Integer getfRepeateTime() {
        return fRepeateTime;
    }

    public void setfRepeateTime(Integer fRepeateTime) {
        this.fRepeateTime = fRepeateTime;
    }

    public Integer getfControlDevice() {
        return fControlDevice;
    }

    public void setfControlDevice(Integer fControlDevice) {
        this.fControlDevice = fControlDevice;
    }

    public Integer getfDeviceChannel() {
        return fDeviceChannel;
    }

    public void setfDeviceChannel(Integer fDeviceChannel) {
        this.fDeviceChannel = fDeviceChannel;
    }

    public String getfBroadcastTo() {
        return fBroadcastTo;
    }

    public void setfBroadcastTo(String fBroadcastTo) {
        this.fBroadcastTo = fBroadcastTo == null ? null : fBroadcastTo.trim();
    }

    public Integer getfMessageSource() {
        return fMessageSource;
    }

    public void setfMessageSource(Integer fMessageSource) {
        this.fMessageSource = fMessageSource;
    }

    public Date getfLastBroadcastTime() {
        return fLastBroadcastTime;
    }

    public void setfLastBroadcastTime(Date fLastBroadcastTime) {
        this.fLastBroadcastTime = fLastBroadcastTime;
    }

    public Integer getfBroadcastedTimes() {
        return fBroadcastedTimes;
    }

    public void setfBroadcastedTimes(Integer fBroadcastedTimes) {
        this.fBroadcastedTimes = fBroadcastedTimes;
    }

    public Byte getfReviewFlag() {
        return fReviewFlag;
    }

    public void setfReviewFlag(Byte fReviewFlag) {
        this.fReviewFlag = fReviewFlag;
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

    public Integer getfCreateId() {
        return fCreateId;
    }

    public void setfCreateId(Integer fCreateId) {
        this.fCreateId = fCreateId;
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

    public Date getfBeginTime() {
        return fBeginTime;
    }

    public void setfBeginTime(Date fBeginTime) {
        this.fBeginTime = fBeginTime;
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
        BBroadcastTiming other = (BBroadcastTiming) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfPlanName() == null ? other.getfPlanName() == null : this.getfPlanName().equals(other.getfPlanName()))
            && (this.getfMessageType() == null ? other.getfMessageType() == null : this.getfMessageType().equals(other.getfMessageType()))
            && (this.getfVolume() == null ? other.getfVolume() == null : this.getfVolume().equals(other.getfVolume()))
            && (this.getfMessageLevel() == null ? other.getfMessageLevel() == null : this.getfMessageLevel().equals(other.getfMessageLevel()))
            && (this.getfDrillCategory() == null ? other.getfDrillCategory() == null : this.getfDrillCategory().equals(other.getfDrillCategory()))
            && (this.getfAudioFile() == null ? other.getfAudioFile() == null : this.getfAudioFile().equals(other.getfAudioFile()))
            && (this.getfFrequentAudio() == null ? other.getfFrequentAudio() == null : this.getfFrequentAudio().equals(other.getfFrequentAudio()))
            && (this.getfBroadcastArea() == null ? other.getfBroadcastArea() == null : this.getfBroadcastArea().equals(other.getfBroadcastArea()))
            && (this.getfStartDate() == null ? other.getfStartDate() == null : this.getfStartDate().equals(other.getfStartDate()))
            && (this.getfEndDate() == null ? other.getfEndDate() == null : this.getfEndDate().equals(other.getfEndDate()))
            && (this.getfChooseWeek() == null ? other.getfChooseWeek() == null : this.getfChooseWeek().equals(other.getfChooseWeek()))
            && (this.getfStartTime() == null ? other.getfStartTime() == null : this.getfStartTime().equals(other.getfStartTime()))
            && (this.getfEndTime() == null ? other.getfEndTime() == null : this.getfEndTime().equals(other.getfEndTime()))
            && (this.getfTimeInterval() == null ? other.getfTimeInterval() == null : this.getfTimeInterval().equals(other.getfTimeInterval()))
            && (this.getfSingleBroadcastTime() == null ? other.getfSingleBroadcastTime() == null : this.getfSingleBroadcastTime().equals(other.getfSingleBroadcastTime()))
            && (this.getfRepeateTime() == null ? other.getfRepeateTime() == null : this.getfRepeateTime().equals(other.getfRepeateTime()))
            && (this.getfControlDevice() == null ? other.getfControlDevice() == null : this.getfControlDevice().equals(other.getfControlDevice()))
            && (this.getfDeviceChannel() == null ? other.getfDeviceChannel() == null : this.getfDeviceChannel().equals(other.getfDeviceChannel()))
            && (this.getfBroadcastTo() == null ? other.getfBroadcastTo() == null : this.getfBroadcastTo().equals(other.getfBroadcastTo()))
            && (this.getfMessageSource() == null ? other.getfMessageSource() == null : this.getfMessageSource().equals(other.getfMessageSource()))
            && (this.getfLastBroadcastTime() == null ? other.getfLastBroadcastTime() == null : this.getfLastBroadcastTime().equals(other.getfLastBroadcastTime()))
            && (this.getfBroadcastedTimes() == null ? other.getfBroadcastedTimes() == null : this.getfBroadcastedTimes().equals(other.getfBroadcastedTimes()))
            && (this.getfReviewFlag() == null ? other.getfReviewFlag() == null : this.getfReviewFlag().equals(other.getfReviewFlag()))
            && (this.getfSort() == null ? other.getfSort() == null : this.getfSort().equals(other.getfSort()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfCreateId() == null ? other.getfCreateId() == null : this.getfCreateId().equals(other.getfCreateId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()))
            && (this.getfBeginTime() == null ? other.getfBeginTime() == null : this.getfBeginTime().equals(other.getfBeginTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfPlanName() == null) ? 0 : getfPlanName().hashCode());
        result = prime * result + ((getfMessageType() == null) ? 0 : getfMessageType().hashCode());
        result = prime * result + ((getfVolume() == null) ? 0 : getfVolume().hashCode());
        result = prime * result + ((getfMessageLevel() == null) ? 0 : getfMessageLevel().hashCode());
        result = prime * result + ((getfDrillCategory() == null) ? 0 : getfDrillCategory().hashCode());
        result = prime * result + ((getfAudioFile() == null) ? 0 : getfAudioFile().hashCode());
        result = prime * result + ((getfFrequentAudio() == null) ? 0 : getfFrequentAudio().hashCode());
        result = prime * result + ((getfBroadcastArea() == null) ? 0 : getfBroadcastArea().hashCode());
        result = prime * result + ((getfStartDate() == null) ? 0 : getfStartDate().hashCode());
        result = prime * result + ((getfEndDate() == null) ? 0 : getfEndDate().hashCode());
        result = prime * result + ((getfChooseWeek() == null) ? 0 : getfChooseWeek().hashCode());
        result = prime * result + ((getfStartTime() == null) ? 0 : getfStartTime().hashCode());
        result = prime * result + ((getfEndTime() == null) ? 0 : getfEndTime().hashCode());
        result = prime * result + ((getfTimeInterval() == null) ? 0 : getfTimeInterval().hashCode());
        result = prime * result + ((getfSingleBroadcastTime() == null) ? 0 : getfSingleBroadcastTime().hashCode());
        result = prime * result + ((getfRepeateTime() == null) ? 0 : getfRepeateTime().hashCode());
        result = prime * result + ((getfControlDevice() == null) ? 0 : getfControlDevice().hashCode());
        result = prime * result + ((getfDeviceChannel() == null) ? 0 : getfDeviceChannel().hashCode());
        result = prime * result + ((getfBroadcastTo() == null) ? 0 : getfBroadcastTo().hashCode());
        result = prime * result + ((getfMessageSource() == null) ? 0 : getfMessageSource().hashCode());
        result = prime * result + ((getfLastBroadcastTime() == null) ? 0 : getfLastBroadcastTime().hashCode());
        result = prime * result + ((getfBroadcastedTimes() == null) ? 0 : getfBroadcastedTimes().hashCode());
        result = prime * result + ((getfReviewFlag() == null) ? 0 : getfReviewFlag().hashCode());
        result = prime * result + ((getfSort() == null) ? 0 : getfSort().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfCreateId() == null) ? 0 : getfCreateId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        result = prime * result + ((getfBeginTime() == null) ? 0 : getfBeginTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fPlanName=").append(fPlanName);
        sb.append(", fMessageType=").append(fMessageType);
        sb.append(", fVolume=").append(fVolume);
        sb.append(", fMessageLevel=").append(fMessageLevel);
        sb.append(", fDrillCategory=").append(fDrillCategory);
        sb.append(", fAudioFile=").append(fAudioFile);
        sb.append(", fFrequentAudio=").append(fFrequentAudio);
        sb.append(", fBroadcastArea=").append(fBroadcastArea);
        sb.append(", fStartDate=").append(fStartDate);
        sb.append(", fEndDate=").append(fEndDate);
        sb.append(", fChooseWeek=").append(fChooseWeek);
        sb.append(", fStartTime=").append(fStartTime);
        sb.append(", fEndTime=").append(fEndTime);
        sb.append(", fTimeInterval=").append(fTimeInterval);
        sb.append(", fSingleBroadcastTime=").append(fSingleBroadcastTime);
        sb.append(", fRepeateTime=").append(fRepeateTime);
        sb.append(", fControlDevice=").append(fControlDevice);
        sb.append(", fDeviceChannel=").append(fDeviceChannel);
        sb.append(", fBroadcastTo=").append(fBroadcastTo);
        sb.append(", fMessageSource=").append(fMessageSource);
        sb.append(", fLastBroadcastTime=").append(fLastBroadcastTime);
        sb.append(", fBroadcastedTimes=").append(fBroadcastedTimes);
        sb.append(", fReviewFlag=").append(fReviewFlag);
        sb.append(", fSort=").append(fSort);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fCreateId=").append(fCreateId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", fBeginTime=").append(fBeginTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}