package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BSystemInfoRecord;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * 系统信息记录service接口
 *
 * @author sueua
 * @date 2019/1/22
 */
public interface SystemInfoRecordService extends ParentService<BSystemInfoRecord> {

    /**
     * mysql状态
     *
     * @return 正常/异常
     */
    boolean mysqlStatus();
    
    public Integer getServerStateById(Integer fServerType);
}
