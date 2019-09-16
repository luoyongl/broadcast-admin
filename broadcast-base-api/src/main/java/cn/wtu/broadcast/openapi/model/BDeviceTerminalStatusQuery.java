package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;

public class BDeviceTerminalStatusQuery implements Serializable {
    private Integer fId;

    private Integer fDeviceId;

    private Integer fTerminalVolume;

    private String fLocalAddress;

    private String fReturnAddress;

    private String fTerminalResourceCode;

    private String fPhysicalAddressCode;

    private String fWorkingCondition;

    private String fFaultCode;

    private String fDeviceType;

    private String fHardwareVersionNumber;

    private String fSoftwareVersionNumber;

    private String fFmSignalStatus;

    private String fCableSignalStatus;

    private String fGroundWirelessSignalStatus;

    private String fCableFrequency;

    private String fGroundWirelessFrequency;

    private String fFmFrequencyScanList;

    private String fFmCurrentFrequencyPoint;

    private String fFmMaintenanceInstructionMode;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfDeviceId() {
        return fDeviceId;
    }

    public void setfDeviceId(Integer fDeviceId) {
        this.fDeviceId = fDeviceId;
    }

    public Integer getfTerminalVolume() {
        return fTerminalVolume;
    }

    public void setfTerminalVolume(Integer fTerminalVolume) {
        this.fTerminalVolume = fTerminalVolume;
    }

    public String getfLocalAddress() {
        return fLocalAddress;
    }

    public void setfLocalAddress(String fLocalAddress) {
        this.fLocalAddress = fLocalAddress == null ? null : fLocalAddress.trim();
    }

    public String getfReturnAddress() {
        return fReturnAddress;
    }

    public void setfReturnAddress(String fReturnAddress) {
        this.fReturnAddress = fReturnAddress == null ? null : fReturnAddress.trim();
    }

    public String getfTerminalResourceCode() {
        return fTerminalResourceCode;
    }

    public void setfTerminalResourceCode(String fTerminalResourceCode) {
        this.fTerminalResourceCode = fTerminalResourceCode == null ? null : fTerminalResourceCode.trim();
    }

    public String getfPhysicalAddressCode() {
        return fPhysicalAddressCode;
    }

    public void setfPhysicalAddressCode(String fPhysicalAddressCode) {
        this.fPhysicalAddressCode = fPhysicalAddressCode == null ? null : fPhysicalAddressCode.trim();
    }

    public String getfWorkingCondition() {
        return fWorkingCondition;
    }

    public void setfWorkingCondition(String fWorkingCondition) {
        this.fWorkingCondition = fWorkingCondition == null ? null : fWorkingCondition.trim();
    }

    public String getfFaultCode() {
        return fFaultCode;
    }

    public void setfFaultCode(String fFaultCode) {
        this.fFaultCode = fFaultCode == null ? null : fFaultCode.trim();
    }

    public String getfDeviceType() {
        return fDeviceType;
    }

    public void setfDeviceType(String fDeviceType) {
        this.fDeviceType = fDeviceType == null ? null : fDeviceType.trim();
    }

    public String getfHardwareVersionNumber() {
        return fHardwareVersionNumber;
    }

    public void setfHardwareVersionNumber(String fHardwareVersionNumber) {
        this.fHardwareVersionNumber = fHardwareVersionNumber == null ? null : fHardwareVersionNumber.trim();
    }

    public String getfSoftwareVersionNumber() {
        return fSoftwareVersionNumber;
    }

    public void setfSoftwareVersionNumber(String fSoftwareVersionNumber) {
        this.fSoftwareVersionNumber = fSoftwareVersionNumber == null ? null : fSoftwareVersionNumber.trim();
    }

    public String getfFmSignalStatus() {
        return fFmSignalStatus;
    }

    public void setfFmSignalStatus(String fFmSignalStatus) {
        this.fFmSignalStatus = fFmSignalStatus == null ? null : fFmSignalStatus.trim();
    }

    public String getfCableSignalStatus() {
        return fCableSignalStatus;
    }

    public void setfCableSignalStatus(String fCableSignalStatus) {
        this.fCableSignalStatus = fCableSignalStatus == null ? null : fCableSignalStatus.trim();
    }

    public String getfGroundWirelessSignalStatus() {
        return fGroundWirelessSignalStatus;
    }

    public void setfGroundWirelessSignalStatus(String fGroundWirelessSignalStatus) {
        this.fGroundWirelessSignalStatus = fGroundWirelessSignalStatus == null ? null : fGroundWirelessSignalStatus.trim();
    }

