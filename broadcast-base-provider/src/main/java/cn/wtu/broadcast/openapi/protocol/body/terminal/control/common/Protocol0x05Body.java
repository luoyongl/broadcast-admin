package cn.wtu.broadcast.openapi.protocol.body.terminal.control.common;

import java.util.ArrayList;
import java.util.List;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急广播大喇叭终端通用指令----通用资源编码设置（0x05）
 * @author Lenovo
 *
 */
public class Protocol0x05Body extends ProtocolBodyCommonInfo {

	public Protocol0x05Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x05Body;
	}

	// 循环数量 8bit
	byte logic_address_number;
	// 逻辑地址内容集合
	public List<LogicAddress> logicAddressInfo = new ArrayList<LogicAddress>();

	public static class LogicAddress {
		// 物理码长度，字节计数8bit
		byte physical_address_length;
		// 物理地址(bcd) Nbit
		byte[] physical_address;
		// 资源编码长度8bit，当前默认取值为12。
		byte logic_address_length = 12;
		// 资源编码(bcd编码，前四位是保留位，取值为“1111”) Nbit
		byte[] logic_address;

		public LogicAddress(String PhysicalAddress, String LogicAddress) {
			physical_address = SendProtocolTools.hexStringToBytes(PhysicalAddress);
			physical_address_length = (byte) physical_address.length;

			if (LogicAddress.length() == 23) {// 国标23字符，前4位填充‘F’
				LogicAddress = "F" + LogicAddress;
			}
			logic_address = SendProtocolTools.strToHexBytes(LogicAddress);
		}

		public int getSize() {
			int len = 1 + 1;

			if (physical_address != null) {
				len += physical_address_length;
			}

			if (logic_address != null) {
				len += logic_address_length;
			}

			return len;
		}

		public byte[] convertToBytes() {
			byte[] data = new byte[getSize()];
			int offSet = 0;

			data[offSet++] = physical_address_length;

			if (physical_address != null) {
				System.arraycopy(physical_address, 0, data, offSet, physical_address_length);
				offSet += physical_address_length;
			}

			data[offSet++] = logic_address_length;

			if (logic_address != null) {
				System.arraycopy(logic_address, 0, data, offSet, logic_address_length);
				offSet += logic_address_length;
			}

			return data;
		}
	}

	public int getSize() {
		primary_cmd_len = 1;

		if (logicAddressInfo != null) {
			logic_address_number = (byte) logicAddressInfo.size();

			for (LogicAddress logicAddress : logicAddressInfo) {
				primary_cmd_len += logicAddress.getSize();
			}
		}

		return primary_cmd_len;
	}

	public byte[] convertToBytes() {
		byte[] data = new byte[getSize()];
		int offSet = 0;

		data[offSet++] = logic_address_number;

		if (logicAddressInfo != null) {
			for (LogicAddress logicAddress : logicAddressInfo) {
				System.arraycopy(logicAddress.convertToBytes(), 0, data, offSet, logicAddress.getSize());
				offSet += logicAddress.getSize();
			}
		}

		return data;
	}

}
