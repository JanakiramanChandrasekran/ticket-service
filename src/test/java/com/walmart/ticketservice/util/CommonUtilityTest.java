package com.walmart.ticketservice.util;

import javax.ws.rs.NotFoundException;

import org.junit.Test;

public class CommonUtilityTest {

    /**
     * Throw as seathold id not exists
     */
    @Test(expected = NotFoundException.class)
    public void invalidSeatHoldTest() {
        CommonUtility.invalidSeatHold(1234);
    }

    /**
     * Throw as invalid email mapped to seatHoldId
     */
    @Test(expected = NotFoundException.class)
    public void invalidEmailTest() {
        CommonUtility.invalidEmail(12345, "test.com");
    }
}