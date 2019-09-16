package cn.wtu.broadcast.openapi.protocol.body.terminal.control.special;

import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急大喇叭适配器控制指令----回传参数设置(0x03)
 * 
 */

public class Protocol0x03Body extends ProtocolBodyCommonInfo {

	public Protocol0x03Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x03Body;
	}

	// 1：播发记录查询
	byte tag;
	
	// 指令数据长度
	int data_length;
	
	// 指令数据
	byte[] data;
	
	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] datA = new byte[getSize()];

		datA[offSet++] = (byte) tag;
		datA[offSet++] = (byte) ((data_length >> 24) & 0xff);
		datA[offSet++] = (byte) ((data_length >> 16) & 0xff);
		datA[offSet++] = (byte) ((data_length >> 8) & 0xff);
		datA[offSet++] = (byte) (data_length & 0xff);

		
		if (data !=null){
			System.arraycopy(data, 0, datA, offSet, data_length);
			//offSet += data_length;
		}
		

		return datA;
	}

	public int getSize() {
		primary_cmd_len = 4 + 1 ;
		
		if (data != null) {
			data_length = (int) data.length;
			primary_cmd_len += data_length;
		}

		return primary_cmd_len;
	}

}
