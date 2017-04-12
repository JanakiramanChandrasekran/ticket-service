package com.walmart.ticketservice.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validator interface to authenticate & authorize the customer email address
 * 
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {CustomerEmailIdAuthValidatorImpl.class})
@Documented
public @interface CustomerEmailIdAuthValidator {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Not an Authorized user";

}