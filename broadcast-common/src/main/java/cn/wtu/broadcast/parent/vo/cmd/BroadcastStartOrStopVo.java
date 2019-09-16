package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;
import java.util.Date;

/**
 * 应急广播大喇叭终端通用指令----广播开播(停播)指令VO （0x04）
 * 
 * @author lxg
 * @since 2019-06-10
 */
public class BroadcastStartOrStopVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 广播Id 作为顺序码 平台资源编码+yyyyMMdd+顺序码
	 */
	private Integer fId;
	
	/**
	 * 消息类型 
	 */
	private String ebm_type;

	/**
	 * 广播类型 
	 */
	private byte ebm_class;

	/**
	 * 消息级别 
	 */
	private byte ebm_level;

	/**
	 * 开始时间 
	 */
	private Date start_time;

	/**
	 * 结束时间
	 */
	private Date end_ime;

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getEbm_type() {
		return ebm_type;
	}

	public void setEbm_type(String ebm_type) {
		this.ebm_type = ebm_type;
	}

	public byte getEbm_class() {
		return ebm_class;
	}

	public void setEbm_class(byte ebm_class) {
		this.ebm_class = ebm_class;
	}

	public byte getEbm_level() {
		return ebm_level;
	}

	public void setEbm_level(byte ebm_level) {
		this.ebm_level = ebm_level;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_ime() {
		return end_ime;
	}

	public void setEnd_ime(Date end_ime) {
		this.end_ime = end_ime;
	}
	
}
