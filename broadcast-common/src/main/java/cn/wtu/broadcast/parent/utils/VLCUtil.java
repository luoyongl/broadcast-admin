package cn.wtu.broadcast.parent.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于执行linux命令 实现vlc音频转码功能 sourceUrl表示音频来源 采用UDP方式组播出去 
 * 
 * @author lxg
 * @since 2019-01-25 前提:linux环境安装有vlc的环境并配置有系统环境 才能调用vlc命令
 */
public class VLCUtil {
	private static Logger logger = LoggerFactory.getLogger(VLCUtil.class);

	public static void Mp32TS(String sourceUrl) throws IOException {
		try {
/*			 音频pid为 6211 测试 范围在[]

			vlc E:\test.mp3 --sout=#udp{mux=ts{pid-audio=1500},dst=224.101.102.103:8888} --sout-all --sout-keep   成功了
            cvlc 无界面状态
*/			
			String command1 = "vlc " + sourceUrl + " --sout=#udp{mux=ts{pid-audio=1500},dst=224.101.102.103:8888} --sout-all --sout-keep";
			Process process = Runtime.getRuntime().exec(command1);
			process.waitFor(); // 加上这句，系统会等待转换完成。不加，就会在服务器后台自行转换。
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}

	}
}
