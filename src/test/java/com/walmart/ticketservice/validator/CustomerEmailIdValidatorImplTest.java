package com.walmart.ticketservice.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerEmailIdValidatorImplTest {

    private final CustomerEmailIdAuthValidatorImpl customerEmailIdValidatorImpl = new CustomerEmailIdAuthValidatorImpl();

    @Mock
    private ConstraintValidatorContext context;

    /**
     * Test the success scenario
     */
    @Test
    public void isValidSuccess() {
        assertTrue(customerEmailIdValidatorImpl.isValid("abc1@gmail.com", context));
    }

    /**
     * Test the failure scenario
     */
    @Test
    public void isValidFail() {
        assertFalse(customerEmailIdValidatorImpl.isValid("abc11111@gmail.com", context));
    }
}
