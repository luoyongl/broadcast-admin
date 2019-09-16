package cn.wtu.broadcast.openapi.protocol.body.terminal.control.common;

import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急广播大喇叭终端通用指令----通用音量设置（0x06）
 * @author Lenovo
 *
 */
public class Protocol0x06Body extends ProtocolBodyCommonInfo {
	
	public Protocol0x06Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x06Body;
	}
	
    //音量 8bit
	public byte volume;
	
	//地址码类型8bit：1：逻辑码寻址；2：物理码寻址；
	//byte resource_code_type;
	//资源码循环个数8bit
	//byte resource_code_number;
	//每个资源码长度 8bit
	//byte resource_code_length = 24/2;
	//BCD编码的资源码信息（逻辑码寻址时前四位是保留位，取值为“1111”）
	//List<byte[]> resource_codes = new ArrayList<byte[]>();
	
	public int getSize() {
		primary_cmd_len = 1 + 1 + 1 + 1;
		if (resource_codes != null) {
			primary_cmd_len += resource_code_number * resource_code_length;
		}
		
		return  primary_cmd_len;
	}
	
	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];		
        
		data[offSet++] = (byte) volume;
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
