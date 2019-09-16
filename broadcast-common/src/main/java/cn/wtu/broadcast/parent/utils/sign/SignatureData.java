/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.parent.utils.sign;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.bouncycastle.math.ec.ECPoint;

import cn.wtu.broadcast.parent.utils.sign.SM2;
import cn.wtu.broadcast.parent.utils.sign.SM2.SM2Result;
import cn.wtu.broadcast.parent.utils.sign.SM3Digest;
import cn.wtu.broadcast.parent.utils.sign.Util;

/**
 *
 * @author Administrator
 */
public class SignatureData {

	/**
	 * 32bits 8位hex 4字节
	 */
	public byte[] random;

	/**
	 * 48bits 12位hex 6字节
	 * 根证书编号  0  1  2  3  .get(0)
	 */
	public byte[] certificate_sn;

	/**
	 * 512bits 512/4=128位hex 64字节
	 */
	public byte[] signature;

	//31323334353637383132333435363738
	private byte[] userID = new byte[] { 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38 ,0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38 };

//	private byte[] userID = new byte[] { 0x12, 0x34, 0x56, 0x78, 0x12, 0x34, 0x56, 0x78 };

	/**
	 * 设置初始值
	 *
	 * @param data
	 * @return
	 */
	public void setUserID(byte[] data) {
		userID = data;
	}

	private byte[] srcData = null;

	public void setSrcData(byte[] data) {
		srcData = new byte[data.length];
		System.arraycopy(data, 0, srcData, 0, data.length);
	}

	public int getSize() {
		return 4 + 48 / 8 + 512 / 8;
	}

	private ArrayList<String> privateKeyList = new ArrayList<String>();

	/**
	 * lxg 2019-02-21
	 * 
	 * @param privateKey
	 */
	public SignatureData(List<String> privateKeys) {
		privateKeyList.addAll(privateKeys);
		//{ 0, 0, 0, 0, 0, 0 } 第六个为1 ,表示获取第二个证书
		certificate_sn = new byte[] { 0, 0, 0, 0, 0, 0 };
	}

	public SignatureData() {
		privateKeyList.add("2FB22AEDD02205AF5B8F4171DC1DCBB5A4643D2BF0034CF7D0283CCAE193EF50");// 0
		privateKeyList.add("541BE382D94D67F0FA634AAD0573980793C4656D540169DA337912B9373F9AA6");// 1
		privateKeyList.add("0EFA71C7C20D44DFBEA61BC94AAA82CD0D5369EF9E74CB6B06D31883F5F9789D");// 2
		privateKeyList.add("EA752CDDB416947F081A842F191CB618BB25CB65A56FD3FF0ABDACFA906E4282");// 3
		certificate_sn = new byte[] { 0, 0, 0, 0, 0, 1 };
	}

	public byte[] convertToBytes() {
		int offSet = 0;
		if (random == null || random.length == 0) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
			random = calendar2Bytes(calendar);

		}
		BigInteger aa = new BigInteger(certificate_sn);

		signature = getSignData(aa.intValue());
		byte[] data = new byte[getSize()];
		System.arraycopy(random, 0, data, offSet, random.length);
		offSet += random.length;
		System.arraycopy(certificate_sn, 0, data, offSet, certificate_sn.length);
		offSet += certificate_sn.length;
		System.arraycopy(signature, 0, data, offSet, signature.length);
		return data;
	}

	public byte[] calendar2Bytes(Calendar calendar) {
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

    public byte[] getSignData(int certificate_sn) {
        SM2 sm2 = SM2.Instance();
        byte[] buf=new byte[random.length+srcData.length];
        System.arraycopy(srcData, 0,buf, 0, srcData.length);
        System.arraycopy(random, 0, buf, srcData.length, random.length);
        
        byte[] sm3 = calcSM3(buf, userID, privateKeyList.get(certificate_sn));
        BigInteger pri = new BigInteger(privateKeyList.get(certificate_sn), 16);
        SM2Result sm2Ret = new SM2Result();
        sm2.Sm2Sign(sm3, pri, sm2Ret, false);
        byte[] data = new byte[64];
        System.arraycopy(Util.toByteArrayUnsigned(sm2Ret.r), 0, data, 0, 32);
        System.arraycopy(Util.toByteArrayUnsigned(sm2Ret.s), 0, data, 32, 32);
        return data;
    }
}
