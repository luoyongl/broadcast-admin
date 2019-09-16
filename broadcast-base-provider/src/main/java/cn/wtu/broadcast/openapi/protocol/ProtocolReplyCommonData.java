package cn.wtu.broadcast.openapi.protocol;

import java.io.Serializable;

import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;
import cn.wtu.broadcast.openapi.protocol.signature.ReplySignatureData;

/**
 * 消息整体信息
 * 
 * @author Lenovo
 *
 */
public class ProtocolReplyCommonData implements Serializable {

	private static final long serialVersionUID = 8122832214607502391L;

	/**
	 * 报头
	 */
	private String head ;

	/**
	 *  协议版本号=1 16bit 
	 */
	private String version;

	/**
	 * 协议类型：8bit
	 */
	private ProtocolTypeEnum protocol_type;

	/**
	 * 消息来源 8bit：1：表示消息来自平台软件；2：表示消息来自设备应急； 其他：保留
	 */
	private String platform_type;
	
	/**
	 * 指令数据长度
	 */
	private String data_length;
	
	/**
	 * 消息体数据
	 */
	private Object data;

	/**
	 * 数字签名
	 */
	private ReplySignatureData replySignatureData;	

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ProtocolTypeEnum getProtocol_type() {
		return protocol_type;
	}

	public void setProtocol_type(ProtocolTypeEnum protocol_type) {
		this.protocol_type = protocol_type;
	}

	public String getPlatform_type() {
		return platform_type;
	}

	public void setPlatform_type(String platform_type) {
		this.platform_type = platform_type;
	}

	public String getData_length() {
		return data_length;
	}

	public void setData_length(String data_length) {
		this.data_length = data_length;
	}

	public ReplySignatureData getReplySignatureData() {
		return replySignatureData;
	}

	public void setReplySignatureData(ReplySignatureData replySignatureData) {
		this.replySignatureData = replySignatureData;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
}
