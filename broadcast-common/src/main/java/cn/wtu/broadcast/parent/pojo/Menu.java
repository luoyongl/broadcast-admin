package cn.wtu.broadcast.parent.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单
 *
 * @author sueua
 * @since 2018-12-11
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = 4901405116468685369L;

    /**
     * 菜单id
     */
    private Integer menuId;

    /**
     * 父菜单id
     */
    private Integer pid;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单名称
     */
    private String menuPath;

    /**
     * 菜单图标
     */
    private String menuIco;

    /**
     * 子菜单
     */
    private List<Menu> children;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMenuIco() {
        return menuIco;
    }

    public void setMenuIco(String menuIco) {
        this.menuIco = menuIco;
    }
}
