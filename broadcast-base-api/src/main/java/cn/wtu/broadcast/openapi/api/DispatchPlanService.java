package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.vo.DispatchPlanVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface DispatchPlanService extends ParentService<DispatchPlanVO>{
	
	//分页
	public PageInfo<DispatchPlanVO> queryPage(Map<String, Object> paramMap);
	
	//新增_策略
	public boolean addDispatchPlan(DispatchPlanVO dispatchPlanVO);
	
	//修改_策略
	public boolean updateDispatchPlan(DispatchPlanVO dispatchPlanVO);
	
	//删除_策略
	public int deleteDispatchPlan(List<Integer> idList);
}
