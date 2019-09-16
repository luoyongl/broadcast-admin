package cn.wtu.broadcast.parent.enums;
/**
 * 文件上传路径
 * @author LXG
 *
 */
public enum UploadUrlEnum {

	image(1, "upload/image"), 
	video(2, "upload/video"), 
	audio(3, "upload/audio"),
	other(4, "upload/other"),
	
	tsDeviceUpdate(5, "upload/tsDeviceUpdate");

	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private UploadUrlEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}

	public static UploadUrlEnum getEnumByCode(String code) {
		for (UploadUrlEnum bigClassificationEnum : UploadUrlEnum.values()) {
			if (code != null && code.equals(String.valueOf(bigClassificationEnum.getCode()))) {
				return bigClassificationEnum;
			}
		}
		
		return UploadUrlEnum.other;
	}
}
