package cn.wtu.broadcast.controller;

import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.vo.BroadCastDataVO;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainPageController {
	
	@Autowired
	BBroadcastDataService bBroadcastDataService;


	@RequestMapping("main")
	public String ui(Model model){
		//一下内容为了暂时展示 数据已固定 后期需重新完善
		model.addAttribute("rank_1",bBroadcastDataService.selectBroadByType(12));
		model.addAttribute("rank_2",bBroadcastDataService.selectBroadByType(13));
		model.addAttribute("rank_3",bBroadcastDataService.selectBroadByType(14));
		model.addAttribute("rank_4",bBroadcastDataService.selectBroadByType(15));
		model.addAttribute("countByTime",bBroadcastDataService.countBytime());
		return "home/main";
	}
	
	/**
	 * @Desc 查询正在播出的广播信息
	 * @Date 2019-01-04
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("selectBeingBroadCast")
	@ResponseBody
	public BroadcastResult selectBeingBroadCast(){
		
		List<BroadCastDataVO> list = bBroadcastDataService.selectBeingBroadCast(BroadcastStateEnum.broadcasting.getCode());
		
		return BroadcastResult.ok(list);
	}
	
	/**
	 * @Desc 查询待播发的广播信息
	 * @Date 2019-01-04
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("selectwaitingBroadCast")
	@ResponseBody
	public BroadcastResult selectwaitingBroadCast(
			  @RequestParam(defaultValue="1", required=false) Integer pageNumber, 
			  @RequestParam(defaultValue="10", required=false) Integer pageSize,
			  @RequestParam(defaultValue="", required=false) String searchText){
		Map<String, Object> paramMap = new HashMap<>(4);
		paramMap.put("pageNumber", pageNumber);
		paramMap.put("pageSize", pageSize);
		paramMap.put("searchText", searchText);
	
		
		return BroadcastResult.ok(bBroadcastDataService.selectwaitingBroadCast(paramMap, BroadcastStateEnum.waitBroadcast.getCode()));
	}
	
	/**
	 * @Desc 根据fId查询该广播详细信息
	 * @Date 2019-01-06
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("selectBeingBroadcastInfo/{fId}")
	@ResponseBody
	public BroadcastResult selectBeingBroadcastInfo(@PathVariable Integer fId){
		
		return BroadcastResult.ok(bBroadcastDataService.selectBroadCastById(fId));
	}
}
