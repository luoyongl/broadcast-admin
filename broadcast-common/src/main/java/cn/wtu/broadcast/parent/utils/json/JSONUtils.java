package cn.wtu.broadcast.parent.utils.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JSONUtils {

    private static Logger logger = LoggerFactory.getLogger(JSONUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JSONUtils() {
    }

    /**
     * object转json字符串
     */
    public static String toString(Object pojo) {
        return toString(pojo, false);
    }

    /**
     * object转json字符串
     */
    public static String toString(Object pojo,boolean ignoreNull) {
        String json = null;
        try {
            if(ignoreNull){
                json = mapper.writeValueAsString(pojo);
            }else{
                json = objectMapper.writeValueAsString(pojo);
            }

        } catch (JsonProcessingException e) {
            logger.info(e.getMessage());
        }
        return json;
    }



    /**
     * json字符串转对象
     */
    public static <T> T getPOJO(String json, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return t;
    }

    /**
     * objectMapper可全局使用
     */
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}	
