package cn.wtu.broadcast.parent.vo;

import java.io.Serializable;
import java.util.List;

public class TsDeviceUpdateVo implements Serializable{

	private static final long serialVersionUID = 1L;

    private String fFileAddress;

    private String fManufacturerNumber;

    private String fHardwareVersion;

    private String fOldSoftwareVersion;

    private String fSoftwareVersion;
    
    //设备资源编码
    private List<String> deviceResourceCodes;

	public List<String> getDeviceResourceCodes() {
		return deviceResourceCodes;
	}

	public void setDeviceResourceCodes(List<String> deviceResourceCodes) {
		this.deviceResourceCodes = deviceResourceCodes;
	}

	public String getfFileAddress() {
		return fFileAddress;
	}

	public void setfFileAddress(String fFileAddress) {
		this.fFileAddress = fFileAddress;
	}

	public String getfManufacturerNumber() {
		return fManufacturerNumber;
	}

	public void setfManufacturerNumber(String fManufacturerNumber) {
		this.fManufacturerNumber = fManufacturerNumber;
	}

	public String getfHardwareVersion() {
		return fHardwareVersion;
	}

	public void setfHardwareVersion(String fHardwareVersion) {
		this.fHardwareVersion = fHardwareVersion;
	}

	public String getfOldSoftwareVersion() {
		return fOldSoftwareVersion;
	}

	public void setfOldSoftwareVersion(String fOldSoftwareVersion) {
		this.fOldSoftwareVersion = fOldSoftwareVersion;
	}

	public String getfSoftwareVersion() {
		return fSoftwareVersion;
	}

	public void setfSoftwareVersion(String fSoftwareVersion) {
		this.fSoftwareVersion = fSoftwareVersion;
	}

}
