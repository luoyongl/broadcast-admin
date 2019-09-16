package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class BReviewVO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6437447548916091681L;

	
	 private Integer fId;

     private Byte fBigClassification;

     private Byte fReviewType;

     private Integer fReviewObjectId;

     private Byte fReviewResult;

     private Date fReviewTime;

     private Integer fReviewer;

     private String fRemark;
     
     private String fBroadcastName;

     private Byte fBroadcastType;

     private Integer fControlDevice;

     //private Integer fProgramPass;

     private Integer fMessageType;

     private Byte fVolumeControl;

     private String fBroadcastTo;

     //private Integer fPassSelect;

     private Integer fMessageLevel;

     private String fBroadcastArea;

     private Integer fMessageSource;
     
     private Byte fSort;
     
     private Date fCreateTime;
     
     private Integer fCreateId;

     private Date fUpdtateTime;

     private Date fEffectiveTime;

     private Integer fOperatorId;

     private Boolean fDeleteFlag;
     
     private String creator;
     
     private String operator;
     
     private String reviewer;
     
     private String fRealControlDevice;
     
     private String fRealBroadcastTo;

	public Date getfEffectiveTime() {
		return fEffectiveTime;
	}

	public void setfEffectiveTime(Date fEffectiveTime) {
		this.fEffectiveTime = fEffectiveTime;
	}

	public String getfRealBroadcastTo() {
		return fRealBroadcastTo;
	}


	public void setfRealBroadcastTo(String fRealBroadcastTo) {
		this.fRealBroadcastTo = fRealBroadcastTo;
	}


	public String getfRealControlDevice() {
		return fRealControlDevice;
	}


	public void setfRealControlDevice(String fRealControlDevice) {
		this.fRealControlDevice = fRealControlDevice;
	}


	public String getReviewer() {
		return reviewer;
	}


	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}


	private String fRealMessageLevel;
  	 
  	 private String fRealArea;
  	 
  	 private String fRealMessageType;
  	 
  	 private String fRealMsgresource;

  	 private String fParentNode;

	public String getfParentNode() {
		return fParentNode;
	}

	public void setfParentNode(String fParentNode) {
		this.fParentNode = fParentNode;
	}

	public Integer getfId() {
		return fId;
	}


	public void setfId(Integer fId) {
		this.fId = fId;
	}


	public Byte getfBigClassification() {
		return fBigClassification;
	}


	public void setfBigClassification(Byte fBigClassification) {
		this.fBigClassification = fBigClassification;
	}


	public Byte getfReviewType() {
		return fReviewType;
	}


	public void setfReviewType(Byte fReviewType) {
		this.fReviewType = fReviewType;
	}


	public Integer getfReviewObjectId() {
		return fReviewObjectId;
	}


	public void setfReviewObjectId(Integer fReviewObjectId) {
		this.fReviewObjectId = fReviewObjectId;
	}


	public Byte getfReviewResult() {
		return fReviewResult;
	}


	public void setfReviewResult(Byte fReviewResult) {
		this.fReviewResult = fReviewResult;
	}


	public Date getfReviewTime() {
		return fReviewTime;
	}


	public void setfReviewTime(Date fReviewTime) {
		this.fReviewTime = fReviewTime;
	}


	public Integer getfReviewer() {
		return fReviewer;
	}


	public void setfReviewer(Integer fReviewer) {
		this.fReviewer = fReviewer;
	}


	public String getfRemark() {
		return fRemark;
	}


	public void setfRemark(String fRemark) {
		this.fRemark = fRemark;
	}


	public String getfBroadcastName() {
		return fBroadcastName;
	}


	public void setfBroadcastName(String fBroadcastName) {
		this.fBroadcastName = fBroadcastName;
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


	public String getfBroadcastTo() {
		return fBroadcastTo;
	}


	public void setfBroadcastTo(String fBroadcastTo) {
		this.fBroadcastTo = fBroadcastTo;
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
		this.fBroadcastArea = fBroadcastArea;
	}


	public Integer getfMessageSource() {
		return fMessageSource;
	}


	public void setfMessageSource(Integer fMessageSource) {
		this.fMessageSource = fMessageSource;
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


	public String getfRealMessageLevel() {
		return fRealMessageLevel;
	}


	public void setfRealMessageLevel(String fRealMessageLevel) {
		this.fRealMessageLevel = fRealMessageLevel;
	}


	public String getfRealArea() {
		return fRealArea;
	}


	public void setfRealArea(String fRealArea) {
		this.fRealArea = fRealArea;
	}


	public String getfRealMessageType() {
		return fRealMessageType;
	}


	public void setfRealMessageType(String fRealMessageType) {
		this.fRealMessageType = fRealMessageType;
	}


	public String getfRealMsgresource() {
		return fRealMsgresource;
	}


	public void setfRealMsgresource(String fRealMsgresource) {
		this.fRealMsgresource = fRealMsgresource;
	}
  	 
  	 
}