package cn.wtu.broadcast.parent.vo.provice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 索引表2019-01-15 配置表2019-01-23 设置有默认值的 mediaType 和 elementary_PID lxg 2019-02-19
 * mediaType = 3 默认为音频
 * 
 * @author lxg
 * @since 2019-01-15 用于封装 页面输入的数据 映射为三方编码 封装数据格式后传递给终端设备
 */
public class EBITParamsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 广播Id 作为顺序码 平台资源编码+yyyymmdd+顺序码
	 */
	private Integer fId;

	/**
	 * 平台资源编码 对应 配置表 t_system_configuration的资源编码
	 */
	private String platformResourceCode;

	/**
	 * 消息类型 对应 广播数据表b_broadcast_data和b_broadcast_timing的f_message_type
	 */
	private String EBM_type;

	/**
	 * 广播类型 对应 广播数据表b_broadcast_data的f_broadcast_type和定时广播
	 */
	private byte EBM_class;

	/**
	 * 消息级别 对应 广播数据表b_broadcast_data和b_broadcast_timing的f_message_level
	 */
	private byte EBM_level;

	/**
	 * 开始时间 对应 广播数据表b_broadcast_data和b_broadcast_timing的f_create_time
	 */
	private Date EBM_start_time;

	/**
	 * 省级平台接收专用
	 */
	private Date EBMEndTime;

	/**
	 * 省级平台接收专用
	 */
	private String termialDevice;

	/**
	 * 结束时间 传数据时 没有结束时间 ,结束时间=创建时间+5min 对应
	 * 广播数据表b_broadcast_data和b_broadcast_timing
	 */
	// private Date EBM_end_time;

	/**
	 * 播发区域 用于接收 从广播数据表传来的 区域id 对应
	 * 广播数据表b_broadcast_data和b_broadcast_timing的f_broadcast_area
	 */
	private String EBM_resource_codes;

	/**
	 * 播发区域 区域编码的list形式 对应
	 * 广播数据表b_broadcast_data和b_broadcast_timing的f_broadcast_area
	 */
	private List<String> resourceCodeList;
	
	/**
	 * 县的平台资源编码  
	 * 用于判断在哪里播放,如果是在全县则21包开头为21,若在镇或村级播放,则是22
	 */
	private String countyResourceCode;

	/**
	 * 详情通道节目号 对应 节目表b_program_channel的f_program_pass
	 */
	private short details_channel_program_number;

	/**
	 * 详情通道PCR_PID 对应 节目表b_program_channel的f_service_id
	 */
	private short details_channel_PCR_PID;
	
	/**
	 * 传输流id  ts_id 对应 字典表b_program_channel的f_service_id
	 */
	private short ts_id;
	
	private String adapterPrefix;

	/**
	 * DVB-C调制参数
	 * 
	 * @author lxg
	 * 
	 * @since 2019-02-18
	 */
	private String DVBC_parameter;

	/**
	 * DTMB调制参数
	 * 
	 * @author lxg
	 * 
	 * @since 2019-02-18
	 */
	private String DTMB_parameter;

	/**
	 * 基本pId(音频pId),由于节目有限10个,但县级镇级30个,每次同一个节目只能播发一个音频,如果两个音频同时播放,音质很杂乱。 对应 节目表的
	 * 基本pId 这些值最后是由 用户(政府)提供 作为基本配置录入 lxg 这里设置1000的原因是 文本转语音和定时广播
	 * 时没有设置elementary_PID,之后是从内存中取出一个 没有使用的elementary_PID 2019-02-19
	 */
	private short elementary_PID;

	/**
	 * 音频url 网络路径
	 */
	private String audioUrl;

	/**
	 * 文本转语音url 网络路径 定时广播时 textToAudioUrl=""; 需要这样吗 不需要 会自动初始化
	 */
	private String textToAudioUrl;

	/**
	 * 音量
	 */
	private byte volume;

	/**
	 * 流媒体类型 对应 节目表b_program_channel的f_media_type
	 */
	private byte mediaType = 3;

	/**
	 * 终端资源编码 存放终端 的三方 资源编码
	 */
	private List<String> termialResourceCodeList = new ArrayList<String>();
	
	/**
	 * 用于判断是否是 定时广播
	 */
	private Integer fState;

	//dtmbAdapterIp  dtmbAdapterPort   dvbcAdapterIp  dvbcAdapterPort
	/**
	 * DTMB适配器ip
	 */
	private String dtmbAdapterIp;

	/**
	 * DTMB适配器port
	 */
	private String dtmbAdapterPort;
	
	/**
	 * DVB-C适配器ip
	 */
	private String dvbcAdapterIp;

	/**
	 * DVB-C适配器port
	 */
	private String dvbcAdapterPort;

	/**
	 * 县平台证书私钥   32位
	 * 从数据库中查询出来的
	 * lxg  2019-02-21
	 */
	private String privateKey;
	
	/**
	 * 省平台证书私钥   32位
	 * 从省平台那边传递过来的
	 * lxg  2019-02-21
	 */
	private String provincePrivateKey;
	
	/**
	 * 省平台区域资源编码     lxg  2019-02-25
	 * 这里是12 位的区域资源编码    451402102206  需要加前缀  0101  编号 00
	 * 不放在 resourceCodeList的原因是 resourceCodeList存放的是带有  0101和00
	 */
	private List<String> prinvinceResourceCode;
	
	/**
	 * 时区设置
	 * 是local还是UTC
	 * 0-local  1-UTC
	 * lxg  2019-04-04
	 */
	private String timeZoneSet;

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getPlatformResourceCode() {
		return platformResourceCode;
	}

	public void setPlatformResourceCode(String platformResourceCode) {
		this.platformResourceCode = platformResourceCode;
	}

	public String getEBM_type() {
		return EBM_type;
	}

	public void setEBM_type(String eBM_type) {
		EBM_type = eBM_type;
	}

	public byte getEBM_class() {
		return EBM_class;
	}

	public void setEBM_class(byte eBM_class) {
		EBM_class = eBM_class;
	}

	public byte getEBM_level() {
		return EBM_level;
	}

	public void setEBM_level(byte eBM_level) {
		EBM_level = eBM_level;
	}

	public String getEBM_resource_codes() {
		return EBM_resource_codes;
	}

	public void setEBM_resource_codes(String eBM_resource_codes) {
		EBM_resource_codes = eBM_resource_codes;
	}

	public List<String> getResourceCodeList() {
		return resourceCodeList;
	}

	public void setResourceCodeList(List<String> resourceCodeList) {
		this.resourceCodeList = resourceCodeList;
	}

	public short getDetails_channel_program_number() {
		return details_channel_program_number;
	}

	public void setDetails_channel_program_number(short details_channel_program_number) {
		this.details_channel_program_number = details_channel_program_number;
	}

	public short getDetails_channel_PCR_PID() {
		return details_channel_PCR_PID;
	}

	public void setDetails_channel_PCR_PID(short details_channel_PCR_PID) {
		this.details_channel_PCR_PID = details_channel_PCR_PID;
	}

	public String getDVBC_parameter() {
		return DVBC_parameter;
	}

	public void setDVBC_parameter(String dVBC_parameter) {
		DVBC_parameter = dVBC_parameter;
	}

	public String getDTMB_parameter() {
		return DTMB_parameter;
	}

	public void setDTMB_parameter(String dTMB_parameter) {
		DTMB_parameter = dTMB_parameter;
	}

	public short getElementary_PID() {
		return elementary_PID;
	}

	public void setElementary_PID(short elementary_PID) {
		this.elementary_PID = elementary_PID;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}

	public Date getEBM_start_time() {
		return EBM_start_time;
	}

	public void setEBM_start_time(Date eBM_start_time) {
		EBM_start_time = eBM_start_time;
	}

	public byte getVolume() {
		return volume;
	}

	public void setVolume(byte volume) {
		this.volume = volume;
	}

	public byte getMediaType() {
		return mediaType;
	}

	public void setMediaType(byte mediaType) {
		this.mediaType = mediaType;
	}

	public List<String> getTermialResourceCodeList() {
		return termialResourceCodeList;
	}

	public void setTermialResourceCodeList(List<String> termialResourceCodeList) {
		this.termialResourceCodeList = termialResourceCodeList;
	}

	public Integer getfState() {
		return fState;
	}

	public void setfState(Integer fState) {
		this.fState = fState;
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

	public String getTextToAudioUrl() {
		return textToAudioUrl;
	}

	public void setTextToAudioUrl(String textToAudioUrl) {
		this.textToAudioUrl = textToAudioUrl;
	}

	public Date getEBMEndTime() {
		return EBMEndTime;
	}

	public void setEBMEndTime(Date eBMEndTime) {
		EBMEndTime = eBMEndTime;
	}

	public String getTermialDevice() {
		return termialDevice;
	}

	public void setTermialDevice(String termialDevice) {
		this.termialDevice = termialDevice;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getProvincePrivateKey() {
		return provincePrivateKey;
	}

	public void setProvincePrivateKey(String provincePrivateKey) {
		this.provincePrivateKey = provincePrivateKey;
	}

	public List<String> getPrinvinceResourceCode() {
		return prinvinceResourceCode;
	}

	public void setPrinvinceResourceCode(List<String> prinvinceResourceCode) {
		this.prinvinceResourceCode = prinvinceResourceCode;
	}

	public short getTs_id() {
		return ts_id;
	}

	public void setTs_id(short ts_id) {
		this.ts_id = ts_id;
	}

	public String getAdapterPrefix() {
		return adapterPrefix;
	}

	public void setAdapterPrefix(String adapterPrefix) {
		this.adapterPrefix = adapterPrefix;
	}

	public String getTimeZoneSet() {
		return timeZoneSet;
	}

	public void setTimeZoneSet(String timeZoneSet) {
		this.timeZoneSet = timeZoneSet;
	}

	public String getCountyResourceCode() {
		return countyResourceCode;
	}

	public void setCountyResourceCode(String countyResourceCode) {
		this.countyResourceCode = countyResourceCode;
	}
}
