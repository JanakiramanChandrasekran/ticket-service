package com.walmart.ticketservice.resource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.ticketservice.model.ReserveInfo;
import com.walmart.ticketservice.model.SeatHold;
import com.walmart.ticketservice.model.SeatHoldInfo;
import com.walmart.ticketservice.service.TicketService;

@Named
@Singleton
@RestController
@RequestMapping("/ticket-service")
public class TicketServiceResourceV1 {

    @Inject
    private TicketService ticketService;

    /**
     * Resource to retrieve the seats available
     * 
     * @return
     */
    @RequestMapping(path = "/available-seats", method = RequestMethod.GET)
    public @ResponseBody int numSeatsAvailable() {
        return ticketService.numSeatsAvailable();
    }

    /**
     * Find and block the best available seats
     * 
     * @param seatHoldInfo
     * @return
     */
    @RequestMapping(path = "/hold-seats", method = RequestMethod.POST)
    public @ResponseBody SeatHold findAndHoldSeats(@RequestBody @Valid final SeatHoldInfo seatHoldInfo) {
        return ticketService.findAndHoldSeats(seatHoldInfo.getNumSeats(), seatHoldInfo.getCustomerEmail());
    }

    /**
     * Reserve the blocked seats for given seatHoldId
     * 
     * @param reserveInfo
     * @return
     */
    @RequestMapping(path = "/reserve-seats", method = RequestMethod.POST)
    public @ResponseBody String reserveSeats(@RequestBody @Valid final ReserveInfo reserveInfo) {
        return ticketService.reserveSeats(reserveInfo.getSeatHoldId(), reserveInfo.getCustomerEmail());
    }
}