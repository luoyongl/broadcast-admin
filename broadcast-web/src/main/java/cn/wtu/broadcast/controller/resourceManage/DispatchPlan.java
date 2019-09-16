package cn.wtu.broadcast.controller.resourceManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.DispatchPlanService;
import cn.wtu.broadcast.openapi.vo.DispatchPlanVO;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;

@Controller
@RequestMapping("resourceManage/dispatchPlan")
public class DispatchPlan extends BaseController{
	@Autowired
	private DispatchPlanService dispatchPlanService;
	
	@GetMapping
    public String ui(Model model) {
        return "resourceManage/dispatchPlan";
	}
	
	@RequestMapping("/selectPlanList")
	@ResponseBody
	public BroadcastResult selectPlanList(
			 @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
			 @RequestParam(defaultValue = "10", required = false) Integer pageSize,
			 @RequestParam(defaultValue="", required=false) String searchText){
		 Map<String, Object> paramMap = new HashMap<>(4);
	     paramMap.put("pageNumber", pageNumber);
	     paramMap.put("pageSize", pageSize);
	     paramMap.put("searchText", searchText);
	     return BroadcastResult.ok(dispatchPlanService.queryPage(paramMap));
	}

	@RequestMapping("/addDispatchPlan")
	@ResponseBody
	public BroadcastResult addDispatchPlan(DispatchPlanVO dispatchPlanVO){
		boolean result = dispatchPlanService.addDispatchPlan(dispatchPlanVO);
		if(result){
			return BroadcastResult.build(200,"新增成功");
		}else {
			return BroadcastResult.build(200,"新增失败");
		}
	}
	
	@RequestMapping(value="/updateDispatchPlan")
	@ResponseBody
	public BroadcastResult updateDispatchPlan(DispatchPlanVO dispatchPlanVO,Integer fPlanId){
		dispatchPlanVO.setfPlanId(fPlanId);
		boolean result = dispatchPlanService.updateDispatchPlan(dispatchPlanVO);
		if(result){
			return BroadcastResult.build(200,"修改成功");
		}else {
			return BroadcastResult.build(200,"修改失败");
		}
	}
	
	/**
	 * 删除调度策略
	 * @param idList
	 * @param fBriefClassification
	 * @return BroadcastResult
	 */
	@RequestMapping("/deleteDispatchPlan")
	@ResponseBody
	public BroadcastResult deleteDispatchPlan(@RequestParam(value="fPlanIds") List<Integer> idList){
		return BroadcastResult.build(200,"删除了" + dispatchPlanService.deleteDispatchPlan(idList) + "条记录");
	}
}
