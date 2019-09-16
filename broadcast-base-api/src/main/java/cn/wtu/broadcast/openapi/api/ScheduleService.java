package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BAudioData;
import cn.wtu.broadcast.openapi.model.BBroadcastTiming;
import cn.wtu.broadcast.openapi.vo.BroadcastTimingVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface ScheduleService extends ParentService<BBroadcastTiming>{
	//查询定时表中数据并将其显示
	public List<BBroadcastTiming> selectByFid(Integer fId);
	
	//向定时表中插入数据
	public boolean insertToBroadcastTiming(BBroadcastTiming bBroadcastTiming);
	
	//查找定时表中的数据
	public BBroadcastTiming selectBBroadcastTimingById(Integer id);
	
	//根据id删除定时表中的数据
	public void deleteBBroadcastTimingById(Integer id);
	
	//级联音频数据表读取数据
	public BAudioData selectByFMessageType(Integer fMessageType);
	
	//查询定时表中数据并将其显示
	public List<BAudioData> selectBAudioDataList();
	
	//model 增加音频文件
	//public List<BBroadcastTiming> getAllBroadcastTiming();
	
	//更新操作
	public boolean updateBBroadcastTiming(BBroadcastTiming bBroadcastTiming,Integer fId);
	
	//删除操作
	public int deleteBBroadcastTimingByIds(List<Integer> idList);
	
	//分页查询
	public PageInfo<BroadcastTimingVO> queryPage(Map<String, Object> paramMap);
	
}
