package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

public class DispatchPlanVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer fPlanId;
	
	private String planName;
	
	private String planDescribe;

	public Integer getfPlanId() {
		return fPlanId;
	}

	public void setfPlanId(Integer fPlanId) {
		this.fPlanId = fPlanId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDescribe() {
		return planDescribe;
	}

	public void setPlanDescribe(String planDescribe) {
		this.planDescribe = planDescribe;
	}

	
	
	

}
