package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

/**
 * 返回参数VO
 *
 */
public class EBCTTsDataVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private byte[] data;

	private Integer length;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

}
