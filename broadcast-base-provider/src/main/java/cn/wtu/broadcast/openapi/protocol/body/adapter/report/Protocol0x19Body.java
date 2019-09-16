package cn.wtu.broadcast.openapi.protocol.body.adapter.report;

import java.io.Serializable;

/**
 * 任务结束上报(0x19)
 * 
 * @author Pr1p
 *
 */
public class Protocol0x19Body implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 4745904416833139091L;
	/**
	 * 
	 */
	
	// 保留，取值为”1111”
	//byte reserved;
	// BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	String reserved_and_front_code;
	/*
	 * //保留，取值为”1111” byte reserved;
	 */
	// BCD编码的应急广播消息标识符, 共35个数字，其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	String reserved_and_ebm_id;
	public String getReserved_and_front_code() {
		return reserved_and_front_code;
	}
	public void setReserved_and_front_code(String reserved_and_front_code) {
		this.reserved_and_front_code = reserved_and_front_code;
	}
	public String getReserved_and_ebm_id() {
		return reserved_and_ebm_id;
	}
	public void setReserved_and_ebm_id(String reserved_and_ebm_id) {
		this.reserved_and_ebm_id = reserved_and_ebm_id;
	}

	

}