    public String getfCableFrequency() {
        return fCableFrequency;
    }

    public void setfCableFrequency(String fCableFrequency) {
        this.fCableFrequency = fCableFrequency == null ? null : fCableFrequency.trim();
    }

    public String getfGroundWirelessFrequency() {
        return fGroundWirelessFrequency;
    }

    public void setfGroundWirelessFrequency(String fGroundWirelessFrequency) {
        this.fGroundWirelessFrequency = fGroundWirelessFrequency == null ? null : fGroundWirelessFrequency.trim();
    }

    public String getfFmFrequencyScanList() {
        return fFmFrequencyScanList;
    }

    public void setfFmFrequencyScanList(String fFmFrequencyScanList) {
        this.fFmFrequencyScanList = fFmFrequencyScanList == null ? null : fFmFrequencyScanList.trim();
    }

    public String getfFmCurrentFrequencyPoint() {
        return fFmCurrentFrequencyPoint;
    }

    public void setfFmCurrentFrequencyPoint(String fFmCurrentFrequencyPoint) {
        this.fFmCurrentFrequencyPoint = fFmCurrentFrequencyPoint == null ? null : fFmCurrentFrequencyPoint.trim();
    }

    public String getfFmMaintenanceInstructionMode() {
        return fFmMaintenanceInstructionMode;
    }

