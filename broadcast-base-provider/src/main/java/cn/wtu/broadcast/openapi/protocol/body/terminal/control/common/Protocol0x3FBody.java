package cn.wtu.broadcast.openapi.protocol.body.terminal.control.common;

import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急广播大喇叭终端通用指令----通用终端功放开关指令(0x3F)
 * @author Lenovo
 *
 */
public class Protocol0x3FBody extends ProtocolBodyCommonInfo {

	public Protocol0x3FBody() {
		protocol_type = ProtocolTypeEnum.Protocol0x3FBody;
	}
	
    //喇叭状态 8bit 1:表示关闭喇叭2：表示打开喇叭
	public byte switch_option;
	
	//要设置的终端编号的地址类型 8bit   1: 表示逻辑地址寻址；2：表示物理地址寻址；3~9：保留
	//byte resource_code_type;
	//需要配置的区域和终端编码的个数 8bit
	//byte resource_code_number;
	//此处特指每个区域和终端编码占用的长度8bit
	//byte resource_code_length = 24/2;
	//BCD编码的资源码信息（逻辑码寻址时，前四位为保留位，取值为（1111））
	//List<byte[]> resource_codes = new ArrayList<byte[]>();
	
	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];

		data[offSet++] = (byte) switch_option;
		data[offSet++] = (byte) resource_code_type;
		data[offSet++] = (byte) resource_code_number;
		data[offSet++] = (byte) resource_code_length;

		// 终端资源编码 BCD编码的资源码信息resource_codes
		if (resource_codes != null) {
			for (byte[] resource : resource_codes) {
				System.arraycopy(resource, 0, data, offSet, resource.length);
				offSet += resource.length;
			}
		}

		return data;
	}
	
	public int getSize() {
		primary_cmd_len = 1 + 1 + 1 + 1;

		if (resource_codes != null) {
			primary_cmd_len += resource_code_number * resource_code_length;
		}

		return primary_cmd_len;
	}
}
