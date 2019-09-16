package cn.wtu.broadcast.controller.broadcast;

import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.*;
import cn.wtu.broadcast.openapi.model.*;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.*;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.util.LocalAudioUtil;
import cn.wtu.broadcast.util.RequestUtils;
import cn.wtu.broadcast.util.TtsUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("broadcast/advance")
public class AdvanceController extends BaseController {

    //private Logger logger = LoggerFactory.getLogger(AdvanceController.class);

    private final TDictionaryService tDictionaryService;

    @Autowired
	private BBroadcastDataService broadcastService;
    @Autowired
    private ShenheHandleService shenheHandleService;
    @Autowired
    private BProgramChannelService bProgramChannelService;
    @Autowired
    private AdvanceService advanceService;
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

    @Autowired
    public AdvanceController(TDictionaryService tDictionaryService) {
        this.tDictionaryService = tDictionaryService;
    }

    @Value("${upload.prefix.url}")
    private String uploadPrefixUrl;

    /**
     * @param model
     * @return
     */
    @GetMapping
    public String ui(Model model) {
        List<TDictionary> messageList = tDictionaryService.selectListByCriteria("message_type");
        List<TDictionary> channelList = tDictionaryService.selectListByCriteria("program_channel");
        List<TDictionary> messageGradeList = tDictionaryService.selectListByCriteria("message_grade");
        List<TDictionary> broadcastDestinate = tDictionaryService.selectListByCriteria("broadcast_destinate");
        List<TDictionary> channelSelectList = tDictionaryService.selectListByCriteria("channel_select");
        List<BDeviceInfo> frontDeviceInfoList = emergencyDeviceService
                .selectDeviceForTelList((byte) DeviceTypeEnum.frontDevice.getCode());
        List<BProgramChannel> programList = bProgramChannelService.getAll();
        model.addAttribute("programList", programList);
        model.addAttribute("channelList", channelList);
        model.addAttribute("messageList", messageList);
        model.addAttribute("messageGradeList", messageGradeList);
        model.addAttribute("channelSelectList", channelSelectList);
        model.addAttribute("broadcastDestinate", broadcastDestinate);
        model.addAttribute("frontDeviceInfoList", frontDeviceInfoList);
        return "broadcast/advance";
    }

