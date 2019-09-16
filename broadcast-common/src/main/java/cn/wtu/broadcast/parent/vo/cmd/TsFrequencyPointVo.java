package cn.wtu.broadcast.parent.vo.cmd;

import java.io.Serializable;

/**
 * TS设置频点VO
 * @author yinjie
 *
 */
public class TsFrequencyPointVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//主频频率
	private Integer frequency;
	
	//符号率
	private Integer symbolRate;
	
	//qam
	private Integer qamNumber;

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getSymbolRate() {
		return symbolRate;
	}

	public void setSymbolRate(Integer symbolRate) {
		this.symbolRate = symbolRate;
	}

	public Integer getQamNumber() {
		return qamNumber;
	}

	public void setQamNumber(Integer qamNumber) {
		this.qamNumber = qamNumber;
	}

	@Override
	public String toString() {
		return "TsFrequencyPointVo [frequency=" + frequency + ", symbolRate=" + symbolRate + ", qamNumber=" + qamNumber
				+ "]";
	}

	
}
