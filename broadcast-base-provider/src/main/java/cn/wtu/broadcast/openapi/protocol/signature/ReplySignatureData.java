package cn.wtu.broadcast.openapi.protocol.signature;

import java.io.Serializable;

public class ReplySignatureData implements Serializable {
	
	private static final long serialVersionUID = -928834372235193066L;

	/**
	 * 数字签名信息长度:指示数字签名时间、签名证书编号、数字签名的总长度
	 */
	private String signature_length;
	
	/**
	 * 数字签名时间
	 */
	private String signature_time;
	
	/**
	 * 签名证书编号
	 */
	private String certificate_sn;
	
	/**
	 * 数字签名:数字签名数据包含应急广播数据包中消息头和消息体的数字签名信息
	 */
	private String signature_data;
	
	/**
	 * CRC32:数据包CRC32值，计算范围为数据包所有数据
	 */
	private String crc32;

	public String getSignature_length() {
		return signature_length;
	}

	public void setSignature_length(String signature_length) {
		this.signature_length = signature_length;
	}

	public String getSignature_time() {
		return signature_time;
	}

	public void setSignature_time(String signature_time) {
		this.signature_time = signature_time;
	}

	public String getCertificate_sn() {
		return certificate_sn;
	}

	public void setCertificate_sn(String certificate_sn) {
		this.certificate_sn = certificate_sn;
	}

	public String getSignature_data() {
		return signature_data;
	}

	public void setSignature_data(String signature_data) {
		this.signature_data = signature_data;
	}

	public String getCrc32() {
		return crc32;
	}

	public void setCrc32(String crc32) {
		this.crc32 = crc32;
	}		
}
