package cn.wtu.broadcast.openapi.api;

import java.util.List;

import cn.wtu.broadcast.openapi.model.TManufacturer;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * 厂商Service接口
 *
 * @author sueua
 * @since 2018-12-29
 */
public interface ManufacturerService extends ParentService<TManufacturer> {

    /**
     * 批量删除厂商数据
     *
     * @param manufacturerIdList 厂商d列表
     * @return 删除的记录数
     */
    int deleteBatch(List<Integer> manufacturerIdList);

    /**
     * 保存厂商
     *
     * @param tManufacturer 厂商
     * @return 保存结果(影响的行数是否 > 0)
     */
    boolean save(TManufacturer tManufacturer);
    
    /**
     * 查询厂商名称，编号,供升级文件选择
     * @author LY
     * @return 
     */
    public List<TManufacturer>selectManufacturerForUpdateFile();
}