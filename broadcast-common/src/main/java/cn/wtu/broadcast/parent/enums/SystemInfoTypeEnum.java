package cn.wtu.broadcast.parent.enums;

/**
 * 系统信息记录类型
 *
 * @author sueua
 * @date 2019/1/21
 */
public enum SystemInfoTypeEnum {
    /**
     * CPU
     */
    CPU((byte) 1, "CPU"),
    /**
     * 内存
     */
    MEMORY((byte) 2, "内存");

    private Byte value;

    private String desc;

    SystemInfoTypeEnum(Byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
