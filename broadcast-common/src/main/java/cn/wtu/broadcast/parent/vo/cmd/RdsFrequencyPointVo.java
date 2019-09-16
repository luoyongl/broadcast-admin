package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;

/**
 * RDS设置频点VO
 * @author yinjie
 *
 */

public class RdsFrequencyPointVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//频点序号
	private Integer rdsPointSequence;
	
	//频点优先级
	private Integer rdsPriority;
	
	//频率
	private Double rdsFrequency;

	public Integer getRdsPointSequence() {
		return rdsPointSequence;
	}

	public void setRdsPointSequence(Integer rdsPointSequence) {
		this.rdsPointSequence = rdsPointSequence;
	}

	public Integer getRdsPriority() {
		return rdsPriority;
	}

	public void setRdsPriority(Integer rdsPriority) {
		this.rdsPriority = rdsPriority;
	}

	public Double getRdsFrequency() {
		return rdsFrequency;
	}

	public void setRdsFrequency(Double rdsFrequency) {
		this.rdsFrequency = rdsFrequency;
	}

	@Override
	public String toString() {
		return "RdsFrequencyPointVo [rdsPointSequence=" + rdsPointSequence + ", rdsPriority=" + rdsPriority
				+ ", rdsFrequency=" + rdsFrequency + "]";
	}
	
}
