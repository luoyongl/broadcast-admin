package cn.wtu.broadcast.parent.vo;

import java.io.Serializable;
/**
 * 调制参数vo
 * @author lxg
 * @since  2019/02/24
 */
public class ModulationParameter implements Serializable{
	
	private static final long serialVersionUID = 1L;
     
	private String ServiceID;
	private String PCRPID;
	private String DTMB; 
	private String DVBC;
	
	
	public ModulationParameter(String serviceID, String pCRPID, String dTMB, String dVBC) {
		ServiceID = serviceID;
		PCRPID = pCRPID;
		DTMB = dTMB;
		DVBC = dVBC;
	}
	public String getServiceID() {
		return ServiceID;
	}
	public void setServiceID(String serviceID) {
		ServiceID = serviceID;
	}
	public String getPCRPID() {
		return PCRPID;
	}
	public void setPCRPID(String pCRPID) {
		PCRPID = pCRPID;
	}
	public String getDTMB() {
		return DTMB;
	}
	public void setDTMB(String dTMB) {
		DTMB = dTMB;
	}
	public String getDVBC() {
		return DVBC;
	}
	public void setDVBC(String dVBC) {
		DVBC = dVBC;
	}
}
