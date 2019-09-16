package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

/**
 * 网卡
 *
 * @author sueua
 * @since 2019-01-21
 */
public class NetworkCard implements Serializable {

    private static final long serialVersionUID = 8957529882357978825L;

    /**
     * 网卡名称
     */
    private String cardName;

    /**
     * MAC地址
     */
    private String macAddr;

    /**
     * IP地址
     */
    private String ipAddr;

    /**
     * 接收数据包数量
     */
    private Long packetsRecv;

    /**
     * 发送数据包数量
     */
    private Long packetsSent;

    /**
     * 接收数据大小(Byte)
     */
    private Long bytesRecv;

    /**
     * 发送数据大小(Byte)
     */
    private Long bytesSent;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Long getPacketsRecv() {
        return packetsRecv;
    }

    public void setPacketsRecv(Long packetsRecv) {
        this.packetsRecv = packetsRecv;
    }

    public Long getPacketsSent() {
        return packetsSent;
    }

    public void setPacketsSent(Long packetsSent) {
        this.packetsSent = packetsSent;
    }

    public Long getBytesRecv() {
        return bytesRecv;
    }

    public void setBytesRecv(Long bytesRecv) {
        this.bytesRecv = bytesRecv;
    }

    public Long getBytesSent() {
        return bytesSent;
    }

    public void setBytesSent(Long bytesSent) {
        this.bytesSent = bytesSent;
    }
}
