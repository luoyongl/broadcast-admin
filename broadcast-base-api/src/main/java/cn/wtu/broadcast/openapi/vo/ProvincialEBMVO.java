package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class ProvincialEBMVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer fId;

	private Byte fVolumeControl; 
	
	private String termialDevice;
	
	private String platformResourceCode; // 平台资源编码
	
	private String EBMMessageType;
	
	private String EBMMessageLevel;
	
	private Date EBMStartTime;
	
	private Date EBMEndTime;
	
	private String EBMAreaCodes;
	
	private String programPassNum;
	
	private String programPcrPid;  // pcrPid
	
	private String programModulation; // 调制方式
	
	private Integer programMediaType; //流媒体类型
	
	private String programAudioPid; // 音频pid
	
	private String programAudioUrl; // 音频url

	public Date getEBMEndTime() {
		return EBMEndTime;
	}

	public void setEBMEndTime(Date eBMEndTime) {
		EBMEndTime = eBMEndTime;
	}

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public Byte getfVolumeControl() {
		return fVolumeControl;
	}

	public void setfVolumeControl(Byte fVolumeControl) {
		this.fVolumeControl = fVolumeControl;
	}

	public String getPlatformResourceCode() {
		return platformResourceCode;
	}

	public void setPlatformResourceCode(String platformResourceCode) {
		this.platformResourceCode = platformResourceCode;
	}

	public String getEBMMessageType() {
		return EBMMessageType;
	}

	public void setEBMMessageType(String eBMMessageType) {
		EBMMessageType = eBMMessageType;
	}

	public String getEBMMessageLevel() {
		return EBMMessageLevel;
	}

	public void setEBMMessageLevel(String eBMMessageLevel) {
		EBMMessageLevel = eBMMessageLevel;
	}

	public Date getEBMStartTime() {
		return EBMStartTime;
	}

	public void setEBMStartTime(Date eBMStartTime) {
		EBMStartTime = eBMStartTime;
	}

	public String getEBMAreaCodes() {
		return EBMAreaCodes;
	}

	public void setEBMAreaCodes(String eBMAreaCodes) {
		EBMAreaCodes = eBMAreaCodes;
	}

	public String getProgramPassNum() {
		return programPassNum;
	}

	public void setProgramPassNum(String programPassNum) {
		this.programPassNum = programPassNum;
	}

	public String getProgramPcrPid() {
		return programPcrPid;
	}

	public void setProgramPcrPid(String programPcrPid) {
		this.programPcrPid = programPcrPid;
	}

	public String getProgramModulation() {
		return programModulation;
	}

	public void setProgramModulation(String programModulation) {
		this.programModulation = programModulation;
	}

	public Integer getProgramMediaType() {
		return programMediaType;
	}

	public void setProgramMediaType(Integer programMediaType) {
		this.programMediaType = programMediaType;
	}

	public String getProgramAudioPid() {
		return programAudioPid;
	}

	public void setProgramAudioPid(String programAudioPid) {
		this.programAudioPid = programAudioPid;
	}

	public String getProgramAudioUrl() {
		return programAudioUrl;
	}

	public void setProgramAudioUrl(String programAudioUrl) {
		this.programAudioUrl = programAudioUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getTermialDevice() {
		return termialDevice;
	}

	public void setTermialDevice(String termialDevice) {
		this.termialDevice = termialDevice;
	}

}
