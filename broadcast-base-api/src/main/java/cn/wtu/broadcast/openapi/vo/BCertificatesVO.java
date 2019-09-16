package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

import cn.wtu.broadcast.openapi.model.BCertificates;

public class BCertificatesVO extends BCertificates implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fDeviceName;
	
	private String fDeviceResourceCode;

	public String getfDeviceName() {
		return fDeviceName;
	}

	public void setfDeviceName(String fDeviceName) {
		this.fDeviceName = fDeviceName;
	}
	
	public String getfDeviceResourceCode() {
		return fDeviceResourceCode;
	}

	public void setfDeviceResourceCode(String fDeviceResourceCode) {
		this.fDeviceResourceCode = fDeviceResourceCode;
	}
}
