package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.ManufacturerService;
import cn.wtu.broadcast.openapi.dao.TManufacturerMapper;
import cn.wtu.broadcast.openapi.model.TManufacturer;
import cn.wtu.broadcast.openapi.model.TManufacturerExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

/**
 * 厂商Service接口实现
 *
 * @author sueua
 * @since 2018-12-29
 */
@Service("manufacturerService")
public class ManufacturerServiceImpl extends ParentServiceImpl<TManufacturer> implements ManufacturerService {

    private final TManufacturerMapper tManufacturerMapper;

    @Autowired
    public ManufacturerServiceImpl(TManufacturerMapper tManufacturerMapper) {
        this.tManufacturerMapper = tManufacturerMapper;
    }

    /**
     * 获取数据操作实例,不能为空,子类必须实现该方法
     */
    @Override
    protected DBInterface<TManufacturer> getDao() {
        return tManufacturerMapper;
    }

    /**
     * 批量删除厂商数据
     *
     * @param manufacturerIdList 厂商d列表
     * @return 删除的记录数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatch(List<Integer> manufacturerIdList) {
        int result = 0;
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        for (Integer manufacturerId : manufacturerIdList) {
            TManufacturer tManufacturer = new TManufacturer();
            tManufacturer.setfDeleteFlag(true);
            tManufacturer.setfId(manufacturerId);
            tManufacturer.setfUpdateTime(time);
            tManufacturer.setfOperatorId(sessionUser.getfId());
            result = result + tManufacturerMapper.updateByPrimaryKeySelective(tManufacturer);
        }
        insertLog(OperationLogTypeEnum.DELETE, "删除厂商", "删除了" + result + "条记录");
        return result;
    }

    /**
     * 保存厂商
     *
     * @param tManufacturer 厂商
     * @return 保存结果(影响的行数是否 > 0)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(TManufacturer tManufacturer) {
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        int result;
        if (tManufacturer.getfId() != null) {
            tManufacturer.setfOperatorId(sessionUser.getfId());
            tManufacturer.setfUpdateTime(time);
            result = tManufacturerMapper.updateByPrimaryKeySelective(tManufacturer);
            insertLog(OperationLogTypeEnum.UPDATE, "修改厂商", result > 0 ? "成功" : "失败");
        } else {
            tManufacturer.setfCreatorId(sessionUser.getfId());
            tManufacturer.setfCreateTime(time);
            tManufacturer.setfDeleteFlag(false);
            result = tManufacturerMapper.insert(tManufacturer);
            insertLog(OperationLogTypeEnum.INSERT, "新增厂商", result > 0 ? "成功" : "失败");
        }
        return result > 0;
    }

    @Override
    public PageInfo<TManufacturer> queryPageByParam(Map<String, Object> paramMap) throws BizException {
        PageHelper.startPage((Integer) paramMap.get("pageNo"), (Integer) paramMap.get("pageSize"));
        TManufacturerExample example = new TManufacturerExample();
        example.createCriteria().andFDeleteFlagEqualTo(false);
        List<TManufacturer> dataList = tManufacturerMapper.selectByExample(example);
        return new PageInfo<>(dataList);
    }

    /**
     * 查询厂商名称，编号,供升级文件选择
     * @author LY
     * @return 
     */
	@Override
	public List<TManufacturer> selectManufacturerForUpdateFile() {
		TManufacturerExample example=new TManufacturerExample();
		example.createCriteria().andFDeleteFlagEqualTo(false);
		return tManufacturerMapper.selectByExample(example);
	}
}
