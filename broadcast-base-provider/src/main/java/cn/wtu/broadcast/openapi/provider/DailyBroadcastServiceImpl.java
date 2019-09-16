package cn.wtu.broadcast.openapi.provider;

import java.util.Map;

import cn.wtu.broadcast.openapi.dao.BBroadcastDataMapper;
import cn.wtu.broadcast.openapi.model.BBroadcastData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.DailyBroadcastService;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.openapi.vo.BroadCastDataVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

@Service
public class DailyBroadcastServiceImpl extends ParentServiceImpl<BBroadcastData> implements DailyBroadcastService{

	@SuppressWarnings("unused")
	@Autowired
	private BBroadcastDataMapper bBroadcastDataMapper;
	
	@Autowired
	BBroadcastDataExtMapper bBroadcastDataExtMapper;
	
	/*@Override
	public boolean insertDailyBroacastInfo(BBroadcastData bBroadcastData) {
		TUser tUser=new TUser();
		bBroadcastData.setfOperatorId(tUser.getfId());
		bBroadcastData.setfDeleteFlag(false);
		int flag = bBroadcastDataMapper.insert(bBroadcastData);
		if(flag>0){
			return true;
		}else{
			return false;
		}
		
	}
*/
	

	@Override
	public PageInfo<BroadCastDataVO> selectDailyBroadcastService(Map<String,Object> paramMap, Integer b) {
		PageHelper.startPage((Integer) paramMap.get("pageNo"),(Integer) paramMap.get("pageSize"));
		
		/*BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
		Criteria criteria = bBroadcastDataExample.createCriteria();
		criteria.andFBroadcastTypeEqualTo(b);*/
		
		PageInfo<BroadCastDataVO> list = bBroadcastDataExtMapper.selectBoradcastForDaily(b);
		return list;
	}

	
	@Override
	protected DBInterface<BBroadcastData> getDao() {
		return null;
	}

}
