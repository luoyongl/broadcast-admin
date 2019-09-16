package cn.wtu.broadcast.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.ResourceService;
import cn.wtu.broadcast.openapi.api.RoleService;
import cn.wtu.broadcast.openapi.model.TRole;
import cn.wtu.broadcast.openapi.vo.RoleVo;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;

/**
 * 角色控制器
 * @author sueua
 * @since 2018-12-16
 */
@Controller
@RequestMapping("systemManage/role")
public class RoleController extends BaseController {

    private final RoleService roleService;

    private final ResourceService resourceService;

    @Autowired
    public RoleController(RoleService roleService, ResourceService resourceService) {
        this.roleService = roleService;
        this.resourceService = resourceService;
    }

    /**
     * 角色页面
     */
    @GetMapping
    public String ui(Model model) {
        model.addAttribute("resources", JSONUtils.toString(resourceService.listAllResource2Ztree()));
        return "systemManage/role";
    }

    /**
     * 保存角色
     *
     * @param tRole          角色
     * @param resourceIdList 角色的权限id列表
     */
    @PostMapping
    @ResponseBody
    public BroadcastResult save(TRole tRole, @RequestParam(value = "resourceId", required = false) List<Integer> resourceIdList) {
        if (roleService.save(tRole, resourceIdList)) {
            return BroadcastResult.ok();
        } else {
            return BroadcastResult.fail();
        }
    }

    /**
     * 批量删除角色
     *
     * @param roleIdList 角色id列表
     */
    @DeleteMapping
    @ResponseBody
    public BroadcastResult deleteBatch(@RequestParam(value = "roleId") List<Integer> roleIdList) {
        return BroadcastResult.build(200, "删除了" + roleService.deleteBatch(roleIdList) + "条记录");
    }

    /**
     * 角色详情
     */
    @GetMapping("{roleId}")
    @ResponseBody
    public BroadcastResult roleDetail(@PathVariable Integer roleId) {
        RoleVo roleVo = roleService.getRoleDetail(roleId);
        if (roleVo != null) {
            return BroadcastResult.ok(roleVo);
        } else {
            return BroadcastResult.fail("角色不存在");
        }
    }

    /**
     * Bootstrap Table 数据
     */
    @GetMapping("list")
    @ResponseBody
    public BroadcastResult roleList(@RequestParam(value = TableConst.PAGE_NO_STR, defaultValue = TableConst.PAGE_NO_DEFAULT_VALUE, required = false) Integer pageNumber,
                                    @RequestParam(value = TableConst.PAGE_SIZE_STR, defaultValue = TableConst.PAGE_SIZE_DEFAULT_VALUE, required = false) Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>(4);
        paramMap.put(TableConst.PAGE_NO_STR, pageNumber);
        paramMap.put(TableConst.PAGE_SIZE_STR, pageSize);
        return BroadcastResult.ok(roleService.queryPageByParam(paramMap));
    }
}
