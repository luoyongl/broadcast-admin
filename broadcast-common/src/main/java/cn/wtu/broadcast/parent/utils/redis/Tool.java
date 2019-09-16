package cn.wtu.broadcast.parent.utils.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tool {
	private final static Logger logger = LoggerFactory.getLogger(Tool.class);
	private static Cipher encryptCipher = null;
	private static Cipher decryptCipher = null;

	static {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			String strDefaultKey = "sueua";
			Key key = getKey(strDefaultKey.getBytes());
			encryptCipher = Cipher.getInstance("DES");
			encryptCipher.init(Cipher.ENCRYPT_MODE, key);
			decryptCipher = Cipher.getInstance("DES");
			decryptCipher.init(Cipher.DECRYPT_MODE, key);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
	}

	private Tool() {

	}

	/**
	 * 对象转字节数组
	 *
	 * @since 1.7
	 */
	public static byte[] ObjectToByte(Object obj) {
		byte[] bytes = null;
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			bytes = bo.toByteArray();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return bytes;
	}

	/**
	 * 字节数组转对象
	 *
	 * @since 1.7
	 */
	@SuppressWarnings("unchecked")
	public static <T> T ByteToObject(byte[] bytes, Class<T> clazz) {
		T t = null;
		try {
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream oi = new ObjectInputStream(bi);
			t = (T) oi.readObject();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return t;
	}

	/**
	 * 加密字符串
	 *
	 * @param strIn 需加密的字符串
	 * @return 加密后的字符串
	 * @throws Exception 异常
	 */
	public static String encrypt(String strIn) throws Exception {
		byte[] bytes = encryptCipher.doFinal(strIn.getBytes());
		int iLen = bytes.length;
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (byte aByte : bytes) {
			int intTmp = aByte;
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * 解密字符串
	 *
	 * @param strIn 需解密的字符串
	 * @return 解密后的字符串
	 * @throws Exception
	 */
	public static String decrypt(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return new String(decryptCipher.doFinal(arrOut));
	}

	/**
	 * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
	 *
	 * @param arrBTmp 构成该字符串的字节数组
	 * @return 生成的密钥
	 */
	private static Key getKey(byte[] arrBTmp) {
		byte[] arrB = new byte[8];
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		return new javax.crypto.spec.SecretKeySpec(arrB, "DES");
	}

}
