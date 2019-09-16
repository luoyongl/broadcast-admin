package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

public class ConnectLineVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int broId;
	String startName;
	double startPointX;
	double startPointY;
	int flashFlag;
	String endName;
	double endPointX;
	double endPointY;
	
	public int getBroId() {
		return broId;
	}
	public void setBroId(int broId) {
		this.broId = broId;
	}
	public String getStartName() {
		return startName;
	}
	public void setStartName(String startName) {
		this.startName = startName;
	}
	public double getStartPointX() {
		return startPointX;
	}
	public void setStartPointX(double startPointX) {
		this.startPointX = startPointX;
	}
	public double getStartPointY() {
		return startPointY;
	}
	public void setStartPointY(double startPointY) {
		this.startPointY = startPointY;
	}
	public int getFlashFlag() {
		return flashFlag;
	}
	public void setFlashFlag(int flashFlag) {
		this.flashFlag = flashFlag;
	}
	public String getEndName() {
		return endName;
	}
	public void setEndName(String endName) {
		this.endName = endName;
	}
	public double getEndPointX() {
		return endPointX;
	}
	public void setEndPointX(double endPointX) {
		this.endPointX = endPointX;
	}
	public double getEndPointY() {
		return endPointY;
	}
	public void setEndPointY(double endPointY) {
		this.endPointY = endPointY;
	}
}
