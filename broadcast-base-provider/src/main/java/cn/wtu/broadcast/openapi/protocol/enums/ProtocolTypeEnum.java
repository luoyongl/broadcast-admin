package cn.wtu.broadcast.openapi.protocol.enums;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;

/**
 * 协议类型：8bit 
 * @author Lenovo
 *
 */
public enum ProtocolTypeEnum {

	Protocol0x0CBody((byte) 0x0C, "白名单更新"),

	Protocol0x0DBody((byte) 0x0D, "回传参数设置"),

	Protocol0x0EBody((byte) 0x0E, "输出通道查询"),

	Protocol0x0FBody((byte) 0x0F, "输入通道查询"),

	Protocol0x10Body((byte) 0x10, "播发记录查询"),

	Protocol0x11Body((byte) 0x11, "故障详情查询"),

	Protocol0x41Body((byte) 0x41, "适配器证书更新指令"),

	Protocol0x04Body((byte) 0x04, "通用应急(日常)广播开播(停播)指令"),

	Protocol0x05Body((byte) 0x05, "通用资源编码设置"),

	Protocol0x06Body((byte) 0x06, "通用音量设置"),

	Protocol0x07Body((byte) 0x07, "通用回传参数设置"),

	Protocol0x08Body((byte) 0x08, "终端参数/状态查询指令"),

	Protocol0x09Body((byte) 0x09, "通用时钟校准"),

	Protocol0x0ABody((byte) 0x0A, "通用网络参数设置"),

	Protocol0x0BBody((byte) 0x0B, "通用回传周期设置"),

	Protocol0x3FBody((byte) 0x3F, "通用终端功放开关指令"),

	Protocol0x40Body((byte) 0x40, "通用证书更新"),

	Protocol0x01Body((byte) 0x01, "TS方案中的特殊指令"),

	Protocol0x02Body((byte) 0x02, "RDS方案中的特殊指令"),

	Protocol0x03Body((byte) 0x03, "IP方案中的特殊指令"),

	Protocol0x12Body((byte) 0x12, "通用回复数据"),

	Protocol0x13Body((byte) 0x13, "查询输出通道回复"),

	Protocol0x14Body((byte) 0x14, "查询输入通道回复"),

	Protocol0x15Body((byte) 0x15, "查询播发记录回复"),

	Protocol0x16Body((byte) 0x16, "查询故障详情回复"),

	Protocol0x17Body((byte) 0x17, "开/停播请求回复"),

	Protocol0x18Body((byte) 0x18, "任务开始上报"),

	Protocol0x19Body((byte) 0x19, "任务结束上报"),

	Protocol0x20Body((byte) 0x20, "心跳"),

	Protocol0x21Body((byte) 0x21, "通用回复"),

	Protocol0x22Body((byte) 0x22, "任务开始上报回复");

	private byte value;
	
	private String protocolDesc;

	private ProtocolTypeEnum(byte value, String protocolDesc) {
		this.value = value;
		this.protocolDesc = protocolDesc;
	}

	public byte getValue() {
		return value;
	}

	public void setValue(byte value) {
		this.value = value;
	}

	public String getProtocolDesc() {
		return protocolDesc;
	}

	public void setProtocolDesc(String protocolDesc) {
		this.protocolDesc = protocolDesc;
	}
	
	public static ProtocolTypeEnum getEnumByCode(String value) {
		for (ProtocolTypeEnum protocolTypeEnum : ProtocolTypeEnum.values()) {
			String enumValue = SendProtocolTools.byteToHex(new byte[]{protocolTypeEnum.getValue()}, null);
			if (value != null && value.equals(enumValue)) {
				return protocolTypeEnum;
			}
		}
		
		return null;
	}
}
