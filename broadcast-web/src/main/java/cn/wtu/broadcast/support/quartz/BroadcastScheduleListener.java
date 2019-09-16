package cn.wtu.broadcast.support.quartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * quartz trigger监听器,主要用于移除日历
 *
 * @author sueua
 * @since 2019-01-13
 */
public class BroadcastScheduleListener implements SchedulerListener {

    private static Logger logger = LoggerFactory.getLogger(BroadcastScheduleListener.class);

    private Scheduler scheduler;

    public BroadcastScheduleListener(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void jobScheduled(Trigger trigger) {

    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {

    }

    @Override
    public void triggerFinalized(Trigger trigger) {
        TriggerKey triggerKey = trigger.getKey();
        if(ScheduleBroadcastJobService.TRIGGER_GROUP_NAME.equals(triggerKey.getGroup())){
            String triggerName = triggerKey.getName();
            Integer broadcastId = null;
            try {
                broadcastId = Integer.valueOf(triggerName.replace(ScheduleBroadcastJobService.TRIGGER_NAME_PREFIX, ""));
            } catch (NumberFormatException e) {
                logger.info(e.getMessage());
            }
            logger.info(triggerName + " was complete");
            logger.info("定时广播触发器Id-{}结束", broadcastId);
            if (scheduler != null && broadcastId != null) {
                try {
                    scheduler.deleteCalendar(ScheduleBroadcastJobService.TIME_CALENDAR_NAME_PREFIX + broadcastId);
                    scheduler.deleteCalendar(ScheduleBroadcastJobService.WEEK_CALENDAR_NAME_PREFIX + broadcastId);
                } catch (SchedulerException e) {
                    logger.info(e.getMessage());
                }
            }
        }
    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {

    }

    @Override
    public void triggersPaused(String triggerGroup) {

    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {

    }

    @Override
    public void triggersResumed(String triggerGroup) {

    }

    @Override
    public void jobAdded(JobDetail jobDetail) {

    }

    @Override
    public void jobDeleted(JobKey jobKey) {

    }

    @Override
    public void jobPaused(JobKey jobKey) {

    }

    @Override
    public void jobsPaused(String jobGroup) {

    }

    @Override
    public void jobResumed(JobKey jobKey) {

    }

    @Override
    public void jobsResumed(String jobGroup) {

    }

    @Override
    public void schedulerError(String msg, SchedulerException cause) {

    }

    @Override
    public void schedulerInStandbyMode() {

    }

    @Override
    public void schedulerStarted() {

    }

    @Override
    public void schedulerStarting() {

    }

    @Override
    public void schedulerShutdown() {

    }

    @Override
    public void schedulerShuttingdown() {

    }

    @Override
    public void schedulingDataCleared() {

    }
}
