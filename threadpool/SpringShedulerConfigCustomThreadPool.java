package com.example.schedulerdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

// configuring Spring to use your own thread pool instead of the default one.

@EnableScheduling
@Configuration
public class SpringShedulerConfigCustomThreadPool implements SchedulingConfigurer {
    private final int POOL_SIZE = 10;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // create custom threadPool
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

        threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix("my-scheduled-task-pool-");
        threadPoolTaskScheduler.initialize();

        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
        
        // Trigger task every few seconds
    /*     taskRegistrar.addTriggerTask(
            /*  Iterate over all the jobs that need to be process
             *  1) The retry count must be below or equal to the threshold 'dispatchAgentRequestQueue.getRetryLimit()
             *      If the retry is '0', then '1' call needs to be processes to EMMA. Therefore, the equal threshold.
             *  2) Jobs need to be process after they have exceeded the request threshold 'dispatchAgentRequestQueue.getTimeInMin()'
            */
            () -> {
                LocalDateTime localDateTime = LocalDateTime.now();
                Lists.newArrayList(agentRequestRepo.findAll())
                .parallelStream()
                .filter(r -> r.getRetryCount() <= dispatchAgentRequestQueue.getDefaultedRetryLimit())
                .filter(r -> MINUTES.between(r.getRequestedOn(),localDateTime) > dispatchAgentRequestQueue.getDefaultedRetryTimeInMin())
                .forEach(this::safeOverrideEntity);
            }
            //  Execute this thread after 'x' amount of minutes
            ,
            (TriggerContext triggerContext) -> {
                Calendar nextExecutionTime =  new GregorianCalendar();
                Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
                nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
                nextExecutionTime.add(Calendar.MINUTE, dispatchAgentRequestQueue.getDefaultedRetryTimeInMin());
                return nextExecutionTime.getTime();
            }
        );
        */
    }
}
