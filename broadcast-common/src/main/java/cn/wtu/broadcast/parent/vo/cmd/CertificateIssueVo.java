package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;
import java.util.List;

/**
 * 应急广播大喇叭终端通用指令----用于接收解析的证书下发VO
 * 
 * @author lxg
 * @since 2019-06-18
 */
public class CertificateIssueVo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 证书链数据-对应解析的证书列表LIST
	 */
	private List<String> certificateLIST;
	
	/**
	 * 证书数据-对应解析的CertCtx
	 */
	private List<String> CertCtx;


	public List<String> getCertificateLIST() {
		return certificateLIST;
	}

	public void setCertificateLIST(List<String> certificateLIST) {
		this.certificateLIST = certificateLIST;
	}

	public List<String> getCertCtx() {
		return CertCtx;
	}

	public void setCertCtx(List<String> certCtx) {
		CertCtx = certCtx;
	}

	@Override
	public String toString() {
		return "CertificateIssueVo [certificateLIST=" + certificateLIST + ", CertCtx=" + CertCtx + "]";
	}

}
