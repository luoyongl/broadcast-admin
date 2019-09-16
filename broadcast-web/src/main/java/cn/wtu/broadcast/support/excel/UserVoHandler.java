package cn.wtu.broadcast.support.excel;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import cn.wtu.broadcast.config.RegionData;
import cn.wtu.broadcast.config.UserData;
import cn.wtu.broadcast.openapi.vo.UserVO;

import java.util.Map;

/**
 * UserVO自定义处理
 *
 * @author sueua
 * @since 2019-01-01
 */
public class UserVoHandler extends ExcelDataHandlerDefaultImpl<UserVO> {

    private final String REGION_NAME = "所属区域";

    private final String ROLE_NAME = "角色";

    private final String CREATOR_NAME = "创建人";

    private final String OPERATOR_NAME = "修改人";

    private Map<Integer, String> regionMap = RegionData.getNameMap();

    private Map<Integer, String> userMap = UserData.getMap();

    private Map<Integer, String> roleMap;

    public UserVoHandler(Map<Integer, String> roleMap) {
        this.roleMap = roleMap;
    }

    @Override
    public Object exportHandler(UserVO obj, String name, Object value) {
        switch (name) {
            case REGION_NAME:
                return regionMap.get(value);
            case ROLE_NAME:
                return roleMap.get(value);
            case CREATOR_NAME:
            case OPERATOR_NAME:
                if (value != null){
                    return userMap.get(value);
                }
            default:
                return value;
        }
    }
}
