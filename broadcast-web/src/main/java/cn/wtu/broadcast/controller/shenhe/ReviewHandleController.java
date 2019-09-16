package cn.wtu.broadcast.controller.shenhe;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.AudioPlayService;
import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.api.DispatchHttpclientService;
import cn.wtu.broadcast.openapi.api.ScheduleService;
import cn.wtu.broadcast.openapi.api.ShenheHandleService;
import cn.wtu.broadcast.openapi.api.TAdministrativeDivisionService;
import cn.wtu.broadcast.openapi.model.BBroadcastData;
import cn.wtu.broadcast.openapi.model.BBroadcastTiming;
import cn.wtu.broadcast.openapi.model.BReview;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.BigClassificationEnum;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;
import cn.wtu.broadcast.parent.enums.BroadcastTypeEnum;
import cn.wtu.broadcast.parent.enums.ReviewEnum;
import cn.wtu.broadcast.parent.enums.ReviewResultEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.support.quartz.ScheduleBroadcastJobService;

@Controller
@RequestMapping("shenhe/shenheHandle")
public class ReviewHandleController extends BaseController {
	// private Logger logger =
	// LoggerFactory.getLogger(ReviewHandleController.class);

	@Autowired
	private ShenheHandleService shenheHandleService;
	@Autowired
	private BBroadcastDataService bBroadcastDataService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private ScheduleBroadcastJobService scheduleBroadcastJobService;
	@Autowired
	private DispatchHttpclientService dispatchHttpclientService;
	@Autowired
	private AudioPlayService audioPlayService;
	@Autowired
	private TAdministrativeDivisionService tAdministrativeDivisionService;

	@Value("${dispatch.server.tomcat.port}")
	private String dispatchServerTomcatPort;

	@GetMapping
	public String ui(Model model) {
		return "shenhe/shenheHandle";
	}

