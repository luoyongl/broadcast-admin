package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BAlarmRecord;
import cn.wtu.broadcast.parent.service.api.ParentService;

import java.util.Map;

/**
 * 告警记录service接口
 *
 * @author sueua
 * @date 2019/1/22
 */
public interface AlarmRecordService extends ParentService<BAlarmRecord> {

    /**
     * 获取百度饼图数据
     *
     * @return 百度饼图数据
     */
    Map<String, Object> getChartData();
}
