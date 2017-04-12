package com.walmart.ticketservice.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.walmart.ticketservice.dao.TicketDAO;
import com.walmart.ticketservice.model.SeatHold;
import com.walmart.ticketservice.util.ExpireHoldSeatsReserved;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceImplTest {

    @InjectMocks
    private TicketServiceImpl service;

    @Mock
    private TicketDAO dao;

    @Mock
    private ScheduledExecutorService executorService;

    @Mock
    private ScheduledFuture<Boolean> scheduledMock;

    @Before
    public void init() {
        ReflectionTestUtils.setField(service, "ttl", 2);
    }

    /**
     * Validate the num of available seats
     */
    @Test
    public void numSeatsAvailableTest() {
        when(dao.numSeatsAvailable()).thenReturn(12);
        assertEquals(12, service.numSeatsAvailable());
    }

    /**
     * Validate the findAndHoldSeats
     */
    @Test
    public void findAndHoldSeatsTest() {
        final SeatHold expected = new SeatHold();
        expected.setSeatHoldId(12345);
        when(dao.findAndHoldSeats(12, "")).thenReturn(expected);
        when(executorService.schedule(any(ExpireHoldSeatsReserved.class), any(Long.class), any(TimeUnit.class)))
                .thenReturn(scheduledMock);
        assertEquals(expected, service.findAndHoldSeats(12, ""));
    }

    /**
     * Validate Reserve Seats
     */
    @Test
    public void reserveSeats() {
        when(dao.reserveSeats(12345, "")).thenReturn("Reservation Successful");
        assertEquals("Reservation Successful", service.reserveSeats(12345, ""));
    }
}