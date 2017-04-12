package com.walmart.ticketservice.util;

import java.util.concurrent.Callable;

import com.walmart.ticketservice.dao.TicketDAO;

/**
 * Class implements the {@link Callable} for concurrent execution
 * 
 * Class will get called after 1 min from the seat is hold to validate if the hold seats are reserved
 */
public class ExpireHoldSeatsReserved implements Callable<Boolean> {

    private final TicketDAO ticketDAO;

    private final int seatHoldId;

    /**
     * Constructor receives the input needed to do validation
     * 
     * @param ticketService
     */
    public ExpireHoldSeatsReserved(final TicketDAO ticketDAO, final int seatHoldId) {
        this.ticketDAO = ticketDAO;
        this.seatHoldId = seatHoldId;
    }

    /**
     * If the hold seats are not reserved within 1 minute from the time of hold, seats will be released for next
     * bookings
     * 
     * @return true/false
     * @throws Exception
     */
    public Boolean call() throws Exception {
        ticketDAO.removeExpiredSeats(seatHoldId);
        return Boolean.TRUE;
    }
}