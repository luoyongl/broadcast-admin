package cn.wtu.broadcast.filter;

import cn.wtu.broadcast.openapi.api.UserService;
import cn.wtu.broadcast.openapi.model.TResource;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.pojo.Menu;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 临时开放,用于postMan免登陆
 *
 * @author sueua
 * @since 2018-12-19
 */
public class AuthenticationFilter extends FormAuthenticationFilter {
    @Autowired
    private UserService userService;
    @Override
    public void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String username = req.getHeader("username");
        String password = req.getHeader("password");
        if (StringUtils.isNotBlank(username)&&StringUtils.isNotBlank(password)) {
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                currentUser.login(token);
                //登录成功后设置session
                Session session = currentUser.getSession();
                TUser tUser = userService.selectByUserAccount(username);
                session.setAttribute(Constant.CURRENT_USER, tUser);
                List<TResource> tResources = userService.selectResource(tUser.getfId());
                List<Menu> menuList = new ArrayList<>();
                Set<String> permissions = new HashSet<>();
                for (TResource tResource : tResources) {
                    if (StringUtils.isNotBlank(tResource.getfPermissionCode())) {
                        permissions.add(tResource.getfPermissionCode());
                    }
                    Menu menu = new Menu();
                    menu.setMenuId(tResource.getfId());
                    menu.setPid(tResource.getfParentResource());
                    menu.setMenuName(tResource.getfResourceName());
                    menu.setMenuPath(tResource.getfResourcePath());
                    menu.setMenuIco(tResource.getfResourceIco());
                    menuList.add(menu);
                }
                List<Menu> menuTree = new ArrayList<>();
                for (Menu menu : menuList) {
                    if (menu.getPid() == 0) {
                        menuTree.add(getChildren(menu, menuList));
                    }
                }
                session.setAttribute(Constant.CURRENT_USER_PERMISSION, permissions);
                session.setAttribute(Constant.CURRENT_USER_MENU, menuTree);
            } catch (Exception e) {
                //登录异常
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSONUtils.toString(BroadcastResult.fail(e.getMessage())));
                writer.flush();
                writer.close();
                return;
            }
        }
        super.doFilterInternal(request, response, chain);
    }
    /**
     * 递归查找子节点
     */
    private Menu getChildren(Menu menu, List<Menu> menuList) {
        for (Menu m : menuList) {
            if (menu.getMenuId().equals(m.getPid())) {
                if (menu.getChildren() == null) {
                    menu.setChildren(new ArrayList<>());
                }
                menu.getChildren().add(getChildren(m, menuList));
            }
        }
        return menu;
    }
}
