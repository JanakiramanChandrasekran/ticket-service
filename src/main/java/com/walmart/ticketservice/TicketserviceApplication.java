package com.walmart.ticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Class, used just to simplify and run the application locally with Embedded instance of Tomcat.
 * 
 * @author Janakiraman
 */
@SpringBootApplication(scanBasePackages = {"com.walmart.ticketservice"})
public class TicketserviceApplication {
    public static void main(final String[] args) {
        SpringApplication.run(TicketserviceApplication.class, args);
    }
}
