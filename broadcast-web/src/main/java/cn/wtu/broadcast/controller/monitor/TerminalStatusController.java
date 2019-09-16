package cn.wtu.broadcast.controller.monitor;

import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.api.TerminalStatusService;
import cn.wtu.broadcast.openapi.vo.TerminalStatusVO;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;
import cn.wtu.broadcast.parent.enums.DeviceStateEnum;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: LiLinFeng
 * @date: 2019-01-08 14:50
 */
@Controller
@RequestMapping("monitor/terminalStatus")
public class TerminalStatusController {

	@Autowired
    private TerminalStatusService terminalStatusService;
	@Autowired
	private EmergencyDeviceService emergencyDeviceService;
	
    @GetMapping
    public String ui(){
        return "monitor/terminalStatus";
    }

    /**
     * @Desc 查询终端播放状态的实时状态记录和播放记录
     * @param resourceId
     * @return
     */
    @RequestMapping("/selectTerStatus")
    @ResponseBody
    public BroadcastResult selectTerStatus(
        @RequestParam(value = "resourceId", defaultValue = "1") String resourceId){



        return BroadcastResult.ok();
    }
    
    @RequestMapping("/selectTerminalStatusList")
    @ResponseBody
    public BroadcastResult selectTerminalStatusList(
            @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(defaultValue = "", required = false) String searchText,
            @RequestParam(defaultValue = "0", required = false) Integer devType,
            @RequestParam Integer fBroadcastType,
            @RequestParam Integer fDeviceState) {
        Map<String, Object> paramMap = new HashMap<>();
        if(fDeviceState != 100) {
        	paramMap.put("fDeviceState", String.valueOf(fDeviceState));
        }
        if (fBroadcastType==1){
            paramMap.put("fBroadcastType", BroadcastStateEnum.broadcasting.getCode());
        }else {
            paramMap.put("fBroadcastType", BroadcastStateEnum.broadcasted.getCode());
        }
        if (devType==DeviceTypeEnum.adapter.getCode()){
            paramMap.put("devType",DeviceTypeEnum.adapter.getCode());
        }else {
            paramMap.put("devType",null);
        }
        paramMap.put("searchText",searchText);
        paramMap.put("pageNumber", pageNumber);
        paramMap.put("pageSize", pageSize);
        PageInfo<TerminalStatusVO> po = terminalStatusService.queryPageByTeminalStatusType(paramMap);
        return BroadcastResult.ok(po);
    }


    @ResponseBody
    @RequestMapping("/getDeviceList")
    public BroadcastResult getFrontDeviceList(@RequestParam(defaultValue = "1", required = false) Integer Number,
                                              @RequestParam(defaultValue = "10", required = false) Integer Size,
                                              @RequestParam(defaultValue = "desc", required = false) String sortOrder,
                                              @RequestParam(defaultValue = "", required = false) String searchText,
                                              @RequestParam(defaultValue = "", required = false) String sortName,
                                              @RequestParam(defaultValue = "", required = false)Integer state) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNumber", Number);
        paramMap.put("pageSize", Size);
        paramMap.put("deviceType", null);
        paramMap.put("searchText", searchText);
        paramMap.put("sortOrder", sortOrder);
        if (state==1){
            paramMap.put("state", DeviceStateEnum.online.getCode());
        }else if (state==2){
            paramMap.put("exception",true);
        }
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


}
