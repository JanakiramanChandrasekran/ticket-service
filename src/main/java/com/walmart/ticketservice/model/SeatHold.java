package com.walmart.ticketservice.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * POJO to hold the Seat Hold related variables
 */
public class SeatHold implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8339520040465734002L;

    private int seatHoldId;

    private String seats;

    /**
     * @return the seatHoldId
     */
    public int getSeatHoldId() {
        return seatHoldId;
    }

    /**
     * @param seatHoldId the seatHoldId to set
     */
    public void setSeatHoldId(int seatHoldId) {
        this.seatHoldId = seatHoldId;
    }

    /**
     * @return the seats
     */
    public String getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(String seats) {
        this.seats = seats;
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    public boolean equals(Object rhs) {
        return EqualsBuilder.reflectionEquals(this, rhs, false);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}