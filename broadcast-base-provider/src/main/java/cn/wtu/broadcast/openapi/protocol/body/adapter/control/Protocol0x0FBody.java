package cn.wtu.broadcast.openapi.protocol.body.adapter.control;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急大喇叭适配器控制指令----输入通道查询（0x0F）
 * 
 * @author Lenovo
 *
 */
public class Protocol0x0FBody extends ProtocolBodyCommonInfo {

	public Protocol0x0FBody(String frontCode,byte input_channel_id,byte input_channel_state) {
		protocol_type = ProtocolTypeEnum.Protocol0x0FBody;
		// F表示保留位0x0F
		reserved_and_frontCode = SendProtocolTools.strToHexBytes("F" + frontCode);
		
		this.input_channel_id = input_channel_id;
		this.input_channel_state = input_channel_state;
	}

	/*// 保留 4bit，取值为”1111”
	byte reserved = 0x0f;*/
	// BCD编码 92bit 23BCD, 23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	//byte[] reserved_and_front_code;
	
	
	// 传输通道号：取0时不做为查询条件 8bit
	byte input_channel_id;
	// 根据传输通道状态查询 8bit 0：查询全部1：查询空闲；2：查询占用3：查询故障
	byte input_channel_state;
	
	/**
	 * 获取指令的长度
	 * @return 单位:字节byte
	 */
	public int getSize() {
		primary_cmd_len = 12 + 1 + 1;
		return  primary_cmd_len;
	}
	
	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];	
		
		System.arraycopy(reserved_and_frontCode, 0, data, offSet, reserved_and_frontCode.length);
		offSet += reserved_and_frontCode.length;
		
		data[offSet++] = input_channel_id;
		data[offSet++] = input_channel_state;
		
		return data;
	}
}
