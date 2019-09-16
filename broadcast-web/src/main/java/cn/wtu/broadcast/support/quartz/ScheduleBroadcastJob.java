package cn.wtu.broadcast.support.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import cn.wtu.broadcast.openapi.api.AudioPlayService;
import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.api.DispatchHttpclientService;
import cn.wtu.broadcast.openapi.api.ScheduleService;
import cn.wtu.broadcast.openapi.api.TAdministrativeDivisionService;
import cn.wtu.broadcast.openapi.model.BBroadcastTiming;
import cn.wtu.broadcast.parent.enums.BroadcastTypeEnum;

/**
 * 定时广播job
 *
 * @author sueua
 * @since 2019-01-10
 */
public class ScheduleBroadcastJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleBroadcastJob.class);

	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private BBroadcastDataService bBroadcastDataService;
	@Autowired
	private DispatchHttpclientService dispatchHttpclientService;
	@Autowired
	private AudioPlayService audioPlayService;
	@Autowired
	private TAdministrativeDivisionService tAdministrativeDivisionService;

	@Value("${dispatch.server.tomcat.port}")
	private String dispatchServerTomcatPort;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		try {
			Integer broadcastId = (Integer) jobDataMap.get(ScheduleBroadcastJobService.BROADCAST_KEY);
			logger.info("执行定时广播,Id-{}", broadcastId);
			BBroadcastTiming broadcastTiming = scheduleService.selectByPrimaryKey(broadcastId);

			// 根据简化了的区域ids查询出原来选中的所有区域id 2019-04-07 lxg
			String resourceIds = tAdministrativeDivisionService
					.getAssociationByResourceIds(broadcastTiming.getfBroadcastArea());
			// 根据广播选中的区域查询对应的设备
			audioPlayService.addDeviceByResourceIds(resourceIds, broadcastTiming.getfId(),
					BroadcastTypeEnum.timing.getCode());
			String adapterResourceCode = bBroadcastDataService.queryAdapterCode(broadcastTiming.getfControlDevice());
			dispatchHttpclientService.sendBroadcast(dispatchServerTomcatPort, BroadcastTypeEnum.timing.getCode(),
					broadcastId, adapterResourceCode);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
