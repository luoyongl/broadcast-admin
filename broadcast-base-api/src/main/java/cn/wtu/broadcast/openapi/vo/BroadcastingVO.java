package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class BroadcastingVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int broId;
	String messageLevel;
	String broArea;
	Date startTime;
	double coverageRate;
	double responseTime;
	
	public int getBroId() {
		return broId;
	}
	public void setBroId(int broId) {
		this.broId = broId;
	}	
	public String getMessageLevel() {
		return messageLevel;
	}
	public void setMessageLevel(String messageLevel) {
		this.messageLevel = messageLevel;
	}
	public String getBroArea() {
		return broArea;
	}
	public void setBroArea(String broArea) {
		this.broArea = broArea;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public double getCoverageRate() {
		return coverageRate;
	}
	public void setCoverageRate(double coverageRate) {
		this.coverageRate = coverageRate;
	}
	public double getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(double responseTime) {
		this.responseTime = responseTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
