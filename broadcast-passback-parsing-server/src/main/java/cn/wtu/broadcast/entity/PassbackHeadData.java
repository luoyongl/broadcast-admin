package cn.wtu.broadcast.entity;

import java.io.Serializable;

public class PassbackHeadData implements Serializable{
	
	private static final long serialVersionUID = -7118908771251297473L;

	/**
	 * 包头标记
	 */
	private String headMark;
	
	/**
	 * 协议版本号
	 */
	private String version;
	
	/**
	 * 会话标识
	 */
	private String tag;
	
	/**
	 * 数据包类型
	 */
	private String packType;
	
	/**
	 * 数据包长度
	 */
	private String packLen;

	public String getHeadMark() {
		return headMark;
	}

	public void setHeadMark(String headMark) {
		this.headMark = headMark;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public String getPackLen() {
		return packLen;
	}

	public void setPackLen(String packLen) {
		this.packLen = packLen;
	}
}
