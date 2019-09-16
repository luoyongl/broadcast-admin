package cn.wtu.broadcast.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.wtu.broadcast.config.UserData;
import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.RegionService;
import cn.wtu.broadcast.openapi.api.RoleService;
import cn.wtu.broadcast.openapi.api.UserService;
import cn.wtu.broadcast.openapi.model.TRole;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.UserVO;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;
import cn.wtu.broadcast.support.ExcelExportStylerImpl;
import cn.wtu.broadcast.support.excel.UserVoHandler;

/**
 * 用户控制器
 *
 * @author sueua
 * @since 2018-12-29
 */
@Controller
@RequestMapping("systemManage/user")
public class UserController extends BaseController {

    private final UserService userService;

    private final RegionService regionService;

    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RegionService regionService, RoleService roleService) {
        this.userService = userService;
        this.regionService = regionService;
        this.roleService = roleService;
    }

    /**
     * 用户页面
     */
    @GetMapping
    public String ui(Model model) {
        model.addAttribute("regions", JSONUtils.toString(regionService.selectList()));
        model.addAttribute("roles", roleService.selectAll());
        return "systemManage/user";
    }

    /**
     * 保存用户
     *
     * @param tUser 用户
     */
    @PostMapping
    @ResponseBody
    public BroadcastResult save(TUser tUser, Integer roleId) {
        if (userService.save(tUser, roleId)) {
            UserData.reload();
            return BroadcastResult.ok();
        } else {
            return BroadcastResult.fail();
        }
    }

    /**
     * 重置密码
     *
     * @param userId 用户id
     */
    @PostMapping("reset")
    @ResponseBody
    public BroadcastResult save(@RequestParam Integer userId) {
        if (userService.reset(userId)) {
            return BroadcastResult.ok();
        } else {
            return BroadcastResult.fail();
        }
    }

    /**
     * 批量删除用户
     *
     * @param userIdList 用户id列表
     */
    @DeleteMapping
    @ResponseBody
    public BroadcastResult deleteBatch(@RequestParam(value = "userId") List<Integer> userIdList) {
        int num = userService.deleteBatch(userIdList);
        if (num > 0) {
            UserData.reload();
        }
        return BroadcastResult.build(200, "删除了" + num + "条记录");
    }

    /**
     * Bootstrap Table 数据
     */
    @GetMapping("list")
    @ResponseBody
    public BroadcastResult userList(@RequestParam(value = TableConst.PAGE_NO_STR, defaultValue = TableConst.PAGE_NO_DEFAULT_VALUE, required = false) Integer pageNumber,
                                    @RequestParam(value = TableConst.PAGE_SIZE_STR, defaultValue = TableConst.PAGE_SIZE_DEFAULT_VALUE, required = false) Integer pageSize,
                                    @RequestParam(value = TableConst.SEARCH_STR, required = false) String search) {
        Map<String, Object> paramMap = new HashMap<>(6);
        paramMap.put(TableConst.PAGE_NO_STR, pageNumber);
        paramMap.put(TableConst.PAGE_SIZE_STR, pageSize);
        paramMap.put(TableConst.SEARCH_STR, search);
        return BroadcastResult.ok(userService.selectList(paramMap));
    }

    /**
     * 导出
     */
    @GetMapping("export")
    public String export(Model model) {
        PageInfo<UserVO> pageInfo = userService.selectList(null);
        ExportParams params = new ExportParams(null, "用户信息", ExcelType.XSSF);
        params.setStyle(ExcelExportStylerImpl.class);
        params.setFixedTitle(false);
        params.setHeight((short) 8);
        params.setDynamicData(true);
        UserVoHandler handler = new UserVoHandler(roleService.selectAll().stream().collect(Collectors.toMap(TRole::getfId, TRole::getfRoleName)));
        handler.setNeedHandlerFields(new String[]{"创建人", "修改人", "所属区域", "角色"});
        params.setDataHandler(handler);
        model.addAttribute(NormalExcelConstants.DATA_LIST, pageInfo.getList());
        model.addAttribute(NormalExcelConstants.CLASS, UserVO.class);
        model.addAttribute(NormalExcelConstants.PARAMS, params);
        model.addAttribute(NormalExcelConstants.FILE_NAME, "用户信息");
        return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
    }
}
