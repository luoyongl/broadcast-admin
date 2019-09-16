package cn.wtu.broadcast.openapi.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.TerminalParamService;
import cn.wtu.broadcast.openapi.dao.extend.TerminalParamExtMapper;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.vo.TerminalParamVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

/**
 * Created on 2019/1/18 14:05
 *
 * @author LY
 */

@Service
public class TerminalParamServiceImpl  extends ParentServiceImpl<BDeviceInfo> implements TerminalParamService {
    private static Logger logger = LoggerFactory.getLogger(TerminalParamServiceImpl.class);

    @Autowired
    private TerminalParamExtMapper terminalParamExtMapper;

    @Override
    public PageInfo<TerminalParamVO> queryEmergencyDevicePage(Map<String, Object> paramMap) {
        PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
        List<TerminalParamVO> deviceData = new ArrayList<TerminalParamVO>();
        try {
            deviceData = terminalParamExtMapper.selectAll(paramMap);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return new PageInfo<TerminalParamVO>(deviceData);
    }

    @Override
    protected DBInterface<BDeviceInfo> getDao() {
        return null;
    }
}

