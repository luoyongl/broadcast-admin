package cn.wtu.broadcast.controller.shenhe;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.api.ReviewLogService;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BReviewLogExcelVO;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.BroadcastTypeEnum;
import cn.wtu.broadcast.parent.enums.ReviewResultEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.support.ExcelExportStylerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("shenhe/shenheLog")
public class ReviewLogController  extends BaseController{
	
	@Autowired
	private ReviewLogService reviewLogService;
	
	@GetMapping
	public String ui(Model model){
		return "shenhe/reviewLog";
	}
	
	@Autowired BBroadcastDataService bBroadcastDataService;
	
	@RequestMapping("/selectManualAutoLog")
	@ResponseBody
	public BroadcastResult selectManualAutoLog(
			@RequestParam(defaultValue="1", required=false) Integer pageNumber,
			@RequestParam(defaultValue="10", required=false) Integer pageSize,
			@RequestParam(defaultValue="", required=false) String searchText,
			@RequestParam(defaultValue="desc", required=false) String sortOrder,
			@RequestParam(defaultValue="fReviewTime", required=false) String sortName,
			HttpSession session) throws Exception{
		Map<String, Object> paramMap = new HashMap<>(4);
		TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
		paramMap.put("pageNumber", pageNumber);
		paramMap.put("pageSize", pageSize);
		if (searchText.equals("已审核")||searchText.equals("待播发")){
			paramMap.put("searchEq",ReviewResultEnum.reviewSuccess.getCode());
		}else if (searchText.equals("未通过")){
			paramMap.put("searchEq",ReviewResultEnum.reviewFail.getCode());
		}else if (searchText.equals("不通过")) {
			paramMap.put("searchEq",ReviewResultEnum.reviewFail.getCode());
		}else if (searchText.equals("已过期")){
			paramMap.put("searchEq",ReviewResultEnum.overTime.getCode());
		}else if (searchText.equals("模拟演练")){
			paramMap.put("searchByType", BroadcastTypeEnum.simulate.getCode());
		}else if (searchText.equals("实际演练")){
			paramMap.put("searchByType", BroadcastTypeEnum.practical.getCode());
		}else if (searchText.equals("系统演练")){
			paramMap.put("searchByType", BroadcastTypeEnum.system.getCode());
		}else if (searchText.equals("应急广播")){
			paramMap.put("searchByType", BroadcastTypeEnum.emergency.getCode());
		}else if (searchText.equals("定时广播")){
			paramMap.put("searchByType", BroadcastTypeEnum.timing.getCode());
		}else {
			paramMap.put("searchText", searchText);
		}
		paramMap.put("sortOrder", sortOrder);
		if(sortName.equals("fReviewTime")){
			paramMap.put("sortName", "fReviewTime");
		}

		//根据区域审核
		paramMap.put("reviewRegion",tUser.getfRespectiveRegion());
		
		paramMap.put("reviewState", ReviewResultEnum.waitReview.getCode());
		return BroadcastResult.ok(reviewLogService.selectManualAutoLog(paramMap));
	}
	
	
	@RequestMapping("/selectBroadcastDataById/{fReviewObjectId}/{fReviewResult}")
	@ResponseBody
	public BroadcastResult selectShenheBroadcastDetail(@PathVariable Integer fReviewObjectId, @PathVariable Integer fReviewResult){
		BroadcastResult broadcastResult = new BroadcastResult(200,String.valueOf(fReviewResult), bBroadcastDataService.selectBroadCastById(fReviewObjectId));
		return broadcastResult;
	}
	
	/**
     * 导出审核记录,最多5000条
     */
	@GetMapping("/download")
    public String download(Model model) {
    	Map<String, Object> paramMap = new HashMap<>(4);
    	List<BReviewLogExcelVO> list = reviewLogService.selectReviewLogInfos(paramMap);
    	ExportParams params = new ExportParams(null, "审核日志信息", ExcelType.XSSF);
        params.setStyle(ExcelExportStylerImpl.class);
        params.setFixedTitle(false);
        params.setHeight((short) 8);
        params.setDynamicData(true);
        model.addAttribute(NormalExcelConstants.DATA_LIST, list);
        model.addAttribute(NormalExcelConstants.CLASS, BReviewLogExcelVO.class);
        model.addAttribute(NormalExcelConstants.PARAMS, params);
        model.addAttribute(NormalExcelConstants.FILE_NAME, "审核日志信息");
    	
        return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
    }
	
}
