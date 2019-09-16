package cn.wtu.broadcast.controller.monitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.vo.ExceptionDeviceExportVO;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.support.ExcelExportStylerImpl;

/**
 * @description:
 * @author: LiLinFeng
 * @date: 2019-01-17 15:07
 */
@Controller
@RequestMapping("monitor/exceptionDevice")
public class ExceptionDeviceController {

	@Autowired
	private BDeviceInfoService bDeviceInfoService;
	
    @GetMapping
    public String ui(){
        return "monitor/exceptionDevice";
    }
    
    /**
     * @Desc 查询异常设备信息
	 * @Author LiLinFeng
	 * @Date 2019-01-16
     * @param searchText
     * @param sortOrder
     * @param sortName
     * @return
     */
    @RequestMapping("/selectExceptionDeviceInfos")
    @ResponseBody
    public BroadcastResult selectExceptionDeviceInfos(
    		@RequestParam(defaultValue = "1", required = false) Integer Number,
			@RequestParam(defaultValue = "10", required = false) Integer Size,
			@RequestParam(defaultValue = "desc", required = false) String sortOrder,
			@RequestParam(defaultValue = "", required = false) String searchText,
			@RequestParam(defaultValue = "", required = false) String sortName){
    	
    	Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pageNumber", Number);
		paramMap.put("pageSize", Size);
		paramMap.put("deviceType", (byte) DeviceTypeEnum.frontDevice.getCode());
		paramMap.put("searchText", searchText);
		paramMap.put("sortOrder", sortOrder);
		if (sortName.equals("fDeviceName")) {
			paramMap.put("sortName", "f_device_name");
		} else if (sortName.equals("fRealDeviceModel")) {
			paramMap.put("sortName", "f_device_model");
		} else if (sortName.equals("fDeviceResourceCode")) {
			paramMap.put("sortName", "f_device_resource_code");
		} else if (sortName.equals("fRealArea")) {
			paramMap.put("sortName", "f_location");
		}else if (sortName.equals("fDeviceState")) {
			paramMap.put("sortName", "f_device_state");
		} else if (sortName.equals("fUpdateTime")) {
			paramMap.put("sortName", "f_update_time");
		}  else {
			paramMap.put("sortName", "f_id");
		}
	    
    	return BroadcastResult.ok(bDeviceInfoService.selectExceptionDeviceInfos(paramMap));
    }

	/**
	 * @Desc 导出异常设备信息
	 * @Author LiLinFeng
	 * @Date 2019-01-17
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/exportExceptionDeviceExcel")
	public String exportFrontExcel(HttpServletRequest request,HttpServletResponse response,Model model) {
		// 解 析excel，
		List<ExceptionDeviceExportVO> list = new ArrayList<ExceptionDeviceExportVO>();
		list = bDeviceInfoService.queryExceptionDeviceInfos();
		Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);
		for (ExceptionDeviceExportVO ex : list) {
			ex.setfDate(dateString);
			String fDeviceState = ex.getfDeviceState();
			if(fDeviceState.equals("0")){
				ex.setfDeviceState("正在广播");
			}else if(fDeviceState.equals("1")){
				ex.setfDeviceState("在线");
			}else if(fDeviceState.equals("2")){
				ex.setfDeviceState("离线");
			}else if(fDeviceState.equals("3")){
				ex.setfDeviceState("停电");
			}else if(fDeviceState.equals("4")){
				ex.setfDeviceState("故障");
			}
		}
		try {
			ExportParams params = new ExportParams(null, "异常设备信息", ExcelType.XSSF);
			params.setStyle(ExcelExportStylerImpl.class);
			params.setFixedTitle(false);
			params.setHeight((short) 8);
			
			params.setDynamicData(true);
			model.addAttribute(NormalExcelConstants.DATA_LIST, list);
			model.addAttribute(NormalExcelConstants.CLASS, ExceptionDeviceExportVO.class);
			model.addAttribute(NormalExcelConstants.PARAMS, params);
			model.addAttribute(NormalExcelConstants.FILE_NAME, "异常设备信息");
			//FileUtils.exportExcel(list, "设备信息表", "设备信息", DeviceExportVO.class, "客户订单统计表.xls", response);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
	}
}
