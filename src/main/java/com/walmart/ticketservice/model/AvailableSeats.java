package com.walmart.ticketservice.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AvailableSeats implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2995938001790267377L;

    private final int numSeatsAvailable;

    public AvailableSeats(final int numSeatsAvailable) {
        this.numSeatsAvailable = numSeatsAvailable;
    }

    /**
     * @return the numSeatsAvailable
     */
    public int getNumSeatsAvailable() {
        return numSeatsAvailable;
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