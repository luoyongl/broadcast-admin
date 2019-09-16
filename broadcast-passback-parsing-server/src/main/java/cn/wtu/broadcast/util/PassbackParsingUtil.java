package cn.wtu.broadcast.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.entity.PassbackBodyData;
import cn.wtu.broadcast.entity.PassbackHeadData;
import cn.wtu.broadcast.entity.PassbackSignData;
import cn.wtu.broadcast.entity.PassbackTotalData;
import cn.wtu.broadcast.entity.body.PassbackBody0x10Data;

import cn.wtu.broadcast.entity.body.PassbackBody0x13Data;
import cn.wtu.broadcast.entity.body.PassbackBody0x14Data;
import cn.wtu.broadcast.entity.body.PassbackBody0x15Data;
import cn.wtu.broadcast.entity.body.PassbackBody0x16Data;
import cn.wtu.broadcast.entity.body.PassbackBody0x16Data.RecordInfo;
import cn.wtu.broadcast.entity.body.PassbackBody0x11Data;
import cn.wtu.broadcast.entity.body.PassbackBody0x11Data.queryContext;
import cn.wtu.broadcast.entity.body.PassbackBody0x11Data.queryContext.frequencyList;

import net.sf.json.JSONObject;

public class PassbackParsingUtil {

	private static Logger logger = LoggerFactory.getLogger(PassbackParsingUtil.class);

	/**
	 * 解析回传数据
	 * 
	 * @param buffer
	 * @param length
	 */
	public static PassbackTotalData parseData(byte[] buffer) {
		// 定义消息的相关结构体
		PassbackTotalData passbackTotalData = new PassbackTotalData();
		PassbackHeadData head = new PassbackHeadData();
		PassbackBodyData body = new PassbackBodyData();
		PassbackSignData sign = new PassbackSignData();
		int index = 0;
		// 消息头的内容
		index = setHeadData(index, buffer, head);
		// 消息体的内容
		index = setBodyData(index, buffer, body);
		// 检验数据
		// byte[4] CRC32检验数据
		// 从包头标记 开始 至 业务 数据内容 计算 CRC 32 校验 数据 ，
		int CRC32 = TypeChangeUtil.buf_to_u32(buffer, index);
		index += 4;
		sign.setCrc32(String.valueOf(CRC32));
		passbackTotalData.setHead(head);
		passbackTotalData.setBody(body);
		passbackTotalData.setSign(sign);
		logger.info(JSONObject.fromObject(passbackTotalData).toString());
		return passbackTotalData;
	}

	/**
	 * 消息头数据的解析
	 * @param index
	 * @param buffer
	 * @param head
	 * @return
	 */
	private static int setHeadData(int index, byte[] buffer, PassbackHeadData head) {
		// byte[2] 包头标记=0xFEFD
		int Head = TypeChangeUtil.buf_to_u16(buffer, index);
		index += 2;
		head.setHeadMark(TypeChangeUtil.u16_to_string(Head));

		// byte[2] 协议版本号=0x0100
		int Ver = TypeChangeUtil.buf_to_u16(buffer, index);
		index += 2;
		head.setVersion(TypeChangeUtil.u16_to_string(Ver));

		// byte[4] 会话标识,应答与请求一致
		// 请求数据包在发送端的统一编号，单向递增。请求与应答的会话标识要保持一致
		int Tag = TypeChangeUtil.buf_to_u32(buffer, index);
		index += 4;
		head.setTag(TypeChangeUtil.u32_to_string(Tag));

		// byte[1] 数据包类型(主动上报=1，被动回传=2)
		int PackType = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		head.setPackType(String.valueOf(PackType));

		// byte[2] 数据包总长度(头至尾)
		// 标识为整个回传数据包的长度
		int PackLen = TypeChangeUtil.buf_to_u16(buffer, index);
		index += 2;
		head.setPackLen(String.valueOf(PackLen));

		return index;
	}

