package cn.wtu.broadcast.openapi.protocol.body.terminal.control.common;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急广播大喇叭终端通用指令----通用网络参数设置（0x0A）
 * 
 * @author Lenovo
 *
 */
public class Protocol0x0ABody extends ProtocolBodyCommonInfo {

	public Protocol0x0ABody() {
		protocol_type = ProtocolTypeEnum.Protocol0x0ABody;
	}

	// 终端本机IP地址 32bit，格式参考本协议中的IPV4地址格式
	public byte[] ip = new byte[4];
	// 子网掩码 32bit，格式参考本协议中的IPV4地址格式
	public byte[] subnet_mask = new byte[4];
	// 网关 32bit，格式参考本协议中的IPV4地址格式
	public byte[] gateway = new byte[4];
	// 地址码类型 8bit：1：逻辑码寻址；2：物理码寻址；
	byte resource_code_type = 1;
	// 资源码长度8bit
	byte resource_code_length = 24 / 2;
	// BCD编码的资源码信息 Nbit（逻辑码寻址时，前四位是保留位，取值为”1111”）
	byte[] resource_code;

	/**
	 * 设置资源编码还是逻辑码 23+1 这里可以直接用父类的??
	 */
	public void setResourceCode(String resourceCode) {
		if (resourceCode.length() == 23) {
			// 国标23字符，前4位填充‘F’
			resourceCode = "F" + resourceCode;
		}

		resource_code = SendProtocolTools.strToHexBytes(resourceCode);
	}

	public int getSize() {
		primary_cmd_len = 4 + 4 + 4 + 1 + 1;

		if (resource_code != null) {
			primary_cmd_len += resource_code_length;
		}

		return primary_cmd_len;
	}

	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];

		System.arraycopy(ip, 0, data, offSet, 4);
		offSet += 4;

		System.arraycopy(subnet_mask, 0, data, offSet, 4);
		offSet += 4;

		System.arraycopy(gateway, 0, data, offSet, 4);
		offSet += 4;

		data[offSet++] = (byte) resource_code_type;
		data[offSet++] = (byte) resource_code_length;

		// 终端资源编码 BCD编码的资源码信息resource_codes
		if (resource_code != null) {
			System.arraycopy(resource_code, 0, data, offSet, resource_code_length);
		}

		return data;
	}
}
