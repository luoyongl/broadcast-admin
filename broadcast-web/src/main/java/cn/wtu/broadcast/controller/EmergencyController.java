package cn.wtu.broadcast.controller;

import cn.wtu.broadcast.openapi.api.*;
import cn.wtu.broadcast.openapi.model.*;
import cn.wtu.broadcast.openapi.vo.BroadCastDataVO;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.*;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.util.LocalAudioUtil;
import cn.wtu.broadcast.util.TtsUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageInfo;

import ws.schild.jave.EncoderException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 应急广播
 *
 * @author lxg
 * @since 2018-12-17
 */
@Controller
@RequestMapping("broadcast/emergency")
public class EmergencyController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(EmergencyController.class);

	@Autowired
	private TDictionaryService tDictionaryService;
	@Autowired
	private BBroadcastDataService broadcastService;
	@Autowired
	private ShenheHandleService shenheHandleService;
	@Autowired
	private EmergencyDeviceService emergencyDeviceService;
	@Autowired
	private BProgramChannelService bProgramChannelService;
	@Autowired
	private AudioPlayService audioPlayService;
	@Autowired
	private TAdministrativeDivisionService tAdministrativeDivisionService;
	@Autowired
	private AudioManageService audioManageService;
	@Autowired
	private DispatchHttpclientService dispatchHttpclientService;
	@Value("${dispatch.server.tomcat.port}")
	private String dispatchServerTomcatPort;

	@Value("${upload.prefix.url}")
	private String uploadPrefixUrl;

	/**
	 * 应急广播页面
	 */
	@GetMapping
	public String ui(Model model, HttpServletRequest request) {
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
		return "broadcast/emergency";
	}

    /**
     * 开播 startPlay
     */
    @RequestMapping("/startPlay/{resourceId}")
    @ResponseBody
    public BroadcastResult addBroadCast(BBroadcastData broadcastData, HttpSession session,
                                        @PathVariable("resourceId") String resourceId,
                                        @RequestParam(value = "EffectiveTime", defaultValue = "") String EffectiveTime,
                                        @RequestParam(value = "tts", defaultValue = "") String tts, HttpServletRequest request,
                                        @RequestParam(value = "localAudio", required = false) CommonsMultipartFile localAudio,
                                        @RequestParam(value = "fDeviceResourcecode",required = false) String fDeviceResourcecode)
            throws ParseException, EncoderException {
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        broadcastData.setfBroadcastArea(resourceId);
        broadcastData.setfEffectiveTime(sdf_date.parse(EffectiveTime));
        broadcastData.setfCreateTime(new Date());
        broadcastData.setfVolumeControl((byte)100);
        //设备广播处理 -插入设备资源编码
      /*  if(fDeviceResourcecode != null && StringUtils.isNotBlank(fDeviceResourcecode)){
        	broadcastData.setfDeviceResourcecode(fDeviceResourcecode);
        	//设备广播 播发去向设为大喇叭
        	broadcastData.setfBroadcastTo("23");
        }*/
        
        broadcastData.setfMessageSource(tUser.getfRespectiveRegion());
        String fileUrl = request.getSession().getServletContext().getRealPath("/")
                + UploadUrlEnum.getEnumByCode("3").getDesc();
        // 文本转语音操作 返回的url 用于set到modal当中 File.separator
        if (tts != "" && StringUtils.isNotBlank(tts)) {
            String textUrl = uploadPrefixUrl + UploadUrlEnum.getEnumByCode("3").getDesc() + "/"
                    + TtsUtil.toTTS(tts, fileUrl);
            broadcastData.setfTextContent(tts);
            broadcastData.setfTextUrl(textUrl);
        }

		// 本地音源操作
		BAudioData bAudioData = LocalAudioUtil.localaudio(localAudio, request, uploadPrefixUrl, audioManageService);
		if (bAudioData.getfAudioUrl() != null && bAudioData.getfAudioUrl() != "") {
			broadcastData.setfTextUrl(bAudioData.getfAudioUrl());
		}

		// 设置区域Id之前,需要简化
		// 判断是否为null 设备广播为null
		if (resourceId != null && resourceId != "") {
			String regionIds = tAdministrativeDivisionService.simplifyRegionIds(resourceId);
			broadcastData.setfBroadcastArea(regionIds);
		}

		broadcastData.setfBroadcastType((byte) BroadcastTypeEnum.emergency.getCode());
		// 应急广播-默认就通过--待播发
		broadcastData.setfState((byte) BroadcastStateEnum.waitBroadcast.getCode());
		byte state = (byte) BroadcastStateEnum.waitBroadcast.getCode();
		boolean flag = broadcastService.addBroadCastThinkUserRole(broadcastData, state);

		if (flag) {
			BReview bReview = new BReview();
			// 应急广播 不需要审核-自动
			bReview.setfBigClassification((byte) BigClassificationEnum.automatic.getCode());
			bReview.setfReviewType((byte) BroadcastTypeEnum.emergency.getCode());
			bReview.setfReviewObjectId(broadcastData.getfId());
			// 应急广播 不需要审核-审核结果 默认为 审核成功
			bReview.setfReviewResult((byte) ReviewResultEnum.reviewSuccess.getCode());

			byte state1 = (byte) ReviewResultEnum.reviewSuccess.getCode();
			boolean review_flag = shenheHandleService.addReviewThinkUserRole(bReview, state1);
			if (review_flag) {
				if (fDeviceResourcecode != null) {
					// 根据广播选中的设备 插入到广播设备表llj
					audioPlayService.addDeviceResourceIds(fDeviceResourcecode, broadcastData.getfId(),
							BroadcastTypeEnum.emergency.getCode());
				} else {
					// 根据广播选中的区域查询对应的设备
					audioPlayService.addDeviceByResourceIds(resourceId, broadcastData.getfId(),
							BroadcastTypeEnum.emergency.getCode());
				}
				String adapterResourceCode = broadcastService.queryAdapterCode(broadcastData.getfControlDevice());
				BroadcastResult result = dispatchHttpclientService.sendBroadcast(dispatchServerTomcatPort,
						 BroadcastTypeEnum.emergency.getCode(), broadcastData.getfId(),adapterResourceCode);
				return result;
			} else {
				return BroadcastResult.fail();
			}

		} else {
			return BroadcastResult.fail();
		}
	}

	/**
	 * 停播 stopPlay
	 */
	@RequestMapping("/stopPlay")
	@ResponseBody
	public BroadcastResult stopPlay( Integer fId) {
		try {
			BroadcastResult result = dispatchHttpclientService.stopBroadcast(dispatchServerTomcatPort,
					fId);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return BroadcastResult.fail();
		}
	}

	/**
	 * @param fId
	 * @param resourceId
	 * @param broadcastData
	 * @return
	 * @description 更新应急广播信息
	 * @date 2019-01-16
	 * @Author lxg
	 */
	@RequestMapping("/update/{resourceId}")
	@ResponseBody
	public BroadcastResult updateBroadCast(@RequestParam(value = "fId") String fId,
			@PathVariable(value = "resourceId") String resourceId, @ModelAttribute BBroadcastData broadcastData,
			HttpSession httpSession, HttpServletRequest request,
			@RequestParam(value = "localAudio", required = false) CommonsMultipartFile localAudio) {
		broadcastData.setfBroadcastArea(resourceId);
		// 本地音源操作
		BAudioData bAudioData = LocalAudioUtil.localaudio(localAudio, request, uploadPrefixUrl, audioManageService);
		broadcastData.setfTextUrl(bAudioData.getfAudioUrl());
		broadcastData.setfState((byte) BroadcastStateEnum.waitBroadcast.getCode());
		TUser tUser = (TUser) httpSession.getAttribute(Constant.CURRENT_USER);
		broadcastData.setfOperatorId(tUser.getfId());
		broadcastData.setfUpdtateTime(new Date());

		if (broadcastService.updateByPrimaryKeySelective(broadcastData) > 0) {
			// 数据插入审核表中
			BReview bReview = new BReview();
			bReview.setfBigClassification((byte) BigClassificationEnum.automatic.getCode());
			bReview.setfReviewResult((byte) ReviewResultEnum.waitBroading.getCode());
			byte state1 = (byte) ReviewResultEnum.reviewSuccess.getCode();
			boolean review_flag = shenheHandleService.addReviewThinkUserRole(bReview, state1);
			if (review_flag) {
				return BroadcastResult.build(200, "操作成功,待播发", null);
			} else {
				return BroadcastResult.fail();
			}
		} else {
			return BroadcastResult.fail();
		}
	}

	/**
	 * 展示应急广播数据 list
	 *
	 * @param pageNumber
	 * @param pageSize
	 * @param searchText
	 * @param sortOrder
	 * @param sortName
	 * @return BroadcastResult
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BroadcastResult getListByBroadcastType(
			@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(defaultValue = "", required = false) String searchText,
			@RequestParam(defaultValue = "desc", required = false) String sortOrder,
			@RequestParam(defaultValue = "fId", required = false) String sortName, HttpSession session) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
		paramMap.put("pageNumber", pageNumber);
		paramMap.put("pageSize", pageSize);
		if (searchText.equals("待审核")) {
			paramMap.put("searchEq", BroadcastStateEnum.waitReview.getCode());
		} else if (searchText.equals("待播发") || searchText.equals("已审核")) {
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
		} else if (sortName.equals("fVolumeControl")) {
			paramMap.put("sortName", "f_volume_control");
		} else if (sortName.equals("fEffectiveTime")) {
			paramMap.put("sortName", "f_effective_time");
		} else if (sortName.equals("fRealMessageLevel")) {
			paramMap.put("sortName", "f_message_level");
		}

		paramMap.put("fBroadcastType", BroadcastTypeEnum.emergency.getCode());

		// 根据用户所在区域查询
		int parentNode = tAdministrativeDivisionService.selectByPrimaryKey(tUser.getfRespectiveRegion())
				.getfParentNode();
		paramMap.put("reviewRegion", tUser.getfRespectiveRegion());
		paramMap.put("parentNode", parentNode);

		PageInfo<BroadCastDataVO> listrs = broadcastService.queryPageByBroadcastType(paramMap);
		return BroadcastResult.ok(listrs);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public BroadcastResult deleteDrill(@RequestParam(value = "fId") String fId) {
		return BroadcastResult.build(200, "取消了" + broadcastService.deleteBroadast(fId) + "条记录");
	}
}
