package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.vo.BProgramChannelVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-02 20:07
 */
public interface BProgramChannelExtMapper extends DBInterface<BProgramChannelVO> {

    List<BProgramChannelVO> selectProgramList(Map<String, Object> paramMap);
}
