package cn.wtu.broadcast.controller;

import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.api.ScheduleService;
import cn.wtu.broadcast.openapi.api.ShenheHandleService;
import cn.wtu.broadcast.openapi.api.TAdministrativeDivisionService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.*;
import cn.wtu.broadcast.openapi.vo.BroadcastTimingVO;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.*;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.support.quartz.ScheduleBroadcastJobService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时广播
 *
 * @author yinjie
 * @since 2018-12-17
 */

@Controller
@RequestMapping("broadcast/schedule")
public class ScheduleController extends BaseController {

	@Autowired
	private TDictionaryService tDictionaryService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	EmergencyDeviceService emergencyDeviceService;
	@Autowired
	private ShenheHandleService shenheHandleService;
	@Autowired
	private ScheduleBroadcastJobService scheduleBroadcastJobService;
	@Autowired
	private TAdministrativeDivisionService tAdministrativeDivisionService;

	@GetMapping
	public String ui(Model model) {
		// 查找字典表中的数据并进行展示
		// List<TDictionary> audiofileList =
		// tDictionaryService.selectListByCriteria("audio_file");
		List<TDictionary> drillCategoriesList = tDictionaryService.selectListByCriteria("drill_categories");
		List<TDictionary> messageGradeList = tDictionaryService.selectListByCriteria("message_grade");
		List<TDictionary> messageTypeList = tDictionaryService.selectListByCriteria("message_type");
		List<BAudioData> bAudioDataList = scheduleService.selectBAudioDataList();
		List<BDeviceInfo> deviceList = emergencyDeviceService
				.selectDeviceForTelList((byte) DeviceTypeEnum.frontDevice.getCode());
		List<TDictionary> channelSelectList = tDictionaryService.selectListByCriteria("channel_select");
		List<TDictionary> broadcastDestinate = tDictionaryService.selectListByCriteria("broadcast_destinate");
		List<TDictionary> FMsettingList = tDictionaryService.selectListByCriteria("FM_setting");

		// model.addAttribute("audiofileList", audiofileList);
		model.addAttribute("drillCategoriesList", drillCategoriesList);
		model.addAttribute("messageGradeList", messageGradeList);
		model.addAttribute("messageTypeList", messageTypeList);
		model.addAttribute("bAudioDataList", bAudioDataList);
		model.addAttribute("deviceList", deviceList);
		model.addAttribute("channelSelectList", channelSelectList);
		model.addAttribute("broadcastDestinate", broadcastDestinate);
		model.addAttribute("FMsettingList", FMsettingList);

		return "broadcast/schedule";
	}

	@RequestMapping("/getAllList")
	@ResponseBody
	public BroadcastResult getAllList(@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
									  @RequestParam(defaultValue = "10", required = false) Integer pageSize,
									  @RequestParam(defaultValue = "", required = false) String pageSortName,
									  @RequestParam(defaultValue = "", required = false) String pageOrderName,
									  @RequestParam(defaultValue = "", required = false) String search,
									  HttpSession session) throws Exception {
		TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
		Map<String, Object> paramMap = new HashMap<>(4);
		paramMap.put("pageNumber", pageNumber);
		paramMap.put("pageSize", pageSize);
		paramMap.put("pageOrderName", pageOrderName);
		if (search.equals("待审核")) {
			paramMap.put("searchEq", BroadcastStateEnum.waitReview.getCode());
		} else if (search.equals("待播发")||search.equals("已审核")) {
			paramMap.put("searchEq", BroadcastStateEnum.waitBroadcast.getCode());
		} else if (search.equals("正在播")) {
			paramMap.put("searchEq", BroadcastStateEnum.broadcasting.getCode());
		} else if (search.equals("已播发")) {
			paramMap.put("searchEq", BroadcastStateEnum.broadcasted.getCode());
		} else if (search.equals("未通过")) {
			paramMap.put("searchEq", BroadcastStateEnum.reviewFail.getCode());
		} else if (search.equals("不通过")) {
			paramMap.put("searchEq", BroadcastStateEnum.reviewFail.getCode());
		}else if (search.equals("已过期")) {
			paramMap.put("searchEq", BroadcastStateEnum.userDefined.getCode());
		}else {
			paramMap.put("search", search);
		}
		if (pageSortName.equals("fId")) {
			paramMap.put("pageSortName", "f_id");
		} else if (pageSortName.equals("fVolume")) {
			paramMap.put("pageSortName", "f_volume");
		} else if (pageSortName.equals("fstartDateTime")) {
			paramMap.put("pageSortName", "f_start_date_time");
		} else if (pageSortName.equals("fendDateTime")) {
			paramMap.put("pageSortName", "f_end_date_time");
		} else if (pageSortName.equals("fDrillCategory")) {
			paramMap.put("pageSortName", "f_drill_category");
		} else if (pageSortName.equals("fReviewFlag")) {
			paramMap.put("pageSortName", "f_review_flag");
		} else if (pageSortName.equals("fRealMessageType")) {
			paramMap.put("pageSortName", "f_message_type");
		} else if (pageSortName.equals("fRealMessageLevel")) {
			paramMap.put("pageSortName", "f_message_level");
		} else if (pageSortName.equals("fRealMessageSource")) {
			paramMap.put("pageSortName", "f_message_source");
		}
		//根据用户所在区域查询
		paramMap.put("reviewRegion",tUser.getfRespectiveRegion());
		PageInfo<BroadcastTimingVO> queryPage = scheduleService.queryPage(paramMap);

		return BroadcastResult.ok(queryPage);
	}

