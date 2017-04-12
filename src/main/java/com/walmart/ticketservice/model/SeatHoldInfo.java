package com.walmart.ticketservice.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.walmart.ticketservice.constants.Constants;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeatHoldInfo extends CustomerInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 2520840679276789001L;

    @Min(value = 1, message = "NumSeats should be greater than 1")
    @Max(value = Constants.HOLD_SEAT_LIMIT, message = "NumSeats can't be more than 33")
    private short numSeats;

    /**
     * @return the numSeats
     */
    public short getNumSeats() {
        return numSeats;
    }

    /**
     * @param numSeats the numSeats to set
     */
    public void setNumSeats(short numSeats) {
        this.numSeats = numSeats;
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