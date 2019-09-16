package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BDeviceInfo implements Serializable {
    private Integer fId;

    private Byte fDeviceType;

    private String fDeviceName;

    private String fDeviceResourceCode;

    private String fDeviceState;

    private String fNumber;

    private String fDeviceImage;

    private String fDeviceIp;

    private String fDevicePort;

    private String fDeviceModel;

    private String fPhysicalCode;

    private Integer fLocation;

    private String fInstallAddress;

    private String fLongitude;

    private String fDimension;

    private String fUrl;

    private Boolean fEnableState;

    private String fDeviceBand;

    private String fAcceptCommandPid;

    private String fDisplayLevel;

    private String fRemark;

    private String fCertificate;

    private String fSchemeType;

    private String fMaintainer;

    private String fProtocolType;

    private String fManufacturerInfo;

    private Integer fNvr;

    private String fChannelModel;

    private String fLoginName;

    private String fLoginPassword;

    private String fChannelContent;

    private String fChannelNumber;

    private String fHardwareVersion;

    private String fSoftwareVersion;

    private String fPower;

    private String fVoltage;

    private String fRfLevel;

    private String fResCoding;

    private String fResTypeCode;

    private String fResTypeSequenceCode;

    private String fResSubtypeCode;

    private String fResSubtypeSequenceCode;

    private Boolean fSupportIpFlag;

    private Boolean fSupportRdsFlag;

    private Boolean fSupportDtmbTsFlag;

    private Boolean fSupportDvbcTsFlag;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private Date fBackTime;

    private String fLogicCode;

    private String fBackMode;

    private String fNetworkMode;

    private String fPowerCurrent;

    private String fBroadcastState;

    private String fDeviceVolume;

    private String fDigitalTelevisionRadioMode;

    private String fDigitalTelevisionRadioRate;

    private String fQma;

    private String fDigitalTelevisionSignalQuality;

    private String fSignalRateList;

    private String fSignalStrengthList;

    private String fDigitalTelevisionSignalStrength;

    private String fCode;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Byte getfDeviceType() {
        return fDeviceType;
    }

    public void setfDeviceType(Byte fDeviceType) {
        this.fDeviceType = fDeviceType;
    }

    public String getfDeviceName() {
        return fDeviceName;
    }

    public void setfDeviceName(String fDeviceName) {
        this.fDeviceName = fDeviceName == null ? null : fDeviceName.trim();
    }

    public String getfDeviceResourceCode() {
        return fDeviceResourceCode;
    }

    public void setfDeviceResourceCode(String fDeviceResourceCode) {
        this.fDeviceResourceCode = fDeviceResourceCode == null ? null : fDeviceResourceCode.trim();
    }

    public String getfDeviceState() {
        return fDeviceState;
    }

    public void setfDeviceState(String fDeviceState) {
        this.fDeviceState = fDeviceState == null ? null : fDeviceState.trim();
    }

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber == null ? null : fNumber.trim();
    }

    public String getfDeviceImage() {
        return fDeviceImage;
    }

    public void setfDeviceImage(String fDeviceImage) {
        this.fDeviceImage = fDeviceImage == null ? null : fDeviceImage.trim();
    }

    public String getfDeviceIp() {
        return fDeviceIp;
    }

    public void setfDeviceIp(String fDeviceIp) {
        this.fDeviceIp = fDeviceIp == null ? null : fDeviceIp.trim();
    }

    public String getfDevicePort() {
        return fDevicePort;
    }

    public void setfDevicePort(String fDevicePort) {
        this.fDevicePort = fDevicePort == null ? null : fDevicePort.trim();
    }

    public String getfDeviceModel() {
        return fDeviceModel;
    }

    public void setfDeviceModel(String fDeviceModel) {
        this.fDeviceModel = fDeviceModel == null ? null : fDeviceModel.trim();
    }

    public String getfPhysicalCode() {
        return fPhysicalCode;
    }

    public void setfPhysicalCode(String fPhysicalCode) {
        this.fPhysicalCode = fPhysicalCode == null ? null : fPhysicalCode.trim();
    }

    public Integer getfLocation() {
        return fLocation;
    }

    public void setfLocation(Integer fLocation) {
        this.fLocation = fLocation;
    }

    public String getfInstallAddress() {
        return fInstallAddress;
    }

    public void setfInstallAddress(String fInstallAddress) {
        this.fInstallAddress = fInstallAddress == null ? null : fInstallAddress.trim();
    }

    public String getfLongitude() {
        return fLongitude;
    }

    public void setfLongitude(String fLongitude) {
        this.fLongitude = fLongitude == null ? null : fLongitude.trim();
    }

    public String getfDimension() {
        return fDimension;
    }

    public void setfDimension(String fDimension) {
        this.fDimension = fDimension == null ? null : fDimension.trim();
    }

    public String getfUrl() {
        return fUrl;
    }

    public void setfUrl(String fUrl) {
        this.fUrl = fUrl == null ? null : fUrl.trim();
    }

    public Boolean getfEnableState() {
        return fEnableState;
    }

    public void setfEnableState(Boolean fEnableState) {
        this.fEnableState = fEnableState;
    }

    public String getfDeviceBand() {
        return fDeviceBand;
    }

    public void setfDeviceBand(String fDeviceBand) {
        this.fDeviceBand = fDeviceBand == null ? null : fDeviceBand.trim();
    }

    public String getfAcceptCommandPid() {
        return fAcceptCommandPid;
    }

    public void setfAcceptCommandPid(String fAcceptCommandPid) {
        this.fAcceptCommandPid = fAcceptCommandPid == null ? null : fAcceptCommandPid.trim();
    }

    public String getfDisplayLevel() {
        return fDisplayLevel;
    }

    public void setfDisplayLevel(String fDisplayLevel) {
        this.fDisplayLevel = fDisplayLevel == null ? null : fDisplayLevel.trim();
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
    }

    public String getfCertificate() {
        return fCertificate;
    }

    public void setfCertificate(String fCertificate) {
        this.fCertificate = fCertificate == null ? null : fCertificate.trim();
    }

    public String getfSchemeType() {
        return fSchemeType;
    }

    public void setfSchemeType(String fSchemeType) {
        this.fSchemeType = fSchemeType == null ? null : fSchemeType.trim();
    }

    public String getfMaintainer() {
        return fMaintainer;
    }

    public void setfMaintainer(String fMaintainer) {
        this.fMaintainer = fMaintainer == null ? null : fMaintainer.trim();
    }

    public String getfProtocolType() {
        return fProtocolType;
    }

    public void setfProtocolType(String fProtocolType) {
        this.fProtocolType = fProtocolType == null ? null : fProtocolType.trim();
    }

    public String getfManufacturerInfo() {
        return fManufacturerInfo;
    }

    public void setfManufacturerInfo(String fManufacturerInfo) {
        this.fManufacturerInfo = fManufacturerInfo == null ? null : fManufacturerInfo.trim();
    }

    public Integer getfNvr() {
        return fNvr;
    }

    public void setfNvr(Integer fNvr) {
        this.fNvr = fNvr;
    }

    public String getfChannelModel() {
        return fChannelModel;
    }

    public void setfChannelModel(String fChannelModel) {
        this.fChannelModel = fChannelModel == null ? null : fChannelModel.trim();
    }

    public String getfLoginName() {
        return fLoginName;
    }

    public void setfLoginName(String fLoginName) {
        this.fLoginName = fLoginName == null ? null : fLoginName.trim();
    }

    public String getfLoginPassword() {
        return fLoginPassword;
    }

    public void setfLoginPassword(String fLoginPassword) {
        this.fLoginPassword = fLoginPassword == null ? null : fLoginPassword.trim();
    }

    public String getfChannelContent() {
        return fChannelContent;
    }

    public void setfChannelContent(String fChannelContent) {
        this.fChannelContent = fChannelContent == null ? null : fChannelContent.trim();
    }

    public String getfChannelNumber() {
        return fChannelNumber;
    }

    public void setfChannelNumber(String fChannelNumber) {
        this.fChannelNumber = fChannelNumber == null ? null : fChannelNumber.trim();
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

    public String getfPower() {
        return fPower;
    }

    public void setfPower(String fPower) {
        this.fPower = fPower == null ? null : fPower.trim();
    }

    public String getfVoltage() {
        return fVoltage;
    }

    public void setfVoltage(String fVoltage) {
        this.fVoltage = fVoltage == null ? null : fVoltage.trim();
    }

    public String getfRfLevel() {
        return fRfLevel;
    }

    public void setfRfLevel(String fRfLevel) {
        this.fRfLevel = fRfLevel == null ? null : fRfLevel.trim();
    }

    public String getfResCoding() {
        return fResCoding;
    }

    public void setfResCoding(String fResCoding) {
        this.fResCoding = fResCoding == null ? null : fResCoding.trim();
    }

    public String getfResTypeCode() {
        return fResTypeCode;
    }

    public void setfResTypeCode(String fResTypeCode) {
        this.fResTypeCode = fResTypeCode == null ? null : fResTypeCode.trim();
    }

    public String getfResTypeSequenceCode() {
        return fResTypeSequenceCode;
    }

    public void setfResTypeSequenceCode(String fResTypeSequenceCode) {
        this.fResTypeSequenceCode = fResTypeSequenceCode == null ? null : fResTypeSequenceCode.trim();
    }

    public String getfResSubtypeCode() {
        return fResSubtypeCode;
    }

    public void setfResSubtypeCode(String fResSubtypeCode) {
        this.fResSubtypeCode = fResSubtypeCode == null ? null : fResSubtypeCode.trim();
    }

    public String getfResSubtypeSequenceCode() {
        return fResSubtypeSequenceCode;
    }

    public void setfResSubtypeSequenceCode(String fResSubtypeSequenceCode) {
        this.fResSubtypeSequenceCode = fResSubtypeSequenceCode == null ? null : fResSubtypeSequenceCode.trim();
    }

    public Boolean getfSupportIpFlag() {
        return fSupportIpFlag;
    }

    public void setfSupportIpFlag(Boolean fSupportIpFlag) {
        this.fSupportIpFlag = fSupportIpFlag;
    }

    public Boolean getfSupportRdsFlag() {
        return fSupportRdsFlag;
    }

    public void setfSupportRdsFlag(Boolean fSupportRdsFlag) {
        this.fSupportRdsFlag = fSupportRdsFlag;
    }

    public Boolean getfSupportDtmbTsFlag() {
        return fSupportDtmbTsFlag;
    }

    public void setfSupportDtmbTsFlag(Boolean fSupportDtmbTsFlag) {
        this.fSupportDtmbTsFlag = fSupportDtmbTsFlag;
    }

    public Boolean getfSupportDvbcTsFlag() {
        return fSupportDvbcTsFlag;
    }

    public void setfSupportDvbcTsFlag(Boolean fSupportDvbcTsFlag) {
        this.fSupportDvbcTsFlag = fSupportDvbcTsFlag;
    }

    public Byte getfSort() {
        return fSort;
    }

    public void setfSort(Byte fSort) {
        this.fSort = fSort;
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

    public Boolean getfDeleteFlag() {
        return fDeleteFlag;
    }

    public void setfDeleteFlag(Boolean fDeleteFlag) {
        this.fDeleteFlag = fDeleteFlag;
    }

    public Date getfBackTime() {
        return fBackTime;
    }

    public void setfBackTime(Date fBackTime) {
        this.fBackTime = fBackTime;
    }

    public String getfLogicCode() {
        return fLogicCode;
    }

    public void setfLogicCode(String fLogicCode) {
        this.fLogicCode = fLogicCode == null ? null : fLogicCode.trim();
    }

    public String getfBackMode() {
        return fBackMode;
    }

    public void setfBackMode(String fBackMode) {
        this.fBackMode = fBackMode == null ? null : fBackMode.trim();
    }

    public String getfNetworkMode() {
        return fNetworkMode;
    }

    public void setfNetworkMode(String fNetworkMode) {
        this.fNetworkMode = fNetworkMode == null ? null : fNetworkMode.trim();
    }

    public String getfPowerCurrent() {
        return fPowerCurrent;
    }

    public void setfPowerCurrent(String fPowerCurrent) {
        this.fPowerCurrent = fPowerCurrent == null ? null : fPowerCurrent.trim();
    }

    public String getfBroadcastState() {
        return fBroadcastState;
    }

    public void setfBroadcastState(String fBroadcastState) {
        this.fBroadcastState = fBroadcastState == null ? null : fBroadcastState.trim();
    }

    public String getfDeviceVolume() {
        return fDeviceVolume;
    }

    public void setfDeviceVolume(String fDeviceVolume) {
        this.fDeviceVolume = fDeviceVolume == null ? null : fDeviceVolume.trim();
    }

    public String getfDigitalTelevisionRadioMode() {
        return fDigitalTelevisionRadioMode;
    }

    public void setfDigitalTelevisionRadioMode(String fDigitalTelevisionRadioMode) {
        this.fDigitalTelevisionRadioMode = fDigitalTelevisionRadioMode == null ? null : fDigitalTelevisionRadioMode.trim();
    }

    public String getfDigitalTelevisionRadioRate() {
        return fDigitalTelevisionRadioRate;
    }

    public void setfDigitalTelevisionRadioRate(String fDigitalTelevisionRadioRate) {
        this.fDigitalTelevisionRadioRate = fDigitalTelevisionRadioRate == null ? null : fDigitalTelevisionRadioRate.trim();
    }

    public String getfQma() {
        return fQma;
    }

    public void setfQma(String fQma) {
        this.fQma = fQma == null ? null : fQma.trim();
    }

    public String getfDigitalTelevisionSignalQuality() {
        return fDigitalTelevisionSignalQuality;
    }

    public void setfDigitalTelevisionSignalQuality(String fDigitalTelevisionSignalQuality) {
        this.fDigitalTelevisionSignalQuality = fDigitalTelevisionSignalQuality == null ? null : fDigitalTelevisionSignalQuality.trim();
    }

    public String getfSignalRateList() {
        return fSignalRateList;
    }

    public void setfSignalRateList(String fSignalRateList) {
        this.fSignalRateList = fSignalRateList == null ? null : fSignalRateList.trim();
    }

    public String getfSignalStrengthList() {
        return fSignalStrengthList;
    }

    public void setfSignalStrengthList(String fSignalStrengthList) {
        this.fSignalStrengthList = fSignalStrengthList == null ? null : fSignalStrengthList.trim();
    }

    public String getfDigitalTelevisionSignalStrength() {
        return fDigitalTelevisionSignalStrength;
    }

    public void setfDigitalTelevisionSignalStrength(String fDigitalTelevisionSignalStrength) {
        this.fDigitalTelevisionSignalStrength = fDigitalTelevisionSignalStrength == null ? null : fDigitalTelevisionSignalStrength.trim();
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode == null ? null : fCode.trim();
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
        BDeviceInfo other = (BDeviceInfo) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfDeviceType() == null ? other.getfDeviceType() == null : this.getfDeviceType().equals(other.getfDeviceType()))
            && (this.getfDeviceName() == null ? other.getfDeviceName() == null : this.getfDeviceName().equals(other.getfDeviceName()))
            && (this.getfDeviceResourceCode() == null ? other.getfDeviceResourceCode() == null : this.getfDeviceResourceCode().equals(other.getfDeviceResourceCode()))
            && (this.getfDeviceState() == null ? other.getfDeviceState() == null : this.getfDeviceState().equals(other.getfDeviceState()))
            && (this.getfNumber() == null ? other.getfNumber() == null : this.getfNumber().equals(other.getfNumber()))
            && (this.getfDeviceImage() == null ? other.getfDeviceImage() == null : this.getfDeviceImage().equals(other.getfDeviceImage()))
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
            && (this.getfHardwareVersion() == null ? other.getfHardwareVersion() == null : this.getfHardwareVersion().equals(other.getfHardwareVersion()))
            && (this.getfSoftwareVersion() == null ? other.getfSoftwareVersion() == null : this.getfSoftwareVersion().equals(other.getfSoftwareVersion()))
            && (this.getfPower() == null ? other.getfPower() == null : this.getfPower().equals(other.getfPower()))
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
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()))
            && (this.getfBackTime() == null ? other.getfBackTime() == null : this.getfBackTime().equals(other.getfBackTime()))
            && (this.getfLogicCode() == null ? other.getfLogicCode() == null : this.getfLogicCode().equals(other.getfLogicCode()))
            && (this.getfBackMode() == null ? other.getfBackMode() == null : this.getfBackMode().equals(other.getfBackMode()))
            && (this.getfNetworkMode() == null ? other.getfNetworkMode() == null : this.getfNetworkMode().equals(other.getfNetworkMode()))
            && (this.getfPowerCurrent() == null ? other.getfPowerCurrent() == null : this.getfPowerCurrent().equals(other.getfPowerCurrent()))
            && (this.getfBroadcastState() == null ? other.getfBroadcastState() == null : this.getfBroadcastState().equals(other.getfBroadcastState()))
            && (this.getfDeviceVolume() == null ? other.getfDeviceVolume() == null : this.getfDeviceVolume().equals(other.getfDeviceVolume()))
            && (this.getfDigitalTelevisionRadioMode() == null ? other.getfDigitalTelevisionRadioMode() == null : this.getfDigitalTelevisionRadioMode().equals(other.getfDigitalTelevisionRadioMode()))
            && (this.getfDigitalTelevisionRadioRate() == null ? other.getfDigitalTelevisionRadioRate() == null : this.getfDigitalTelevisionRadioRate().equals(other.getfDigitalTelevisionRadioRate()))
            && (this.getfQma() == null ? other.getfQma() == null : this.getfQma().equals(other.getfQma()))
            && (this.getfDigitalTelevisionSignalQuality() == null ? other.getfDigitalTelevisionSignalQuality() == null : this.getfDigitalTelevisionSignalQuality().equals(other.getfDigitalTelevisionSignalQuality()))
            && (this.getfSignalRateList() == null ? other.getfSignalRateList() == null : this.getfSignalRateList().equals(other.getfSignalRateList()))
            && (this.getfSignalStrengthList() == null ? other.getfSignalStrengthList() == null : this.getfSignalStrengthList().equals(other.getfSignalStrengthList()))
            && (this.getfDigitalTelevisionSignalStrength() == null ? other.getfDigitalTelevisionSignalStrength() == null : this.getfDigitalTelevisionSignalStrength().equals(other.getfDigitalTelevisionSignalStrength()))
            && (this.getfCode() == null ? other.getfCode() == null : this.getfCode().equals(other.getfCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfDeviceType() == null) ? 0 : getfDeviceType().hashCode());
        result = prime * result + ((getfDeviceName() == null) ? 0 : getfDeviceName().hashCode());
        result = prime * result + ((getfDeviceResourceCode() == null) ? 0 : getfDeviceResourceCode().hashCode());
        result = prime * result + ((getfDeviceState() == null) ? 0 : getfDeviceState().hashCode());
        result = prime * result + ((getfNumber() == null) ? 0 : getfNumber().hashCode());
        result = prime * result + ((getfDeviceImage() == null) ? 0 : getfDeviceImage().hashCode());
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
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        result = prime * result + ((getfBackTime() == null) ? 0 : getfBackTime().hashCode());
        result = prime * result + ((getfLogicCode() == null) ? 0 : getfLogicCode().hashCode());
        result = prime * result + ((getfBackMode() == null) ? 0 : getfBackMode().hashCode());
        result = prime * result + ((getfNetworkMode() == null) ? 0 : getfNetworkMode().hashCode());
        result = prime * result + ((getfPowerCurrent() == null) ? 0 : getfPowerCurrent().hashCode());
        result = prime * result + ((getfBroadcastState() == null) ? 0 : getfBroadcastState().hashCode());
        result = prime * result + ((getfDeviceVolume() == null) ? 0 : getfDeviceVolume().hashCode());
        result = prime * result + ((getfDigitalTelevisionRadioMode() == null) ? 0 : getfDigitalTelevisionRadioMode().hashCode());
        result = prime * result + ((getfDigitalTelevisionRadioRate() == null) ? 0 : getfDigitalTelevisionRadioRate().hashCode());
        result = prime * result + ((getfQma() == null) ? 0 : getfQma().hashCode());
        result = prime * result + ((getfDigitalTelevisionSignalQuality() == null) ? 0 : getfDigitalTelevisionSignalQuality().hashCode());
        result = prime * result + ((getfSignalRateList() == null) ? 0 : getfSignalRateList().hashCode());
        result = prime * result + ((getfSignalStrengthList() == null) ? 0 : getfSignalStrengthList().hashCode());
        result = prime * result + ((getfDigitalTelevisionSignalStrength() == null) ? 0 : getfDigitalTelevisionSignalStrength().hashCode());
        result = prime * result + ((getfCode() == null) ? 0 : getfCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fDeviceType=").append(fDeviceType);
        sb.append(", fDeviceName=").append(fDeviceName);
        sb.append(", fDeviceResourceCode=").append(fDeviceResourceCode);
        sb.append(", fDeviceState=").append(fDeviceState);
        sb.append(", fNumber=").append(fNumber);
        sb.append(", fDeviceImage=").append(fDeviceImage);
        sb.append(", fDeviceIp=").append(fDeviceIp);
        sb.append(", fDevicePort=").append(fDevicePort);
        sb.append(", fDeviceModel=").append(fDeviceModel);
        sb.append(", fPhysicalCode=").append(fPhysicalCode);
        sb.append(", fLocation=").append(fLocation);
        sb.append(", fInstallAddress=").append(fInstallAddress);
        sb.append(", fLongitude=").append(fLongitude);
        sb.append(", fDimension=").append(fDimension);
        sb.append(", fUrl=").append(fUrl);
        sb.append(", fEnableState=").append(fEnableState);
        sb.append(", fDeviceBand=").append(fDeviceBand);
        sb.append(", fAcceptCommandPid=").append(fAcceptCommandPid);
        sb.append(", fDisplayLevel=").append(fDisplayLevel);
        sb.append(", fRemark=").append(fRemark);
        sb.append(", fCertificate=").append(fCertificate);
        sb.append(", fSchemeType=").append(fSchemeType);
        sb.append(", fMaintainer=").append(fMaintainer);
        sb.append(", fProtocolType=").append(fProtocolType);
        sb.append(", fManufacturerInfo=").append(fManufacturerInfo);
        sb.append(", fNvr=").append(fNvr);
        sb.append(", fChannelModel=").append(fChannelModel);
        sb.append(", fLoginName=").append(fLoginName);
        sb.append(", fLoginPassword=").append(fLoginPassword);
        sb.append(", fChannelContent=").append(fChannelContent);
        sb.append(", fChannelNumber=").append(fChannelNumber);
        sb.append(", fHardwareVersion=").append(fHardwareVersion);
        sb.append(", fSoftwareVersion=").append(fSoftwareVersion);
        sb.append(", fPower=").append(fPower);
        sb.append(", fVoltage=").append(fVoltage);
        sb.append(", fRfLevel=").append(fRfLevel);
        sb.append(", fResCoding=").append(fResCoding);
        sb.append(", fResTypeCode=").append(fResTypeCode);
        sb.append(", fResTypeSequenceCode=").append(fResTypeSequenceCode);
        sb.append(", fResSubtypeCode=").append(fResSubtypeCode);
        sb.append(", fResSubtypeSequenceCode=").append(fResSubtypeSequenceCode);
        sb.append(", fSupportIpFlag=").append(fSupportIpFlag);
        sb.append(", fSupportRdsFlag=").append(fSupportRdsFlag);
        sb.append(", fSupportDtmbTsFlag=").append(fSupportDtmbTsFlag);
        sb.append(", fSupportDvbcTsFlag=").append(fSupportDvbcTsFlag);
        sb.append(", fSort=").append(fSort);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", fBackTime=").append(fBackTime);
        sb.append(", fLogicCode=").append(fLogicCode);
        sb.append(", fBackMode=").append(fBackMode);
        sb.append(", fNetworkMode=").append(fNetworkMode);
        sb.append(", fPowerCurrent=").append(fPowerCurrent);
        sb.append(", fBroadcastState=").append(fBroadcastState);
        sb.append(", fDeviceVolume=").append(fDeviceVolume);
        sb.append(", fDigitalTelevisionRadioMode=").append(fDigitalTelevisionRadioMode);
        sb.append(", fDigitalTelevisionRadioRate=").append(fDigitalTelevisionRadioRate);
        sb.append(", fQma=").append(fQma);
        sb.append(", fDigitalTelevisionSignalQuality=").append(fDigitalTelevisionSignalQuality);
        sb.append(", fSignalRateList=").append(fSignalRateList);
        sb.append(", fSignalStrengthList=").append(fSignalStrengthList);
        sb.append(", fDigitalTelevisionSignalStrength=").append(fDigitalTelevisionSignalStrength);
        sb.append(", fCode=").append(fCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}