package cn.wtu.broadcast.controller.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.api.AlarmRecordService;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.enums.AlarmTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;

@Controller
@RequestMapping("/systemManage/systemWarning")
public class SystemWarningController {

    private final AlarmRecordService alarmRecordService;

    @Autowired
    public SystemWarningController(AlarmRecordService alarmRecordService) {
        this.alarmRecordService = alarmRecordService;
    }

    @GetMapping
    public String ui(Model model) {
        Map<Byte, String> alarmTypeEnumMap = Arrays.stream(AlarmTypeEnum.values()).collect(Collectors.toMap(AlarmTypeEnum::getValue, AlarmTypeEnum::getDesc));
        List<String> alarmTypeTextList = new ArrayList<>();
        alarmTypeEnumMap.forEach((key, value) -> alarmTypeTextList.add(value));
        model.addAttribute("alarmTypeTextList", JSONUtils.toString(alarmTypeTextList));
        model.addAttribute("alarmTypeEnumMap", JSONUtils.toString(alarmTypeEnumMap));
        List<Map<String, Object>> chartData = new ArrayList<>();
        alarmRecordService.getChartData().forEach((key,value)->{
            Map<String, Object> map = new HashMap<>();
            map.put("name", key);
            map.put("value", value);
            chartData.add(map);
        });
        model.addAttribute("chartData", JSONUtils.toString(chartData));
        return "systemManage/systemWarning";
    }

    @GetMapping("data")
    @ResponseBody
    public BroadcastResult data(@RequestParam(value = TableConst.PAGE_NO_STR, defaultValue = TableConst.PAGE_NO_DEFAULT_VALUE, required = false) Integer pageNumber,
                                @RequestParam(value = TableConst.PAGE_SIZE_STR, defaultValue = TableConst.PAGE_SIZE_DEFAULT_VALUE, required = false) Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>(4);
        paramMap.put(TableConst.PAGE_NO_STR, pageNumber);
        paramMap.put(TableConst.PAGE_SIZE_STR, pageSize);
        return BroadcastResult.ok(alarmRecordService.queryPageByParam(paramMap));
    }
}
