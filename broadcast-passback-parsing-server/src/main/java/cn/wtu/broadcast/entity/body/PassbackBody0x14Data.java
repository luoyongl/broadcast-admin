package cn.wtu.broadcast.entity.body;

import java.io.Serializable;

import cn.wtu.broadcast.entity.PassbackBodyData;

/**
 * 终端任务切换
 * @author Lenovo
 *
 */
public class PassbackBody0x14Data extends PassbackBodyData implements Serializable{

	private static final long serialVersionUID = 1121401218057767310L;

	// 1：任务 开始
	// 2：任务结束
	private String switchTag;
	
	// 1：应急节目源
	// 2：日常节目源
	// 3：电话
	// 4：短信
	// 5：调音台
	// 6：U盘
	private String taskType;
	
	// 终端任务切换对应的应急广播消息 编码
	private String ebmId;
	
	// 终端播出任务切换时的 UTC 时间
	private String happenTime;

	public String getSwitchTag() {
		return switchTag;
	}

	public void setSwitchTag(String switchTag) {
		this.switchTag = switchTag;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getEbmId() {
		return ebmId;
	}

	public void setEbmId(String ebmId) {
		this.ebmId = ebmId;
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
