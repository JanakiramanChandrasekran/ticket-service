package com.walmart.ticketservice.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReserveInfo extends CustomerInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 2520840679276789001L;

    @Min(value = 1, message = "Invalid SeatHold Id")
    @Max(value = Integer.MAX_VALUE, message = "Invalid SeatHold Id")
    private int seatHoldId;

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