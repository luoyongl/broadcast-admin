/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.protocol;

import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;
import cn.wtu.broadcast.openapi.protocol.signature.ReplySignatureData;

/**
 * 解析回复指令工具类
 * 
 * @author Lenovo
 *
 */
public class ReplyProtocolTools {

	/**
	 * 设置消息头的所有数据
	 * 
	 * @param buffer
	 * @return
	 */
	public static void setProtocolHead(ProtocolReplyCommonData protocolReplyCommonData, byte[] buffer) {
		int index = 0;
		// 报头
		protocolReplyCommonData.setHead(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
		index += 1;
		// 协议版本号
		protocolReplyCommonData.setVersion(ReplyProtocolTools.getProtocolHex(buffer, index, 2));
		index += 2;
		// 协议类型
		protocolReplyCommonData
				.setProtocol_type(ProtocolTypeEnum.getEnumByCode(ReplyProtocolTools.getProtocolHex(buffer, index, 1)));
		index += 1;
		// 消息来源
		protocolReplyCommonData.setPlatform_type(ReplyProtocolTools.getProtocolHex(buffer, index, 1));
		index += 1;
		// 指令数据长度
		protocolReplyCommonData.setData_length(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
		index += 4;
	}

	/**
	 * 设置校验数据
	 * 
	 * @param buffer
	 * @return
	 */
	public static void setProtocolSignatureData(ProtocolReplyCommonData protocolReplyCommonData, int index,
			byte[] buffer) {
		// 校验数据
		ReplySignatureData replySignatureData = new ReplySignatureData();
		// 数字签名信息长度 : 用于指示数字签名时间、签名证书编号、数字签名的总长度
		replySignatureData.setSignature_length(ReplyProtocolTools.getProtocolHex(buffer, index, 2));
		int snsLength = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, index, 2), 16);
		index += 2;
		// 数字签名时间
		replySignatureData.setSignature_time(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
		index += 4;
		// 签名证书编号
		replySignatureData.setCertificate_sn(ReplyProtocolTools.getProtocolHex(buffer, index, 6));
		index += 6;
		// 数字签名 : 长度要减去签名证书编号、数字签名的长度
		replySignatureData.setSignature_data(ReplyProtocolTools.getProtocolHex(buffer, index, snsLength - 4 - 6));
		index += (snsLength - 4 - 6);
		// CRC32
		replySignatureData.setCrc32(ReplyProtocolTools.getProtocolHex(buffer, index, 4));
		index += 4;
		protocolReplyCommonData.setReplySignatureData(replySignatureData);
	}

	/**
	 * 获取回复值的协议类型
	 * 
	 * @param buffer
	 * @return
	 */
	public static String getProtocolType(byte[] buffer) {
		return ReplyProtocolTools.getProtocolHex(buffer, 3, 1);
	}

	/**
	 * 获取回复数字的长度（已经转换成了十进制的长度）
	 * 
	 * @param buffer
	 * @return
	 */
	public static Integer getProtocolLength(byte[] buffer) {
		// 消息头长度
		Integer headLength = Integer.valueOf(String.valueOf(1 + 2 + 1 + 1 + 4), 16);
		// 指令数据长度
		Integer bodyLength = Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, 5, 4), 16);
		// 数字签名信息长度（展示长度字段的长度） + 数字签名信息长度 + CRC32长度
		Integer signLength = Integer.valueOf(String.valueOf(2), 16)
				+ Integer.valueOf(ReplyProtocolTools.getProtocolHex(buffer, headLength + bodyLength, 2), 16)
				+ Integer.valueOf(String.valueOf(4), 16);
		return headLength + bodyLength + signLength;
	}

	/**
	 * 根据长度获取字节流中指定的数据
	 * 
	 * @param buffer
	 * @param index
	 * @param length
	 * @return
	 */
	public static String getProtocolHex(byte[] buffer, int index, int length) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int val = buf_to_u8(buffer, index);
			result.append(u8_to_string(val));
			index++;
		}

		return result.toString();
	}

	/**
	 * 16进制字符串转十进制int
	 * 
	 * @param HexString
	 * @return
	 */
	public static int hexStringToInt(String HexString) {
		int inJTFingerLockAddress = Integer.valueOf(HexString, 16);
		return inJTFingerLockAddress;
	}

	/**
	 * 待转化的总协议字节流转换成字符串
	 * 
	 * @param buffer 待转化的总协议字节流
	 * @param index
	 * @param length
	 * @return
	 */
	public static int buf_to_uN(byte[] buffer, int index, int length) {
		int[] bArray = new int[length];
		for (int i = 0; i < length; i++) {
			bArray[i] = (buffer[index + i]) & 0xff;
		}
		int result = 0;
		int k = 0;
		for (int j = bArray.length; j > 0; j--) {
			int bit = (j - 1) * 8;
			if (result == 0) {
				result = bArray[k];
			} else {
				result = result | (bArray[k] << bit);
			}
			k++;
		}
		return result;
	}

	/**
	 * 回传协议中转换成字符串
	 * 
	 * @param val 值
	 * @param length 字节长度
	 * @return
	 */
	public static String uN_to_string(int val, int length) {
		byte[] bArray = new byte[length];
		for (int i = 0; i < length; i++) {
			int bit = (length - i - 1) * 8;
			bArray[i] = (byte) ((val >> bit) & 0xff);
		}
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 从包头标记 开始 至 业务 数据内容 计算 CRC 32 校验 数据
	 * 
	 * @param ptr
	 * @param len
	 * @return
	 */
	public static int CRC32_MPEG2(byte ptr[], int len) {
		int crc = 0xFFFFFFFF;
		for (int j = 0; j < len; j++) {
			crc ^= (int) (ptr[j]) << 24;
			for (int i = 8; i > 0; --i) {
				if ((crc & 0x80000000) > 0)
					crc = (crc << 1) ^ 0x04C11DB7;
				else
					crc <<= 1;
			}
		}
		return crc;
	}

	public static int buf_to_u8(byte[] buffer, int index) {
		int v0 = (buffer[index + 0]) & 0xff;
		return v0;
	}

	public static int buf_to_u16(byte[] buffer, int index) {
		int v0 = (buffer[index + 0]) & 0xff;
		int v1 = (buffer[index + 1]) & 0xff;
		return (v0 << 8) | (v1);
	}

	public static int buf_to_u24(byte[] buffer, int index) {
		int v0 = (buffer[index + 0]) & 0xff;
		int v1 = (buffer[index + 1]) & 0xff;
		int v2 = (buffer[index + 2]) & 0xff;
		return (v0 << 16) | (v1 << 8) | (v2);
	}

	public static int buf_to_u32(byte[] buffer, int index) {
		int v0 = (buffer[index + 0]) & 0xff;
		int v1 = (buffer[index + 1]) & 0xff;
		int v2 = (buffer[index + 2]) & 0xff;
		int v3 = (buffer[index + 3]) & 0xff;
		return (v0 << 24) | (v1 << 16) | (v2 << 8) | (v3);
	}

	public static byte[] buf_to_bytes(byte[] buffer, int index, int len) {
		if (len > 0) {
			byte bArray[] = new byte[len];
			for (int i = 0; i < len; i++) {
				bArray[i] = buffer[index + i];
			}
			return bArray;
		} else {
			return null;
		}
	}

	public static byte[][] buf_to_bytes_bytes(byte[] buffer, int index, int number, int len) {
		if (number > 0) {
			byte bArray[][] = new byte[number][len];
			for (int j = 0; j < number; j++) {
				for (int i = 0; i < len; i++) {
					bArray[j][i] = buffer[index + j * len + i];
				}
			}
			return bArray;
		} else {
			return null;
		}
	}

	public static void u8_to_buf(int val, byte[] buffer, int index) {
		byte v0 = (byte) (val & 0xff);
		buffer[index + 0] = v0;// val;
	}

	public static void u16_to_buf(int val, byte[] buffer, int index) {
		byte v0 = (byte) ((val >> 8) & 0xff);
		byte v1 = (byte) ((val) & 0xff);
		buffer[index + 0] = v0;
		buffer[index + 1] = v1;
	}

	public static void u24_to_buf(int val, byte[] buffer, int index) {
		byte v0 = (byte) ((val >> 16) & 0xff);
		byte v1 = (byte) ((val >> 8) & 0xff);
		byte v2 = (byte) ((val) & 0xff);
		buffer[index + 0] = v0;
		buffer[index + 1] = v1;
		buffer[index + 2] = v2;
	}

	public static void u32_to_buf(int val, byte[] buffer, int index) {
		byte v0 = (byte) ((val >> 24) & 0xff);
		byte v1 = (byte) ((val >> 16) & 0xff);
		byte v2 = (byte) ((val >> 8) & 0xff);
		byte v3 = (byte) ((val) & 0xff);
		buffer[index + 0] = v0;
		buffer[index + 1] = v1;
		buffer[index + 2] = v2;
		buffer[index + 3] = v3;
	}

	public static void bytes_to_buf(byte[] val, int len, byte[] buffer, int index) {
		for (int i = 0; i < len; i++) {
			buffer[index + i] = val[i];
		}
	}

	public static String u8_to_string(int val) {
		byte v0 = (byte) (val & 0xff);
		byte[] bArray = new byte[1];
		bArray[0] = v0;
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static String u16_to_string(int val) {
		byte v0 = (byte) ((val >> 8) & 0xff);
		byte v1 = (byte) ((val) & 0xff);
		byte[] bArray = new byte[2];
		bArray[0] = v0;
		bArray[1] = v1;
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static String u24_to_string(int val) {
		byte v0 = (byte) ((val >> 16) & 0xff);
		byte v1 = (byte) ((val >> 8) & 0xff);
		byte v2 = (byte) ((val) & 0xff);
		byte[] bArray = new byte[3];
		bArray[0] = v0;
		bArray[1] = v1;
		bArray[2] = v2;
		//
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static String u32_to_string(int val) {
		byte v0 = (byte) ((val >> 24) & 0xff);
		byte v1 = (byte) ((val >> 16) & 0xff);
		byte v2 = (byte) ((val >> 8) & 0xff);
		byte v3 = (byte) ((val) & 0xff);
		byte[] bArray = new byte[4];
		bArray[0] = v0;
		bArray[1] = v1;
		bArray[2] = v2;
		bArray[3] = v3;
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static String bytes_to_string(byte[] val) {
		if (val == null)
			return "";
		StringBuffer sb = new StringBuffer(val.length);
		String sTemp;
		for (int i = 0; i < val.length; i++) {
			sTemp = Integer.toHexString(0xFF & val[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static String source_to_string(byte[] Source) {
		if (Source == null)
			return "";
		StringBuffer sb = new StringBuffer(Source.length);
		String sTemp;
		for (int i = 0; i < Source.length; i++) {
			if (i == 0) {
				sTemp = Integer.toHexString(0xF & Source[i]);
			} else {
				sTemp = Integer.toHexString(0xFF & Source[i]);
				if (sTemp.length() < 2)
					sb.append(0);
			}
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * Byte[]转换成byte[]
	 * 
	 * @param oBytes
	 * @return
	 */
	public static byte[] toPrimitives(Byte[] oBytes) {
		byte[] bytes = new byte[oBytes.length];
		for (int i = 0; i < oBytes.length; i++) {
			bytes[i] = oBytes[i];
		}
		return bytes;
	}

	/**
	 * byte[]转换成Byte[]
	 * 
	 * @param bytesPrim
	 * @return
	 */
	public static Byte[] toObjects(byte[] bytesPrim) {
		Byte[] bytes = new Byte[bytesPrim.length];
		int i = 0;
		for (byte b : bytesPrim) {
			bytes[i++] = b;
		}
		return bytes;
	}

}
