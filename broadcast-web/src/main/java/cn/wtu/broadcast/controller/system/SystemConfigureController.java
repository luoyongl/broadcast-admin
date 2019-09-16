package cn.wtu.broadcast.controller.system;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.config.SystemConfig;
import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.util.TtsUtil;

/**
 * 系统配置管理器
 *
 * @author sueua
 * @since 2018-12-15
 */
@Controller
@RequestMapping("systemManage/systemConfigure")
public class SystemConfigureController extends BaseController {

    private final SystemConfigurationService systemConfigurationService;

    @Autowired
    public SystemConfigureController(SystemConfigurationService systemConfigurationService) {
        this.systemConfigurationService = systemConfigurationService;
    }

    /**
     * 系统配置页面
     */
    @GetMapping
    public String ui() {
        return "systemManage/systemConfigure";
    }

    /**
     * 系统配置页面
     */
    @PutMapping
    @ResponseBody
    public BroadcastResult update(@RequestParam Map<String, String> configMap) {
        int num = systemConfigurationService.update(configMap);
        TtsUtil.update();
            if (num > 0) {
            //重新刷新配置
            SystemConfig.reload();
            return BroadcastResult.ok();
        } else {
            return BroadcastResult.build(400, "配置未更改");
        }
    }
}
