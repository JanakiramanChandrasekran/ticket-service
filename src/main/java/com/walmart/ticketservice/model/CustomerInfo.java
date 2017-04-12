package com.walmart.ticketservice.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.walmart.ticketservice.constants.Constants;
import com.walmart.ticketservice.validator.CustomerEmailIdAuthValidator;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -308988148085245358L;

    @Pattern(regexp = Constants.EMAIL_PATTERN, message = "Invalid Email Id")
    @CustomerEmailIdAuthValidator
    private String customerEmail;

    /**
     * @return the customerEmail
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * @param customerEmail the customerEmail to set
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
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