package cn.wtu.broadcast.parent.enums;

/**
 * 告警类型
 *
 * @author sueua
 * @date 2019/1/21
 */
public enum AlarmTypeEnum {
    /**
     * CPU
     */
    CPU((byte)1, "CPU使用过高"),
    /**
     * 内存
     */
    MEMORY((byte)2, "内存使用过高"),
    /**
     * 磁盘
     */
    DISK((byte)3, "磁盘空间不足");

    private Byte value;

    private String desc;

    AlarmTypeEnum(Byte value, String desc) {
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
