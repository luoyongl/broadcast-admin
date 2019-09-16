package cn.wtu.broadcast.openapi.protocol.body.terminal.control.common;

import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急广播大喇叭终端通用指令----通用回传参数设置（0x07）
 * @author Lenovo
 *
 */
public class Protocol0x07Body extends ProtocolBodyCommonInfo {
	
	public Protocol0x07Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x07Body;
	}
	
    //回传地址类型8bit：1：短信，地址为11个数字电话号码；2：IP地址和端口；3：域名和端口号；4~9：保留；
	byte reback_type = 2;
	//回传目标域名地址长度8bit
	byte reback_address_length;
	//N 短信：地址为11个数字电话号码，每个数字占用1个字节；IP地址和端口：4字节IP地址+2字节端口号，十六进制格式；域名和端口号：为ASCII字符串格式，域名与端口号用“：”分开，格式为：域名+“：”+端口号；示例：www.chinaeb-lab.org：8080
	public byte[] reback_address;
	
	//地址码类型8bit：1：逻辑码寻址；2：物理码寻址；
	//byte resource_code_type = 1;
	//资源码循环个数8bit
	//byte resource_code_number;
	//每个资源码长度8bit
	//byte resource_code_length = 24/2;
	//BCD编码的资源码信息（逻辑码寻址时，前四位为保留位，取值为（1111））
	//List<byte[]> resource_codes = new ArrayList<byte[]>();
	
	public int getSize() {
		primary_cmd_len = 1 + 1;
		
		if (reback_address != null) {
			reback_address_length = (byte) reback_address.length;
			primary_cmd_len += reback_address_length;
		}
		
		primary_cmd_len += 1 + 1 + 1;
		
		if (resource_codes != null) {
			primary_cmd_len += resource_code_number * resource_code_length;
		}
				
		return  primary_cmd_len;
	}
	
	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];		
        
		data[offSet++] = (byte) reback_type;
		data[offSet++] = (byte) reback_address_length;

		if (reback_address != null) {
			System.arraycopy(reback_address, 0, data, offSet, reback_address_length);
			offSet += reback_address_length;
		}
		
		data[offSet++] = (byte) resource_code_type;
		data[offSet++] = (byte) resource_code_number;
		data[offSet++] = (byte) resource_code_length;
		
		//终端资源编码 BCD编码的资源码信息resource_codes
		if (resource_codes != null) {
			for (byte[] resource : resource_codes) {
				System.arraycopy(resource, 0, data, offSet, resource.length);
				offSet += resource.length;
			}
		}
		
		return data;
	}
}
