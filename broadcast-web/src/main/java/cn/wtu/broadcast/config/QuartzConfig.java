package cn.wtu.broadcast.config;

import cn.wtu.broadcast.support.quartz.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;

/**
 * Quartz配置
 *
 * @author sueua
 * @since 2019-01-10
 */
@Configuration
public class QuartzConfig {

    private final DataSource dataSource;

    private final JobFactory jobFactory;

    @Autowired
    public QuartzConfig(DataSource dataSource, JobFactory jobFactory) {
        this.dataSource = dataSource;
        this.jobFactory = jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(dataSource);
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setSchedulerName("broadcast_schedule");
        return schedulerFactoryBean;
    }
}
