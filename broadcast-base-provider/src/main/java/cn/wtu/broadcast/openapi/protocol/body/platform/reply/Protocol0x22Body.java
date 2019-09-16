package cn.wtu.broadcast.openapi.protocol.body.platform.reply;

import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 任务开始上报回复(0x22)
 * 
 */
public class Protocol0x22Body extends ProtocolBodyCommonInfo {

	public Protocol0x22Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x22Body;
	}
	// 0代表成功1代表失败
	byte result_code;
	// 格式参考本协议中的IPV4地址格式。
	int receive_stream_ip;
	// 接收流的端口
	short receive_stream_port;
	
	public int getSize(){
		int len = 1+4+2;
		return len;
	}
	
	public byte[] convertToBytes(){
		int offSet = 0;
		byte[] data = new byte[getSize()];	
		
		data[offSet++] = (byte)result_code;
		
		data[offSet++] = (byte)((receive_stream_ip>>24)&0xff);
		data[offSet++] = (byte)((receive_stream_ip>>16)&0xff);
		data[offSet++] = (byte)((receive_stream_ip>>8)&0xff);
		data[offSet++] = (byte)(receive_stream_ip&0xff);
		
		data[offSet++] = (byte)((receive_stream_port>>8)&0xff);
		data[offSet++] = (byte)(receive_stream_port&0xff);
		
		return data;
	}
}