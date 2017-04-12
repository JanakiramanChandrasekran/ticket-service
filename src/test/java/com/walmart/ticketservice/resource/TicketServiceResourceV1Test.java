package com.walmart.ticketservice.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.walmart.ticketservice.model.ReserveInfo;
import com.walmart.ticketservice.model.SeatHold;
import com.walmart.ticketservice.model.SeatHoldInfo;
import com.walmart.ticketservice.service.TicketService;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceResourceV1Test {

    @InjectMocks
    private TicketServiceResourceV1 resource;

    @Mock
    private TicketService service;

    /**
     * Resource to get number of available seats
     */
    @Test
    public void numSeatsAvailableTest() {
        when(service.numSeatsAvailable()).thenReturn(12);
        assertEquals(12, resource.numSeatsAvailable());
    }

    /**
     * Test to hold the best available seats
     */
    @Test
    public void findAndHoldSeatsTest() {
        final SeatHold seatHold = new SeatHold();
        seatHold.setSeatHoldId(12345);
        when(service.findAndHoldSeats(12, "")).thenReturn(seatHold);
        final SeatHoldInfo info = new SeatHoldInfo();
        info.setNumSeats(Short.valueOf("12"));
        info.setCustomerEmail("");
        assertEquals(seatHold, resource.findAndHoldSeats(info));
    }

    /**
     * Test the reserve seats scenario
     */
    @Test
    public void reserveSeatsTest() {
        final ReserveInfo info = new ReserveInfo();
        info.setSeatHoldId(12345);
        info.setCustomerEmail("");
        when(service.reserveSeats(12345, "")).thenReturn("Reservation Successful");
        assertEquals("Reservation Successful", resource.reserveSeats(info));
    }
}