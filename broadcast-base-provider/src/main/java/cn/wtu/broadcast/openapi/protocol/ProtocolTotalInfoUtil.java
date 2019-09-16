package cn.wtu.broadcast.openapi.protocol;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x12Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x13Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x13Body.output_channel_info;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x13Body.output_channel_info.sub_channel_info;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x13Body.output_channel_info.sub_channel_info1;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x13Body.output_channel_info.sub_channel_info1.stream_info;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x14Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x14Body.InputChannelInfo;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x15Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x15Body.RecordInfo;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x15Body.RecordInfo.OutputChannelInfo;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x15Body.RecordInfo.ResourceInfo;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x16Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x17Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.report.Protocol0x18Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.report.Protocol0x19Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.report.Protocol0x20Body;
import cn.wtu.broadcast.openapi.protocol.signature.SignatureData;
import net.sf.json.JSONObject;

/**
 * 
 * 应急广播平台与大喇叭前端适配器通讯数据包--完整指令
 * 
 */
public class ProtocolTotalInfoUtil {

	private static Logger logger = LoggerFactory.getLogger(ProtocolTotalInfoUtil.class);

	/**
	 * 返回完整的指令数据 byte[]
	 * 
	 * @param c
	 * @return
	 */
	public static byte[] getProtocolByte(ProtocolHeadBodyData protocolCompleteInfo) {
		try {
			// 消息体数据设置
			byte[] bodyByte = protocolCompleteInfo.convertToBytes();
			ProtocolHeadBodyData totalCmd = new ProtocolHeadBodyData();
			totalCmd.setProtocol_type(protocolCompleteInfo.getProtocol_type());
			totalCmd.setBroadcastMessageBody(bodyByte);
			// 消息数据延签设置
			SignatureData signatureData = new SignatureData((byte) 1, true);
			totalCmd.setSignatureData(signatureData);
			byte[] completeInfoByte = totalCmd.convertToBytes();
			logger.info("指令{" + SendProtocolTools.byteToHex(new byte[] { totalCmd.getProtocol_type().getValue()}, null)
					+ "}发送信息：" + SendProtocolTools.byteToHex(completeInfoByte, null));
			return completeInfoByte;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return null;
		}
	}

