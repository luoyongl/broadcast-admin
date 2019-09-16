package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-14 18:47
 */
public class BProgramChannelVO implements Serializable {

	private static final long serialVersionUID = -8044948023216317538L;

	private Integer fId;

    private String fPassNumber;

    private String fModulation;

    private String fPassName;

    private Integer fPassTypeKey;

    private String fPassTypeValue;

    private Integer fControlDeviceKey;

    private String fControlDeviceValue;

    private String fBroadcastArea;

    private Byte fPriority;

    private String fNitId;

    private String fPcrpId;

    private String fServiceId;

    private String fTsId;

    private Integer fMediaType;

    private String fMediaUrl;

    private String urlValue;

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

    public String getUrlValue() {
        return urlValue;
    }

    public void setUrlValue(String urlValue) {
        this.urlValue = urlValue;
    }

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
        this.fPassNumber = fPassNumber;
    }

    public String getfModulation() {
        return fModulation;
    }

    public void setfModulation(String fModulation) {
        this.fModulation = fModulation;
    }

    public String getfPassName() {
        return fPassName;
    }

    public void setfPassName(String fPassName) {
        this.fPassName = fPassName;
    }

    public Integer getfPassTypeKey() {
        return fPassTypeKey;
    }

    public void setfPassTypeKey(Integer fPassTypeKey) {
        this.fPassTypeKey = fPassTypeKey;
    }

    public String getfPassTypeValue() {
        return fPassTypeValue;
    }

    public void setfPassTypeValue(String fPassTypeValue) {
        this.fPassTypeValue = fPassTypeValue;
    }

    public Integer getfControlDeviceKey() {
        return fControlDeviceKey;
    }

    public void setfControlDeviceKey(Integer fControlDeviceKey) {
        this.fControlDeviceKey = fControlDeviceKey;
    }

    public String getfControlDeviceValue() {
        return fControlDeviceValue;
    }

    public void setfControlDeviceValue(String fControlDeviceValue) {
        this.fControlDeviceValue = fControlDeviceValue;
    }

    public String getfBroadcastArea() {
        return fBroadcastArea;
    }

    public void setfBroadcastArea(String fBroadcastArea) {
        this.fBroadcastArea = fBroadcastArea;
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
        this.fNitId = fNitId;
    }

    public String getfPcrpId() {
        return fPcrpId;
    }

    public void setfPcrpId(String fPcrpId) {
        this.fPcrpId = fPcrpId;
    }

    public String getfServiceId() {
        return fServiceId;
    }

    public void setfServiceId(String fServiceId) {
        this.fServiceId = fServiceId;
    }

    public String getfTsId() {
        return fTsId;
    }

    public void setfTsId(String fTsId) {
        this.fTsId = fTsId;
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
        this.fMediaUrl = fMediaUrl;
    }

    public String getfAudioPid() {
        return fAudioPid;
    }

    public void setfAudioPid(String fAudioPid) {
        this.fAudioPid = fAudioPid;
    }

    public String getfRdsOutput() {
        return fRdsOutput;
    }

    public void setfRdsOutput(String fRdsOutput) {
        this.fRdsOutput = fRdsOutput;
    }

    public String getfOutputAddress() {
        return fOutputAddress;
    }

    public void setfOutputAddress(String fOutputAddress) {
        this.fOutputAddress = fOutputAddress;
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
    public String toString() {
        return "BProgramChannelVO{" +
                "fId=" + fId +
                ", fPassNumber='" + fPassNumber + '\'' +
                ", fModulation='" + fModulation + '\'' +
                ", fPassName='" + fPassName + '\'' +
                ", fPassTypeKey=" + fPassTypeKey +
                ", fPassTypeValue='" + fPassTypeValue + '\'' +
                ", fControlDeviceKey=" + fControlDeviceKey +
                ", fControlDeviceValue='" + fControlDeviceValue + '\'' +
                ", fBroadcastArea='" + fBroadcastArea + '\'' +
                ", fPriority=" + fPriority +
                ", fNitId='" + fNitId + '\'' +
                ", fPcrpId='" + fPcrpId + '\'' +
                ", fServiceId='" + fServiceId + '\'' +
                ", fTsId='" + fTsId + '\'' +
                ", fMediaType=" + fMediaType +
                ", fMediaUrl='" + fMediaUrl + '\'' +
                ", fAudioPid='" + fAudioPid + '\'' +
                ", fRdsOutput='" + fRdsOutput + '\'' +
                ", fOutputAddress='" + fOutputAddress + '\'' +
                ", fOutputPort=" + fOutputPort +
                ", fSort=" + fSort +
                ", fCreateTime=" + fCreateTime +
                ", fCreatorId=" + fCreatorId +
                ", fUpdateTime=" + fUpdateTime +
                ", fOperatorId=" + fOperatorId +
                ", fDeleteFlag=" + fDeleteFlag +
                '}';
    }
}
