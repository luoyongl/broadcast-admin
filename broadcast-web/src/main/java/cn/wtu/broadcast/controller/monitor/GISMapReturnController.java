package cn.wtu.broadcast.controller.monitor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.config.RegionData;
import cn.wtu.broadcast.openapi.api.MonitorDeviceService;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.pojo.ZTree;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;

/**
 * @description: 地图回传
 * @author: AYY
 * @date: 2019-01-08 15:10
 */

@Controller
@RequestMapping("monitor/GISMapReturn")
public class GISMapReturnController {
    private final MonitorDeviceService deviceService;

    @Autowired
    public GISMapReturnController(MonitorDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public String ui(Model model){
        List<ZTree> zTreeList = RegionData.getZTreeList();
        if (zTreeList.size() > 0) {
            model.addAttribute("county", JSONUtils.toString(zTreeList.get(0)));
        }
        model.addAttribute("devices", JSONUtils.toString(deviceService.listUserDevice(),true));
        return "monitor/GISMapReturn";
    }
    
    @RequestMapping("/selectConnectInfos")
    @ResponseBody
    public BroadcastResult selectExceptionDeviceInfos(){    	    	
    	return BroadcastResult.ok(deviceService.getConnectInfo());
    }

}


