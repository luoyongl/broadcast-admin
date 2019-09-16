package cn.wtu.broadcast.openapi.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.common.NettyClient;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;
import cn.wtu.broadcast.parent.utils.sign.SignatureData;
import cn.wtu.broadcast.parent.vo.IpVO;
import io.netty.channel.Channel;

public class Ipdata {

	public static Logger logger = LoggerFactory.getLogger(Ipdata.class);
	/**
	 * 顺序码
	 */
	@SuppressWarnings("unused")
	private static int orderCode = 1;
	
	
	/**
	 * 终端参数查询
	 * @param channel
	 * @param resourceList
	 * @param ip
	 * @param port
	 */
	public static void terminalParamControl(Channel channel, List<String> resourceList, String ip,String port) {
		try {
			String sendData = terminalParamQuery(resourceList, ip, port);
			String data = ControlData("08", sendData);
			if (data != null && channel.isOpen() && channel.isActive()) {
				channel.writeAndFlush(SendIPUtils.hexToByte(data));
				logger.info("终端参数查询消息发送成功:" + data);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}
	
	
	private static String terminalParamQuery(List<String> resourceList, String ip, String port) {
		StringBuilder body = new StringBuilder();
		body.append("02");	//回传地址类型 01短信方式 对应地址为号码 02 4字节ip + 2字节prot 03 域名+port
		String[] ipArray =  ip.split("\\.");	//.为特殊字符 需要转义
		String newIp = "";
		for(int i = 0;i<ipArray.length;i++){
			newIp += SendIPUtils.addZeroForNum(Integer.toHexString(Integer.parseInt(ipArray[i])),2);
		}
		String newPort = SendIPUtils.addZeroForNum(Integer.toHexString(Integer.parseInt(port)),2);
		body.append("06");	//回传地址长度  4字节ip + 2字节prot
		body.append(newIp).append(newPort);
		body.append("01");	//寻址方式 
		String resourceCodes = Ipdata.getResourceCodes( resourceList);
		body.append(resourceCodes); // resource_code_number +resource_code_length + resource_codes		
		//TODO 查询参数封装 默认全选
		body.append("0a"); //10个参数
		for(int i=1;i<11;i++){
			body.append(SendIPUtils.addZeroForNum(Integer.toHexString(i),2));
		}
		return body.toString();
	}


	/**
	 * 回传参数设置
	 * @param channel
	 * @param resourceList
	 * @param ip
	 * @param port
	 */
	public static void rebackParamControl(Channel channel, List<String> resourceList, String ip,String port) {
		try {
			String sendData = updateRebackParam(resourceList, ip, port);
			String data = ControlData("07", sendData);
			if (data != null && channel.isOpen() && channel.isActive()) {
				channel.writeAndFlush(SendIPUtils.hexToByte(data));
				logger.info("回传设置消息发送成功:" + data);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}
	
	/**
	 * 通用指令封装
	 * @param protocolType  协议号
	 * @param sendData	body数据
	 * @return
	 */
	private static String ControlData(String protocolType,String sendData){
		String data = null;
		try {
			String privateKey = RedisDb.getString("private_key");
			String timeZone = RedisDb.getString("timeZone_set");
			// 缺少数据包长度,后面会加上
			String head = getSendHead(protocolType);
			StringBuilder data2 = new StringBuilder(head);
			data2.append(sendData);		
			String totalSize = SendIPUtils.addZeroForNum((Integer.toHexString(sendData.length() / 2 )),8);
			//尾部总长度80 + 2字节的指令总长度  此处data2包括消息头（除了总长度）和消息体
			//String totalSize = SendIPUtils.addZeroForNum((Integer.toHexString(data2.length() / 2 + 80 + 4)),8);
			data2.insert(head.length(), totalSize); // 插入总长度
			data2.append(getTail(data2.toString(), privateKey, timeZone));
			data = data2.toString();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return data;
	}
	
	/**
	 * 
	 * @param resourceList
	 * @param ip "10.177.3.143"
	 * @param port "7000"
	 * @return
	 */
	private static String updateRebackParam(List<String> resourceList, String ip, String port) {
		StringBuilder body = new StringBuilder();
		body.append("02");	//回传地址类型 01短信方式 对应地址为号码 02 4字节ip + 2字节prot 03 域名+port
		String[] ipArray =  ip.split("\\.");	//.为特殊字符 需要转义
		String newIp = "";
		for(int i = 0;i<ipArray.length;i++){
			newIp += SendIPUtils.addZeroForNum(Integer.toHexString(Integer.parseInt(ipArray[i])),2);
		}
		String newPort = SendIPUtils.addZeroForNum(Integer.toHexString(Integer.parseInt(port)),2);
		body.append("06");	//回传地址长度  4字节ip + 2字节prot
		body.append(newIp).append(newPort);
		body.append("01");	//寻址方式 
		String resourceCodes = Ipdata.getResourceCodes( resourceList);
		body.append(resourceCodes); // resource_code_number +resource_code_length + resource_codes		
		return body.toString();
	}

	/**
	 * 终端音量设置
	 * @param channel
	 * @param volume 0-100
	 * @param resourceList 要修改的终端资源码
	 */
	public static void volumeControl(Channel channel, int volume, List<String> resourceList) {
		try {
			String sendData = updateVolume(volume, resourceList);
			String data = ControlData("06", sendData);
			if (data != null && channel.isOpen() && channel.isActive()) {
				channel.writeAndFlush(SendIPUtils.hexToByte(data));
				logger.info("音量设置消息发送成功:" + data);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}
	
	private static String updateVolume(int volume, List<String> resourceList) {
		// 将音量如60 转换成16进制 3c
		String hexVolume = SendIPUtils.intToHex(volume);
		StringBuilder body = new StringBuilder();
		body.append(SendIPUtils.addZeroForNum(hexVolume, 2));
		body.append("01");	//寻址类型 01逻辑码 02物理码
		String resourceCodes = Ipdata.getResourceCodes( resourceList);
		body.append(resourceCodes); // resource_code_number +resource_code_length + resource_codes		
		return body.toString();
	}

	/**
	 * 通用资源编码设置
	 * 
	 * @param answer
	 * @param map<key,value> key为物理码 value为对应设备新的资源码
	 */
	public static void resourceCodesControl(Channel channel, HashMap<String,String> map) {
		try {
			String sendData = updateResourceCodes(map);
			String data = ControlData("05", sendData);
			if (data != null && channel.isOpen() && channel.isActive()) {
				channel.writeAndFlush(SendIPUtils.hexToByte(data));
				logger.info("资源编码设置消息发送成功:" + data);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}

	
	private static String updateResourceCodes(HashMap<String, String> map) {
		StringBuilder body = new StringBuilder();
		if(map != null && map.size()!=0){
			body.append(SendIPUtils.addZeroForNum(Integer.toHexString(map.size()), 2));
			Iterator<String> iter = map.keySet().iterator();
			while(iter.hasNext()){
				String physicalAddress = iter.next(); //key 为物理编码
				String resourceCode = map.get(physicalAddress); //value为逻辑码
				body.append(SendIPUtils.addZeroForNum(Integer.toHexString(physicalAddress.length()/2),2)).append(physicalAddress)
				.append(SendIPUtils.addZeroForNum(Integer.toHexString((resourceCode.length()+1)/2), 2)).append("f"+resourceCode);
			}
		}
		return body.toString();
	}


	/**
	 * 心跳应答响应处理
	 * 
	 * @param answer
	 */
	public static void heartControl( String heartData) {
		try {
			String resourceCodeLen = heartData.substring(18, 20);
			String resourceCode = heartData.substring(21, 20 + Integer.parseInt(resourceCodeLen, 16) * 2); // 第20位为F?
			String sendData = heartAnswer(heartData);
			String data = ControlData("21", sendData);
			if (data != null ) {
				NettyClient.start(resourceCode, SendIPUtils.hexToByte(data));
				logger.info("心跳数据:" + heartData.toString());
				logger.info("心跳回复发送成功:" + data);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}
	

	/**
	 * IP播发
	 * 
	 * @param ipVO
	 */
	public static void sendIPControl(IpVO ipVO) {
		try {
			String sendData = play(ipVO);
			String data = ControlData("04",sendData);
			// 保存已经播放的广播，用于停播用
			if (ipVO.getfId() != null) {
				SendIPUtils.sendIpVOMap.put(ipVO.getfId(), ipVO);
			}
			NettyClient.start(ipVO.getAdapterResourceCode(), SendIPUtils.hexToByte(data));
			logger.info("开播指令发送成功:" + data.toString());
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}

	/**
	 * 发送停播指令
	 * 
	 * @param ipvo
	 */
	public static void stopIPControl(IpVO ipVO) {
		try {
			String sendData = stopPlay(ipVO);
			String data = ControlData("04", sendData);
			NettyClient.start(ipVO.getAdapterResourceCode(), SendIPUtils.hexToByte(data));
			logger.info("停播指令发送成功:" + data);
			
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}

	/**
	 * 停播指令body部分封装
	 * 
	 * @param ipVO
	 * @return
	 */
	private static String stopPlay(IpVO ipVO) {
		String platformResourceCode = RedisDb.getString("platform_resource_code");
		StringBuilder body = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		String year = "" + cal.get(Calendar.YEAR);
		String month = "" + (cal.get(Calendar.MONTH) + 1);
		String day = "" + cal.get(Calendar.DAY_OF_MONTH);
		if (month.length() < 2) {
			month = "0" + month;
		}
		if (day.length() < 2) {
			day = "0" + day;
		}
		body.append("f"); // reserved 保留数据

		/*
		 * 35 位数字码，通过应急广播消息编号区别其他的应急广播消息。 应急广播平台ID(23 位)+日期（8 位）+顺序码（4
		 * 位）顺序码：当顺序码为 0000 时， 表示当前应急广播消息为非强制播发，可不进行处理；当顺序码为 0001～9999
		 * 时，表示当前应急广播消息为强制播发，需进行处理 TODO 顺序码到底是取广播ID还是全局参数，停播怎么获取到顺序码
		 */
		String ebmId = platformResourceCode + year + month + day
				+ SendIPUtils.addZeroForNum(ipVO.getfId(), 4);
		body.append(ebmId);
		body.append("02"); 	//表示停播
		body.append("01");// 逻辑码寻址 resource_code_type
		String resourceCodes = Ipdata.getResourceCodes(ipVO.getResourceCodeList());
		body.append(resourceCodes); // resource_code_number +resource_code_length + resource_codes
		return body.toString();
	}

	/**
	 * 开播指令body部分封装
	 * 
	 * @param ipVO
	 * @return
	 */
	private static String play(IpVO ipVO) {
		String platformResourceCode = RedisDb.getString("platform_resource_code");
		StringBuilder body = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		String year = "" + cal.get(Calendar.YEAR);
		String month = "" + (cal.get(Calendar.MONTH) + 1);
		String day = "" + cal.get(Calendar.DAY_OF_MONTH);
		if (month.length() < 2) {
			month = "0" + month;
		}
		if (day.length() < 2) {
			day = "0" + day;
		}
		body.append("f"); // reserved 保留数据

		/*
		 * 35 位数字码，通过应急广播消息编号区别其他的应急广播消息。 应急广播平台ID(23 位)+日期（8 位）+顺序码（4
		 * 位）顺序码：当顺序码为 0000 时， 表示当前应急广播消息为非强制播发，可不进行处理；当顺序码为 0001～9999
		 * 时，表示当前应急广播消息为强制播发，需进行处理 TODO 顺序码到底是取广播ID还是全局参数，停播怎么获取到顺序码
		 */
		String ebmId = platformResourceCode + year + month + day
				+ SendIPUtils.addZeroForNum(ipVO.getfId(), 4);
		/*
		 * if(orderCode > 0 && orderCode < 10000){ ebmId +=
		 * SendIPUtils.addZeroForNum(""+orderCode, 4); orderCode++; }
		 */
		body.append(ebmId);
		body.append("01"); // power_switch 01开播 02停播
		body.append(ipVO.getBroadCastType()); // 应急广播类型 04应急 05日常
		body.append(ipVO.getEventType()); // 广播事件类型
		body.append(ipVO.getEventLevel()); // 广播事件级别 0缺省 1-4 一级到四级
		cal = getTimeCalendar();
		String startTime = Integer.toHexString((int) (cal.getTime().getTime() / 1000));
		String endTime = Integer.toHexString((int) ((cal.getTime().getTime() / 1000) + 360)); // TODO默认取开始时间6分钟后结束，以后考虑
																								// 从界面取
		body.append(startTime);
		body.append(endTime);
		// 将音量如60 转换成16进制 3c
		String volume = SendIPUtils.intToHex(ipVO.getVolume().intValue());
		body.append(SendIPUtils.addZeroForNum(volume, 2));
		body.append("01"); // 寻址类型 01逻辑码 02物理码 TODO 默认逻辑码寻址 后期看是否需要修改
		
		String resourceCodes = Ipdata.getResourceCodes(ipVO.getResourceCodeList());// resource_code_number
		//String resourceCodes = "010cf64107040000000314010201";// resource_code_number
							// +  010cf64107040000000314010400
																													// resource_code_length
																													// +
																													// resource_codes
		body.append(resourceCodes); // resource_code_number +
									// resource_code_length + resource_codes
		//多语种数量
		body.append("01");
		String languageCode = UDPUtil.stringToAscii("zho");
		body.append(languageCode).append("00").append("0000");
		String agencyName = SendIPUtils.stringToUnicode("舒城县应急广播平台");
		body.append(SendIPUtils.addZeroForNum(Integer.toHexString(agencyName.length()/2),2)).append(agencyName);
		// TODO 辅助数据部分封装	辅助数据类型62--3e  判断播发方式 true代表单播
		if(ipVO.getfBroadcastStyle()){
			body.append("01").append("3e").append("00000000");
		}else{
			body.append("01").append("3d").append(ipVO.getLen()).append(ipVO.getAudioURL());
		}
		//输入通道编号 和 输出通道数量
		body.append("00").append("00");
		return body.toString();
	}

	/**
	 * 拼接资源码数量 资源码长度 覆盖的资源码
	 * 
	 * @param objsCode
	 * @return
	 */
	public static String getResourceCodes( List<String> objsCode) {
		StringBuilder sb = new StringBuilder();
		sb.append(SendIPUtils.addZeroForNum("" + objsCode.size(), 2)); // 资源码数量
		sb.append(SendIPUtils.addZeroForNum(Integer.toHexString((objsCode.get(0).length()+1)/2),2)); // 资源编码长度 23位 第一个16进制数保留 TODO是长度是12--c? (23+1)/2再转16进制
		for (String i : objsCode) {
			sb.append("f" + i); // f为保留位
		}
		return sb.toString();
	}

	/**
	 * 消息头封装 缺少数据总长度
	 * 
	 * @param protocolType
	 * @return
	 */
	private static String getSendHead(String protocolType) {
		StringBuilder headBuild = new StringBuilder();
		headBuild.append("49"); // head 49表示消息是平台下发给适配器的
		headBuild.append("0001"); // 协议号 //TODO 考虑版本号0001由界面取
		if (protocolType != null && protocolType.length() != 0) {
			headBuild.append(SendIPUtils.addZeroForNum(protocolType, 2));
		}
		headBuild.append("01");
		return headBuild.toString();
	}

	/**
	 * 消息尾部封装
	 * 
	 * @param ipData
	 *            包含消息头和消息体的全部数据
	 * @param privateKey
	 * @param timeZoneSet
	 * @return
	 */
	private static String getTail(String ipData, String privateKey, String timeZoneSet) {
		StringBuilder dataForSign = new StringBuilder(ipData);

		List<String> privateKeys = new ArrayList<String>();
		privateKeys.add(privateKey);
		SignatureData signatureData = new SignatureData(privateKeys);
		/**
		 * 0-local 1-UTC 时区设置
		 */
		Calendar cal = getTimeCalendar();
		byte[] random = signatureData.calendar2Bytes(cal);
		signatureData.random = random;
		signatureData.setSrcData(SendIPUtils.hexToByte(dataForSign.toString()));
		byte[] signData = signatureData.convertToBytes();
		// 签名时间 + 证书编号 +签名
		StringBuilder tail = new StringBuilder(SendIPUtils.byteToHex(signData));
		// 验证数据加上长度
		tail.insert(0, SendIPUtils.addZeroForNum((Integer.toHexString(tail.length() / 2)), 4));
		StringBuilder all = new StringBuilder(ipData);
		all.append(tail);
		int calculate = TCRC32.crc_Calculate(SendIPUtils.hexToByte(all.toString()), 0,
				SendIPUtils.hexToByte(all.toString()).length);
		String hex32 = SendIPUtils.addZeroForNum(Integer.toHexString(calculate), 8);
		tail.append(hex32);
		return tail.toString();
	}

	/**
	 * 例如061245140210220301
	 * 
	 * @return
	 */
	public static String heartAnswer(String heartData) {
		StringBuilder body = new StringBuilder();
		String answer = "";
		try {
			if (heartData != null && heartData.length() != 0) {
				if (heartData.length() != 107 * 2) { // 心跳数据 消息头9+消息体18+尾部80 共
														// 107个  字节
					answer = "00000001";
				} else if (!"0001".equals(heartData.substring(2, 6))) { // 版本号 
					answer = "00000002";
				} else {
					answer = "00000000";
				}
				// 应答结果 00成功
				body.append(answer);
				// 结果描述长度为
				body.append("00000000");
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return body.toString();
	}

	
	private static Calendar getTimeCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getDefault());
		return cal;
	}
/*	private static Calendar getTimeCalendar(String timeZoneSet) {
		Calendar cal = Calendar.getInstance();
		if (Integer.parseInt(timeZoneSet) == 0) {
			// 获得时区和 GMT-0 的时间差,偏移量
			int offset = cal.get(Calendar.ZONE_OFFSET);
			// 获得夏令时 时差
			int dstoff = cal.get(Calendar.DST_OFFSET);
			cal.add(Calendar.MILLISECOND, (offset + dstoff));

		} else if (Integer.parseInt(timeZoneSet) == 1) {
			cal.setTimeZone(TimeZone.getDefault());
		}
		return cal;
	}*/
	
	/**
	 * 终端音量设置
	 * @param channel
	 * @param volume 0-100
	 * @param resourceList 要修改的终端资源码
	 *//*
	public static void volumeControl(Channel channel, int volume, List<String> resourceList) {
		String data = null;
		try {
			String privateKey = RedisDb.getString("private_key");
			String timeZone = RedisDb.getString("timeZone_set");
			// 缺少数据包长度,后面会加上
			String head = getSendHead("06");
			//总长度 + 消息体
			String sendData = updateVolume(volume, resourceList);
			StringBuilder data2 = new StringBuilder(head);
			data2.append(sendData);		
			//尾部总长度80 + 2字节的指令总长度  此处data2包括消息头（除了总长度）和消息体
			String totalSize = SendIPUtils.addZeroForNum((Integer.toHexString(data2.length() / 2 + 80 + 4)),8);
			data2.insert(head.length(), totalSize); // 插入总长度
			data2.append(getTail(data2.toString(), privateKey, timeZone));
			data = data2.toString();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		if (data != null && channel.isOpen() && channel.isActive()) {
			channel.writeAndFlush(SendIPUtils.hexToByte(data));
			logger.info("资源编码设置消息发送成功:" + data);
		}
	}
*/
}
