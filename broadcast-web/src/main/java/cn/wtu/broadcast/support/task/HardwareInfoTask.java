package cn.wtu.broadcast.support.task;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.wtu.broadcast.config.SystemConfig;
import cn.wtu.broadcast.openapi.api.AlarmRecordService;
import cn.wtu.broadcast.openapi.api.SystemInfoRecordService;
import cn.wtu.broadcast.openapi.model.BAlarmRecord;
import cn.wtu.broadcast.openapi.model.BSystemInfoRecord;
import cn.wtu.broadcast.parent.enums.AlarmTypeEnum;
import cn.wtu.broadcast.parent.enums.SystemInfoTypeEnum;
import cn.wtu.broadcast.util.HardwareInfoUtil;

/**
 * 硬件信息定时任务
 *
 * @author sueua
 * @since 2019-01-20
 */
@Component
public class HardwareInfoTask {

    private static final Logger log = LoggerFactory.getLogger(HardwareInfoTask.class);

    private final SystemInfoRecordService systemInfoRecordService;

    private final AlarmRecordService alarmRecordService;

    /**
     * cpu告警值配置key
     */
    private final String alarmCpuKey = "alarm_cpu_value";

    /**
     * 内存告警值配置key
     */
    private final String alarmMemoryKey = "alarm_memory_value";

    /**
     * 磁盘告警值配置key
     */
    private final String alarmDiskKey = "alarm_disk_value";

    @Autowired
    public HardwareInfoTask(SystemInfoRecordService systemInfoRecordService, AlarmRecordService alarmRecordService) {
        this.systemInfoRecordService = systemInfoRecordService;
        this.alarmRecordService = alarmRecordService;
    }

    /**
     * 采集硬件信息
     * <p>30秒采集一次数据</p>
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void gatherHardwareInfo() {
        Date createTime = new Date();
        log.info("执行采集硬件信息定时任务");
        String cpuPercentUsed = HardwareInfoUtil.getCpuPercentUsed();
        log.info("CPU使用率{}%", cpuPercentUsed);
        BSystemInfoRecord cpuInfoRecord = new BSystemInfoRecord();
        cpuInfoRecord.setfPercentUsed(cpuPercentUsed);
        cpuInfoRecord.setfInfoType(SystemInfoTypeEnum.CPU.getValue());
        cpuInfoRecord.setfCreateTime(createTime);
        cpuInfoRecord.setfDeleteFlag(false);
        systemInfoRecordService.insert(cpuInfoRecord);
        BigDecimal cpuPercentUsedValue = new BigDecimal(cpuPercentUsed);
        if (cpuPercentUsedValue.compareTo(new BigDecimal(SystemConfig.get(alarmCpuKey))) > 0) {
            BAlarmRecord alarmRecord = new BAlarmRecord();
            alarmRecord.setfAlarmType(AlarmTypeEnum.CPU.getValue());
            alarmRecord.setfAlarmDesc("CPU使用率达到" + cpuPercentUsed + "%");
            alarmRecord.setfAlarmValue(cpuPercentUsed);
            alarmRecord.setfCreateTime(createTime);
            alarmRecord.setfDeleteFlag(false);
            alarmRecordService.insert(alarmRecord);
            //todo 告警短信
        }
        log.info("每核CPU使用率{}%", HardwareInfoUtil.getCpuCoreUseRatio());
        BSystemInfoRecord memoryInfoRecord = HardwareInfoUtil.getMemoryInfo();
        String memoryPercentUsed = memoryInfoRecord.getfPercentUsed();
        log.info("内存使用率{}%", memoryPercentUsed);
        memoryInfoRecord.setfCreateTime(createTime);
        memoryInfoRecord.setfDeleteFlag(false);
        systemInfoRecordService.insert(memoryInfoRecord);
        BigDecimal memoryPercentUsedValue = new BigDecimal(memoryPercentUsed);
        if (memoryPercentUsedValue.compareTo(new BigDecimal(SystemConfig.get(alarmMemoryKey))) > 0) {
            BAlarmRecord alarmRecord = new BAlarmRecord();
            alarmRecord.setfAlarmType(AlarmTypeEnum.MEMORY.getValue());
            alarmRecord.setfAlarmDesc("内存使用率达到" + memoryPercentUsed + "%");
            alarmRecord.setfAlarmValue(memoryPercentUsed);
            alarmRecord.setfCreateTime(createTime);
            alarmRecord.setfDeleteFlag(false);
            alarmRecordService.insert(alarmRecord);
            //todo 告警短信
        }
        String diskPercentUsed = HardwareInfoUtil.getDiskPercentUsed();
        log.info("磁盘使用率{}%", diskPercentUsed);
        BigDecimal diskPercentUsedValue = new BigDecimal(diskPercentUsed);
        if (diskPercentUsedValue.compareTo(new BigDecimal(SystemConfig.get(alarmDiskKey))) > 0) {
            BAlarmRecord alarmRecord = new BAlarmRecord();
            alarmRecord.setfAlarmType(AlarmTypeEnum.DISK.getValue());
            alarmRecord.setfAlarmDesc("磁盘使用比例达到" + diskPercentUsed + "%");
            alarmRecord.setfAlarmValue(diskPercentUsed);
            alarmRecord.setfCreateTime(createTime);
            alarmRecord.setfDeleteFlag(false);
            alarmRecordService.insert(alarmRecord);
            //todo 告警短信
        }
    }
}
