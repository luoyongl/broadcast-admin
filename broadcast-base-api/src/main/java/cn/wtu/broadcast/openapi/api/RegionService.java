package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.openapi.vo.RegionVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

import java.util.List;

/**
 * 行政区域service接口
 *
 * @author sueua
 * @since 2018-12-22
 */
public interface RegionService extends ParentService<TAdministrativeDivision> {

    /**
     * 初始化行政区域
     *
     * @return 成功或失败
     */
    boolean init();

    /**
     * 查询所有区域
     *
     * @return 全部区域list
     */
    List<TAdministrativeDivision> selectList();

    /**
     * 保存区域
     *
     * @param tAdministrativeDivision 行政区域
     * @return 影响的行数
     */
    boolean save(TAdministrativeDivision tAdministrativeDivision);

    /**
     * 批量删除行政区域
     *
     * @param regionIdList 行政区域列表
     * @return 删除的记录数
     */
    int deleteBatch(List<Integer> regionIdList);

    /**
     * 导入数据
     *
     * @param list list数据
     * @return 导入结果
     */
    boolean importData(List<RegionVO> list);
}
