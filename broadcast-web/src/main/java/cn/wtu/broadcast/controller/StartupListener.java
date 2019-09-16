package cn.wtu.broadcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import cn.wtu.broadcast.openapi.api.BServerRuntimeInfoService;
import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;

/**
 *    
    * @ClassName: StartupListener
    * @Description: 启动监听器
    * @author huangjiakui
    * @date 2018年12月04日
    *
 */
@Service
public class StartupListener implements ApplicationListener<ContextRefreshedEvent>  {
	
	@SuppressWarnings("unused")
	@Autowired
	private BServerRuntimeInfoService bServerRuntimeInfoService;
	
	@Autowired
	private SystemConfigurationService systemConfigurationService;
	
	/**
	 * 建立各种服务器是否正常在运行
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			// 配置文件加载到缓存中
			List<TSystemConfiguration> list = systemConfigurationService.selectList();
	        list.forEach(tSystemConfiguration -> {
	            String value = tSystemConfiguration.getfConfigurationValue();
	            RedisDb.setString(tSystemConfiguration.getfConfigurationName(), value == null ? "" : value);
	        });
			
			/*// 默认将所有服务器设置成离线，后续有心跳进来就设置成在线
			bServerRuntimeInfoService.updateBServerRuntimeInfoByType(null, 0);
			// 回传服务器的监听
			ReceiveServerMonitorThread receiveServerMonitorThread = new ReceiveServerMonitorThread(bServerRuntimeInfoService);
			new Thread(receiveServerMonitorThread).start();
			// 调控服务器的监听
			IPServerMonitorThread serverMonitorThread = new IPServerMonitorThread(bServerRuntimeInfoService);
			new Thread(serverMonitorThread).start();
			// 省级平台服务器监听
			ProvincialServerMonitorThread provincialServerMonitorThread = new ProvincialServerMonitorThread(bServerRuntimeInfoService);
			new Thread(provincialServerMonitorThread).start();*/
	    }
	}
	
}