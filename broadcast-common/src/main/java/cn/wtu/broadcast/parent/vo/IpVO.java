package cn.wtu.broadcast.parent.vo;

import java.io.Serializable;
import java.util.List;

public class IpVO implements Serializable {

	private static final long serialVersionUID = 5704556028483087032L;

	private String fId; // 广播id

	private String broadCastType;
	
	private String len;
	
	/**
	 * 播发方式 true单播 false组播
	 */
	private Boolean fBroadcastStyle;

	private String eventLevel;

	private String eventType;

	private Byte volume;

	private String audioURL; // 辅助数据音频地址

	private String serviceIp;

	private String servicePort;

	/*
	 * 音频url 网络路径
	 */
	private String broadcastAudioUrl; // 广播表音频地址

	/*
	 * 文本转语音url 
	 */
	private String textToAudioUrl;

	/*
	 * 平台资源编码 对应 配置表 t_system_configuration的资源编码
	 */
	private String platformResourceCode;

	private String adapterResourceCode;

	/*
	 * 播发区域 用于接收 从广播数据表传来的 区域id 对应
	 * 广播数据表b_broadcast_data和b_broadcast_timing的f_broadcast_area
	 */
	private String EBM_resource_codes;
	/*
	 * 播发区域 区域编码的list形式 对应
	 * 广播数据表b_broadcast_data和b_broadcast_timing的f_broadcast_area
	 */
	private List<String> resourceCodeList;

	private String ipPlayPort;

	private String broadcastTomcatPath;

	/**
	 * 存放广播顺序码
	 */
	private String orderId;

	private String fProgramPass;

	public String getLen() {
		return len;
	}

	public void setLen(String len) {
		this.len = len;
	}

	public Boolean getfBroadcastStyle() {
		return fBroadcastStyle;
	}

	public void setfBroadcastStyle(Boolean fBroadcastStyle) {
		this.fBroadcastStyle = fBroadcastStyle;
	}

	public String getfProgramPass() {
		return fProgramPass;
	}

	public void setfProgramPass(String fProgramPass) {
		this.fProgramPass = fProgramPass;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAdapterResourceCode() {
		return adapterResourceCode;
	}

	public void setAdapterResourceCode(String adapterResourceCode) {
		this.adapterResourceCode = adapterResourceCode;
	}

	public String getIpPlayPort() {
		return ipPlayPort;
	}

	public void setIpPlayPort(String ipPlayPort) {
		this.ipPlayPort = ipPlayPort;
	}

	public String getPlatformResourceCode() {
		return platformResourceCode;
	}

	public void setPlatformResourceCode(String platformResourceCode) {
		this.platformResourceCode = platformResourceCode;
	}

	public List<String> getResourceCodeList() {
		return resourceCodeList;
	}

	public void setResourceCodeList(List<String> resourceCodeList) {
		this.resourceCodeList = resourceCodeList;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}

	public String getBroadCastType() {
		return broadCastType;
	}

	public void setBroadCastType(String broadCastType) {
		this.broadCastType = broadCastType;
	}

	public String getEventLevel() {
		return eventLevel;
	}

	public void setEventLevel(String eventLevel) {
		this.eventLevel = eventLevel;
	}

	public String getAudioURL() {
		return audioURL;
	}

	public void setAudioURL(String audioUrl) {
		this.audioURL = audioUrl;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Byte getVolume() {
		return volume;
	}

	public void setVolume(Byte volume) {
		this.volume = volume;
	}

	public String getServiceIp() {
		return serviceIp;
	}

	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}

	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public String getTextToAudioUrl() {
		return textToAudioUrl;
	}

	public void setTextToAudioUrl(String textToAudioUrl) {
		this.textToAudioUrl = textToAudioUrl;
	}

	public String getBroadcastAudioUrl() {
		return broadcastAudioUrl;
	}

	public void setBroadcastAudioUrl(String broadcastAudioUrl) {
		this.broadcastAudioUrl = broadcastAudioUrl;
	}

	public String getBroadcastTomcatPath() {
		return broadcastTomcatPath;
	}

	public void setBroadcastTomcatPath(String broadcastTomcatPath) {
		this.broadcastTomcatPath = broadcastTomcatPath;
	}

	public String getEBM_resource_codes() {
		return EBM_resource_codes;
	}

	public void setEBM_resource_codes(String eBM_resource_codes) {
		EBM_resource_codes = eBM_resource_codes;
	}

}
