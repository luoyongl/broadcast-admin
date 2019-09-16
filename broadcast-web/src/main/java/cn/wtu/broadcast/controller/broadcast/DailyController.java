package cn.wtu.broadcast.controller.broadcast;

import cn.wtu.broadcast.controller.BaseController;
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

/**
 * @author LiLinFeng
 * @date 2018-12-17
 * @Description
 */
@Controller
@RequestMapping("broadcast/daily")
public class DailyController extends BaseController {
    //private Logger logger = LoggerFactory.getLogger(DailyController.class);

    @Autowired
    private TDictionaryService tDictionaryService;
    @Autowired
    EmergencyDeviceService emergencyDeviceService;
    @Autowired
    private BBroadcastDataService broadcastService;
    @Autowired
    private ShenheHandleService shenheHandleService;
    @Autowired
    private BProgramChannelService bProgramChannelService;
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
    public String ui(HttpServletRequest request) {
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

        request.getSession().setAttribute("channelList", channelList);
        request.getSession().setAttribute("messageList", messageList);
        request.getSession().setAttribute("messageGradeList", messageGradeList);
        request.getSession().setAttribute("deviceInfos", deviceInfos);
        request.getSession().setAttribute("programList", programList);
        request.getSession().setAttribute("broadcastDestinateList", broadcastDestinateList);

        return "broadcast/daily";
    }

