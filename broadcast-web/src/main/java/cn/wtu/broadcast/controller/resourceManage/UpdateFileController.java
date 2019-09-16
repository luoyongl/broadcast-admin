package cn.wtu.broadcast.controller.resourceManage;


import cn.wtu.broadcast.openapi.api.BUpdateFileService;
import cn.wtu.broadcast.openapi.api.ManufacturerService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.BUpdateFile;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TManufacturer;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("resourceManage/updateFile")
public class UpdateFileController {

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private TDictionaryService tDictionaryService;

    @Autowired
    private BUpdateFileService bUpdateFileService;

    @GetMapping
    public String ui(Model model) {
        List<TManufacturer> list = manufacturerService.selectManufacturerForUpdateFile();
        List<TDictionary> frontDeviceList = tDictionaryService.selectListByCriteria("frontDevice_model");
        List<TDictionary> terminalDeviceList = tDictionaryService.selectListByCriteria("terminalDevice_model");
        model.addAttribute("manufacturerList", list);
        model.addAttribute("frontDeviceList", frontDeviceList);
        model.addAttribute("terminalDeviceList", terminalDeviceList);
        return "resourceManage/updateFile";
    }

    @RequestMapping("/addUpdateFile")
    @ResponseBody
    public BroadcastResult addfile(BUpdateFile bUpdateFile) {
        try {
            boolean ok = bUpdateFileService.addUpdateFile(bUpdateFile);
            if (!ok) {
                return BroadcastResult.fail();
            }
            return BroadcastResult.build(200, "上传成功");
        } catch (Exception e) {
            return BroadcastResult.build(200, "上传失败");
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
