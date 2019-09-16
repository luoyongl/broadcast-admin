package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BBroadcastData implements Serializable {
    private Integer fId;

    private String fBroadcastName;

    private Byte fBroadcastType;

    private Integer fControlDevice;

    private String fDeviceResourcecode;

    private String fProgramPass;

    private Integer fMessageType;

    private Byte fVolumeControl;

    private Boolean fBroadcastStyle;

    private Integer fPassSelect;

    private Integer fMessageLevel;

    private String fBroadcastArea;

    private String fTextContent;

    private String fTextUrl;

    private Date fEffectiveTime;

    private Integer fMessageSource;

    private String fMessageCommandType;

    private Integer fBroadcastTerminalCount;

    private Integer fResponseTerminalCount;

    private Byte fState;

    private Byte fSort;

    private Date fCreateTime;

    private Date fEndTime;

    private Integer fCreateId;

    private Date fUpdtateTime;

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

    public String getfBroadcastName() {
        return fBroadcastName;
    }

    public void setfBroadcastName(String fBroadcastName) {
        this.fBroadcastName = fBroadcastName == null ? null : fBroadcastName.trim();
    }

    public Byte getfBroadcastType() {
        return fBroadcastType;
    }

    public void setfBroadcastType(Byte fBroadcastType) {
        this.fBroadcastType = fBroadcastType;
    }

    public Integer getfControlDevice() {
        return fControlDevice;
    }

    public void setfControlDevice(Integer fControlDevice) {
        this.fControlDevice = fControlDevice;
    }

    public String getfDeviceResourcecode() {
        return fDeviceResourcecode;
    }

    public void setfDeviceResourcecode(String fDeviceResourcecode) {
        this.fDeviceResourcecode = fDeviceResourcecode == null ? null : fDeviceResourcecode.trim();
    }

    public String getfProgramPass() {
        return fProgramPass;
    }

    public void setfProgramPass(String fProgramPass) {
        this.fProgramPass = fProgramPass == null ? null : fProgramPass.trim();
    }

    public Integer getfMessageType() {
        return fMessageType;
    }

    public void setfMessageType(Integer fMessageType) {
        this.fMessageType = fMessageType;
    }

    public Byte getfVolumeControl() {
        return fVolumeControl;
    }

    public void setfVolumeControl(Byte fVolumeControl) {
        this.fVolumeControl = fVolumeControl;
    }

    public Boolean getfBroadcastStyle() {
        return fBroadcastStyle;
    }

    public void setfBroadcastStyle(Boolean fBroadcastStyle) {
        this.fBroadcastStyle = fBroadcastStyle;
    }

    public Integer getfPassSelect() {
        return fPassSelect;
    }

    public void setfPassSelect(Integer fPassSelect) {
        this.fPassSelect = fPassSelect;
    }

    public Integer getfMessageLevel() {
        return fMessageLevel;
    }

    public void setfMessageLevel(Integer fMessageLevel) {
        this.fMessageLevel = fMessageLevel;
    }

    public String getfBroadcastArea() {
        return fBroadcastArea;
    }

    public void setfBroadcastArea(String fBroadcastArea) {
        this.fBroadcastArea = fBroadcastArea == null ? null : fBroadcastArea.trim();
    }

    public String getfTextContent() {
        return fTextContent;
    }

    public void setfTextContent(String fTextContent) {
        this.fTextContent = fTextContent == null ? null : fTextContent.trim();
    }

    public String getfTextUrl() {
        return fTextUrl;
    }

    public void setfTextUrl(String fTextUrl) {
        this.fTextUrl = fTextUrl == null ? null : fTextUrl.trim();
    }

    public Date getfEffectiveTime() {
        return fEffectiveTime;
    }

    public void setfEffectiveTime(Date fEffectiveTime) {
        this.fEffectiveTime = fEffectiveTime;
    }

    public Integer getfMessageSource() {
        return fMessageSource;
    }

    public void setfMessageSource(Integer fMessageSource) {
        this.fMessageSource = fMessageSource;
    }

    public String getfMessageCommandType() {
        return fMessageCommandType;
    }

    public void setfMessageCommandType(String fMessageCommandType) {
        this.fMessageCommandType = fMessageCommandType == null ? null : fMessageCommandType.trim();
    }

    public Integer getfBroadcastTerminalCount() {
        return fBroadcastTerminalCount;
    }

    public void setfBroadcastTerminalCount(Integer fBroadcastTerminalCount) {
        this.fBroadcastTerminalCount = fBroadcastTerminalCount;
    }

    public Integer getfResponseTerminalCount() {
        return fResponseTerminalCount;
    }

    public void setfResponseTerminalCount(Integer fResponseTerminalCount) {
        this.fResponseTerminalCount = fResponseTerminalCount;
    }

    public Byte getfState() {
        return fState;
    }

    public void setfState(Byte fState) {
        this.fState = fState;
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

    public Date getfEndTime() {
        return fEndTime;
    }

    public void setfEndTime(Date fEndTime) {
        this.fEndTime = fEndTime;
    }

    public Integer getfCreateId() {
        return fCreateId;
    }

    public void setfCreateId(Integer fCreateId) {
        this.fCreateId = fCreateId;
    }

    public Date getfUpdtateTime() {
        return fUpdtateTime;
    }

    public void setfUpdtateTime(Date fUpdtateTime) {
        this.fUpdtateTime = fUpdtateTime;
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
        BBroadcastData other = (BBroadcastData) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfBroadcastName() == null ? other.getfBroadcastName() == null : this.getfBroadcastName().equals(other.getfBroadcastName()))
            && (this.getfBroadcastType() == null ? other.getfBroadcastType() == null : this.getfBroadcastType().equals(other.getfBroadcastType()))
            && (this.getfControlDevice() == null ? other.getfControlDevice() == null : this.getfControlDevice().equals(other.getfControlDevice()))
            && (this.getfDeviceResourcecode() == null ? other.getfDeviceResourcecode() == null : this.getfDeviceResourcecode().equals(other.getfDeviceResourcecode()))
            && (this.getfProgramPass() == null ? other.getfProgramPass() == null : this.getfProgramPass().equals(other.getfProgramPass()))
            && (this.getfMessageType() == null ? other.getfMessageType() == null : this.getfMessageType().equals(other.getfMessageType()))
            && (this.getfVolumeControl() == null ? other.getfVolumeControl() == null : this.getfVolumeControl().equals(other.getfVolumeControl()))
            && (this.getfBroadcastStyle() == null ? other.getfBroadcastStyle() == null : this.getfBroadcastStyle().equals(other.getfBroadcastStyle()))
            && (this.getfPassSelect() == null ? other.getfPassSelect() == null : this.getfPassSelect().equals(other.getfPassSelect()))
            && (this.getfMessageLevel() == null ? other.getfMessageLevel() == null : this.getfMessageLevel().equals(other.getfMessageLevel()))
            && (this.getfBroadcastArea() == null ? other.getfBroadcastArea() == null : this.getfBroadcastArea().equals(other.getfBroadcastArea()))
            && (this.getfTextContent() == null ? other.getfTextContent() == null : this.getfTextContent().equals(other.getfTextContent()))
            && (this.getfTextUrl() == null ? other.getfTextUrl() == null : this.getfTextUrl().equals(other.getfTextUrl()))
            && (this.getfEffectiveTime() == null ? other.getfEffectiveTime() == null : this.getfEffectiveTime().equals(other.getfEffectiveTime()))
            && (this.getfMessageSource() == null ? other.getfMessageSource() == null : this.getfMessageSource().equals(other.getfMessageSource()))
            && (this.getfMessageCommandType() == null ? other.getfMessageCommandType() == null : this.getfMessageCommandType().equals(other.getfMessageCommandType()))
            && (this.getfBroadcastTerminalCount() == null ? other.getfBroadcastTerminalCount() == null : this.getfBroadcastTerminalCount().equals(other.getfBroadcastTerminalCount()))
            && (this.getfResponseTerminalCount() == null ? other.getfResponseTerminalCount() == null : this.getfResponseTerminalCount().equals(other.getfResponseTerminalCount()))
            && (this.getfState() == null ? other.getfState() == null : this.getfState().equals(other.getfState()))
            && (this.getfSort() == null ? other.getfSort() == null : this.getfSort().equals(other.getfSort()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfEndTime() == null ? other.getfEndTime() == null : this.getfEndTime().equals(other.getfEndTime()))
            && (this.getfCreateId() == null ? other.getfCreateId() == null : this.getfCreateId().equals(other.getfCreateId()))
            && (this.getfUpdtateTime() == null ? other.getfUpdtateTime() == null : this.getfUpdtateTime().equals(other.getfUpdtateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()))
            && (this.getfBeginTime() == null ? other.getfBeginTime() == null : this.getfBeginTime().equals(other.getfBeginTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfBroadcastName() == null) ? 0 : getfBroadcastName().hashCode());
        result = prime * result + ((getfBroadcastType() == null) ? 0 : getfBroadcastType().hashCode());
        result = prime * result + ((getfControlDevice() == null) ? 0 : getfControlDevice().hashCode());
        result = prime * result + ((getfDeviceResourcecode() == null) ? 0 : getfDeviceResourcecode().hashCode());
        result = prime * result + ((getfProgramPass() == null) ? 0 : getfProgramPass().hashCode());
        result = prime * result + ((getfMessageType() == null) ? 0 : getfMessageType().hashCode());
        result = prime * result + ((getfVolumeControl() == null) ? 0 : getfVolumeControl().hashCode());
        result = prime * result + ((getfBroadcastStyle() == null) ? 0 : getfBroadcastStyle().hashCode());
        result = prime * result + ((getfPassSelect() == null) ? 0 : getfPassSelect().hashCode());
        result = prime * result + ((getfMessageLevel() == null) ? 0 : getfMessageLevel().hashCode());
        result = prime * result + ((getfBroadcastArea() == null) ? 0 : getfBroadcastArea().hashCode());
        result = prime * result + ((getfTextContent() == null) ? 0 : getfTextContent().hashCode());
        result = prime * result + ((getfTextUrl() == null) ? 0 : getfTextUrl().hashCode());
        result = prime * result + ((getfEffectiveTime() == null) ? 0 : getfEffectiveTime().hashCode());
        result = prime * result + ((getfMessageSource() == null) ? 0 : getfMessageSource().hashCode());
        result = prime * result + ((getfMessageCommandType() == null) ? 0 : getfMessageCommandType().hashCode());
        result = prime * result + ((getfBroadcastTerminalCount() == null) ? 0 : getfBroadcastTerminalCount().hashCode());
        result = prime * result + ((getfResponseTerminalCount() == null) ? 0 : getfResponseTerminalCount().hashCode());
        result = prime * result + ((getfState() == null) ? 0 : getfState().hashCode());
        result = prime * result + ((getfSort() == null) ? 0 : getfSort().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfEndTime() == null) ? 0 : getfEndTime().hashCode());
        result = prime * result + ((getfCreateId() == null) ? 0 : getfCreateId().hashCode());
        result = prime * result + ((getfUpdtateTime() == null) ? 0 : getfUpdtateTime().hashCode());
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
        sb.append(", fBroadcastName=").append(fBroadcastName);
        sb.append(", fBroadcastType=").append(fBroadcastType);
        sb.append(", fControlDevice=").append(fControlDevice);
        sb.append(", fDeviceResourcecode=").append(fDeviceResourcecode);
        sb.append(", fProgramPass=").append(fProgramPass);
        sb.append(", fMessageType=").append(fMessageType);
        sb.append(", fVolumeControl=").append(fVolumeControl);
        sb.append(", fBroadcastStyle=").append(fBroadcastStyle);
        sb.append(", fPassSelect=").append(fPassSelect);
        sb.append(", fMessageLevel=").append(fMessageLevel);
        sb.append(", fBroadcastArea=").append(fBroadcastArea);
        sb.append(", fTextContent=").append(fTextContent);
        sb.append(", fTextUrl=").append(fTextUrl);
        sb.append(", fEffectiveTime=").append(fEffectiveTime);
        sb.append(", fMessageSource=").append(fMessageSource);
        sb.append(", fMessageCommandType=").append(fMessageCommandType);
        sb.append(", fBroadcastTerminalCount=").append(fBroadcastTerminalCount);
        sb.append(", fResponseTerminalCount=").append(fResponseTerminalCount);
        sb.append(", fState=").append(fState);
        sb.append(", fSort=").append(fSort);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fEndTime=").append(fEndTime);
        sb.append(", fCreateId=").append(fCreateId);
        sb.append(", fUpdtateTime=").append(fUpdtateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", fBeginTime=").append(fBeginTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}