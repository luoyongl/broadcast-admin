package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.vo.DispatchPlanVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface DispatchPlanExtMapper extends DBInterface<DispatchPlanVO>{
    int deleteByPrimaryKey(Integer fId);

    int insertSelective(DispatchPlanVO record);

    DispatchPlanVO selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(DispatchPlanVO record);
    
    public List<DispatchPlanVO> selectPlanList(Map<String, Object> paramMap);
}