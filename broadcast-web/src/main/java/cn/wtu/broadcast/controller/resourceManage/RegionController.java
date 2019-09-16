package cn.wtu.broadcast.controller.resourceManage;

import cn.wtu.broadcast.config.RegionData;
import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.MonitorDeviceService;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.pojo.ZTree;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 区域管理
 *
 * @author sueua
 * @date 2019/1/7
 */
@Controller
@RequestMapping("resourceManage/region")
public class RegionController extends BaseController {
    private final MonitorDeviceService deviceService;

    @Autowired
    public RegionController(MonitorDeviceService deviceService) {
        this.deviceService = deviceService;
    }


    /**
     * 界面
     */
    @GetMapping
    public String ui(Model model) {
        List<ZTree> zTreeList = RegionData.getZTreeList();
        if (zTreeList.size() > 0) {
            model.addAttribute("county", JSONUtils.toString(zTreeList.get(0)));
        }
        model.addAttribute("devices", JSONUtils.toString(deviceService.listUserDevice(),true));
        return "resourceManage/region";
    }

    /**
     * 保存设备信息(经纬度)
     */
    @PostMapping
    @ResponseBody
    public BroadcastResult save(BDeviceInfo deviceInfo) {
        if (deviceService.updateByPrimaryKeySelective(deviceInfo) > 0) {
            return BroadcastResult.ok();
        } else {
            return BroadcastResult.fail();
        }
    }
}
