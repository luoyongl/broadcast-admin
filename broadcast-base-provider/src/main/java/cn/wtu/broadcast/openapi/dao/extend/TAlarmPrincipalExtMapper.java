package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.TAlarmPrincipal;
import cn.wtu.broadcast.parent.db.api.DBInterface;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-17 11:37
 */
public interface TAlarmPrincipalExtMapper extends DBInterface<TAlarmPrincipal> {

    List<TAlarmPrincipal> selectAlarmList(Map<String, Object> paramMap);
    
    Integer getRootNode();
    
    List<String> getNodes(Integer node);
    
    /**
     * 获取所有存在的结点的id
     * @return
     */
    List<String> getAllNodes();
}
