
package cn.wtu.broadcast.openapi.protocol.body.adapter.control;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急大喇叭适配器控制指令----回传参数设置(0x0D)
 * 
 * @author Lenovo
 *
 */
public class Protocol0x0DBody extends ProtocolBodyCommonInfo {
	
	public Protocol0x0DBody(int reback_cycle, String ip, int port) {
		protocol_type = ProtocolTypeEnum.Protocol0x0DBody;

		//this.reback_type = reback_type;
		this.reback_cycle = reback_cycle;
		this.reback_address = SendProtocolTools.ipAndPortToBytes(ip, port);
	}

	// 回传地址类型8bit：1：短信，地址为11个数字电话号码；2：IP地址和端口；3：域名和端口号；4~9：保留；
	public byte reback_type = 2;
	// 回传周期：32bit=4字节，整数型，单位为秒。
	public int reback_cycle;
	// 回传目标域名地址长度8bit
	byte reback_address_length;
	// N短信：地址为11个数字电话号码，每个数字占用1个字节；IP地址和端口：4字节IP地址+2字节端口号，十六进制格式；域名和端口号：为ASCII字符串格式，域名与端口号用“：”分开，格式为：域名+“：”+端口号；示例：www.chinaeb-lab.org：8080
	public byte[] reback_address;

	public int getSize() {
		primary_cmd_len = 1 + 4 + 1;
		if (reback_address != null) {
			reback_address_length = (byte) reback_address.length;
			primary_cmd_len += reback_address_length;
		}
		return primary_cmd_len;
	}

	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];

		data[offSet++] = reback_type;

		data[offSet++] = (byte) ((reback_cycle >> 24) & 0xff);
		data[offSet++] = (byte) ((reback_cycle >> 16) & 0xff);
		data[offSet++] = (byte) ((reback_cycle >> 8) & 0xff);
		data[offSet++] = (byte) ((reback_cycle) & 0xff);

		data[offSet++] = reback_address_length;

		if (reback_address != null) {
			System.arraycopy(reback_address, 0, data, offSet, reback_address.length);
			offSet += reback_address_length;
		}

		return data;
	}
}
