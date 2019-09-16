package cn.wtu.broadcast.parent.enums;

/**
 * 审核结果
 * @author LXG
 *
 */
public enum ReviewResultEnum {

	waitReview(0, "待审核"), 
	reviewFail(1, "审核未通过"),
	reviewSuccess(2, "审核成功"),
	waitBroading(3,"待播放"),
	overTime(4,"已过期"),
	userDefined(5, "自定义");

	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private ReviewResultEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}

	public static ReviewResultEnum getSexEnumByCode(String code) {
		for (ReviewResultEnum reviewResultEnum : ReviewResultEnum.values()) {
			if (code != null && code.equals(String.valueOf(reviewResultEnum.getCode()))) {
				return reviewResultEnum;
			}
		}
		
		return null;
	}
	
	public static String getValueByCode(String code) {
		for (ReviewResultEnum broadcastTypeEnum : ReviewResultEnum.values()) {
			if (code != null && code.equals(String.valueOf(broadcastTypeEnum.getCode()))) {
				return broadcastTypeEnum.desc;
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
