package cn.wtu.broadcast.config;

import cn.wtu.broadcast.openapi.api.UserService;
import cn.wtu.broadcast.openapi.model.TUser;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * 用户数据
 *
 * @author sueua
 * @since 2018-12-23
 */
@Component
public class UserData implements InitializingBean {

    private static ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();

    private static UserService userService;

    @Autowired
    public UserData(UserService userService) {
        UserData.userService = userService;
    }

    /**
     * 刷新map
     */
    public synchronized static void reload() {
        List<TUser> userList = userService.listAllUser();
        map = userList.stream().collect(Collectors.toConcurrentMap(TUser::getfId, TUser::getfUsername));
    }

    public static ConcurrentMap<Integer, String> getMap() {
        return map;
    }

    @Override
    public void afterPropertiesSet() {
        reload();
    }
}
