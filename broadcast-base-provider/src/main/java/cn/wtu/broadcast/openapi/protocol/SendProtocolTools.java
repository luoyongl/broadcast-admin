/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.misc.BASE64Decoder;

/**
 * 封装指令工具类
 * 
 * @author Lenovo
 *
 */
@SuppressWarnings("restriction")
public class SendProtocolTools {

	/**
	 * 用于将 用户名转换为utf-8编码格式的byte[] 小李子--FEFF5C0F674E5B50--5C0F674E5B50 TODO
	 * 如果名字是英文字母 xiao--0078 0069 0061 006F 该怎么处理
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] string2Unicode(String str) throws UnsupportedEncodingException {
		byte[] bys = str.getBytes("unicode");

		byte[] data = new byte[bys.length - 2];
		System.arraycopy(bys, 2, data, 0, bys.length - 2);

		return data;
	}

	/**
	 * 专用于 证书下发解析List
	 * 
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static String Base64ToHex(String str) throws IOException {
		return byteToHex(new BASE64Decoder().decodeBuffer(str), null);
	}

	/**
	 * "1,2,3,4,5,6,7" 转byte[]
	 * 
	 * @param queryCodes
	 * @return
	 */
	public static byte[] stringToBytes(String queryCodes) {

		String[] strings = queryCodes.split(",");

		int offset = 0;
		byte[] data = new byte[strings.length];

		if (strings.length >= 1) {
			for (String str : strings) {
				data[offset++] = (byte) Integer.parseInt(str);
			}
		}

		return data;

	}

	/**
	 * String ip = "192.168.3.143"; 4byte int port = 10086; 2byte
	 * 
	 * @param ip
	 * @return
	 */
	public static byte[] ipAndPortToBytes(String ip, int port) {

		byte[] data = new byte[6];
		int offSet = 0;

		byte[] ipBytes = SendProtocolTools.ipToBytes(ip);

		int aa = 0;
		byte[] portBytes = new byte[2];
		portBytes[aa++] = (byte) (port >> 8);
		portBytes[aa++] = (byte) (port & 0xff);

		System.arraycopy(ipBytes, 0, data, offSet, 4);
		offSet += 4;

		System.arraycopy(portBytes, 0, data, offSet, 2);

		return data;
	}

	/**
	 * String ip = "192.168.3.143";
	 * 
	 * @param ip
	 * @return
	 */
	public static byte[] ipToBytes(String ip) {
		int offset = 0;
		byte[] data = new byte[4];
		// 这里的.需要转义一下 \\. 否则为[]
		// String[] ipArr = ip.split(".");
		String[] ipArr = ip.split("\\.");
		for (String strIp : ipArr) {
			// 转换失败 最高位符号位 范围 [-128,127] 255
			data[offset++] = (byte) Integer.parseInt(strIp);
		}
		return data;

	}

	/**
	 * Date转32bit=8Hex UTC时间
	 * 
	 * @param date
	 * @return
	 */
	public static byte[] date2Bytes(Date date) {
		int time = (int) (date.getTime() / 1000);
		byte[] bytes = new byte[4];
		for (int i = bytes.length - 1; i >= 0; i--) {
			bytes[i] = (byte) (time & 0xFF);
			time = (int) (time >> 8);
		}
		return bytes;
	}

	/**
	 * Calendar转32bit=8Hex UTC时间
	 * 
	 * @param date
	 * @return
	 */
	public static byte[] calendar2Bytes(Calendar calendar) {
		int time = (int) (calendar.getTimeInMillis() / 1000);
		byte[] bytes = new byte[4];
		for (int i = bytes.length - 1; i >= 0; i--) {
			bytes[i] = (byte) (time & 0xFF);
			time = (int) (time >> 8);
		}
		return bytes;
	}

