package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;

import cn.wtu.broadcast.openapi.vo.ServerVo;
import cn.wtu.broadcast.parent.db.api.DBInterface;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-05 14:35
 */
public interface ServerVoExtMapper extends DBInterface<ServerVo> {

    List<ServerVo> selectServerList();
}
