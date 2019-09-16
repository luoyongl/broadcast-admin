package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class BWhitelistVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String operaror;

	private String creator;

	private Byte fPermit;

	private String fRealArea;

	private Integer fId;

	private String fName;

	private String fTelephoneNumber;

	private Integer fControlDevice;

	private Date fCreateTime;
	
	private String deviceName;


	public Byte getfPermit() {
		return fPermit;
	}

	public void setfPermit(Byte fPermit) {
		this.fPermit = fPermit;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	private Date fUpdateTime;

	private Integer fCreatorId;

	private Integer fOperatorId;

	private String fArea;

	private Boolean fDeleteFlag;

	public String getOperaror() {
		return operaror;
	}

	public void setOperaror(String operaror) {
		this.operaror = operaror;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getfRealArea() {
		return fRealArea;
	}

	public void setfRealArea(String fRealArea) {
		this.fRealArea = fRealArea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getfTelephoneNumber() {
		return fTelephoneNumber;
	}

	public void setfTelephoneNumber(String fTelephoneNumber) {
		this.fTelephoneNumber = fTelephoneNumber;
	}

	public Integer getfControlDevice() {
		return fControlDevice;
	}

	public void setfControlDevice(Integer fControlDevice) {
		this.fControlDevice = fControlDevice;
	}
 
	public Date getfCreateTime() {
		return fCreateTime;
	}

	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
	}

	public Date getfUpdateTime() {
		return fUpdateTime;
	}

	public void setfUpdateTime(Date fUpdateTime) {
		this.fUpdateTime = fUpdateTime;
	}

	public Integer getfCreatorId() {
		return fCreatorId;
	}

	public void setfCreatorId(Integer fCreatorId) {
		this.fCreatorId = fCreatorId;
	}

	public Integer getfOperatorId() {
		return fOperatorId;
	}

	public void setfOperatorId(Integer fOperatorId) {
		this.fOperatorId = fOperatorId;
	}

	public String getfArea() {
		return fArea;
	}

	public void setfArea(String fArea) {
		this.fArea = fArea;
	}

	public Boolean getfDeleteFlag() {
		return fDeleteFlag;
	}

	public void setfDeleteFlag(Boolean fDeleteFlag) {
		this.fDeleteFlag = fDeleteFlag;
	}

}
