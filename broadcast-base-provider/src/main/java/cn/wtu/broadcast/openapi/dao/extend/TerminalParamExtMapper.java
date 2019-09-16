package cn.wtu.broadcast.openapi.dao.extend;

import cn.wtu.broadcast.openapi.vo.TerminalParamVO;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/1/21 17:38
 *
 * @author LY
 */
public interface TerminalParamExtMapper {
    public List<TerminalParamVO> selectAll(Map<String, Object> paramMap);
}

