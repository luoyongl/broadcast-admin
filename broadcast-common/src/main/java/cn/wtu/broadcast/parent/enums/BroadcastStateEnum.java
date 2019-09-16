package cn.wtu.broadcast.parent.enums;
/**
 * 广播状态
 * @author lxg
 *
 */
public enum BroadcastStateEnum {

	no(0, "无"), //广播预案专用
	waitReview(1, "待审核"), 
	waitBroadcast(2, "待播发"), 
	broadcasting(3, "正在播"),
	broadcasted(4, "已播发"),
	reviewFail(5, "审核未通过"),
	cancelled(6, "已取消"),
	userDefined(7,"已过期");
	
	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private BroadcastStateEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}

	public static BroadcastStateEnum getSexEnumByCode(String code) {
		for (BroadcastStateEnum broadcastStateEnum : BroadcastStateEnum.values()) {
			if (code != null && code.equals(String.valueOf(broadcastStateEnum.getCode()))) {
				return broadcastStateEnum;
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
