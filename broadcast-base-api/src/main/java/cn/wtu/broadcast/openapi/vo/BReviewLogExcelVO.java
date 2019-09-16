package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @description 审核日志Excel导出表格信息VO
 * @author LiLinFeng
 * @Date 2019-01-14
 */
public class BReviewLogExcelVO implements Serializable {

	private static final long serialVersionUID = 1949845165766569842L;

	@Excel(name="广播类型", orderNum="1")
	private Byte fBroadcastType;
	
	@Excel(name="广播ID", orderNum="2")
	private Integer fReviewObjectId;
	
	@Excel(name="消息类型", orderNum="3")
	private String fRealMessageType;
	
	@Excel(name="消息级别", orderNum="4")
	private String fRealMessageLevel;

	@Excel(name="控制设备", orderNum="5")
	private String fRealControlDevice;

	@Excel(name="音量控制", orderNum="6")
	private Byte fVolumeControl;
	
	@Excel(name="创建者", orderNum="7")
	private String creator;

	@Excel(name="创建时间", orderNum="8", exportFormat = "yyyy-MM-dd HH:mm:ss")
	private Date fCreateTime;
	
	@Excel(name="审核人", orderNum="9")
	private String reviewer;
	
	@Excel(name="审核时间", orderNum="10", exportFormat = "yyyy-MM-dd HH:mm:ss")
	private Date fReviewTime;
	
	@Excel(name="审核结果", orderNum="11")
	private Byte fReviewResult;
	
	@Excel(name="审核意见", orderNum="12")
	private String fRemark;
	
	@Excel(name="播发去向", orderNum="13")
	private String fRealBroadcastTo;
	
	@Excel(name="播发区域", orderNum="14")
	private String fRealArea;

	public Byte getfBroadcastType() {
		return fBroadcastType;
	}

	public void setfBroadcastType(Byte fBroadcastType) {
		this.fBroadcastType = fBroadcastType;
	}

	public Integer getfReviewObjectId() {
		return fReviewObjectId;
	}

	public void setfReviewObjectId(Integer fReviewObjectId) {
		this.fReviewObjectId = fReviewObjectId;
	}

	public String getfRealMessageType() {
		return fRealMessageType;
	}

	public void setfRealMessageType(String fRealMessageType) {
		this.fRealMessageType = fRealMessageType;
	}

	public String getfRealMessageLevel() {
		return fRealMessageLevel;
	}

	public void setfRealMessageLevel(String fRealMessageLevel) {
		this.fRealMessageLevel = fRealMessageLevel;
	}

	public String getfRealControlDevice() {
		return fRealControlDevice;
	}

	public void setfRealControlDevice(String fRealControlDevice) {
		this.fRealControlDevice = fRealControlDevice;
	}

	public Byte getfVolumeControl() {
		return fVolumeControl;
	}

	public void setfVolumeControl(Byte fVolumeControl) {
		this.fVolumeControl = fVolumeControl;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getfCreateTime() {
		return fCreateTime;
	}

	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public Date getfReviewTime() {
		return fReviewTime;
	}

	public void setfReviewTime(Date fReviewTime) {
		this.fReviewTime = fReviewTime;
	}

	public Byte getfReviewResult() {
		return fReviewResult;
	}

	public void setfReviewResult(Byte fReviewResult) {
		this.fReviewResult = fReviewResult;
	}

	public String getfRemark() {
		return fRemark;
	}

	public void setfRemark(String fRemark) {
		this.fRemark = fRemark;
	}

	public String getfRealBroadcastTo() {
		return fRealBroadcastTo;
	}

	public void setfRealBroadcastTo(String fRealBroadcastTo) {
		this.fRealBroadcastTo = fRealBroadcastTo;
	}

	public String getfRealArea() {
		return fRealArea;
	}

	public void setfRealArea(String fRealArea) {
		this.fRealArea = fRealArea;
	}
	
	
	
}
