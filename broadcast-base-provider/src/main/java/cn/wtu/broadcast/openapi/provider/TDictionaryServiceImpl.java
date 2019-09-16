package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.dao.TDictionaryMapper;
import cn.wtu.broadcast.openapi.dao.extend.TDictionaryExtMapper;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TDictionaryExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;

@Service("TDictionaryService")
public class TDictionaryServiceImpl extends ParentServiceImpl<TDictionary> implements TDictionaryService {

    private final TDictionaryMapper dictionaryMapper;
    
    private final TDictionaryExtMapper dictionaryExtMapper;

    /**
     * f_dictionary_code为key的,同一类词典
     */
    private ConcurrentMap<String, List<TDictionary>> dictMap;

    @Autowired
    public TDictionaryServiceImpl(TDictionaryMapper dictionaryMapper, TDictionaryExtMapper dictionaryExtMapper) {
        this.dictionaryMapper = dictionaryMapper;
        this.dictionaryExtMapper = dictionaryExtMapper;
    }

    /**
     * <p>
     * 由于在本系统中使用<b>f_dictionary_code</b>作为类型区分key,故同一类的
     * <b>f_dictionary_code</b>和<b>f_dictionary_type</b>一致的,且后者是父类的<b>f_id</b>,
     * 查询list时,排除父类,即<b>f_dictionary_type=0</b>的记录
     * </p>
     *
     * @param criteria f_dictionary_code
     * @return 相同f_dictionary_code的字典list
     */
    @Override
    public List<TDictionary> selectListByCriteria(String criteria) {
        if (dictMap == null) {
            loadDictMap();
        }
        return dictMap.get(criteria);
    }

    /**
     * 查询所有非顶级词典,并转换为ConcurrentHashMap
     * <b>字典更新必须调用该方法刷新数据</b>
     */
    private synchronized void loadDictMap() {
        TDictionaryExample tDictionaryExample = new TDictionaryExample();
        tDictionaryExample.createCriteria()
                .andFDeleteFlagEqualTo(false)
                .andFDictionaryTypeNotEqualTo(0);
        tDictionaryExample.setOrderByClause("f_sort");
        List<TDictionary> list = dictionaryMapper.selectByExample(tDictionaryExample);
        dictMap = list.stream().collect(Collectors.groupingByConcurrent(TDictionary::getfDictionaryCode));
    }

    @Override
    protected DBInterface<TDictionary> getDao() {
        return dictionaryMapper;
    }

    /**
     * 根据顶级字典(字典分类)
     *
     * @return 字典分类list
     */
    @Override
    public List<TDictionary> selectDictCategory() {
        TDictionaryExample tDictionaryExample = new TDictionaryExample();
        tDictionaryExample.createCriteria()
                .andFDeleteFlagEqualTo(false)
                .andFDictionaryTypeEqualTo(0);
        tDictionaryExample.setOrderByClause("f_sort");
        return dictionaryMapper.selectByExample(tDictionaryExample);
    }

    /**
     * 批量删除字典数据
     *
     * @param dictIdList 字典d列表
     * @return 删除的记录数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatch(List<Integer> dictIdList) {
        int result = 0;
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        for (Integer dictId : dictIdList) {
            TDictionary tDictionary = new TDictionary();
            tDictionary.setfDeleteFlag(true);
            tDictionary.setfId(dictId);
            tDictionary.setfUpdateTime(time);
            tDictionary.setfOperatorId(sessionUser.getfId());
            result = result + dictionaryMapper.updateByPrimaryKeySelective(tDictionary);
        }
        insertLog(OperationLogTypeEnum.DELETE, "删除基础数据", "删除了" + result + "条记录");
        if (result > 0) {
            loadDictMap();
        }
        return result;
    }

    @Override
    public List<TDictionary> selectList() {
        TDictionaryExample example = new TDictionaryExample();
        example.createCriteria()
                .andFDictionaryCodeIsNotNull()
                .andFDeleteFlagEqualTo(false)
                .andFDictionaryTypeNotEqualTo(0);
        example.setOrderByClause("f_sort");
        return dictionaryMapper.selectByExample(example);
    }

    /**
     * 保存字典
     *
     * @param tDictionary 字典
     * @return 保存结果(影响的行数是否 > 0)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(TDictionary tDictionary) {
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        int result;
        if (tDictionary.getfId() != null) {
            tDictionary.setfOperatorId(sessionUser.getfId());
            tDictionary.setfUpdateTime(time);
            result = dictionaryMapper.updateByPrimaryKeySelective(tDictionary);
            insertLog(OperationLogTypeEnum.UPDATE, "修改基础数据", result > 0 ? "成功" : "失败");
        } else {
            tDictionary.setfCreatorId(sessionUser.getfId());
            tDictionary.setfCreateTime(time);
            tDictionary.setfDeleteFlag(false);
            result = dictionaryMapper.insert(tDictionary);
            insertLog(OperationLogTypeEnum.INSERT, "新增基础数据", result > 0 ? "成功" : "失败");
        }
        if (result > 0) {
            loadDictMap();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查询所有没有用到的基本PID
     * @param param [参数usedPidList: 已经使用的PID以逗号隔开的字符串]
     * @return
     */
	@Override
	public List<TDictionary> selectPidList(Map<String, Object> param) {
		return dictionaryExtMapper.selectPidList(param);
	}

	@Override
	public String getThirdCodeById(Integer fId) {
		return dictionaryExtMapper.getThirdCodeById(fId);
	}

	@Override
	public List<Integer> selectAdapterOrSoundDeviceIds(String type) {
		return dictionaryExtMapper.selectAdapterOrSoundDeviceIds(type);
	}

}