    public void setfFmMaintenanceInstructionMode(String fFmMaintenanceInstructionMode) {
        this.fFmMaintenanceInstructionMode = fFmMaintenanceInstructionMode == null ? null : fFmMaintenanceInstructionMode.trim();
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
        BDeviceTerminalStatusQuery other = (BDeviceTerminalStatusQuery) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfDeviceId() == null ? other.getfDeviceId() == null : this.getfDeviceId().equals(other.getfDeviceId()))
            && (this.getfTerminalVolume() == null ? other.getfTerminalVolume() == null : this.getfTerminalVolume().equals(other.getfTerminalVolume()))
            && (this.getfLocalAddress() == null ? other.getfLocalAddress() == null : this.getfLocalAddress().equals(other.getfLocalAddress()))
            && (this.getfReturnAddress() == null ? other.getfReturnAddress() == null : this.getfReturnAddress().equals(other.getfReturnAddress()))
            && (this.getfTerminalResourceCode() == null ? other.getfTerminalResourceCode() == null : this.getfTerminalResourceCode().equals(other.getfTerminalResourceCode()))
            && (this.getfPhysicalAddressCode() == null ? other.getfPhysicalAddressCode() == null : this.getfPhysicalAddressCode().equals(other.getfPhysicalAddressCode()))
            && (this.getfWorkingCondition() == null ? other.getfWorkingCondition() == null : this.getfWorkingCondition().equals(other.getfWorkingCondition()))
            && (this.getfFaultCode() == null ? other.getfFaultCode() == null : this.getfFaultCode().equals(other.getfFaultCode()))
            && (this.getfDeviceType() == null ? other.getfDeviceType() == null : this.getfDeviceType().equals(other.getfDeviceType()))
            && (this.getfHardwareVersionNumber() == null ? other.getfHardwareVersionNumber() == null : this.getfHardwareVersionNumber().equals(other.getfHardwareVersionNumber()))
            && (this.getfSoftwareVersionNumber() == null ? other.getfSoftwareVersionNumber() == null : this.getfSoftwareVersionNumber().equals(other.getfSoftwareVersionNumber()))
            && (this.getfFmSignalStatus() == null ? other.getfFmSignalStatus() == null : this.getfFmSignalStatus().equals(other.getfFmSignalStatus()))
            && (this.getfCableSignalStatus() == null ? other.getfCableSignalStatus() == null : this.getfCableSignalStatus().equals(other.getfCableSignalStatus()))
            && (this.getfGroundWirelessSignalStatus() == null ? other.getfGroundWirelessSignalStatus() == null : this.getfGroundWirelessSignalStatus().equals(other.getfGroundWirelessSignalStatus()))
            && (this.getfCableFrequency() == null ? other.getfCableFrequency() == null : this.getfCableFrequency().equals(other.getfCableFrequency()))
            && (this.getfGroundWirelessFrequency() == null ? other.getfGroundWirelessFrequency() == null : this.getfGroundWirelessFrequency().equals(other.getfGroundWirelessFrequency()))
            && (this.getfFmFrequencyScanList() == null ? other.getfFmFrequencyScanList() == null : this.getfFmFrequencyScanList().equals(other.getfFmFrequencyScanList()))
            && (this.getfFmCurrentFrequencyPoint() == null ? other.getfFmCurrentFrequencyPoint() == null : this.getfFmCurrentFrequencyPoint().equals(other.getfFmCurrentFrequencyPoint()))
            && (this.getfFmMaintenanceInstructionMode() == null ? other.getfFmMaintenanceInstructionMode() == null : this.getfFmMaintenanceInstructionMode().equals(other.getfFmMaintenanceInstructionMode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfDeviceId() == null) ? 0 : getfDeviceId().hashCode());
        result = prime * result + ((getfTerminalVolume() == null) ? 0 : getfTerminalVolume().hashCode());
        result = prime * result + ((getfLocalAddress() == null) ? 0 : getfLocalAddress().hashCode());
        result = prime * result + ((getfReturnAddress() == null) ? 0 : getfReturnAddress().hashCode());
        result = prime * result + ((getfTerminalResourceCode() == null) ? 0 : getfTerminalResourceCode().hashCode());
        result = prime * result + ((getfPhysicalAddressCode() == null) ? 0 : getfPhysicalAddressCode().hashCode());
        result = prime * result + ((getfWorkingCondition() == null) ? 0 : getfWorkingCondition().hashCode());
        result = prime * result + ((getfFaultCode() == null) ? 0 : getfFaultCode().hashCode());
        result = prime * result + ((getfDeviceType() == null) ? 0 : getfDeviceType().hashCode());
        result = prime * result + ((getfHardwareVersionNumber() == null) ? 0 : getfHardwareVersionNumber().hashCode());
        result = prime * result + ((getfSoftwareVersionNumber() == null) ? 0 : getfSoftwareVersionNumber().hashCode());
        result = prime * result + ((getfFmSignalStatus() == null) ? 0 : getfFmSignalStatus().hashCode());
        result = prime * result + ((getfCableSignalStatus() == null) ? 0 : getfCableSignalStatus().hashCode());
        result = prime * result + ((getfGroundWirelessSignalStatus() == null) ? 0 : getfGroundWirelessSignalStatus().hashCode());
        result = prime * result + ((getfCableFrequency() == null) ? 0 : getfCableFrequency().hashCode());
        result = prime * result + ((getfGroundWirelessFrequency() == null) ? 0 : getfGroundWirelessFrequency().hashCode());
        result = prime * result + ((getfFmFrequencyScanList() == null) ? 0 : getfFmFrequencyScanList().hashCode());
        result = prime * result + ((getfFmCurrentFrequencyPoint() == null) ? 0 : getfFmCurrentFrequencyPoint().hashCode());
        result = prime * result + ((getfFmMaintenanceInstructionMode() == null) ? 0 : getfFmMaintenanceInstructionMode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fDeviceId=").append(fDeviceId);
        sb.append(", fTerminalVolume=").append(fTerminalVolume);
        sb.append(", fLocalAddress=").append(fLocalAddress);
        sb.append(", fReturnAddress=").append(fReturnAddress);
        sb.append(", fTerminalResourceCode=").append(fTerminalResourceCode);
        sb.append(", fPhysicalAddressCode=").append(fPhysicalAddressCode);
        sb.append(", fWorkingCondition=").append(fWorkingCondition);
        sb.append(", fFaultCode=").append(fFaultCode);
        sb.append(", fDeviceType=").append(fDeviceType);
        sb.append(", fHardwareVersionNumber=").append(fHardwareVersionNumber);
        sb.append(", fSoftwareVersionNumber=").append(fSoftwareVersionNumber);
        sb.append(", fFmSignalStatus=").append(fFmSignalStatus);
        sb.append(", fCableSignalStatus=").append(fCableSignalStatus);
        sb.append(", fGroundWirelessSignalStatus=").append(fGroundWirelessSignalStatus);
        sb.append(", fCableFrequency=").append(fCableFrequency);
        sb.append(", fGroundWirelessFrequency=").append(fGroundWirelessFrequency);
        sb.append(", fFmFrequencyScanList=").append(fFmFrequencyScanList);
        sb.append(", fFmCurrentFrequencyPoint=").append(fFmCurrentFrequencyPoint);
        sb.append(", fFmMaintenanceInstructionMode=").append(fFmMaintenanceInstructionMode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}