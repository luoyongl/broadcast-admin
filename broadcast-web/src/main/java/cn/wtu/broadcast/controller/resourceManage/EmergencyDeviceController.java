package cn.wtu.broadcast.controller.resourceManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.wtu.broadcast.config.DeviceBroadcastConfig;
import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.api.TAdministrativeDivisionService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TManufacturer;
import cn.wtu.broadcast.openapi.vo.BAdapterInfo;
import cn.wtu.broadcast.openapi.vo.FrontDeviceExportVO;
import cn.wtu.broadcast.openapi.vo.TerminalDeviceExportVO;
import cn.wtu.broadcast.openapi.vo.TerminalDeviceVO;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.support.ExcelExportStylerImpl;
import cn.wtu.broadcast.util.FileUtils;
import cn.wtu.broadcast.util.RequestUtils;

@Controller
@RequestMapping("resourceManage/emergencyDevice")
public class EmergencyDeviceController {

	@Autowired
	private TDictionaryService tDictionaryService;

	@Autowired
	private EmergencyDeviceService emergencyDeviceService;

	@Autowired
	private TAdministrativeDivisionService tAdministrativeDivisionService;

	@GetMapping
	public String ui(Model model) {
		List<TDictionary> deviceModelList = tDictionaryService.selectListByCriteria("device_model");
		List<TDictionary> frontDeviceList = tDictionaryService.selectListByCriteria("frontDevice_model");
		List<TDictionary> terminalDeviceList = tDictionaryService.selectListByCriteria("terminalDevice_model");
		List<TDictionary> protocolTypeList = tDictionaryService.selectListByCriteria("protocol_type");
		List<TDictionary> devicechannelList = tDictionaryService.selectListByCriteria("device_channel");
		List<TDictionary> resourceLevelList = tDictionaryService.selectListByCriteria("resource_level");
		List<TDictionary> resourceSubtypesList = tDictionaryService.selectListByCriteria("resource_subtypes");
		List<Map<String, Object>> adapterListTemp = emergencyDeviceService.getAllAdapter();
		List<BAdapterInfo> adapterList = new ArrayList<BAdapterInfo>();
		for (Map<String, Object> m : adapterListTemp) {
			BAdapterInfo BAdapterInfo = new BAdapterInfo();
			BAdapterInfo.setfId(Integer.parseInt(String.valueOf(m.get("f_id"))));
			BAdapterInfo.setfDeviceName(String.valueOf(m.get("f_device_name")));
			adapterList.add(BAdapterInfo);
		}
		List<TAdministrativeDivision> divisionList = emergencyDeviceService.queryDivision();
		List<TManufacturer> manufacturerList = emergencyDeviceService.queryManufacturer();
		model.addAttribute("deviceModelList", deviceModelList);
		model.addAttribute("divisionList", divisionList);
		model.addAttribute("frontDeviceList", frontDeviceList);
		model.addAttribute("terminalDeviceList", terminalDeviceList);
		model.addAttribute("protocolTypeList", protocolTypeList);
		model.addAttribute("manufacturerList", manufacturerList);
		model.addAttribute("devicechannelList", devicechannelList);
		model.addAttribute("adapterList", adapterList);
		model.addAttribute("resourceLevelList", resourceLevelList);
		model.addAttribute("resourceSubtypesList", resourceSubtypesList);
		return "resourceManage/emergencyDevice";
	}

