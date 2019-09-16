package cn.wtu.broadcast.openapi.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.parent.vo.IpVO;
import io.netty.channel.ChannelHandlerContext;

public class SendIPUtils {

	public static Logger logger = LoggerFactory.getLogger(SendIPUtils.class);

	public static ConcurrentHashMap<String, ChannelHandlerContext> ctxMap = new ConcurrentHashMap<String, ChannelHandlerContext>();

	public static ConcurrentHashMap<String, String> answerMap = new ConcurrentHashMap<String, String>();

	public static ConcurrentHashMap<String, IpVO> sendIpVOMap = new ConcurrentHashMap<String, IpVO>();

	public static ConcurrentHashMap<String, String> deviceStateMap = new ConcurrentHashMap<String, String>();

	/**
	 * 会话标志
	 */
	private static int talkTagTo = 1;

	/**
	 * 字符串补0操作
	 * 
	 * @param str
	 * @param strLength
	 * @return
	 */
	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);// 左补0
				str = sb.toString();
				strLen = str.length();
			}
		} else if (strLen > strLength) {
			str = str.substring(0, 4);
		}

		return str;
	}

	/**
	 * 获取发送IP指令的会话标记，内存中递增，重启后重置
	 * 
	 * @return
	 */
	public static String getSendTalkTag() {
		String talkTag = new DecimalFormat("00000000").format(talkTagTo);
		talkTagTo++;
		return talkTag;
	}

	public static String intToHex(int n) {
		StringBuffer s = new StringBuffer();
		String a;
		char[] b = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (n != 0) {
			s = s.append(b[n % 16]);
			n = n / 16;
		}
		a = s.reverse().toString();
		return a;
	}

	public static String ipToLong(String ipString) {
		String[] ip = ipString.split("\\.");
		StringBuffer sb = new StringBuffer();
		for (String str : ip) {
			sb.append(addZeroForNum(Integer.toHexString(Integer.parseInt(str)), 2));
		}
		return sb.toString();
	}

	public static int getRealValue(char c) {
		int n = 0;
		if (c >= 'a' && c <= 'f')
			n = c - 'a' + 10;
		if (c >= 'A' && c <= 'F')
			n = c - 'A' + 10;
		if (c >= '0' && c <= '9')
			n = c - '0';
		return n;
	}

	public static int hexToTen(String s) {
		int m = 0;
		for (int i = 0; i < s.length(); i++) {
			m = 16 * m + getRealValue(s.charAt(i));
		}
		return m;
	}

	/*	*//**
			 * 停播处理
			 * 
			 * @param ipVO
			 *//*
			 * private static void ipStopBroadcast(IpVO ipVO, String answer) {
			 * // 停播 if (SendIPUtils.ctxMap.size() > 0) { for (String
			 * resourceCode : SendIPUtils.ctxMap.keySet()) { if
			 * (SendIPUtils.isCanSend(resourceCode, ipVO.getResourceCodeList()))
			 * { SendIPUtils.stopIPControl(SendIPUtils.ctxMap.get(resourceCode).
			 * channel(), SendIPUtils.answerMap.get(resourceCode), ipVO); } } }
			 * }
			 */

	/**
	 * 判断该设备是否是播放区域内的(播放区域去掉尾部0，然后和设备资源编码匹配)
	 * 
	 * @param resourceCode
	 *            县适配器资源编码
	 * @param resourceCodeList
	 *            播发区域
	 * @return
	 */
	public static boolean isCanSend(String resourceCode, List<String> resourceCodeList) {
		if (resourceCodeList != null && resourceCodeList.size() > 0) {
			for (String code : resourceCodeList) {
				try {
					// 删除字符串尾部的0  1-13
					// 停播 64107040000000314010400 64107040000000314010202           410704000000   410704800000
					String areaCode = resourceCode.substring(1, 13);
					String newAdapterAreaCode = removeTailZero(areaCode);		
					
					String newResourceCode = code.substring(1, newAdapterAreaCode.length()+1);
					if (newAdapterAreaCode.equals(newResourceCode)) {
						return true;
					}
				} catch (Exception e) {
					logger.error(e.getMessage() + e);
				}
			}
		}

		return false;
	}

	/**
	 * 删除字符串尾部的0
	 * 
	 * @param str
	 * @return
	 */
	private static String removeTailZero(String str) {
		// 如果字符串尾部不为0，返回字符串
		if (!str.substring(str.length() - 1).equals("0")) {
			return str;
		} else {
			// 否则将字符串尾部删除一位再进行递归
			return removeTailZero(str.substring(0, str.length() - 1));
		}
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
	public static String stringToUnicode(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			if (ch > 255)
				str += Integer.toHexString(ch);
			else
				str +=  Integer.toHexString(ch);
		}
		return str;
	}

	public static String asciiToString(String value)  {
		ArrayList<String> chars = new ArrayList<String> ();
		for(int i=0;i<value.length()/2;i++){
			chars.add(""+Integer.parseInt(value.substring(i*2, (i+1)*2),16));
		}
	    StringBuffer sbu = new StringBuffer();  
	    for (int i = 0; i < chars.size(); i++) {  
	        sbu.append((char) Integer.parseInt(chars.get(i)));  
	    }  
	    return sbu.toString();  
	}  
}
