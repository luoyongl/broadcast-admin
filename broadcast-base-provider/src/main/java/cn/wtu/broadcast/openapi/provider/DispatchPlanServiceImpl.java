package cn.wtu.broadcast.openapi.provider;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.DispatchPlanService;
import cn.wtu.broadcast.openapi.dao.extend.DispatchPlanExtMapper;
import cn.wtu.broadcast.openapi.vo.DispatchPlanVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;

@Service
public class DispatchPlanServiceImpl extends ParentServiceImpl<DispatchPlanVO> implements DispatchPlanService{
	//private static Logger logger = LoggerFactory.getLogger(DispatchPlanServiceImpl.class);
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(DispatchPlanServiceImpl.class);
	
    private final DispatchPlanExtMapper dispatchMapper;
	
	@Autowired
	public DispatchPlanServiceImpl(DispatchPlanExtMapper dispatchMapper) {
		this.dispatchMapper = dispatchMapper;
	}
	
	@Override
	protected DBInterface<DispatchPlanVO> getDao() {
		return dispatchMapper;
	}
	
	@Override
	public PageInfo<DispatchPlanVO> queryPage(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		 PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
	     List<DispatchPlanVO> dataList = dispatchMapper.selectPlanList(paramMap);
	     return new PageInfo<>(dataList);
	}
	
	@Override
	public boolean addDispatchPlan(DispatchPlanVO dispatchPlanVO) {
		int i = 0;
		try{
			i = dispatchMapper.insertSelective(dispatchPlanVO);
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		if(i==1){
			insertLog(OperationLogTypeEnum.INSERT,"新增调度策略","成功");
			return true;
		}else{
			insertLog(OperationLogTypeEnum.INSERT,"新增调度策略","失败");
			return false;
		}

	}
	
	@Override
   public boolean updateDispatchPlan(DispatchPlanVO dispatchPlanVO) {
        try {
            int result = dispatchMapper.updateByPrimaryKeySelective(dispatchPlanVO);
            if (result == 1) {
                insertLog(OperationLogTypeEnum.UPDATE, "修改调度策略", "成功");
            return true;
        } else {
            insertLog(OperationLogTypeEnum.UPDATE, "修改调度策略", "失败");
            return false;
        }
		} catch (Exception e) {
		    logger.error(e.getMessage(), e);
		    insertLog(OperationLogTypeEnum.UPDATE, "修改调度策略", "失败");
		    return false;
		}
	}
	
	 @Override
		@Transactional(rollbackFor = {Exception.class})
		public int deleteDispatchPlan(List<Integer> idList) {
	    	int result = 0;
			for(Integer id:idList){
				try{
					result += dispatchMapper.deleteByPrimaryKey(id);
				}catch (Exception e){
					logger.error(e.getMessage(),e);
				}
			}
			insertLog(OperationLogTypeEnum.DELETE,"删除调度策略","删除了"+result+"条调度策略");
			return result;
		}

}
