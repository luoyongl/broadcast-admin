package cn.wtu.broadcast.parent.enums;

/**
 * 审核类型枚举
 *
 */
public enum ReviewEnum {

	daily(1, "日常广播"), 
	shiji(2, "实际演练"), 
	moni(3, "模拟演练"),
	system(4, "系统演练"), 
	advanceEmergency(5,"广播预案-应急广播"),
	advanceDaily(6,"广播预案-日常广播"),
	advancePracticalDrill(7,"广播预案-实际演练"),
	advanceSystemDrill(8,"广播预案-系统演练"),
	advanceSimulateDrill(9,"广播预案-模拟演练"),
	userDefined(10, "自定义"),
	timing(11,"定时广播");
	
	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private ReviewEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}
	
}
