package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.BWhitelistService;
import cn.wtu.broadcast.openapi.dao.BWhitelistMapper;
import cn.wtu.broadcast.openapi.dao.extend.BWhitelistExtMapper;
import cn.wtu.broadcast.openapi.model.BWhitelist;
import cn.wtu.broadcast.openapi.model.BWhitelistExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BWhitelistVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.exceptions.BizException;

@Service
public class BWhitelistServiceImpl extends ParentServiceImpl<BWhitelist> implements BWhitelistService{
	
	public static Logger logger=LoggerFactory.getLogger(BWhitelistServiceImpl.class);
	
	private final BWhitelistMapper bWhitelistMapper;

	private final BWhitelistExtMapper bwExtMapper;
	
	public BWhitelistServiceImpl(BWhitelistMapper bWhitelistMapper,
			BWhitelistExtMapper bwExtMapper) {
		this.bwExtMapper=bwExtMapper;
		this.bWhitelistMapper=bWhitelistMapper;
	}
	@Override
	protected DBInterface<BWhitelist> getDao() {
		return bWhitelistMapper;
	}

	@Override
	public Boolean addwhitelist(BWhitelist bWhitelist) {
		TUser tUser=getSessionUser();
		bWhitelist.setfCreatorId(tUser.getfId());
		bWhitelist.setfOperatorId(tUser.getfId());
		int count=bWhitelistMapper.insertSelective(bWhitelist);
		if (count>0) {
			return true;
		}else{
			return false;
		}
	}



	 @Override
	 public PageInfo<BWhitelistVO> queryPage(Map<String, Object> paramMap) throws BizException {
        PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
        List<BWhitelistVO> dataList = bwExtMapper.selectwhitelist(paramMap);
        return new PageInfo<>(dataList);
    }

	@Override
	public boolean updatewhitelistById(BWhitelist rWhitelist) {
		TUser tUser=getSessionUser();
		rWhitelist.setfOperatorId(tUser.getfId());
		rWhitelist.setfUpdateTime(new Date());
		int count=bWhitelistMapper.updateByPrimaryKeySelective(rWhitelist);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int deletewhitelist(String fId) {
		BWhitelist bWhitelist=new BWhitelist();
		TUser tUser=getSessionUser();
		bWhitelist.setfOperatorId(tUser.getfId());
		bWhitelist.setfDeleteFlag(true);
		int count=0;
		String[] ids=fId.split(",");
		for (String id : ids) {
			try {
				bWhitelist.setfId(Integer.parseInt(id));
				count+=bWhitelistMapper.updateByPrimaryKeySelective(bWhitelist);
			} catch (Exception e) {
				// TODO: handle exception
			}	
		}
		return count/2;
	}

	@Override
	public Boolean checkwhiteList(String title) {
		int count=0;
		BWhitelistExample example=new BWhitelistExample();
		example.createCriteria().andFTelephoneNumberEqualTo(title).andFDeleteFlagEqualTo(false);
		try {
			count=bWhitelistMapper.countByExample(example);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}if (count>0) {
			return true;
		}else{
			return false;
		}
	}


}
