package cn.wtu.broadcast.entity.body;

import java.io.Serializable;

import cn.wtu.broadcast.entity.PassbackBodyData;

/**
 * 故障与恢复
 * @author Lenovo
 *
 */
public class PassbackBody0x13Data extends PassbackBodyData implements Serializable{

	private static final long serialVersionUID = 1121401218057767310L;
	
	// 1：发生故障
	// 2：故障消除 ，即恢复正常
	String faultOrRecoveryTag;
	
	// 1：电源电流过低
	// 2：平均电源功耗过低
	// 3：功放输出电压过低
	// 4：锁定频率场强过低
	// 5：无法获取监测信息
	// 其他预留
	String faultType;
	
	// 发生故障或者故障恢复 的 描述信息
	String faultDesc;
	
	// 发生故障或者故障恢复的 UTC 时间
	String happenTime;

	public String getFaultOrRecoveryTag() {
		return faultOrRecoveryTag;
	}

	public void setFaultOrRecoveryTag(String faultOrRecoveryTag) {
		this.faultOrRecoveryTag = faultOrRecoveryTag;
	}

	public String getFaultType() {
		return faultType;
	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public String getFaultDesc() {
		return faultDesc;
	}

	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}

	public String getHappenTime() {
		return happenTime;
	}

	public void setHappenTime(String happenTime) {
		this.happenTime = happenTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
