package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Author: LiLinfeng
 * @Description:
 * @Date: Created in 10:09 on 2019/1/17.
 * @Modified_by:
 */
public class ExceptionDeviceExportVO  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Excel(name = "设备编号", orderNum = "1")
    private String fNumber;

    @Excel(name = "设备名称", orderNum = "2")
    private String fDeviceName;

    @Excel(name = "设备型号", orderNum = "3")
    private String fRealDeviceModel;

    @Excel(name = "设备IP", orderNum = "4",width=20)
    private String fDeviceIp;

    @Excel(name = "设备端口", orderNum = "5")
    private String fDevicePort;

    @Excel(name = "设备物理码", orderNum = "6",width=15)
    private String fPhysicalCode;

    @Excel(name = "设备资源码", orderNum = "7",width=20)
    private String fDeviceResourceCode;

    @Excel(name = "所属区域", orderNum = "8",width=15)
    private String fRealArea;

    @Excel(name = "安装地址", orderNum = "9")
    private String fInstallAddress;

    @Excel(name = "URL", orderNum = "10",width=35)
    private String fUrl;

    @Excel(name = "经度", orderNum = "11")
    private String fLongitude;

    @Excel(name = "纬度", orderNum = "12")
    private String fDimension;

    @Excel(name = "显示级别", orderNum = "13")
    private String fDisplayLevel;

    @Excel(name = "维护人员", orderNum = "14")
    private String fMaintainer;

    @Excel(name = "协议类型", orderNum = "15")
    private String fRealProtocol;

    @Excel(name = "备注", orderNum = "16",width=50)
    private String fRemark;

    @Excel(name = "设备状态", orderNum = "17",width=50)
    private String fDeviceState;
    
    @Excel(name = "导出时间", orderNum = "18",width=50)
    private String fDate;
    

	public String getfDate() {
		return fDate;
	}

	public void setfDate(String fDate) {
		this.fDate = fDate;
	}

	public String getfDeviceState() {
		return fDeviceState;
	}

	public void setfDeviceState(String fDeviceState) {
		this.fDeviceState = fDeviceState;
	}

	public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public String getfDeviceName() {
        return fDeviceName;
    }

    public void setfDeviceName(String fDeviceName) {
        this.fDeviceName = fDeviceName;
    }

    public String getfRealDeviceModel() {
        return fRealDeviceModel;
    }

    public void setfRealDeviceModel(String fRealDeviceModel) {
        this.fRealDeviceModel = fRealDeviceModel;
    }

    public String getfDeviceIp() {
        return fDeviceIp;
    }

    public void setfDeviceIp(String fDeviceIp) {
        this.fDeviceIp = fDeviceIp;
    }

    public String getfDevicePort() {
        return fDevicePort;
    }

    public void setfDevicePort(String fDevicePort) {
        this.fDevicePort = fDevicePort;
    }

    public String getfPhysicalCode() {
        return fPhysicalCode;
    }

    public void setfPhysicalCode(String fPhysicalCode) {
        this.fPhysicalCode = fPhysicalCode;
    }

    public String getfDeviceResourceCode() {
        return fDeviceResourceCode;
    }

    public void setfDeviceResourceCode(String fDeviceResourceCode) {
        this.fDeviceResourceCode = fDeviceResourceCode;
    }

    public String getfRealArea() {
        return fRealArea;
    }

    public void setfRealArea(String fRealArea) {
        this.fRealArea = fRealArea;
    }

    public String getfInstallAddress() {
        return fInstallAddress;
    }

    public void setfInstallAddress(String fInstallAddress) {
        this.fInstallAddress = fInstallAddress;
    }

    public String getfUrl() {
        return fUrl;
    }

    public void setfUrl(String fUrl) {
        this.fUrl = fUrl;
    }

    public String getfLongitude() {
        return fLongitude;
    }

    public void setfLongitude(String fLongitude) {
        this.fLongitude = fLongitude;
    }

    public String getfDimension() {
        return fDimension;
    }

    public void setfDimension(String fDimension) {
        this.fDimension = fDimension;
    }

    public String getfDisplayLevel() {
        return fDisplayLevel;
    }

    public void setfDisplayLevel(String fDisplayLevel) {
        this.fDisplayLevel = fDisplayLevel;
    }

    public String getfMaintainer() {
        return fMaintainer;
    }

    public void setfMaintainer(String fMaintainer) {
        this.fMaintainer = fMaintainer;
    }

    public String getfRealProtocol() {
        return fRealProtocol;
    }

    public void setfRealProtocol(String fRealProtocol) {
        this.fRealProtocol = fRealProtocol;
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark;
    }
}
