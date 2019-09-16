package cn.wtu.broadcast.enums;

public enum BroadcastTypeEnum {

	emergency(0, "应急广播"), daily(1, "日常广播"), shiji(2, "实际演练"), moni(3, "模拟演练"), system(4, "系统演练"), userDefined(5, "自定义");

	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private BroadcastTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}

	public static BroadcastTypeEnum getSexEnumByCode(String code) {
		for (BroadcastTypeEnum broadcastTypeEnum : BroadcastTypeEnum.values()) {
			if (code != null && code.equals(String.valueOf(broadcastTypeEnum.getCode()))) {
				return broadcastTypeEnum;
			}
		}

		return null;
	}
}