	/**
	 * 消息体数据的解析
	 * @param index
	 * @param buffer
	 * @param body
	 * @return
	 */
	private static int setBodyData(int index, byte[] buffer, PassbackBodyData body) {
		// byte[12] 数据源对象编码
		// 数据包发送端 的 资源编码 ，共 12 字节 ，前 4bit 保留 ，后 23 个 BCD 码 有效 。资源 编码 的定义详见 GD/J
		// 080 2018
		byte Source[] = TypeChangeUtil.buf_to_bytes(buffer, index, 12);
		index += 12;
		body.setSource(TypeChangeUtil.source_to_string(Source));

		// byte[2] 数据目标对象数量
		// 数据目标对象数量
		int Number = TypeChangeUtil.buf_to_u16(buffer, index);
		index += 2;
		body.setNumber(String.valueOf(Number));

		// byte[12xNumber] 数据目标对象编码序列，12x数据目标对象数量
		// 数据包接收端 的 资源编码。目标对象编码格式同源对象编码
		byte Traget[] = TypeChangeUtil.buf_to_bytes(buffer, index, 12 * Number);
		index += (12 * Number);
		body.setSequence(TypeChangeUtil.bytes_to_string(Traget));

		// byte[1] 业务数据类型
		// 0x10：终端心跳
		// 0x11：查询指令应答
		// 0x13：终端故障与恢复
		// 0x14：终端任务 切换
		// 0x15：上报播发结果
		// 0x16：播发记录上报
		// 请求包与应答包 对应 业务数据类型 要 保持一致
		int DataType = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		body.setDataType("0x" + TypeChangeUtil.u8_to_string(DataType));

		// byte[2] 业务数据长度 u16 DataLen;
		int DataLen = TypeChangeUtil.buf_to_u16(buffer, index);
		index += 2;
		body.setDataLen(String.valueOf(DataLen));

		// byte[DataLen] 业务数据内容，可变长度 u8 * DataBuf;
		switch (DataType) {
		case 0x11:
			// 查询指令应答
			index = parse0x11Data(body,index, buffer);
			break;
		case 0x10:
			// 终端心跳
			index = parse0x10Data(body, index, buffer);
			break;
		case 0x13:
			// 故障 与恢复
			index = parse0x13Data(body,index, buffer);
			break;
		case 0x14:
			// 终端任务切换
			index = parse0x14Data(body,index, buffer);
			break;
		case 0x15:
			// 上报播发结果
			index = parse0x15Data(body,index, buffer);
			break;
		case 0x16:
			// 播发记录上报
			index = parse0x16Data(body,index, buffer);
			break;
		default:
			// 未知业务数据类型
			break;
		}

		return index;
	}

