package cn.wtu.broadcast.controller.monitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-08 15:23
 */
@Controller
@RequestMapping("monitor/mapMonitor")
public class MapMonitorController {

    @GetMapping
    public String ui(){
        return "monitor/mapMonitor";
    }
}
