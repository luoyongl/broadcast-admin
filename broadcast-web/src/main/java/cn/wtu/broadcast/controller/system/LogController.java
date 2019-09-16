package cn.wtu.broadcast.controller.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.afterturn.easypoi.entity.vo.TemplateExcelConstants;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.LogService;
import cn.wtu.broadcast.openapi.model.TOperationLog;
import cn.wtu.broadcast.openapi.vo.LogVo;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;

/**
 * 日志控制器
 *
 * @author sueua
 * @since 2019-01-01
 */
@Controller
@RequestMapping("systemManage/log")
public class LogController extends BaseController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    /**
     * 日志页面
     */
    @GetMapping
    public String ui(Model model) {
        Map<Byte, String> map = Arrays.stream(OperationLogTypeEnum.values()).collect(Collectors.toMap(OperationLogTypeEnum::getValue, OperationLogTypeEnum::getDesc));
        model.addAttribute("operationTypeMap", JSONUtils.toString(map));
        return "systemManage/log";
    }

    /**
     * Bootstrap Table 数据
     */
    @GetMapping("list")
    @ResponseBody
    public BroadcastResult logList(@RequestParam(value = TableConst.PAGE_NO_STR, defaultValue = TableConst.PAGE_NO_DEFAULT_VALUE, required = false) Integer pageNumber,
                                   @RequestParam(value = TableConst.PAGE_SIZE_STR, defaultValue = TableConst.PAGE_SIZE_DEFAULT_VALUE, required = false) Integer pageSize,
                                   @RequestParam(defaultValue="", required=false) String startTime, 
                     			   @RequestParam(defaultValue="", required=false) String endTime,
                     			   @RequestParam(defaultValue="", required=false) String searchInfo) {
        Map<String, Object> paramMap = new HashMap<>(4);
        paramMap.put(TableConst.PAGE_NO_STR, pageNumber);
        paramMap.put(TableConst.PAGE_SIZE_STR, pageSize);
        if(startTime.equals("")&&endTime.equals("")&&searchInfo.equals("")){
        	return BroadcastResult.ok(logService.queryPageByParam(paramMap));
        }else{
        	if(startTime.equals("")||startTime==null){
     	    	startTime = "1900-01-01 10:00:00";
     	    }
     	    if(endTime.equals("")||endTime==null){
     	    	endTime = "2120-01-01 10:00:00";
     	    }
        	paramMap.put("startTime", startTime);
    		paramMap.put("endTime", endTime);
    		paramMap.put("searchInfo", searchInfo);		
    		return BroadcastResult.ok(logService.selectSearchTableInfo(paramMap));
        }
        
    }

    /**
     * 导出日志,最多5000条
     */
    @GetMapping("download")
    public String download(ModelMap modelMap) {
        Map<String, Object> paramMap = new HashMap<>(4);
        paramMap.put(TableConst.PAGE_NO_STR, 1);
        paramMap.put(TableConst.PAGE_SIZE_STR, 5000);
        PageInfo<TOperationLog> pageInfo = logService.queryPageByParam(paramMap);
        Map<String, Object> map = new HashMap<>(4);
        TemplateExportParams params = new TemplateExportParams("excel/log.xlsx");
        List<TOperationLog> list = pageInfo.getList();
        List<LogVo> logList = new ArrayList<>();
        Map<Byte, String> operationMap = Arrays.stream(OperationLogTypeEnum.values()).collect(Collectors.toMap(OperationLogTypeEnum::getValue, OperationLogTypeEnum::getDesc));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TOperationLog tOperationLog = list.get(i);
            LogVo logVo = new LogVo();
            BeanUtils.copyProperties(tOperationLog, logVo);
            logVo.setIndex(i + 1);
            logVo.setOperationType(operationMap.get(tOperationLog.getfOperationType()));
            logList.add(logVo);
        }
        map.put("logList", logList);
        modelMap.put(TemplateExcelConstants.FILE_NAME, "操作记录");
        modelMap.put(TemplateExcelConstants.PARAMS, params);
        modelMap.put(TemplateExcelConstants.MAP_DATA, map);
        return TemplateExcelConstants.EASYPOI_TEMPLATE_EXCEL_VIEW;

    }
    
	@RequestMapping("getSearchTableInfo")
	@ResponseBody
	public BroadcastResult getSearchTableInfo(
			  @RequestParam(value = TableConst.PAGE_NO_STR, defaultValue = TableConst.PAGE_NO_DEFAULT_VALUE, required = false) Integer pageNumber,
              @RequestParam(value = TableConst.PAGE_SIZE_STR, defaultValue = TableConst.PAGE_SIZE_DEFAULT_VALUE, required = false) Integer pageSize,
			  @RequestParam(defaultValue="", required=false) String startTime, 
			  @RequestParam(defaultValue="", required=false) String endTime,
			  @RequestParam(defaultValue="", required=false) String searchInfo){
		Map<String, Object> paramMap = new HashMap<>();	
	    if(startTime.equals("")||startTime==null){
	    	startTime = "1900-01-01 10:00:00";
	    }
	    if(endTime.equals("")||endTime==null){
	    	endTime = "2120-01-01 10:00:00";
	    }
	    paramMap.put(TableConst.PAGE_NO_STR, pageNumber);
        paramMap.put(TableConst.PAGE_SIZE_STR, pageSize);
		paramMap.put("startTime", startTime);
		paramMap.put("endTime", endTime);
		paramMap.put("searchInfo", searchInfo);
				
		return BroadcastResult.ok(logService.selectSearchTableInfo(paramMap));
	}
}
