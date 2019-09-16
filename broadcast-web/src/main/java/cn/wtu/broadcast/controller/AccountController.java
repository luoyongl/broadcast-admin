package cn.wtu.broadcast.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.api.UserService;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TResource;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.DeviceStateEnum;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.pojo.Menu;

/**
 * @author huangjiakui
 * @ClassName: AccountController
 * @Description: 用户登录
 * @date 2018年12月04日
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    private final UserService userService;

    private final BDeviceInfoService bDeviceInfoService;

    private final TDictionaryService tDictionaryService;


    @Autowired
    public AccountController(UserService userService,
                             BDeviceInfoService bDeviceInfoService,
                             TDictionaryService tDictionaryService) {
        this.bDeviceInfoService=bDeviceInfoService;
        this.userService = userService;
        this.tDictionaryService=tDictionaryService;
    }

    @RequestMapping(value = "/goLogin")
    public String goLogin() {  	
        return "login";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public BroadcastResult login(@RequestParam("fAccount") String fAccount,
                                 @RequestParam("fPassword") String fPassword,
                                 @RequestParam(value = "remember", required = false, defaultValue = "false") boolean remember, Model model) {
        BroadcastResult broadcastResult = new BroadcastResult();
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(fAccount, fPassword);
            token.setRememberMe(remember);
            try {
                currentUser.login(token);
                //登录成功后设置session
                Session session = currentUser.getSession();
                TUser tUser = userService.selectByUserAccount(fAccount);
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
                broadcastResult.setStatus(200);
            } catch (Exception e) {
                broadcastResult.setStatus(400);
                broadcastResult.setMsg("用户名或密码错误!");
            }
        } else {
            broadcastResult.setStatus(200);
        }

        return broadcastResult;
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

    @SuppressWarnings("unused")
	@RequestMapping(value = "/home")
    public String home(Model model) {
        List<TDictionary> messageLevel=tDictionaryService.selectListByCriteria("message_grade");
        Integer malfunction_device=bDeviceInfoService.selectState(DeviceStateEnum.malfunction.getCode());//故障
        Integer powerOutage=bDeviceInfoService.selectState(DeviceStateEnum.powerOutage.getCode());//停电
        Integer discon_device=bDeviceInfoService.selectState(DeviceStateEnum.offline.getCode());//离线
        Integer online_device=bDeviceInfoService.selectState(DeviceStateEnum.online.getCode());//在线
        Integer broadcasting_device=bDeviceInfoService.selectState(DeviceStateEnum.broadcasting.getCode());//在线
        Integer ter_device=bDeviceInfoService.selectDeviceType(DeviceTypeEnum.terminalDevice.getCode());
        Integer front_device=bDeviceInfoService.selectDeviceType(DeviceTypeEnum.frontDevice.getCode());

        model.addAttribute("online_device",online_device);
        model.addAttribute("broadcasting_device",broadcasting_device);
        model.addAttribute("powerOutage",powerOutage);
        model.addAttribute("malfunction_device",malfunction_device);
        model.addAttribute("discon_device",discon_device);
        model.addAttribute("front_device",front_device);
        model.addAttribute("ter_device",ter_device);


        return "home";
    }
}