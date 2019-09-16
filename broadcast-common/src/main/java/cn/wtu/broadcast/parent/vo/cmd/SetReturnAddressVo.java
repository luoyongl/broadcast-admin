package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;
/**
 * 设置回传地址(通用回传参数设置)
 * @author yinjie
 *
 */
public class SetReturnAddressVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//回传IP
	private String returnIpValue;
	
	//回传端口
	private Integer returnPortValue;

	public String getReturnIpValue() {
		return returnIpValue;
	}

	public void setReturnIpValue(String returnIpValue) {
		this.returnIpValue = returnIpValue;
	}

	public Integer getReturnPortValue() {
		return returnPortValue;
	}

	public void setReturnPortValue(Integer returnPortValue) {
		this.returnPortValue = returnPortValue;
	}

	@Override
	public String toString() {
		return "SetReturnAddressVo [returnIpValue=" + returnIpValue + ", returnPortValue=" + returnPortValue + "]";
	}

}
