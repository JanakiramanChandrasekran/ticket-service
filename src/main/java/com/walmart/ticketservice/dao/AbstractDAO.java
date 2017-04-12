package com.walmart.ticketservice.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.tuple.Pair;

import com.walmart.ticketservice.constants.Constants;
import com.walmart.ticketservice.constants.VenueLevelSeatsEnum;
import com.walmart.ticketservice.model.SeatHold;
import com.walmart.ticketservice.util.CommonUtility;

public abstract class AbstractDAO {

    private final AtomicInteger availableSeatsCount = new AtomicInteger();

    private final Map<Integer, Pair<String, List<String>>> blockedSeats = new ConcurrentHashMap<>();

    private final Random random = new Random();

    private final List<String> availableSeats = new ArrayList<String>() {
        /**
         * 
         */
        private static final long serialVersionUID = 3686537755363896789L;

        {
            Arrays.stream(VenueLevelSeatsEnum.values()).forEach(venueEnum -> {
                IntStream.range(0, venueEnum.totalRows.get()).forEach(row -> {
                    IntStream.range(0, venueEnum.supplySeatsPerRow.get()).forEach(seat -> {
                        add(new StringBuilder(venueEnum.supplyLevelName.get()).append(Constants.ROW_MAPPING.charAt(row))
                                .append('-').append(seat).toString());
                    });
                });
            });
        }
    };

    /**
     * Update the available seats
     * 
     */
    protected void updateSeatCount() {
        availableSeatsCount.set(availableSeats.size());
    }

    /**
     * Return the atomic value of available seats
     * 
     * @return
     */
    protected int getAvailableSeats() {
        return availableSeatsCount.get();
    }

    /**
     * Block the seats and return
     * 
     * @param numSeats
     * @return
     */
    private synchronized List<String> blockSeats(final int numSeats) {
        final List<String> holdSeats = IntStream.range(0, numSeats).map(i -> 0)
                .mapToObj(index -> availableSeats.remove(index)).collect(Collectors.toList());
        updateSeatCount();
        return holdSeats;
    }

    /**
     * Release the seats for use
     * 
     * @param numSeats
     * @return
     */
    private synchronized void releaseSeats(final List<String> holdSeats) {
        holdSeats.stream().forEach(value -> availableSeats.add(0, value));
        updateSeatCount();
    }

    /**
     * Hold the seats and get back
     * 
     * @param numSeats
     * @param customerEmail
     * @return
     */
    protected SeatHold holdSeats(final int numSeats, final String customerEmail) {
        final List<String> holdSeats = blockSeats(numSeats);
        final SeatHold seatHold = new SeatHold();
        seatHold.setSeats(holdSeats.toString());
        seatHold.setSeatHoldId(random.nextInt(Integer.MAX_VALUE));
        blockedSeats.put(seatHold.getSeatHoldId(), Pair.of(customerEmail, holdSeats));
        return seatHold;
    }

    /**
     * Validate the blocked seats and make reservation
     * 
     * @param seatHoldId
     * @param customerEmail
     */
    protected void validateSeatCustomerEmailHold(final int seatHoldId, final String customerEmail) {
        final Pair<String, List<String>> blockedSeatsPair = blockedSeats.get(seatHoldId);
        if (blockedSeatsPair == null) {
            CommonUtility.invalidSeatHold(seatHoldId);
        } else if (!blockedSeatsPair.getLeft().equals(customerEmail)) {
            CommonUtility.invalidEmail(seatHoldId, customerEmail);
        }
    }

    /**
     * Reserve the hold seats and return
     * 
     * @param seatHoldId
     * @return
     */
    protected String reserveSeats(final int seatHoldId) {
        blockedSeats.remove(seatHoldId);
        return UUID.randomUUID().toString();
    }

    /**
     * Make the blocked seats available to other customers
     * 
     * @param SeatHoldId
     */
    protected void validateAndReleaseSeats(final int seatHoldId) {
        final Pair<String, List<String>> blockedSeatsPair = blockedSeats.remove(seatHoldId);
        if (blockedSeatsPair != null) {
            blockedSeats.remove(seatHoldId);
            releaseSeats(blockedSeatsPair.getRight());
        }
    }
}