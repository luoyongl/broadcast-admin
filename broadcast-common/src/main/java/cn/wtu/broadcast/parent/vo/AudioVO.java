package cn.wtu.broadcast.parent.vo;

import java.io.Serializable;

public class AudioVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5093786413526537691L;

	private Integer fId;
	
	private String broadcastAudioUrl;
	
	private String textToAudioUrl;

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getBroadcastAudioUrl() {
		return broadcastAudioUrl;
	}

	public void setBroadcastAudioUrl(String broadcastAudioUrl) {
		this.broadcastAudioUrl = broadcastAudioUrl;
	}

	public String getTextToAudioUrl() {
		return textToAudioUrl;
	}

	public void setTextToAudioUrl(String textToAudioUrl) {
		this.textToAudioUrl = textToAudioUrl;
	}
	
}
