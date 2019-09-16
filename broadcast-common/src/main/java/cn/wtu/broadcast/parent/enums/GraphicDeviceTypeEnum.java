package cn.wtu.broadcast.parent.enums;

public enum GraphicDeviceTypeEnum {

	subtitle(0, "字幕"), 
	image(1, "图片"), 
	video(2, "视频"), 
	userDefined(3, "自定义");

	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private GraphicDeviceTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}

	public static GraphicDeviceTypeEnum getSexEnumByCode(String code) {
		for (GraphicDeviceTypeEnum graphicDeviceTypeEnum : GraphicDeviceTypeEnum.values()) {
			if (code != null && code.equals(String.valueOf(graphicDeviceTypeEnum.getCode()))) {
				return graphicDeviceTypeEnum;
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
