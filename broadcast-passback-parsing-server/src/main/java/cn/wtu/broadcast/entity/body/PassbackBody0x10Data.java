package cn.wtu.broadcast.entity.body;

import java.io.Serializable;

import cn.wtu.broadcast.entity.PassbackBodyData;

/**
 * 终端心跳
 * @author Lenovo
 *
 */
public class PassbackBody0x10Data extends PassbackBodyData implements Serializable{

	private static final long serialVersionUID = 1121401218057767310L;
	
	/**
	 * 终端工作状态
	 */
	private String workState;
	
	/**
	 * 首次注册标识
	 */
	private String firstRegisterTag;
	
	/**
	 * 物理地址编码长度
	 */
	private String physicsAddressLength;
	
	/**
	 * 物理地址编码
	 */
	private String physicsAddress;

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getFirstRegisterTag() {
		return firstRegisterTag;
	}

	public void setFirstRegisterTag(String firstRegisterTag) {
		this.firstRegisterTag = firstRegisterTag;
	}

	public String getPhysicsAddressLength() {
		return physicsAddressLength;
	}

	public void setPhysicsAddressLength(String physicsAddressLength) {
		this.physicsAddressLength = physicsAddressLength;
	}

	public String getPhysicsAddress() {
		return physicsAddress;
	}

	public void setPhysicsAddress(String physicsAddress) {
		this.physicsAddress = physicsAddress;
	}	
	
}
