package cn.wtu.broadcast.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.util.TextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;

import cn.jpush.api.report.UsersResult.User;
import cn.wtu.broadcast.common.Principal;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.FtpUploadUrlEnum;
import cn.wtu.broadcast.parent.utils.PropertiesUtil;
import cn.wtu.broadcast.parent.utils.ftp.FtpUtil;
import cn.wtu.broadcast.parent.vo.UploadResult;

/**
 * 
 * @ClassName: BaseController
 * @Description: 基础类
 * @author huangjiakui
 * @date 2018年12月04日
 *
 */
@SuppressWarnings("deprecation")
public class BaseController extends MultiActionController {
	private static Logger logger = LoggerFactory.getLogger(BaseController.class);
	protected Gson gson = new Gson();

	public void writeByMapString(HttpServletResponse response, Map<Object, Object> map) {
		try {
			response.setCharacterEncoding("text/html;UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			ServletOutputStream sos = response.getOutputStream();
			List<SerializerFeature> list = new ArrayList<SerializerFeature>();
			list.add(SerializerFeature.WriteMapNullValue);
			list.add(SerializerFeature.WriteNullStringAsEmpty);
			list.add(SerializerFeature.WriteDateUseDateFormat);
			list.add(SerializerFeature.DisableCircularReferenceDetect);
			list.add(SerializerFeature.WriteMapNullValue);
			list.add(SerializerFeature.WriteNullNumberAsZero);
			list.add(SerializerFeature.PrettyFormat);
			SerializerFeature[] toBeStored = list.toArray(new SerializerFeature[list.size()]);
			String outVal = JSONObject.toJSONString(map, toBeStored);
			sos.write(outVal.getBytes("UTF-8"));
			sos.flush();
			sos.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@ModelAttribute("ctx")
	public String basePath(HttpServletRequest req) {
		String protocolv = req.getProtocol();
		String protocol = protocolv.split("/")[0];
		protocol = protocol.toLowerCase();
		String proj = req.getContextPath();
		String server = req.getServerName();
		int port = req.getServerPort();
		String base = protocol + "://" + server + ":" + port + proj;
		return base;
	}

	@ModelAttribute("imgServer")
	public String imgServer(HttpServletRequest req) {
		return PropertiesUtil.getProperty("hostUrl.img");
	}

	@ModelAttribute("fileServer")
	public String fileServer(HttpServletRequest req) {
		return PropertiesUtil.getProperty("hostUrl.file");
	}

	@ModelAttribute("audioServer")
	public String audioServer(HttpServletRequest req) {
		return PropertiesUtil.getProperty("hostUrl.audio");
	}

	/**
	 * 获取当前登录管理员
	 * 
	 * @return 当前登录管理员，若不存在则返回null
	 */
	public User getCurrentUser() {
		return (User) SecurityUtils.getSubject().getSession().getAttribute(Constant.CURRENT_USER);
	}

	/**
	 * 设置当前登录管理员
	 * 
	 * @return
	 */
	public void setCurrentUser(User user) {
		SecurityUtils.getSubject().getSession().setAttribute(Constant.CURRENT_USER, user);
	}

	/**
	 * 获取当前登录用户名
	 * 
	 * @return 当前登录用户名，若不存在则返回null
	 */
	public String getCurrentUserName() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			Principal principal = (Principal) subject.getPrincipal();
			if (principal != null) {
				return principal.getUsername();
			}
		}
		return null;
	}

	/**
	 * 清空相关session
	 */
	public void removeUserLoginInfo() {
		SecurityUtils.getSubject().getSession().removeAttribute(Constant.CURRENT_USER);
		SecurityUtils.getSubject().getSession().removeAttribute(Constant.CURRENT_COMPANY);
		SecurityUtils.getSubject().getSession().removeAttribute(Constant.CURRENT_USER_PERMISSION);
	}

	/**
	 * 是否通过认证
	 * 
	 * @return
	 */
	public boolean isAuthenticated() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			return subject.isAuthenticated();
		}
		return false;
	}

	/**
	 * 上传文件至文件服务器
	 * @throws Exception 
	 */
	protected UploadResult uploadFileToServer(MultipartFile file) throws IOException {
		UploadResult uploadResult = new UploadResult();
		if (file != null) {
			String originalFilename = file.getOriginalFilename();
			originalFilename = uTF8Decode(originalFilename);
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
			//String filePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + File.separator + FtpUploadUrlEnum.getEnumByFileName(originalFilename);
			String filePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + "/" + FtpUploadUrlEnum.getEnumByFileName(originalFilename);
			String fileName = UUID.randomUUID().toString() + ext;
			if (!FtpUtil.uploadFile(filePath, fileName, file.getInputStream())) {
				throw new IOException();
			}
			uploadResult.setStatus(true);
			uploadResult.setName(fileName);
			uploadResult.setOriginalName(originalFilename);
			uploadResult.setType(ext);
			uploadResult.setSize(file.getSize());
			uploadResult.setUrl(filePath + File.separator + fileName);
			uploadResult.setState("SUCCESS");
		} else {
			uploadResult.setStatus(false);
		}
		return uploadResult;
	}

	/**
	 * utf8解码
	 *
	 * @param contents
	 * @return
	 */
	private static String uTF8Decode(String contents) {
		if (!TextUtils.isEmpty(contents)) {
			String content2 = null;
			try {
				content2 = URLDecoder.decode(contents, "utf-8");
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage(), e);
			}
			String content = content2;
			return content;
		}
		return contents;
	}
}
