package cn.wtu.broadcast.parent.enums;

/**
 * @author sueua
 * @since 2018-12-15
 */
public enum OperationLogTypeEnum {
    /**
     * 新增操作
     */
    INSERT((byte) 1, "新增操作"),
    /**
     * 删除操作
     */
    DELETE((byte) 2, "删除操作"),
    /**
     * 修改操作
     */
    UPDATE((byte) 3, "修改操作"),
    /**
     * 修改操作
     */
    COMMAND((byte) 4, "指令操作");

    private byte value;

    private String desc;

    OperationLogTypeEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
