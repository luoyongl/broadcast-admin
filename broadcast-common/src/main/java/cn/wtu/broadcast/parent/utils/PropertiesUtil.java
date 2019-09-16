package cn.wtu.broadcast.parent.utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:properties文件获取工具类
 * Created by hafiz.zhang on 2016/9/15.
 */
public class PropertiesUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
    private static Properties props;
    private static String[] proFileArr = new String[]{"config.properties"};
    static{
        loadProps();
    }

    synchronized static private void loadProps(){
        logger.info("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;
        for(String proFile:proFileArr){
            try {
                in = PropertiesUtil.class.getClassLoader().getResourceAsStream(proFile);
                //in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
                props.load(in);
            } catch (FileNotFoundException e) {
                logger.error("properties文件未找到");
            } catch (IOException e) {
                logger.error("出现IOException");
            } finally {
                try {
                    if(null != in) {
                        in.close();
                    }
                } catch (IOException e) {
                    logger.error("jdbc.properties文件流关闭出现异常");
                }
            }
        }
        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + props);
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
    
}