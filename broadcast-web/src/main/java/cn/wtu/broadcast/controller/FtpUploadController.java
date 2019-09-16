package cn.wtu.broadcast.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.UploadResult;

@Controller
@RequestMapping("ftp")
public class FtpUploadController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(AudioManageController.class);

	@RequestMapping(value = "/ftpUpload", method = RequestMethod.POST)
	@ResponseBody
	public BroadcastResult ftpUpload(@RequestParam("files") CommonsMultipartFile file) {
		if (file.isEmpty()) {
			return BroadcastResult.fail("文件为空不能上传");
		}
		try {
			UploadResult uploadFileToServer = uploadFileToServer(file);
			return BroadcastResult.ok(uploadFileToServer);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.fail("上传失败，系统异常");
		}
	}
}
