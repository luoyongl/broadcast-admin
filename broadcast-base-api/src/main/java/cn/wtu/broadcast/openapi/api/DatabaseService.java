package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.parent.enums.BackupTypeEnum;

/**
 * 数据库管理service接口
 *
 * @author sueua
 * @date 2019/1/16
 */
public interface DatabaseService {

    /**
     * 每月最后一天标示
     */
    Integer LAST_DATE = 32;

    /**
     * 获取备份文件
     *
     * @return 文件列表
     */
    List<Map<String, Object>> getFiles();

    /**
     * 批量删除文件
     *
     * @param fileNameList 文件名list
     * @return 删除文件数量
     */
    int deleteFiles(List<String> fileNameList);

    /**
     * 备份
     *
     * @return 备份结果
     */
    boolean backup();

    /**
     * 恢复
     *
     * @param fileName 文件名
     * @return 恢复结果
     */
    boolean recover(String fileName);

    /**
     * 获取自动备份cron表达式
     *
     * @param backupTypeEnum 备份方式
     * @param backupTime     备份时间
     * @return cron表达式
     */
    String getBackupCron(BackupTypeEnum backupTypeEnum, Integer backupTime);
}
