package cn.wtu.broadcast.entity;

import java.io.Serializable;

public class PassbackSignData implements Serializable{

	private static final long serialVersionUID = -5593109341065790580L;

	/**
	 * 校验数据
	 */
	private String crc32;

	public String getCrc32() {
		return crc32;
	}

	public void setCrc32(String crc32) {
		this.crc32 = crc32;
	}
}
