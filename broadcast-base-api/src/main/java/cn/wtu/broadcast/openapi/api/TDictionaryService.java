package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.parent.service.api.ParentService;

import java.util.List;
import java.util.Map;

/**
 * 数据字典service接口
 *
 * @author lxg
 * @date 2018/12/16
 */
public interface TDictionaryService extends ParentService<TDictionary> {

    List<TDictionary> selectList();

    /**
     * 根据条件查询部分字典数据
     *
     * @param criteria 查询条件,即f_dictionary_code
     * @return 部分字典数据list
     */
    List<TDictionary> selectListByCriteria(String criteria);

    /**
     * 根据顶级字典(字典分类)
     *
     * @return 字典分类list
     */
    List<TDictionary> selectDictCategory();

    /**
     * 批量删除字典数据
     *
     * @param dictIdList 字典d列表
     * @return 删除的记录数
     */
    int deleteBatch(List<Integer> dictIdList);

    /**
     * 保存字典
     *
     * @param tDictionary 字典
     * @return 保存结果(影响的行数是否 > 0)
     */
    boolean save(TDictionary tDictionary);
    
    /**
     * 查询所有没有用到的基本PID
     * @param param [参数usedPidList: 已经使用的PID以逗号隔开的字符串]
     * @return
     */
    List<TDictionary> selectPidList(Map<String, Object> param);
    
    String getThirdCodeById(Integer fId);

	List<Integer> selectAdapterOrSoundDeviceIds(String type);

}
