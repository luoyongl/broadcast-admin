package cn.wtu.broadcast.controller.resourceManage;

import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.CertificateService;
import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.model.BCertificates;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.vo.CertificateImpVO;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.util.FileUtils;
import cn.wtu.broadcast.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("resourceManage/receiveCertificate")
public class CertificateController extends BaseController {
	@Autowired
	private CertificateService certificateService;
	@Autowired
	private EmergencyDeviceService emergencyDeviceService;

	@GetMapping
	public String ui(Model model) {
		List<BDeviceInfo> frontDeviceInfoList = emergencyDeviceService
				.selectDeviceForTelList((byte) DeviceTypeEnum.frontDevice.getCode());
		List<BDeviceInfo> terminalDeviceInfoList = emergencyDeviceService
				.selectDeviceForTelList((byte) DeviceTypeEnum.terminalDevice.getCode());
		List<BDeviceInfo> deviceList = new ArrayList<BDeviceInfo>();
		deviceList.addAll(frontDeviceInfoList);
		deviceList.addAll(terminalDeviceInfoList);
		model.addAttribute("deviceList", deviceList);
		return "resourceManage/receiveCertificate";
	}

	@ResponseBody
	@RequestMapping("/getCertificateList")
	public BroadcastResult getCertificateList(@RequestParam(defaultValue = "1", required = false) Integer Number,
			@RequestParam(defaultValue = "10", required = false) Integer Size,
			@RequestParam(defaultValue = "desc", required = false) String sortOrder,
			@RequestParam(defaultValue = "", required = false) String searchText,
			@RequestParam(defaultValue = "fId", required = false) String sortName) {
		Map<String, Object> paramMap = new HashMap<>(4);
		paramMap.put("pageNumber", Number);
		paramMap.put("pageSize", Size);
		paramMap.put("searchText", searchText);
		paramMap.put("sortOrder", sortOrder);
		paramMap.put("sortName", "f_id");
		if (sortName.equals("fDeviceName")) {
			paramMap.put("sortName", "f_device_name");
		} else if (sortName.equals("fCertificatesNumber")) {
			paramMap.put("sortName", "f_certificates_number");
		} else if (sortName.equals("fCertificatesPeriodOfValidity")) {
			paramMap.put("sortName", "f_start_date_of_validity");
		}
		return BroadcastResult.ok(certificateService.queryPage(paramMap));
	}

	@ResponseBody
	@RequestMapping("/insertOrUpdateCertificate")
	public BroadcastResult insertOrUpdateCertificate(BCertificates bCertificate, String certificatesPeriodOfValidity) {
		BroadcastResult broadcastResult = new BroadcastResult();
		if (certificatesPeriodOfValidity != null && certificatesPeriodOfValidity != "") {
			//String date[] = certificatesPeriodOfValidity.split("至");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				//bCertificate.setfStartDateOfValidity(dateFormat.parse(date[0]));
				//bCertificate.setfEndDateOfValidity(dateFormat.parse(date[1]));
				bCertificate.setfEndDateOfValidity(dateFormat.parse(certificatesPeriodOfValidity));
			} catch (Exception e) {
				return BroadcastResult.fail("操作失败");
			}
		}
		if (certificateService.insertOrUpdateCertificate(bCertificate)) {
			broadcastResult = BroadcastResult.ok();
		} else {
			broadcastResult = BroadcastResult.fail();
		}
		return broadcastResult;
	}
	
	@ResponseBody
	@RequestMapping("/deleteCertificate")
	public BroadcastResult deleteCertificate(HttpServletRequest request) {
		String idsObj = RequestUtils.getRequestKeyValue(request, "ids");
		String[] idsArr = idsObj.split(",");
		return BroadcastResult.build(200, "取消了" + certificateService.deleteByPrimaryKey(idsArr) + "条记录");
	}
	
	@RequestMapping("/importExcel")
	@ResponseBody
	public BroadcastResult importExcel(@RequestParam("excelFile") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		BroadcastResult broadcastResult = new BroadcastResult();
		int successSize = 0;
		int failSize = 0;
		int listSize = 0;
		// 解 析excel，
		List<CertificateImpVO> list = new ArrayList<CertificateImpVO>();
		if (file == null) {
			return BroadcastResult.fail("导入文件存在错误,请检查后重试！");
		}else{
			try {
				list = FileUtils.importExcel(file, 0, 1, CertificateImpVO.class);
			} catch (Exception e) {
				broadcastResult.setStatus(400);
	            broadcastResult.setMsg("文件读取出错!");
			}
			listSize = list.size();
			if(listSize<=0){
				broadcastResult.setStatus(400);
	            broadcastResult.setMsg("读取文件数据失败,请检查数据是否正确!");
			}else{
				 successSize = certificateService.importExcel(list);
				 failSize = listSize-successSize;
				 if(successSize==0){
					 broadcastResult.setStatus(400);
					 broadcastResult.setMsg("成功导入"+successSize+"条记录,失败"+failSize+"条");
				 }
				 if(failSize!=0){
					 broadcastResult.setStatus(200);
					 broadcastResult.setMsg("成功导入"+successSize+"条记录,失败"+failSize+"条");
				 }else{
					 broadcastResult.setStatus(200);
					 broadcastResult.setMsg("成功导入"+successSize+"条记录!");
				 }
			}
		}
		return broadcastResult;
	}
	
	@ResponseBody
	@RequestMapping("/isOnlyName")
	public BroadcastResult isOnlyName(HttpServletRequest request) {
		String deviceName = RequestUtils.getRequestKeyValue(request, "fDeviceName");
		List<String> names = certificateService.queryDeviceNames();
		boolean isExisted = false;
		for (int i = 0; i < names.size(); i++) {
			if (deviceName.equals(names.get(i))) {
				isExisted = true;
			}
		}
		if (isExisted == false) {
			return BroadcastResult.build(200, "");
		} else {
			return BroadcastResult.build(400, "重名");
		}
	}

	@ResponseBody
	@RequestMapping("/isOnlyCode")
	public BroadcastResult isOnlyCode(HttpServletRequest request) {
		String fDeviceResourceCode = RequestUtils.getRequestKeyValue(request, "fDeviceResourceCode");
		if (certificateService.countByCode(fDeviceResourceCode)>0){
			return BroadcastResult.build(400,"重复");
		}else {
			return BroadcastResult.build(200,"");
		}

	}
}