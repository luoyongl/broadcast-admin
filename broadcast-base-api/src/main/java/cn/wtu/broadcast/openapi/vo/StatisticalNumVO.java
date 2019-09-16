package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

public class StatisticalNumVO  implements Serializable{

	private static final long serialVersionUID = 1L;
	private String shouldPlayTerminalNum;
    private String alreadyPlayTerminalNum;
    private String NotPlayTerminalNum;

    public String getShouldPlayTerminalNum() {
        return shouldPlayTerminalNum;
    }

    public void setShouldPlayTerminalNum(String shouldPlayTerminalNum) {
        this.shouldPlayTerminalNum = shouldPlayTerminalNum;
    }

    public String getAlreadyPlayTerminalNum() {
        return alreadyPlayTerminalNum;
    }

    public void setAlreadyPlayTerminalNum(String alreadyPlayTerminalNum) {
        this.alreadyPlayTerminalNum = alreadyPlayTerminalNum;
    }

    public String getNotPlayTerminalNum() {
        return NotPlayTerminalNum;
    }

    public void setNotPlayTerminalNum(String notPlayTerminalNum) {
        NotPlayTerminalNum = notPlayTerminalNum;
    }

    /*//文本
    private String text;

    //话筒
    private String microphone;

    //线路
    private String line;

    //调频
    private String requencyModulation;

    //电话，短信
    private String phone;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMicrophone() {
        return microphone;
    }

    public void setMicrophone(String microphone) {
        this.microphone = microphone;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getRequencyModulation() {
        return requencyModulation;
    }

    public void setRequencyModulation(String requencyModulation) {
        this.requencyModulation = requencyModulation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }*/
}
