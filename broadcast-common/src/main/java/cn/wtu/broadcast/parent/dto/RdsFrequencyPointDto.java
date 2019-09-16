package cn.wtu.broadcast.parent.dto;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import cn.wtu.broadcast.parent.vo.cmd.RdsFrequencyPointVo;

/**
 * rds参数传递封装适配
 * @author yinjie
 *
 */

public class RdsFrequencyPointDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<RdsFrequencyPointVo> rdsFrequencyPointVoList = Lists.newArrayList();

	public List<RdsFrequencyPointVo> getRdsFrequencyPointVoList() {
		return rdsFrequencyPointVoList;
	}

	public void setRdsFrequencyPointVoList(List<RdsFrequencyPointVo> rdsFrequencyPointVoList) {
		this.rdsFrequencyPointVoList = rdsFrequencyPointVoList;
	}

	@Override
	public String toString() {
		return "RdsFrequencyPointDto [rdsFrequencyPointVoList=" + rdsFrequencyPointVoList + "]";
	}
	
}
