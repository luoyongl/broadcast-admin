package cn.wtu.broadcast.openapi.vo;

import cn.wtu.broadcast.openapi.model.BBroadcastData;

import java.io.Serializable;

public class BroadCastDataVO extends BBroadcastData implements Serializable{
	
	/*private Integer fId;

    private String fBroadcastName;

    private Byte fBroadcastType;

    private Integer fControlDevice;

    private Integer fProgramPass;

    private Integer fMessageType;

    private Byte fVolumeControl;

    private String fBroadcastTo;

    private Integer fPassSelect;

	private Date fEffectiveTime;

    private Integer fMessageLevel;

    private String fBroadcastArea;

    private Integer fMessageSource;

    private String fMessageCommandType;

    private Integer fBroadcastTerminalCount;

    private Integer fResponseTerminalCount;

    private Byte fState;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreateId;

    private Date fUpdtateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;*/

	private String fRealArea;

	private String fRealMessageLevel;
	
	private String fRealBroadcastTo;
    
	private String fRealMessageType;
    
    private String fRealMessageSource;
    
	private String fRealProgramPass;
    
    private String fRealPassSelect;
    
	private String fRealControlDevice;
    
    private String creator;
    
    private String operator;
    
    private String realState;

    private String fDeviceName;

    private String fDeviceCode;

    private String fParentNode;
    
    private static final long serialVersionUID = 1L;

	public String getfRealArea() {
		return fRealArea;
	}

	public void setfRealArea(String fRealArea) {
		this.fRealArea = fRealArea;
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

	public String getfRealProgramPass() {
		return fRealProgramPass;
	}

	public void setfRealProgramPass(String fRealProgramPass) {
		this.fRealProgramPass = fRealProgramPass;
	}

	public String getfRealPassSelect() {
		return fRealPassSelect;
	}

	public void setfRealPassSelect(String fRealPassSelect) {
		this.fRealPassSelect = fRealPassSelect;
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

	public String getRealState() {
		return realState;
	}
	
	

	public String getfRealMessageSource() {
		return fRealMessageSource;
	}

	public void setfRealMessageSource(String fRealMessageSource) {
		this.fRealMessageSource = fRealMessageSource;
	}

	public void setRealState(String realState) {
		this.realState = realState;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getfDeviceName() {
		return fDeviceName;
	}

	public void setfDeviceName(String fDeviceName) {
		this.fDeviceName = fDeviceName;
	}

	public String getfDeviceCode() {
		return fDeviceCode;
	}

	public void setfDeviceCode(String fDeviceCode) {
		this.fDeviceCode = fDeviceCode;
	}

	public String getfParentNode() {
		return fParentNode;
	}

	public void setfParentNode(String fParentNode) {
		this.fParentNode = fParentNode;
	}
}
