package cn.wtu.broadcast.openapi.protocol.body.adapter.reply;

import java.io.Serializable;

/**
 * 查询故障详情回复(0x16)
 * @author Pr1p
 *
 */
public class Protocol0x16Body implements Serializable {
	private static final long serialVersionUID = -9206321858067764951L;
	//保留，取值为”1111”+BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	String front_code_reserved;
	/*	
	0：无故障；
	1：电源电流过低；
	2：平均电源功耗过低；
	3：功放输出电压过低；
	4：锁定频率场强过低；
	5：无法获取监测信息。
	其它预留。*/
	String fault_type;
	//
	String fault_desc_length;
	//故障详情描述
	String fault_desc;
	
	public String getFront_code_reserved() {
		return front_code_reserved;
	}
	public void setFront_code_reserved(String front_code_reserved) {
		this.front_code_reserved = front_code_reserved;
	}
	public String getFault_type() {
		return fault_type;
	}
	public void setFault_type(String fault_type) {
		this.fault_type = fault_type;
	}
	public String getFault_desc_length() {
		return fault_desc_length;
	}
	public void setFault_desc_length(String fault_desc_length) {
		this.fault_desc_length = fault_desc_length;
	}
	public String getFault_desc() {
		return fault_desc;
	}
	public void setFault_desc(String fault_desc) {
		this.fault_desc = fault_desc;
	}
	
}