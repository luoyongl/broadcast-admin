package cn.wtu.broadcast.openapi.vo;

import cn.wtu.broadcast.openapi.model.TRole;
import cn.wtu.broadcast.parent.pojo.ZTree;

import java.io.Serializable;
import java.util.List;

/**
 * 包含权限ztree的角色信息
 *
 * @author sueua
 * @since 2018-12-16
 */
public class RoleVo extends TRole implements Serializable{

    private static final long serialVersionUID = 5603636679419168488L;

    /**
     * 权限ztree
     */
    private List<ZTree> permissions;

    public List<ZTree> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<ZTree> permissions) {
        this.permissions = permissions;
    }

}
