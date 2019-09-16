package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class BRollingSubtitlesVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer fId;

	private String fTitle;

	private String fAddress;

	private Date fStartDate;

	private Date fEndDate;

	private Date fStartTime;

	private Date fEndTime;

	private String fBroadcastArea;

	private String fRemark;

	private Byte fSort;

	private Date fCreateTime;

	private Integer fCreatorId;

	private Date fUpdateTime;

	private Integer fOperatorId;

	private Boolean fDeleteFlag;

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

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
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

	public String getfBroadcastArea() {
		return fBroadcastArea;
	}

	public void setfBroadcastArea(String fBroadcastArea) {
		this.fBroadcastArea = fBroadcastArea;
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