	public static void main(String[] args) {
		/*
		 * // 动态从页面获取 String resourceCodes = "63415230000000314010400"; // 特殊指令
		 * Protocol0x01Body tsLockFrequency = new Protocol0x01Body(); //
		 * freq范围44000-999000KHZ整数
		 * tsLockFrequency.setResourceCodes(Arrays.asList(resourceCodes.split(
		 * ","))); tsLockFrequency.freq = 300000; tsLockFrequency.symbol_rate =
		 * 6875; tsLockFrequency.qam = 0;
		 * ProtocolTotalInfoUtil.getProtocolByte(tsLockFrequency);
		 */
		
		String protocol0x12 ="5000011202000000080000000000000000004A0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000AC1D9D3C";
		byte[] protocolByte0x12 = SendProtocolTools.hexStringToByte(protocol0x12);
		ProtocolReplyCommonData protocolReplyCommonData0x12 = new ProtocolReplyCommonData();
		parseProtocol0x12Data(protocolReplyCommonData0x12, protocolByte0x12);
		
		String prototo10x13 = "500001130200000024F43415230000000314010201020101010100000102020100000000000001000180010001004A00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002975A754";
		byte[] protocolByte0x13 =SendProtocolTools.hexStringToByte(prototo10x13);
		ProtocolReplyCommonData protocolReplyCommonData0x13 = new ProtocolReplyCommonData();
		parseProtocol0x13Data(protocolReplyCommonData0x13, protocolByte0x13);
		
		String protocol0x14 = "500001140200000059F4341523000000031401020107060006E8AF9DE7AD920001070006E7BABFE8B7AF0001010006E79FADE4BFA1000103000555E79B98000001040006E8B083E9A2910001020006E5B9B3E58FB00001000006E794B5E8AF9D0001004A0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000C2843096";
		byte[] protocolByte = SendProtocolTools.hexStringToByte(protocol0x14);
		ProtocolReplyCommonData protocolReplyCommonData = new ProtocolReplyCommonData();
		parseProtocol0x14Data(protocolReplyCommonData, protocolByte);
		
		String protocol0x15 ="5000011502000000E0F4341523000000031401020100000004F434152300000001030101012019011400040301040130303030305C3C57695C3C5895FF0000010CF03415230000000314010400F434152300000001030101012019011400050301040130303030305C3C5CFD5C3C5E29FF0000010CF03415230000000314010400F434152300000001030101012019011400010501040130303030305C3C85975C3C87EFFF0000010CF03415230000000314010400F434152300000001030101012019011400010301000030303030305C3C85C95C3C85C9000000010CF03415230000000314010400004A0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000FA3F9A66";
		byte[] protocolByte0x15 = SendProtocolTools.hexStringToByte(protocol0x15);
		ProtocolReplyCommonData protocolReplyCommonData0x15 = new ProtocolReplyCommonData();
		parseProtocol0x15Data(protocolReplyCommonData0x15, protocolByte0x15);
		
		String protocol0x16 ="50000116020000000FF43415230000000314010201000000004A000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000075C33CEC";
		byte[] protocolByte0x16 = SendProtocolTools.hexStringToByte(protocol0x16);
		ProtocolReplyCommonData protocolReplyCommonData0x16 = new ProtocolReplyCommonData();
		parseProtocol0x16Data(protocolReplyCommonData0x16, protocolByte0x16);
		
		String protocol0x17 ="50000117020000000FF43415230000000314010201F4341523000000031401020100031401020100000000000000004A0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000C2843096";
		byte[] protocolByte0x17 = SendProtocolTools.hexStringToByte(protocol0x17);
		ProtocolReplyCommonData protocolReplyCommonData0x17 = new ProtocolReplyCommonData();
		parseProtocol0x17Data(protocolReplyCommonData0x17, protocolByte0x17);
		
		String protocol0x18="500001180200000059F43415230000000314010201F43415230000000103010101201901140004010001303030303001000101021212004A0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000FA3F9A66";
		byte[] protocolByte0x18 = SendProtocolTools.hexStringToByte(protocol0x18);
		ProtocolReplyCommonData protocolReplyCommonData0x18 = new ProtocolReplyCommonData();
		parseProtocol0x18Data(protocolReplyCommonData0x18,protocolByte0x18);
		
		String protocol0x19="5000011902000000E0F43415230000000314010201F43415230000000103010101201901140004004A0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000FA3F9A66";
		byte[] protocolByte0x19 = SendProtocolTools.hexStringToByte(protocol0x19);
		ProtocolReplyCommonData protocolReplyCommonData0x19 = new ProtocolReplyCommonData();
		parseProtocol0x19Data(protocolReplyCommonData0x19,protocolByte0x19);
		
		String protocol0x20="5000012002000000E001110112121212004A0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000FA3F9A66";
		byte[] protocolByte0x20 = SendProtocolTools.hexStringToByte(protocol0x20);
		ProtocolReplyCommonData protocolReplyCommonData0x20 = new ProtocolReplyCommonData();
		parseProtocol0x20Data(protocolReplyCommonData0x20,protocolByte0x20);
		
	}
	
