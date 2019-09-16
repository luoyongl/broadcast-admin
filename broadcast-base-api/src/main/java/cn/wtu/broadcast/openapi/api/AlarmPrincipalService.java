package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.TAlarmPrincipal;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-05 17:09
 */
public interface AlarmPrincipalService extends ParentService<TAlarmPrincipal> {

    Integer addPrincipal(List<Integer> ids);

    Map<Integer,Map<Integer,String>> selectUserByRegionId(List<Integer> idList);

    Integer deleteProgramByIds(List<Integer> idList);
}
