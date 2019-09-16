package cn.wtu.broadcast.openapi.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-05 14:31
 */
public class ServerVo implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Excel(name = "设备编号", orderNum = "1")
    private String fNumber;

    @Excel(name = "设备名称", orderNum = "2")
    private String fDeviceName;

    @Excel(name = "显示级别", orderNum = "3")
    private String fDisplayLevel;

    @Excel(name = "设备型号", orderNum = "4")
    private String fDeviceModel;

    @Excel(name = "设备IP", orderNum = "5")
    private String fDeviceIp;

    @Excel(name = "控制端口", orderNum = "6")
    private String fDevicePort;

    @Excel(name = "登录名", orderNum = "7")
    private String fLoginName;

    @Excel(name = "登录密码", orderNum = "8")
    private String fLoginPassword;

    @Excel(name = "所属区域", orderNum = "9")
    private String fLocation;

    @Excel(name = "安装地址", orderNum = "10")
    private String fInstallAddress;

    @Excel(name = "物理码", orderNum = "11")
    private String fPhysicalCode;

    @Excel(name = "创建者", orderNum = "12")
    private String fCreatorId;

    @Excel(name = "创建时间", orderNum = "13", exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date fCreateTime;

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public String getfDisplayLevel() {
        return fDisplayLevel;
    }

    public void setfDisplayLevel(String fDisplayLevel) {
        this.fDisplayLevel = fDisplayLevel;
    }

    public String getfDeviceModel() {
        return fDeviceModel;
    }

    public void setfDeviceModel(String fDeviceModel) {
        this.fDeviceModel = fDeviceModel;
    }

    public String getfDeviceName() {
        return fDeviceName;
    }

    public void setfDeviceName(String fDeviceName) {
        this.fDeviceName = fDeviceName;
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

    public String getfLoginName() {
        return fLoginName;
    }

    public void setfLoginName(String fLoginName) {
        this.fLoginName = fLoginName;
    }

    public String getfLoginPassword() {
        return fLoginPassword;
    }

    public void setfLoginPassword(String fLoginPassword) {
        this.fLoginPassword = fLoginPassword;
    }

    public String getfLocation() {
        return fLocation;
    }

    public void setfLocation(String fLocation) {
        this.fLocation = fLocation;
    }

    public String getfInstallAddress() {
        return fInstallAddress;
    }

    public void setfInstallAddress(String fInstallAddress) {
        this.fInstallAddress = fInstallAddress;
    }

    public String getfPhysicalCode() {
        return fPhysicalCode;
    }

    public void setfPhysicalCode(String fPhysicalCode) {
        this.fPhysicalCode = fPhysicalCode;
    }

    public String getfCreatorId() {
        return fCreatorId;
    }

    public void setfCreatorId(String fCreatorId) {
        this.fCreatorId = fCreatorId;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }
}
