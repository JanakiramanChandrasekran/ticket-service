package com.walmart.ticketservice.config;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class ScheduledExecutorConfigTest {

    @InjectMocks
    private ScheduledExecutorConfig config;

    @Before
    public void init() {
        ReflectionTestUtils.setField(config, "corePoolSize", 123);
    }

    /**
     * Test the positive scenario
     */
    @Test
    public void testCreateExecutorService() {
        assertFalse(config.createExecutorService().isShutdown());
    }
}