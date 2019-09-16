package cn.wtu.broadcast.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.wtu.broadcast.common.PropertyConstants;

/**
 * 相关文件工具
 * 
 * @author HJK
 */
public class EBFileUtil {
	private static Logger logger = LoggerFactory.getLogger(EBFileUtil.class);
	public static final String BACKUPS_URL = PropertyConstants.getPropertiesKey("backups_url");
	public static final String BACKUPS_REQUEST = PropertyConstants.getPropertiesKey("backups_request");
	public static final String BACKUPS_RESPONSE = PropertyConstants.getPropertiesKey("backups_response");

	/**
	 * 存储服务器上传过来的tar包（测试用）
	 * @param file 上传的文件
	 * @return 存储后tar包的路径,包含tar包的名称
	 */
	public static String saveProvincialTar(CommonsMultipartFile file) {
		String result = StringUtils.EMPTY;
		try {
			if (!file.isEmpty()) {
				String datePath = getDatePath();
				String path = getResposeBackpassUrl(datePath) + file.getOriginalFilename();
				File destFile = new File(path);
				try {
					// 复制临时文件到指定目录下,这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
					FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
				} catch (IOException e) {
					logger.error(e.getMessage() + e);
				}
				result = path;
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		
		return result;
	}
	
	/**
	 * 请求文件的存放路径，包括Tar包以及XML文件等等
	 * @param datePath 请求的时间，精确到毫秒
	 * @return
	 * @throws Exception
	 */
	public static String getRequestBackpassUrl(String datePath) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		StringBuffer tarBackpassUrl = new StringBuffer();
		tarBackpassUrl.append(BACKUPS_URL);
		tarBackpassUrl.append(File.separator);
		tarBackpassUrl.append(sdf.format(new Date()));
		tarBackpassUrl.append(File.separator);
		tarBackpassUrl.append(BACKUPS_REQUEST);
		tarBackpassUrl.append(File.separator);
		File file = new File(String.valueOf(tarBackpassUrl));
		if (!file.exists()) {
			file.mkdirs();
		}
		return String.valueOf(tarBackpassUrl);
	}

	/**
	 * 服务器回传文件的存放路径，包括Tar包以及XML文件等等
	 **/
	public static String getResposeBackpassUrl(String datePath) throws Exception {
		StringBuffer tarBackpassUrl = new StringBuffer();
		tarBackpassUrl.append(BACKUPS_URL);
		tarBackpassUrl.append(File.separator);
		tarBackpassUrl.append(datePath);
		tarBackpassUrl.append(File.separator);
		tarBackpassUrl.append(BACKUPS_RESPONSE);
		tarBackpassUrl.append(File.separator);
		File file = new File(String.valueOf(tarBackpassUrl));
		if (!file.exists()) {
			file.mkdirs();
		}
		return String.valueOf(tarBackpassUrl);
	}
	
	public static String getDatePath(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}
}
