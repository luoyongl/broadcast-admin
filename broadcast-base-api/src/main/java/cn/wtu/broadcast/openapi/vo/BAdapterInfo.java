package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BAdapterInfo  implements Serializable{

	private int fId;
	private String fDeviceName;
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getfDeviceName() {
		return fDeviceName;
	}
	public void setfDeviceName(String fDeviceName) {
		this.fDeviceName = fDeviceName;
	}
	
}
