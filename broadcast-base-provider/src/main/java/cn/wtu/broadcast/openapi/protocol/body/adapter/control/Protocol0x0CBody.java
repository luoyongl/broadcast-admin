package cn.wtu.broadcast.openapi.protocol.body.adapter.control;

import java.util.ArrayList;
import java.util.List;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急大喇叭适配器控制指令----白名单更新(0x0C)
 * 
 * @author Lenovo
 *
 */
public class Protocol0x0CBody extends ProtocolBodyCommonInfo {

	public Protocol0x0CBody() {
		protocol_type = ProtocolTypeEnum.Protocol0x0CBody;
	}

	// 名单总数 8bit
	byte white_list_length;
	// 白名单内容集合
	public List<WhiteList> whiteListInfos = new ArrayList<WhiteList>();

	public static class WhiteList {
		// 操纵类型 8bit 1：增加 2：修改 3：删除
		public byte oper_type;
		// 8bit
		byte phone_number_length;
		// ASCII码
		public byte[] phone_number;
		// 姓名长度 8bit
		byte user_name_length;
		// UTF-8编码
		public byte[] user_name;
		// 许可类型8bit 1:代表短信;2:代表电话;3代表短信和电话
		public byte permission_type = 3;
		// 授权区域码个数 8bit
		byte permission_area_number;
		// 一个授权区域码的长度 8bit
		byte permission_area_length;
		// 授权区域码（BCD编码） Nbit
		public List<byte[]> permission_area_codes = new ArrayList<byte[]>();

		public WhiteList(byte oper_type, byte[] phone_number, byte[] user_name, byte permission_type) {
			this.oper_type = oper_type;
			this.phone_number = phone_number;
			this.user_name = user_name;
			this.permission_type = permission_type;
		}

		/**
		 * 设置授权区域码
		 * 
		 * @param resourceCodeList
		 */
		public void setPermissionAreaCodes(List<String> permissionAreaCodeList) {
			permission_area_number = (byte) permissionAreaCodeList.size();
			for (String s : permissionAreaCodeList) {
				byte[] data = SendProtocolTools.StrToBCDBytes(s);
				permission_area_codes.add(data);
			}
		}

		public int getSize() {
			int len = 1 + 1 + 1 + 1 + 1 + 1;

			if (phone_number != null) {
				phone_number_length = (byte) phone_number.length;
				len += phone_number_length;
			}

			if (user_name != null) {
				user_name_length = (byte) user_name.length;
				len += user_name_length;
			}

			if (permission_area_codes != null) {
				permission_area_length = (byte) permission_area_codes.get(0).length;
				permission_area_number = (byte) permission_area_codes.size();
				len += permission_area_number * permission_area_length;
			}
			return len;
		}

		public byte[] convertToBytes() {
			int offSet = 0;
			byte[] data = new byte[getSize()];

			data[offSet++] = (byte) oper_type;
			data[offSet++] = (byte) phone_number_length;

			if (phone_number != null) {
				System.arraycopy(phone_number, 0, data, offSet, phone_number.length);
				offSet += phone_number_length;
			}

			data[offSet++] = (byte) user_name_length;

			if (user_name != null) {
				System.arraycopy(user_name, 0, data, offSet, user_name.length);
				offSet += user_name_length;
			}

			data[offSet++] = (byte) permission_type;
			data[offSet++] = (byte) permission_area_number;
			data[offSet++] = (byte) permission_area_length;

			if (permission_area_codes != null) {
				for (byte[] permission_area : permission_area_codes) {
					System.arraycopy(permission_area, 0, data, offSet, permission_area.length);
					offSet += permission_area.length;
				}
			}
			return data;
		}

	}

	public int getSize() {
		primary_cmd_len = 1;
		if (whiteListInfos != null) {
			white_list_length = (byte) whiteListInfos.size();
			for (WhiteList whiteList : whiteListInfos) {
				primary_cmd_len += whiteList.getSize();
			}
		}
		return primary_cmd_len;
	}

	public byte[] converToBytes() {
		byte[] data = new byte[getSize()];
		int offSet = 0;

		data[offSet++] = white_list_length;

		if (whiteListInfos != null) {
			for (WhiteList whiteList : whiteListInfos) {
				System.arraycopy(whiteList.convertToBytes(), 0, data, offSet, whiteList.getSize());
				offSet += whiteList.getSize();
			}
		}

		return data;
	}
}
