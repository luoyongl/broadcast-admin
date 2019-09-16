package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.TResource;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.UserVO;
import cn.wtu.broadcast.parent.exceptions.DBException;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.service.api.ParentService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface UserService extends ParentService<TUser> {

    /**
     * 手机号或者邮箱登录
     *
     * @param keys     手机号/邮箱
     * @param password 密码
     * @return
     */
    BroadcastResult login(String keys, String password, String cate) throws DBException;

    /**
     * 通过用户账号获取用户信息
     *
     * @param fUserAccount
     * @return
     */
    TUser selectByUserAccount(String fUserAccount);

    /**
     * 查询用户资源
     *
     * @param userId 用户id
     * @return 资源列表
     */
    List<TResource> selectResource(Integer userId);

    /**
     * 查询所有用户(包含已删除)
     *
     * @return 所有用户List
     */
    List<TUser> listAllUser();

    /**
     * 保存用户
     *
     * @param tUser  用户
     * @param roleId 角色id
     * @return 保存是否成功
     */
    boolean save(TUser tUser, Integer roleId);

    /**
     * 批量删除用户
     *
     * @param userIdList 用户id列表
     * @return 删除的记录数
     */
    int deleteBatch(List<Integer> userIdList);

    /**
     * 重置用户密码
     *
     * @param userId 用户id
     * @return 重置是否成功
     */
    boolean reset(Integer userId);

    /**
     * 查询用户列表
     *
     * @param param 查询参数
     * @return 用户列表
     */
    PageInfo<UserVO> selectList(Map<String, Object> param);
}
