package cn.wtu.broadcast.controller.resourceManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.wtu.broadcast.openapi.api.MonitorDeviceService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.vo.CameraVo;
import cn.wtu.broadcast.openapi.vo.ServerVo;
import cn.wtu.broadcast.parent.enums.UploadUrlEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.string.StringUtil;
import cn.wtu.broadcast.support.ExcelExportStylerImpl;

/**
 * @description:
 * @author: AYY
 * @date: 2018-12-26 16:39
 */

@Controller
@RequestMapping("resourceManage/monitorDevice")
public class MonitorDeviceController {

    @Autowired
    private TDictionaryService tDictionaryService;

    @Autowired
    private MonitorDeviceService monitorDeviceService;

    @GetMapping
    public String ui(HttpServletRequest request) {
        List<TDictionary> deviceModelList = tDictionaryService.selectListByCriteria("device_model");
        List<TDictionary> channelModelList = tDictionaryService.selectListByCriteria("channel_model");
        HttpSession session = request.getSession();

        session.setAttribute("deviceModelList", deviceModelList);
        session.setAttribute("channelModelList", channelModelList);
       /* session.setAttribute("regionList", JSONUtils.toString(RegionData.getUserZTreeList()));*/

        return "resourceManage/monitorDevice";
    }


    @RequestMapping("/add/{type}")
    @ResponseBody
    public BroadcastResult add(BDeviceInfo deviceInfo, @PathVariable Byte type) {

        boolean result = monitorDeviceService.add(deviceInfo, type);
        if (result) {
            return BroadcastResult.build(200, "新增成功");
        } else {
            return BroadcastResult.build(200, "新增失败");
        }
    }

    @RequestMapping("/updateCamera/{fId}/{type}")
    @ResponseBody
    public BroadcastResult addCamera(BDeviceInfo deviceInfo, @PathVariable("fId") Integer fId, @PathVariable("type") Byte type) {
        deviceInfo.setfId(fId);
        deviceInfo.setfDeviceType(type);
        if(deviceInfo.getfDeviceImage()!=null && deviceInfo.getfDeviceImage().equals("")){
            deviceInfo.setfDeviceImage(null);
        }

        boolean result = monitorDeviceService.updateCamera(deviceInfo);
        if (result) {
            return BroadcastResult.build(200, "修改成功");
        } else {
            return BroadcastResult.build(200, "修改失败");
        }
    }

    @GetMapping("/list/{type}")
    @ResponseBody
    public BroadcastResult cameraList(@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
                                      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                      @RequestParam(defaultValue = "", required = false) String searchText,
                                      @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                      @RequestParam(defaultValue = "f_id", required = false) String sortName,
                                      @PathVariable(value = "type") Integer type) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNo", pageNumber);
        paramMap.put("pageSize", pageSize);
        paramMap.put("searchText", searchText);
        paramMap.put("sortOrder", sortOrder);
        paramMap.put("sortName", StringUtil.FieldNameToColumnName(sortName));
        paramMap.put("type", type);
        return BroadcastResult.ok(monitorDeviceService.queryPageByParam(paramMap));
    }
    
    @RequestMapping("/getCameraInfo")
    @ResponseBody
    public BroadcastResult getCameraInfo() {

        return BroadcastResult.ok(monitorDeviceService.getCameraInfo());
    }

    @RequestMapping("/deleteCamera/{ids}/{type}")
    @ResponseBody
    public BroadcastResult delete(@PathVariable("ids") String ids, @PathVariable("type") Byte type,HttpServletRequest request) {
        String del_path = request.getSession().getServletContext().getRealPath("/")+UploadUrlEnum.getEnumByCode("1").getDesc();
        return BroadcastResult.build(200, "删除了" + monitorDeviceService.deleteByIds(ids, type,del_path) + "条信息");
    }

    @RequestMapping(value = "/check/{type}")
    @ResponseBody
    public BroadcastResult check(String name, @PathVariable("type") Byte type) {
        System.out.println(name);
        List<BDeviceInfo> deviceInfoList = monitorDeviceService.getAll(type);
        for (BDeviceInfo deviceInfo : deviceInfoList) {
            if (deviceInfo.getfNumber().equals(name)) {
                return BroadcastResult.ok("true");
            }
        }
        return BroadcastResult.ok("false");
    }

    /**
     * 导出摄像头设备信息
     * @param model
     * @return
     */
    @GetMapping("/exportCamera")
    public String exportCamera(Model model) {
        List<CameraVo> list = monitorDeviceService.selectCameraList();
        ExportParams params = new ExportParams(null, "监控摄像头信息", ExcelType.XSSF);
        params.setStyle(ExcelExportStylerImpl.class);
        params.setFixedTitle(false);
        params.setHeight((short) 8);
        params.setDynamicData(true);
        model.addAttribute(NormalExcelConstants.DATA_LIST, list);
        model.addAttribute(NormalExcelConstants.CLASS, CameraVo.class);
        model.addAttribute(NormalExcelConstants.PARAMS, params);
        model.addAttribute(NormalExcelConstants.FILE_NAME, "监控摄像头信息");
        return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
    }

    /**
     * 导出摄像头设备信息
     * @param model
     * @return
     */
    @GetMapping("/exportServer")
    public String exportServer(Model model) {
        List<ServerVo> list = monitorDeviceService.selectServerList();
        ExportParams params = new ExportParams(null, "监控服务器信息", ExcelType.XSSF);
        params.setStyle(ExcelExportStylerImpl.class);
        params.setFixedTitle(false);
        params.setHeight((short) 8);
        params.setDynamicData(true);
        model.addAttribute(NormalExcelConstants.DATA_LIST, list);
        model.addAttribute(NormalExcelConstants.CLASS, ServerVo.class);
        model.addAttribute(NormalExcelConstants.PARAMS, params);
        model.addAttribute(NormalExcelConstants.FILE_NAME, "监控服务器信息");
        return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
    }
}
