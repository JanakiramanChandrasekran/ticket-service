package com.walmart.ticketservice.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduledExecutorConfig {

    @Value("${primary.core-thread-pool-size}")
    private int corePoolSize;

    /**
     * Create the ScheduledExecutorService with the given thread pool size
     * 
     * @return
     */
    @Bean(name = "executorService")
    public ScheduledExecutorService createExecutorService() {
        return Executors.newScheduledThreadPool(corePoolSize);
    }
}