	/**
	 * 各乡镇村应急广播适配器根据回传周期定期上报播发记录
	 * 
	 * @param index
	 * @param buffer
	 * @return
	 */
	private static int parse0x16Data(PassbackBodyData body,int index, byte[] buffer) {
		PassbackBody0x16Data passbackBody0x16Data = new PassbackBody0x16Data();
		// byte[1] 前端编码长度
		// 前端编码长度
		int frontendCodeLength = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		passbackBody0x16Data.setFrontendCodeLength(String.valueOf(frontendCodeLength));

		// byte[] 前端编码
		// BCD编码
		byte frontendCode[] = TypeChangeUtil.buf_to_bytes(buffer, index, frontendCodeLength);
		index += frontendCodeLength;
		passbackBody0x16Data.setFrontendCode(TypeChangeUtil.bytes_to_string(frontendCode));

		// byte[1] 播发记录数
		// 正在播出的任务
		int playRecordNumber = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		passbackBody0x16Data.setPlayRecordNumber(String.valueOf(playRecordNumber));

		List<RecordInfo> recordInfoList = new ArrayList<RecordInfo>();
		for (int i = 0; i < playRecordNumber; i++) {
			RecordInfo recordInfo = new RecordInfo();
			// byte[2] 通道号
			// 播发的通道号
			int channelNumber = TypeChangeUtil.buf_to_u8(buffer, index);
			index += 2;
			recordInfo.setChannelNumber(String.valueOf(channelNumber));

			// byte[1] 播发状态
			// 0：未处理
			// 1：等待播发，指未到消息播发时间
			// 2：播发中
			// 3：播发成功
			// 4：播发失败，包括播发全部失败、播发部分失败、未按要求播发等情况
			// 5：播发取消
			int playStatus = TypeChangeUtil.buf_to_u8(buffer, index);
			index += 1;
			recordInfo.setPlayStatus(String.valueOf(playStatus));

			// byte[18] EBM_id
			// BCD编码的应急广播消息标识符
			byte ebmId[] = TypeChangeUtil.buf_to_bytes(buffer, index, 18);
			index += 18;
			recordInfo.setEbmId(TypeChangeUtil.bytes_to_string(ebmId));

			// byte[1] 任务类型
			// 1：应急节目源
			// 2：日常节目源
			// 3：电话
			// 4：短信
			// 5：调音台
			// 6：u盘；
			// 7：传输 覆盖网 其他通道（ 无线 ）信号
			int taskType = TypeChangeUtil.buf_to_u8(buffer, index);
			index += 1;
			recordInfo.setTaskType(String.valueOf(taskType));

			// byte[1] 应急广播类型
			// 应急广播类型：
			// 0：保留
			// 1：发布系统演练
			// 2：模拟演练
			// 3：实际演练
			// 4：应急广播
			// 05：日常广播
			// 其他：保留；
			int ebmType = TypeChangeUtil.buf_to_u8(buffer, index);
			index += 1;
			recordInfo.setEbmType(String.valueOf(ebmType));

			// byte[1] 事件级别
			// 应急广播事件级别：
			// 0：缺省
			// 1：1 级（特别重大）；
			// 2：2 级（重大）；
			// 3：3 级（较大）；
			// 4：4 级（一般）；
			// 其他：保留；
			int eventLevel = TypeChangeUtil.buf_to_u8(buffer, index);
			index += 1;
			recordInfo.setEventLevel(String.valueOf(eventLevel));

			// byte[5] 事件类型
			// 应急广播事件类型
			byte eventType[] = TypeChangeUtil.buf_to_bytes(buffer, index, 5);
			index += 5;
			recordInfo.setEventType(TypeChangeUtil.bytes_to_string(eventType));

			// byte[4] 开始时间
			// 时间均指北京时间(UTC+ 8)；传输均按照距 纪元时间 1970 1 1 00:00:00 ）的总秒数进行传输
			int startTime = TypeChangeUtil.buf_to_u32(buffer, index);
			index += 1;
			recordInfo.setStartTime(String.valueOf(startTime));

			// byte[4] 结束时间
			// 时间均指北京时间(UTC+ 8)；传输均按照距 纪元时间 1970 1 1 00:00:00 ）的总秒数进行传输
			int endTime = TypeChangeUtil.buf_to_u32(buffer, index);
			index += 4;
			recordInfo.setEndTime(String.valueOf(endTime));

			// If 任务类型 ==3 or 任务类型 ==4 {
			if (taskType == 3 || taskType == 4) {

				// byte[1] 电话号码长度
				// 电话号码长度，不是电话和短信开播时该数据填 0
				int phoneLength = TypeChangeUtil.buf_to_u8(buffer, index);
				index += 1;
				recordInfo.setPhoneLength(String.valueOf(phoneLength));

				// byte[] 电话号码
				byte phone[] = TypeChangeUtil.buf_to_bytes(buffer, index, phoneLength);
				index += phoneLength;
				recordInfo.setPhone(TypeChangeUtil.bytes_to_string(phone));

			}
			// }

			// byte[1] 音量大小
			// 音量按百分比形式标识，其中：
			// 0x00：静音
			// 0xff：开播，音量不变
			// 0x01-0x64 对应音量 1%-100%
			// 其他取值无意义
			int volume = TypeChangeUtil.buf_to_u8(buffer, index);
			index += 1;
			recordInfo.setVolume(String.valueOf(volume));

			// byte[1] 覆盖区域数量
			// 应急广播消息覆盖的资源码数量
			int coverRegionNumber = TypeChangeUtil.buf_to_u8(buffer, index);
			index += 1;
			recordInfo.setCoverRegionNumber(String.valueOf(coverRegionNumber));

			// byte[1] 区域码长度
			// 资源编码长度
			int areaCodeLength = TypeChangeUtil.buf_to_u8(buffer, index);
			index += 1;
			recordInfo.setAreaCodeLength(String.valueOf(areaCodeLength));

			List<byte[]> coverageResourceCodings = new ArrayList<byte[]>();
			// for (i=0;i<覆盖区域数量 i++) {
			for (int j = 0; j < coverRegionNumber; j++) {
				
				// byte[] 覆盖资源编码
				// BCD编码的资源码信息
				byte coverageResourceCoding[] = TypeChangeUtil.buf_to_bytes(buffer, index, areaCodeLength);
				index += areaCodeLength;
				coverageResourceCodings.add(coverageResourceCoding);
			}
			// }
			recordInfo.setCoverageResourceCodingList(coverageResourceCodings);
			recordInfoList.add(recordInfo);
		}
		passbackBody0x16Data.setRecordInfoList(recordInfoList);
		return index;
	}

