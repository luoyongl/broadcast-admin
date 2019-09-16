package cn.wtu.broadcast.openapi.vo;

public class AuxiliaryData {
	private String count;
	private String type;
	private String len;
	private String protocolType;
	private String audioCodeType;
	private String audioPid1;
	private String audioPid2;
	private String reserveInfo;
	private String audioUrl;
	
	public AuxiliaryData(String url){
		audioUrl=url;
		count="01";
		type="02";
		protocolType="04";
		audioCodeType="01";
		audioPid1="00";
		audioPid2="00";
		reserveInfo="000000000000000000";
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLen() {
		return len;
	}
	public void setLen(String len) {
		this.len = len;
	}
	public String getProtocolType() {
		return protocolType;
	}
	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}
	public String getAudioCodeType() {
		return audioCodeType;
	}
	public void setAudioCodeType(String audioCodeType) {
		this.audioCodeType = audioCodeType;
	}
	public String getAudioPid1() {
		return audioPid1;
	}
	public void setAudioPid1(String audioPid1) {
		this.audioPid1 = audioPid1;
	}
	public String getAudioPid2() {
		return audioPid2;
	}
	public void setAudioPid2(String audioPid2) {
		this.audioPid2 = audioPid2;
	}
	public String getReserveInfo() {
		return reserveInfo;
	}
	public void setReserveInfo(String reserveInfo) {
		this.reserveInfo = reserveInfo;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
}
