package cn.wtu.broadcast.parent.enums;

public enum DeviceChannelThirdCodeEnum {

    Microphone(1, "话筒"),
    LineOne(2, "线路一"),
    LineTwo(3, "线路二"),
    UDisk(4, "U盘"),
    FrequencyModulationOne(5, "调频一"),
    FrequencyModulationTwo(6, "调频二"),
    TelephoneMessage(7, "电话短信"),
    TextToLanguageConversion(8, "文本");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private DeviceChannelThirdCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }

    public static DeviceChannelThirdCodeEnum getSexEnumByCode(String code) {
        for (DeviceChannelThirdCodeEnum deviceChannelThirdCodeEnum : DeviceChannelThirdCodeEnum.values()) {
            if (code != null && code.equals(String.valueOf(deviceChannelThirdCodeEnum.getCode()))) {
                return deviceChannelThirdCodeEnum;
            }
        }
        return null;
    }
}
