package cn.wtu.broadcast.openapi.provider;

/**
 *  定时广播
 * 
 * @author yinjie
 * @since 2018-12-17
 */

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.ScheduleService;
import cn.wtu.broadcast.openapi.dao.BAudioDataMapper;
import cn.wtu.broadcast.openapi.dao.BBroadcastTimingMapper;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastTimingExtMapper;
import cn.wtu.broadcast.openapi.model.BAudioData;
import cn.wtu.broadcast.openapi.model.BAudioDataExample;
import cn.wtu.broadcast.openapi.model.BBroadcastTiming;
import cn.wtu.broadcast.openapi.model.BBroadcastTimingExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BroadcastTimingVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

@Service("ScheduleService")
public class ScheduleServiceImpl extends ParentServiceImpl<BBroadcastTiming> implements ScheduleService{
	
	@Autowired
	private final BBroadcastTimingMapper bBroadcastTimingMapper;
	
	@Autowired
    public ScheduleServiceImpl(BBroadcastTimingMapper bBroadcastTimingMapper) {
        this.bBroadcastTimingMapper = bBroadcastTimingMapper;
    } 
	 
	@Autowired
	private BAudioDataMapper bAudioDataMapper;
	//private bAudioDataMapper bAudioDataMapper;
	
	@Autowired
	private BBroadcastTimingExtMapper bBroadcastTimingExtMapper;
	
	//查询定时表中数据并将其显示
	public List<BBroadcastTiming> selectByFid(Integer fId){
		BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
		bBroadcastTimingExample.createCriteria().andFIdIsNotNull();
		List<BBroadcastTiming> bBroadcastList = bBroadcastTimingMapper.selectByExample(bBroadcastTimingExample);
		return bBroadcastList;
	}
	
	//联表查询
	@Override
	public PageInfo<BroadcastTimingVO> queryPage(Map<String, Object> paramMap)throws BizException {
		PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
		 List<BroadcastTimingVO> dataList = bBroadcastTimingExtMapper.selectBoradcastAll(paramMap);			
	    return new PageInfo<>(dataList);
	}
	
	//向定时表中插入数据
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public boolean insertToBroadcastTiming(BBroadcastTiming bBroadcastTiming){
		TUser sessionUser = getSessionUser();

		//bBroadcastTiming.setfOperatorId(sessionUser.getfId());
		bBroadcastTiming.setfCreateId(sessionUser.getfId());
		bBroadcastTiming.setfMessageSource(sessionUser.getfRespectiveRegion());
		
		int i = bBroadcastTimingMapper.insertSelective(bBroadcastTiming);
		if(i==1){
			insertLog(OperationLogTypeEnum.INSERT,"新增定时广播","新增成功");
			return true;
		}else{
			insertLog(OperationLogTypeEnum.INSERT,"新增定时广播","新增失败");
			return false;
		}
	}
	
	//根据id查找定时表中的数据
	public BBroadcastTiming selectBBroadcastTimingById(Integer id){
		BBroadcastTiming broadcastTiming = bBroadcastTimingMapper.selectByPrimaryKey(id);
		return broadcastTiming;
	}
	
	//根据id删除定时表中的数据
	public void deleteBBroadcastTimingById(Integer id){
		bBroadcastTimingMapper.deleteByPrimaryKey(id);
	}
	
	//级联音频数据表读取数据
	public BAudioData selectByFMessageType(Integer fMessageType){
		BAudioData videoData = bAudioDataMapper.selectByPrimaryKey(fMessageType);
		return videoData;
	}
	
	//查询定时表中数据并将其显示
	public List<BAudioData> selectBAudioDataList(){
		BAudioDataExample BAudioDataExample = new BAudioDataExample();
		BAudioDataExample.createCriteria().andFDeleteFlagNotEqualTo(true);
		List<BAudioData> videoDataList = bAudioDataMapper.selectByExample(BAudioDataExample);
		return videoDataList;
	}
	
	//model 增加音频文件
	/*public List<BBroadcastTiming> getAllBroadcastTiming(){
		List<BBroadcastTiming> broadcastTiming = bBroadcastTimingMapper.selectAllBroadcastTiming();
		return broadcastTiming;
	}*/

	//更新操作
	@Override
	public boolean updateBBroadcastTiming(BBroadcastTiming bBroadcastTiming,Integer fId) {
    	bBroadcastTiming.setfId(fId);
    	TUser sessionUser = getSessionUser();
    	bBroadcastTiming.setfOperatorId(sessionUser.getfId());
		int i = bBroadcastTimingMapper.updateByPrimaryKeySelective(bBroadcastTiming);
		if(i==1){
			insertLog(OperationLogTypeEnum.INSERT,"修改定时广播","修改了1个定时广播");
			return true;
		}else{
			insertLog(OperationLogTypeEnum.INSERT,"修改定时广播","修改失败");
			return false;
		}
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int deleteBBroadcastTimingByIds(List<Integer> idList) {	
		int result = 0;
		Date date = new Date();
		TUser sessionUser = getSessionUser();
		for(Integer id:idList){
			BBroadcastTiming broadcastTiming = new BBroadcastTiming();
			broadcastTiming.setfId(id);
			broadcastTiming.setfUpdateTime(date);
			broadcastTiming.setfDeleteFlag(true);
			broadcastTiming.setfOperatorId(sessionUser.getfId());
			result += bBroadcastTimingMapper.updateByPrimaryKeySelective(broadcastTiming);
		}
		insertLog(OperationLogTypeEnum.DELETE,"删除定时广播","删除了"+result+"个定时广播");
		return result;
	}


	@Override
	protected DBInterface<BBroadcastTiming> getDao() {
		return bBroadcastTimingMapper;
	}

	
}
