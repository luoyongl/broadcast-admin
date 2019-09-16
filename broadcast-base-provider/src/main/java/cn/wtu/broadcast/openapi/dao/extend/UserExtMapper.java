package cn.wtu.broadcast.openapi.dao.extend;

import cn.wtu.broadcast.openapi.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户dao接口
 *
 * @author sueua
 * @since 2019-01-01
 */
public interface UserExtMapper {

    /**
     * 查询用户列表
     *
     * @param search 查询关键字
     * @return 用户list
     */
    List<UserVO> selectList(@Param("search") String search);
}
