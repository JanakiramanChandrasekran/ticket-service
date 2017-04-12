package com.walmart.ticketservice.util;

import javax.ws.rs.NotFoundException;

/**
 * Common utilities used all over
 * 
 * @since 1.0
 */
public class CommonUtility {

    private CommonUtility() {
    }

    /**
     * Throw {@link NotFoundException} if the seatHoldId is not valid/reserved already/timedout
     * 
     * @param seatHoldId
     */
    public static void invalidSeatHold(final int seatHoldId) {
        throw new NotFoundException(new StringBuilder("Seat Hold Id : ").append(seatHoldId)
                .append(" is already reserved/timed out/not exists").toString());
    }

    /**
     * Throw {@link NotFoundException} if email is invalid
     * 
     * @param seatHoldId
     * @param customerEmail
     */
    public static void invalidEmail(final int seatHoldId, final String customerEmail) {
        throw new NotFoundException(new StringBuilder("Seat Hold Id : ").append(seatHoldId)
                .append(" is not blocked by user :").append(customerEmail).toString());
    }

    /**
     * Throw exception as no available seats
     */
    public static void noAvailableSeats() {
        throw new NotFoundException("No Available Seats, All seats are blocked");
    }
}