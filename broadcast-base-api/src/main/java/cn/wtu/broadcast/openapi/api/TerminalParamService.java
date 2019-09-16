package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.vo.TerminalParamVO;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Created on 2019/1/18 14:05
 *
 * @author LY
 */
public interface TerminalParamService  {

    public PageInfo<TerminalParamVO> queryEmergencyDevicePage(Map<String, Object> paramMap);

}

