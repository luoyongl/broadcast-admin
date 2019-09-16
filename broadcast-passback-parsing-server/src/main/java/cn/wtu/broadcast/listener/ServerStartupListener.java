package cn.wtu.broadcast.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;

import cn.wtu.broadcast.thread.PassbackServer;

/**
 * 
    * @ClassName: StartupListener
    * @Description: 启动监听器
    * @author Lenovo
    * @date 2019年07月12日
    *
 */
@Controller
public class ServerStartupListener implements ApplicationListener<ContextRefreshedEvent>  {
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			PassbackServer passbackServer = new PassbackServer(8889);
			new Thread(passbackServer).start();
	    }
	}	
}