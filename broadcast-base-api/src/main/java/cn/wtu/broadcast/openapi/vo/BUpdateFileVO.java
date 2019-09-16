package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class BUpdateFileVO implements Serializable {
    private Integer fId;

    private String fNumber;

    private String fFileName;

    private String fFileAddress;

    private Integer fManufacturerName;
    
    private Integer fManufacturerNumber;

    private Integer fDeviceType;

    private String fHardwareVersion;

    private String fSoftwareVersion;
    
    private String fOldSoftwareVersion;
    
    private String broadcastArea;
    
    private String Realmanufacturer;
    
    private String Realdevice;

    private Date fCreateTime;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fUpdateFlag;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

    
    public String getRealmanufacturer() {
		return Realmanufacturer;
	}

	public void setRealmanufacturer(String realmanufacturer) {
		Realmanufacturer = realmanufacturer;
	}

	public String getRealdevice() {
		return Realdevice;
	}

	public String getfOldSoftwareVersion() {
		return fOldSoftwareVersion;
	}

	public void setfOldSoftwareVersion(String fOldSoftwareVersion) {
		this.fOldSoftwareVersion = fOldSoftwareVersion;
	}

	public String getBroadcastArea() {
		return broadcastArea;
	}

	public void setBroadcastArea(String broadcastArea) {
		this.broadcastArea = broadcastArea;
	}

	public void setRealdevice(String realdevice) {
		Realdevice = realdevice;
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

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber == null ? null : fNumber.trim();
    }

    public String getfFileName() {
        return fFileName;
    }

    public void setfFileName(String fFileName) {
        this.fFileName = fFileName == null ? null : fFileName.trim();
    }

    public String getfFileAddress() {
        return fFileAddress;
    }

    public void setfFileAddress(String fFileAddress) {
        this.fFileAddress = fFileAddress == null ? null : fFileAddress.trim();
    }

    public Integer getfManufacturerName() {
        return fManufacturerName;
    }

    public void setfManufacturerName(Integer fManufacturerName) {
        this.fManufacturerName = fManufacturerName;
    }

    public Integer getfDeviceType() {
        return fDeviceType;
    }

    public void setfDeviceType(Integer fDeviceType) {
        this.fDeviceType = fDeviceType;
    }

    public String getfHardwareVersion() {
        return fHardwareVersion;
    }

    public void setfHardwareVersion(String fHardwareVersion) {
        this.fHardwareVersion = fHardwareVersion == null ? null : fHardwareVersion.trim();
    }

    public String getfSoftwareVersion() {
        return fSoftwareVersion;
    }

    public void setfSoftwareVersion(String fSoftwareVersion) {
        this.fSoftwareVersion = fSoftwareVersion == null ? null : fSoftwareVersion.trim();
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Integer getfCreatorId() {
        return fCreatorId;
    }

    public void setfCreatorId(Integer fCreatorId) {
        this.fCreatorId = fCreatorId;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    public Integer getfOperatorId() {
        return fOperatorId;
    }

    public void setfOperatorId(Integer fOperatorId) {
        this.fOperatorId = fOperatorId;
    }

    public Boolean getfUpdateFlag() {
        return fUpdateFlag;
    }

    public void setfUpdateFlag(Boolean fUpdateFlag) {
        this.fUpdateFlag = fUpdateFlag;
    }

    public Boolean getfDeleteFlag() {
        return fDeleteFlag;
    }

    public void setfDeleteFlag(Boolean fDeleteFlag) {
        this.fDeleteFlag = fDeleteFlag;
    }

    
    public Integer getfManufacturerNumber() {
		return fManufacturerNumber;
	}

	public void setfManufacturerNumber(Integer fManufacturerNumber) {
		this.fManufacturerNumber = fManufacturerNumber;
	}

	@Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BUpdateFileVO other = (BUpdateFileVO) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfNumber() == null ? other.getfNumber() == null : this.getfNumber().equals(other.getfNumber()))
            && (this.getfFileName() == null ? other.getfFileName() == null : this.getfFileName().equals(other.getfFileName()))
            && (this.getfFileAddress() == null ? other.getfFileAddress() == null : this.getfFileAddress().equals(other.getfFileAddress()))
            && (this.getfManufacturerName() == null ? other.getfManufacturerName() == null : this.getfManufacturerName().equals(other.getfManufacturerName()))
            && (this.getfDeviceType() == null ? other.getfDeviceType() == null : this.getfDeviceType().equals(other.getfDeviceType()))
            && (this.getfHardwareVersion() == null ? other.getfHardwareVersion() == null : this.getfHardwareVersion().equals(other.getfHardwareVersion()))
            && (this.getfSoftwareVersion() == null ? other.getfSoftwareVersion() == null : this.getfSoftwareVersion().equals(other.getfSoftwareVersion()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfUpdateFlag() == null ? other.getfUpdateFlag() == null : this.getfUpdateFlag().equals(other.getfUpdateFlag()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfNumber() == null) ? 0 : getfNumber().hashCode());
        result = prime * result + ((getfFileName() == null) ? 0 : getfFileName().hashCode());
        result = prime * result + ((getfFileAddress() == null) ? 0 : getfFileAddress().hashCode());
        result = prime * result + ((getfManufacturerName() == null) ? 0 : getfManufacturerName().hashCode());
        result = prime * result + ((getfDeviceType() == null) ? 0 : getfDeviceType().hashCode());
        result = prime * result + ((getfHardwareVersion() == null) ? 0 : getfHardwareVersion().hashCode());
        result = prime * result + ((getfSoftwareVersion() == null) ? 0 : getfSoftwareVersion().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfUpdateFlag() == null) ? 0 : getfUpdateFlag().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fNumber=").append(fNumber);
        sb.append(", fFileName=").append(fFileName);
        sb.append(", fFileAddress=").append(fFileAddress);
        sb.append(", fManufacturerName=").append(fManufacturerName);
        sb.append(", fDeviceType=").append(fDeviceType);
        sb.append(", fHardwareVersion=").append(fHardwareVersion);
        sb.append(", fSoftwareVersion=").append(fSoftwareVersion);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fUpdateFlag=").append(fUpdateFlag);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}