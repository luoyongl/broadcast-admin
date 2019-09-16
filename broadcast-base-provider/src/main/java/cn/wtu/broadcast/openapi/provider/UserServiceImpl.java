package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.UserService;
import cn.wtu.broadcast.openapi.dao.TRoleAndUserAssociationMapper;
import cn.wtu.broadcast.openapi.dao.TUserMapper;
import cn.wtu.broadcast.openapi.dao.extend.TResourceExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.UserExtMapper;
import cn.wtu.broadcast.openapi.model.*;
import cn.wtu.broadcast.openapi.vo.UserVO;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.exceptions.DBException;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends ParentServiceImpl<TUser> implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final TUserMapper userMapper;

    private final UserExtMapper userExtMapper;

    private final TResourceExtMapper tResourceExtMapper;

    private final TRoleAndUserAssociationMapper tRoleAndUserAssociationMapper;

    private final HashedCredentialsMatcher hashedCredentialsMatcher;

    /**
     * 初始密码
     */
    private final String initPassword = "000000";

    @Autowired
    public UserServiceImpl(TUserMapper userMapper, UserExtMapper userExtMapper, TResourceExtMapper tResourceExtMapper, TRoleAndUserAssociationMapper tRoleAndUserAssociationMapper, HashedCredentialsMatcher hashedCredentialsMatcher) {
        this.userMapper = userMapper;
        this.userExtMapper = userExtMapper;
        this.tResourceExtMapper = tResourceExtMapper;
        this.tRoleAndUserAssociationMapper = tRoleAndUserAssociationMapper;
        this.hashedCredentialsMatcher = hashedCredentialsMatcher;
    }

    @Override
    protected DBInterface<TUser> getDao() {
        return userMapper;
    }

    @Override
    public BroadcastResult login(String keys, String password, String cate) throws DBException {
        return null;
    }

    @Override
    public TUser selectByUserAccount(String fUserAccount) {
        try {
            if (StringUtils.isNoneBlank(fUserAccount)) {
                TUserExample example = new TUserExample();
                example.createCriteria().andFIsEffectiveEqualTo(true).andFAccountEqualTo(fUserAccount);
                List<TUser> userList = userMapper.selectByExample(example);
                if (userList != null && userList.size() == 1) {
                    return userList.get(0);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
        }
        return null;
    }

    /**
     * 查询用户资源
     *
     * @param userId 用户id
     * @return 资源列表
     */
    @Override
    public List<TResource> selectResource(Integer userId) {
        return tResourceExtMapper.selectByUserId(userId);
    }

    /**
     * 查询所有用户(包含已删除)
     *
     * @return 所有用户List
     */
    @Override
    public List<TUser> listAllUser() {
        return userMapper.selectByExample(null);
    }

    /**
     * 保存用户
     *
     * @param tUser  用户
     * @param roleId 角色id
     * @return 保存是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(TUser tUser, Integer roleId) {
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        int result = 0;
        if (tUser.getfId() != null) {
            String chpwd = tUser.getfPassword();
            validateAccount(tUser.getfAccount(), tUser.getfId());
            tUser.setfPassword(encryptPassword(tUser.getfAccount(), chpwd));
            tUser.setfOperatorId(sessionUser.getfId());
            tUser.setfUpdateTime(time);
            result += userMapper.updateByPrimaryKeySelective(tUser);
            insertLog(OperationLogTypeEnum.UPDATE, "修改用户", result > 0 ? "成功" : "失败");
        } else {
            validateAccount(tUser.getfAccount(), null);
            tUser.setfPassword(encryptPassword(tUser.getfAccount(), tUser.getfPassword()));
            tUser.setfCreatorId(sessionUser.getfId());
            tUser.setfCreateTime(time);
            tUser.setfDeleteFlag(false);
            result += userMapper.insert(tUser);
            insertLog(OperationLogTypeEnum.UPDATE, "添加用户", result > 0 ? "成功" : "失败");
        }
        //先清空后保存
        Integer userId = tUser.getfId();
        if (roleId != null) {
            TRoleAndUserAssociationExample example = new TRoleAndUserAssociationExample();
            example.createCriteria().andFUserIdEqualTo(userId);
            tRoleAndUserAssociationMapper.deleteByExample(example);
            //目前一个用户只对应一个角色
            TRoleAndUserAssociation association = new TRoleAndUserAssociation();
            association.setfRoleId(roleId);
            association.setfUserId(userId);
            result += tRoleAndUserAssociationMapper.insert(association);
        }
        return result > 0;
    }

    /**
     * 批量删除用户
     *
     * @param userIdList 用户id列表
     * @return 删除的记录数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatch(List<Integer> userIdList) {
        int result = 0;
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        for (Integer userId : userIdList) {
            if (userId.equals(sessionUser.getfId())) {
                //不能删除自己
                continue;
            }
            TUser tUser = new TUser();
            tUser.setfDeleteFlag(true);
            tUser.setfId(userId);
            tUser.setfUpdateTime(time);
            tUser.setfOperatorId(sessionUser.getfId());
            result = result + userMapper.updateByPrimaryKeySelective(tUser);
        }
        insertLog(OperationLogTypeEnum.DELETE, "删除用户", "删除了" + result + "个用户");
        return result;
    }

    /**
     * 重置用户密码
     *
     * @param userId 用户id
     * @return 重置是否成功
     */
    @Override
    public boolean reset(Integer userId) {
        TUser tUser = userMapper.selectByPrimaryKey(userId);
        if (tUser != null) {
            String account = tUser.getfAccount();
            tUser.setfPassword(encryptPassword(account, initPassword));
            int num = userMapper.updateByPrimaryKeySelective(tUser);
            insertLog(OperationLogTypeEnum.UPDATE, "为[" + account + "]重置密码", num > 0 ? "成功" : "失败");
            return num > 0;
        }
        return false;
    }

    /**
     * 加密密码
     *
     * @param username 用户名
     * @param password 密码明文
     * @return 密码密文
     */
    private String encryptPassword(String username, String password) {
        Object salt = ByteSource.Util.bytes(username);
        SimpleHash result = new SimpleHash(hashedCredentialsMatcher.getHashAlgorithmName(), password, salt, hashedCredentialsMatcher.getHashIterations());
        return result.toHex();
    }

    /**
     * 验证账号名称是否存在
     *
     * @param account 账号
     * @param userId  用户id
     */
    private void validateAccount(String account, Integer userId) {
        if (StringUtils.isEmpty(account)) {
            throw new BizException("请填写账号");
        }
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria().andFAccountEqualTo(account);
        if (userId != null) {
            criteria.andFIdNotEqualTo(userId);
        }
        if (userMapper.countByExample(example) > 0) {
            throw new BizException("账号已存在");
        }
    }

    /**
     * 查询用户列表
     *
     * @param param 查询参数
     * @return 用户列表
     */
    @Override
    public PageInfo<UserVO> selectList(Map<String, Object> param) {
        String search = "";
        if (param != null) {
            if (param.get(TableConst.PAGE_NO_STR) != null && param.get(TableConst.PAGE_SIZE_STR) != null) {
                PageHelper.startPage((Integer) param.get(TableConst.PAGE_NO_STR), (Integer) param.get(TableConst.PAGE_SIZE_STR));
            }
            search = (String) param.get(TableConst.SEARCH_STR);
        }
        List<UserVO> dataList = userExtMapper.selectList(search);
        return new PageInfo<>(dataList);
    }
}
