package cn.wtu.broadcast.openapi.provider;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.BUpdateFileService;
import cn.wtu.broadcast.openapi.dao.BUpdateFileMapper;
import cn.wtu.broadcast.openapi.dao.extend.BUpdateFileExtMapper;
import cn.wtu.broadcast.openapi.model.BUpdateFile;
import cn.wtu.broadcast.openapi.model.BUpdateFileExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BUpdateFileVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

@Service
public class BUpdateFileServiceImpl extends ParentServiceImpl<BUpdateFile> implements BUpdateFileService{

	public static Logger logger=LoggerFactory.getLogger(BUpdateFileServiceImpl.class);
	
	@Autowired
	BUpdateFileMapper bUpdateFileMapper;
	
	@Autowired
	BUpdateFileExtMapper bUpdateFileExtMapper;
	
	@Override
	public Boolean addUpdateFile(BUpdateFile bUpdateFile) {
		TUser tUser= getSessionUser();
		bUpdateFile.setfOperatorId(tUser.getfId());
		bUpdateFile.setfCreatorId(tUser.getfId());
		try {
			int count=bUpdateFileMapper.insertSelective(bUpdateFile);	
			if (count>0) {
				insertLog(OperationLogTypeEnum.INSERT,"上传升级文件","上传成功");
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	protected DBInterface<BUpdateFile> getDao() {
		return bUpdateFileMapper;
	}

	@Override
	public PageInfo<BUpdateFile> queryPageByParam(Map<String, Object> paramMap) throws BizException {
		PageInfo<BUpdateFile> result = null;
		BUpdateFileExample example=new BUpdateFileExample();
		example.setOrderByClause(paramMap.get("sortName")+" "+paramMap.get("sortOrder"));
		example.createCriteria().andFDeleteFlagEqualTo(false).andFFileNameLike("%"+paramMap.get("searchText")+"%");
		try {
			PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
			List<BUpdateFile> dataList = bUpdateFileMapper.selectByExample(example);
			if (dataList != null) {
				result=new PageInfo<BUpdateFile>(dataList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result; 	
	}

	@Override
	public int deleteFile(String fId) {
		TUser tUser = getSessionUser();
		BUpdateFile bUpdateFile=new BUpdateFile();
		bUpdateFile.setfDeleteFlag(true);
		bUpdateFile.setfOperatorId(tUser.getfId());
		int count=0;
		String[] ids=fId.split(",");
		for (String id : ids) {
			try {
				bUpdateFile.setfId(Integer.parseInt(id));
				count=count+bUpdateFileMapper.updateByPrimaryKeySelective(bUpdateFile);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return count;
	}

	@Override
	public Boolean checkUpdateFileName(String title) {
		int count=0;
		BUpdateFileExample example=new BUpdateFileExample();
		example.createCriteria().andFFileNameEqualTo(title).andFDeleteFlagEqualTo(false);
		try {
			count=bUpdateFileMapper.countByExample(example);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}if (count>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public PageInfo<BUpdateFileVO> queryPage(Map<String, Object> paramMap,Integer fIpOrTs) {
		List<BUpdateFileVO> list=null;
 		try {
 			PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
 			if(fIpOrTs == 0){
 				//ip
 				list =bUpdateFileExtMapper.selectupdatefile(paramMap);
 			}else if(fIpOrTs == 1){
 				//ts
 				list =bUpdateFileExtMapper.selectTsupdatefile(paramMap);
 			}
	 		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
        return new PageInfo<BUpdateFileVO>(list);
	}
	
	
}
