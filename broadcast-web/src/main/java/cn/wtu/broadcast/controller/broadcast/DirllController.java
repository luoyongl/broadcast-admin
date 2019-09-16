package cn.wtu.broadcast.controller.broadcast;

import cn.wtu.broadcast.openapi.api.*;
import cn.wtu.broadcast.openapi.model.*;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.*;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.util.LocalAudioUtil;
import cn.wtu.broadcast.util.TtsUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("broadcast/drill")
public class DirllController {
    //private Logger logger = LoggerFactory.getLogger(DirllController.class);
    @Autowired
    private TDictionaryService tDictionaryService;
    @Autowired
    private BBroadcastDataService bBroadcastDataService;
    @Autowired
    private ShenheHandleService shenheHandleService;
    @Autowired
    private EmergencyDeviceService emergencyDeviceService;
    @Autowired
    private TAdministrativeDivisionService tAdministrativeDivisionService;
    @Autowired
    private DispatchHttpclientService dispatchHttpclientService;
    @Autowired
    private AudioManageService audioManageService;
    @Autowired
    private AudioPlayService audioPlayService;
    
    @Value("${dispatch.server.tomcat.port}")
    private String dispatchServerTomcatPort;

    @Value("${upload.prefix.url}")
    private String uploadPrefixUrl;

    @GetMapping
    public String ui(Model model) {
        List<TDictionary> channelList = tDictionaryService.selectListByCriteria("program_channel");
        List<TDictionary> messagetypeList = tDictionaryService.selectListByCriteria("message_type");
        List<TDictionary> messagegradeList = tDictionaryService.selectListByCriteria("message_grade");
        List<TDictionary> broadcastDestinate = tDictionaryService.selectListByCriteria("broadcast_destinate");
        List<BDeviceInfo> deviceInfos = emergencyDeviceService
                .selectDeviceForTelList((byte) DeviceTypeEnum.frontDevice.getCode());
        model.addAttribute("channelList", channelList);
        model.addAttribute("messagetypeList", messagetypeList);
        model.addAttribute("messagegradeList", messagegradeList);
        model.addAttribute("broadcastDestinate", broadcastDestinate);
        model.addAttribute("deviceInfos", deviceInfos);
        return "broadcast/drill";
    }

    @RequestMapping("/addBroadCast")
    @ResponseBody
    public BroadcastResult addBroadCast(
            @RequestParam(value = "fBroadcastType", defaultValue = "") String fBroadcastType,
            @RequestParam(value = "resourceId", required = false) String resourceId,
            @RequestParam(value = "EffectiveTime", defaultValue = "") String EffectiveTime,
            @RequestParam(value = "tts", defaultValue = "") String tts,
            @ModelAttribute BBroadcastData broadcastData,
            HttpServletRequest request, HttpSession session,
            @RequestParam(value = "localAudio", required = false) CommonsMultipartFile localAudio,
            @RequestParam(value = "fDeviceResourcecode",required = false) String fDeviceResourcecode) throws ParseException {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        broadcastData.setfMessageSource(tUser.getfRespectiveRegion().intValue());
        broadcastData.setfEffectiveTime(sdf_date.parse(EffectiveTime));
        broadcastData.setfCreateTime(new Date());
        broadcastData.setfBroadcastType(Byte.valueOf(fBroadcastType));
        //本地音源操作
        BAudioData bAudioData = LocalAudioUtil.localaudio(localAudio, request, uploadPrefixUrl, audioManageService);
        if (bAudioData.getfAudioUrl()!=null&&bAudioData.getfAudioUrl()!=""){
            broadcastData.setfTextUrl(bAudioData.getfAudioUrl());
        }

        //设置区域Id之前,需要简化
        if(resourceId!=null&&resourceId!=""){
            String regionIds = tAdministrativeDivisionService.simplifyRegionIds(resourceId);
            broadcastData.setfBroadcastArea(regionIds);
        }


        String fileUrl = request.getSession().getServletContext().getRealPath("/")
                + UploadUrlEnum.getEnumByCode("3").getDesc();
        // 返回的url 用于set到modal当中 File.separator
        if (tts != "" && StringUtils.isNotBlank(tts)) {
            String textUrl = uploadPrefixUrl + UploadUrlEnum.getEnumByCode("3").getDesc() + "/"
                    + TtsUtil.toTTS(tts, fileUrl);
            broadcastData.setfTextContent(tts);
            broadcastData.setfTextUrl(textUrl);
        }
        broadcastData.setfState((byte) BroadcastStateEnum.waitReview.getCode());
        byte state = (byte) BroadcastStateEnum.waitBroadcast.getCode();
        boolean flag = bBroadcastDataService.addBroadCastThinkUserRole(broadcastData, state);
        if (flag) {
            BReview bReview = new BReview();
            // 广播-手动
            bReview.setfBigClassification((byte) BigClassificationEnum.manual.getCode());
            bReview.setfReviewType((byte) BroadcastTypeEnum.daily.getCode());
            bReview.setfReviewObjectId(broadcastData.getfId());
            // 广播-审核表中-待审核
            bReview.setfReviewResult((byte) ReviewResultEnum.waitReview.getCode());

            TUser user = (TUser) session.getAttribute(Constant.CURRENT_USER);
            String msg = null;
            if (user.getfIsAuditAutomatic()) {
            	if(fDeviceResourcecode != null){
           		 //根据广播选中的设备 插入到广播设备表llj
           		audioPlayService.addDeviceResourceIds(fDeviceResourcecode, broadcastData.getfId(), BroadcastTypeEnum.emergency.getCode());
           	}else{
           		 //根据广播选中的区域查询对应的设备
           		audioPlayService.addDeviceByResourceIds(resourceId, broadcastData.getfId(), BroadcastTypeEnum.emergency.getCode());
           	}
            	String adapterResourceCode = bBroadcastDataService.queryAdapterCode(broadcastData.getfControlDevice());
                BroadcastResult result = dispatchHttpclientService.sendBroadcast(dispatchServerTomcatPort,
                         Integer.valueOf(broadcastData.getfBroadcastType()), broadcastData.getfId(),adapterResourceCode);
                msg = result.getMsg();
            } else {
                msg = "操作成功,待审核!";
            }
            byte state1 = (byte) ReviewResultEnum.reviewSuccess.getCode();
            boolean review_flag = shenheHandleService.addReviewThinkUserRole(bReview, state1);
            if (review_flag) {
                return BroadcastResult.build(200, msg, null);
            } else {
                return BroadcastResult.fail();
            }
        } else {
            return BroadcastResult.fail();
        }
    }

