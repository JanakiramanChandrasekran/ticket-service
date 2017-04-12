# About
	TicketService is Project to provide services to Hold, Reserve the tickets for particual Venue

# Installation and Execution
	Download the Project, Copy to a location and call below services ., 

	java -jar ticket-service-0.0.1-SNAPSHOT.jar

# Project Dependeices

	Java 1.8
	Spring Boot 1.5.2
	Maven
	Embeded Tomcat
	JUnit 4.12

# Functional Overview, Functionality and Assumptions

     Assumptions 
	
	1. 3 levels of seats with 9 rows each and each row has 33 seats
	2. Single ticket can't reserve more than 33 seats
	3. If available, all seats will be reserved in same row. If not, immediate next row
	4. If seats are not available, "NotFoundException" will be thrown with error message as "No Available Seats, All seats are blocked"
	5. Hold seats have ttl of 5 mins
    6. Authorized users can invoke the hold/reserve post request

      Project provides three services
	1. /available-seats - number of seats available in Venue 
			Number of seats that are neither held nor reserved

	2. /hold-seats - find and holds the seats available
		Seats automatically expires after 5 mins (300 secs)

	3. /reserve-seats - Reserve the Hold Seats
		Reserve the seats which were on hold, if expired sends a Exired message.

# Design and Build 

    1. Validation implemented using JSR 303
    2. ScheduledExecutorService implemented to validate the time out and release the blocked tickets
    3. Atomic way of implementation to retrieve available seats and block seats
    4. Integration Testing automated using Cucumber+Retrofit+Assertions
    5. To execute the integration testing, use the below command -> mvn test -Dcucumber=true -Dhost=http://localhost:8080 (With this code, the test cases can be validated against any environment. Test cases are limited just to showcase as POC)
    6. Integration Test execution can be plugged to CICD and report can be generated on top of that to verify the breaks.

# Test Results 


