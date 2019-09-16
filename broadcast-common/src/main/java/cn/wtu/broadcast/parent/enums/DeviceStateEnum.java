package cn.wtu.broadcast.parent.enums;

/**
 * 设备状态枚举
 * @author lxg
 *广播,在线,离线,停电,故障
 *Broadcasting, online, offline, power outage, malfunction
 */
public enum DeviceStateEnum {

	broadcasting(0, "广播"),
	online(1, "在线"),
	offline(2, "离线"),
	powerOutage(3, "停电"),
	malfunction(4, "故障"),
	userDefined(5,"自定义");
	

	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private DeviceStateEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}
	
}
