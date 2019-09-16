package cn.wtu.broadcast.openapi.protocol.body.terminal.control.common;

import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急广播大喇叭终端通用指令----通用回传周期设置（0x0B）
 * 
 * @author Lenovo
 *
 */
public class Protocol0x0BBody extends ProtocolBodyCommonInfo {

	public Protocol0x0BBody() {
		protocol_type = ProtocolTypeEnum.Protocol0x0BBody;
	}

	// 回传周期：4字节=32bit，整数型，单位为秒。
	public int reback_cycle;

	// 地址码类型 8bit：1：逻辑码寻址；2：物理码寻址；
	// byte resource_code_type;
	// 资源码循环个数 8bit
	// byte resource_code_number;
	// 每个资源码长度8bit
	// byte resource_code_length = 24 / 2;
	// BCD编码的资源码信息（逻辑码寻址时，前四位为保留位，取值为（1111））
	// List<byte[]> resource_codes = new ArrayList<byte[]>();

	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];

		data[offSet++] = (byte) ((reback_cycle >> 24) & 0xff);
		data[offSet++] = (byte) ((reback_cycle >> 16) & 0xff);
		data[offSet++] = (byte) ((reback_cycle >> 8) & 0xff);
		data[offSet++] = (byte) (reback_cycle & 0xff);

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
		primary_cmd_len = 4 + 1 + 1 + 1;

		if (resource_codes != null) {
			primary_cmd_len += resource_code_number * resource_code_length;
		}

		return primary_cmd_len;
	}
}
