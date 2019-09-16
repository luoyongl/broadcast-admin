package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * 系统配置service接口
 *
 * @author sueua
 * @date 2018/12/11
 */
public interface SystemConfigurationService extends ParentService<TSystemConfiguration> {

    /**
     * 查询全部配置
     *
     * @return 全部配置list
     */
    List<TSystemConfiguration> selectList();

    /**
     * 更新配置
     *
     * @param configMap map封装的配置信息key->f_configuration_name,value->f_configuration_value
     * @return 影响的行数
     */
    int update(Map<String, String> configMap);
    
    /**
     * 通过配置名称查询对应的值
     * @param cName
     * @return
     */
    TSystemConfiguration selectDataByCName(String cName);
}
