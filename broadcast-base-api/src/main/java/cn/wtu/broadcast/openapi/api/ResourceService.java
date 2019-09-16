package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.TResource;
import cn.wtu.broadcast.parent.pojo.ZTree;
import cn.wtu.broadcast.parent.service.api.ParentService;

import java.util.List;

/**
 * 资源service接口
 *
 * @author sueua
 * @since 2018-12-16
 */
public interface ResourceService extends ParentService<TResource> { 

    /**
     * 查询所有资源且已ztree simple模式显示数据
     * @return 所有资源的ztree
     */
    List<ZTree> listAllResource2Ztree();
}