	// 增加
	@PostMapping
	@ResponseBody
	public BroadcastResult add(BBroadcastTiming bBroadcastTiming, String fStartAndEndDate, String fStartAndEndTime,
							   String SingleBroadcastTime, @RequestParam(value = "areaIds", defaultValue = "1") String areaIds,
							   @RequestParam(value = "fTimeIntervalHour", defaultValue = "0") String fTimeIntervalHour,
							   @RequestParam(value = "fTimeIntervalMinute", defaultValue = "0") String fTimeIntervalMinute,
							   @RequestParam(value = "fTimeIntervalSecond", defaultValue = "0") String fTimeIntervalSecond,
							   HttpServletRequest request) {

		bBroadcastTiming.setfTimeInterval(Integer.parseInt(fTimeIntervalHour) * 60 * 60
				+ Integer.parseInt(fTimeIntervalMinute) * 60 + Integer.parseInt(fTimeIntervalSecond));

		try {
			if (fStartAndEndDate != null && fStartAndEndDate != "") {
				String date[] = fStartAndEndDate.split("至");
				// SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd
				// HH:mm:ss");
				SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
				bBroadcastTiming.setfStartDate(sdf_date.parse(date[0]));
				bBroadcastTiming.setfEndDate(sdf_date.parse(date[1]));
			}

			if (fStartAndEndTime != null && fStartAndEndTime != "") {
				String time[] = fStartAndEndTime.split("至");
				SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm:ss");
				bBroadcastTiming.setfStartTime(sdf_time.parse(time[0]));
				bBroadcastTiming.setfEndTime(sdf_time.parse(time[1]));
			}

			SimpleDateFormat sdf_singletime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateSingle[] = SingleBroadcastTime.split(" ");
			SimpleDateFormat sdfSingletimeDate = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfSingletimeTime = new SimpleDateFormat("HH:mm:ss");
			if (SingleBroadcastTime != null && SingleBroadcastTime != "") {
				bBroadcastTiming.setfSingleBroadcastTime(sdf_singletime.parse(SingleBroadcastTime));
				bBroadcastTiming.setfStartDate(sdfSingletimeDate.parse(dateSingle[0]));
				bBroadcastTiming.setfEndDate(sdfSingletimeDate.parse(dateSingle[0]));
				bBroadcastTiming.setfStartTime(sdfSingletimeTime.parse(dateSingle[1]));
				bBroadcastTiming.setfEndTime(sdfSingletimeTime.parse(dateSingle[1]));
			}

			//设置区域Id之前,需要简化
			String regionIds = tAdministrativeDivisionService.simplifyRegionIds(areaIds);		
			bBroadcastTiming.setfBroadcastArea(regionIds);

			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
			Boolean isAuto = tUser.getfIsAuditAutomatic();

			if (!isAuto) {
				bBroadcastTiming.setfReviewFlag((byte) BroadcastStateEnum.waitReview.getCode());
			} else {
				bBroadcastTiming.setfReviewFlag((byte) BroadcastStateEnum.waitBroadcast.getCode());
			}
			String fileName = bBroadcastTiming.getfAudioFile();
			String substring = fileName.substring(0, 1);
			String substring2 = fileName.substring(1, fileName.length());
			if (substring.equals("f")) {
				bBroadcastTiming.setfFrequentAudio(Integer.parseInt(substring2));
			}
			boolean result = scheduleService.insertToBroadcastTiming(bBroadcastTiming);
			/* return "新增成功"; */

			/*
			 * if(result){ return BroadcastResult.ok(); }else { return
			 * BroadcastResult.fail(); }
			 */
			// String broadcastType = RequestUtils.getRequestKeyValue(request,
			// "broadcastType");
			if (result) {
				if (!isAuto) {
					BReview bReview = new BReview();
					bReview.setfBigClassification((byte) BigClassificationEnum.manual.getCode());
					// 枚举
					bReview.setfReviewType((byte) BroadcastTypeEnum.timing.getCode());
					bReview.setfReviewObjectId(bBroadcastTiming.getfId());
					bReview.setfReviewResult((byte) ReviewResultEnum.waitReview.getCode());
					// bReview.setfRemark("测试手动");
					boolean review_flag = shenheHandleService.addReview(bReview);
					if (review_flag) {
						return BroadcastResult.build(200, "操作成功,待审核!", null);
					} else {
						return BroadcastResult.fail("新增失败");
					}
				} else {
					BReview bReview = new BReview();
					bReview.setfBigClassification((byte) BigClassificationEnum.automatic.getCode());
					// 枚举
					bReview.setfReviewType((byte) BroadcastTypeEnum.timing.getCode());
					bReview.setfReviewObjectId(bBroadcastTiming.getfId());
					bReview.setfReviewResult((byte) ReviewResultEnum.reviewSuccess.getCode());
					// bReview.setfRemark("测试自动");

					boolean review_flag = shenheHandleService.addReview(bReview);
					if (review_flag) {
						scheduleBroadcastJobService.createJob(bBroadcastTiming.getfId());
						return BroadcastResult.build(200, "操作成功,已审核!", null);
					} else {
						return BroadcastResult.fail("新增失败");
					}
				}
			} else {
				return BroadcastResult.fail("新增失败");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			/* return "新增失败"; */
			return BroadcastResult.fail("新增失败");
		}
	}

	// 修改
	@RequestMapping(value = "/update")
	@ResponseBody
	public BroadcastResult updateProgram(BBroadcastTiming bBroadcastTiming, @RequestParam(value = "fId") Integer fId,
			String SingleBroadcastTime, String fStartAndEndDate, String fStartAndEndTime) {
		try {
			if (fStartAndEndDate != null && fStartAndEndDate != "") {
				String date[] = fStartAndEndDate.split("至");
				// SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd
				// HH:mm:ss");
				SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
				bBroadcastTiming.setfStartDate(sdf_date.parse(date[0]));
				bBroadcastTiming.setfEndDate(sdf_date.parse(date[1]));
			}

			if (fStartAndEndTime != null && fStartAndEndTime != "") {
				String time[] = fStartAndEndTime.split("至");
				SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm:ss");
				bBroadcastTiming.setfStartTime(sdf_time.parse(time[0]));
				bBroadcastTiming.setfEndTime(sdf_time.parse(time[1]));
			}
			Date upDate = new Date();
			bBroadcastTiming.setfUpdateTime(upDate);
			
			SimpleDateFormat sdf_singletime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateSingle[] = SingleBroadcastTime.split(" ");
			SimpleDateFormat sdfSingletimeDate = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfSingletimeTime = new SimpleDateFormat("HH:mm:ss");
			if (SingleBroadcastTime != null && SingleBroadcastTime != "") {
				bBroadcastTiming.setfSingleBroadcastTime(sdf_singletime.parse(SingleBroadcastTime));
				bBroadcastTiming.setfStartDate(sdfSingletimeDate.parse(dateSingle[0]));
				bBroadcastTiming.setfEndDate(sdfSingletimeDate.parse(dateSingle[0]));
				bBroadcastTiming.setfStartTime(sdfSingletimeTime.parse(dateSingle[1]));
				bBroadcastTiming.setfEndTime(sdfSingletimeTime.parse(dateSingle[1]));
			}

			boolean result = scheduleService.updateBBroadcastTiming(bBroadcastTiming, fId);
			if (result) {
				return BroadcastResult.ok();
			} else {
				return BroadcastResult.fail();
			}

		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
			/* return "新增失败"; */
			return BroadcastResult.fail("修改失败");
		}
	}

	// 删除
	@DeleteMapping
	@ResponseBody
	public BroadcastResult delete(@RequestParam(value = "ids") List<Integer> idList) {
		return BroadcastResult.build(200, "取消了" + scheduleService.deleteBBroadcastTimingByIds(idList) + "条记录");
	}

}
