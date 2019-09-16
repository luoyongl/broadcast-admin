package cn.wtu.broadcast.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.wtu.broadcast.openapi.api.AudioManageService;
import cn.wtu.broadcast.openapi.model.BAudioData;
import cn.wtu.broadcast.parent.enums.UploadUrlEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.PropertiesUtil;
import cn.wtu.broadcast.parent.utils.string.StringUtil;
import cn.wtu.broadcast.parent.vo.UploadResult;
import ws.schild.jave.MultimediaObject;

/**
 * //TODO
 * 删除操作中音频都没有从资源库中删除,待商议
 */
@Controller
@RequestMapping("broadcast/ftps")
public class FtpUploadController_b extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(AudioManageController.class);

	@Autowired
	private AudioManageService audioManageService;

    private String uploadPrefixUrl = PropertiesUtil.getProperty("upload.prefix.url");

	@GetMapping
	public String ui(){
		
		return "broadcast/audioManage";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/upload/{second}/{fAudioName}/{fRemark}")
	@ResponseBody
	public BroadcastResult upload(@RequestParam("files") CommonsMultipartFile[] files,
                                  @PathVariable("second") Integer second,
                                  @PathVariable("fAudioName") String fAudioName,
                                  @PathVariable("fRemark") String fRemark,
                                  HttpServletRequest request){
	    int index=0;
        BAudioData bAudioData = new BAudioData();
        for (CommonsMultipartFile file : files) {

            //循环保存文件
            if (index>=1){
                bAudioData.setfAudioName(fAudioName+"-"+index);
            }else {
                bAudioData.setfAudioName(fAudioName);
            }
            bAudioData.setfRemark(fRemark);
            DiskFileItem diskFileItem = (DiskFileItem)file.getFileItem();
            File source = diskFileItem.getStoreLocation();
            bAudioData.setfAudioSize(String.valueOf(source.length()));
            MultimediaObject multimediaObject = new MultimediaObject(source);
            try {
                bAudioData.setfBitRate(multimediaObject.getInfo().getAudio().getBitRate());
                bAudioData.setfSampleRate(BigDecimal.valueOf(multimediaObject.getInfo().getAudio().getSamplingRate()));
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
                return BroadcastResult.build(200,"上传失败");
            }
            Date date = new Date();
            bAudioData.setfCreateTime(date);
            bAudioData.setfUpdateTime(date);
            bAudioData.setfTime(second);
            bAudioData.setfDeleteFlag(false);
            String programPath = UploadUrlEnum.getEnumByCode("3").getDesc()+ File.separator + UUID.randomUUID().toString() + ".mp3";
            String fileUrl = request.getSession().getServletContext().getRealPath("/") +  programPath;
            String returnUrl = uploadPrefixUrl  + programPath;
            bAudioData.setfAudioUrl(returnUrl);
            try {
                long start = System.currentTimeMillis();
                //上传文件
                FileUtils.copyInputStreamToFile(file.getInputStream(),new File(fileUrl));
                long end = System.currentTimeMillis();
                boolean ok = audioManageService.uploadFile(bAudioData);
                UploadResult uploadFileToServer = uploadFileToServer(file);
                if(!ok){
                    return BroadcastResult.fail();
                }
            } catch (Exception e) {
                return BroadcastResult.build(200,"上传失败");
            }
            index++;
        }
        return BroadcastResult.build(200,"上传成功");
	}

    /**
     * Bootstrap Table 数据
     */
    @GetMapping("/list")
    @ResponseBody
    public BroadcastResult audioList(@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
                                       @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                       @RequestParam(defaultValue="", required=false) String searchText,
                                       @RequestParam(defaultValue="desc", required=false) String sortOrder,
                                       @RequestParam(defaultValue="f_id", required=false) String sortName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNo", pageNumber);
        paramMap.put("pageSize", pageSize);
        paramMap.put("searchText",searchText);
        paramMap.put("sortOrder",sortOrder);
        paramMap.put("sortName",StringUtil.FieldNameToColumnName(sortName));
        return BroadcastResult.ok(audioManageService.queryPageByParam(paramMap));
    }

    @DeleteMapping
    @ResponseBody
    public BroadcastResult delete(@RequestParam(value="ids") List<Integer> idList,HttpServletRequest request){
        String del_path = request.getSession().getServletContext().getRealPath("/")+UploadUrlEnum.getEnumByCode("3").getDesc();
        return BroadcastResult.build(200,"删除了" + audioManageService.deleteAudioByIds(idList,del_path) + "条记录");
    }

    @RequestMapping("/update/{audioName}/{fId}")
    @ResponseBody
    public BroadcastResult update(@PathVariable("audioName") String audioName,@PathVariable("fId") Integer fId){
        BAudioData bAudioData = new BAudioData();
        bAudioData.setfAudioName(audioName);
        bAudioData.setfId(fId);
        boolean ok = audioManageService.updateAudio(bAudioData);
        if(ok){
            return BroadcastResult.build(200,"修改成功");
        }else{
            return BroadcastResult.build(200,"修改失败");
        }
    }
    
    @RequestMapping("/getSensitiveWords")
    @ResponseBody
    public BroadcastResult getSensitiveWords(HttpServletRequest request){	
        return BroadcastResult.ok(audioManageService.selectSensitiveWords());
    }
    /**
     * @param audioName
     * @param fId
     * @return
     */
    @RequestMapping("/checkUsed/{fIds}")
    @ResponseBody
    public Boolean checkAudioUsed(@PathVariable("fIds") List<Integer> idList,HttpServletRequest request){
    	for(Integer id : idList){
    		if(id!=null&&audioManageService.checkAudioUsed(id)){
    			return true;
    		}
    	} 
    	return false;
    	
    }
}
