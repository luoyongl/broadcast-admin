package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BAudioData;
import cn.wtu.broadcast.parent.db.api.DBInterface;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-02 0:16
 */
public interface BAudioDataExtMapper extends DBInterface<BAudioData> {

    List<BAudioData> selectAudioList(Map<String, Object> paramMap);
    
    int selectUsedAudio(int id);
}
