package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.ResourceService;
import cn.wtu.broadcast.openapi.dao.TResourceMapper;
import cn.wtu.broadcast.openapi.dao.extend.TResourceExtMapper;
import cn.wtu.broadcast.openapi.model.TResource;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.pojo.ZTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源service接口实现类
 *
 * @author sueua
 * @since 2018-12-16
 */
@Service("resourceService")
public class ResourceServiceImpl extends ParentServiceImpl<TResource> implements ResourceService {

    private final TResourceMapper tResourceMapper;

    private final TResourceExtMapper tResourceExtMapper;

    @Autowired
    public ResourceServiceImpl(TResourceMapper tResourceMapper, TResourceExtMapper tResourceExtMapper) {
        this.tResourceMapper = tResourceMapper;
        this.tResourceExtMapper = tResourceExtMapper;
    }

    /**
     * 获取数据操作实例,不能为空,子类必须实现该方法
     */
    @Override
    protected DBInterface<TResource> getDao() {
        return tResourceMapper;
    }

    /**
     * 查询所有资源且已ztree simple模式显示数据
     *
     * @return 所有资源的ztree
     */
    @Override
    public List<ZTree> listAllResource2Ztree() {
        return tResourceExtMapper.listAllResource2Ztree();
    }
}
