package cn.wtu.broadcast.parent.enums;
/**
 * 审核大分类 自动还是手动
 * @author LXG
 *
 */
public enum BigClassificationEnum {

	manual(0, "手动"), 
	automatic(1, "自动"), 
	userDefined(2, "自定义");

	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private BigClassificationEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}

	public static BigClassificationEnum getSexEnumByCode(String code) {
		for (BigClassificationEnum bigClassificationEnum : BigClassificationEnum.values()) {
			if (code != null && code.equals(String.valueOf(bigClassificationEnum.getCode()))) {
				return bigClassificationEnum;
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
