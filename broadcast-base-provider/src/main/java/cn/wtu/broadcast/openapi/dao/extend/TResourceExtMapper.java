package cn.wtu.broadcast.openapi.dao.extend;

import cn.wtu.broadcast.openapi.model.TResource;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.pojo.ZTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TResourceExtMapper extends DBInterface<TUser> {

    /**
     * 查询用户资源
     *
     * @param userId 用户id
     * @return 资源列表
     */
    List<TResource> selectByUserId(@Param("userId") Integer userId);

    /**
     * 查询所有资源且已ztree simple模式显示数据
     *
     * @return 所有资源的ztree
     */
    List<ZTree> listAllResource2Ztree();

    /**
     * 查询某角色所有资源且已ztree simple模式显示数据
     *
     * @param roleId 角色id
     * @return 角色所有资源的ztree
     */
    List<ZTree> listAllResource2ZtreeByRoleId(@Param("roleId") Integer roleId);
}