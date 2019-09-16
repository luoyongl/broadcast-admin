package cn.wtu.broadcast.openapi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;
import cn.wtu.broadcast.parent.vo.AudioVO;

public class VlcCommend {

	private static Logger logger = LoggerFactory.getLogger(VlcCommend.class);

	public static void play(Integer fId, String ip, String port, BBroadcastDataExtMapper broadcastDataExtMapper)
			throws IOException, InterruptedException {
		String broadcastTomcatPath = RedisDb.getString("broadcastTomcatPath");
		// 查询音频路径
		AudioVO audioVO = broadcastDataExtMapper.queryIpAudio(fId);
		String audioName = "";
		if (audioVO.getTextToAudioUrl() != null) {
			audioName = audioVO.getTextToAudioUrl().substring(audioVO.getTextToAudioUrl().lastIndexOf("/") + 1);
		} else {
			audioName = audioVO.getBroadcastAudioUrl().substring(audioVO.getBroadcastAudioUrl().lastIndexOf("/") + 1);
		}
		String audioUrl = broadcastTomcatPath + "/webapps/ROOT/upload/audio/" + audioName;
		String command2 = "";
		if (ip != null) {
			command2 = "/usr/bin/cvlc " + audioUrl + " -vv -I dummy --sout='#rtp{dst=" + ip + ",port=" + port
					+ "}' --play-and-exit";
		} else {
			command2 = "/usr/bin/cvlc " + audioUrl + " -vv -I dummy --sout='#rtp{dst=,port=" + port
					+ "}' --play-and-exit";
		}

		String[] cmd = new String[] { "sh", "-c", command2 };
		System.out.println(command2);
		Process process = Runtime.getRuntime().exec(cmd);
		List<Process> processList = Constant.tsAudioProcessMap.get("IP" + fId);
		if (processList == null) {
			processList = new ArrayList<Process>();
		}
		processList.add(process);
		Constant.tsAudioProcessMap.put("IP" + fId, processList);
		dealStream(process);
		process.waitFor(); // 加上这句，系统会等待转换完成。不加，就会在服务器后台自行转换。
		logger.info("广播{}的音频PID{}正常播放完成", fId, audioUrl);
		// usr/bin/cvlc /usr/local/22.mp3 -vv -I dummy --sout="#rtp{dst=10.177.3.238,port=5500}" --play-and-exit
	}
	
	public static void playTestWindows(Integer fId, String ip, String port, BBroadcastDataExtMapper broadcastDataExtMapper)
			throws IOException, InterruptedException {
		String broadcastTomcatPath = RedisDb.getString("broadcastTomcatPath");
		// 查询音频路径
		AudioVO audioVO = broadcastDataExtMapper.queryIpAudio(fId);
		String audioName = "";
		if (audioVO.getTextToAudioUrl() != null) {
			audioName = audioVO.getTextToAudioUrl().substring(audioVO.getTextToAudioUrl().lastIndexOf("/") + 1);
		} else {
			audioName = audioVO.getBroadcastAudioUrl().substring(audioVO.getBroadcastAudioUrl().lastIndexOf("/") + 1);
		}
		String audioUrl = broadcastTomcatPath + "/webapps/ROOT/upload/audio/" + audioName;
		String command2 = "";
		if (ip != null) {
			command2 = "D:\\VLC\\vlc.exe " + audioUrl + " -vv -I dummy --sout=#rtp{dst=" + ip + ",port=" + port
					+ "} --play-and-exit";
			} else {
			command2 = "D:\\VLC\\vlc.exe " + audioUrl + " -vv -I dummy --sout=#rtp{dst=,port=" + port
					+ "} --play-and-exit";
		}

		//String[] cmd = new String[] { "sh", "-c", command2 };
		System.out.println(command2);
		Process process = Runtime.getRuntime().exec(command2);
		List<Process> processList = Constant.tsAudioProcessMap.get("IP" + fId);
		if (processList == null) {
			processList = new ArrayList<Process>();
		}
		processList.add(process);
		Constant.tsAudioProcessMap.put("IP" + fId, processList);
		dealStream(process);
		process.waitFor(); // 加上这句，系统会等待转换完成。不加，就会在服务器后台自行转换。
		logger.info("广播{}的音频PID{}正常播放完成", fId, audioUrl);
		// usr/bin/cvlc /usr/local/22.mp3 -vv -I dummy
		// --sout="#rtp{dst=10.177.3.238,port=5500}" --play-and-exit
	}

	/**
	 * 处理process输出流和错误流，防止进程阻塞 在process.waitFor();前调用
	 * 
	 * @param process
	 */
	private static void dealStream(Process process) {
		if (process == null) {
			return;
		}
		// 处理InputStream的线程
		new Thread() {
			@Override
			public void run() {
				BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = null;
				try {
					while ((line = in.readLine()) != null) {
						logger.info("output: " + line);
					}
				} catch (IOException e) {
					logger.error(e.getMessage() + e);
				} finally {
					try {
						in.close();
					} catch (IOException e) {
						logger.error(e.getMessage() + e);
					}
				}
			}
		}.start();
		// 处理ErrorStream的线程
		new Thread() {
			@Override
			public void run() {
				BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String line = null;
				try {
					while ((line = err.readLine()) != null) {
						logger.info("err: " + line);
					}
				} catch (IOException e) {
					logger.error(e.getMessage() + e);
				} finally {
					try {
						err.close();
					} catch (IOException e) {
						logger.error(e.getMessage() + e);
					}
				}
			}
		}.start();
	}
}
