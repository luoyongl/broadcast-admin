package cn.wtu.broadcast.util;

public class TypeChangeUtil {
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
		buffer[index + 0] = v0;
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
		if (val == null) {
			return "";
		}
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
		if (Source == null) {
			return "";
		}

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

}
