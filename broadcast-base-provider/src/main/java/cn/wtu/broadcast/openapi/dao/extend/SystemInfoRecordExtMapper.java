package cn.wtu.broadcast.openapi.dao.extend;

import org.apache.ibatis.annotations.Select;

/**
 * 系统信息扩展Dao接口
 *
 * @author sueua
 * @date 2019/1/22
 */
public interface SystemInfoRecordExtMapper {

    /**
     * mysql状态
     *
     * @return 正常/异常
     */
    @Select("Select 1")
    boolean mysqlStatus();
}
