package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TransmitterVO  implements Serializable{
	
	/**
	 * 记录id
	 */
	private int id;
	/**
	 * 发射机编号
	 */
	private String transmitterId;
	/**
	 * 发射机名称
	 */
	private String transmitterName;
	/**
	 * 绑定适配器
	 */
	private String adapterName;
	/**
	 * 所属区域
	 */
	private String region;
	/**
	 * 安装地址
	 */
	private String installArea;
	/**
	 * 物理编码
	 */
	private String physicalCode;
	/**
	 * 资源编码
	 */
	private String resourceCode;
	/**
	 * 发射机状态
	 */
	private int transmitterState;
	/**
	 * 发射机输出频率
	 */
	private String transmitterOutputFrequency;
	/**
	 * 输出功率
	 */
	private String outputPower;
	/**
	 * 设备温度
	 */
	private String equipmentTemperature;
	/**
	 * 发射机工作电压
	 */
	private String transmitterOperatingVoltage;
	/**
	 * 发射机工作电流
	 */
	private String transmitterOperatingCurrent;
	/**
	 * 发射机反射功率
	 */
	private String transmitterReflectionPower;
	/**
	 * 左声道调制度
	 */
	private String leftChannelModulation;
	/**
	 * 右声道调制度
	 */
	private String rightChannelModulation;
	/**
	 * 和声道调制度
	 */
	private String harmonicChannelModulation;
	/**
	 * 差声道调制度
	 */
	private String differentialChannelModulation;
	/**
	 * RF锁定状态
	 */
	private int rfLockInState;
	/**
	 * PLL锁定状态
	 */
	private int pllLockInState;
	/**
	 * 回传时间
	 */
	private String backTime;
	/**
	 * 适配器Id
	 */
	private int adapterId;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransmitterId() {
		return transmitterId;
	}
	public void setTransmitterId(String transmitterId) {
		this.transmitterId = transmitterId;
	}
	public String getTransmitterName() {
		return transmitterName;
	}
	public void setTransmitterName(String transmitterName) {
		this.transmitterName = transmitterName;
	}
	public String getAdapterName() {
		return adapterName;
	}
	public void setAdapterName(String adapterName) {
		this.adapterName = adapterName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getInstallArea() {
		return installArea;
	}
	public void setInstallArea(String installArea) {
		this.installArea = installArea;
	}
	public String getPhysicalCode() {
		return physicalCode;
	}
	public void setPhysicalCode(String physicalCode) {
		this.physicalCode = physicalCode;
	}
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	public int getTransmitterState() {
		return transmitterState;
	}
	public void setTransmitterState(int transmitterState) {
		this.transmitterState = transmitterState;
	}
	public String getTransmitterOutputFrequency() {
		return transmitterOutputFrequency;
	}
	public void setTransmitterOutputFrequency(String transmitterOutputFrequency) {
		this.transmitterOutputFrequency = transmitterOutputFrequency;
	}
	public String getOutputPower() {
		return outputPower;
	}
	public void setOutputPower(String outputPower) {
		this.outputPower = outputPower;
	}
	public String getEquipmentTemperature() {
		return equipmentTemperature;
	}
	public void setEquipmentTemperature(String equipmentTemperature) {
		this.equipmentTemperature = equipmentTemperature;
	}
	public String getTransmitterOperatingVoltage() {
		return transmitterOperatingVoltage;
	}
	public void setTransmitterOperatingVoltage(String transmitterOperatingVoltage) {
		this.transmitterOperatingVoltage = transmitterOperatingVoltage;
	}
	public String getTransmitterOperatingCurrent() {
		return transmitterOperatingCurrent;
	}
	public void setTransmitterOperatingCurrent(String transmitterOperatingCurrent) {
		this.transmitterOperatingCurrent = transmitterOperatingCurrent;
	}
	public String getTransmitterReflectionPower() {
		return transmitterReflectionPower;
	}
	public void setTransmitterReflectionPower(String transmitterReflectionPower) {
		this.transmitterReflectionPower = transmitterReflectionPower;
	}
	public String getLeftChannelModulation() {
		return leftChannelModulation;
	}
	public void setLeftChannelModulation(String leftChannelModulation) {
		this.leftChannelModulation = leftChannelModulation;
	}
	public String getRightChannelModulation() {
		return rightChannelModulation;
	}
	public void setRightChannelModulation(String rightChannelModulation) {
		this.rightChannelModulation = rightChannelModulation;
	}
	public String getHarmonicChannelModulation() {
		return harmonicChannelModulation;
	}
	public void setHarmonicChannelModulation(String harmonicChannelModulation) {
		this.harmonicChannelModulation = harmonicChannelModulation;
	}
	public String getDifferentialChannelModulation() {
		return differentialChannelModulation;
	}
	public void setDifferentialChannelModulation(String differentialChannelModulation) {
		this.differentialChannelModulation = differentialChannelModulation;
	}
	public int getRfLockInState() {
		return rfLockInState;
	}
	public void setRfLockInState(int rfLockInState) {
		this.rfLockInState = rfLockInState;
	}
	public int getPllLockInState() {
		return pllLockInState;
	}
	public void setPllLockInState(int pllLockInState) {
		this.pllLockInState = pllLockInState;
	}
	public String getBackTime() {
		return backTime;
	}
	public void setBackTime(String backTime) {
		this.backTime = backTime;
	}
	public int getAdapterId() {
		return adapterId;
	}
	public void setAdapterId(int adapterId) {
		this.adapterId = adapterId;
	}	
}