	/**
	 * 终端完成播出 任务后 ，终端主动 向应急 广播 平台 上报 播发 结果
	 * 
	 * @param index
	 * @param buffer
	 * @return
	 */
	private static int parse0x15Data(PassbackBodyData body, int index, byte[] buffer) {
		PassbackBody0x15Data passbackBody0x15Data = new PassbackBody0x15Data();
		// byte[18] 应急广播消息 编号
		// 应急广播消息编号编码规 则见 GD/J 082 2018 。
		byte ebmId[] = TypeChangeUtil.buf_to_bytes(buffer, index, 18);
		index += 18;
		passbackBody0x15Data.setEbmId(TypeChangeUtil.bytes_to_string(ebmId));

		// byte[1] 结果代码
		// 0失败； 1 成功。
		int resultCode = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		passbackBody0x15Data.setResultCode(String.valueOf(resultCode));

		// byte[2] 结果描述长度
		// 结果描述的长度；如果无结果描述则长度为0 。
		int resultDescLength = TypeChangeUtil.buf_to_u16(buffer, index);
		index += 2;
		passbackBody0x15Data.setResultDescLength(String.valueOf(resultDescLength));

		// byte[] 结果描述内容
		// 可选，对应答结果进行描述。
		byte resultDesc[] = TypeChangeUtil.buf_to_bytes(buffer, index, resultDescLength);
		index += resultDescLength;
		passbackBody0x15Data.setResultDesc(TypeChangeUtil.bytes_to_string(resultDesc));

		// byte[4] 播发开始时间
		// 播发开始的 UTC 时间。
		int playStartTime = TypeChangeUtil.buf_to_u32(buffer, index);
		index += 4;
		passbackBody0x15Data.setPlayStartTime(String.valueOf(playStartTime));

		// byte[4] 播发结束时间
		// 播发结束的 UTC 时间。
		int playEndTime = TypeChangeUtil.buf_to_u32(buffer, index);
		index += 4;
		passbackBody0x15Data.setPlayEndTime(String.valueOf(playEndTime));

		// byte[1] 播发次数
		// 播发次数 。
		int playCount = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		passbackBody0x15Data.setPlayCount(String.valueOf(playCount));

		// byte[4] 上报时间
		// 上报播发结果的 UTC 时间。
		int reportTime = TypeChangeUtil.buf_to_u32(buffer, index);
		index += 4;
		passbackBody0x15Data.setReportTime(String.valueOf(reportTime));
		body = passbackBody0x15Data;
		return index;
	}

	/**
	 * 终端播出任务切换时，终端主动 向应急 广播 平台 上报 任务 切换情况
	 * 
	 * @param index
	 * @param buffer
	 * @return
	 */
	private static int parse0x14Data(PassbackBodyData body,int index, byte[] buffer) {
		PassbackBody0x14Data passbackBody0x14Data = new PassbackBody0x14Data();
		// byte[1] 切换标识
		// 1：任务 开始
		// 2：任务结束
		int switchTag = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		passbackBody0x14Data.setSwitchTag(String.valueOf(switchTag));

		// byte[1] 任务类型
		// 1：应急节目源
		// 2：日常节目源
		// 3：电话
		// 4：短信
		// 5：调音台
		// 6：U盘
		int taskType = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		passbackBody0x14Data.setTaskType(String.valueOf(taskType));
	

		// byte[18] 应急广播消息编码
		// 终端任务切换对应的应急广播消息 编码
		byte ebmId[] = TypeChangeUtil.buf_to_bytes(buffer, index, 18);
		index += 18;
		passbackBody0x14Data.setEbmId(String.valueOf(ebmId));
	

		// byte[4] 发生时间
		// 终端播出任务切换时的 UTC 时间
		int happenTime = TypeChangeUtil.buf_to_u32(buffer, index);
		index += 4;
		passbackBody0x14Data.setHappenTime(String.valueOf(happenTime));
		
		
		body = passbackBody0x14Data;
		return index;
	}

