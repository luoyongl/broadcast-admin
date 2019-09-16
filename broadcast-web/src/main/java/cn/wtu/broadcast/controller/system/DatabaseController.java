package cn.wtu.broadcast.controller.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.config.SystemConfig;
import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.DatabaseService;
import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.parent.enums.BackupTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.json.JSONUtils;
import cn.wtu.broadcast.support.quartz.BackupJobService;

/**
 * 数据库管理控制器
 *
 * @author sueua
 * @since 2019-01-15
 */
@Controller
@RequestMapping("/systemManage/database")
public class DatabaseController extends BaseController {

    private final DatabaseService databaseService;

    private final SystemConfigurationService systemConfigurationService;

    private final BackupJobService backupJobService;

    @Autowired
    public DatabaseController(DatabaseService databaseService, SystemConfigurationService systemConfigurationService, BackupJobService backupJobService) {
        this.databaseService = databaseService;
        this.systemConfigurationService = systemConfigurationService;
        this.backupJobService = backupJobService;
    }

    /**
     * 数据库管理页
     */
    @GetMapping
    public String ui(Model model) {
        BackupTypeEnum[] backupTypeEnums = BackupTypeEnum.values();
        Map<Integer, BackupTypeEnum> backupTypeMap = Arrays.stream(backupTypeEnums).collect(Collectors.toMap(BackupTypeEnum::getValue, Function.identity()));
        model.addAttribute("backupTypeMap", JSONUtils.toString(backupTypeMap));
        model.addAttribute("backupTypeEnums", backupTypeEnums);
        model.addAttribute("lastDate", DatabaseService.LAST_DATE);
        return "systemManage/database";
    }

    /**
     * 数据库管理页
     */
    @GetMapping("files")
    @ResponseBody
    public BroadcastResult getFiles() {
        return BroadcastResult.ok(databaseService.getFiles());
    }

    /**
     * 删除文件
     */
    @DeleteMapping
    @ResponseBody
    public BroadcastResult deleteFiles(@RequestParam("fileName") List<String> fileNameList) {
        return BroadcastResult.ok(databaseService.deleteFiles(fileNameList));
    }

    /**
     * 手动执行备份
     */
    @PostMapping
    @ResponseBody
    public BroadcastResult backup() {
        if (databaseService.backup()) {
            return BroadcastResult.ok();
        } else {
            return BroadcastResult.fail("备份失败");
        }
    }

    /**
     * 恢复
     */
    @PostMapping("recover")
    @ResponseBody
    public BroadcastResult recover(String fileName) {
        if (databaseService.recover(fileName)) {
            return BroadcastResult.ok();
        } else {
            return BroadcastResult.fail("恢复失败");
        }
    }

    /**
     * 保存自动备份配置
     *
     * @param autoBackup 是否开启自动备份
     * @param backupType 自动配置类型,日/周/月
     * @param backupTime 备份时间,几点/周几/几号
     * @return 结果
     */
    @PutMapping
    @ResponseBody
    public BroadcastResult config(@RequestParam Boolean autoBackup,
                                  @RequestParam BackupTypeEnum backupType,
                                  @RequestParam Integer backupTime) {
        Map<String, String> map = new HashMap<>(5);
        map.put("backup_auto", autoBackup ? "1" : "0");
        map.put("backup_type", backupType.getValue() + "");
        map.put("backup_time", backupTime + "");
        int num = systemConfigurationService.update(map);
        if (num > 0) {
            //重新刷新配置
            SystemConfig.reload();
            if (autoBackup) {
                backupJobService.createJob(databaseService.getBackupCron(backupType, backupTime));
            } else {
                backupJobService.removeJob();
            }
            return BroadcastResult.ok();
        } else {
            return BroadcastResult.fail();
        }
    }
}
