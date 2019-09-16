package cn.wtu.broadcast.openapi.provider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Driver;

import cn.wtu.broadcast.openapi.api.DatabaseService;
import cn.wtu.broadcast.openapi.util.MysqlDb;
import cn.wtu.broadcast.parent.enums.BackupTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.utils.FormatUtil;
import cn.wtu.broadcast.parent.utils.PropertiesUtil;

/**
 * 数据库管理service接口实现
 *
 * @author sueua
 * @date 2019/1/16
 */
@Service("databaseService")
public class DatabaseServiceImpl implements DatabaseService {

    private String jdbcUrl = PropertiesUtil.getProperty("jdbc_url");

    private String jdbcUsername = PropertiesUtil.getProperty("jdbc_username", "root");

    private String jdbcPassword = PropertiesUtil.getProperty("jdbc_password", "root");

    /**
     * 备份文件目录
     */
    private String filePath = PropertiesUtil.getProperty("backup.path", "/backup/");

    /**
     * 获取备份文件
     *
     * @return 文件列表
     */
    @Override
    public List<Map<String, Object>> getFiles() {
        List<Map<String, Object>> list = new ArrayList<>();
        File folder = new File(filePath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                Map<String, Object> map = new HashMap<>(5);
                map.put("fileName", file.getName());
                map.put("fileSize", FormatUtil.formatBytes(file.length()));
                try {
                    FileTime fileTime = (FileTime) Files.getAttribute(file.toPath(), "basic:creationTime");
                    map.put("createTime", fileTime.toMillis());
                } catch (IOException ignore) {

                }
                list.add(map);
            }
        }
        //按时间倒序
        list.sort((o1, o2) -> (int) ((Long) o2.get("createTime") - (Long) o1.get("createTime")));
        return list;
    }

    /**
     * 批量删除文件
     *
     * @param fileNameList 文件名list
     * @return 删除文件数量
     */
    @Override
    public int deleteFiles(List<String> fileNameList) {
        int result = 0;
        for (String fileName : fileNameList) {
            File file = new File(filePath + fileName);
            if (file.exists()) {
                if (file.delete()) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 备份
     *
     * @return 备份结果
     */
    @Override
    public boolean backup() {
        MysqlDb mysqlDb = getMysqlDb();
        try {
            mysqlDb.backup(null, filePath);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 恢复
     *
     * @param fileName 文件名
     * @return 恢复结果
     */
    @Override
    public boolean recover(String fileName) {
        MysqlDb mysqlDb = getMysqlDb();
        try {
            mysqlDb.recover(filePath + fileName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 获取自动备份cron表达式
     *
     * @param backupTypeEnum 备份方式
     * @param backupTime     备份时间
     * @return cron表达式
     */
    @Override
    public String getBackupCron(BackupTypeEnum backupTypeEnum, Integer backupTime) {
        String cron = null;
        switch (backupTypeEnum) {
            case EVERYDAY:
                cron = "5 0 " + backupTime + " * * ?";
                break;
            case WEEKLY:
                cron = "5 0 1 ? * " + backupTime;
                break;
            case MONTHLY:
                if (LAST_DATE.equals(backupTime)) {
                    cron = "5 0 1 L * ?";
                } else {
                    cron = "5 0 1 " + backupTime + " * ?";
                }
                break;
            default:
        }
        return cron;
    }

    private MysqlDb getMysqlDb() {
        try {
            Driver driver = new Driver();
            Properties properties = driver.parseURL(jdbcUrl, null);
            String host = properties.getProperty(Driver.HOST_PROPERTY_KEY);
            String port = properties.getProperty(Driver.PORT_PROPERTY_KEY);
            String dbName = properties.getProperty(Driver.DBNAME_PROPERTY_KEY);
            return new MysqlDb(host, port, jdbcUsername, jdbcPassword, dbName);
        } catch (SQLException e) {
            throw new BizException("数据库配置错误");
        }
    }
}
