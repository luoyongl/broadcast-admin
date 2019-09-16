package cn.wtu.broadcast.support.quartz;

import cn.wtu.broadcast.openapi.api.DatabaseService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 數據庫備份job
 *
 * @author sueua
 * @date 2019/1/17
 */
public class BackupJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(BackupJob.class);

    @Autowired
    private DatabaseService databaseService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("自动备份数据库");
        databaseService.backup();
    }
}
