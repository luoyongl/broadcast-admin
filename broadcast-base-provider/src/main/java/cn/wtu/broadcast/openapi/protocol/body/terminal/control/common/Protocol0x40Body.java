package cn.wtu.broadcast.openapi.protocol.body.terminal.control.common;

import java.util.ArrayList;
import java.util.List;

import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

/**
 * 应急广播大喇叭终端通用指令----通用证书更新(0x40)
 * @author Lenovo
 *
 */
public class Protocol0x40Body extends ProtocolBodyCommonInfo {

	public Protocol0x40Body() {
		protocol_type = ProtocolTypeEnum.Protocol0x40Body;
	}
	
    //证书链个数8bit
	byte certauth_number;
	// 证书链内容集合
	public List<CertauthInfo> certauthInfos = new ArrayList<CertauthInfo>();
	
	public static class CertauthInfo {
		//证书链长度 16bit
		short certauth_length;
		//证书链数据 Nbit
		byte[] certauth;
		
		public CertauthInfo(byte[] certauth) {
			this.certauth = certauth;
			certauth_length = (short) certauth.length;
		}

		public int getSize() {
			int len = 2;
			if (certauth != null) {
				len += certauth_length;
			}
			return len;
		}
		
		public byte[] converToBytes() {
			byte[] data = new byte[getSize()];
			int offSet = 0;
			
			data[offSet++] = (byte) (certauth_length >> 8);
			data[offSet++] = (byte) (certauth_length & 0xff);
			
			if(certauth != null){
				System.arraycopy(certauth, 0, data, offSet, certauth_length);
			}
			
			return data;
		}
	}
	
	//证书个数8bit
	byte cert_number;
	// 证书内容集合
	public List<CerthInfo> certhInfos = new ArrayList<CerthInfo>();
	
	public static class CerthInfo {
		/*
		 * 证书长度 8bit
		 * 这里用short修饰,特例,之后截取后8位
		 * 因为传来的证书数据是286Hex = 143byte
		 */
		//byte certh_length;
		short certh_length;
		//证书数据 Nbit
		byte[] certh;
		
		public CerthInfo(byte[] certh) {
			this.certh = certh;
			certh_length = (short) certh.length;
		}

		public int getSize() {
			int len = 1;
			if (certh != null) {
				len += certh_length;
			}
			return len;
		}
		
		public byte[] converToBytes() {
			byte[] data = new byte[getSize()];
			int offSet = 0;
			
			//TODO 获取低8位
			data[offSet++] = (byte)(certh_length & 0xff);
			
			if(certh != null){
				System.arraycopy(certh, 0, data, offSet, certh_length);
			}
			
			return data;
		}
	}
	
	public byte[] convertToBytes() {
		byte[] data = new byte[getSize()];
		int offSet = 0;
		
		data[offSet++] = (byte) certauth_number;
		
		if(certauthInfos != null){
			for (CertauthInfo certauthInfo : certauthInfos) {
				System.arraycopy(certauthInfo.converToBytes(), 0, data, offSet, certauthInfo.getSize());
				offSet += certauthInfo.getSize(); 
			}
		}
		
		data[offSet++] = (byte) cert_number;
		
		if(certhInfos != null){
			for (CerthInfo certhInfo : certhInfos) {
				System.arraycopy(certhInfo.converToBytes(), 0, data, offSet, certhInfo.getSize());
				offSet += certhInfo.getSize(); 
			}
		}
		
		return data;
	}
	
	public int getSize() {
		primary_cmd_len = 1;
		
		if (certauthInfos != null) {
			certauth_number = (byte) certauthInfos.size();
			
			for (CertauthInfo certauthInfo : certauthInfos) {
				primary_cmd_len += certauthInfo.getSize();
			}
		}
		
		primary_cmd_len += 1;
		
		if (certhInfos != null) {
			cert_number = (byte) certhInfos.size();
			
			for (CerthInfo certhInfo : certhInfos) {
				primary_cmd_len += certhInfo.getSize();
			}
		}
		
		return primary_cmd_len;
	}
}