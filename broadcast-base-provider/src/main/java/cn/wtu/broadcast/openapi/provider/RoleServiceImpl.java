package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.RoleService;
import cn.wtu.broadcast.openapi.dao.TRoleAndResourceLinkMapper;
import cn.wtu.broadcast.openapi.dao.TRoleMapper;
import cn.wtu.broadcast.openapi.dao.extend.TResourceExtMapper;
import cn.wtu.broadcast.openapi.model.TRole;
import cn.wtu.broadcast.openapi.model.TRoleAndResourceLink;
import cn.wtu.broadcast.openapi.model.TRoleAndResourceLinkExample;
import cn.wtu.broadcast.openapi.model.TRoleExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.RoleVo;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

/**
 * @author sueua
 * @since 2018-12-16
 */
@Service("roleService")
public class RoleServiceImpl extends ParentServiceImpl<TRole> implements RoleService {

    private final TRoleMapper tRoleMapper;

    private final TRoleAndResourceLinkMapper tRoleAndResourceLinkMapper;

    private final TResourceExtMapper tResourceExtMapper;

    @Autowired
    public RoleServiceImpl(TRoleMapper tRoleMapper, TRoleAndResourceLinkMapper tRoleAndResourceLinkMapper, TResourceExtMapper tResourceExtMapper) {
        this.tRoleMapper = tRoleMapper;
        this.tRoleAndResourceLinkMapper = tRoleAndResourceLinkMapper;
        this.tResourceExtMapper = tResourceExtMapper;
    }

    /**
     * 获取数据操作实例,不能为空,子类必须实现该方法
     */
    @Override
    protected DBInterface<TRole> getDao() {
        return tRoleMapper;
    }

    /**
     * 保存角色
     *
     * @param tRole          角色
     * @param resourceIdList 角色的权限id列表
     * @return 保存是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(TRole tRole, List<Integer> resourceIdList) {
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        if (tRole.getfId() != null) {
            tRole.setfOperatorId(sessionUser.getfId());
            tRole.setfUpdateTime(time);
            tRoleMapper.updateByPrimaryKeySelective(tRole);
            insertLog(OperationLogTypeEnum.UPDATE, "修改角色", "成功");
        } else {
            tRole.setfCreatorId(sessionUser.getfId());
            tRole.setfCreateTime(time);
            tRole.setfDeleteFlag(false);
            tRoleMapper.insert(tRole);
            insertLog(OperationLogTypeEnum.UPDATE, "添加角色", "成功");
        }
        //先清空后保存
        clearPermission(tRole.getfId());
        resourceIdList.forEach(fResourcesId -> {
            TRoleAndResourceLink tRoleAndResourceLink = new TRoleAndResourceLink();
            tRoleAndResourceLink.setfRoleId(tRole.getfId());
            tRoleAndResourceLink.setfResourcesId(fResourcesId);
            tRoleAndResourceLinkMapper.insert(tRoleAndResourceLink);
        });
        return true;
    }

    /**
     * 批量删除角色
     *
     * @param roleIdList 角色id列表
     * @return 删除的记录数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatch(List<Integer> roleIdList) {
        int result = 0;
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        for (Integer roleId : roleIdList) {
            TRole tRole = new TRole();
            tRole.setfDeleteFlag(true);
            tRole.setfId(roleId);
            tRole.setfUpdateTime(time);
            tRole.setfOperatorId(sessionUser.getfId());
            result = result + tRoleMapper.updateByPrimaryKeySelective(tRole);
            clearPermission(roleId);
        }
        insertLog(OperationLogTypeEnum.DELETE, "删除角色", "删除了" + result + "个角色");
        return result;
    }

    /**
     * 获取角色详情
     *
     * @param roleId 角色id
     * @return 包含权限信息的角色详情
     */
    @Override
    public RoleVo getRoleDetail(Integer roleId) {
        TRole tRole = tRoleMapper.selectByPrimaryKey(roleId);
        if (tRole != null) {
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(tRole, roleVo);
            roleVo.setPermissions(tResourceExtMapper.listAllResource2ZtreeByRoleId(roleId));
            return roleVo;
        }
        return null;
    }

    @Override
    public PageInfo<TRole> queryPageByParam(Map<String, Object> param) throws BizException {
        if (param != null) {
            if (param.get(TableConst.PAGE_NO_STR) != null && param.get(TableConst.PAGE_SIZE_STR) != null) {
                PageHelper.startPage((Integer) param.get(TableConst.PAGE_NO_STR), (Integer) param.get(TableConst.PAGE_SIZE_STR));
            }
        }
        TRoleExample example = new TRoleExample();
        example.createCriteria().andFDeleteFlagEqualTo(false);
        example.setOrderByClause("f_sort");
        List<TRole> dataList = tRoleMapper.selectByExample(example);
        return new PageInfo<>(dataList);
    }

    /**
     * 清空角色权限
     *
     * @param roleId 角色id
     */
    private void clearPermission(Integer roleId) {
        TRoleAndResourceLinkExample example = new TRoleAndResourceLinkExample();
        example.createCriteria().andFRoleIdEqualTo(roleId);
        tRoleAndResourceLinkMapper.deleteByExample(example);
    }

    /**
     * 查询所有角色
     *
     * @return 所有角色List
     */
    @Override
    public List<TRole> selectAll() {
        TRoleExample example = new TRoleExample();
        example.createCriteria().andFDeleteFlagEqualTo(false);
        example.setOrderByClause("f_sort");
        return tRoleMapper.selectByExample(example);
    }
}
