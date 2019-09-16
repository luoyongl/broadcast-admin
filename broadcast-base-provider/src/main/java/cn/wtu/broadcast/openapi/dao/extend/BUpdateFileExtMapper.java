package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BUpdateFile;
import cn.wtu.broadcast.openapi.vo.BUpdateFileVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BUpdateFileExtMapper extends DBInterface<BUpdateFile>{
	
	public List<BUpdateFileVO> selectupdatefile(Map<String, Object> paramMap);
	
	public List<BUpdateFileVO> selectTsupdatefile(Map<String, Object> paramMap);
	
}