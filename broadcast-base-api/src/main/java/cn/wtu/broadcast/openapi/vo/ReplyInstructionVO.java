package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

public class ReplyInstructionVO implements Serializable{

	private static final long serialVersionUID = -5217768445590797180L;

	/**
	 * 包头标记
	 */
	private String fHeadmark;

	/**
	 * 协议版本号
	 */
    private String fVersion;

    /**
	 * 会话标识
	 */
    private String fTag;

    /**
	 * 数据包类型
	 */
    private String fPacktype;

    /**
	 * 数据源对象编码
	 */
    private String fSource;

    /**
	 * 业务数据类型
	 */
    private String fDatatype;

    /**
	 * 字符串格式下的json数据
	 */
    private String fRespondInstructions;

	public String getfHeadmark() {
		return fHeadmark;
	}

	public void setfHeadmark(String fHeadmark) {
		this.fHeadmark = fHeadmark;
	}

	public String getfVersion() {
		return fVersion;
	}

	public void setfVersion(String fVersion) {
		this.fVersion = fVersion;
	}

	public String getfTag() {
		return fTag;
	}

	public void setfTag(String fTag) {
		this.fTag = fTag;
	}

	public String getfPacktype() {
		return fPacktype;
	}

	public void setfPacktype(String fPacktype) {
		this.fPacktype = fPacktype;
	}

	public String getfSource() {
		return fSource;
	}

	public void setfSource(String fSource) {
		this.fSource = fSource;
	}

	public String getfDatatype() {
		return fDatatype;
	}

	public void setfDatatype(String fDatatype) {
		this.fDatatype = fDatatype;
	}

	public String getfRespondInstructions() {
		return fRespondInstructions;
	}

	public void setfRespondInstructions(String fRespondInstructions) {
		this.fRespondInstructions = fRespondInstructions;
	}

	@Override
	public String toString() {
		return "ReplyInstructionVO [fHeadmark=" + fHeadmark + ", fVersion=" + fVersion + ", fTag=" + fTag
				+ ", fPacktype=" + fPacktype + ", fSource=" + fSource + ", fDatatype=" + fDatatype
				+ ", fRespondInstructions=" + fRespondInstructions + "]";
	}
    
}
