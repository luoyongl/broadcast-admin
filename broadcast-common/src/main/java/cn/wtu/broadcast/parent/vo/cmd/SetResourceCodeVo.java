package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;

/**
 * 资源编码设置
 * @author yinjie
 *
 */
public class SetResourceCodeVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//资源编码
	private String resourceCode;
	
	//物理编码
	private String physicalCode;
	
	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getPhysicalCode() {
		return physicalCode;
	}

	public void setPhysicalCode(String physicalCode) {
		this.physicalCode = physicalCode;
	}

	@Override
	public String toString() {
		return "SetResourceCodeVo [resourceCode=" + resourceCode + ", physicalCode=" + physicalCode + "]";
	}
	
}
