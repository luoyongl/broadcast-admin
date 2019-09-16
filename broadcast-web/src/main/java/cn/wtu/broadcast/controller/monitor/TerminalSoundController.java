package cn.wtu.broadcast.controller.monitor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.TerminalStatusService;
import cn.wtu.broadcast.openapi.vo.TerminalStatusVO;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-08 15:02
 */

@Controller
@RequestMapping("monitor/terminalSound")
public class TerminalSoundController {

    @Autowired
    private TerminalStatusService terminalStatusService;


    @GetMapping
    public String ui() {
        return "monitor/terminalSound";
    }

    @RequestMapping("/selectTerminalSoundList")
    @ResponseBody
    public BroadcastResult selectTerminalStatusList(
            @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(defaultValue = "", required = false) String searchText,
            @RequestParam(defaultValue = "0", required = false) Integer devType,
            @RequestParam Integer fBroadcastType) {
        Map<String, Object> paramMap = new HashMap<>();
        if (fBroadcastType == 1) {
            paramMap.put("fBroadcastType", BroadcastStateEnum.broadcasting.getCode());
        } else {
            paramMap.put("fBroadcastType", BroadcastStateEnum.broadcasted.getCode());
        }
        if (devType == DeviceTypeEnum.adapter.getCode()) {
            paramMap.put("devType", DeviceTypeEnum.adapter.getCode());
        } else {
            paramMap.put("devType", null);
        }
        paramMap.put("searchaudio",true);
        paramMap.put("searchText", searchText);
        paramMap.put("pageNumber", pageNumber);
        paramMap.put("pageSize", pageSize);
        PageInfo<TerminalStatusVO> pageInfo = terminalStatusService.queryPageByTeminalStatusType(paramMap);
        return BroadcastResult.ok(pageInfo);
    }
}
