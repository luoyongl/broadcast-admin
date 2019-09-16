package cn.wtu.broadcast.parent.enums;

public enum HomePageTypeEnum {

	budiness(0, "商家"), 
	activity(1, "活动"), 
	businessCost(2, "商家套餐"), 
	activityCost(3, "活动套餐"), 
	userDefined(4, "自定义");

	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private HomePageTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}

	public static HomePageTypeEnum getSexEnumByCode(String code) {
		for (HomePageTypeEnum homePageTypeEnum : HomePageTypeEnum.values()) {
			if (code != null && code.equals(String.valueOf(homePageTypeEnum.getCode()))) {
				return homePageTypeEnum;
			}
		}
		
		return null;
	}
}
