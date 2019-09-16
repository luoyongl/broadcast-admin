package cn.wtu.broadcast.controller.resourceManage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.dao.BUpdateFileMapper;
import cn.wtu.broadcast.openapi.model.BUpdateFile;
import cn.wtu.broadcast.openapi.model.BUpdateFileExample;
import cn.wtu.broadcast.parent.utils.json.JSONObject;

@Controller
@RequestMapping("v1")
public class DeviceUpdateApi {
	@Autowired
	private BUpdateFileMapper updateFileMapper;
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeviceUpdateApi.class);

	@ResponseBody
	@RequestMapping("/upgradefile")
	public void getCertificateList(@RequestParam(required = false) Integer terminaltype,
			@RequestParam(required = false) String logicaladdr, @RequestParam(required = false) Integer vendercode,
			@RequestParam(required = false) String hwversion, @RequestParam(required = false) String swversion,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		logger.info("终端设备物理地址" + logicaladdr);
		logger.info("终端类型" + terminaltype);
		logger.info("厂家编号" + vendercode);
		logger.info("硬件版本号" + hwversion);
		logger.info("软件版本号" + swversion);
		JSONObject jsonObject = new JSONObject();
		try {
			String tomcatPath = System.getProperty("catalina.home");
			BUpdateFileExample updateFileExample = new BUpdateFileExample();
			updateFileExample.createCriteria().andFDeleteFlagEqualTo(false);
			List<BUpdateFile> updateFileList = updateFileMapper.selectByExample(updateFileExample);
			for (BUpdateFile bUpdateFile : updateFileList) {
				if (bUpdateFile != null) {
					int currentVersion = Integer.parseInt(swversion); // 设备当前软件版本号
					int version = 0;
					if (bUpdateFile.getfSoftwareVersion() != null) {
						version = Integer.parseInt(bUpdateFile.getfSoftwareVersion());
					}
					if (12 == (terminaltype)) {
						if ((version - currentVersion) >= 0) {
							//获取项目根目录
							//String prefixPath = request.getSession().getServletContext().getRealPath("/");
							//http://10.177.3.143:8080/upload/other/eee2edcb-ebcb-4fb4-b8d4-6087bf143386.mp3
							String fileAddress = bUpdateFile.getfFileAddress();
							//后缀
							String fileName = fileAddress.substring(fileAddress.lastIndexOf("/")+1);
							String fileUrl = tomcatPath + "/webapps/ROOT/upload/other/" +fileName;
							String md5 = DigestUtils.md5Hex(new FileInputStream(fileUrl));
							String token = UUID.randomUUID().toString().substring(0, 16);
							jsonObject.put("url", "http://127.0.0.1:8080/v1/upgradefile/" + bUpdateFile.getfFileName());
							jsonObject.put("token", token);
							jsonObject.put("version", bUpdateFile.getfSoftwareVersion());
							jsonObject.put("md5", md5);
						}
					}
				}

			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		String head = "HTTP/1.1 200 OK" + "\r\n";
		logger.info("result" + jsonObject.toString());
		response.setStatus(200);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(head + jsonObject.toString());
		pw.flush();
	}

	@GetMapping(value = "/upgradefile/{fileName}.{fileType}")
	@ResponseBody
	public FileInputStream process(@PathVariable("fileName") String fileName, 
			@PathVariable("fileType") String fileType,
			@RequestParam(required = true) String token,
			HttpServletResponse response,HttpServletRequest request) throws FileNotFoundException {
		BUpdateFileExample updateFileExample = new BUpdateFileExample();
		updateFileExample.createCriteria().andFDeleteFlagEqualTo(false);
		List<BUpdateFile> updateFileList = updateFileMapper.selectByExample(updateFileExample);
		String name = fileName + "." + fileType;
		for (BUpdateFile bUpdateFile : updateFileList) {
			if(bUpdateFile.getfFileName().equals(name)){
				String path = System.getProperty("catalina.home");
				
				System.out.println(path);
				System.out.println(bUpdateFile.getfFileAddress());
				
				//获取项目根目录
				String prefixPath = request.getSession().getServletContext().getRealPath("/");
				
				//http://10.177.3.143:8080/upload/other/eee2edcb-ebcb-4fb4-b8d4-6087bf143386.mp3
				String fileAddress = bUpdateFile.getfFileAddress();
				//后缀
				String suffixPath = fileAddress.substring(fileAddress.lastIndexOf("/")+1);
				String path2 = prefixPath + suffixPath;
				
				//转为二进制文件并返回
				FileInputStream fis = new FileInputStream(path2);
			/*	FileOutputStream fos = new FileOutputStream("c:/test.ts");
				
				byte[] bys = new byte[1024];
				int len;
				try {
					while((len =fis.read(bys)) != -1){
						fos.write(bys, 0, len);
					}
				} catch (IOException e) {
				}*/
				return fis;
			}
		}
		response.setStatus(200);
		System.out.println(fileName + token);
		return null;
	}

}
