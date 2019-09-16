package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;

/**
 * Created on 2019/1/21 17:17
 *
 * @author LY
 */
public class TerminalParamVO extends BDeviceInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private Integer fDeviceId;

    private String fFmReceiveRate;

    private String fFmSignalStrength;

    private String fEmergencyBroadcastMesStatus;

    public Integer getfDeviceId() {
        return fDeviceId;
    }

    public void setfDeviceId(Integer fDeviceId) {
        this.fDeviceId = fDeviceId;
    }

    public String getfFmReceiveRate() {
        return fFmReceiveRate;
    }

    public void setfFmReceiveRate(String fFmReceiveRate) {
        this.fFmReceiveRate = fFmReceiveRate;
    }

    public String getfFmSignalStrength() {
        return fFmSignalStrength;
    }

    public void setfFmSignalStrength(String fFmSignalStrength) {
        this.fFmSignalStrength = fFmSignalStrength;
    }

    public String getfEmergencyBroadcastMesStatus() {
        return fEmergencyBroadcastMesStatus;
    }

    public void setfEmergencyBroadcastMesStatus(String fEmergencyBroadcastMesStatus) {
        this.fEmergencyBroadcastMesStatus = fEmergencyBroadcastMesStatus;
    }
}

