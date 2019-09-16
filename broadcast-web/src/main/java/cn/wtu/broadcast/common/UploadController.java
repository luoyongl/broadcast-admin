package cn.wtu.broadcast.common;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.wtu.broadcast.controller.AudioManageController;
import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.parent.enums.UploadUrlEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.PropertiesUtil;
import cn.wtu.broadcast.parent.vo.UploadResult;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-08 18:29
 */

@Controller
@RequestMapping("common")
public class UploadController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(AudioManageController.class);

    private String uploadPrefixUrl = PropertiesUtil.getProperty("upload.prefix.url");


	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
    public BroadcastResult upload(@RequestParam("file") CommonsMultipartFile file,
                                  @RequestParam("type") String type,
                                  HttpServletRequest request) {
        if (file.isEmpty()) {
            return BroadcastResult.build(500, "文件为空不能上传");
        }
        String fileName = file.getOriginalFilename();
        //后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        //文件夹路径 upload/image
        String folderPath = null;
        if (type.equals("3") && suffix.equals(".mp3")) {
            folderPath = UploadUrlEnum.getEnumByCode(type).getDesc();
        } else if (type.equals("1") && (suffix.equals(".jpg") || suffix.equals(".png") || suffix.equals(".jpeg"))) {
            folderPath = UploadUrlEnum.getEnumByCode(type).getDesc();
        } else if (type.equals("2") && (suffix.equals(".avi") || suffix.equals(".mov") || suffix.equals(".qt") || suffix.equals(".asf") || suffix.equals(".mf"))) {
            folderPath = UploadUrlEnum.getEnumByCode(type).getDesc();
        }else if(type.equals("4")){
            folderPath = UploadUrlEnum.getEnumByCode(type).getDesc();
        }else{
            return BroadcastResult.build(500, "上传参数错误");
        }
        try {
        	String fileUrl = file.getFileItem().getName();
            //String md5 = DigestUtils.md5Hex(new FileInputStream(fileUrl));
        	//String md5 = "image";
        	
             String path = folderPath + File.separator + UUID.randomUUID().toString() + suffix;
             //文件存储路径
             String loadUrl = request.getSession().getServletContext().getRealPath("/") + path; 
             //返回路径
             String url = uploadPrefixUrl + path;	
             FileUtils.copyInputStreamToFile(file.getInputStream(), new File(loadUrl));
             @SuppressWarnings("unused")
             UploadResult uploadFileToServer = uploadFileToServer(file);
             //return BroadcastResult.build(200, url,md5);
             return BroadcastResult.build(200, url, fileUrl);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return BroadcastResult.build(500, "上传失败");
        }
    }
}
