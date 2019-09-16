package cn.wtu.broadcast.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.wtu.broadcast.openapi.api.ThirdBroadcastDataService;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.provice.EBITParamsVO;
import cn.wtu.broadcast.util.EBFileUtil;
import cn.wtu.broadcast.util.EBHttpURLConnectionUtil;
import cn.wtu.broadcast.util.EBTarUtil;

@Controller
@RequestMapping("provincial")
public class ProvincialResponseController {

	@Autowired
	ThirdBroadcastDataService thirdBroadcastDataService;
    @Value("${dispatch.server.tomcat.port}")
    private String dispatchServerTomcatPort;

	private static Logger logger = LoggerFactory.getLogger(ProvincialResponseController.class);

	/**
	 * 测试用： 模拟省级平台主动发送文件（为了切合模拟工具）
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sendProvincialTar", method = RequestMethod.POST)
	@ResponseBody
	public BroadcastResult sendProvincialTar(@RequestParam("upfile") CommonsMultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		// 服务器上传tar文件保存测试
		String path = EBFileUtil.saveProvincialTar(file);
		// 服务器上传tar文件解压测试
		List<String> compressFilePaths = EBTarUtil.unCompressTar(path);
		// 本地生成文件压缩测试
		EBTarUtil.compressTar(compressFilePaths, file.getOriginalFilename(), "C:/compressTest/");
		// 上传tar文件到省级平台测试（同时测试回传结果）
		String result = EBHttpURLConnectionUtil.sendTarToProvince(path);
		System.out.println(result);

		return BroadcastResult.ok();
	}

	/**
	 * 测试用： 模拟省级平台接受tar包同时回传tar包
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/provincialTest", method = RequestMethod.POST)
	@ResponseBody
	public BroadcastResult provincialTest(HttpServletRequest request, HttpServletResponse response) {
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			List<MultipartFile> files = multipartRequest.getFiles("upfile");
			System.out.println(files);
		}

		// 使用Apache文件上传组件处理文件上传步骤
		try {
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				System.out.println("没有文件上传");
			}
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			System.out.println(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return BroadcastResult.ok();
	}

	/**
	 * 测试工具模拟省级平台主动推送文件测试
	 * 
	 * @param request
	 *            注意测试工具里面上传文件的key为"upfile"
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/getProvincialTar", method = RequestMethod.POST)
	@ResponseBody
	public BroadcastResult getProvincialTar(@RequestParam("upfile") CommonsMultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			EBITParamsVO paramsVO = new EBITParamsVO();
			// 多种模式获取文件方式。目前采用CommonsMultipartFile
			if (request instanceof MultipartHttpServletRequest) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				List<MultipartFile> files = multipartRequest.getFiles("upfile");
				if (files != null && files.size() > 0) {
					System.out.println(files);
				}
			}
			// 服务器上传tar文件保存同时返回保存的地址
			String path = EBFileUtil.saveProvincialTar(file);
			String filename = file.getOriginalFilename();
			String preUrl = path.replace(filename, "");
			// 服务器上传tar文件解压测试
			List<String> compressFilePaths = EBTarUtil.unCompressTar(path);
			if (compressFilePaths != null && compressFilePaths.size() > 0) {
				
			}
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}

		return BroadcastResult.ok();
	}
}
