package cn.wtu.broadcast.entity;

import java.io.Serializable;

public class PassbackBodyData implements Serializable{
	
	private static final long serialVersionUID = -7118908771251297473L;
	
	/**
	 * 数据源对象编码
	 */
	private String source;
	
	/**
	 * 数据目标对象数量
	 */
	private String number;
	
	/**
	 * 数据目标对象编码序列
	 */
	private String sequence;
	
	/**
	 * 业务数据类型
	 */
	private String dataType;
	
	/**
	 * 业务数据长度
	 */
	private String dataLen;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataLen() {
		return dataLen;
	}

	public void setDataLen(String dataLen) {
		this.dataLen = dataLen;
	}
	
}
