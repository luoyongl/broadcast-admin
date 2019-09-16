package cn.wtu.broadcast.parent.enums;

/**
 * 电话名单枚举
 * @author LY
 *
 */
public enum SmsAndRecordEnum {

	RECORD(0, "短信记录"),
	SMS(1, "电话记录");
	

	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private SmsAndRecordEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}
	
}
