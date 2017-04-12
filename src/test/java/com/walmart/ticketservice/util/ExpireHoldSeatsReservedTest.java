package com.walmart.ticketservice.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.walmart.ticketservice.dao.TicketDAO;

public class ExpireHoldSeatsReservedTest {

    private TicketDAO ticketDAO;

    private ExpireHoldSeatsReserved expireHoldSeatsReserved;

    @Before
    public void init() {
        ticketDAO = mock(TicketDAO.class);
        expireHoldSeatsReserved = new ExpireHoldSeatsReserved(ticketDAO, 1234);
    }

    @Test
    public void call() throws Exception {
        doNothing().when(ticketDAO).removeExpiredSeats(1234);
        assertEquals(Boolean.TRUE, expireHoldSeatsReserved.call());
    }
}