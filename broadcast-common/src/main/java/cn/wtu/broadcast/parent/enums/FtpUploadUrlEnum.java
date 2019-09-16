package cn.wtu.broadcast.parent.enums;

/**
 * 文件上传路径
 * @author LXG
 *
 */
public enum FtpUploadUrlEnum {
	image("jpg,png,bmp,gif,jpeg", "image"), 
	video("avi,mov,qt,asf,mf", "video"), 
	audio("mp3", "audio"),
	other("", "other");
	
	private String exts;
	
	private String folder;
	
	public String getExts() {
		return exts;
	}

	public void setExts(String exts) {
		this.exts = exts;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	private FtpUploadUrlEnum(String exts, String folder) {
		this.exts = exts;
		this.folder = folder;
	}
	
	public static String getEnumByFileName(String fileName) {
		for (FtpUploadUrlEnum urlEnum : FtpUploadUrlEnum.values()) {
			String[] extArray = urlEnum.getExts().split(",");
			if (extArray != null && extArray.length > 0 ) {
				for (String ext : extArray) {
					if (fileName.toLowerCase().endsWith(ext)) {
						return urlEnum.getFolder();
					}
				}
			}
		}
		
		return FtpUploadUrlEnum.other.getFolder();
	}
}
