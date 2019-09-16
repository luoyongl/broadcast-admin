package cn.wtu.broadcast.controller;

import cn.wtu.broadcast.config.RegionData;
import cn.wtu.broadcast.openapi.api.AudioManageService;
import cn.wtu.broadcast.openapi.api.BProgramChannelService;
import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.api.TAdministrativeDivisionService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.BAudioData;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BProgramChannel;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;
import cn.wtu.broadcast.parent.utils.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("broadcast/programProduce")
public class ProgramController extends BaseController{

	@Autowired
	private TDictionaryService tDictionaryService;
	@Autowired
	private BProgramChannelService bProgramChannelService;
	@Autowired
	private EmergencyDeviceService emergencyDeviceService;
	@Autowired
	private AudioManageService audioManageService;
    @Autowired
    private TAdministrativeDivisionService tAdministrativeDivisionService;

	//节目制作页面加载
	@GetMapping
	public String ui(Model model){
	
		//根据通道类型和媒体类型封装所有相应类型的list，点击新增时能加载所有的类型
		List<TDictionary> channelList = tDictionaryService.selectListByCriteria("program_channel");
		List<TDictionary> medaiTypeList = tDictionaryService.selectListByCriteria("streaming_media_type");
		List<BDeviceInfo> deviceInfos=emergencyDeviceService.selectDeviceForTelList((byte) DeviceTypeEnum.frontDevice.getCode());
		List<BAudioData> audioList = audioManageService.getAll();
		model.addAttribute("channelList", channelList);
		model.addAttribute("medaiTypeList", medaiTypeList);
		model.addAttribute("regionList", JSONUtils.toString(RegionData.getUserZTreeList()));
		model.addAttribute("deviceInfos",deviceInfos);
		model.addAttribute("audioList",audioList);
		return "broadcast/programProduce";	
	}

	/**
	 * Bootstrap Table 数据
	 */
	@GetMapping("/list")
	@ResponseBody
	public BroadcastResult programList(@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
									 @RequestParam(defaultValue = "10", required = false) Integer pageSize,
									 @RequestParam(defaultValue="", required=false) String searchText,
									 @RequestParam(defaultValue="desc", required=false) String sortOrder,
									 @RequestParam(defaultValue="f_id", required=false) String sortName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pageNo", pageNumber);
		paramMap.put("pageSize", pageSize);
		paramMap.put("searchText",searchText);
		paramMap.put("sortOrder",sortOrder);
		paramMap.put("sortName",StringUtil.FieldNameToColumnName(sortName));
		return BroadcastResult.ok(bProgramChannelService.queryPageByParams(paramMap));
	}
	
	@PostMapping
	@ResponseBody
	public BroadcastResult add(BProgramChannel bProgramChannel,String areaIds){
		
        // 设置区域Id之前,需要简化
        String regionIds = tAdministrativeDivisionService.simplifyRegionIds(areaIds);
		bProgramChannel.setfBroadcastArea(regionIds);
		
		boolean result = bProgramChannelService.addProgramChannel(bProgramChannel);
		if(result){
			return BroadcastResult.build(200,"新增成功");
		}else {
			return BroadcastResult.build(200,"新增失败");
		}
	}
	
	@DeleteMapping
	@ResponseBody
	public BroadcastResult delete(@RequestParam(value="ids") List<Integer> idList){
		return BroadcastResult.build(200,"删除了" + bProgramChannelService.deleteProgramByIds(idList) + "条记录");
	}


	@RequestMapping(value="/updateById")
	@ResponseBody
	public BroadcastResult updateProgram(BProgramChannel bProgramChannel,
										 @RequestParam(value = "fId") String fId,
										 @RequestParam(value = "areaIds") String areaIds){
		bProgramChannel.setfBroadcastArea(areaIds);
		boolean result = bProgramChannelService.updateProgramChannel(bProgramChannel,fId);
		if(result){
			return BroadcastResult.build(200,"修改成功");
		}else {
			return BroadcastResult.build(200,"修改失败");
		}

	}

	@RequestMapping(value="/check")
	@ResponseBody
	public BroadcastResult check(String name){
		List<BProgramChannel> programChannelList = bProgramChannelService.getAll();
		for(BProgramChannel programChannel:programChannelList){
			if(programChannel.getfPassName().equals(name)){
				return BroadcastResult.ok("true");
			}
		}
		return BroadcastResult.ok("false");
	}

}
