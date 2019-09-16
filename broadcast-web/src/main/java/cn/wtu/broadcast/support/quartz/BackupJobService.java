package cn.wtu.broadcast.support.quartz;

import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * 自动备份数据service
 *
 * @author sueua
 * @date 2019/1/17
 */
@Component
public class BackupJobService {

    private static final Logger logger = LoggerFactory.getLogger(BackupJobService.class);

    private final String jobKey = "auto_backup";

    private final SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    public BackupJobService(SchedulerFactoryBean schedulerFactoryBean) {
        this.schedulerFactoryBean = schedulerFactoryBean;
    }

    /**
     * 创建自动备份任务
     */
    public void createJob(String cron) {
        if (StringUtils.isNotBlank(cron)) {
            removeJob();
            logger.info("添加自动备份任务");
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobDetail jobDetail = JobBuilder
                    .newJob(BackupJob.class)
                    .withIdentity(jobKey, jobKey)
                    .build();
            //触发器
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .startNow()
                    .withIdentity(jobKey, jobKey)
                    .withSchedule(CronScheduleBuilder
                            .cronSchedule(cron)
                            //错过时间不重试
                            .withMisfireHandlingInstructionDoNothing())
                    .build();
            try {
                scheduler.scheduleJob(jobDetail, trigger);
            } catch (SchedulerException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * 删除自动备份任务
     */
    public void removeJob() {
        logger.info("移除自动备份任务");
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = new TriggerKey(this.jobKey, this.jobKey);
        JobKey jobKey = new JobKey(this.jobKey, this.jobKey);
        try {
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            logger.info(e.getMessage(), e);
        }
    }
}
