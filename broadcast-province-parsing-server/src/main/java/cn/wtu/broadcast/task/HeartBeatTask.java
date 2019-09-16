package cn.wtu.broadcast.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author HJB
 */
@Component 
public class HeartBeatTask {

	private static Logger log = LoggerFactory.getLogger(HeartBeatTask.class);

	public void heartBeatTaskThread(){	
		try {
			new Thread(new Runnable() {
				public void run() {
					// TODO
				}
			}).start();
		} catch (Exception e) {
			log.error(e.getMessage() + e);
		}
	}
}
