package cn.wtu.broadcast.openapi.provider;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.SystemInfoRecordService;
import cn.wtu.broadcast.openapi.dao.BServerRuntimeInfoMapper;
import cn.wtu.broadcast.openapi.dao.BSystemInfoRecordMapper;
import cn.wtu.broadcast.openapi.dao.extend.SystemInfoRecordExtMapper;
import cn.wtu.broadcast.openapi.model.BServerRuntimeInfo;
import cn.wtu.broadcast.openapi.model.BServerRuntimeInfoExample;
import cn.wtu.broadcast.openapi.model.BSystemInfoRecord;
import cn.wtu.broadcast.openapi.model.BSystemInfoRecordExample;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.SystemInfoTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

/**
 * 系统信息记录service接口实现
 *
 * @author sueua
 * @date 2019/1/22
 */
@Service("systemInfoRecordService")
public class SystemInfoRecordServiceImpl extends ParentServiceImpl<BSystemInfoRecord> implements SystemInfoRecordService {

    private final BSystemInfoRecordMapper systemInfoRecordMapper;

    private final SystemInfoRecordExtMapper systemInfoRecordExtMapper;
    
    private final BServerRuntimeInfoMapper bServerRuntimeInfoMapper;

    @Autowired
    public SystemInfoRecordServiceImpl(BSystemInfoRecordMapper systemInfoRecordMapper, SystemInfoRecordExtMapper systemInfoRecordExtMapper,BServerRuntimeInfoMapper bServerRuntimeInfoMapper) {
        this.systemInfoRecordMapper = systemInfoRecordMapper;
        this.systemInfoRecordExtMapper = systemInfoRecordExtMapper;
        this.bServerRuntimeInfoMapper = bServerRuntimeInfoMapper;
    }

    /**
     * 获取数据操作实例,不能为空,子类必须实现该方法
     */
    @Override
    protected DBInterface<BSystemInfoRecord> getDao() {
        return systemInfoRecordMapper;
    }

    /**
     * mysql状态
     *
     * @return 正常/异常
     */
    @Override
    public boolean mysqlStatus() {
        return systemInfoRecordExtMapper.mysqlStatus();
    }

    @Override
    public PageInfo<BSystemInfoRecord> queryPageByParam(Map<String, Object> paramMap) throws BizException {
        if (paramMap != null) {
            if (paramMap.get(TableConst.PAGE_NO_STR) != null && paramMap.get(TableConst.PAGE_SIZE_STR) != null) {
                PageHelper.startPage((Integer) paramMap.get(TableConst.PAGE_NO_STR), (Integer) paramMap.get(TableConst.PAGE_SIZE_STR));
            }
        }
        SystemInfoTypeEnum systemInfoTypeEnum = (SystemInfoTypeEnum) (paramMap != null ? paramMap.get("systemInfoType") : null);
        BSystemInfoRecordExample example = new BSystemInfoRecordExample();
        BSystemInfoRecordExample.Criteria criteria = example.createCriteria();
        criteria.andFDeleteFlagEqualTo(false);
        if (systemInfoTypeEnum != null) {
            criteria.andFInfoTypeEqualTo(systemInfoTypeEnum.getValue());
        }
        example.setOrderByClause("f_id desc");
        List<BSystemInfoRecord> dataList = systemInfoRecordMapper.selectByExample(example);
        return new PageInfo<>(dataList);
    }

	@Override
	public Integer getServerStateById(Integer fServerType) {
		Integer fServerState = 0;
		BServerRuntimeInfoExample example = new BServerRuntimeInfoExample();
		example.setOrderByClause(" f_id DESC ");
		example.createCriteria().andFServerTypeEqualTo(fServerType);
		List<BServerRuntimeInfo> list = bServerRuntimeInfoMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			fServerState = list.get(0).getfServerState();
		}
		return fServerState;
	}
}
