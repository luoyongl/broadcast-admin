package cn.wtu.broadcast.openapi.vo;

public class IpSetParamVO {

	//原设备资源编码
	private String resourceCode;
	//要更新的设备资源编码 若为空则不更新
	private String newResourceCode;
	private String deviceIp;
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	public String getNewResourceCode() {
		return newResourceCode;
	}
	public void setNewResourceCode(String newResourceCode) {
		this.newResourceCode = newResourceCode;
	}
	public String getDeviceIp() {
		return deviceIp;
	}
	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}
	
}
