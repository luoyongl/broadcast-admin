package cn.wtu.broadcast.openapi.protocol.signature;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.bouncycastle.math.ec.ECPoint;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.signature.SM2.SM2Result;

/**
 * 数字签名
 * 
 * @author lxg
 * @since 2019-06-07
 */
public class SignatureData {

	// 16bit，用于指示数字签名时间、签名证书编号、数字签名的总长度。
	short signature_length;
	// 数字签名UTC时间 32bit
	byte[] signatureTime;
	// 证书编号48bit = 6byte
	// 签名验证需要使用的发送源数字证书编号，全国范围内采用统一的唯一编号，证书编号48比特，采用BCD码表示的12个数字。
	public byte[] certificate_sn;
	// 数字签名数据[签名结果] 512bit= 64byte 包含应急广播数据包中消息头和消息体的数字签名信息
	public byte[] signatureData;

	// 非封装字段 待签名的指令数据
	byte[] waittingSignData;

	// 非封装字段 用户id 16byte 验签用
	private byte[] userID = new byte[] { 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x31, 0x32, 0x33, 0x34, 0x35,
			0x36, 0x37, 0x38 };

	/**
	 * 签名时UTCTimeFlag true 待签名的数据 [消息头+消息体+UTC时间] false [消息头+消息体]
	 */
	public boolean UTCTimeFlag;

	public SignatureData(byte certificateNumber, boolean UTCTimeFlag) {
		privateKeyList.add("3945208F7B2144B13F36E38AC6D39F95889393692860B51A42FB81EF4DF7C5B8");// 0
		privateKeyList.add("2FB22AEDD02205AF5B8F4171DC1DCBB5A4643D2BF0034CF7D0283CCAE193EF508");// 1
		privateKeyList.add("541BE382D94D67F0FA634AAD0573980793C4656D540169DA337912B9373F9AA6");// 2
		privateKeyList.add("0EFA71C7C20D44DFBEA61BC94AAA82CD0D5369EF9E74CB6B06D31883F5F9789D");// 3
		privateKeyList.add("EA752CDDB416947F081A842F191CB618BB25CB65A56FD3FF0ABDACFA906E4282");// ?
		// TODO 页面输入 证书编号给我就行
		this.certificate_sn = new byte[] { 0, 0, 0, 0, 0, certificateNumber };

		this.UTCTimeFlag = UTCTimeFlag;
	}

	// TODO 非封装字段,用户指定平台私钥后,与之匹配，然后确定证书编号
	List<String> privateKeyList = new ArrayList<String>();

	/**
	 * 获取待签名的指令数据
	 * 
	 * @param data
	 */
	public void setWaittingSignatureData(byte[] data) {
		waittingSignData = data;
	}

	public int getSize() {
		int len = 2;
		signature_length = 4 + 6 + 64;
		len += signature_length;

		return len;
	}

	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];

		// 获取签名后的结果
		BigInteger aa = new BigInteger(certificate_sn);
		signatureData = getSignData(aa.intValue());

		// signatureTime 32bit设置签名时间UTC
		if (signatureTime == null || signatureTime.length == 0) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
			signatureTime = calendar2Bytes(calendar);
		}

		// signature_length 16bit
		data[offSet++] = (byte) (signature_length >> 8);
		data[offSet++] = (byte) (signature_length & 0xff);

		// 封装signatureTime
		System.arraycopy(signatureTime, 0, data, offSet, 4);
		offSet += 4;

		System.arraycopy(certificate_sn, 0, data, offSet, certificate_sn.length);
		offSet += certificate_sn.length;

		System.arraycopy(signatureData, 0, data, offSet, signatureData.length);

		return data;
	}

	public byte[] getSignData(int certificate_sn) {
		SM2 sm2 = SM2.Instance();
		
		// 验签时waittingSignData代表广播消息头和消息体的指令数据
		byte[] buf = null;

		if (UTCTimeFlag) {
			byte[] UTCtime = SendProtocolTools.date2Bytes(new Date());

			buf = new byte[waittingSignData.length + 4];
			System.arraycopy(waittingSignData, 0, buf, 0, waittingSignData.length);
			System.arraycopy(UTCtime, 0, buf, waittingSignData.length, 4);
		} else {
			System.arraycopy(waittingSignData, 0, buf, 0, waittingSignData.length);
		}

		byte[] sm3 = calcSM3(buf, userID, privateKeyList.get(certificate_sn));
		BigInteger pri = new BigInteger(privateKeyList.get(certificate_sn), 16);
		SM2Result sm2Ret = new SM2Result();
		sm2.Sm2Sign(sm3, pri, sm2Ret, false);
		byte[] data = new byte[64];
		System.arraycopy(Util.toByteArrayUnsigned(sm2Ret.r), 0, data, 0, 32);
		System.arraycopy(Util.toByteArrayUnsigned(sm2Ret.s), 0, data, 32, 32);
		return data;
	}

	private byte[] calendar2Bytes(Calendar calendar) {
		int time = (int) (calendar.getTimeInMillis() / 1000);
		byte[] bytes = new byte[4];
		for (int i = bytes.length - 1; i >= 0; i--) {
			bytes[i] = (byte) (time & 0xFF);
			time = (int) (time >> 8);
		}
		return bytes;
	}

	private byte[] calcSM3(byte[] srcData, byte[] userID, String privateKeyStr) {

		SM2 sm2 = SM2.Instance();
		byte[] z = sm2.Sm2GetZ(userID, GetPublicKey(sm2, privateKeyStr));

		byte[] data = new byte[z.length + srcData.length];
		System.arraycopy(z, 0, data, 0, z.length);
		System.arraycopy(srcData, 0, data, z.length, srcData.length);

		SM3Digest sm3 = new SM3Digest();
		sm3.update(data, 0, data.length);
		byte[] md_sm3 = new byte[32];
		sm3.doFinal(md_sm3, 0);
		return md_sm3;
	}

	private ECPoint GetPublicKey(SM2 sm2, String privateKeyStr) {
		BigInteger test_d_copy = new BigInteger(privateKeyStr, 16);

		ECPoint pub = sm2.ecc_point_g.multiply(test_d_copy);

		String x = pub.getX().toBigInteger().toString(16).toUpperCase();
		String y = pub.getY().toBigInteger().toString(16).toUpperCase();
		return sm2.CreatePublicKey(x, y, 16);
	}

}
