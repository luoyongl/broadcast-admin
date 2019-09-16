package cn.wtu.broadcast.openapi.provider;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.BCallandsmsRecordService;
import cn.wtu.broadcast.openapi.dao.BCallandsmsRecordMapper;
import cn.wtu.broadcast.openapi.dao.extend.BCallandsmsRecordExtMapper;
import cn.wtu.broadcast.openapi.model.BCallandsmsRecord;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.exceptions.BizException;

@Service
public class BCallandsmsRecordServiceImpl extends ParentServiceImpl<BCallandsmsRecord> implements BCallandsmsRecordService{


	private final BCallandsmsRecordMapper bCallandsmsRecordMapper;
	
	private final BCallandsmsRecordExtMapper bCallandsmsRecordExtMapper;
	
	public BCallandsmsRecordServiceImpl(BCallandsmsRecordMapper bCallandsmsRecordMapper,
			BCallandsmsRecordExtMapper bCallandsmsRecordExtMapper) {
		this.bCallandsmsRecordExtMapper=bCallandsmsRecordExtMapper;
		this.bCallandsmsRecordMapper=bCallandsmsRecordMapper;
	}
	
	@Override
	protected DBInterface<BCallandsmsRecord> getDao() {
		return bCallandsmsRecordMapper;
	}

	@Override
	public PageInfo<BCallandsmsRecord> queryPageByParam(Map<String, Object> paramMap) throws BizException {
		List<BCallandsmsRecord> list=null;
 		try {
 			PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
 			list =bCallandsmsRecordExtMapper.selectRCallandsmsRecord(paramMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
 		
        return new PageInfo<BCallandsmsRecord>(list);
	}
}
