package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.TRole;
import cn.wtu.broadcast.openapi.vo.RoleVo;
import cn.wtu.broadcast.parent.service.api.ParentService;

import java.util.List;

/**
 * 角色service接口
 *
 * @author sueua
 * @since 2018-12-16
 */
public interface RoleService extends ParentService<TRole> {

    /**
     * 保存角色
     *
     * @param tRole          角色
     * @param resourceIdList 角色的权限id列表
     * @return 保存是否成功
     */
    boolean save(TRole tRole, List<Integer> resourceIdList);

    /**
     * 批量删除角色
     *
     * @param roleIdList 角色id列表
     * @return 删除的记录数
     */
    int deleteBatch(List<Integer> roleIdList);

    /**
     * 获取角色详情
     *
     * @param roleId 角色id
     * @return 包含权限信息的角色详情
     */
    RoleVo getRoleDetail(Integer roleId);

    /**
     * 查询所有角色
     *
     * @return 所有角色List
     */
    List<TRole> selectAll();
}
