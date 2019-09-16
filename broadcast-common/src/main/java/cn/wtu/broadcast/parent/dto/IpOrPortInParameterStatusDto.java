package cn.wtu.broadcast.parent.dto;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import cn.wtu.broadcast.parent.vo.cmd.IpOrPortInParameterStatusVO;

public class IpOrPortInParameterStatusDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int status;
	
	private IpOrPortInParameterStatusVO ipOrPort;
	
	private List<IpOrPortInParameterStatusVO> ipOrPortList = Lists.newArrayList();
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public IpOrPortInParameterStatusVO getIpOrPort() {
		return ipOrPort;
	}

	public void setIpOrPort(IpOrPortInParameterStatusVO ipOrPort) {
		this.ipOrPort = ipOrPort;
	}

	public List<IpOrPortInParameterStatusVO> getIpOrPortList() {
		return ipOrPortList;
	}

	public void setIpOrPortList(List<IpOrPortInParameterStatusVO> ipOrPortList) {
		this.ipOrPortList = ipOrPortList;
	}

	@Override
	public String toString() {
		return "IpOrPortInParameterStatusDto [status=" + status + ", ipOrPort=" + ipOrPort + ", ipOrPortList="
				+ ipOrPortList + "]";
	}

}
