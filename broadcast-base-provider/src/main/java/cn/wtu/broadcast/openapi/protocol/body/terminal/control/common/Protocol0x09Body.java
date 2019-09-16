package cn.wtu.broadcast.openapi.protocol.body.terminal.control.common;

import java.util.Date;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急广播大喇叭终端通用指令----通用时钟校准（0x09）
 * @author Lenovo
 *
 */
public class Protocol0x09Body extends ProtocolBodyCommonInfo {

	public Protocol0x09Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x09Body;
	}

	// UTC时间 32bit
	byte[] time = new byte[4]; 

	public int getSize() {
		primary_cmd_len = 4;

		return primary_cmd_len;
	}

	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];

		time = SendProtocolTools.date2Bytes(new Date());

		System.arraycopy(time, 0, data, offSet, 4);

		return data;
	}

}
