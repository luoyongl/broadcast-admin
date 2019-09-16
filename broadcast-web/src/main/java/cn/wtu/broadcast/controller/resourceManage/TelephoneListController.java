package cn.wtu.broadcast.controller.resourceManage;

import cn.wtu.broadcast.openapi.api.BCallandsmsRecordService;
import cn.wtu.broadcast.openapi.api.BWhitelistService;
import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BWhitelist;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.enums.SmsAndRecordEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/resourceManage/telephoneList")
public class TelephoneListController {
	@Autowired
	BWhitelistService rWhitelistService;
	
	@Autowired
	BCallandsmsRecordService rCallandsmsRecordService;
	
	@Autowired
	EmergencyDeviceService emergencyDeviceService;
	
	@GetMapping 
	public String ui(Model model){
		List<BDeviceInfo> deviceInfos=emergencyDeviceService.selectDeviceForTelList((byte) DeviceTypeEnum.frontDevice.getCode());
		model.addAttribute("deviceInfos",deviceInfos);
		return "resourceManage/telephoneList";
	}
	
	@RequestMapping("/addwhiteList")
	@ResponseBody
	public BroadcastResult addwhitelist(BWhitelist bWhitelist,
			@RequestParam(value="resourceId",defaultValue="")String resourceId,
			@RequestParam(value="fPermit",defaultValue="")String fPermit){
		bWhitelist.setfResourceCode(resourceId);
		bWhitelist.setfPermit(Byte.valueOf(fPermit));
		bWhitelist.setfUpdateTime(new Date());
		if(rWhitelistService.addwhitelist(bWhitelist)){
			return BroadcastResult.ok();
		}else{
			return BroadcastResult.fail();
		}
	}
	
	@RequestMapping("/selectwhitelist")
	@ResponseBody
	public BroadcastResult selectwhitelist(
			@RequestParam(defaultValue="desc", required=false) String sortOrder,
			@RequestParam(defaultValue="fCreateTime", required=false) String sortName ,
			@RequestParam(defaultValue="", required=false) String searchText,
			@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize){
		 Map<String, Object> paramMap = new HashMap<>(4);
	     paramMap.put("pageNumber", pageNumber);
	     paramMap.put("pageSize", pageSize);
	     paramMap.put("searchText", searchText);
	     paramMap.put("sortOrder",sortOrder);
	     if (sortName.equals("fCreateTime")) {
				paramMap.put("sortName", "f_create_time");
			}
	    return BroadcastResult.ok(rWhitelistService.queryPage(paramMap));
	}
	
	@RequestMapping("/updatewhitelist/{fId}")
	@ResponseBody
	public BroadcastResult updatewhitelistById(@PathVariable Integer fId,
			BWhitelist bWhitelist,
			@RequestParam(value="resourceId",defaultValue="")String resourceId){
		bWhitelist.setfId(fId);
		bWhitelist.setfResourceCode(resourceId);
		bWhitelist.setfUpdateTime(new Date());
		if (rWhitelistService.updatewhitelistById(bWhitelist)) {
			return BroadcastResult.ok();
		}else{
			return BroadcastResult.fail();
		}		
	}
	
	@RequestMapping("/deletewhitelist")
	@ResponseBody
	public BroadcastResult deletewhitelist(@RequestParam(value="fId")String fId){
		return BroadcastResult.build(200, "删除了"+rWhitelistService.deletewhitelist(fId)+"条记录");
		
	}
	@RequestMapping("/checkwhitelist")
	@ResponseBody
	public BroadcastResult checkWhiteList(@RequestParam(value="title")String title){
		if (rWhitelistService.checkwhiteList(title)) {
			return BroadcastResult.build(400, "重复");
		}else{
			return BroadcastResult.build(200, "可添加");
		}
	}
	
	@RequestMapping("/selectSms")
	@ResponseBody
	public BroadcastResult selectSms(
			@RequestParam(defaultValue="desc", required=false) String sortOrder,
			@RequestParam(defaultValue="fCreateTime", required=false) String sortName ,
			@RequestParam(defaultValue="", required=false) String searchText,
			@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize){
		 Map<String, Object> paramMap = new HashMap<>(4);
	     paramMap.put("pageNumber", pageNumber);
	     paramMap.put("pageSize", pageSize);
	     paramMap.put("searchText", searchText);
	     paramMap.put("sortOrder",sortOrder);
	     paramMap.put("type", SmsAndRecordEnum.SMS.getCode());
	     if (sortName.equals("fCreateTime")) {
				paramMap.put("sortName", "f_create_time");
			}
		return BroadcastResult.ok(rCallandsmsRecordService.queryPageByParam(paramMap));
		
	}
	
	@RequestMapping("/selectRecord")
	@ResponseBody
	public BroadcastResult selectRecord(
			@RequestParam(defaultValue="desc", required=false) String sortOrder,
			@RequestParam(defaultValue="fCreateTime", required=false) String sortName ,
			@RequestParam(defaultValue="", required=false) String searchText,
			@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize){
		 Map<String, Object> paramMap = new HashMap<>(4);
	     paramMap.put("pageNumber", pageNumber);
	     paramMap.put("pageSize", pageSize);
	     paramMap.put("searchText", searchText);
	     paramMap.put("sortOrder",sortOrder);
	     paramMap.put("type", SmsAndRecordEnum.RECORD.getCode());
	     if (sortName.equals("fCreateTime")) {
				paramMap.put("sortName", "f_create_time");
			}
		return BroadcastResult.ok(rCallandsmsRecordService.queryPageByParam(paramMap));
		
	}
}
