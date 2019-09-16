package cn.wtu.broadcast.parent.enums;

/**
 * 自动备份类型
 *
 * @author sueua
 * @since 2019-01-15
 */
public enum BackupTypeEnum {
    /**
     * 每天
     */
    EVERYDAY(1, "每天"),
    /**
     * 每周
     */
    WEEKLY(2, "每周"),
    /**
     * 每月
     */
    MONTHLY(3, "每月");

    private Integer value;

    private String desc;

    BackupTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
