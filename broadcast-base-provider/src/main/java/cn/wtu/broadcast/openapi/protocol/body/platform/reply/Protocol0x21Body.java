package cn.wtu.broadcast.openapi.protocol.body.platform.reply;

import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 通用回复(0x21)
 *
 */
public class Protocol0x21Body extends ProtocolBodyCommonInfo {

	public Protocol0x21Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x21Body;
	}
	//执行结果代码
	int BackCode;
	//相应数据长度
	int BackData_Len;
	//厂家可自行定义响应数据
	byte[] BackData;
	
	public int getSize(){
		int len = 4+4;
		BackData_Len = BackData.length;
		if(BackData!=null){
			len+=BackData_Len;
		}
		return len;
	}
	
	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];	
		
		data[offSet++] = (byte)((BackCode>>24)&0xff);
		data[offSet++] = (byte)((BackCode>>16)&0xff);
		data[offSet++] = (byte)((BackCode>>8)&0xff);
		data[offSet++] = (byte)(BackCode&0xff);
		
		data[offSet++] = (byte)((BackData_Len>>24)&0xff);
		data[offSet++] = (byte)((BackData_Len>>16)&0xff);
		data[offSet++] = (byte)((BackData_Len>>8)&0xff);
		data[offSet++] = (byte)(BackData_Len&0xff);
		
		BackData_Len = BackData.length;
		if(BackData!=null){
			System.arraycopy(BackData,0,data,offSet,BackData_Len);
			offSet += BackData_Len;
		}
		
		return data;
	}
}