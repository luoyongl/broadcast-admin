package cn.wtu.broadcast.support.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * quartz job factory
 *
 * @author sueua
 * @since 2019-01-10
 */
@Component
public class JobFactory extends AdaptableJobFactory {

    private final AutowireCapableBeanFactory capableBeanFactory;

    @Autowired
    public JobFactory(AutowireCapableBeanFactory capableBeanFactory) {
        this.capableBeanFactory = capableBeanFactory;
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        //将spring管理的对象注入到job中.
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
