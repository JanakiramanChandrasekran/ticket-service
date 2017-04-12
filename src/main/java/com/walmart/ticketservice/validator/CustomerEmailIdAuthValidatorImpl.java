package com.walmart.ticketservice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.walmart.ticketservice.constants.Constants;

/**
 * to authenticate & authorize the customer email address
 * 
 */
public class CustomerEmailIdAuthValidatorImpl implements ConstraintValidator<CustomerEmailIdAuthValidator, String> {

    /**
     * Initialize the validator with the parameters set in the bean class
     * 
     */
    public void initialize(final CustomerEmailIdAuthValidator validator) {
    }

    /**
     * Implement the isValid
     * 
     */
    public boolean isValid(final String customerEmail, final ConstraintValidatorContext context) {
        return Constants.AUTHORIZED_USERS.getOrDefault(customerEmail, Boolean.FALSE);
    }
}