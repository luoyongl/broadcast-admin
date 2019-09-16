package cn.wtu.broadcast.openapi.vo;


import cn.wtu.broadcast.openapi.model.BDeviceInfo;

import java.io.Serializable;

public class BDeviceInfoVo extends BDeviceInfo implements Serializable {

	private String fRealDeviceModel;

    private String fRealArea;
	
	private String fRealFacture;
	
	private String fCreatorName;
	
	private String fOperatorName;
	
	public String getfOperatorName() {
		return fOperatorName;
	}

	public void setfOperatorName(String fOperatorName) {
		this.fOperatorName = fOperatorName;
	}

	private String fRealProtocol;
    
    public String getfRealProtocol() {
		return fRealProtocol;
	}

	public void setfRealProtocol(String fRealProtocol) {
		this.fRealProtocol = fRealProtocol;
	}

	public String getfCreatorName() {
		return fCreatorName;
	}

	public void setfCreatorName(String fCreatorName) {
		this.fCreatorName = fCreatorName;
	}

	public String getfRealFacture() {
		return fRealFacture;
	}

	public void setfRealFacture(String fRealFacture) {
		this.fRealFacture = fRealFacture;
	}

	public String getfRealArea() {
		return fRealArea;
	}

	public void setfRealArea(String fRealArea) {
		this.fRealArea = fRealArea;
	}

	public String getfRealDeviceModel() {
		return fRealDeviceModel;
	}

