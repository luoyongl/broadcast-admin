package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class BVideoVo implements Serializable {
	private Integer fId;

	private String fVideoName;

	private String fAddress;

	private Boolean fSendAllDates;

	private Date fSendStartDate;

	private Date fSendEndDate;

	private Boolean fSendAllTimes;

	private Date fSendStartTime;

	private Date fSendEndTime;

	private String fBroadcastArea;

	private String fRemark;

	private Byte fSort;

	private Date fCreateTime;

	private Integer fCreatorId;

	private Date fUpdateTime;

	private Integer fOperatorId;

	private Boolean fDeleteFlag;

	private String creator;

	private String operator;

	private String fState;

	private String fDevice;

	private String fResourceCode;

	private static final long serialVersionUID = 1L;

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getfVideoName() {
		return fVideoName;
	}

	public void setfVideoName(String fVideoName) {
		this.fVideoName = fVideoName == null ? null : fVideoName.trim();
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress == null ? null : fAddress.trim();
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
		this.fBroadcastArea = fBroadcastArea == null ? null : fBroadcastArea.trim();
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

	public String getfResourceCode() {
		return fResourceCode;
	}

	public void setfResourceCode(String fResourceCode) {
		this.fResourceCode = fResourceCode;
	}
}