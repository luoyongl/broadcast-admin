package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BWhitelist;
import cn.wtu.broadcast.openapi.vo.BWhitelistNewVO;
import cn.wtu.broadcast.openapi.vo.BWhitelistVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;


public interface BWhitelistExtMapper extends DBInterface<BWhitelist>{

	public List<BWhitelistVO> selectwhitelist(Map<String, Object> paramMap);
	
	//修改白名单表后进行查询操作
	public List<BWhitelistNewVO> selectWhiteNewList(Map<String, Object>paramMap);
	
}