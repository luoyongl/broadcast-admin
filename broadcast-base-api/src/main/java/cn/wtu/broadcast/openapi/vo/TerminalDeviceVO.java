package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TerminalDeviceVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getfNumber() {
		return fNumber;
	}
	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}
	public String getfPhysicalCode() {
		return fPhysicalCode;
	}
	public void setfPhysicalCode(String fPhysicalCode) {
		this.fPhysicalCode = fPhysicalCode;
	}
	public String getfDeviceTypeCode() {
		return fDeviceTypeCode;
	}
	public void setfDeviceTypeCode(String fDeviceTypeCode) {
		this.fDeviceTypeCode = fDeviceTypeCode;
	}
	public String getfDeviceName() {
		return fDeviceName;
	}
	public void setfDeviceName(String fDeviceName) {
		this.fDeviceName = fDeviceName;
	}
	public String getfManufacturerInfo() {
		return fManufacturerInfo;
	}
	public void setfManufacturerInfo(String fManufacturerInfo) {
		this.fManufacturerInfo = fManufacturerInfo;
	}
	public String getfLocationCode() {
		return fLocationCode;
	}
	public void setfLocationCode(String fLocationCode) {
		this.fLocationCode = fLocationCode;
	}
	public String getfInstallAddress() {
		return fInstallAddress;
	}
	public void setfInstallAddress(String fInstallAddress) {
		this.fInstallAddress = fInstallAddress;
	}
	//设备编号
	@Excel(name = "设备编号", orderNum = "0")
	 private String fNumber;
	 //设备物理码
	@Excel(name = "设备物理码", orderNum = "1")
	 private String fPhysicalCode;
	 //设备类型码
	@Excel(name = "设备类型码", orderNum = "2")
	 private String fDeviceTypeCode;
	 //设备名称
	@Excel(name = "设备名称", orderNum = "3")
	  private String fDeviceName;
	  //厂商信息
	@Excel(name = "厂商信息", orderNum = "4")
	  private String fManufacturerInfo;
	  //所属区域码
	@Excel(name = "所属区域码", orderNum = "5")
	  private String fLocationCode;
	  //安装位置
	@Excel(name = "安装位置", orderNum = "6")
	    private String fInstallAddress;
	
	//设备类型码4位+所属区域码12位+设备编号2位==设备资源码18位
}
