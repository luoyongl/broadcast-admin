package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;

public class IpOrPortInParameterStatusVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//回传IP
	private String returnIp;
	
	//回传端口
	private String returnPort;

	public String getReturnIp() {
		return returnIp;
	}

	public void setReturnIp(String returnIp) {
		this.returnIp = returnIp;
	}

	public String getReturnPort() {
		return returnPort;
	}

	public void setReturnPort(String returnPort) {
		this.returnPort = returnPort;
	}

	@Override
	public String toString() {
		return "IpOrPortInParameterStatusVO [returnIp=" + returnIp + ", returnPort=" + returnPort + "]";
	}

}
