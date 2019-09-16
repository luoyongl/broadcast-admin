package cn.wtu.broadcast.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.wtu.broadcast.openapi.api.DeviceService;
import cn.wtu.broadcast.openapi.model.BTeletextTerminal;
import cn.wtu.broadcast.parent.pojo.ZTree;

@Controller
public class DeviceDataController implements InitializingBean {

	private static Logger logger = LoggerFactory.getLogger(DeviceDataController.class);
	//private ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private List<ZTree> zTreeList = new ArrayList<>();

	private DeviceService deviceService;

	@Autowired
	public DeviceDataController(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@RequestMapping(value = "/deviceData/getUserZTreeList2Json")
	@ResponseBody
	public String getUserZTreeList2JsonAction() {
		try {
			ObjectMapper OBJECT_MAPPER = new ObjectMapper();
			String rs = OBJECT_MAPPER.writeValueAsString(getUserZTreeList());
			return rs;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "[]";
	}

	/**
	 * 树形结构list数据
	 */
	public List<ZTree> getZTreeList() {
		return zTreeList;
	}
	
	/**
	 * 加载数据
	 */
	public void reload() {
		zTreeList.clear();
		deviceService.selectAll().forEach(division -> {
			ZTree zTree = new ZTree();
			zTree.setName(division.getfTerminalName());
			zTreeList.add(zTree);
		});
	}

	/**
	 * 用户树形结构list数据
	 */
	public List<ZTree> getUserZTreeList() {

		List<BTeletextTerminal> list = deviceService.selectAll();
		System.out.println(list);
		try {
//			Subject subject = SecurityUtils.getSubject();
//			Session session = subject.getSession();
//			TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);			
			List<ZTree> userZTreeList = new ArrayList<>();
			// 加入顶级
			
			for(int i = 0; i<list.size(); i++) {
				ZTree ztree = new ZTree();
				ztree.setName(list.get(i).getfTerminalName());
				userZTreeList.add(ztree);
			}			
			
		/*	zTreeList.forEach(zTree -> {				
					userZTreeList.add(zTree);
			});*/
			return userZTreeList;
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			return Collections.emptyList();
		}
	}

	@Override
	public void afterPropertiesSet() {
		reload();
	}
}
