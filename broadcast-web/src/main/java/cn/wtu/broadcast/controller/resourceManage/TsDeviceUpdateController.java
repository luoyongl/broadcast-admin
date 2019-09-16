package cn.wtu.broadcast.controller.resourceManage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.api.BUpdateFileService;
import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.api.ManufacturerService;
import cn.wtu.broadcast.openapi.api.TAdministrativeDivisionService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.BUpdateFile;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TManufacturer;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.TsDeviceUpdateVo;

@Controller
@RequestMapping("resourceManage/tsDeviceUpdate")
public class TsDeviceUpdateController {

    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private TDictionaryService tDictionaryService;
    @Autowired
    private BUpdateFileService bUpdateFileService;
    @Autowired
    private TAdministrativeDivisionService tAdministrativeDivisionService;
	@Autowired
	private EmergencyDeviceService deviceService;

    @GetMapping
    public String ui(Model model) {
        List<TManufacturer> list = manufacturerService.selectManufacturerForUpdateFile();
        List<TDictionary> frontDeviceList = tDictionaryService.selectListByCriteria("frontDevice_model");
        List<TDictionary> terminalDeviceList = tDictionaryService.selectListByCriteria("terminalDevice_model");
        model.addAttribute("manufacturerList", list);
        model.addAttribute("frontDeviceList", frontDeviceList);
        model.addAttribute("terminalDeviceList", terminalDeviceList);
        return "resourceManage/tsDeviceUpdate";
    }

    @RequestMapping("/addUpdateFile")
    @ResponseBody
    public BroadcastResult tsDeviceUpdate(BUpdateFile bUpdateFile,HttpServletRequest request) {
    	//暂时存放从页面传来的区域Id
    	String tempRegionIds = bUpdateFile.getfBroadcastArea();
        // 设置区域Id之前,需要简化
        String regionIds = tAdministrativeDivisionService.simplifyRegionIds(bUpdateFile.getfBroadcastArea());
        bUpdateFile.setfBroadcastArea(regionIds);
        
        try {
            boolean ok = bUpdateFileService.addUpdateFile(bUpdateFile);
            if (!ok) {
                return BroadcastResult.fail();
            }
            
            List<Integer> deviceModelList=new ArrayList<Integer>();
            //先确定设备类型, 4-适配器  5-音柱
            if(bUpdateFile.getfDeviceType() ==DeviceTypeEnum.adapter.getCode()){
            	//在字典表中查询出  前端设备的适配器,并返回id
            	deviceModelList=tDictionaryService.selectAdapterOrSoundDeviceIds("frontDevice_model");
            }else if(bUpdateFile.getfDeviceType() ==DeviceTypeEnum.soundDevice.getCode()){
            	deviceModelList=tDictionaryService.selectAdapterOrSoundDeviceIds("terminalDevice_model");
            }
            //根据一系列条件查询出 相关的 设备资源编码f_device_resource_code
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("manufacturerNumber", bUpdateFile.getfManufacturerNumber());
            map.put("deviceModelList", deviceModelList);
            map.put("resourceIdList", Arrays.asList(tempRegionIds.split(",")));
            
            List<String> deviceResourceCodes = deviceService.getDeviceByConditions(map);
			
            //封装ts设备升级vo,发送 ts设备升级指令 lxg
            TsDeviceUpdateVo tsDeviceUpdateVo =new TsDeviceUpdateVo();
            BeanUtils.copyProperties(bUpdateFile, tsDeviceUpdateVo);
            
            tsDeviceUpdateVo.setDeviceResourceCodes(deviceResourceCodes);
            /*//TODO 查询出DTMB调制参数
            String path = UploadUrlEnum.tsDeviceUpdate.getDesc() + File.separator + UUID.randomUUID().toString() + ".ts";
            //获取项目根目录相对路径
            String programRootUrl = request.getSession().getServletContext().getRealPath("/");
            tsStreamPackagedService.deviceUpdateHandle(tsDeviceUpdateVo,programRootUrl,path);
            */
            return BroadcastResult.build(200, "成功");
        } catch (Exception e) {
            return BroadcastResult.build(200, "失败");
        }

    }

    @RequestMapping("/selectUpdateFile")
    @ResponseBody
    public BroadcastResult selectUpdateFile(
            @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(defaultValue = "", required = false) String searchText,
            @RequestParam(defaultValue = "desc", required = false) String sortOrder,
            @RequestParam(defaultValue = "fCreateTime", required = false) String sortName,
            Integer fIpOrTs) {
        Map<String, Object> paramMap = new HashMap<>(4);
        paramMap.put("pageNumber", pageNumber);
        paramMap.put("pageSize", pageSize);
        paramMap.put("searchText", searchText);
        paramMap.put("sortOrder", sortOrder);
        paramMap.put("fIpOrTs", fIpOrTs);
        
        if (sortName.equals("fCreateTime")) {
            paramMap.put("sortName", "f_create_time");
        }
        return BroadcastResult.ok(bUpdateFileService.queryPage(paramMap,fIpOrTs));
    }

    @RequestMapping("/checkUpdateFileName")
    @ResponseBody
    public BroadcastResult selectUpdateFileName(@RequestParam(value="title")String title){
        if (bUpdateFileService.checkUpdateFileName(title)) {
            return BroadcastResult.build(400, "重复");
        }else{
            return BroadcastResult.build(200, "可添加");
        }
    }
    
    @RequestMapping("/ipControlUpdate")
    @ResponseBody
    public BroadcastResult ipControlUpdate(){
    	StringBuilder sb = new StringBuilder();
    	sb.append("06");
    	//sb.append(str)
		return null;
    }


    @RequestMapping("/UpdateFile")
    @ResponseBody
    public BroadcastResult UpdateFile(BUpdateFile bUpdateFile) {
        return BroadcastResult.ok(bUpdateFileService.updateByPrimaryKeySelective(bUpdateFile));

    }

    @RequestMapping("/deleteFile")
    @ResponseBody
    public BroadcastResult deleteFile(@RequestParam(value = "fId") String fId) {
        return BroadcastResult.build(200, "删除了" + bUpdateFileService.deleteFile(fId) + "条记录");
    }
}