	public void setfRealDeviceModel(String fRealDeviceModel) {
		this.fRealDeviceModel = fRealDeviceModel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

    
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
        BDeviceInfoVo other = (BDeviceInfoVo) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfDeviceType() == null ? other.getfDeviceType() == null : this.getfDeviceType().equals(other.getfDeviceType()))
            && (this.getfNumber() == null ? other.getfNumber() == null : this.getfNumber().equals(other.getfNumber()))
            && (this.getfDeviceImage() == null ? other.getfDeviceImage() == null : this.getfDeviceImage().equals(other.getfDeviceImage()))
            && (this.getfDeviceName() == null ? other.getfDeviceName() == null : this.getfDeviceName().equals(other.getfDeviceName()))
            && (this.getfDeviceIp() == null ? other.getfDeviceIp() == null : this.getfDeviceIp().equals(other.getfDeviceIp()))
            && (this.getfDevicePort() == null ? other.getfDevicePort() == null : this.getfDevicePort().equals(other.getfDevicePort()))
            && (this.getfDeviceModel() == null ? other.getfDeviceModel() == null : this.getfDeviceModel().equals(other.getfDeviceModel()))
            && (this.getfPhysicalCode() == null ? other.getfPhysicalCode() == null : this.getfPhysicalCode().equals(other.getfPhysicalCode()))
            && (this.getfLocation() == null ? other.getfLocation() == null : this.getfLocation().equals(other.getfLocation()))
            && (this.getfInstallAddress() == null ? other.getfInstallAddress() == null : this.getfInstallAddress().equals(other.getfInstallAddress()))
            && (this.getfLongitude() == null ? other.getfLongitude() == null : this.getfLongitude().equals(other.getfLongitude()))
            && (this.getfDimension() == null ? other.getfDimension() == null : this.getfDimension().equals(other.getfDimension()))
            && (this.getfUrl() == null ? other.getfUrl() == null : this.getfUrl().equals(other.getfUrl()))
            && (this.getfEnableState() == null ? other.getfEnableState() == null : this.getfEnableState().equals(other.getfEnableState()))
            && (this.getfDeviceBand() == null ? other.getfDeviceBand() == null : this.getfDeviceBand().equals(other.getfDeviceBand()))
            && (this.getfAcceptCommandPid() == null ? other.getfAcceptCommandPid() == null : this.getfAcceptCommandPid().equals(other.getfAcceptCommandPid()))
            && (this.getfDisplayLevel() == null ? other.getfDisplayLevel() == null : this.getfDisplayLevel().equals(other.getfDisplayLevel()))
            && (this.getfDeviceResourceCode() == null ? other.getfDeviceResourceCode() == null : this.getfDeviceResourceCode().equals(other.getfDeviceResourceCode()))
            && (this.getfRemark() == null ? other.getfRemark() == null : this.getfRemark().equals(other.getfRemark()))
            && (this.getfCertificate() == null ? other.getfCertificate() == null : this.getfCertificate().equals(other.getfCertificate()))
            && (this.getfSchemeType() == null ? other.getfSchemeType() == null : this.getfSchemeType().equals(other.getfSchemeType()))
            && (this.getfMaintainer() == null ? other.getfMaintainer() == null : this.getfMaintainer().equals(other.getfMaintainer()))
            && (this.getfProtocolType() == null ? other.getfProtocolType() == null : this.getfProtocolType().equals(other.getfProtocolType()))
            && (this.getfManufacturerInfo() == null ? other.getfManufacturerInfo() == null : this.getfManufacturerInfo().equals(other.getfManufacturerInfo()))
            && (this.getfNvr() == null ? other.getfNvr() == null : this.getfNvr().equals(other.getfNvr()))
            && (this.getfChannelModel() == null ? other.getfChannelModel() == null : this.getfChannelModel().equals(other.getfChannelModel()))
            && (this.getfLoginName() == null ? other.getfLoginName() == null : this.getfLoginName().equals(other.getfLoginName()))
            && (this.getfLoginPassword() == null ? other.getfLoginPassword() == null : this.getfLoginPassword().equals(other.getfLoginPassword()))
            && (this.getfChannelContent() == null ? other.getfChannelContent() == null : this.getfChannelContent().equals(other.getfChannelContent()))
            && (this.getfChannelNumber() == null ? other.getfChannelNumber() == null : this.getfChannelNumber().equals(other.getfChannelNumber()))
            && (this.getfDeviceState() == null ? other.getfDeviceState() == null : this.getfDeviceState().equals(other.getfDeviceState()))
            && (this.getfHardwareVersion() == null ? other.getfHardwareVersion() == null : this.getfHardwareVersion().equals(other.getfHardwareVersion()))
            && (this.getfSoftwareVersion() == null ? other.getfSoftwareVersion() == null : this.getfSoftwareVersion().equals(other.getfSoftwareVersion()))
            && (this.getfPower() == null ? other.getfPower() == null : this.getfPower().equals(other.getfPower()))
            && (this.getfPowerCurrent() == null ? other.getfPowerCurrent() == null : this.getfPowerCurrent().equals(other.getfPowerCurrent()))
            && (this.getfVoltage() == null ? other.getfVoltage() == null : this.getfVoltage().equals(other.getfVoltage()))
            && (this.getfRfLevel() == null ? other.getfRfLevel() == null : this.getfRfLevel().equals(other.getfRfLevel()))
            && (this.getfResCoding() == null ? other.getfResCoding() == null : this.getfResCoding().equals(other.getfResCoding()))
            && (this.getfResTypeCode() == null ? other.getfResTypeCode() == null : this.getfResTypeCode().equals(other.getfResTypeCode()))
            && (this.getfResTypeSequenceCode() == null ? other.getfResTypeSequenceCode() == null : this.getfResTypeSequenceCode().equals(other.getfResTypeSequenceCode()))
            && (this.getfResSubtypeCode() == null ? other.getfResSubtypeCode() == null : this.getfResSubtypeCode().equals(other.getfResSubtypeCode()))
            && (this.getfResSubtypeSequenceCode() == null ? other.getfResSubtypeSequenceCode() == null : this.getfResSubtypeSequenceCode().equals(other.getfResSubtypeSequenceCode()))
            && (this.getfSupportIpFlag() == null ? other.getfSupportIpFlag() == null : this.getfSupportIpFlag().equals(other.getfSupportIpFlag()))
            && (this.getfSupportRdsFlag() == null ? other.getfSupportRdsFlag() == null : this.getfSupportRdsFlag().equals(other.getfSupportRdsFlag()))
            && (this.getfSupportDtmbTsFlag() == null ? other.getfSupportDtmbTsFlag() == null : this.getfSupportDtmbTsFlag().equals(other.getfSupportDtmbTsFlag()))
            && (this.getfSupportDvbcTsFlag() == null ? other.getfSupportDvbcTsFlag() == null : this.getfSupportDvbcTsFlag().equals(other.getfSupportDvbcTsFlag()))
            && (this.getfSort() == null ? other.getfSort() == null : this.getfSort().equals(other.getfSort()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfBackTime() == null ? other.getfBackTime() == null : this.getfBackTime().equals(other.getfBackTime()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfDeviceType() == null) ? 0 : getfDeviceType().hashCode());
        result = prime * result + ((getfNumber() == null) ? 0 : getfNumber().hashCode());
        result = prime * result + ((getfDeviceImage() == null) ? 0 : getfDeviceImage().hashCode());
        result = prime * result + ((getfDeviceName() == null) ? 0 : getfDeviceName().hashCode());
        result = prime * result + ((getfDeviceIp() == null) ? 0 : getfDeviceIp().hashCode());
        result = prime * result + ((getfDevicePort() == null) ? 0 : getfDevicePort().hashCode());
        result = prime * result + ((getfDeviceModel() == null) ? 0 : getfDeviceModel().hashCode());
        result = prime * result + ((getfPhysicalCode() == null) ? 0 : getfPhysicalCode().hashCode());
        result = prime * result + ((getfLocation() == null) ? 0 : getfLocation().hashCode());
        result = prime * result + ((getfInstallAddress() == null) ? 0 : getfInstallAddress().hashCode());
        result = prime * result + ((getfLongitude() == null) ? 0 : getfLongitude().hashCode());
        result = prime * result + ((getfDimension() == null) ? 0 : getfDimension().hashCode());
        result = prime * result + ((getfUrl() == null) ? 0 : getfUrl().hashCode());
        result = prime * result + ((getfEnableState() == null) ? 0 : getfEnableState().hashCode());
        result = prime * result + ((getfDeviceBand() == null) ? 0 : getfDeviceBand().hashCode());
        result = prime * result + ((getfAcceptCommandPid() == null) ? 0 : getfAcceptCommandPid().hashCode());
        result = prime * result + ((getfDisplayLevel() == null) ? 0 : getfDisplayLevel().hashCode());
        result = prime * result + ((getfDeviceResourceCode() == null) ? 0 : getfDeviceResourceCode().hashCode());
        result = prime * result + ((getfRemark() == null) ? 0 : getfRemark().hashCode());
        result = prime * result + ((getfCertificate() == null) ? 0 : getfCertificate().hashCode());
        result = prime * result + ((getfSchemeType() == null) ? 0 : getfSchemeType().hashCode());
        result = prime * result + ((getfMaintainer() == null) ? 0 : getfMaintainer().hashCode());
        result = prime * result + ((getfProtocolType() == null) ? 0 : getfProtocolType().hashCode());
        result = prime * result + ((getfManufacturerInfo() == null) ? 0 : getfManufacturerInfo().hashCode());
        result = prime * result + ((getfNvr() == null) ? 0 : getfNvr().hashCode());
        result = prime * result + ((getfChannelModel() == null) ? 0 : getfChannelModel().hashCode());
        result = prime * result + ((getfLoginName() == null) ? 0 : getfLoginName().hashCode());
        result = prime * result + ((getfLoginPassword() == null) ? 0 : getfLoginPassword().hashCode());
        result = prime * result + ((getfChannelContent() == null) ? 0 : getfChannelContent().hashCode());
        result = prime * result + ((getfChannelNumber() == null) ? 0 : getfChannelNumber().hashCode());
        result = prime * result + ((getfDeviceState() == null) ? 0 : getfDeviceState().hashCode());
        result = prime * result + ((getfHardwareVersion() == null) ? 0 : getfHardwareVersion().hashCode());
        result = prime * result + ((getfSoftwareVersion() == null) ? 0 : getfSoftwareVersion().hashCode());
        result = prime * result + ((getfPower() == null) ? 0 : getfPower().hashCode());
        result = prime * result + ((getfVoltage() == null) ? 0 : getfVoltage().hashCode());
        result = prime * result + ((getfRfLevel() == null) ? 0 : getfRfLevel().hashCode());
        result = prime * result + ((getfResCoding() == null) ? 0 : getfResCoding().hashCode());
        result = prime * result + ((getfResTypeCode() == null) ? 0 : getfResTypeCode().hashCode());
        result = prime * result + ((getfResTypeSequenceCode() == null) ? 0 : getfResTypeSequenceCode().hashCode());
        result = prime * result + ((getfResSubtypeCode() == null) ? 0 : getfResSubtypeCode().hashCode());
        result = prime * result + ((getfResSubtypeSequenceCode() == null) ? 0 : getfResSubtypeSequenceCode().hashCode());
        result = prime * result + ((getfSupportIpFlag() == null) ? 0 : getfSupportIpFlag().hashCode());
        result = prime * result + ((getfSupportRdsFlag() == null) ? 0 : getfSupportRdsFlag().hashCode());
        result = prime * result + ((getfSupportDtmbTsFlag() == null) ? 0 : getfSupportDtmbTsFlag().hashCode());
        result = prime * result + ((getfSupportDvbcTsFlag() == null) ? 0 : getfSupportDvbcTsFlag().hashCode());
        result = prime * result + ((getfSort() == null) ? 0 : getfSort().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfBackTime() == null) ? 0 : getfBackTime().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        return result;
    }


}