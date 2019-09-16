package cn.wtu.broadcast.controller.monitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-08 14:56
 */

@Controller
@RequestMapping("monitor/terminalParam")
public class TerminalParamController {
    @GetMapping
    public String ui() {
        return "monitor/terminalParam";
    }


}
