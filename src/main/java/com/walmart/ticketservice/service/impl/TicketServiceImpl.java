package com.walmart.ticketservice.service.impl;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.walmart.ticketservice.dao.TicketDAO;
import com.walmart.ticketservice.model.SeatHold;
import com.walmart.ticketservice.service.TicketService;
import com.walmart.ticketservice.util.ExpireHoldSeatsReserved;

@Named
public class TicketServiceImpl implements TicketService {

    @Inject
    private TicketDAO ticketDAO;

    @Inject
    @Named("executorService")
    private ScheduledExecutorService executorService;

    @Value("${hold-seats-ttl}")
    private int ttl;

    /**
     * The number of seats in the venue that are neither held nor reserved
     *
     * @return the number of tickets available in the venue
     */
    public int numSeatsAvailable() {
        return ticketDAO.numSeatsAvailable();
    }

    /**
     * Find and hold the best available seats for a customer
     *
     * @param numSeats the number of seats to find and hold
     * @param customerEmail unique identifier for the customer
     * @return a SeatHold object identifying the specific seats and related information
     */
    public SeatHold findAndHoldSeats(final int numSeats, final String customerEmail) {
        final SeatHold seatHold = ticketDAO.findAndHoldSeats(numSeats, customerEmail);
        executorService.schedule(new ExpireHoldSeatsReserved(ticketDAO, seatHold.getSeatHoldId()), ttl,
                TimeUnit.MINUTES);
        return seatHold;
    }

    /**
     * Commit seats held for a specific customer
     *
     * @param seatHoldId the seat hold identifier
     * @param customerEmail the email address of the customer to which the seat hold is assigned
     * @return a reservation confirmation code
     */
    public String reserveSeats(final int seatHoldId, final String customerEmail) {
        return ticketDAO.reserveSeats(seatHoldId, customerEmail);
    }
}