package cn.wtu.broadcast.openapi.api;

import java.util.List;

import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * Created on 03/03/2019 18:40
 *
 * @author lxg
 */
public interface TAdministrativeDivisionService extends ParentService<TAdministrativeDivision> {

	/**
	 * 用于去掉 区域树中,不必要的id
	 * 
	 * @param String resourceId
	 * @return String
	 * @author lxg
	 * @since 2019/03/07 规则:有了上级结点,就不需要 相对应的 下级结点 前提:1.区域树中 父级结点和子结点 不能同时选中 2.保证
	 *        0612+镇区域编码+00 全镇的 设备可以响
	 */
	 String simplifyRegionIds(String resourceId);

	List<Integer> getDeviceByrResourceIds(String resourceId);
	
	/**
	 * 根据简化了的区域ids查询出原来选中的所有区域id  
	 * 2019-04-07 
	 * lxg
	 */
	public String getAssociationByResourceIds(String rsourceIds);
	
	/**
	 * 获取区域表的f_id,赋值给省平台的播发区域
	 * 2019-04-11 lxg
	 * @return
	 */
	public Integer getRootNode();
}
