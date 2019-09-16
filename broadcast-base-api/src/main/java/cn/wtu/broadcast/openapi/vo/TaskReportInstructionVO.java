package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

public class TaskReportInstructionVO implements Serializable{

	private static final long serialVersionUID = 2956003659523078617L;

	//转为json字符串
	private String protocolReply;
	
	//a :23个数字码 --> 设备广播对应设备id
	private String deviceResourcecode;
	
	//b: 应急广播类型 --> 广播类型：枚举（应急，日常等等）
	private String broadcastType;
	
	//c:应急广播事件级别 -->消息级别（字典id）
	private String messageLevel;
	
	//d:应急广播事件类型 -->消息类型（字典id）
	private String messageType;
	
	//e:program_resource --> 消息来源（枚举）
	private String messageSource;

	public String getProtocolReply() {
		return protocolReply;
	}

	public void setProtocolReply(String protocolReply) {
		this.protocolReply = protocolReply;
	}

	public String getDeviceResourcecode() {
		return deviceResourcecode;
	}

	public void setDeviceResourcecode(String deviceResourcecode) {
		this.deviceResourcecode = deviceResourcecode;
	}

	public String getBroadcastType() {
		return broadcastType;
	}

	public void setBroadcastType(String broadcastType) {
		this.broadcastType = broadcastType;
	}

	public String getMessageLevel() {
		return messageLevel;
	}

	public void setMessageLevel(String messageLevel) {
		this.messageLevel = messageLevel;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(String messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public String toString() {
		return "TaskReportInstructionVO [protocolReply=" + protocolReply + ", deviceResourcecode=" + deviceResourcecode
				+ ", broadcastType=" + broadcastType + ", messageLevel=" + messageLevel + ", messageType=" + messageType
				+ ", messageSource=" + messageSource + "]";
	}
	
}
