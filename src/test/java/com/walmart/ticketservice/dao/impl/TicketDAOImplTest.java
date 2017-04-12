package com.walmart.ticketservice.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.NotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.walmart.ticketservice.model.SeatHold;

@RunWith(MockitoJUnitRunner.class)
public class TicketDAOImplTest {

    @InjectMocks
    private TicketDAOImpl dao;

    /**
     * Validate the available seats
     */
    @Test
    public void numSeatsAvailableTest() {
        assertEquals(891, dao.numSeatsAvailable());
    }

    /**
     * Validate the best hold seats
     */
    @Test
    public void findAndHoldSeatsTest() {
        final SeatHold seatHold = dao.findAndHoldSeats(10, "abc@gmail.com");
        assertNotNull(seatHold.getSeats());
    }

    /**
     * Validate the reserve seats flow
     */
    @Test
    public void reserveSeatsTest() {
        final SeatHold seatHold = dao.findAndHoldSeats(10, "abc@gmail.com");
        assertNotNull(dao.reserveSeats(seatHold.getSeatHoldId(), "abc@gmail.com"));
    }

    /**
     * Validate the reserve seats flow with invalid email id
     */
    @Test(expected = NotFoundException.class)
    public void reserveSeatsTestInvalidEmail() {
        final SeatHold seatHold = dao.findAndHoldSeats(10, "abc@gmail.com");
        dao.reserveSeats(seatHold.getSeatHoldId(), "");
    }

    /**
     * Validate the expired seats
     */
    @Test
    public void removeExpiredSeatsTest() {
        final int count = dao.numSeatsAvailable();
        final SeatHold seatHold = dao.findAndHoldSeats(10, "abc@gmail.com");
        dao.removeExpiredSeats(seatHold.getSeatHoldId());
        assertEquals(count, dao.numSeatsAvailable());
    }
}