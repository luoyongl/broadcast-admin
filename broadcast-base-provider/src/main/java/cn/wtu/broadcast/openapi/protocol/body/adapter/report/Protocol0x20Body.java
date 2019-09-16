package cn.wtu.broadcast.openapi.protocol.body.adapter.report;

import java.io.Serializable;

/**
 * 应急大喇叭适配器控制指令----回传参数设置(0x20)
 * 
 */
public class Protocol0x20Body implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3145816502701255366L;

	/**
	 * 
	 */
	
	
	// 前端编码长度
	String front_code_length;
	// BCD编码
	String front_code;
	// 前端状态1：空闲，2：工作，3：故障
	String front_State;
	// 参考本协议中的时间格式约定
	String connection_time;
	public String getFront_code_length() {
		return front_code_length;
	}
	public void setFront_code_length(String front_code_length) {
		this.front_code_length = front_code_length;
	}
	public String getFront_code() {
		return front_code;
	}
	public void setFront_code(String front_code) {
		this.front_code = front_code;
	}
	public String getFront_State() {
		return front_State;
	}
	public void setFront_State(String front_State) {
		this.front_State = front_State;
	}
	public String getConnection_time() {
		return connection_time;
	}
	public void setConnection_time(String connection_time) {
		this.connection_time = connection_time;
	}

	

}
