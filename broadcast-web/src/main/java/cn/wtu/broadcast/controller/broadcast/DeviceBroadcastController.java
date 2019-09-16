package cn.wtu.broadcast.controller.broadcast;

import cn.wtu.broadcast.openapi.api.*;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BProgramChannel;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;

import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2019/4/5 15:22
 *
 * @author LY
 */


@Controller
@RequestMapping("broadcast/deviceBroadcast")
public class DeviceBroadcastController {

    public Map<Integer, String> map = new HashMap<>();

    @Autowired
    private TDictionaryService tDictionaryService;
    @Autowired
    private EmergencyDeviceService emergencyDeviceService;
    @Autowired
    private BProgramChannelService bProgramChannelService;
    @Autowired
    private BBroadcastDataService bBroadcastDataService;
    @SuppressWarnings("unused")
	@Autowired
    private static BDeviceInfoService bDeviceInfoService;

    @Autowired
    private TAdministrativeDivisionService tAdministrativeDivisionService;


    @GetMapping
    public String ui(Model model) {
        // 节目通道
        List<TDictionary> channelList = tDictionaryService.selectListByCriteria("program_channel");
        // 消息类型
        List<TDictionary> messageList = tDictionaryService.selectListByCriteria("message_type");
        // 消息等级
        List<TDictionary> messageGradeList = tDictionaryService.selectListByCriteria("message_grade");
        // 设备通道
        List<BDeviceInfo> deviceInfos = emergencyDeviceService
                .selectDeviceForTelList((byte) DeviceTypeEnum.frontDevice.getCode());
        // 播发去向
        List<TDictionary> broadcastDestinateList = tDictionaryService.selectListByCriteria("broadcast_destinate");
        // 节目选择
        List<BProgramChannel> programList = bProgramChannelService.getAll();
        model.addAttribute("channelList", channelList);
        model.addAttribute("messageList", messageList);
        model.addAttribute("messageGradeList", messageGradeList);
        model.addAttribute("deviceInfos", deviceInfos);
        model.addAttribute("programList", programList);
        model.addAttribute("broadcastDestinateList", broadcastDestinateList);
        return "broadcast/deviceBroadcast";
    }

    @RequestMapping("/List")
    @ResponseBody
    public BroadcastResult selectBroadcast(@RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                           @RequestParam(defaultValue = "f_id", required = false) String sortName,
                                           @RequestParam(defaultValue = "", required = false) String searchText,
                                           @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
                                           @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                           HttpSession session) {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        Map<String, Object> paramMap = new HashMap<>(4);
        paramMap.put("pageNumber", pageNumber);
        paramMap.put("pageSize", pageSize);
        if (searchText.equals("待审核")) {
            paramMap.put("searchEq", BroadcastStateEnum.waitReview.getCode());
        } else if (searchText.equals("待播发")||searchText.equals("已审核")) {
            paramMap.put("searchEq", BroadcastStateEnum.waitBroadcast.getCode());
        } else if (searchText.equals("未开播")) {
            paramMap.put("searchEq", String.valueOf(BroadcastStateEnum.no.getCode()));
        } else if (searchText.equals("正在播")) {
            paramMap.put("searchEq", BroadcastStateEnum.broadcasting.getCode());
        } else if (searchText.equals("已播发")) {
            paramMap.put("searchEq", BroadcastStateEnum.broadcasted.getCode());
        } else if (searchText.equals("未通过")) {
            paramMap.put("searchEq", BroadcastStateEnum.reviewFail.getCode());
        } else if (searchText.equals("不通过")) {
			paramMap.put("searchEq", BroadcastStateEnum.reviewFail.getCode());
        } else if (searchText.equals("已过期")) {
            paramMap.put("searchEq", BroadcastStateEnum.userDefined.getCode());
        } else {
            paramMap.put("searchText", searchText);
        }

        paramMap.put("sortOrder", sortOrder);
        if (sortName.equals("fRealMessageLevel")) {
            paramMap.put("sortName", "f_message_level");
        } else if (sortName.equals("fState")) {
            paramMap.put("sortName", "f_state");
        } else if (sortName.equals("fEffectiveTime")) {
            paramMap.put("sortName", "f_effective_time");
        } else if (sortName.equals("fRealMessageSource")) {
            paramMap.put("sortName", "f_message_source");
        } else {
            paramMap.put("sortName", "f_id");
        }

        int parentNode=tAdministrativeDivisionService.selectByPrimaryKey(tUser.getfRespectiveRegion()).getfParentNode();
        paramMap.put("reviewRegion",tUser.getfRespectiveRegion());
        paramMap.put("parentNode",parentNode);
        return BroadcastResult.ok(bBroadcastDataService.queryDeviceBroadcast(paramMap));
    }

}

