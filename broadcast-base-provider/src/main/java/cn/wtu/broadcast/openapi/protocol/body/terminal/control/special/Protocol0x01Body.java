package cn.wtu.broadcast.openapi.protocol.body.terminal.control.special;

import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * TS锁定频率设置-0x01
 * 
 * @author Lenovo
 *
 */
public class Protocol0x01Body extends ProtocolBodyCommonInfo {

	public Protocol0x01Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x01Body;
	}

	// TsLockFrequency消息头
	// 指令类型：0：参数配置指令；1：保留；2：日常指令；
	byte tag = 0;
	// 指令数据长度
	int data_length;

	// TsLockFrequency消息体
	// 配置指令标识，取值0x04 8bit
	byte configure_cmd_tag = 0x04;
	// 配置指令长度 16bit
	short configure_cmd_length;
	// KHZ,主频频率 32bit
	public int freq;
	// 符号率(KBPS) 32bit
	public int symbol_rate;
	// qam 8bit QAM16:0 QAM32:1 QAM64:2 QAM128:3 QAM256:4 
	public byte qam;

	// 要设置的终端编号的地址类型 8bit 1: 表示逻辑码寻址； 2：表示物理码寻址； 3~9：保留
	// public byte resource_code_type;
	// 需要配置的区域和终端编码的个数 8bit
	// byte resource_code_number;
	// 终端编码长度 8bit
	// byte resource_code_length = 24 / 2;
	// 终端资源编码 BCD编码的资源码信息 resource_codes公共部分,提取到父类中
	// List<byte[]> resource_codes = new ArrayList<byte[]>();

	/**
	 * 获取指令的长度
	 * 
	 * @return 单位:字节byte
	 */
	public int getSize() {
		primary_cmd_len = 1 + 4 + 1 + 2 + 4 + 4 + 1 + 1 + 1 + 1;
		if (resource_codes != null) {
			primary_cmd_len += resource_code_number * resource_code_length;
		}

		// 指令数据长度 不包括 指令类型和指令数据长度(5字节)
		data_length = (int) (primary_cmd_len - 5);
		// 配置指令长度 不包括 配置指令标识和配置指令长度(3字节) 和 消息头的 指令类型和指令数据长度(5字节)
		configure_cmd_length = (short) (primary_cmd_len - 3 - 5);
		return primary_cmd_len;
	}

	/**
	 * 返回指令的字节数组byte[]
	 * 
	 * @return
	 */
	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];

		// TS消息头
		data[offSet++] = (byte) tag;
		// data_length 32bit
		data[offSet++] = (byte) ((data_length >> 24) & 0xff);
		data[offSet++] = (byte) ((data_length >> 16) & 0xff);
		data[offSet++] = (byte) ((data_length >> 8) & 0xff);
		data[offSet++] = (byte) (data_length & 0xff);

		// TS消息体
		data[offSet++] = (byte) configure_cmd_tag;
		// 获取configure_cmd_length的高8位
		data[offSet++] = (byte) (configure_cmd_length >> 8);
		// 获取configure_cmd_length的低8位
		data[offSet++] = (byte) (configure_cmd_length & 0xff);

		// freq 32bit
		data[offSet++] = (byte) ((freq >> 24) & 0xff);
		data[offSet++] = (byte) ((freq >> 16) & 0xff);
		data[offSet++] = (byte) ((freq >> 8) & 0xff);
		data[offSet++] = (byte) (freq & 0xff);

		// symbol_rate 32bit
		data[offSet++] = (byte) ((symbol_rate >> 24) & 0xff);
		data[offSet++] = (byte) ((symbol_rate >> 16) & 0xff);
		data[offSet++] = (byte) ((symbol_rate >> 8) & 0xff);
		data[offSet++] = (byte) (symbol_rate & 0xff);

		data[offSet++] = (byte) qam;
		data[offSet++] = (byte) resource_code_type;
		data[offSet++] = (byte) resource_code_number;
		data[offSet++] = (byte) resource_code_length;

		// 终端资源编码 BCD编码的资源码信息resource_codes
		if (resource_codes != null) {
			for (byte[] resource : resource_codes) {
				System.arraycopy(resource, 0, data, offSet, resource_code_length);
				offSet += resource_code_length;
			}
		}

		return data;
	}
}