	public static void parseProtocol0x12Data(ProtocolReplyCommonData protocolReplyCommonData, byte[] buffer){
		// 消息体起始字节数
		int index = 1 + 2 + 1 + 1 + 4;
    	// 消息头的消息设置
		ReplyProtocolTools.setProtocolHead(protocolReplyCommonData, buffer);
		// 消息体数据
    	Protocol0x12Body protocol0x12Body = new Protocol0x12Body();
    	protocol0x12Body.setReturn_code(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
    	index+=4;
    	protocol0x12Body.setReturn_data_length(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
    	
    	int return_data_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 4), 16);
    	
    	index+=4;
    	
    	String return_data = ReplyProtocolTools.getProtocolHex(buffer, index, return_data_length);
    	index+=return_data_length;
    	protocol0x12Body.setReturn_data(return_data);
    	ReplyProtocolTools.setProtocolSignatureData(protocolReplyCommonData, index, buffer);
    	protocolReplyCommonData.setData(protocol0x12Body);
    	logger.info(JSONObject.fromObject(protocolReplyCommonData).toString());
	}

	/**
	 * 解析查询输出通道回复(0x13)数据
	 * @param buffer
	 * @param length
	 * @author Pr1p
	 */	
	public static void parseProtocol0x13Data(ProtocolReplyCommonData protocolReplyCommonData, byte[] buffer){
		//消息起始字节数
		int index = 1 + 2 + 1 + 1 + 4;
		//消息头的消息设置
		ReplyProtocolTools.setProtocolHead(protocolReplyCommonData, buffer);
    	//消息体数据
    	Protocol0x13Body protocol0x13Body = new Protocol0x13Body();
    	// 保留，取值为”1111” + BCD编码，23个数字码
    	protocol0x13Body.setFront_code_reserved(ReplyProtocolTools.getProtocolHex(buffer, index, 12));
    	index += 12;
    	//传输通道数量
    	protocol0x13Body.setOutput_channel_number(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
       	int output_channel_number = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
    	index += 1;
    	List<output_channel_info> output_channels=new ArrayList<>();
    	for(int i=0;i<output_channel_number;i++)
    	{
    		output_channel_info output_channel=new output_channel_info();
    		//通道号(唯一标识)
    		output_channel.setOutput_channel_id(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    		index += 1;
    		//通道类型 1：调频 2：有线数字电视 3：地面数字电视 4:IP
    		output_channel.setOutput_channel_type(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    		int out_channel_type =Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
    		index += 1;
    		//rds传输通道
    		if(out_channel_type==1){
    			//Rds通道数量
    			output_channel.setSub_channel_number(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    			int Sub_channel_number = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
    			index += 1;
    			List<sub_channel_info> sub_channels=new ArrayList<>();
    			for(int j=0;j< Sub_channel_number;j++){
    				
    				sub_channel_info sub_channel_info=new sub_channel_info();
    				//开播频点，单位MHZ，3个字节，采用BCD 码的方式表示 6个数字，其中小数点前4位，小数点后2 位。
    				sub_channel_info.setSub_channel_freq(ReplyProtocolTools.getProtocolHex(buffer, index, 3));
    				index += 3;
    				//传输通道状态。1：空闲；2：占用；3：故障
    				sub_channel_info.setOutput_channel_state(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    				int output_channel_state =Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
    				index += 1;
    				//
    				if(output_channel_state==2){
    					//保留，取值为”1111” + BCD编码，23个数字码
    					sub_channel_info.setEbm_id_reserved(ReplyProtocolTools.getProtocolHex(buffer, index, 18));
    					index += 18;
    				}
    				
    				
    				sub_channels.add(sub_channel_info);
    			}
    			output_channel.setSub_channels(sub_channels);
    		}
    		//DTMB传输通道 |DVB_C传输通道
    		if(out_channel_type==2|out_channel_type==3){
    			//DVB_C通达数量
    			output_channel.setSub_channel_number(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    			int Sub_channel_number = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
    			index += 1;
    			
    			List<sub_channel_info1> sub_channel_info1=new ArrayList<>();
    			for(int j=0;j< Sub_channel_number;j++){
    				
    				sub_channel_info1 sub_channel_info=new sub_channel_info1();
    				//TS流传输中原始网络ID
    				sub_channel_info.setOriginal_network_id(ReplyProtocolTools.getProtocolHex(buffer, index, 2));
    				index +=2;
    				//TS流传输中传输流标识符
    				sub_channel_info.setDetails_channel_transport_stream_id(ReplyProtocolTools.getProtocolHex(buffer, index, 2));
    				index +=2;
    				//TS流传输中节目号
    				sub_channel_info.setDetails_channel_program_number(ReplyProtocolTools.getProtocolHex(buffer, index, 2));
    				index +=2;
    				//TS流传输中详情频道PCR标识
    				sub_channel_info.setDetails_channel_pcr_pid(ReplyProtocolTools.getProtocolHex(buffer, index, 2));
    				index +=2;
    				//
    				sub_channel_info.setStream_number(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    				int stream_number=Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
    				index +=1; 				
    				List<stream_info> stream_info =new ArrayList<>();
    				
    				for(int k=0;k<stream_number;k++){
    					stream_info stream=new stream_info();
    					//该字段的取值范围和定义见GB/T 17975.1-2010的表37
    					stream.setStream_type(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    					index +=1;
    					//基本PID
    					stream.setElementary_pid(ReplyProtocolTools.getProtocolHex(buffer, index, 2));
    					index +=2;
    					
    					stream_info.add(stream);
    					
    				}
    					sub_channel_info.setStreams(stream_info);
    					
    				
    				
    				//传输通道状态。1：空闲；2：占用；3：故障
    				sub_channel_info.setOutput_channel_state(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    				int output_channel_state=Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
    				index += 1;
    				if(output_channel_state==2){
    					//保留，取值为”1111” + BCD编码，23个数字码
    					sub_channel_info.setEbm_id_reserved(ReplyProtocolTools.getProtocolHex(buffer, index, 18));
    					index += 18;
    				}
    				
    				
    				
    				sub_channel_info1.add(sub_channel_info);
    			}
    			
    			output_channel.setSub_channels1(sub_channel_info1);
    		}
    		
    		output_channels.add(output_channel);
    	}
    	protocol0x13Body.setOutput_channels(output_channels);
    	ReplyProtocolTools.setProtocolSignatureData(protocolReplyCommonData, index, buffer);
    	protocolReplyCommonData.setData(protocol0x13Body);
    	logger.info(JSONObject.fromObject(protocolReplyCommonData).toString());
    	
	}
	
	
	
	
	/**
	 * 解析查询输入通道回复(0x14)数据
	 * @param buffer
	 */
	public static void parseProtocol0x14Data(ProtocolReplyCommonData protocolReplyCommonData, byte[] buffer) {
		// 消息体起始字节数
		int index = 1 + 2 + 1 + 1 + 4;
    	// 消息头的消息设置
    	ReplyProtocolTools.setProtocolHead(protocolReplyCommonData, buffer);
    	// 消息体数据
    	Protocol0x14Body protocol0x14Body = new Protocol0x14Body();
    	// 保留，取值为”1111” + BCD编码，23个数字码
    	protocol0x14Body.setFront_code_reserved(ReplyProtocolTools.getProtocolHex(buffer, index, 12));
    	index += 12;
    	// 输入通道数量
    	protocol0x14Body.setInput_channel_number(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	int input_channel_number = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
    	index += 1;
    	List<InputChannelInfo> input_channels = new ArrayList<>(); 
    	for (int i = 0; i < input_channel_number; i++) {
    		InputChannelInfo inputChannelInfo = new InputChannelInfo();
    		// 通道号(唯一标识)
    		inputChannelInfo.setInput_channel_id(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	index += 1;
        	// 通道名称长度
        	inputChannelInfo.setInput_channel_name_length(ReplyProtocolTools.getProtocolHex(buffer, index, 2));
        	int input_channel_name_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 2), 16);
        	index += 2;
        	// 通道名称
        	String channel_name = ReplyProtocolTools.getProtocolHex(buffer, index, input_channel_name_length);
        	// 16进制的中文，可以解码成中文
        	inputChannelInfo.setInput_channel_name(channel_name);
        	index += input_channel_name_length;
        	// 同一分组编号的输入通道为互斥通道，不同分组编号的通道为并行通道
        	inputChannelInfo.setInput_channel_group(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	index += 1;
        	// 输入通道状态。1：空闲；2：占用；3：故障
        	inputChannelInfo.setInput_channel_state(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	index += 1;
        	input_channels.add(inputChannelInfo);
		}  
    	protocol0x14Body.setInput_channels(input_channels);
    	ReplyProtocolTools.setProtocolSignatureData(protocolReplyCommonData, index, buffer);
    	protocolReplyCommonData.setData(protocol0x14Body);
    	logger.info("适配器回复解析结果：{}", JSONObject.fromObject(protocolReplyCommonData).toString());
	}
	

	public static void parseProtocol0x15Data(ProtocolReplyCommonData protocolReplyCommonData, byte[] buffer) {
		// 消息体起始字节数,消息头
		int index = 1 + 2 + 1 + 1 + 4;
		// 消息头的消息设置
		ReplyProtocolTools.setProtocolHead(protocolReplyCommonData, buffer);
    	// 消息体数据
    	Protocol0x15Body protocol0x15Body = new Protocol0x15Body();
    	// 保留，取值为”1111” + BCD编码，23个数字码
    	protocol0x15Body.setFront_code_reserved(ReplyProtocolTools.getProtocolHex(buffer, index, 12));
    	index += 12;
    	
    	// 记录数
    	protocol0x15Body.setRecord_number(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
    	int record_number = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 4), 16);
    	index += 4;
    	List<RecordInfo> records = new ArrayList<>();
    	
    	for (int i = 0; i < record_number; i++) {
    		RecordInfo recordInfo = new RecordInfo();
    		// 保留，取值为”1111” + BCD编码，35个数字码
    		recordInfo.setEbm_id_reserved(ReplyProtocolTools.getProtocolHex(buffer, index, 18));
    		index += 18;
    		/*
    		0：未处理
    		1：等待播发，指未到消息播发时间
    		2：播发中
    		3：播发成功
    		4：播发失败，包括播发全部失败、播发部分失败、未按要求播发等情况
    		5：播发取消
    		*/
    		recordInfo.setTask_state(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	index += 1;
        	/*
    		1：应急广播县平台；
    		2：输入通道；
    		3：电话；
    		4：短信；
    		5：无线或卫星信号
    		*/
        	recordInfo.setProgram_resource(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	index += 1;
        	/*
    		应急广播类型：
    		0：保留；
    		1：发布系统演练；
    		2：模拟演练；
    		3：实际演练；
    		4：应急广播；
    		5：日常广播；
    		其他：保留；
    		*/
        	recordInfo.setEbm_class(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	index += 1;
        	/*
	   		 应急广播事件级别：
	   		0：缺省；
	   		1：1级（特别重大）；
	   		2：2级（重大）；
	   		3：3级（较大）；
	   		4：4级（一般）；
	   		其他：保留；
        	 */
        	recordInfo.setEbm_level(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	index += 1;
        	
        	//应急广播事件类型：详见附录A
        	recordInfo.setEbm_type(ReplyProtocolTools.getProtocolHex(buffer, index, 5));
        	index += 5;
        	//参考本协议中的时间格式约定
        	recordInfo.setStart_time(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
        	index += 4;
        	//参考本协议中的时间格式约定
        	recordInfo.setEnd_time(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
        	index += 4;
        	//参考本协议中的音量格式约定
        	recordInfo.setVolume(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	index += 1;
        	//输入通道编号，program_resource取值为2时该通道号不为0，其余均为0
        	recordInfo.setInput_channel_id(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	index += 1;
        	// 输出
        	
        	recordInfo.setOutput_channel_number(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        
        	int output_channel_number = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
        	index += 1;
        	List<OutputChannelInfo> outputChannels = new ArrayList<>();
        	for (int j=0; j < output_channel_number; j++) {
        		OutputChannelInfo outputChannelInfo=new OutputChannelInfo();
        		//输出通道类型
        		outputChannelInfo.setOutput_channel_type(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
            	index += 1;
            	//输出通道编号
        		outputChannelInfo.setOutput_channel_id(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
            	index += 1;
            	outputChannels.add(outputChannelInfo);
        	
        	}
        	recordInfo.setOutputChannels(outputChannels);
        	
        
        	/**
        	 * 先用recordInfo.getProgram_resource();获取rogram_resource的值
        	 * 然后用Integer.parseInt()做强制转换，把String转换成Integer型，在和数字做对比，然后做或运算
        	 */
        	
        	if( Integer.parseInt(recordInfo.getProgram_resource())==3 | Integer.parseInt(recordInfo.getProgram_resource())==4){
            	// 电话号码长度
        		recordInfo.setTel_length(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
            	int tel_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
            	index += 1;
        		// 电话号码
            	String tel_name = ReplyProtocolTools.getProtocolHex(buffer, index,tel_length );
            	// 16进制的中文，可以解码成中文
            	recordInfo.setTel_number(tel_name);
            	index += tel_length;
        	}
        	
        	//应急广播消息覆盖的资源码数量
    	
    		//每个资源码长度
        	recordInfo.setResource_code_number(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	int resource_code_number = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1),16);
        	index += 1;
        	//每个资源码长度
        	recordInfo.setResource_code_length(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
        	
        	
        	int resource_code_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1),16);
        	index += 1;
        	List<ResourceInfo> resource_codes = new ArrayList<>();
        	
        	for (int i3 = 0; i3 < resource_code_number; i3++) {
        		ResourceInfo resourceInfo=new ResourceInfo();
        		String resource_code = ReplyProtocolTools.getProtocolHex(buffer, index,resource_code_length );
            	// 16进制的中文，可以解码成中文
        		resourceInfo.setResource_code(resource_code);
            	index += resource_code_length;
            	resource_codes.add(resourceInfo);
        	}
        	
        	recordInfo.setResource_codes(resource_codes);
        	records.add(recordInfo);
        	}
    	protocol0x15Body.setRecords(records);
    	ReplyProtocolTools.setProtocolSignatureData(protocolReplyCommonData, index, buffer);
    	protocolReplyCommonData.setData(protocol0x15Body);
    	logger.info(JSONObject.fromObject(protocolReplyCommonData).toString());
        	
        	
	}
	
	public static void parseProtocol0x16Data(ProtocolReplyCommonData protocolReplyCommonData, byte[] buffer){
		// 消息体起始字节数
		int index = 1 + 2 + 1 + 1 + 4;
    	// 消息头的消息设置
		ReplyProtocolTools.setProtocolHead(protocolReplyCommonData, buffer);
		// 消息体数据
    	Protocol0x16Body protocol0x16Body = new Protocol0x16Body();
    	
    	protocol0x16Body.setFront_code_reserved(ReplyProtocolTools.getProtocolHex(buffer, index, 12));
    	index+=12;
    	
    	protocol0x16Body.setFault_type(ReplyProtocolTools.getProtocolHex(buffer,index,1));
    	index +=1;
    	
    	protocol0x16Body.setFault_desc_length(ReplyProtocolTools.getProtocolHex(buffer,index,2));
    	
    	
    	int fault_desc_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 2), 16);
    	index +=2;
    	String fault_desc = ReplyProtocolTools.getProtocolHex(buffer, index, fault_desc_length);
    	protocol0x16Body.setFault_desc(fault_desc);
    	index +=fault_desc_length;
    	
    	
    	ReplyProtocolTools.setProtocolSignatureData(protocolReplyCommonData, index, buffer);
    	protocolReplyCommonData.setData(protocol0x16Body);
    	logger.info(JSONObject.fromObject(protocolReplyCommonData).toString());
    	
    	
	}
	
	public static void parseProtocol0x17Data(ProtocolReplyCommonData protocolReplyCommonData, byte[] buffer){
		// 消息体起始字节数
		int index = 1 + 2 + 1 + 1 + 4;
    	// 消息头的消息设置
		ReplyProtocolTools.setProtocolHead(protocolReplyCommonData, buffer);
		// 消息体数据
    	Protocol0x17Body protocol0x17Body = new Protocol0x17Body();
    	
    	protocol0x17Body.setFront_code_reserved(ReplyProtocolTools.getProtocolHex(buffer, index, 12));
    	index+=12;
    	
    	protocol0x17Body.setEbm_id_reserved(ReplyProtocolTools.getProtocolHex(buffer, index, 18));
    	index+=18;
    	
    	protocol0x17Body.setResult_code(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	index+=1;
    	
    	protocol0x17Body.setResult_desc_length(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
    	
    	
    	
    	int result_desc_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 4),16);
    	index+=4;
    	String result_desc = ReplyProtocolTools.getProtocolHex(buffer, index, result_desc_length);
    	protocol0x17Body.setResult_desc(result_desc);
    	index+=result_desc_length;
    	
    	protocol0x17Body.setAccept_stream_address_length(ReplyProtocolTools.getProtocolHex(buffer, index, 2));
    	
    	int accept_steam_address_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 2), 16);
    	index+=2;
    	String accept_stream_address = ReplyProtocolTools.getProtocolHex(buffer, index, accept_steam_address_length);
    	protocol0x17Body.setAccept_stream_address(accept_stream_address);
    	index+=accept_steam_address_length;
    	
    	ReplyProtocolTools.setProtocolSignatureData(protocolReplyCommonData, index, buffer);
    	protocolReplyCommonData.setData(protocol0x17Body);
    	logger.info(JSONObject.fromObject(protocolReplyCommonData).toString());
    	
	}
	
	public static void parseProtocol0x18Data(ProtocolReplyCommonData protocolReplyCommonData, byte[] buffer){
		// 消息体起始字节数
		int index = 1 + 2 + 1 + 1 + 4;
		// 消息头的消息设置
		ReplyProtocolTools.setProtocolHead(protocolReplyCommonData, buffer);
		// 消息体数据
    	Protocol0x18Body protocol0x18Body = new Protocol0x18Body();
    	
    	protocol0x18Body.setReserved_and_front_code(ReplyProtocolTools.getProtocolHex(buffer, index, 12));
    	index+=12;
    	
    	protocol0x18Body.setReserved_and_ebm_id(ReplyProtocolTools.getProtocolHex(buffer, index, 18));
    	index+=18;
    	
    	protocol0x18Body.setProgram_resource(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	int program_resource = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1),16);
    	index+=1;
    	
    	protocol0x18Body.setEbm_class(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	index+=1;
    	
    	protocol0x18Body.setEbm_level(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	index+=1;
    	
    	protocol0x18Body.setEbm_type(ReplyProtocolTools.getProtocolHex(buffer, index, 5));
    	index+=5;
    	
    	protocol0x18Body.setInput_channel_id(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	index+=1;
    	
    	protocol0x18Body.setOutput_channel_number(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	int output_channel_number = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1),16);
    	index+=1;
    	
    	List<cn.wtu.broadcast.openapi.protocol.body.adapter.report.Protocol0x18Body.output_channel_Info> output_channels = new ArrayList<cn.wtu.broadcast.openapi.protocol.body.adapter.report.Protocol0x18Body.output_channel_Info>();
    	
    	for(int i=0;i< output_channel_number;i++){
    		cn.wtu.broadcast.openapi.protocol.body.adapter.report.Protocol0x18Body.output_channel_Info output_channel = new cn.wtu.broadcast.openapi.protocol.body.adapter.report.Protocol0x18Body.output_channel_Info();
    		output_channel.setOutput_channel_type(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    		index+=1;
    		
    		output_channel.setOutput_channel_id(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    		index+=1;
    		output_channels.add(output_channel);
    	}
    	
    	protocol0x18Body.setOutput_channels(output_channels);
    	if(program_resource==3||program_resource==4){
    		protocol0x18Body.setTel_length(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    		int tel_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1), 16);
    		index+=1;
    		
    		protocol0x18Body.setTel_number(ReplyProtocolTools.getProtocolHex(buffer, index, tel_length));
    		index+=tel_length;
    	}
    	protocol0x18Body.setVolume(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	index+=1;
    	
    	
    	protocol0x18Body.setResource_code_number(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	int resource_code_number = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1),16);
    	index+=1;
    	
    	protocol0x18Body.setResource_code_length(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	int resource_code_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1),16);
    	index+=1;
    	
    	List<byte[]> resource_codes = new ArrayList<byte[]>();
    	
    	for(int i=0;i< resource_code_number; i++){
    		byte[] resource_code = ReplyProtocolTools.getProtocolHex(buffer, index, resource_code_length).getBytes();
    		resource_codes.add(resource_code);
    		index+=resource_code_length;
    	}
    	
    	protocol0x18Body.setResource_codes(resource_codes);
    	ReplyProtocolTools.setProtocolSignatureData(protocolReplyCommonData, index, buffer);
    	protocolReplyCommonData.setData(protocol0x18Body);
    	logger.info(JSONObject.fromObject(protocolReplyCommonData).toString());
    	
	}
	
	public static void parseProtocol0x19Data(ProtocolReplyCommonData protocolReplyCommonData,byte[] buffer){
		// 消息体起始字节数
		int index = 1 + 2 + 1 + 1 + 4;
    	// 消息头的消息设置
		ReplyProtocolTools.setProtocolHead(protocolReplyCommonData, buffer);
		// 消息体数据
    	Protocol0x19Body protocol0x19Body = new Protocol0x19Body();
    	protocol0x19Body.setReserved_and_front_code(ReplyProtocolTools.getProtocolHex(buffer, index, 12));
    	index+=12;
    	
    	protocol0x19Body.setReserved_and_ebm_id(ReplyProtocolTools.getProtocolHex(buffer, index, 18));
    	index+=18;
    	ReplyProtocolTools.setProtocolSignatureData(protocolReplyCommonData, index, buffer);
    	protocolReplyCommonData.setData(protocol0x19Body);
    	logger.info(JSONObject.fromObject(protocolReplyCommonData).toString());
    		
	}
	
	public static void parseProtocol0x20Data(ProtocolReplyCommonData protocolReplyCommonData,byte[] buffer){
		// 消息体起始字节数
		int index = 1 + 2 + 1 + 1 + 4;
		// 消息头的消息设置
		ReplyProtocolTools.setProtocolHead(protocolReplyCommonData, buffer);
		// 消息体数据
    	Protocol0x20Body protocol0x20Body = new Protocol0x20Body();
    	protocol0x20Body.setFront_code_length(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	int front_code_length = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 1),16);
    	index+=1;
    	
    	protocol0x20Body.setFront_code(ReplyProtocolTools.getProtocolHex(buffer, index, front_code_length));
    	index+=front_code_length;
    	
    	protocol0x20Body.setFront_State(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
    	index+=1;
    	
    	protocol0x20Body.setConnection_time(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
    	index+=4;
    	ReplyProtocolTools.setProtocolSignatureData(protocolReplyCommonData, index, buffer);
    	protocolReplyCommonData.setData(protocol0x20Body);
    	logger.info(JSONObject.fromObject(protocolReplyCommonData).toString());
    		
    	
	}
}
