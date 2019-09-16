package cn.wtu.broadcast.parent.vo.provice;

import java.io.Serializable;

/**
 * 内容表
 * @author lxg
 *
 */
public class EBCTParamsVO implements Serializable{

	private static final long serialVersionUID = 1L;

	/*
	 * 应急广播消息id 15bytes
	 */
	private byte[] EBM_ID;
	/*
	 * 消息内容
	 */
	private String messageText;
	/*
	 * 机构名称
	 */
	private String agencyName;
	
	public byte[] getEBM_ID() {
		return EBM_ID;
	}
	public void setEBM_ID(byte[] eBM_ID) {
		EBM_ID = eBM_ID;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	
}
