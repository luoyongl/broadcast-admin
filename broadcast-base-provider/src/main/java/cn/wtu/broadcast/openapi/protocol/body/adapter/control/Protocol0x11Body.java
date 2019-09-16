package cn.wtu.broadcast.openapi.protocol.body.adapter.control;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急大喇叭适配器控制指令----故障详情查询（0x11）
 * 
 * @author Lenovo
 *
 */
public class Protocol0x11Body extends ProtocolBodyCommonInfo {

	public Protocol0x11Body(String frontCode) {
		protocol_type = ProtocolTypeEnum.Protocol0x11Body;

		// F表示保留位0x0F
		reserved_and_frontCode = SendProtocolTools.strToHexBytes("F" + frontCode);
	}

	// 保留 4bit，取值为”1111”
	// byte reserved = 0x0f;
	// BCD编码 92bit 23BCD, 23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	// byte[] front_code;

	public int getSize() {
		primary_cmd_len = 12;
		return primary_cmd_len;
	}

	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];

		System.arraycopy(reserved_and_frontCode, 0, data, offSet, reserved_and_frontCode.length);
		// offSet += reserved_and_frontCode.length;

		return data;
	}
}
