package cn.wtu.broadcast.parent.vo;

import java.io.Serializable;

public class IpWriteVO implements Serializable{
	
	private static final long serialVersionUID = 6250391987470051356L;
	
	/**
	 * 设备18位资源编码 例如061245140210220301
	 */
	
	private Integer deviceID;
	//设备资源编码
	private String deviceSourceCode;
	
	//更新的设备资源编码  若为空则不更新
	private String newDeviceSourceCode;

	private String deviceIp;
	//回传ip
	private String backIp;
	
	private String privateKey;
	
	private String platFormSourceCode;
	
	public String getPlatFormSourceCode() {
		return platFormSourceCode;
	}

	public void setPlatFormSourceCode(String platFormSourceCode) {
		this.platFormSourceCode = platFormSourceCode;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getDeviceSourceCode() {
		return deviceSourceCode;
	}

	public void setDeviceSourceCode(String deviceSourceCode) {
		this.deviceSourceCode = deviceSourceCode;
	}

	public String getNewDeviceSourceCode() {
		return newDeviceSourceCode;
	}

	public void setNewDeviceSourceCode(String newDeviceSourceCode) {
		this.newDeviceSourceCode = newDeviceSourceCode;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getBackIp() {
		return backIp;
	}

	public void setBackIp(String backIp) {
		this.backIp = backIp;
	}

	public Integer getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(Integer deviceID) {
		this.deviceID = deviceID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
