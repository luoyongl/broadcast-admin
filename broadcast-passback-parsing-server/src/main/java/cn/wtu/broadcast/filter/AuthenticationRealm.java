package cn.wtu.broadcast.filter;

import cn.wtu.broadcast.openapi.api.UserService;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.exceptions.BizException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author huangjiakui
 * @ClassName: AuthenticationRealm
 * @Description: 权限认证
 * @date 2018年12月04日
 */
public class AuthenticationRealm extends AuthorizingRealm {

    /**
     * 用户信息操作接口
     */
    @Autowired
    private UserService userService;

    /**
     * 获取认证信息
     *
     * @param token 令牌
     * @return 认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        String fUserAccount = (String) token.getPrincipal();
        TUser tUser = userService.selectByUserAccount(fUserAccount);
        if (tUser != null) {
            if(tUser.getfIsEffective()!=null && !tUser.getfIsEffective()){
                throw new BizException("用户已失效");
            }
            return new SimpleAuthenticationInfo(tUser.getfAccount(), tUser.getfPassword(),
                    ByteSource.Util.bytes(tUser.getfAccount()), getName());
        }
        return null;
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection PrincipalCollection
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        @SuppressWarnings("all")
        Set<String> permissions = (Set<String>) session.getAttribute(Constant.CURRENT_USER_PERMISSION);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

}