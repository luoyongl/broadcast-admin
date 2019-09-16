package cn.wtu.broadcast.parent.vo.provice;

import java.io.Serializable;

/**
 * 配置表
 * @author lxg
 * @since 2019/03/06
 */
public class EBCONTParamsVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 县平台 私钥
	 */
	private String privateKey;
	
	private String dtmbAdapterIp;
	
	private String dtmbAdapterPort;
	
	private String dvbcAdapterIp;
	
	private String dvbcAdapterPort;
	
	/**
	 * 以下所有字段  从设备参数配置表 BDeviceParameterSet 得来
	 * TODO BeanUtils.copyProperties(dest,orig);
	 */
    private String fDeviceResourceCode;

    private Boolean fAddressSettingCmd;

    private String fPhysicalAddress;

    private String fLogicDdress;

    private Boolean fWorkmodeSettingCmd;

    private Byte fWorkmode;

    private Boolean fFreqSettingCmd;

    private Boolean fDtmbOrDvbc;

    private Boolean fDtmb;

    private String fDtmbFreq;

    private String fDtmbSymbolrate;

    private Byte fDtmbQam;

    private Boolean fDvbc;

    private String fDvbcFreq;

    private String fDvbcSymbolrate;

    private Byte fDvbcQam;

    private Boolean fRebacktypeAndAddressCmd;

    private Byte fRebackType;

    private String fRebackTelNumber;

    private String fRebackIpAddress1;

    private String fRebackIpAddress2;

    private String fRebackIpPort1;

    private String fRebackIpPort2;

    private String fRebackDomainName;

    private String fRebackDomainNameport;

    private Boolean fColumnSettingCmd;

    private Byte fColumn;

    private Boolean fRebackPeriodSettingCmd;

    private Integer fRebackPeriod;

    private Boolean fRdsSettingCmd;

    private Byte fTerminalRdsSet;

    private String fTerminalRdsData;

    private Boolean fTerminalInspectSettingCmd;

    private Integer fTerminalRebackPeriod;

    private Byte fTerminalRebackType;

    private Boolean fTerminalPidSettingCmd;

    private String fTerminalPidSet;

    private Boolean fRecordExtractSettingCmd;

    private String fRecordFileName;

    private String fStartPackageNum;

    private Byte fAudioRebackMode;

    private String fAudioRebackServerip;

    private String fAudioRebackPort;

    private Boolean fAudioRebackSettingCmd;

    private Boolean fKaiguan;

    private Byte fAudioRebackMode2;

    private String fAudioRebackServerip2;

    private String fAudioRebackPort2;

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getfDeviceResourceCode() {
		return fDeviceResourceCode;
	}

	public void setfDeviceResourceCode(String fDeviceResourceCode) {
		this.fDeviceResourceCode = fDeviceResourceCode;
	}

	public Boolean getfAddressSettingCmd() {
		return fAddressSettingCmd;
	}

	public void setfAddressSettingCmd(Boolean fAddressSettingCmd) {
		this.fAddressSettingCmd = fAddressSettingCmd;
	}

	public String getfPhysicalAddress() {
		return fPhysicalAddress;
	}

	public void setfPhysicalAddress(String fPhysicalAddress) {
		this.fPhysicalAddress = fPhysicalAddress;
	}

	public String getfLogicDdress() {
		return fLogicDdress;
	}

	public void setfLogicDdress(String fLogicDdress) {
		this.fLogicDdress = fLogicDdress;
	}

	public Boolean getfWorkmodeSettingCmd() {
		return fWorkmodeSettingCmd;
	}

	public void setfWorkmodeSettingCmd(Boolean fWorkmodeSettingCmd) {
		this.fWorkmodeSettingCmd = fWorkmodeSettingCmd;
	}

	public Byte getfWorkmode() {
		return fWorkmode;
	}

	public void setfWorkmode(Byte fWorkmode) {
		this.fWorkmode = fWorkmode;
	}

	public Boolean getfFreqSettingCmd() {
		return fFreqSettingCmd;
	}

	public void setfFreqSettingCmd(Boolean fFreqSettingCmd) {
		this.fFreqSettingCmd = fFreqSettingCmd;
	}

	public Boolean getfDtmbOrDvbc() {
		return fDtmbOrDvbc;
	}

	public void setfDtmbOrDvbc(Boolean fDtmbOrDvbc) {
		this.fDtmbOrDvbc = fDtmbOrDvbc;
	}

	public Boolean getfDtmb() {
		return fDtmb;
	}

	public void setfDtmb(Boolean fDtmb) {
		this.fDtmb = fDtmb;
	}

	public String getfDtmbFreq() {
		return fDtmbFreq;
	}

	public void setfDtmbFreq(String fDtmbFreq) {
		this.fDtmbFreq = fDtmbFreq;
	}

	public String getfDtmbSymbolrate() {
		return fDtmbSymbolrate;
	}

	public void setfDtmbSymbolrate(String fDtmbSymbolrate) {
		this.fDtmbSymbolrate = fDtmbSymbolrate;
	}

	public Byte getfDtmbQam() {
		return fDtmbQam;
	}

	public void setfDtmbQam(Byte fDtmbQam) {
		this.fDtmbQam = fDtmbQam;
	}

	public Boolean getfDvbc() {
		return fDvbc;
	}

	public void setfDvbc(Boolean fDvbc) {
		this.fDvbc = fDvbc;
	}

	public String getfDvbcFreq() {
		return fDvbcFreq;
	}

	public void setfDvbcFreq(String fDvbcFreq) {
		this.fDvbcFreq = fDvbcFreq;
	}

	public String getfDvbcSymbolrate() {
		return fDvbcSymbolrate;
	}

	public void setfDvbcSymbolrate(String fDvbcSymbolrate) {
		this.fDvbcSymbolrate = fDvbcSymbolrate;
	}

	public Byte getfDvbcQam() {
		return fDvbcQam;
	}

	public void setfDvbcQam(Byte fDvbcQam) {
		this.fDvbcQam = fDvbcQam;
	}

	public Boolean getfRebacktypeAndAddressCmd() {
		return fRebacktypeAndAddressCmd;
	}

	public void setfRebacktypeAndAddressCmd(Boolean fRebacktypeAndAddressCmd) {
		this.fRebacktypeAndAddressCmd = fRebacktypeAndAddressCmd;
	}

	public Byte getfRebackType() {
		return fRebackType;
	}

	public void setfRebackType(Byte fRebackType) {
		this.fRebackType = fRebackType;
	}

	public String getfRebackTelNumber() {
		return fRebackTelNumber;
	}

	public void setfRebackTelNumber(String fRebackTelNumber) {
		this.fRebackTelNumber = fRebackTelNumber;
	}

	public String getfRebackIpAddress1() {
		return fRebackIpAddress1;
	}

	public void setfRebackIpAddress1(String fRebackIpAddress1) {
		this.fRebackIpAddress1 = fRebackIpAddress1;
	}

	public String getfRebackIpAddress2() {
		return fRebackIpAddress2;
	}

	public void setfRebackIpAddress2(String fRebackIpAddress2) {
		this.fRebackIpAddress2 = fRebackIpAddress2;
	}

	public String getfRebackIpPort1() {
		return fRebackIpPort1;
	}

	public void setfRebackIpPort1(String fRebackIpPort1) {
		this.fRebackIpPort1 = fRebackIpPort1;
	}

	public String getfRebackIpPort2() {
		return fRebackIpPort2;
	}

	public void setfRebackIpPort2(String fRebackIpPort2) {
		this.fRebackIpPort2 = fRebackIpPort2;
	}

	public String getfRebackDomainName() {
		return fRebackDomainName;
	}

	public void setfRebackDomainName(String fRebackDomainName) {
		this.fRebackDomainName = fRebackDomainName;
	}

	public String getfRebackDomainNameport() {
		return fRebackDomainNameport;
	}

	public void setfRebackDomainNameport(String fRebackDomainNameport) {
		this.fRebackDomainNameport = fRebackDomainNameport;
	}

	public Boolean getfColumnSettingCmd() {
		return fColumnSettingCmd;
	}

	public void setfColumnSettingCmd(Boolean fColumnSettingCmd) {
		this.fColumnSettingCmd = fColumnSettingCmd;
	}

	public Byte getfColumn() {
		return fColumn;
	}

	public void setfColumn(Byte fColumn) {
		this.fColumn = fColumn;
	}

	public Boolean getfRebackPeriodSettingCmd() {
		return fRebackPeriodSettingCmd;
	}

	public void setfRebackPeriodSettingCmd(Boolean fRebackPeriodSettingCmd) {
		this.fRebackPeriodSettingCmd = fRebackPeriodSettingCmd;
	}

	public Integer getfRebackPeriod() {
		return fRebackPeriod;
	}

	public void setfRebackPeriod(Integer fRebackPeriod) {
		this.fRebackPeriod = fRebackPeriod;
	}

	public Boolean getfRdsSettingCmd() {
		return fRdsSettingCmd;
	}

	public void setfRdsSettingCmd(Boolean fRdsSettingCmd) {
		this.fRdsSettingCmd = fRdsSettingCmd;
	}

	public Byte getfTerminalRdsSet() {
		return fTerminalRdsSet;
	}

	public void setfTerminalRdsSet(Byte fTerminalRdsSet) {
		this.fTerminalRdsSet = fTerminalRdsSet;
	}

	public String getfTerminalRdsData() {
		return fTerminalRdsData;
	}

	public void setfTerminalRdsData(String fTerminalRdsData) {
		this.fTerminalRdsData = fTerminalRdsData;
	}

	public Boolean getfTerminalInspectSettingCmd() {
		return fTerminalInspectSettingCmd;
	}

	public void setfTerminalInspectSettingCmd(Boolean fTerminalInspectSettingCmd) {
		this.fTerminalInspectSettingCmd = fTerminalInspectSettingCmd;
	}

	public Integer getfTerminalRebackPeriod() {
		return fTerminalRebackPeriod;
	}

	public void setfTerminalRebackPeriod(Integer fTerminalRebackPeriod) {
		this.fTerminalRebackPeriod = fTerminalRebackPeriod;
	}

	public Byte getfTerminalRebackType() {
		return fTerminalRebackType;
	}

	public void setfTerminalRebackType(Byte fTerminalRebackType) {
		this.fTerminalRebackType = fTerminalRebackType;
	}

	public Boolean getfTerminalPidSettingCmd() {
		return fTerminalPidSettingCmd;
	}

	public void setfTerminalPidSettingCmd(Boolean fTerminalPidSettingCmd) {
		this.fTerminalPidSettingCmd = fTerminalPidSettingCmd;
	}

	public String getfTerminalPidSet() {
		return fTerminalPidSet;
	}

	public void setfTerminalPidSet(String fTerminalPidSet) {
		this.fTerminalPidSet = fTerminalPidSet;
	}

	public Boolean getfRecordExtractSettingCmd() {
		return fRecordExtractSettingCmd;
	}

	public void setfRecordExtractSettingCmd(Boolean fRecordExtractSettingCmd) {
		this.fRecordExtractSettingCmd = fRecordExtractSettingCmd;
	}

	public String getfRecordFileName() {
		return fRecordFileName;
	}

	public void setfRecordFileName(String fRecordFileName) {
		this.fRecordFileName = fRecordFileName;
	}

	public String getfStartPackageNum() {
		return fStartPackageNum;
	}

	public void setfStartPackageNum(String fStartPackageNum) {
		this.fStartPackageNum = fStartPackageNum;
	}

	public Byte getfAudioRebackMode() {
		return fAudioRebackMode;
	}

	public void setfAudioRebackMode(Byte fAudioRebackMode) {
		this.fAudioRebackMode = fAudioRebackMode;
	}

	public String getfAudioRebackServerip() {
		return fAudioRebackServerip;
	}

	public void setfAudioRebackServerip(String fAudioRebackServerip) {
		this.fAudioRebackServerip = fAudioRebackServerip;
	}

	public String getfAudioRebackPort() {
		return fAudioRebackPort;
	}

	public void setfAudioRebackPort(String fAudioRebackPort) {
		this.fAudioRebackPort = fAudioRebackPort;
	}

	public Boolean getfAudioRebackSettingCmd() {
		return fAudioRebackSettingCmd;
	}

	public void setfAudioRebackSettingCmd(Boolean fAudioRebackSettingCmd) {
		this.fAudioRebackSettingCmd = fAudioRebackSettingCmd;
	}

	public Boolean getfKaiguan() {
		return fKaiguan;
	}

	public void setfKaiguan(Boolean fKaiguan) {
		this.fKaiguan = fKaiguan;
	}

	public Byte getfAudioRebackMode2() {
		return fAudioRebackMode2;
	}

	public void setfAudioRebackMode2(Byte fAudioRebackMode2) {
		this.fAudioRebackMode2 = fAudioRebackMode2;
	}

	public String getfAudioRebackServerip2() {
		return fAudioRebackServerip2;
	}

	public void setfAudioRebackServerip2(String fAudioRebackServerip2) {
		this.fAudioRebackServerip2 = fAudioRebackServerip2;
	}

	public String getfAudioRebackPort2() {
		return fAudioRebackPort2;
	}

	public void setfAudioRebackPort2(String fAudioRebackPort2) {
		this.fAudioRebackPort2 = fAudioRebackPort2;
	}

	public String getDtmbAdapterIp() {
		return dtmbAdapterIp;
	}

	public void setDtmbAdapterIp(String dtmbAdapterIp) {
		this.dtmbAdapterIp = dtmbAdapterIp;
	}

	public String getDtmbAdapterPort() {
		return dtmbAdapterPort;
	}

	public void setDtmbAdapterPort(String dtmbAdapterPort) {
		this.dtmbAdapterPort = dtmbAdapterPort;
	}

	public String getDvbcAdapterIp() {
		return dvbcAdapterIp;
	}

	public void setDvbcAdapterIp(String dvbcAdapterIp) {
		this.dvbcAdapterIp = dvbcAdapterIp;
	}

	public String getDvbcAdapterPort() {
		return dvbcAdapterPort;
	}

	public void setDvbcAdapterPort(String dvbcAdapterPort) {
		this.dvbcAdapterPort = dvbcAdapterPort;
	}
}
