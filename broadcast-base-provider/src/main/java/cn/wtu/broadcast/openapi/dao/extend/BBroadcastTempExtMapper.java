package cn.wtu.broadcast.openapi.dao.extend;

import cn.wtu.broadcast.openapi.vo.BBroadcastTempVO;

import java.util.List;
import java.util.Map;

/**
 * Created on 11/03/2019 16:13
 *
 * @author LY
 */
public interface BBroadcastTempExtMapper {

    public List<BBroadcastTempVO> selectBroadcast(Map<String, Object> paramMap);
}

