package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;
/**
 * 设置IP地址(通用网络参数设置)
 * @author yinjie
 *
 */
public class TerminalIpAddressVo implements Serializable{

	private static final long serialVersionUID = 1L;

	//资源编码
	private String resourceCode;

	//IP地址
	private String ipAddressValue;
	
	//子网掩码
	private String subnetMask;
	
	//网关
	private String ipGate;

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getIpAddressValue() {
		return ipAddressValue;
	}

	public void setIpAddressValue(String ipAddressValue) {
		this.ipAddressValue = ipAddressValue;
	}

	public String getSubnetMask() {
		return subnetMask;
	}

	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}

	public String getIpGate() {
		return ipGate;
	}

	public void setIpGate(String ipGate) {
		this.ipGate = ipGate;
	}

	@Override
	public String toString() {
		return "TerminalIpAddressVo [resourceCode=" + resourceCode + ", ipAddressValue=" + ipAddressValue
				+ ", subnetMask=" + subnetMask + ", ipGate=" + ipGate + "]";
	}
	
}
