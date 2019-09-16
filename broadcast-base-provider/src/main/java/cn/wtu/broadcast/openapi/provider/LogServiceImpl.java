package cn.wtu.broadcast.openapi.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.LogService;
import cn.wtu.broadcast.openapi.dao.TOperationLogMapper;
import cn.wtu.broadcast.openapi.dao.extend.TOperationLogExtMapper;
import cn.wtu.broadcast.openapi.model.TOperationLog;
import cn.wtu.broadcast.openapi.model.TOperationLogExample;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.exceptions.BizException;

/**
 * 日志service接口实现
 *
 * @author sueua
 * @since 2019-01-01
 */
@Service("logService")
public class LogServiceImpl extends ParentServiceImpl<TOperationLog> implements LogService {

    private final TOperationLogMapper tOperationLogMapper;
    private final TOperationLogExtMapper tOperationLogExtMapper;

    @Autowired
    public LogServiceImpl(TOperationLogMapper tOperationLogMapper,TOperationLogExtMapper tOperationLogExtMapper) {
        this.tOperationLogMapper = tOperationLogMapper;
        this.tOperationLogExtMapper = tOperationLogExtMapper;
    }

    /**
     * 获取数据操作实例,不能为空,子类必须实现该方法
     */
    @Override
    protected DBInterface<TOperationLog> getDao() {
        return tOperationLogMapper;
    }

    @Override
    public PageInfo<TOperationLog> queryPageByParam(Map<String, Object> param) throws BizException {
        if (param != null) {
            if (param.get(TableConst.PAGE_NO_STR) != null && param.get(TableConst.PAGE_SIZE_STR) != null) {
                PageHelper.startPage((Integer) param.get(TableConst.PAGE_NO_STR), (Integer) param.get(TableConst.PAGE_SIZE_STR));
            }
        }
        TOperationLogExample example = new TOperationLogExample();
        example.setOrderByClause("f_id desc");
        List<TOperationLog> dataList = tOperationLogMapper.selectByExample(example);
        return new PageInfo<>(dataList);
    }
    
    @Override
    public PageInfo<TOperationLog> selectSearchTableInfo(Map<String, Object> param) throws BizException {
    	PageInfo<TOperationLog> result = null; 
    	if (param != null) {
            if (param.get(TableConst.PAGE_NO_STR) != null && param.get(TableConst.PAGE_SIZE_STR) != null) {
                PageHelper.startPage((Integer) param.get(TableConst.PAGE_NO_STR), (Integer) param.get(TableConst.PAGE_SIZE_STR));
            }
        }
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date startTime = sdf.parse((String)param.get("startTime"));
		    Date endTime = sdf.parse((String)param.get("endTime"));
		    String searchInfo = "%"+(String)param.get("searchInfo")+"%";
		    /*TOperationLogExample example = new TOperationLogExample();
		    TOperationLogExample.Criteria criteria = example.createCriteria();
	        example.setOrderByClause("f_id desc");
	        criteria.andFOperationTimeBetween(startTime, endTime);
	        criteria.andFOperationContentLike(searchInfo);
	        List<TOperationLog> dataList = tOperationLogMapper.selectByExample(example);*/
		    List<TOperationLog> dataList = tOperationLogExtMapper.selectBySearchInfoAndTime(startTime, endTime, searchInfo);
	        result =  new PageInfo<>(dataList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
    }
}