	/**
	 * 终端出现故障，或者故障消除，终端主动向应急广播平台上报故障/恢复情况
	 * 
	 * @param index
	 * @param buffer
	 * @return
	 */
	private static int parse0x13Data(PassbackBodyData body,int index, byte[] buffer) {
		PassbackBody0x13Data passbackBody0x13Data = new PassbackBody0x13Data();
		// byte[1] 故障恢复标识
		// 1：发生故障
		// 2：故障消除 ，即恢复正常
		int faultOrRecoveryTag = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
	
		passbackBody0x13Data.setFaultOrRecoveryTag(String.valueOf(faultOrRecoveryTag));
		//logger.info("故障恢复标识: " + faultOrRecoveryTag);

		// byte[1] 故障类型
		// 1：电源电流过低
		// 2：平均电源功耗过低
		// 3：功放输出电压过低
		// 4：锁定频率场强过低
		// 5：无法获取监测信息
		// 其他预留
		int faultType = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		passbackBody0x13Data.setFaultType(String.valueOf(faultType));
		//logger.info("故障类型: " + faultType);

		// byte[255] 故障描述
		// 发生故障或者故障恢复 的 描述信息
		byte faultDesc[] = TypeChangeUtil.buf_to_bytes(buffer, index, 255);
		index += 255;
		passbackBody0x13Data.setFaultDesc(String.valueOf(faultDesc));
	

		// byte[4] 发生时间
		// 发生故障或者故障恢复的 UTC 时间
		int happenTime = TypeChangeUtil.buf_to_u32(buffer, index);
		index += 4;
		passbackBody0x13Data.setHappenTime(String.valueOf(happenTime));
		
		
		body = passbackBody0x13Data;
		return index;
	}

	/**
	 * 终端周期性向应急广播平台发送心跳指令，主动向上汇报自身运行状态。
	 * 
	 * @param index
	 * @param buffer
	 * @return
	 */
	private static int parse0x10Data(PassbackBodyData body, int index, byte[] buffer) {
		PassbackBody0x10Data passbackBody0x10Data = new PassbackBody0x10Data();
		// byte[1] 终端工作状态
		// 终端当前所处工作状态：
		// 1：空闲 ，终端在线，但未进行任何广播操作
		// 2：工作，终端进行广播中
		// 3：故障，终端 处于故障状态。
		int workState = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		logger.info("终端工作状态: " + workState);
		passbackBody0x10Data.setWorkState(String.valueOf(workState));

		// byte[1] 首次注册标识
		// 终端通电启动后第一次 注册 标识
		// 1：首次注册
		// 2：非首次注册。
		int firstRegisterTag = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		logger.info("首次注册标识: " + firstRegisterTag);
		passbackBody0x10Data.setFirstRegisterTag(String.valueOf(firstRegisterTag));

		// byte[1] 物理地址编码长度
		// 物理地址 编码 的 长度。
		int physicsAddressLength = TypeChangeUtil.buf_to_u8(buffer, index);
		index += 1;
		logger.info("物理地址编码长度: " + physicsAddressLength);
		passbackBody0x10Data.setPhysicsAddressLength(String.valueOf(physicsAddressLength));

		// byte[] 物理地址编码
		// 终端唯一标识，出厂时生成，固定不变。
		byte physicsAddress[] = TypeChangeUtil.buf_to_bytes(buffer, index, physicsAddressLength);
		index += physicsAddressLength;
		logger.info("物理地址编码: " + TypeChangeUtil.bytes_to_string(physicsAddress));
		passbackBody0x10Data.setPhysicsAddress(TypeChangeUtil.bytes_to_string(physicsAddress));

		body = passbackBody0x10Data;
		return index;
	}

