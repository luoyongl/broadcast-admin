package cn.wtu.broadcast.entity.body;

import java.io.Serializable;

import cn.wtu.broadcast.entity.PassbackBodyData;

/**
 * 上报播发结果
 * @author Lenovo
 *
 */
public class PassbackBody0x15Data extends PassbackBodyData implements Serializable{

	private static final long serialVersionUID = 1121401218057767310L;

	/**
	 * 应急广播消息编号
	 */
	private String ebmId;
	/*
	 结果代码
	 **/
	private String resultCode;
	/*
	 * 结果描述长度*/
	private String resultDescLength;
	/*
	 * 结果描述内容*/
	private String resultDesc;
	/*
	 * 播发开始时间*/
	private String playStartTime;
	/*
	 * 播发结束时间*/
	private String playEndTime;
	/*
	 * 播发次数*/
	private String playCount;
	/*
	 * 上报时间*/
	private String reportTime;
	public String getEbmId() {
		return ebmId;
	}
	public void setEbmId(String ebmId) {
		this.ebmId = ebmId;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDescLength() {
		return resultDescLength;
	}
	public void setResultDescLength(String resultDescLength) {
		this.resultDescLength = resultDescLength;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	public String getPlayStartTime() {
		return playStartTime;
	}
	public void setPlayStartTime(String playStartTime) {
		this.playStartTime = playStartTime;
	}
	public String getPlayEndTime() {
		return playEndTime;
	}
	public void setPlayEndTime(String playEndTime) {
		this.playEndTime = playEndTime;
	}
	public String getPlayCount() {
		return playCount;
	}
	public void setPlayCount(String playCount) {
		this.playCount = playCount;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	
	
}
