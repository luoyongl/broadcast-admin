package cn.wtu.broadcast.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.wtu.broadcast.openapi.api.DeviceService;
import cn.wtu.broadcast.openapi.model.BTeletextTerminal;
import cn.wtu.broadcast.parent.pojo.ZTree;

@Component
public class DeviceData implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(DeviceData.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static List<ZTree> zTreeList = new ArrayList<>();

	private static DeviceService deviceService;

	@Autowired
	public DeviceData(DeviceService deviceService) {
		DeviceData.deviceService = deviceService;
	}

	/**
	 * 区域id对应区域名称Map
	 */
	public static Map<Integer, String> getNameMap() {
		return zTreeList.stream().collect(Collectors.toMap(ZTree::getId, ZTree::getName));
	}

	/**
	 * 区域id对应区域名称Map的JSON格式(一般直接在前端中使用)
	 */
	public static String getNameMapJson() {
		try {
			return OBJECT_MAPPER.writeValueAsString(getNameMap());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "[]";
	}

	/**
	 * 树形结构list数据
	 */
	public static List<ZTree> getZTreeList() {
		return zTreeList;
	}

	/**
	 * 树形结构list数据的json(一般直接在前端中使用)
	 */
	public static String getZTreeListJson() {
		try {
			return OBJECT_MAPPER.writeValueAsString(zTreeList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "[]";
	}

	/**
	 * 树形结构list数据的json(一般直接在前端中使用) 根據用戶查詢區域樹
	 */
	public static String getUserZTreeList2Json() {
		try {
			return OBJECT_MAPPER.writeValueAsString(getUserZTreeList());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "[]";
	}

	/**
	 * 加载数据
	 */
	public synchronized static void reload() {
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
	/**
	 * 用户树形结构list数据
	 */
	public static List<ZTree> getUserZTreeList() {

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
