package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

import cn.wtu.broadcast.openapi.model.BBroadcastData;

/**
 * @Author: NewLinfeng
 * @Description:
 * @Date: Created in 14:55 on 2019/1/17.
 * @Modified_by:
 */
public class TerminalStatusVO extends BBroadcastData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fRealArea;

	private String fRealMessageLevel;

	private String fRealBroadcastTo;

	private String fRealMessageType;

	private String fRealMessageSource;

	private String fRealControlDevice;

	private String fCode;

	private String operator;

	private String fAudioUrl;

	private byte[] fAudioByte;

	private Integer fReturnAudioId;
	private String fAudioName;

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

	public String getfRealBroadcastTo() {
		return fRealBroadcastTo;
	}

	public void setfRealBroadcastTo(String fRealBroadcastTo) {
		this.fRealBroadcastTo = fRealBroadcastTo;
	}

	public String getfRealMessageType() {
		return fRealMessageType;
	}

	public void setfRealMessageType(String fRealMessageType) {
		this.fRealMessageType = fRealMessageType;
	}

	public String getfRealMessageSource() {
		return fRealMessageSource;
	}

	public void setfRealMessageSource(String fRealMessageSource) {
		this.fRealMessageSource = fRealMessageSource;
	}

	public String getfRealControlDevice() {
		return fRealControlDevice;
	}

	public void setfRealControlDevice(String fRealControlDevice) {
		this.fRealControlDevice = fRealControlDevice;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public byte[] getfAudioByte() {
		return fAudioByte;
	}

	public void setfAudioByte(byte[] fAudioByte) {
		this.fAudioByte = fAudioByte;
	}

	public String getfAudioUrl() {
		return fAudioUrl;
	}

	public void setfAudioUrl(String fAudioUrl) {
		this.fAudioUrl = fAudioUrl;
	}

	public Integer getfReturnAudioId() {
		return fReturnAudioId;
	}

	public void setfReturnAudioId(Integer fReturnAudioId) {
		this.fReturnAudioId = fReturnAudioId;
	}

	public String getfAudioName() {
		return fAudioName;
	}

	public void setfAudioName(String fAudioName) {
		this.fAudioName = fAudioName;
	}

}