    /**
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertOrUpdateAdvance")
    public BroadcastResult createAdvance(HttpSession session,
                                         BBroadcastData bBroadcastData, HttpServletRequest request,
                                         @RequestParam(value = "resourceId", defaultValue = "1") String resourceId,
                                         @RequestParam(value = "EffectiveTime", required = false) String EffectiveTime,
                                         @RequestParam(value = "state", defaultValue = "0", required = false) byte state,
                                         @RequestParam(value = "tts", defaultValue = "") String tts,
                                         @RequestParam(value = "localAudio", required = false) CommonsMultipartFile localAudio) throws ParseException {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        BroadcastResult broadcastResult = new BroadcastResult();
        SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (EffectiveTime != null && EffectiveTime != "") {
            bBroadcastData.setfEffectiveTime(sdf_date.parse(EffectiveTime));
        }
        bBroadcastData.setfCreateTime(new Date());

        bBroadcastData.setfMessageSource(tUser.getfRespectiveRegion());

        //本地音源操作
        BAudioData bAudioData = LocalAudioUtil.localaudio(localAudio, request, uploadPrefixUrl, audioManageService);
        if (bAudioData.getfAudioUrl()!=null&&bAudioData.getfAudioUrl()!=""){
            bBroadcastData.setfTextUrl(bAudioData.getfAudioUrl());
        }


        //设置区域Id之前,需要简化
        String regionIds = tAdministrativeDivisionService.simplifyRegionIds(resourceId);
        bBroadcastData.setfBroadcastArea(regionIds);

        if (bBroadcastData.getfVolumeControl() == null) {
            bBroadcastData.setfVolumeControl((byte) 100);
        }
        String fileUrl = request.getSession().getServletContext().getRealPath("/")
                + UploadUrlEnum.getEnumByCode("3").getDesc();

        // 返回的url 用于set到modal当中 File.separator
        if (tts != "" && StringUtils.isNotBlank(tts)) {
            String textUrl = uploadPrefixUrl + UploadUrlEnum.getEnumByCode("3").getDesc() + "/"
                    + TtsUtil.toTTS(tts, fileUrl);
            bBroadcastData.setfTextContent(tts);
            bBroadcastData.setfTextUrl(textUrl);
        }
        bBroadcastData.setfState(state);
        if (advanceService.insertOrUpdateAdvance(bBroadcastData)) {
            broadcastResult = BroadcastResult.ok();
        } else {
            broadcastResult = BroadcastResult.fail();
        }
        return broadcastResult;
    }

    /**
     * 后台分页查询页面
     *
     * @param Number
     * @param Size
     * @param sortOrder
     * @param searchText
     * @param sortName
     * @return BroadcastResult
     */
    @ResponseBody
    @RequestMapping("/getAdavanceList")
    public BroadcastResult getAdavanceList(@RequestParam(defaultValue = "1", required = false) Integer Number,
                                           @RequestParam(defaultValue = "10", required = false) Integer Size,
                                           @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                           @RequestParam(defaultValue = "", required = false) String searchText,
                                           @RequestParam(defaultValue = "fId", required = false) String sortName,
                                           HttpSession session) {
        Map<String, Object> paramMap = new HashMap<>(4);
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        paramMap.put("pageNumber", Number);
        paramMap.put("pageSize", Size);
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
        } else if (searchText.equals("已取消")) {
            paramMap.put("searchEq", BroadcastStateEnum.cancelled.getCode());
        } else {
            paramMap.put("searchText", searchText);
        }
        paramMap.put("sortOrder", sortOrder);
        paramMap.put("sortName", "f_id");
        if (sortName.equals("fBroadcastName")) {
            paramMap.put("sortName", "f_broadcast_name");
        } else if (sortName.equals("fBroadcastType")) {
            paramMap.put("sortName", "f_broadcast_type");
        } else if (sortName.equals("fState")) {
            paramMap.put("sortName", "f_state");
        } else if (sortName.equals("fRealMessageType")) {
            paramMap.put("sortName", "f_message_type");
        } else if (sortName.equals("fRealMessageLevel")) {
            paramMap.put("sortName", "f_message_level");
        } else if (sortName.equals("fRealMessageSource")) {
            paramMap.put("sortName", "f_message_source");
        } else if (sortName.equals("fEffectiveTime")) {
            paramMap.put("sortName", "f_effective_time");
        }
        //根据用户所在区域查询
        int parentNode=tAdministrativeDivisionService.selectByPrimaryKey(tUser.getfRespectiveRegion()).getfParentNode();
        paramMap.put("reviewRegion",tUser.getfRespectiveRegion());
        paramMap.put("parentNode",parentNode);
        return BroadcastResult.ok(advanceService.queryPage(paramMap));
    }

    /**
     * 提交审核
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    @RequestMapping("/submitReview")
    public BroadcastResult submitReview(HttpServletRequest request, HttpSession session) {
        String id = RequestUtils.getRequestKeyValue(request, "id");
        String broadcastType = RequestUtils.getRequestKeyValue(request, "broadcastType");
        
        
        String fBroadcastArea = RequestUtils.getRequestKeyValue(request, "fBroadcastArea");
    	//根据简化了的区域ids查询出原来选中的所有区域id  2019-04-07 lxg
    	String resourceIds = tAdministrativeDivisionService.getAssociationByResourceIds(fBroadcastArea);
        
        BroadcastResult broadcastResult = new BroadcastResult();
        BBroadcastData bBroadcastData = new BBroadcastData();
        bBroadcastData.setfId(Integer.parseInt(id));

        // 点击开播 加入到审核列表中
        Byte realBroadcastType = (byte) (Integer.parseInt(broadcastType) - 6);
        bBroadcastData.setfBroadcastType(realBroadcastType);
        BReview bReview = new BReview();
        bReview.setfReviewObjectId(bBroadcastData.getfId());
        bReview.setfReviewType(realBroadcastType);
        TUser user = (TUser) session.getAttribute(Constant.CURRENT_USER);
        //判断用户是否有自动审核权限
        if (user.getfIsAuditAutomatic()) {
            bBroadcastData.setfState((byte) BroadcastStateEnum.waitBroadcast.getCode());
            int temp = advanceService.updateByPrimaryKeySelective(bBroadcastData);
            if (temp == 1) {
                bReview.setfBigClassification((byte) BigClassificationEnum.automatic.getCode());
                bReview.setfReviewResult((byte) ReviewResultEnum.reviewSuccess.getCode());
                bReview.setfRemark("自动审核权限测试");
                bReview.setfReviewTime(new Date());
                boolean review_flag = shenheHandleService.addReview(bReview);
                if (review_flag) {
                    //根据广播选中的区域查询对应的设备
                    audioPlayService.addDeviceByResourceIds(resourceIds, bBroadcastData.getfId(), (int)bBroadcastData.getfBroadcastType());
                    String adapterResourceCode = broadcastService.queryAdapterCode(bBroadcastData.getfControlDevice());
                    broadcastResult = BroadcastResult.build(200, temp + "条预案已自动审核并提交到待播发列表");
                    dispatchHttpclientService.sendBroadcast(dispatchServerTomcatPort,
                             (int) (realBroadcastType), bBroadcastData.getfId(),adapterResourceCode);
                } else {
                    broadcastResult = BroadcastResult.fail();
                }
            } else {
                broadcastResult = BroadcastResult.fail();
            }
        } else {
            //判断是否应急广播
            if (realBroadcastType == (byte) BroadcastTypeEnum.emergency.getCode()) {
                bBroadcastData.setfState((byte) BroadcastStateEnum.waitBroadcast.getCode());
                int temp = advanceService.updateByPrimaryKeySelective(bBroadcastData);
                if (temp == 1) {
                    bReview.setfBigClassification((byte) BigClassificationEnum.automatic.getCode());
                    bReview.setfReviewResult((byte) ReviewResultEnum.reviewSuccess.getCode());
                    bReview.setfRemark("应急预案测试");
                    bReview.setfReviewTime(new Date());
                    boolean review_flag = shenheHandleService.addReview(bReview);
                    if (review_flag) {
                        //根据广播选中的区域查询对应的设备
                        audioPlayService.addDeviceByResourceIds(resourceIds, bBroadcastData.getfId(), BroadcastTypeEnum.emergency.getCode());
                        String adapterResourceCode = broadcastService.queryAdapterCode(bBroadcastData.getfControlDevice());
                        dispatchHttpclientService.sendBroadcast(dispatchServerTomcatPort,
                                 (int) (realBroadcastType), bBroadcastData.getfId(),adapterResourceCode);
                        broadcastResult = BroadcastResult.build(200, temp + "条应急广播预案已提交到待播发列表");
                    } else {
                        broadcastResult = BroadcastResult.fail();
                    }
                } else {
                    broadcastResult = BroadcastResult.fail();
                }
            } else {
                String broadcastType1 = "";
                bBroadcastData.setfState((byte) BroadcastStateEnum.waitReview.getCode());
                int temp = advanceService.updateByPrimaryKeySelective(bBroadcastData);
                if (temp == 1) {
                    bReview.setfBigClassification((byte) BigClassificationEnum.manual.getCode());
                    bReview.setfReviewResult((byte) ReviewResultEnum.waitReview.getCode());
                    bReview.setfRemark("其他预案测试");
                    bReview.setfReviewTime(new Date());
                    boolean review_flag = shenheHandleService.addReview(bReview);
                    if (review_flag) {
                        if (Integer.valueOf(realBroadcastType) != 1
                                && Integer.valueOf(realBroadcastType) != 2
                                && Integer.valueOf(realBroadcastType) != 3) {
                            realBroadcastType = (byte) 5;
                        }
                        broadcastType1 = BroadcastTypeEnum.getEnumByCode(realBroadcastType.toString()).getDesc();
                        broadcastResult = BroadcastResult.build(200, temp + "条" + broadcastType1 + "预案已提交到待审核列表");
                    } else {
                        broadcastResult = BroadcastResult.fail();
                    }
                }
            }
        }
        return broadcastResult;

    }

    /**
     * 判断预案名是否重名
     *
     * @param fBroadcastName
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectAllAdvanceName")
    public BroadcastResult selectAllAdvanceName(HttpServletRequest request) {
        String advanceName = RequestUtils.getRequestKeyValue(request, "fBroadcastName");
        List<String> names = advanceService.selectAllAdvanceName();
        boolean isExisted = false;
        for (int i = 0; i < names.size(); i++) {
            if (advanceName.equals(names.get(i))) {
                isExisted = true;
            }
        }
        if (isExisted == false) {
            return BroadcastResult.build(200, "");
        } else {
            return BroadcastResult.build(400, "重名");
        }
    }

    /**
     * @param ids 所有要删除的广播id的集合 如"20，21"
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteAdvance")
    public BroadcastResult deleteAdvance(HttpServletRequest request) {
        String idsObj = RequestUtils.getRequestKeyValue(request, "ids");
        String[] idsArr = idsObj.split(",");
        int cancelledState = BroadcastStateEnum.cancelled.getCode();
        return BroadcastResult.build(200, "取消了" + advanceService.deleteByPrimaryKey(idsArr, cancelledState) + "条记录");
    }
}