	/**
	 * CRC32
	 * 
	 * @param data
	 * @param StartIndex
	 * @param length
	 * @return
	 */
	public static int crc_Calculate(byte[] data, int StartIndex, int length) {
		int[] ptiTable = new int[256];
		int nData = 0, CRCPloy = 0x04C11DB7;
		int nAccum = 0;

		for (int i = 0; i < 256; i++) {
			nData = i << 24;
			nAccum = 0;
			for (int j = 0; j < 8; j++) {
				if (0 != ((nData ^ nAccum) & 0x80000000)) {
					nAccum = (nAccum << 1) ^ CRCPloy;
				} else {
					nAccum <<= 1;
				}
				nData <<= 1;
			}
			ptiTable[i] = nAccum;
		}
		int crc32 = 0xFFFFFFFF;
		int byteCount = 0;
		while (byteCount < length) {
			crc32 = (crc32 << 8) ^ ptiTable[(crc32 >>> 24) ^ (data[StartIndex + byteCount] & 0xFF)];
			byteCount++;
		}

		return crc32;

	}

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}

		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	public static byte charToByte(char c) {
		return (byte) "0123456789AHexEF".indexOf(c);
	}

	/**
	 * 16进制字符串转Hex码 F06121111111111111111111 特别注意
	 * :逻辑编码是23位BCD码(没有A-F),但由于前缀Fs,所以转成Hex; 如果逻辑码本身就包含A-F(可能？)
	 * 
	 * @param asc
	 * @return
	 */
	public static byte[] strToHexBytes(String asc) {
		int len = asc.length();
		int mod = len % 2;
		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}
		byte[] abt = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}
		byte[] bbt = new byte[len];
		abt = asc.getBytes();
		int j, k;
		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}
			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}
			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}

	public static void main(String[] args) {
		System.out.println(byteToHex(strToHexBytes("F06121111111111111111111"), null));// F06121111111111111111111
		System.out.println(byteToHex(StrToBCDBytes("F06121111111111111111111"), null));// 606121111111111111111111

		// RDS 频率 SendProtocolTools.StrToBCDBytes(String.format("%06d",
		// frequency))
		System.out.println(byteToHex(StrToBCDBytes(String.format("%06d", 8000)), null));// 80M
																						// 008000
		System.out.println(byteToHex(StrToBCDBytes(String.format("%06d", 8020)), null));// 80.2M
																						// 008020

		System.out.println(byteToHex(strToHexBytes(String.format("%06d", 8000)), null));// 80M
																						// 008000
		System.out.println(byteToHex(strToHexBytes(String.format("%06d", 8020)), null));// 80.2M
																						// 008020
	}

	/**
	 * RDS扫描频点信息 频率
	 * 
	 * @param s
	 * @return
	 */
	public static byte[] StrToBCDBytes(String s) {

		if (s.length() % 2 != 0) {
			s = "0" + s;
		}
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i += 2) {
			int high = cs[i] - 48;
			int low = cs[i + 1] - 48;
			bs.write(high << 4 | low);
		}

		byte[] data = bs.toByteArray();
		try {
			bs.close();
		} catch (Exception ex) {
		}
		return data;
	}

	/**
	 * 字节数组转换为十六进制字符串
	 * 
	 * @param b
	 *            byte[] 需要转换的字节数组
	 * @return String 十六进制字符串
	 */
	public static String byteToHex(byte b[], Integer length) {
		if (b == null) {
			throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
		}
		String hs = "";
		String stmp = "";
		if (length == null) {
			length = b.length;
		}
		for (int n = 0; n < length; n++) {
			stmp = Integer.toHexString(b[n] & 0xff);
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	public static String byteToHex2(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		return ret;
	}

	/**
	 * 16进制字符串转换为byte[]
	 * 
	 * @param hex
	 * @return
	 */
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static int toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	/**
	 * Hex码转10进制 Math.pow(m,n)，代表m的n次方 非日期Hex转十进制
	 * 
	 * @param Hex
	 * @return int
	 */
	public static int hextoDec(String Hex) {
		int i, num, tmp, dec = 0;
		for (i = 0; i < Hex.length(); i++) {
			String str = Hex.substring(i, i + 1);

			switch (str) {
			case "A":
			case "a":
				num = 10;
				break;
			case "B":
			case "b":
				num = 11;
				break;
			case "C":
			case "c":
				num = 12;
				break;
			case "D":
			case "d":
				num = 13;
				break;
			case "E":
			case "e":
				num = 14;
				break;
			case "F":
			case "f":
				num = 15;
				break;
			default:
				num = Integer.parseInt(str);
			}

			tmp = (int) (num * Math.pow(16, Hex.length() - i - 1));
			dec += tmp;
		}
		return dec;
	}

	/**
	 * Hex码转10进制 Math.pow(m,n)，代表m的n次方 日期Hex先转十进制 的时间戳desc,然后 desc*1000
	 * 转为时间的String格式
	 * 
	 * @param Hex
	 * @return String
	 */
	public static String HexDatetoDec(String Hex) {
		int i, num;
		long tmp, dec = 0;
		for (i = 0; i < Hex.length(); i++) {
			String str = Hex.substring(i, i + 1);

			switch (str) {
			case "A":
			case "a":
				num = 10;
				break;
			case "B":
			case "b":
				num = 11;
				break;
			case "C":
			case "c":
				num = 12;
				break;
			case "D":
			case "d":
				num = 13;
				break;
			case "E":
			case "e":
				num = 14;
				break;
			case "F":
			case "f":
				num = 15;
				break;
			default:
				num = Integer.parseInt(str);
			}

			tmp = (long) (num * Math.pow(16, Hex.length() - i - 1));
			dec += tmp;
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(dec * 1000);

		return simpleDateFormat.format(date);
	}
}
