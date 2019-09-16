package cn.wtu.broadcast.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;

/**
 * 系统配置
 *
 * @author sueua
 * @since 2018-12-12
 */
@Component
public class SystemConfig implements InitializingBean {

    private static ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    private static SystemConfigurationService systemConfigurationService;

    @Autowired
    public SystemConfig(SystemConfigurationService systemConfigurationService) {
        SystemConfig.systemConfigurationService = systemConfigurationService;
    }

    /**
     * 设置值
     */
    public synchronized static void set(String configName, String configValue) {
        map.replace(configName, configValue);
    }

    /**
     * 获取值
     */
    public static String get(String configName) {
        return map.get(configName);
    }

    /**
     * 获取全部配置
     */
    public static Map<String, String> getMap() {
        return map;
    }

    /**
     * 刷新配置map
     */
    public synchronized static void reload() {
        map.clear();
        List<TSystemConfiguration> list = systemConfigurationService.selectList();
        list.forEach(tSystemConfiguration -> {
            String value = tSystemConfiguration.getfConfigurationValue();
            //ConcurrentHashMap value不能为空
            map.put(tSystemConfiguration.getfConfigurationName(), value == null ? "" : value);
            if(RedisDb.getJedis() != null){ // redis未初始化的时候，不处理redis，在StartupListener中处理
            	RedisDb.setString(tSystemConfiguration.getfConfigurationName(), value == null ? "" : value);
            }
        });
    }

    @Override
    public void afterPropertiesSet() {
        reload();
    }
}