    @RequestMapping("/updateBroadCast")
    @ResponseBody
    public BroadcastResult updateBroadCast(@RequestParam(value = "fId") String fId,
                                           @RequestParam(value = "resourceId", defaultValue = "") String resourceId,
                                           @ModelAttribute BBroadcastData broadcastData,
                                           HttpSession httpSession,
                                           HttpServletRequest request,
                                           @RequestParam(value = "localAudio", required = false) CommonsMultipartFile localAudio) {
        broadcastData.setfBroadcastArea(resourceId);
        broadcastData.setfState((byte) BroadcastStateEnum.waitReview.getCode());
        TUser tUser = (TUser) httpSession.getAttribute(Constant.CURRENT_USER);
        broadcastData.setfOperatorId(tUser.getfId());
        broadcastData.setfUpdtateTime(new Date());
        //本地音源操作
        BAudioData bAudioData = LocalAudioUtil.localaudio(localAudio, request, uploadPrefixUrl, audioManageService);
        broadcastData.setfTextUrl(bAudioData.getfAudioUrl());
        if (bBroadcastDataService.updateByPrimaryKeySelective(broadcastData) > 0) {
            // TOOD此处需要将此条数据插入审核表中
            BReview bReview = new BReview();
            bReview.setfBigClassification((byte) BigClassificationEnum.automatic.getCode());
            bReview.setfReviewResult((byte) ReviewResultEnum.waitBroading.getCode());
            boolean review_flag = shenheHandleService.addReview(bReview);
            if (review_flag) {
                return BroadcastResult.build(200, "操作成功,待播发", null);
            } else {
                return BroadcastResult.build(400, "操作失败!", null);
            }
        } else {
            return BroadcastResult.fail();
        }
    }

    @RequestMapping("/selectPastList")
    @ResponseBody
    public BroadcastResult selectBroadcast(@RequestParam Integer fBroadcastType,
                                           @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                           @RequestParam(defaultValue = "f_id", required = false) String sortName,
                                           @RequestParam(defaultValue = "", required = false) String searchText,
                                           @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
                                           @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                           HttpSession session) {
        Map<String, Object> paramMap = new HashMap<>(4);

        paramMap.put("pageNumber", pageNumber);
        paramMap.put("pageSize", pageSize);
        paramMap.put("fBroadcastType", fBroadcastType);
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
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
        //根据用户所在区域查询
        int parentNode=tAdministrativeDivisionService.selectByPrimaryKey(tUser.getfRespectiveRegion()).getfParentNode();
        paramMap.put("reviewRegion",tUser.getfRespectiveRegion());
        paramMap.put("parentNode",parentNode);
        return BroadcastResult.ok(bBroadcastDataService.queryPageByBroadcastType(paramMap));
    }

    /**
     * 根据fid查询单个数据
     *
     * @param fId
     * @return
     */
    @RequestMapping("selectPastList/{fId}")
    @ResponseBody
    public BroadcastResult slectBroadcastById(@PathVariable Integer fId) {
        return BroadcastResult.ok(bBroadcastDataService.selectBroadCastById(fId));
    }

    @RequestMapping("/deleteBroadcast")
    @ResponseBody
    public BroadcastResult deleteDrill(@RequestParam(value = "fId") String fId) {
        return BroadcastResult.build(200, "取消了" + bBroadcastDataService.deleteBroadast(fId) + "条记录");
    }

    @RequestMapping("/selectDeviceChannel")
    @ResponseBody
    public BroadcastResult selectDeviceChannel(@RequestParam Integer deviceId) {
        return BroadcastResult.ok(emergencyDeviceService.selectByPrimaryKey(deviceId));
    }

}
