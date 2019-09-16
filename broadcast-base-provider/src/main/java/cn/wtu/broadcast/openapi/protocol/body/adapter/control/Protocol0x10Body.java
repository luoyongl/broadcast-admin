package cn.wtu.broadcast.openapi.protocol.body.adapter.control;

import java.util.Date;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急大喇叭适配器控制指令----播发记录查询(0x10)
 * 
 * @author Lenovo
 * 
 *
 */
public class Protocol0x10Body extends ProtocolBodyCommonInfo {

	public Protocol0x10Body(String frontCode, String platformResourceCode, byte task_type, Date startTime,
			Date endTime) {
		protocol_type = ProtocolTypeEnum.Protocol0x10Body;

		// F表示保留位0x0F
		reserved_and_frontCode = SendProtocolTools.strToHexBytes("F" + frontCode);

		this.setReservedAndEbmId(platformResourceCode);

		// 任务类型8bit：0为全部节目，1为日常节目，2为应急节目
		this.task_type = task_type;

		this.startTime = SendProtocolTools.date2Bytes(startTime);
		this.endTime = SendProtocolTools.date2Bytes(endTime);
	}

	// 保留4bit，取值为”1111”
	// byte reserved1 = 0x0f;
	// BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	// byte[] front_code;
	// 保留4bit，取值为”1111”
	// byte reserved2 = 0x0f;
	// BCD编码的应急广播消息标识符； (当EBMID=0时的关机为全区域关机) 140bit = 35位BCD码
	// byte[] ebm_id;

	// 任务类型8bit：0为全部节目，1为日常节目，2为应急节目
	byte task_type;
	// 播发记录开始时间 32bit
	public byte[] startTime = new byte[4];
	// 播发记录结束时间32bit
	public byte[] endTime = new byte[4];

	public int getSize() {
		primary_cmd_len = 12 + 18 + 1 + 4 + 4;
		return primary_cmd_len;
	}

	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];

		if (reserved_and_frontCode != null) {
			System.arraycopy(reserved_and_frontCode, 0, data, offSet, reserved_and_frontCode.length);
			offSet += reserved_and_frontCode.length;
		}
		if (reserved_and_ebmId != null) {
			System.arraycopy(reserved_and_ebmId, 0, data, offSet, reserved_and_ebmId.length);
			offSet += reserved_and_ebmId.length;
		}

		data[offSet++] = (byte) task_type;

		System.arraycopy(startTime, 0, data, offSet, 4);
		offSet += 4;
		System.arraycopy(endTime, 0, data, offSet, 4);
		offSet += 4;

		return data;
	}
}
