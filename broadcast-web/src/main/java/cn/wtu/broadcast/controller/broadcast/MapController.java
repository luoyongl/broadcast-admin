package cn.wtu.broadcast.controller.broadcast;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wtu.broadcast.config.RegionData;
import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.BProgramChannelService;
import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.api.RegionService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BProgramChannel;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.ZTree;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;

/**
 * 地图广播控制器
 *
 * @author sueua
 * @since 2019-01-04
 */
@Controller
@RequestMapping("broadcast/map")
public class MapController extends BaseController {

    @SuppressWarnings("unused")
	private final RegionService regionService;

    private final EmergencyDeviceService emergencyDeviceService;

    private final TDictionaryService tDictionaryService;

    private final BProgramChannelService bProgramChannelService;

    @Autowired
    public MapController(RegionService regionService,
                         EmergencyDeviceService emergencyDeviceService,
                         TDictionaryService tDictionaryService,
                         BProgramChannelService bProgramChannelService) {
        this.regionService = regionService;
        this.emergencyDeviceService=emergencyDeviceService;
        this.tDictionaryService=tDictionaryService;
        this.bProgramChannelService=bProgramChannelService;
    }

    /**
     * 基础数据页面
     */
    @SuppressWarnings("unused")
	@GetMapping
    public String ui(Model model) {
        List<BDeviceInfo> deviceInfos=emergencyDeviceService.selectDeviceForTelList((byte) DeviceTypeEnum.frontDevice.getCode());
        List<ZTree> zTreeList = RegionData.getZTreeList();
        List<TDictionary> channelList = tDictionaryService.selectListByCriteria("program_channel");
        // 节目选择
        List<BProgramChannel> programList = bProgramChannelService.getAll();
        if(zTreeList.size()>0){
            model.addAttribute("county", JSONUtils.toString(zTreeList.get(0)));
        }
        model.addAttribute("deviceInfos",deviceInfos);
        model.addAttribute("regionPoints", JSONUtils.toString(RegionData.getUserZTreeList()));
        return "broadcast/map";
    }
}
