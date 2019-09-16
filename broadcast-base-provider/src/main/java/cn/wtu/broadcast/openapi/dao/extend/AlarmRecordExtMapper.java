package cn.wtu.broadcast.openapi.dao.extend;


import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 告警信息扩展Dao接口
 *
 * @author sueua
 * @date 2019/1/26
 */
public interface AlarmRecordExtMapper {
    /**
     * 按类别分组查询数量
     *
     * @return 数量
     */
    @Select("Select count(*) count,f_alarm_type type from b_alarm_record where f_delete_flag=0 group by f_alarm_type")
    List<Map<String, Object>> countGroupByType();
}