	/**
	 * @Desc 查询手动审核的信息列表
	 * @Date 2019-01-02
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("/selectManualShenhe")
	@ResponseBody
	public BroadcastResult selectAutoShenhe(@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(defaultValue = "", required = false) String searchText,
			@RequestParam(defaultValue = "desc", required = false) String sortOrder,
			@RequestParam(defaultValue = "fReviewTime", required = false) String sortName, HttpSession session)
			throws Exception {
		TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
		Map<String, Object> paramMap = new HashMap<>(4);
		paramMap.put("pageNumber", pageNumber);
		paramMap.put("pageSize", pageSize);
		if (searchText.equals("模拟演练")) {
			paramMap.put("searchByType", BroadcastTypeEnum.simulate.getCode());
		} else if (searchText.equals("实际演练")) {
			paramMap.put("searchByType", BroadcastTypeEnum.practical.getCode());
		} else if (searchText.equals("系统演练")) {
			paramMap.put("searchByType", BroadcastTypeEnum.system.getCode());
		} else if (searchText.equals("应急广播")) {
			paramMap.put("searchByType", BroadcastTypeEnum.emergency.getCode());
		} else if (searchText.equals("定时广播")) {
			paramMap.put("searchByType", BroadcastTypeEnum.timing.getCode());
		} else {
			paramMap.put("searchText", searchText);
		}
		paramMap.put("sortOrder", sortOrder);
		if (sortName.equals("fCreateTime")) {
			paramMap.put("sortName", "fCreateTime");
		} else if (sortName.equals("fReviewType")) {
			paramMap.put("sortName", "f_review_type");
		}
		paramMap.put("reviewResult", (byte) ReviewResultEnum.waitReview.getCode());
		paramMap.put("reviewBigClassification", (byte) BigClassificationEnum.manual.getCode());
		paramMap.put("reviewType", (byte) ReviewEnum.daily.getCode());
		paramMap.put("reviewState", (byte) ReviewResultEnum.waitReview.getCode());
		// 根据区域审核
		int parentNode = tAdministrativeDivisionService.selectByPrimaryKey(tUser.getfRespectiveRegion())
				.getfParentNode();
		paramMap.put("reviewRegion", tUser.getfRespectiveRegion());
		paramMap.put("parentNode", parentNode);
		return BroadcastResult.ok(shenheHandleService.selectManualShenheHandle(paramMap));
	}

	/**
	 * @Desc 查询相应广播的详细信息
	 * @Date 2019-01-02
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("/selectShenBroadcastData/{fReviewObjectId}/{fReviewResult}")
	@ResponseBody
	public BroadcastResult selectShenheBroadcastDetail(@PathVariable Integer fReviewObjectId,
			@PathVariable Integer fReviewResult) {
		BroadcastResult broadcastResult = new BroadcastResult(200, String.valueOf(fReviewResult),
				bBroadcastDataService.selectBroadCastById(fReviewObjectId));
		return broadcastResult;
	}

	/**
	 * @Desc Table表中点击通过按钮，将改变广播数据表和审核处理表中对应的状态 ,对于广播数据表而言
	 * @Date 2019-01-02
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("/updateBroadcastState/{fId}/{fReviewObjectId}/{text}")
	@ResponseBody
	public BroadcastResult updateBroadcastState(@PathVariable Integer fId, @PathVariable Integer fReviewObjectId,
			@PathVariable String text) {
		boolean flag_data = false;
		// BReview bReview = shenheHandleService.selectByPrimaryKey(fId);
		BReview bReview = shenheHandleService.selectByFId(fId);
		bReview.setfReviewResult((byte) ReviewResultEnum.reviewSuccess.getCode());
		bReview.setfReviewTime(new Date());
		bReview.setfRemark(text);
		boolean flag = shenheHandleService.updateByFId(bReview);
		if (flag) {
			BBroadcastData broadcastData = bBroadcastDataService.selectByPrimaryKey(fReviewObjectId);
			broadcastData.setfState((byte) BroadcastStateEnum.waitBroadcast.getCode());
			flag_data = bBroadcastDataService.updateBroadcastState(broadcastData);
			if (flag_data) {
				// 设备广播处理 -插入设备资源编码
				if (broadcastData.getfDeviceResourcecode() == null) {
					// 根据简化了的区域ids查询出原来选中的所有区域id 2019-04-07 lxg
					String resourceIds = tAdministrativeDivisionService
							.getAssociationByResourceIds(broadcastData.getfBroadcastArea());
					// 根据广播选中的区域查询对应的设备
					audioPlayService.addDeviceByResourceIds(resourceIds, broadcastData.getfId(),
							(int) broadcastData.getfBroadcastType());
				} else {
					// 根据广播选中的设备 插入到广播设备表llj
					audioPlayService.addDeviceResourceIds(broadcastData.getfDeviceResourcecode(),
							broadcastData.getfId(), (int) broadcastData.getfBroadcastType());
				}
				
				String adapterResourceCode = bBroadcastDataService.queryAdapterCode(broadcastData.getfControlDevice());
				BroadcastResult result = dispatchHttpclientService.sendBroadcast(dispatchServerTomcatPort,
						 Integer.valueOf(broadcastData.getfBroadcastType()),
						broadcastData.getfId(),adapterResourceCode);
				return result;
			}
		}

		return BroadcastResult.ok();
	}

	/**
	 * @Desc Table表中点击通过按钮，将改变广播数据表和审核处理表中对应的状态，对于定时 广播表而言
	 * @Date 2019-01-13
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("/updateBroadcastStateForTiming/{fId}/{fReviewObjectId}/{text}")
	@ResponseBody
	public BroadcastResult updateBroadcastStateForTiming(@PathVariable Integer fId,
			@PathVariable Integer fReviewObjectId, @PathVariable String text) {
		boolean flag_data = false;
		// BReview bReview = shenheHandleService.selectByPrimaryKey(fId);
		BReview bReview = shenheHandleService.selectByFId(fId);
		bReview.setfReviewResult((byte) ReviewResultEnum.reviewSuccess.getCode());
		bReview.setfRemark(text);
		bReview.setfReviewTime(new Date());
		boolean flag = shenheHandleService.updateByFId(bReview);
		if (flag) {
			// 改变定时广播表的状态
			BBroadcastTiming bBroadcastTiming = scheduleService.selectByPrimaryKey(fReviewObjectId);
			bBroadcastTiming.setfReviewFlag((byte) BroadcastStateEnum.waitBroadcast.getCode());

			flag_data = scheduleService.updateBBroadcastTiming(bBroadcastTiming, fReviewObjectId);
			if (flag_data) {
				scheduleBroadcastJobService.createJob(fReviewObjectId);
			}
		}
		return BroadcastResult.ok(flag_data);
	}

	/**
	 * @Desc 点击不通过按钮，将改变广播数据表和审核处理表中对应的状态
	 * @Date 2019-01-02
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("/updateBroadcastStateFailed/{fId}/{fReviewObjectId}/{text}")
	@ResponseBody
	public BroadcastResult updateBroadcastStateFailed(@PathVariable Integer fId, @PathVariable Integer fReviewObjectId,
			@PathVariable String text) {
		boolean flag_data = false;
		BReview bReview = shenheHandleService.selectByFId(fId);
		bReview.setfReviewResult((byte) ReviewResultEnum.reviewFail.getCode());
		bReview.setfRemark(text);
		bReview.setfReviewTime(new Date());
		boolean flag = shenheHandleService.updateByFId(bReview);
		if (flag) {
			BBroadcastData broadCastData = bBroadcastDataService.selectByPrimaryKey(fReviewObjectId);
			broadCastData.setfState((byte) BroadcastStateEnum.reviewFail.getCode());
			flag_data = bBroadcastDataService.updateBroadcastState(broadCastData);
		}
		return BroadcastResult.ok(flag_data);
	}

	/**
	 * @Desc 点击不通过按钮，将改变定时广播和审核处理表中对应的状态
	 * @Date 2019-01-02
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("/updateBroadcastStateFailedTiming/{fId}/{fReviewObjectId}/{text}")
	@ResponseBody
	public BroadcastResult updateBroadcastStateFailedTiming(@PathVariable Integer fId,
			@PathVariable Integer fReviewObjectId, @PathVariable String text) {

		boolean flag_data = false;
		BReview bReview = shenheHandleService.selectByFId(fId);
		bReview.setfReviewResult((byte) ReviewResultEnum.reviewFail.getCode());
		bReview.setfRemark(text);
		bReview.setfReviewTime(new Date());

		boolean flag = shenheHandleService.updateByFId(bReview);
		if (flag) {
			BBroadcastTiming bBroadcastTiming = scheduleService.selectByPrimaryKey(fReviewObjectId);
			bBroadcastTiming.setfReviewFlag((byte) BroadcastStateEnum.reviewFail.getCode());
			flag_data = scheduleService.updateBBroadcastTiming(bBroadcastTiming, fReviewObjectId);
		}
		return BroadcastResult.ok(flag_data);
	}

	@RequestMapping("/overTime/{fId}/{type}/{fReviewObjectId}")
	@ResponseBody
	public BroadcastResult overTime(@PathVariable Integer fId, @PathVariable Integer type,
			@PathVariable Integer fReviewObjectId) {
		BReview bReview = shenheHandleService.selectByFId(fId);
		bReview.setfReviewResult((byte) ReviewResultEnum.overTime.getCode());
		bReview.setfReviewTime(new Date());
		shenheHandleService.updateByFId(bReview);
		if (type == 12) {
			BBroadcastTiming bBroadcastTiming = scheduleService.selectByPrimaryKey(fReviewObjectId);
			bBroadcastTiming.setfReviewFlag((byte) BroadcastStateEnum.userDefined.getCode());
			scheduleService.updateBBroadcastTiming(bBroadcastTiming, fReviewObjectId);
		} else {
			BBroadcastData broadCastData = bBroadcastDataService.selectByPrimaryKey(fReviewObjectId);
			broadCastData.setfState((byte) BroadcastStateEnum.userDefined.getCode());
			bBroadcastDataService.updateBroadcastState(broadCastData);
		}
		return BroadcastResult.ok();
	}

	/**
	 * @Desc 详情点击按钮，将改变广播数据表和审核处理表中对应的状态
	 * @Date 2019-01-02
	 * @Author Li LinFeng
	 * @return
	 */
	@RequestMapping("/selectfReviewObjectId/{fId}")
	@ResponseBody
	public BroadcastResult selectByfReviewObjectId(@PathVariable Integer fId) {
		BReview bReview = shenheHandleService.selectByFReviewObjectId(fId);
		return BroadcastResult.ok(bReview);
	}
}
