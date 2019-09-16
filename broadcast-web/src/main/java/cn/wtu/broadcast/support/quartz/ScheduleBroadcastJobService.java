package cn.wtu.broadcast.support.quartz;

import cn.wtu.broadcast.openapi.api.ScheduleService;
import cn.wtu.broadcast.openapi.model.BBroadcastTiming;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.quartz.impl.calendar.DailyCalendar;
import org.quartz.impl.calendar.WeeklyCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 定时广播任务管理service
 *
 * @author sueua
 * @since 2019-01-10
 */
@Component
public class ScheduleBroadcastJobService {

    /**
     * 广播标示
     */
    public static final String BROADCAST_KEY = "broadcastId";

    public static final String TIME_CALENDAR_NAME_PREFIX = "time_calendar_";

    public static final String WEEK_CALENDAR_NAME_PREFIX = "week_calendar_";

    public static final String TRIGGER_GROUP_NAME = "broadcast_trigger";

    public static final String TRIGGER_NAME_PREFIX = TRIGGER_GROUP_NAME + "_";

    private static final Logger logger = LoggerFactory.getLogger(ScheduleBroadcastJobService.class);

    private final String jobGroupName = "broadcast_job";

    private final String jobNamePrefix = jobGroupName + "_";

    private final SchedulerFactoryBean schedulerFactoryBean;

    private final ScheduleService scheduleService;

    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public ScheduleBroadcastJobService(SchedulerFactoryBean schedulerFactoryBean, ScheduleService scheduleService) {
        this.schedulerFactoryBean = schedulerFactoryBean;
        this.scheduleService = scheduleService;
    }

    /**
     * 创建定时任务
     *
     * @param broadcastId 广播id
     */
    public void createJob(Integer broadcastId) {
        if (broadcastId != null) {
            BBroadcastTiming broadcastTiming = scheduleService.selectByPrimaryKey(broadcastId);
            if (broadcastTiming != null) {
                Scheduler scheduler = schedulerFactoryBean.getScheduler();
                JobDetail jobDetail = JobBuilder
                        .newJob(ScheduleBroadcastJob.class)
                        .usingJobData(BROADCAST_KEY, broadcastId)
                        .withIdentity(jobNamePrefix + broadcastId, jobGroupName)
                        .build();
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger().withIdentity(TRIGGER_NAME_PREFIX + broadcastId, TRIGGER_GROUP_NAME);
                SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
                Date singleTime = broadcastTiming.getfSingleBroadcastTime();
                if (singleTime != null) {
                    //单次
                    triggerBuilder.startAt(singleTime);
                    //scheduleBuilder.withRepeatCount(1);
                    //scheduleBuilder.withIntervalInSeconds(10);
                } else {
                    //重复
                    Date startDate = broadcastTiming.getfStartDate();
                    Integer repeatCount = broadcastTiming.getfRepeateTime();
                    Integer intervalInSeconds = broadcastTiming.getfTimeInterval();
                    if (startDate == null || repeatCount == null || intervalInSeconds == null) {
                        logger.warn("定时广播,Id-{},参数不完整,无法执行定时任务", broadcastId);
                        return;
                    } else {
                        Date startTime = broadcastTiming.getfStartTime();
                        Date endTime = broadcastTiming.getfEndTime();
                        //时间段
                        if (startTime != null && endTime != null) {
                            DailyCalendar dailyCalendar = new DailyCalendar(timeFormat.format(startTime), timeFormat.format(endTime));
                            try {
                                scheduler.addCalendar(TIME_CALENDAR_NAME_PREFIX + broadcastId, dailyCalendar, true, true);
                            } catch (SchedulerException e) {
                                logger.error(e.getMessage());
                            }
                        }
                        //处理星期
                        String chooseWeek = broadcastTiming.getfChooseWeek();
                        if (StringUtils.isNotBlank(chooseWeek)) {
                            String[] weekStrArr = chooseWeek.split(",");
                            WeeklyCalendar weeklyCalendar = new WeeklyCalendar();
                            try {
                                for (String weekStr : weekStrArr) {
                                    weeklyCalendar.setDayExcluded(Integer.valueOf(weekStr), false);
                                }
                                scheduler.addCalendar(WEEK_CALENDAR_NAME_PREFIX + broadcastId, weeklyCalendar, true, true);
                            } catch (NumberFormatException | SchedulerException e) {
                                logger.error(e.getMessage());
                            }

                        }
                        //处理开始时间
                        if (startTime != null) {
                            try {
                                startDate = dateTimeFormat.parse(dateFormat.format(startDate) + " " + timeFormat.format(startTime));
                            } catch (ParseException e) {
                                logger.error(e.getMessage());
                            }
                        }
                        if (startDate.before(new Date())) {
                            triggerBuilder.startNow();
                        } else {
                            triggerBuilder.startAt(startDate);
                        }
                        scheduleBuilder
                                //错过时间不重试
                                .withMisfireHandlingInstructionNextWithRemainingCount()
                                .withRepeatCount(repeatCount)
                                .withIntervalInSeconds(intervalInSeconds);
                    }
                }
                //触发器
                Trigger trigger = triggerBuilder.withSchedule(scheduleBuilder).build();
                try {
                    ListenerManager listenerManager = scheduler.getListenerManager();
                    List<SchedulerListener> schedulerListeners = listenerManager.getSchedulerListeners();
                    BroadcastScheduleListener scheduleListener = new BroadcastScheduleListener(scheduler);
                    if (!schedulerListeners.contains(scheduleListener)) {
                        listenerManager.addSchedulerListener(scheduleListener);
                    }
                    scheduler.scheduleJob(jobDetail, trigger);
                } catch (SchedulerException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 删除定时任务
     *
     * @param broadcastId 广播id
     */
    public void removeJob(Integer broadcastId) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = new JobKey(jobNamePrefix + broadcastId, jobGroupName);
        TriggerKey triggerKey = new TriggerKey(TRIGGER_NAME_PREFIX + broadcastId, TRIGGER_GROUP_NAME);
        try {
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(jobKey);
            scheduler.deleteCalendar(TIME_CALENDAR_NAME_PREFIX + broadcastId);
            scheduler.deleteCalendar(WEEK_CALENDAR_NAME_PREFIX + broadcastId);
        } catch (SchedulerException e) {
            logger.info(e.getMessage(), e);
        }
    }
}
