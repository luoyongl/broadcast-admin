package cn.wtu.broadcast.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.config.RegionData;
import cn.wtu.broadcast.openapi.api.AlarmPrincipalService;
import cn.wtu.broadcast.parent.enums.SmsResponseEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.pojo.ZTree;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;
import cn.wtu.broadcast.parent.utils.string.StringUtil;
import cn.wtu.broadcast.util.SmsUtil;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-05 16:01
 */

@Controller
@RequestMapping("/systemManage/SMSWarning")
public class AlarmPrincipalController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(AlarmPrincipalController.class);

    @Autowired
    private AlarmPrincipalService alarmPrincipalService;

    @GetMapping
    public String ui(Model model) {
        model.addAttribute("regionList", JSONUtils.toString(RegionData.getUserZTreeList()));

        return "systemManage/SMSWarning";
    }

    @PostMapping
    @ResponseBody
    public BroadcastResult add(@RequestParam("ids") List<Integer> ids) {
        Integer result = alarmPrincipalService.addPrincipal(ids);
        return BroadcastResult.build(200, "新增了" + result + "条记录");

    }

    /**
     * 短信测试
     */
    @PostMapping("test")
    @ResponseBody
    public BroadcastResult test(@RequestParam String mobile, @RequestParam String text) {
        SmsResponseEnum send = SmsUtil.send(mobile, text);
        if (send == SmsResponseEnum.OK) {
            return BroadcastResult.build(200, send.getDesc());
        }
        return BroadcastResult.fail(send.getDesc());
    }

    @GetMapping("/list")
    @ResponseBody
    public BroadcastResult programList(@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
                                       @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                       @RequestParam(defaultValue = "", required = false) String searchText,
                                       @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                       @RequestParam(defaultValue = "f_id", required = false) String sortName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNo", pageNumber);
        paramMap.put("pageSize", pageSize);
        paramMap.put("searchText", searchText);
        paramMap.put("sortOrder", sortOrder);
        paramMap.put("sortName", StringUtil.FieldNameToColumnName(sortName));
        return BroadcastResult.ok(alarmPrincipalService.queryPageByParam(paramMap));
    }

    @RequestMapping("select")
    @ResponseBody
    public BroadcastResult select() {

        try {
            List<ZTree> treeList = RegionData.getUserZTreeList();
            List<Integer> idList = new ArrayList<>();
            treeList.forEach(tree -> {
                idList.add(tree.getId());
            });
            Map<Integer, Map<Integer, String>> map = alarmPrincipalService.selectUserByRegionId(idList);
            return BroadcastResult.ok(map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return BroadcastResult.fail();
    }

    @DeleteMapping
    @ResponseBody
    public BroadcastResult delete(@RequestParam(value = "ids") List<Integer> idList) {
        return BroadcastResult.build(200, "删除了" + alarmPrincipalService.deleteProgramByIds(idList) + "条记录");
    }
}
