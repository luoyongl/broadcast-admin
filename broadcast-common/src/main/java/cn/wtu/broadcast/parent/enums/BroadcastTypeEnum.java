package cn.wtu.broadcast.parent.enums;

public enum BroadcastTypeEnum {

	system(1, "发布系统演练"), 
	simulate(2, "模拟演练"),	
	practical(3, "实际演练"), 
	emergency(4,"应急广播"),
	daily(5,"日常广播"),
	upgradeBroadcast(6,"升级广播"),
	
	advanceSystemDrill(7,"广播预案-系统演练"),/*成为广播时,类型改为 1*/
	advanceSimulateDrill(8,"广播预案-模拟演练"),/*成为广播时,类型改为 2*/
	advancePracticalDrill(9,"广播预案-实际演练"),/*成为广播时,类型改为 3*/
	advanceEmergency(10,"广播预案-应急广播"),/*成为广播时,类型改为 4*/
	advanceDaily(11,"广播预案-日常广播"),/*成为广播时,类型改为 5*/
	timing(12,"定时广播"),/*成为广播时,类型改为 5 ???这里我不是很确定*/
	pictureAd(13,"图文广告");
	
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

	public static BroadcastTypeEnum getEnumByCode(String code) {
		for (BroadcastTypeEnum broadcastTypeEnum : BroadcastTypeEnum.values()) {
			if (code != null && code.equals(String.valueOf(broadcastTypeEnum.getCode()))) {
				return broadcastTypeEnum;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		/*
		int code2 = emergency.getCode();
		System.out.println(code2);*/
		// BroadcastTypeEnum.getEnumByCode(realBroadcastType.toString()).getDesc();
//		String broadcastTypeEnum = BroadcastTypeEnum.getEnumByCode("1").getDesc();
//		System.out.println(broadcastTypeEnum);
	}
}
