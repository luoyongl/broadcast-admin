package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class BPictureAdsVO implements Serializable {

	/**
	 * 
	 */

	private Integer fId;

	private String fImageName;

	private String fAddress;

	private Boolean fSendAllDates;

	private Date fSendStartDate;

	private Date fSendEndDate;

	private Boolean fSendAllTimes;

	private Date fSendStartTime;

	private Date fSendEndTime;

	private String fBroadcastArea;

	private Integer fRollInterval;

	private String fRemark;

	private Byte fSort;

	private Date fCreateTime;

	private Integer fCreatorId;

	private Date fUpdateTime;

	private Integer fOperatorId;

	private Boolean fDeleteFlag;
	private static final long serialVersionUID = 1L;

	private String fRealArea;

	private String creator;

	private String operator;

	private String fState;
	
	private String fDevice;
	
	private String fResourceCode;

	
	public String getfResourceCode() {
		return fResourceCode;
	}

	public void setfResourceCode(String fResourceCode) {
		this.fResourceCode = fResourceCode;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getfImageName() {
		return fImageName;
	}

	public void setfImageName(String fImageName) {
		this.fImageName = fImageName;
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}

	public Boolean getfSendAllDates() {
		return fSendAllDates;
	}

	public void setfSendAllDates(Boolean fSendAllDates) {
		this.fSendAllDates = fSendAllDates;
	}

	public Date getfSendStartDate() {
		return fSendStartDate;
	}

	public void setfSendStartDate(Date fSendStartDate) {
		this.fSendStartDate = fSendStartDate;
	}

	public Date getfSendEndDate() {
		return fSendEndDate;
	}

	public void setfSendEndDate(Date fSendEndDate) {
		this.fSendEndDate = fSendEndDate;
	}

	public Boolean getfSendAllTimes() {
		return fSendAllTimes;
	}

	public void setfSendAllTimes(Boolean fSendAllTimes) {
		this.fSendAllTimes = fSendAllTimes;
	}

	public Date getfSendStartTime() {
		return fSendStartTime;
	}

	public void setfSendStartTime(Date fSendStartTime) {
		this.fSendStartTime = fSendStartTime;
	}

	public Date getfSendEndTime() {
		return fSendEndTime;
	}

	public void setfSendEndTime(Date fSendEndTime) {
		this.fSendEndTime = fSendEndTime;
	}

	public String getfBroadcastArea() {
		return fBroadcastArea;
	}

	public void setfBroadcastArea(String fBroadcastArea) {
		this.fBroadcastArea = fBroadcastArea;
	}

	public Integer getfRollInterval() {
		return fRollInterval;
	}

	public void setfRollInterval(Integer fRollInterval) {
		this.fRollInterval = fRollInterval;
	}

	public String getfRemark() {
		return fRemark;
	}

	public void setfRemark(String fRemark) {
		this.fRemark = fRemark;
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

	public String getfState() {
		return fState;
	}

	public void setfState(String fState) {
		this.fState = fState;
	}

	public String getfDevice() {
		return fDevice;
	}

	public void setfDevice(String fDevice) {
		this.fDevice = fDevice;
	}
		
}
