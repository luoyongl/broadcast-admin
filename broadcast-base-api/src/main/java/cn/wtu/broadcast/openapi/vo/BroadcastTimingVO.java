package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class BroadcastTimingVO implements Serializable{

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

    private String fParentNode;
    
    //播发去向
    private String fRealBroadcastTo;
    
    //消息来源
    private String fRealMessageSource;
    
    //设备通道
    private String fRealPassSelect;
    
    //控制设备
    private String fRealProgramPass;

	//消息级别
	private String fRealMessageLevel;
    
	//消息类型
    private String fRealMessageType;
    
	//显示音频文件
    private String fAudioFileName;
    
    //显示调频
    private String fFMFileName;

	//显示开始结束时间
    private String fStartAndEndTime;
    
    //创建时间
    private String fCreateTimes;
    
    //详情显示开始时间
    private String fDetailStartTime;
    
    //详情显示结束时间
    private String fDetailEndTime;
    
    //地域
    private String fRealArea;
    
    //创建者
    private String creator;
    
    //操作者
    private String operator;
    
    //开始时间（日期+时间）
    private String fstartDateTime;
    
    //结束时间（日期+时间）
    private String fendDateTime;
    
	private static final long serialVersionUID = 1L;
    
	public String getfFMFileName() {
		return fFMFileName;
	}

	public void setfFMFileName(String fFMFileName) {
		this.fFMFileName = fFMFileName;
	}
	
	public String getFstartDateTime() {
		return fstartDateTime;
	}

	public void setFstartDateTime(String fstartDateTime) {
		this.fstartDateTime = fstartDateTime;
	}

	public String getFendDateTime() {
		return fendDateTime;
	}

	public void setFendDateTime(String fendDateTime) {
		this.fendDateTime = fendDateTime;
	}

	
    public String getfRealBroadcastTo() {
		return fRealBroadcastTo;
	}

	public void setfRealBroadcastTo(String fRealBroadcastTo) {
		this.fRealBroadcastTo = fRealBroadcastTo;
	}

	public String getfRealMessageSource() {
		return fRealMessageSource;
	}

	public void setfRealMessageSource(String fRealMessageSource) {
		this.fRealMessageSource = fRealMessageSource;
	}

	public String getfRealPassSelect() {
		return fRealPassSelect;
	}

	public void setfRealPassSelect(String fRealPassSelect) {
		this.fRealPassSelect = fRealPassSelect;
	}

	public String getfRealProgramPass() {
		return fRealProgramPass;
	}

	public void setfRealProgramPass(String fRealProgramPass) {
		this.fRealProgramPass = fRealProgramPass;
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
		this.fBroadcastTo = fBroadcastTo;
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
    
    public String getfRealMessageLevel() {
		return fRealMessageLevel;
	}

	public void setfRealMessageLevel(String fRealMessageLevel) {
		this.fRealMessageLevel = fRealMessageLevel;
	}

	public String getfRealMessageType() {
		return fRealMessageType;
	}

	public void setfRealMessageType(String fRealMessageType) {
		this.fRealMessageType = fRealMessageType;
	}
    
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
		this.fPlanName = fPlanName;
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
		this.fBroadcastArea = fBroadcastArea;
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
		this.fChooseWeek = fChooseWeek;
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

	public Integer getfRepeateTime() {
		return fRepeateTime;
	}

	public void setfRepeateTime(Integer fRepeateTime) {
		this.fRepeateTime = fRepeateTime;
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
		this.fAudioFile = fAudioFile;
	}

	public Date getfSingleBroadcastTime() {
		return fSingleBroadcastTime;
	}

	public void setfSingleBroadcastTime(Date fSingleBroadcastTime) {
		this.fSingleBroadcastTime = fSingleBroadcastTime;
	}

	public String getfAudioFileName() {
		return fAudioFileName;
	}

	public void setfAudioFileName(String fAudioFileName) {
		this.fAudioFileName = fAudioFileName;
	}

	public String getfStartAndEndTime() {
		return fStartAndEndTime;
	}

	public void setfStartAndEndTime(String fStartAndEndTime) {
		this.fStartAndEndTime = fStartAndEndTime;
	}

	public String getfCreateTimes() {
		return fCreateTimes;
	}

	public void setfCreateTimes(String fCreateTimes) {
		this.fCreateTimes = fCreateTimes;
	}

	public String getfDetailStartTime() {
		return fDetailStartTime;
	}

	public void setfDetailStartTime(String fDetailStartTime) {
		this.fDetailStartTime = fDetailStartTime;
	}

	public String getfDetailEndTime() {
		return fDetailEndTime;
	}

	public void setfDetailEndTime(String fDetailEndTime) {
		this.fDetailEndTime = fDetailEndTime;
	}

	public String getfRealArea() {
		return fRealArea;
	}

	public void setfRealArea(String fRealArea) {
		this.fRealArea = fRealArea;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getfParentNode() {
		return fParentNode;
	}

	public void setfParentNode(String fParentNode) {
		this.fParentNode = fParentNode;
	}
}
