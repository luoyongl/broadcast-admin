package cn.wtu.broadcast.parent.enums;

/**
 * 
 * 21包的类型(DVBC, DTMB) 用来当作key值的一部分
 * 
 */
public enum BroadcastTypeKeyEnum {
	DVBC(1, "DVBC"), DTMB(2, "DTMB");

    private Integer code;

    private String desc;

    BroadcastTypeKeyEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setValue(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
