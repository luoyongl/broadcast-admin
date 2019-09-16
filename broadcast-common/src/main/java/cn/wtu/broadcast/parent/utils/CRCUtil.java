package cn.wtu.broadcast.parent.utils;

public class CRCUtil {

	/**
	 * 计算CRC16校验码
	 * @param bytes
	 * @return
	 */
	public static String getCRC(byte[] bytes) {
		int CRC = 0x0000ffff;
		int POLYNOMIAL = 0x0000a001;

		int i, j;
		for (i = 0; i < bytes.length; i++) {
			CRC ^= ((int) bytes[i] & 0x000000ff);
			for (j = 0; j < 8; j++) {
				if ((CRC & 0x00000001) != 0) {
					CRC >>= 1;
					CRC ^= POLYNOMIAL;
				} else {
					CRC >>= 1;
				}
			}
		}
		String str = Integer.toHexString(CRC);
		return str.substring(2, 4) + str.substring(0, 2);
	}
	
	/**
	 * byte数组转hex
	 * 
	 * @param bytes
	 * @param dataLength
	 * @return
	 */
	public static String byteToHex(byte[] bytes, int dataLength) {
		String strHex = "";
		StringBuilder sb = new StringBuilder("");
		for (int n = 0; n < dataLength; n++) {
			strHex = Integer.toHexString(bytes[n] & 0xFF);
			sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
		}
		return sb.toString().trim();
	}

	/**
	 * hex转byte数组
	 * 
	 * @param hex
	 * @return
	 */
	public static byte[] hexToByte(String hex) {
		int m = 0, n = 0;
		int byteLen = hex.length() / 2; // 每两个字符描述一个字节
		byte[] ret = new byte[byteLen];
		for (int i = 0; i < byteLen; i++) {
			m = i * 2 + 1;
			n = m + 1;
			int intVal = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m, n));
			ret[i] = Byte.valueOf((byte) intVal);
		}
		return ret;
	}
	
}
