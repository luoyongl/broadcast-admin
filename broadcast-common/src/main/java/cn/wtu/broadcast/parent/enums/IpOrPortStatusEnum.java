package cn.wtu.broadcast.parent.enums;

/**
 * 查询状态参数(判断是否为相同IP及端口)
 * @author yinjie
 *
 */

public enum IpOrPortStatusEnum {
	
	//判断为相同IP及端口
	okStatus(200),
	
	//判断为不同IP及端口
	errorsStatus(400),
	
	//判断为全空IP及端口
	nullStatus(500);

	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	private IpOrPortStatusEnum(int status) {
		this.status = status;
	}
	
	
}
