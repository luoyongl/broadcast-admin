package cn.wtu.broadcast.parent.dto;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import cn.wtu.broadcast.parent.vo.cmd.SetResourceCodeVo;

/**
 * 资源编码设置适配
 * @author yinjie
 *
 */

public class SetResourceCodeDto implements Serializable{

	private static final long serialVersionUID = 1L;

	//资源编码设置(list)
	private List<SetResourceCodeVo> setResourceCodeVoList = Lists.newArrayList();

	public List<SetResourceCodeVo> getSetResourceCodeVoList() {
		return setResourceCodeVoList;
	}

	public void setSetResourceCodeVoList(List<SetResourceCodeVo> setResourceCodeVoList) {
		this.setResourceCodeVoList = setResourceCodeVoList;
	}

	@Override
	public String toString() {
		return "SetResourceCodeDto [setResourceCodeVoList=" + setResourceCodeVoList + "]";
	}

}
