package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;

/**
 * 专门用于封装  非业务参数[即大多指令通用的参数]
 * 
 * @author lxg
 * @since 2019-06-10
 */
public class NonBusinessParamsVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 根证书编号
	 */
	private byte rootCertificateNumber;
	
	/**
	 * 平台资源编码 23位
	 */
	private String platformResourceCode;
	
	/**
	 * 县适配器IP
	 */
	private String adapterIp;
	
	/**
	 * 县适配器PORT
	 */
	private Integer port;

	public byte getRootCertificateNumber() {
		return rootCertificateNumber;
	}

	public void setRootCertificateNumber(byte rootCertificateNumber) {
		this.rootCertificateNumber = rootCertificateNumber;
	}

	public String getPlatformResourceCode() {
		return platformResourceCode;
	}

	public void setPlatformResourceCode(String platformResourceCode) {
		this.platformResourceCode = platformResourceCode;
	}

	public String getAdapterIp() {
		return adapterIp;
	}

	public void setAdapterIp(String adapterIp) {
		this.adapterIp = adapterIp;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
}
