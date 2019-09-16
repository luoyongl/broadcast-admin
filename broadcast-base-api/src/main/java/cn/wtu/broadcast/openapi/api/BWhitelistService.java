package cn.wtu.broadcast.openapi.api;


import java.util.Map;


import cn.wtu.broadcast.openapi.model.BWhitelist;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.vo.BWhitelistVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface BWhitelistService extends ParentService<BWhitelist>{

	public Boolean addwhitelist(BWhitelist rWhitelist);
	
	public PageInfo<BWhitelistVO> queryPage(Map<String, Object> paramMap);
	
	public boolean updatewhitelistById(BWhitelist rWhitelist);

	public int deletewhitelist(String fId);
	
	public Boolean checkwhiteList(String title);
}
