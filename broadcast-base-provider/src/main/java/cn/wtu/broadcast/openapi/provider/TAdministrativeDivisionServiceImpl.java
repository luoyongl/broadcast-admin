package cn.wtu.broadcast.openapi.provider;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wtu.broadcast.openapi.api.TAdministrativeDivisionService;
import cn.wtu.broadcast.openapi.dao.TAdministrativeDivisionMapper;
import cn.wtu.broadcast.openapi.dao.extend.BDeviceInfoExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.TAlarmPrincipalExtMapper;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.parent.db.api.DBInterface;

/**
 * Created on 03/03/2019 20:12
 *
 * @author LY
 */
@Service
public class TAdministrativeDivisionServiceImpl extends ParentServiceImpl<TAdministrativeDivision>
		implements TAdministrativeDivisionService {

	private final TAdministrativeDivisionMapper tAdministrativeDivisionMapper;

	private final TAlarmPrincipalExtMapper tAlarmPrincipalExtMapper;

	private final BDeviceInfoExtMapper deviceInfoExtMapper;

	@Autowired
	public TAdministrativeDivisionServiceImpl(TAdministrativeDivisionMapper tAdministrativeDivisionMapper,
			TAlarmPrincipalExtMapper tAlarmPrincipalExtMapper, BDeviceInfoExtMapper deviceInfoExtMapper) {
		this.tAdministrativeDivisionMapper = tAdministrativeDivisionMapper;
		this.tAlarmPrincipalExtMapper = tAlarmPrincipalExtMapper;
		this.deviceInfoExtMapper = deviceInfoExtMapper;
	}

	@Override
	protected DBInterface<TAdministrativeDivision> getDao() {
		return tAdministrativeDivisionMapper;
	}

	/**
	 * 用于去掉 区域树中,不必要的id
	 * 
	 * @param String
	 *            resourceId
	 * @return String
	 * @author lxg
	 * @since 2019/03/07 规则:有了上级结点,就不需要 相对应的 下级结点 前提:1.区域树中 父级结点和子结点 不能同时选中 2.保证
	 *        0612+镇区域编码+00 全镇的 设备可以响
	 */
	@Transactional(rollbackFor = Exception.class)
	public String simplifyRegionIds(String resourceId) {
		String[] strings = resourceId.split(",");
		// 1.resourceId中只包含一个String,即只选中了一个 三级结点(村)
		if (strings.length == 1) {
			return resourceId;
		} else {
			// 2.数组strings转list,再转为可以操作元素(remove)的list
			List<String> resourceList = new ArrayList<String>(Arrays.asList(strings));
			// 3.查询出根节点
			Integer rootNode = tAlarmPrincipalExtMapper.getRootNode();

			// 4.rootNode.toString()在 resourceList中,选中了全县
			if (resourceList.contains(rootNode.toString())) {
				return rootNode.toString();
			} else {
				// 5.根据根节点 rootNode查询二级节点
				List<String> secondNodes = tAlarmPrincipalExtMapper.getNodes(rootNode);

				// 6.取两个的交集 resourceList secondNodes
				List<String> intersectionList = resourceList.stream().filter(item -> secondNodes.contains(item))
						.collect(toList());
				// 7.没有 二级结点 意思是说 resourceList中既无根结点也无二级结点,就直接返回
				if (intersectionList.size() < 0) {
					return resourceId;
				} else {
					// 8.遍历每个在resourceList的二级节点,并删除其下的所有三级节点
					for (String secondNode : intersectionList) {
						// 9.根据二级节点secondNode查询出三级节点
						List<String> thirdNodes = tAlarmPrincipalExtMapper.getNodes(Integer.parseInt(secondNode));
						// 10.resourceList删除thirdNodes
						resourceList.removeAll(thirdNodes);
					}
					// 11.返回结果
					//return ListToStringUtil.ListToString(resourceList);
					return String.join(",", resourceList);
				}
			}
		}
	}

	/*
	 * 根据区域ids查询出相关联的适配器和音柱(可以响的 01)
	 * 2019-04-07 
	 * lxg
	 */
	public List<Integer> getDeviceByrResourceIds(String resourceId) {

		List<String> regionIdlist = Arrays.asList(resourceId.split(","));

		return deviceInfoExtMapper.getDeviceByResourceId(regionIdlist);
	}
	
	/**
	 * 根据简化了的区域ids查询出原来选中的所有区域id  
	 * 2019-04-07 
	 * lxg
	 */
	public String getAssociationByResourceIds(String resourceIds){
		String[] strings = resourceIds.split(",");
		//数组strings转list,再转为可以操作元素(remove)的list
		List<String> resourceList = new ArrayList<String>(Arrays.asList(strings));
		
		//查询出根节点,如果rsourceIds包含，就查出所有的结点
		Integer rootNode = tAlarmPrincipalExtMapper.getRootNode();
		if (resourceList.contains(rootNode.toString())) {
			List<String> nodes = tAlarmPrincipalExtMapper.getAllNodes();
			return String.join(",", nodes);
		}else{
			//如果存在二级结点,根据二级结点查询出其下的根节点，并加入到rsourceIds
			//根据根节点 rootNode查询二级节点
			List<String> secondNodes = tAlarmPrincipalExtMapper.getNodes(rootNode);

			//取两个的交集 resourceList secondNodes
			List<String> intersectionList = resourceList.stream().filter(item -> secondNodes.contains(item))
					.collect(toList());
			if (intersectionList.size() < 0) {
				// 7.没有 二级结点 意思是说 resourceList中既无根结点也无二级结点,就直接返回三级节点
				return resourceIds;
			} else {
				// 8.遍历每个在resourceList的二级节点
				for (String secondNode : intersectionList) {
					// 9.根据二级节点secondNode查询出三级节点
					List<String> thirdNodes = tAlarmPrincipalExtMapper.getNodes(Integer.parseInt(secondNode));
					// 10.加入resourceList
					resourceList.addAll(thirdNodes);
				}
				return String.join(",", resourceList);
			}
		}
	}
	
	/**
	 * 获取区域表的f_id,赋值给省平台的播发区域
	 * 2019-04-11 lxg
	 * @return
	 */
	public Integer getRootNode(){
		return tAlarmPrincipalExtMapper.getRootNode();
	}

}
