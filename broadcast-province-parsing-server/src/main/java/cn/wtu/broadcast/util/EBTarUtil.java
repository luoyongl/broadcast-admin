package cn.wtu.broadcast.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EBTarUtil {

	private static Logger logger = LoggerFactory.getLogger(EBTarUtil.class);
	
	public static void main(String[] args) {
		List<String> compressFilePaths = new ArrayList<String>();
		compressFilePaths.add("C:/EbBackups/20190113171618812/EBResponse/" + "EBDB_10245000000000001010101011000000000000017.xml");
		compressFilePaths.add("C:/EbBackups/20190113171618812/EBResponse/" + "EBDR_D6AB01C1DCBBE351587A08B4F4D3E2F2.mp3");
		compressFilePaths.add("C:/EbBackups/20190113171618812/EBResponse/" + "EBDS_EBDB_10245000000000001010101011000000000000017.xml");
		String tarName = "EBDB_10245000000000001010101011000000000000017.tar";
		String destFolderPath = null;
		compressTar(compressFilePaths, tarName, destFolderPath);
	}

	/**
	 * 压缩tar包
	 * @param compressFilePaths 待压缩的文件路径(带文件名的全路径)集合
	 * @param tarName 压缩的tar包的名称
	 * @param destFilePath 可为空，压缩的tar包的存放路径（ 以"/"结尾），如果为NULL时候，压缩到第一个文件存放的父目录中
	 * @throws Exception
	 */
	public static void compressTar(List<String> compressFilePaths, String tarName, String destFolderPath) {
		try {
			if (compressFilePaths != null && compressFilePaths.size() > 0) {
				if(StringUtil.isBlank(destFolderPath)){
					File firstFile = new File(compressFilePaths.get(0));
					destFolderPath = firstFile.getParent();
				}				
				File tarFolder = new File(destFolderPath);		
				if (!tarFolder.exists()) {
					tarFolder.mkdirs();
				}				
				File tarfile = new File(destFolderPath, tarName);				
				TarArchiveOutputStream taos = new TarArchiveOutputStream(new FileOutputStream(tarfile));
				for (String compressFile : compressFilePaths) {
					File file = new File(compressFile);
					TarArchiveEntry tae = new TarArchiveEntry(file);
					tae.setSize(file.length());
					tae.setName(file.getName());
					taos.putArchiveEntry(tae);
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
					int count;
					byte data[] = new byte[1024];
					while ((count = bis.read(data, 0, 1024)) != -1) {
						taos.write(data, 0, count);
					}
					bis.close();
					taos.closeArchiveEntry();
				}
				taos.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}

	/**
	 * 解压tar包(直接解压到当前目录)
	 * @param path 带tar包名称的全路径
	 * @throws IOException
	 */
	public static List<String> unCompressTar(String path) {
		List<String> compressFilePaths = new ArrayList<String>();
		try {
			File file = new File(path);
			String parentPath = file.getParent();
			TarArchiveInputStream tais = new TarArchiveInputStream(new FileInputStream(file));
			TarArchiveEntry tarArchiveEntry = null;
			while ((tarArchiveEntry = tais.getNextTarEntry()) != null) {
				String name = tarArchiveEntry.getName();
				File tarFile = new File(parentPath, name);
				if (!tarFile.getParentFile().exists()) {
					tarFile.getParentFile().mkdirs();
				}
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tarFile));
				int read = -1;
				byte[] buffer = new byte[1024];
				while ((read = tais.read(buffer)) != -1) {
					bos.write(buffer, 0, read);
				}
				bos.close();
				compressFilePaths.add(tarFile.getPath());
			}
			tais.close();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}	
		
		return compressFilePaths;
	}

}