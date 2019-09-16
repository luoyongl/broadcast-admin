package cn.wtu.broadcast.parent.enums;

public enum DeviceTypeEnum {

	frontDevice(0, "前端设备"), 
	terminalDevice(1, "终端设备"), 
	monitorDevice(2, "监控设备"), 
	camera(3, "摄像头"),
	/**
	 * 用于ts设备升级 过滤  lxg
	 */
	adapter(4, "适配器"),
	soundDevice(5, "音柱");
	

	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private DeviceTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}

	public static DeviceTypeEnum getSexEnumByCode(String code) {
		for (DeviceTypeEnum deviceTypeEnum : DeviceTypeEnum.values()) {
			if (code != null && code.equals(String.valueOf(deviceTypeEnum.getCode()))) {
				return deviceTypeEnum;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		/*
		int code2 = emergency.getCode();
		System.out.println(code2);*/
	}
}
