package cn.wtu.broadcast.parent.enums;

/**
 * 短信响应
 *
 * @author sueua
 * @since 2019-02-15
 */
public enum SmsResponseEnum {
    /**
     * 成功
     */
    OK("Send OK", "发送成功"),
    /**
     * 无卡
     */
    NO_CARD("No Card", "无卡"),
    /**
     * 不在线
     */
    NO_REGISTER("No Register", "不在线"),
    /**
     * 连接超时
     */
    TIMEOUT("Timeout", "连接超时"),
    /**
     * 发送错误
     */
    ERROR("Error", "发送错误"),
    /**
     * 其他状态
     */
    OTHER("Other", "未知错误");

    private String value;

    private String desc;

    SmsResponseEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static SmsResponseEnum getEnum(String value) {
        SmsResponseEnum[] smsResponseEnums = SmsResponseEnum.values();
        for (SmsResponseEnum smsResponseEnum : smsResponseEnums) {
            if (smsResponseEnum.getValue().equals(value)) {
                return smsResponseEnum;
            }
        }
        return SmsResponseEnum.OTHER;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
