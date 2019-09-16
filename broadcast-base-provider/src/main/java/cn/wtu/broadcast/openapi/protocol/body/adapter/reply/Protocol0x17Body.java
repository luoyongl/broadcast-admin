package cn.wtu.broadcast.openapi.protocol.body.adapter.reply;

import java.io.Serializable;

/**
 * 开/停播请求回复(0x17)
 * 
 * @author Pr1p
 *
 */
public class Protocol0x17Body implements Serializable {

	private static final long serialVersionUID = 3277732324708440626L;
	// 保留，取值为”1111”
	// BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	String front_code_reserved;
	/*
	 * //保留，取值为”1111” byte reserved;
	 */
	/* 开停播的应急广播消息标识符，BCD编码共35个数字，其定义见GD/J XXXX-XXXX应急广播消息格式规范。 */
	String ebm_id_reserved;
	// 0代表成功1代表失败
	String result_code;
	//
	String result_desc_length;
	// utf-8编码
	String result_desc;
	// 适配器接收流地址长度
	String accept_stream_address_length;
	// 适配器接收流地址（如果适配器接收到的辅助数据类型为0x62时，则代表适配器需要提供一个接收流的地址给平台，格式如RTP://IP地址：端口，）
	String accept_stream_address;
	
	public String getFront_code_reserved() {
		return front_code_reserved;
	}
	public void setFront_code_reserved(String front_code_reserved) {
		this.front_code_reserved = front_code_reserved;
	}
	public String getEbm_id_reserved() {
		return ebm_id_reserved;
	}
	public void setEbm_id_reserved(String ebm_id_reserved) {
		this.ebm_id_reserved = ebm_id_reserved;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getResult_desc_length() {
		return result_desc_length;
	}
	public void setResult_desc_length(String result_desc_length) {
		this.result_desc_length = result_desc_length;
	}
	public String getResult_desc() {
		return result_desc;
	}
	public void setResult_desc(String result_desc) {
		this.result_desc = result_desc;
	}
	public String getAccept_stream_address_length() {
		return accept_stream_address_length;
	}
	public void setAccept_stream_address_length(String accept_stream_address_length) {
		this.accept_stream_address_length = accept_stream_address_length;
	}
	public String getAccept_stream_address() {
		return accept_stream_address;
	}
	public void setAccept_stream_address(String accept_stream_address) {
		this.accept_stream_address = accept_stream_address;
	}

}