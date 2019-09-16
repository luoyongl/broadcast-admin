package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;

/**
 * 设置状态查询参数
 * @author yinjie
 *
 */
public class SetStateQueryParameterVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//回传IP
	private String returnIpValue;
	
	//回传端口
	private Integer returnPortValue;
	
	//查询信息类型
	private String queryCodes;

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

	public String getQueryCodes() {
		return queryCodes;
	}

	public void setQueryCodes(String queryCodes) {
		this.queryCodes = queryCodes;
	}

	@Override
	public String toString() {
		return "SetStateQueryParameterVo [returnIpValue=" + returnIpValue + ", returnPortValue=" + returnPortValue
				+ ", queryCodes=" + queryCodes + "]";
	}
	
}
