package com.walmart.ticketservice.dao.impl;

import javax.inject.Named;

import com.walmart.ticketservice.dao.AbstractDAO;
import com.walmart.ticketservice.dao.TicketDAO;
import com.walmart.ticketservice.model.SeatHold;
import com.walmart.ticketservice.util.CommonUtility;

/**
 * Implementation class for TicketDAO
 * 
 * AbstractTicketDAO - Some common functionalities are moved to separate abstract class which can be extended by other
 * dao implementations (Code reusability)
 * 
 * No explicit singleton as the public constructor is called only once
 */
@Named
public class TicketDAOImpl extends AbstractDAO implements TicketDAO {

    public TicketDAOImpl() {
        updateSeatCount();
    }

    /**
     * The number of seats in the venue that are neither held nor reserved
     *
     * @return the number of tickets available in the venue
     */
    public int numSeatsAvailable() {
        return getAvailableSeats();
    }

    /**
     * Find and hold the best available seats for a customer
     *
     * @param numSeats the number of seats to find and hold
     * @param customerEmail unique identifier for the customer
     * @return a SeatHold object identifying the specific seats and related information
     */
    public SeatHold findAndHoldSeats(final int numSeats, final String customerEmail) {
        if (getAvailableSeats() >= numSeats) {
            return holdSeats(numSeats, customerEmail);
        } else {
            CommonUtility.noAvailableSeats();
            return null;
        }
    }

    /**
     * Commit seats held for a specific customer
     *
     * @param seatHoldId the seat hold identifier
     * @param customerEmail the email address of the customer to which the seat hold is assigned
     * @return a reservation confirmation code
     */
    public String reserveSeats(final int seatHoldId, final String customerEmail) {
        validateSeatCustomerEmailHold(seatHoldId, customerEmail);
        return reserveSeats(seatHoldId);
    }

    /**
     * Remove the expired seats
     */
    public void removeExpiredSeats(final int seatHoldId) {
        validateAndReleaseSeats(seatHoldId);
    }
}