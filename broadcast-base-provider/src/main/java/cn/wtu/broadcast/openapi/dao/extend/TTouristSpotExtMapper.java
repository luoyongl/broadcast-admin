package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.exceptions.DBException;

public interface TTouristSpotExtMapper extends DBInterface<TUser>{

    List<TUser> isSpotBuy(Map<String, Object> paramMap) throws DBException;
	
}