    /**
     * 开播日常广播
     *
     * @param broadcastData
     * @return
     */
    @RequestMapping("/addDailyBroadcast/{resourceId}")
    @ResponseBody
    public BroadcastResult addDailyBroadcastController(
            @PathVariable(value = "resourceId") String resourceId,
            @RequestParam(value = "EffectiveTime", defaultValue = "") String EffectiveTime,
            @RequestParam(value = "tts", defaultValue = "") String tts, BBroadcastData broadcastData,
            HttpServletRequest request, HttpSession session,
            @RequestParam(value = "localAudio", required = false) CommonsMultipartFile localAudio,
            @RequestParam(value = "fDeviceResourcecode",required = false) String fDeviceResourcecode)
            throws ParseException {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        broadcastData.setfEffectiveTime(sdf_date.parse(EffectiveTime));
        broadcastData.setfCreateTime(new Date());
        broadcastData.setfMessageSource(tUser.getfRespectiveRegion());
        broadcastData.setfBroadcastArea(resourceId);
  /*      //设备广播处理 -插入设备资源编码
        if(fDeviceResourcecode != null && StringUtils.isNotBlank(fDeviceResourcecode)){
        	broadcastData.setfDeviceResourcecode(fDeviceResourcecode);
        	broadcastData.setfBroadcastTo("23");
        }*/
        String fileUrl = request.getSession().getServletContext().getRealPath("/")
                + UploadUrlEnum.getEnumByCode("3").getDesc();
        // 返回的url 用于set到modal当中  File.separator
        if (tts != "" && StringUtils.isNotBlank(tts)) {
            String textUrl = uploadPrefixUrl + UploadUrlEnum.getEnumByCode("3").getDesc() + "/"
                    + TtsUtil.toTTS(tts, fileUrl);
            broadcastData.setfTextContent(tts);
            broadcastData.setfTextUrl(textUrl);
        }

        //本地音源操作
        BAudioData bAudioData = LocalAudioUtil.localaudio(localAudio, request, uploadPrefixUrl, audioManageService);
        if (bAudioData.getfAudioUrl()!=null&&bAudioData.getfAudioUrl()!=""){
            broadcastData.setfTextUrl(bAudioData.getfAudioUrl());
        }


        //设置区域Id之前,需要简化
        String regionIds = tAdministrativeDivisionService.simplifyRegionIds(resourceId);
        broadcastData.setfBroadcastArea(regionIds);
        broadcastData.setfBroadcastType((byte) BroadcastTypeEnum.daily.getCode());
        // 创建数据时,日常广播的广播状态-广播数据表中-待审核
        broadcastData.setfState((byte) BroadcastStateEnum.waitReview.getCode());
        byte state = (byte) BroadcastStateEnum.waitBroadcast.getCode();
        boolean flag = broadcastService.addBroadCastThinkUserRole(broadcastData, state);

        if (flag) {
            BReview bReview = new BReview();
            // 日常广播-手动
            bReview.setfBigClassification((byte) BigClassificationEnum.manual.getCode());
            bReview.setfReviewType((byte) BroadcastTypeEnum.daily.getCode());
            bReview.setfReviewObjectId(broadcastData.getfId());
            // 日常广播-审核表中-待审核
            bReview.setfReviewResult((byte) ReviewResultEnum.waitReview.getCode());

            TUser user = (TUser) session.getAttribute(Constant.CURRENT_USER);
            String msg = null;
            if (user.getfIsAuditAutomatic()) {
            	
            	if(broadcastData.getfDeviceResourcecode() != null){
           		 //根据广播选中的设备 插入到广播设备表llj
           		audioPlayService.addDeviceResourceIds(broadcastData.getfDeviceResourcecode(), broadcastData.getfId(), (int) broadcastData.getfBroadcastType());
           	}else{
           		 //根据广播选中的区域查询对应的设备
           		audioPlayService.addDeviceByResourceIds(resourceId, broadcastData.getfId(), (int) broadcastData.getfBroadcastType());
           	}
            	
            	 String adapterResourceCode = broadcastService.queryAdapterCode(broadcastData.getfControlDevice());
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

    /**
     * @param fId
     * @param resourceId
     * @param broadcastData
     * @return
     * @description 更新日常广播信息
     * @date 2019-01-15
     * @Author LiLinFeng
     */
    @RequestMapping("/updateDailyBroadCast/{resourceId}")
    @ResponseBody
    public BroadcastResult updateBroadCast(@RequestParam(value = "fId") String fId,
                                           @PathVariable(value = "resourceId") String resourceId,
                                           @ModelAttribute BBroadcastData broadcastData, HttpSession session,
                                           HttpServletRequest request,
                                           @RequestParam(value = "localAudio", required = false) CommonsMultipartFile localAudio) {
        broadcastData.setfBroadcastArea(resourceId);
        broadcastData.setfUpdtateTime(new Date());
        //本地音源操作
        BAudioData bAudioData = LocalAudioUtil.localaudio(localAudio, request, uploadPrefixUrl, audioManageService);
        broadcastData.setfTextUrl(bAudioData.getfAudioUrl());
        TUser user = (TUser) session.getAttribute(Constant.CURRENT_USER);
        broadcastData.setfOperatorId(user.getfId());
        String msg = null;
        if (user.getfIsAuditAutomatic()) {
            broadcastData.setfState((byte) BroadcastStateEnum.waitBroadcast.getCode());
            msg = "操作成功,待播发!";
        } else {
            broadcastData.setfState((byte) BroadcastStateEnum.waitReview.getCode());
            msg = "操作成功,待审核!";
        }

        if (broadcastService.updateByPrimaryKeySelective(broadcastData) > 0) {
            BReview bReview = new BReview();
            bReview.setfBigClassification((byte) BigClassificationEnum.automatic.getCode());
            bReview.setfReviewResult((byte) ReviewResultEnum.waitBroading.getCode());
            byte state1 = (byte) ReviewResultEnum.reviewSuccess.getCode();
            boolean review_flag = shenheHandleService.addReviewThinkUserRole(bReview, state1);
            if (review_flag) {
                return BroadcastResult.build(200, msg, null);
            } else {
                return BroadcastResult.build(400, "操作失败!", null);
            }
        } else {
            return BroadcastResult.fail();
        }
    }

    /**
     * @param pageNumber
     * @param pageSize
     * @param searchText
     * @param sortOrder
     * @param sortName
     * @return
     */
    @RequestMapping("/selectDailyBroadcast")
    @ResponseBody
    public BroadcastResult selectDailyBroadcastController(
            @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(defaultValue = "", required = false) String searchText,
            @RequestParam(defaultValue = "desc", required = false) String sortOrder,
            @RequestParam(defaultValue = "fId", required = false) String sortName,
            HttpSession session) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
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
        if (sortName.equals("fId")) {
            paramMap.put("sortName", "f_id");
        } else if (sortName.equals("fState")) {
            paramMap.put("sortName", "f_state");
        } else if (sortName.equals("fEffectiveTime")) {
            paramMap.put("sortName", "f_effective_time");
        } else if (sortName.equals("fRealMessageLevel")) {
            paramMap.put("sortName", "f_message_level");
        }

        paramMap.put("fBroadcastType", BroadcastTypeEnum.daily.getCode());

        //根据用户所在区域查询
        int parentNode=tAdministrativeDivisionService.selectByPrimaryKey(tUser.getfRespectiveRegion()).getfParentNode();
        paramMap.put("reviewRegion",tUser.getfRespectiveRegion());
        paramMap.put("parentNode",parentNode);
        return BroadcastResult.ok(broadcastService.queryPageByBroadcastType(paramMap));
    }

    @RequestMapping("/deleteBroadcast")
    @ResponseBody
    public BroadcastResult deleteDrill(@RequestParam(value = "fId") String fId) {
        return BroadcastResult.build(200, "取消了" + broadcastService.deleteBroadast(fId) + "条记录");
    }
}
