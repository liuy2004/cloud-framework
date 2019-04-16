package com.sech.framework.monitor.config;

import com.sech.framework.monitor.filter.StatusChangeNotifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class SechNotifierConfiguration {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier() {
        RemindingNotifier remindingNotifier = new RemindingNotifier(notifier());
        remindingNotifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(1));
        return remindingNotifier;
    }

    @Bean
    public StatusChangeNotifier notifier() {
        return new StatusChangeNotifier();
    }

    // 60 秒调度
    @Scheduled(fixedRate = 60_000L)
    public void remind() {
        remindingNotifier().sendReminders();
    }
}