	/**
	 * 应急广播平台向终端下达终端状态参数查询指令，终端做出查询指令应答， 被动向平台回传查询信息数据
	 * 
	 * @param index
	 * @param buffer
	 * @return
	 */
	//@SuppressWarnings("unused")
	private static int parse0x11Data(PassbackBodyData body,int index, byte[] buffer) {
		PassbackBody0x11Data passbackBody0x11Data= new PassbackBody0x11Data();
		// byte[1] 结果代码
		// 0：表示终端成功接收
		// 13：表示请求数据包出现错误
		// 60：表示终端出现错误，无法处理。
		// 参见错误代码列表。
		int resultCode = TypeChangeUtil.buf_to_u8(buffer, index);
		passbackBody0x11Data.setResultCode(String.valueOf(resultCode));
		index += 1;
		logger.info("结果代码: " + resultCode);

		// byte[2] 结果描述长度
		// 结果描述的长度，如果无结果描述则长度为0 。
		int resultDescLength = TypeChangeUtil.buf_to_u16(buffer, index);
		passbackBody0x11Data.setResultDescLength(String.valueOf(resultDescLength));
		index += 2;
		logger.info("结果描述长度: " + resultDescLength);

		// byte[] 结果描述内容
		// 对查询结果进行描述。
		byte resultDesc[] = TypeChangeUtil.buf_to_bytes(buffer, index, resultDescLength);
		passbackBody0x11Data.setResultDesc(String.valueOf(resultDesc));
		index += resultDescLength;
		logger.info("结果描述内容: " + TypeChangeUtil.bytes_to_string(resultDesc));

		// byte[1] 查询参数个数
		// 查询参数的个数。
		int queryParameterNumber = TypeChangeUtil.buf_to_u8(buffer, index);
		passbackBody0x11Data.setQueryParameterNumber(String.valueOf(queryParameterNumber));
		index += 1;
		logger.info("查询参数个数: " + queryParameterNumber);
		List<queryContext> context=new ArrayList<>();
		for (int i = 0; i < queryParameterNumber; i++) {
			// byte[1] 参数标识 1
			queryContext queryContext = new queryContext();
			int parameterTag = TypeChangeUtil.buf_to_u8(buffer, index);
			queryContext.setParameterTag(String.valueOf(parameterTag));
			index += 1;
			logger.info("参数标识" + (i + 1) + ": 0x" + TypeChangeUtil.u8_to_string(parameterTag));

			// byte[1] 参数标识1 内容长度
			int parameterBodyLength = TypeChangeUtil.buf_to_u8(buffer, index);
			queryContext.setParameterBodyLength(String.valueOf(parameterBodyLength));
			index += 1;
			logger.info("参数标识" + (i + 1) + "内容长度: " + parameterBodyLength);

			// byte[] 参数标识1 内容描述
			byte parameterBody[] = TypeChangeUtil.buf_to_bytes(buffer, index, parameterBodyLength);
			queryContext.setParameterBody(String.valueOf(parameterBody));
			index += parameterBodyLength;
			logger.info("参数标识" + (i + 1) + "内容描述: " + TypeChangeUtil.bytes_to_string(parameterBody));

			// 表E.5 终端状态 查询 （应答）回传参数 状态数据 定义
			int bodyIndex = 0;
			//queryContext.setBodyIndex(String.valueOf(bodyIndex));
			int frequency = 0;
			//queryContext.setFrequency(String.valueOf(frequency));
			int signalStrength = 0;
			//queryContext.setSignalStrength(String.valueOf(signalStrength));
			int signalQuality = 0;
			//queryContext.setSignalQuality(String.valueOf(signalQuality));
			switch (parameterTag) {
			case 0x01:
				// byte[1] 终端音量 ,字段 必备项(IP, TS, RDS)
				bodyIndex = 0;
				// 终端输出音量，效果为终端可输出最大音量的百分比，取值范围： 0-100 。
				int localVolume = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setLocalVolume(String.valueOf(localVolume));
				bodyIndex += 1;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x02:
				// byte[12] 本地地址 ,字段 必备项(IP, TS, RDS)
				bodyIndex = 0;
				// IP地址（ 4字节 ）
				int localIpaddr = TypeChangeUtil.buf_to_u32(parameterBody, bodyIndex);
				queryContext.setLocalIpaddr(String.valueOf(localIpaddr));
				bodyIndex += 4;
				// 子网掩码（ 4 字节 ）
				int localNetmask = TypeChangeUtil.buf_to_u32(parameterBody, bodyIndex);
				queryContext.setLocalNetmask(String.valueOf(localNetmask));
				bodyIndex += 4;
				// 网关 （4 字节 ）
				int localGateway = TypeChangeUtil.buf_to_u32(parameterBody, bodyIndex);
				queryContext.setLocalGateway(String.valueOf(localGateway));
				bodyIndex += 4;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x03: // byte[] 回传地址 ,字段 必备项(IP, TS, RDS)
				bodyIndex = 0;
				// byte[1] 一 是 IP+ 端口，二是域名 端口， 用 内容中 第一个 字节 标识。 三是短信号码。
				int addressType = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setAddressType(String.valueOf(addressType));
				bodyIndex += 1;
				// 三种方式
				int backPort = 0;
				
				switch (addressType) {
				case 0x01:
					// 如果第一个 字节 为 0x01 ，表示 采用方式一， IPIP 4 字节 端口（ 2字节
					// byte[4] IP
					int backIpaddr = TypeChangeUtil.buf_to_u32(parameterBody, bodyIndex);
					queryContext.setBackIpaddr(String.valueOf(backIpaddr));
					bodyIndex += 4;
					// byte[2] 端口
					backPort = TypeChangeUtil.buf_to_u16(parameterBody, bodyIndex);
					queryContext.setBackPort(String.valueOf(backPort));
					bodyIndex += 2;
					queryContext.setBodyIndex(String.valueOf(bodyIndex));
					break;
				case 0x02:
					// 如果第一个 字节 为 0x02表示 采用方式 二 第二个 字节 标记域名长度 n 域名 n
					// 字节 端口2 字节
					// byte[1] 域名长度 n
					int backHostLength = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
					queryContext.setBackHostLength(String.valueOf(backHostLength));
					bodyIndex += 1;
					// byte[] 域名
					byte backHost[] = TypeChangeUtil.buf_to_bytes(parameterBody, bodyIndex, backHostLength);
					queryContext.setBackHost(String.valueOf(backHost));
					bodyIndex += backHostLength;
					// byte[2] 端口
					backPort = TypeChangeUtil.buf_to_u16(parameterBody, bodyIndex);
					queryContext.setBackPort(String.valueOf(backPort));
					bodyIndex += 2;
					queryContext.setBodyIndex(String.valueOf(bodyIndex));
					break;
				case 0x03:
					// 如果第一个 字节 为0x03 ，表示采用方式三，随后的第二字节表示短信号码的长度（通常为
					// 11 个字节的数字），第三字节开始的为短信号码。
					// byte[1] 短信号码的长度
					int backPhoneLength = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
					queryContext.setBackPhoneLength(String.valueOf(backPhoneLength));
					bodyIndex += 1;
					// byte[] 短信号码
					byte backPhone[] = TypeChangeUtil.buf_to_bytes(parameterBody, bodyIndex, backPhoneLength);
					queryContext.setBackPhone(String.valueOf(backPhone));
					bodyIndex += backPhoneLength;
					queryContext.setBodyIndex(String.valueOf(bodyIndex));
					break;
				default:
					break;
				}
				break;
			case 0x04:
				// byte[12] 终端资源编码 ,字段 必备项(IP, TS, RDS)
				bodyIndex = 0;
				// 共12 字节 ，前 4bit 保留 ，后 23个 BCD 码 有效 。资源 编码 的定义详见 GD/J 080
				// 2018
				byte localSource[] = TypeChangeUtil.buf_to_bytes(parameterBody, bodyIndex, 12);
				queryContext.setLocalSource(String.valueOf(localSource));
				bodyIndex += 12;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x05:
				// byte[] 物理地址编码 ,字段 必备项(IP, TS, RDS)
				bodyIndex = 0;
				// 第1 个 字节 标识物理 地址编码的长度值 后面 （长度 1 ）个字节终端唯一标识，出厂时生成，固定不变。
				int localPhysicsAddressLength = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setLocalPhysicsAddressLength(String.valueOf(localPhysicsAddressLength));
				bodyIndex += 1;
				byte localPhysicsAddress[] = TypeChangeUtil.buf_to_bytes(parameterBody, bodyIndex,
						localPhysicsAddressLength);
				queryContext.setLocalPhysicsAddress(String.valueOf(localPhysicsAddress));
				bodyIndex += localPhysicsAddressLength;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x06:
				// byte[1] 工作状态 ,字段 必备项(IP, TS, RDS)
				bodyIndex = 0;
				// 终端当前所处工作状态。
				// 1：空闲 ，终端在线，但未进行任何广播操作；
				// 2：工作，终端进行广播中
				// 3：故障 终端 处于故障状态。
				int localWorkState = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setLocalWorkState(String.valueOf(localWorkState));
				bodyIndex += 1;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x07:
				// byte[1] 故障代码 ,字段 必备项(IP)
				bodyIndex = 0;
				// 故障代码，标识终端故障类型， 1个 字节， 由厂家自行定义。
				int faultCode = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setFaultCode(String.valueOf(faultCode));
				bodyIndex += 1;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x08:
				// byte[2] 设备类型 ,字段 必备项(IP, TS, RDS)
				// 厂家自行定义
				break;
			case 0x09:
				// byte[4] 硬件版本号 ,字段 必备项(IP, TS, RDS)
				// 厂家自行定义
				break;
			case 0x0A:
				// byte[4] 软件版本号 ,字段 必备项(IP, TS, RDS)
				// 厂家自行定义
				break;
			case 0x0B:
				// byte[2] 调频信号状态 ,字段 必备项(RDS)
				bodyIndex = 0;
				// 信号强度(1B)+信号质量 (1B)
				signalStrength = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setSignalStrength(String.valueOf(signalStrength));
				bodyIndex += 1;
				signalQuality = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setSignalQuality(String.valueOf(signalQuality));
				bodyIndex += 1;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x0C:
				// byte[2] 有线信号状态 ,字段 必备项(TS)
				bodyIndex = 0;
				// 信号强度(1B)+信号质量 (1B)
				signalStrength = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setSignalStrength(String.valueOf(signalStrength));
				bodyIndex += 1;
				signalQuality = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setSignalQuality(String.valueOf(signalQuality));
				bodyIndex += 1;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x0D:
				// byte[2] 地面无线信号状态 ,字段 必备项(TS)
				bodyIndex = 0;
				// 信号强度(1B)+信号质量 (1B)
				signalStrength = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setSignalStrength(String.valueOf(signalStrength));
				bodyIndex += 1;
				signalQuality = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setSignalQuality(String.valueOf(signalQuality));
				bodyIndex += 1;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x0E:
				// byte[9] 有线频率 ,字段 必备项(TS)
				bodyIndex = 0;
				// 主频率,kHZ(4B)+符号率 ,kBPS(4B)+QAM(1B)
				frequency = TypeChangeUtil.buf_to_u32(parameterBody, bodyIndex);
				queryContext.setFrequency(String.valueOf(frequency));
				bodyIndex += 4;
				int QAM = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setQAM(String.valueOf(QAM));
				bodyIndex += 1;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x0F:
				// byte[4] 地面无线频率 ,字段 必备项(TS)
				bodyIndex = 0;
				// 主频率,kHZ(4B)
				frequency = TypeChangeUtil.buf_to_u32(parameterBody, bodyIndex);
				queryContext.setFrequency(String.valueOf(frequency));
				bodyIndex += 4;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x10:
				// byte[] FM频点扫描列表 ,字段 必备项(RDS)
				bodyIndex = 0;
				// 频点数(1B)+{频点序号 1(1B)+优先级 1(1B)+频率 1(3B)+...}
				int frequencyListNumber = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setFrequencyListNumber(String.valueOf(frequencyListNumber));
				bodyIndex += 1;
				List<frequencyList> frequencyList =new ArrayList<>();
				for (int k = 0; k < frequencyListNumber; k++) {
					frequencyList frequencyList1 = new frequencyList();
					int frequencyIndex = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
					frequencyList1.setFrequencyIndex(String.valueOf(frequencyIndex));
					bodyIndex += 1;
					int frequencyPriority = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
					frequencyList1.setFrequencyPriority(String.valueOf(frequencyPriority));
					bodyIndex += 1;
					frequency = TypeChangeUtil.buf_to_u24(parameterBody, bodyIndex);
					queryContext.setFrequency(String.valueOf(frequency));
					bodyIndex += 3;
					
					frequencyList.add(frequencyList1);
				}
				queryContext.setFrequencyList(frequencyList);
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x11: // byte[6] FM当前频点 ,字段 必备项(RDS)
				bodyIndex = 0;
				// 指令频点(3B)+节目频点 (3B)
				int frequencyContrl = TypeChangeUtil.buf_to_u24(parameterBody, bodyIndex);
				queryContext.setFrequencyContrl(String.valueOf(frequencyContrl));
				bodyIndex += 3;
				int frequencyChannel = TypeChangeUtil.buf_to_u24(parameterBody, bodyIndex);
				queryContext.setFrequencyChannel(String.valueOf(frequencyChannel));
				bodyIndex += 3;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
			case 0x12:
				// byte[3] FM维持指令模式 ,字段 必备项(RDS)
				bodyIndex = 0;
				// 是否启用,0 禁用， 1 ：启用(1B)+(维持周期（ 2B)
				int keepEnable = TypeChangeUtil.buf_to_u8(parameterBody, bodyIndex);
				queryContext.setKeepEnable(String.valueOf(keepEnable));
				bodyIndex += 1;
				int keepCycle = TypeChangeUtil.buf_to_u16(parameterBody, bodyIndex);
				queryContext.setKeepCycle(String.valueOf(keepCycle));
				bodyIndex += 2;
				queryContext.setBodyIndex(String.valueOf(bodyIndex));
				break;
		
			default:
				break;
			}
			
			context.add(queryContext);
		}
		passbackBody0x11Data.setContext(context);
		
		body = passbackBody0x11Data;
		return index;
	}
}
