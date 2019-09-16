package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BBroadcastData;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.vo.BroadCastDataVO;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.service.api.ParentService;


public interface AdvanceService extends ParentService<BBroadcastData>{

	boolean insertOrUpdateAdvance(BBroadcastData bBroadcastData);
	int deleteByPrimaryKey(String[] advanceIdArr, int cancelledState); //返回删除的记录数 传入id字符串数组
	public PageInfo<BroadCastDataVO> queryPage(Map<String, Object> paramMap);
	List<String> selectAllAdvanceName();
	BroadcastResult submitReview(BBroadcastData bBroadcastData);
}
