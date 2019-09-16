package cn.wtu.broadcast.controller.resourceManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.dao.TSystemConfigurationMapper;
import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.openapi.model.TSystemConfigurationExample;
import cn.wtu.broadcast.openapi.util.SendIPUtils;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.IpWriteVO;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created on 2019/1/23 11:52
 *
 * @author LY
 */

@Controller
@SuppressWarnings("unused")
@RequestMapping("/resourceManage/handUpdate")
public class HandUpdateController {

	private Logger logger = LoggerFactory.getLogger(HandUpdateController.class);

	@Autowired
	private EmergencyDeviceService emergencyDeviceService;
	@Autowired
	private TDictionaryService tDictionaryService;
	@Autowired
	private BDeviceInfoService bDeviceInfoService;
	@Autowired
	private SystemConfigurationService systemConfigurationService;
	@Autowired
	private TSystemConfigurationMapper systemConfigurationMapper;

	@GetMapping
	public String ui(Model model) {
		model.addAttribute("deviceConfig", tDictionaryService.selectListByCriteria("device_config"));
		//状态参数查询 yinjie 2019/7/1
		model.addAttribute("queryCode", tDictionaryService.selectListByCriteria("query_code"));
		
		/*ModelAndView mv = new ModelAndView();
		mv.addObject("queryCode",	 tDictionaryService.selectListByCriteria("query_code"));
		mv.setViewName("resourceManage/handUpdate");*/
		return "resourceManage/handUpdate";
	}

	@ResponseBody
	@RequestMapping("/getDeviceList")
	public BroadcastResult getFrontDeviceList(@RequestParam(defaultValue = "1", required = false) Integer Number,
			@RequestParam(defaultValue = "10", required = false) Integer Size,
			@RequestParam(defaultValue = "desc", required = false) String sortOrder,
			@RequestParam(defaultValue = "", required = false) String searchText,
			@RequestParam(defaultValue = "", required = false) String sortName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pageNumber", Number);
		paramMap.put("pageSize", Size);
		paramMap.put("deviceType", null);
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
	/**
	 * 通过条件区域树及前端后端设备参数进行前端设备查询
	 *
	 */
	@ResponseBody
	@RequestMapping("/getFrontDeviceListByDivisions")
	public BroadcastResult getFrontDeviceListByDivisions(@RequestParam(defaultValue = "1", required = false) Integer Number,
			@RequestParam(defaultValue = "10", required = false) Integer Size,
			@RequestParam(defaultValue = "desc", required = false) String sortOrder,
			@RequestParam(defaultValue = "", required = false) String searchText,
			@RequestParam(defaultValue = "", required = false) String sortName,
			@RequestParam(value = "divisions",defaultValue = "",required = false)Integer[] divisions) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pageNumber", Number);
		paramMap.put("pageSize", Size);
		paramMap.put("deviceType", DeviceTypeEnum.frontDevice.getCode() + "");
		paramMap.put("searchText", searchText);
		paramMap.put("sortOrder", sortOrder);
		paramMap.put("divisions", divisions);
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
	@RequestMapping("/getTerminalDeviceListByDivisions")
	public BroadcastResult getTerminalDeviceListByDivisions(@RequestParam(defaultValue = "1", required = false) Integer Number,
			@RequestParam(defaultValue = "10", required = false) Integer Size,
			@RequestParam(defaultValue = "desc", required = false) String sortOrder,
			@RequestParam(defaultValue = "", required = false) String searchText,
			@RequestParam(defaultValue = "", required = false) String sortName,
			@RequestParam(value = "divisions",defaultValue = "",required = false)Integer[] divisions) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pageNumber", Number);
		paramMap.put("pageSize", Size);
		paramMap.put("deviceType", (byte) DeviceTypeEnum.terminalDevice.getCode());
		paramMap.put("searchText", searchText);
		paramMap.put("sortOrder", sortOrder);
		paramMap.put("divisions", divisions);
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
	
	/*
	 * @param bDeviceParameterSet 参数配置modal
	 * @param fDeviceId 设备id
	 * @param fDtmbFreq Dtmb频率 有默认值
	 * @param fDtmbSymbolrate Dtmb符号率
	 * @param fDvbcFreq Dvbc频率
	 * @param fDvbcSymbolrate Dvbc符号率
	 * @return
	 */
	@RequestMapping("/saveConfig")
	@ResponseBody
	public BroadcastResult saveConfig(IpWriteVO ipWriteVO,
			@RequestParam(value = "deviceSourceCode") String deviceSourceCode,
			@RequestParam(value = "deviceID") Integer deviceID) {
		// 查询平台资源编码，私钥，
		TSystemConfigurationExample systemConfigurationExample = new TSystemConfigurationExample();
		List<String> queryName = new ArrayList<String>();
		queryName.add("platform_resource_code");
		queryName.add("private_key");
		systemConfigurationExample.createCriteria().andFConfigurationNameIn(queryName);
		List<TSystemConfiguration> configurations = systemConfigurationMapper
				.selectByExample(systemConfigurationExample);
		for (int i = 0; i < configurations.size(); i++) {
			if (configurations.get(i).getfConfigurationName().equals("platform_resource_code")) {
				ipWriteVO.setPlatFormSourceCode(configurations.get(i).getfConfigurationValue());
			} else if (configurations.get(i).getfConfigurationName().equals("private_key")) {
				ipWriteVO.setPrivateKey(configurations.get(i).getfConfigurationValue());
			}
		}
		if (deviceID != null) {
			ipWriteVO.setDeviceID(deviceID);
		}
		// TODO map里面的key值以后要将资源编码改成物理地址
		ChannelHandlerContext ChannelHandlerContext = SendIPUtils.ctxMap.get(ipWriteVO.getDeviceSourceCode());
		String answer = SendIPUtils.answerMap.get(ipWriteVO.getDeviceSourceCode());
		// SendIPUtils.deviceWriteControl(ChannelHandlerContext.channel(),
		// answer, ipWriteVO);
		return BroadcastResult.ok();

	}

	public String testName(String answer, int talkTag1, String privateKey) {
		// head部分
		// "01"请求
		String askOrAnswer = "01";
		// 会话标记
		String talkTag = addZeroForNum(Integer.toString(talkTag1), 8);
		// 获取签名标志
		String isSign = "01";
		// 协议类型 例如0200
		String protocol = answer.substring(4, 8);// "0200";
		// 缺少数据包长度,后面会加上
		String head = "fefd" + protocol + talkTag + askOrAnswer + isSign;

		// body部分
		String platForm = "010345108100000001"; // 平台编码
		String objCounts = "0001";
		String objCode = "061245140210220301"; // 设备资源码

		String serviceType = "12"; // 12 终端参数配置

		String serviceDataLen = "";

		// 业务数据
		StringBuilder sb = new StringBuilder();
		// 要配置的参数个数
		sb.append("01");
		sb.append("2303"); // 参数编码
		sb.append("09"); // 资源码长度
		sb.append("061245120000000301");

		serviceDataLen = addZeroForNum(Integer.toHexString(sb.length() / 2), 4);
		String body = platForm + objCounts + objCode + serviceType + serviceDataLen + sb.toString();

		StringBuilder allData = new StringBuilder(head);

		return allData.toString();
	}

	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);// 左补0
				// sb.append(str).append("0");//右补0
				str = sb.toString();
				strLen = str.length();
			}
		}

		return str;
	}
}
