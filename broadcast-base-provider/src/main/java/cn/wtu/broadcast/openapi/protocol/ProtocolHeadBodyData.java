package cn.wtu.broadcast.openapi.protocol;

import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;
import cn.wtu.broadcast.openapi.protocol.signature.SignatureData;

/**
 * 消息整体信息
 * 
 * @author Lenovo
 *
 */
public class ProtocolHeadBodyData {

	/*
	 * 报头： 字段值为 0x49
	 * 代表应急广播平台发送给应急广播大喇叭适配器的指令，包括应急广播大喇叭适配器控制指令、应急广播大喇叭终端控制指令、应急广播平台回复指令三种 0x50
	 * 代表应急广播大喇叭适配器发送给应急广播平台的指令，包括应急广播大喇叭适配器上报指令和应急广播大喇叭适配器回复指令两种
	 */
	public byte head = 0x49;

	/* 协议版本号=1 16bit */
	protected short version = 1;

	/*
	 * 协议类型：8bit
	 */
	protected ProtocolTypeEnum protocol_type;

	/* 消息来源 8bit：1：表示消息来自平台软件；2：表示消息来自设备应急； 其他：保留 */
	public byte platform_type = 1;

	/*
	 * 指令数据长度 32bit 子类中本身就有data_length,但表示的意思不一样 static修饰
	 * 否则getSize()primary_cmd_len = 0;封装时ArrayIndexOutOfBoundsException
	 */
	protected static int primary_cmd_len;

	/*
	 * 广播消息头部长度head(1字节) + version(2字节) + protocol_type(1字节) +
	 * platform_type(1字节) + data_length(4字节)
	 */
	protected int broadcastMessageHeaderLen = 1 + 2 + 1 + 1 + 4;

	//////////////////////////////// 消息体&数字签名&CRC32////////////////////////////////////
	/**
	 * 用来接收封装好的消息体指令数据 ,如TsLockFrequencyCmd的指令数据
	 */
	protected byte[] broadcastMessageBody;

	// 数字签名
	protected SignatureData signatureData;

	// CRC32 32bit
	int crc32;

	/**
	 * 获取指令的长度 单位:字节byte
	 */
	public int getSize() {
		// 获取广播消息头和消息体长度
		int len = broadcastMessageHeaderLen + primary_cmd_len;

		// signatureData
		if (signatureData != null) {
			len += signatureData.getSize();
		}

		// CRC32
		len += 4;

		return len;
	}

	/**
	 * 获取完整的指令
	 */
	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[getSize()];
		// 用来接收 数据签名之前的指令数据
		byte[] srcData = null;

		// 广播消息头部
		data[offSet++] = (byte) head;
		data[offSet++] = (byte) (version >> 8);
		data[offSet++] = (byte) (version & 0xff);
		data[offSet++] = (byte) protocol_type.getValue();
		data[offSet++] = (byte) platform_type;
		data[offSet++] = (byte) ((primary_cmd_len >> 24) & 0xff);
		data[offSet++] = (byte) ((primary_cmd_len >> 16) & 0xff);
		data[offSet++] = (byte) ((primary_cmd_len >> 8) & 0xff);
		data[offSet++] = (byte) (primary_cmd_len & 0xff);

		// 消息体
		System.arraycopy(broadcastMessageBody, 0, data, offSet, broadcastMessageBody.length);
		offSet += broadcastMessageBody.length;

		srcData = new byte[offSet];

		// 把当前封装的data从0索引开始赋值给srcData,也是从0索引开始赋值
		System.arraycopy(data, 0, srcData, 0, srcData.length);
		// 设置待签名数据
		signatureData.setWaittingSignatureData(srcData);

		System.arraycopy(signatureData.convertToBytes(), 0, data, offSet, signatureData.getSize());
		offSet += signatureData.getSize();

		// CRC32
		crc32 = SendProtocolTools.crc_Calculate(data, 0, offSet);
		data[offSet++] = (byte) ((crc32 >> 24) & 0xff);
		data[offSet++] = (byte) ((crc32 >> 16) & 0xff);
		data[offSet++] = (byte) ((crc32 >> 8) & 0xff);
		data[offSet++] = (byte) (crc32 & 0xff);

		return data;
	}

	public byte[] getBroadcastMessageBody() {
		return broadcastMessageBody;
	}

	public void setBroadcastMessageBody(byte[] broadcastMessageBody) {
		this.broadcastMessageBody = broadcastMessageBody;
	}

	public ProtocolTypeEnum getProtocol_type() {
		return protocol_type;
	}

	public void setProtocol_type(ProtocolTypeEnum protocol_type) {
		this.protocol_type = protocol_type;
	}

	public SignatureData getSignatureData() {
		return signatureData;
	}

	public void setSignatureData(SignatureData signatureData) {
		this.signatureData = signatureData;
	}
}
