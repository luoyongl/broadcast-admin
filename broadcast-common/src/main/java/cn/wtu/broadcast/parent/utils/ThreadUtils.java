package cn.wtu.broadcast.parent.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadUtils {

    private static Logger logger = LoggerFactory.getLogger(ThreadUtils.class);
    
    public static  void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
