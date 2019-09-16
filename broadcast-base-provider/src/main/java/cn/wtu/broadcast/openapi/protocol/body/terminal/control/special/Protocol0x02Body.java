package cn.wtu.broadcast.openapi.protocol.body.terminal.control.special;

import java.util.ArrayList;
import java.util.List;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 设置RDS扫描频点信息-0x02
 * 
 * @author Lenovo
 *
 */
public class Protocol0x02Body extends ProtocolBodyCommonInfo {
	
	public Protocol0x02Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x02Body;
	}

	// RDS消息头
	// 指令类型 8bit 0：参数配置命令；1：应急广播；2：日常广播；
	byte cmd_type = 0;
	// 数据报类型 8bit 0x00表示设置RDS扫描频点信息
	byte data_type = 0x00;
	// 发送次数 8bit 0x00~0xFF，默认0xFF表示一直发送
	byte send_times = (byte) 0xFF;
	// 发送时间间隔 8bit 单位毫秒，默认100ms
	public byte interval = 100;
	
	// 覆盖区域(逻辑码)个数 8bit
	// byte coverag_resource_number;
	// 覆盖区域 每个元素72bit = 9字节 = 18位BCD码
	// List<byte[]> resource_codes = new ArrayList<byte[]>();
	
	// 消息体数据长度 32bit
	int data_length;

	// RDS消息体
	// 频点数：8bit，设置需要进行扫描的接收频点数，不超过255个，一般不建议超过5个。
	byte frequencyPointNumber;

	// 频点信息内容的集合
	public List<FrequencyInfo> frequencyInfos = new ArrayList<FrequencyInfo>();

	public static class FrequencyInfo {

		// 频点序号：8bit，序号，1-255，其中1号频点为默认扫描的起始频点（序号0在该指令中不能使用）;
		byte frequencyPointSequence;
		// 频点优先级：8bit，同时出现信号时，频点优先级数值小的优先级高。
		byte frequencyPointPriority;
		//频率：24bit  BCD码，单位为MHZ[78.00~108.00]，按照BCD编码的6个数字，其中小数点前4个，小数点后2个。 
		//这里仅仅用于接收值,真正封装时在内部转换了(减少代码改动).
		int frequency;

		public FrequencyInfo(byte frequencyPointSequence, byte frequencyPointPriority, double frequency) {
			this.frequencyPointSequence = frequencyPointSequence;
			this.frequencyPointPriority = frequencyPointPriority;
			this.frequency = (int) (frequency * 100);
		}

		public int getSize() {
			int len = 1 + 1 + 3;

			return len;
		}

		public byte[] convertToBytes() {
			int offSet = 0;
			byte[] data = new byte[getSize()];

			data[offSet++] = (byte) frequencyPointSequence;
			data[offSet++] = (byte) frequencyPointPriority;

			/**
			 * 1.页面传过来的是double,单位MHZ
			 * 2.封装时是按照KHZ的;X100
			 * 3.封装时是3byte,而又是BCD码；固定长度6位；不足补0
			 * 4.转BCD码
			 */
			byte[] bys = SendProtocolTools.strToHexBytes(String.format("%06d", frequency));
			
			System.arraycopy(bys, 0, data, offSet, bys.length);

			return data;
		}
	}

	/**
	 * 获取指令的长度 单位:字节byte
	 * 
	 * @return
	 */
	public int getSize() {
		// 消息体数据长度 32bit
		data_length = 1;

		if (frequencyInfos != null) {
			frequencyPointNumber = (byte) frequencyInfos.size();
			data_length += 5 * frequencyPointNumber;
		}

		primary_cmd_len = 5 + 4 + data_length;
		if (resource_codes != null) {
			primary_cmd_len += resource_code_number * resource_code_length;
		}

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

		// RDS消息头
		data[offSet++] = (byte) cmd_type;
		data[offSet++] = (byte) data_type;
		data[offSet++] = (byte) send_times;
		data[offSet++] = (byte) interval;
		data[offSet++] = (byte) resource_code_number;
		// resource_codes
		// 终端资源编码 BCD编码的资源码信息resource_codes
		if (resource_codes != null) {
			for (byte[] resource : resource_codes) {
				System.arraycopy(resource, 0, data, offSet, resource.length);
				offSet += resource.length;
			}
		}

		// data_length 32bit
		data[offSet++] = (byte) ((data_length >> 24) & 0xff);
		data[offSet++] = (byte) ((data_length >> 16) & 0xff);
		data[offSet++] = (byte) ((data_length >> 8) & 0xff);
		data[offSet++] = (byte) (data_length & 0xff);

		// RDS消息体
		data[offSet++] = (byte) frequencyPointNumber;

		if (frequencyInfos != null) {
			for (FrequencyInfo frequencyInfo : frequencyInfos) {
				System.arraycopy(frequencyInfo.convertToBytes(), 0, data, offSet, 5);
				offSet += 5;
			}
		}

		return data;
	}
	
	/**
	 * 补位运算ComplementOperation  不足多少位  在前面补0
	 */
	public static void main(String[] args) {
		int i=100000000;
		String s = String.format("%06d", i);
		System.out.println(s);//000001
	}
}