	@ResponseBody
	@RequestMapping("/getFrontDeviceList")
	public BroadcastResult getFrontDeviceList(@RequestParam(defaultValue = "1", required = false) Integer Number,
			@RequestParam(defaultValue = "10", required = false) Integer Size,
			@RequestParam(defaultValue = "desc", required = false) String sortOrder,
			@RequestParam(defaultValue = "", required = false) String searchText,
			@RequestParam(defaultValue = "", required = false) String sortName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pageNumber", Number);
		paramMap.put("pageSize", Size);
		paramMap.put("deviceType", DeviceTypeEnum.frontDevice.getCode() + "");
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
		} else if (sortName.equals("fDeviceState")) {
			paramMap.put("sortName", "f_device_state");
		} else if (sortName.equals("fUpdateTime")) {
			paramMap.put("sortName", "f_update_time");
		} else {
			paramMap.put("sortName", "f_update_time");
		}
		return BroadcastResult.ok(emergencyDeviceService.queryDevicePage(paramMap));
	}

	@ResponseBody
	@RequestMapping("/getTerminalDeviceList")
	public BroadcastResult getTerminalDeviceList(@RequestParam(defaultValue = "1", required = false) Integer Number,
			@RequestParam(defaultValue = "10", required = false) Integer Size,
			@RequestParam(defaultValue = "desc", required = false) String sortOrder,
			@RequestParam(defaultValue = "", required = false) String searchText,
			@RequestParam(defaultValue = "", required = false) String sortName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pageNumber", Number);
		paramMap.put("pageSize", Size);
		paramMap.put("deviceType", (byte) DeviceTypeEnum.terminalDevice.getCode());
		paramMap.put("searchText", searchText);
		paramMap.put("sortOrder", sortOrder);
		if (sortName.equals("fDeviceName")) {
			paramMap.put("sortName", "f_device_name");
		} else if (sortName.equals("fDeviceResourceCode")) {
			paramMap.put("sortName", "f_device_resource_code");
		} else if (sortName.equals("fRealDeviceModel")) {
			paramMap.put("sortName", "f_device_model");
		} else if (sortName.equals("fRealArea")) {
			paramMap.put("sortName", "f_location");
		} else if (sortName.equals("fDeviceState")) {
			paramMap.put("sortName", "f_device_state");
		} else if (sortName.equals("fUpdateTime")) {
			paramMap.put("sortName", "f_update_time");
		} else {
			paramMap.put("sortName", "f_update_time");
		}
		return BroadcastResult.ok(emergencyDeviceService.queryDevicePage(paramMap));
	}

	@ResponseBody
	@RequestMapping("/insertOrUpdateFrontDevice")
	public BroadcastResult insertOrUpdateFrontDevice(BDeviceInfo bDeviceInfo, HttpServletRequest request) {
		BroadcastResult broadcastResult = new BroadcastResult();

		// 根据 设备类型即字典id查询出 字典id对应的f_third_code,并赋值给fCode
		String thirdCode = tDictionaryService.getThirdCodeById(Integer.parseInt(bDeviceInfo.getfDeviceModel()));
		bDeviceInfo.setfCode(thirdCode);

		bDeviceInfo.setfDeviceType((byte) DeviceTypeEnum.frontDevice.getCode());
		if (emergencyDeviceService.insertOrUpdateDevice(bDeviceInfo)) {
			broadcastResult = BroadcastResult.ok();
			DeviceBroadcastConfig.reload();
		} else {
			broadcastResult = BroadcastResult.fail();
			DeviceBroadcastConfig.reload();
		}
		return broadcastResult;
	}

	@ResponseBody
	@RequestMapping("/insertOrUpdateTerminalDevice")
	public BroadcastResult insertOrUpdateTerminalDevice(BDeviceInfo bDeviceInfo, HttpServletRequest request) {
		BroadcastResult broadcastResult = new BroadcastResult();

		// 根据 设备类型即字典id查询出 字典id对应的f_third_code,并赋值给fCode
		String thirdCode = tDictionaryService.getThirdCodeById(Integer.parseInt(bDeviceInfo.getfDeviceModel()));
		bDeviceInfo.setfCode(thirdCode);

		bDeviceInfo.setfDeviceType((byte) DeviceTypeEnum.terminalDevice.getCode());
		if (emergencyDeviceService.insertOrUpdateDevice(bDeviceInfo)) {
			DeviceBroadcastConfig.reload();
			broadcastResult = BroadcastResult.ok();
		} else {
			DeviceBroadcastConfig.reload();
			broadcastResult = BroadcastResult.fail();
		}
		return broadcastResult;
	}

	@ResponseBody
	@RequestMapping("/deleteFrontDevice")
	public BroadcastResult deleteFrontDevice(HttpServletRequest request) {
		String idsObj = RequestUtils.getRequestKeyValue(request, "ids");
		String[] idsArr = idsObj.split(",");
		DeviceBroadcastConfig.reload();
		return BroadcastResult.build(200, "删除了" + emergencyDeviceService.deleteAllByPrimaryKey(idsArr) + "条前端设备记录");
	}

	@ResponseBody
	@RequestMapping("/deleteTerminalDevice")
	public BroadcastResult deleteTerminalDevice(HttpServletRequest request) {
		String idsObj = RequestUtils.getRequestKeyValue(request, "ids");
		String[] idsArr = idsObj.split(",");
		DeviceBroadcastConfig.reload();
		return BroadcastResult.build(200, "删除了" + emergencyDeviceService.deleteAllByPrimaryKey(idsArr) + "条终端设备记录");
	}

	@RequestMapping("/importExcel")
	@ResponseBody
	public BroadcastResult importExcel(@RequestParam("textFile") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		BroadcastResult broadcastResult = new BroadcastResult();
		int successSize = 0;
		int failSize = 0;
		int listSize = 0;
		// 解 析excel，
		List<TerminalDeviceVO> terminalDeviceList = new ArrayList<TerminalDeviceVO>();
		if (file == null) {
			return BroadcastResult.fail("导入文件存在错误,请检查后重试！");
		} else {
			try {
				terminalDeviceList = FileUtils.importExcel(file, 0, 1, TerminalDeviceVO.class);
			} catch (Exception e) {
				broadcastResult.setStatus(400);
				broadcastResult.setMsg("文件读取出错!");
			}
			listSize = terminalDeviceList.size();
			if (listSize <= 0) {
				broadcastResult.setStatus(400);
				broadcastResult.setMsg("读取文件数据失败,请检查数据是否正确!");
			} else {
				successSize = emergencyDeviceService.importExcel(terminalDeviceList);
				failSize = listSize - successSize;
				if (successSize == 0) {
					broadcastResult.setStatus(400);
					broadcastResult.setMsg("成功导入" + successSize + "条记录,失败" + failSize + "条");
				}
				if (failSize != 0) {
					broadcastResult.setStatus(200);
					broadcastResult.setMsg("成功导入" + successSize + "条记录,失败" + failSize + "条");
				} else {
					broadcastResult.setStatus(200);
					broadcastResult.setMsg("成功导入" + successSize + "条记录!");
				}
			}
		}
		return broadcastResult;
	}

	@RequestMapping("/exportFrontExcel")
	public String exportFrontExcel(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 解 析excel，
		List<FrontDeviceExportVO> list = new ArrayList<FrontDeviceExportVO>();
		list = emergencyDeviceService.queryFrontExportDeviceInfo();
		try {
			ExportParams params = new ExportParams(null, "前端设备信息", ExcelType.XSSF);
			params.setStyle(ExcelExportStylerImpl.class);
			params.setFixedTitle(false);
			params.setHeight((short) 8);
			params.setDynamicData(true);
			model.addAttribute(NormalExcelConstants.DATA_LIST, list);
			model.addAttribute(NormalExcelConstants.CLASS, FrontDeviceExportVO.class);
			model.addAttribute(NormalExcelConstants.PARAMS, params);
			model.addAttribute(NormalExcelConstants.FILE_NAME, "前端设备信息");
			// FileUtils.exportExcel(list, "设备信息表", "设备信息",
			// DeviceExportVO.class, "客户订单统计表.xls", response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/error";
		}
		return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
	}

	@RequestMapping("/exportTerminalExcel")

	public String exportTerminalExcel(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 解 析excel，
		List<TerminalDeviceExportVO> list = new ArrayList<TerminalDeviceExportVO>();
		list = emergencyDeviceService.queryTerminalExportDeviceInfo();
		try {
			ExportParams params = new ExportParams(null, "终端设备信息", ExcelType.XSSF);
			params.setStyle(ExcelExportStylerImpl.class);
			params.setFixedTitle(false);
			params.setHeight((short) 8);
			params.setDynamicData(true);
			model.addAttribute(NormalExcelConstants.DATA_LIST, list);
			model.addAttribute(NormalExcelConstants.CLASS, TerminalDeviceExportVO.class);
			model.addAttribute(NormalExcelConstants.PARAMS, params);
			model.addAttribute(NormalExcelConstants.FILE_NAME, "终端设备信息");
			// FileUtils.exportExcel(list, "设备信息表", "设备信息",
			// DeviceExportVO.class, "客户订单统计表.xls", response);
		} catch (Exception e) {
			e.printStackTrace();
			return "error/error";
		}
		return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
	}

	@RequestMapping("/selectNumber")
	@ResponseBody
	public BroadcastResult selectNumber(Integer fId) {
		return BroadcastResult.ok(tAdministrativeDivisionService.selectByPrimaryKey(fId));
	}

	/**
	 * 查询对应适配器下的音柱数量
	 * 
	 * @param fId 适配器所在区域
	 * @return 音柱数目
	 */
	@RequestMapping("/count")
	@ResponseBody
	public BroadcastResult count(@RequestParam Integer fId) {
		return BroadcastResult.ok(emergencyDeviceService.count(fId));
	}
}
