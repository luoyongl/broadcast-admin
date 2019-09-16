package cn.wtu.broadcast.openapi.util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

/*
 *  UDP协议的发送端实现步骤:
 *    1. 创建DatagramPacket对象,封装数据, 接收的地址和端口
 *    2. 创建DatagramSocket
 *    3. 调用DatagramSocket类方法send,发送数据包
 *    4. 关闭资源
 *      
 */
public class UDPUtil {

	/**
	 * PID计数0-15循环
	 */
	private static final HashMap<String, HashMap<Short, Byte>> pidContinuerMap = new HashMap<String, HashMap<Short, Byte>>();

	public static void udpSend(byte[] data, int length, String ip, int port) throws IOException, InterruptedException {
		// 创建InetAdress对象，封装自己的IP地址
		String currSendDest = ip.replace(".", "") + String.valueOf(port);
		HashMap<Short, Byte> currPidContinuerMap = null;
		if (pidContinuerMap.containsKey(currSendDest)) {
			currPidContinuerMap = pidContinuerMap.get(currSendDest);
		} else {
			currPidContinuerMap = new HashMap<Short, Byte>();
			pidContinuerMap.put(currSendDest, currPidContinuerMap);
		}
		InetAddress inet = InetAddress.getByName(ip);
		DatagramSocket ds = new DatagramSocket();
		byte[] buf = null;
		int offSet = 0;
		int bufLen = 188 * 1;
		byte continueValue = 0;
		while (offSet < data.length) {
			if ((data.length - offSet) > bufLen) {
				buf = new byte[bufLen];
			} else {
				buf = new byte[data.length - offSet];
				bufLen = buf.length;
			}
			System.arraycopy(data, offSet, buf, 0, bufLen);
			for (int i = 0; i < bufLen; i += 188) {
				Short pid = (short) (((buf[1 + i] & 0x1f) << 8) | buf[2 + i]);
				if (currPidContinuerMap.containsKey(pid)) {
					continueValue = currPidContinuerMap.get(pid);
					continueValue++;
					continueValue = (byte) (continueValue & 0x0f);
					buf[3 + i] = (byte) ((buf[3 + i] & 0xf0) | continueValue);
					currPidContinuerMap.replace(pid, continueValue);
				} else {
					continueValue = 0;
					buf[3 + i] = (byte) ((buf[3 + i] & 0xf0));
					currPidContinuerMap.put(pid, continueValue);
				}
			}

			offSet += bufLen;
			// 创建DatagramSocket对象，数据包的发送和接收对象
			DatagramPacket dp = new DatagramPacket(buf, bufLen, inet, port);
			// 调用ds对象的方法send，发送数据包
			ds.send(dp);
			Thread.sleep(1);
		}
		// 关闭资源
		ds.close();
	}

	public static String udpReceive(int port) throws IOException {
		// 创建数据包传输对象DatagramSocket绑定端口号
		DatagramSocket ds = new DatagramSocket(port);
		// 创建字节数据
		byte[] data = new byte[1024];
		// 创建数据包对象，传递字节数组
		DatagramPacket dp = new DatagramPacket(data, data.length);
		// 调用ds对象的方法receive传递数据包
		ds.receive(dp);
		// 获取接收到的字节个数
		// int length = dp.getLength();
		// String receiveDate = new String(data, 0, length);
		ds.close();
		return byteToHex(data);
	}

	/**
	 * byte数组转hex
	 * 
	 * @param bytes
	 * @return
	 */
	public static String byteToHex(byte[] bytes) {
		String strHex = "";
		StringBuilder sb = new StringBuilder("");
		for (int n = 0; n < bytes.length; n++) {
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

	/**
	 * 计算CRC16校验码
	 *
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

	public static String str2HexStr(String str) {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
		}
		return sb.toString().trim();
	}

	public static String stringToAscii(String value) {
		byte[] b = value.getBytes();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

}
