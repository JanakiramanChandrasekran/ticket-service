# encoding: UTF-8
Feature: ticket-service-hold-seats-function

  #Scenario 1 : To validate if the POST operation errors out if invalid data request 
  Scenario Outline: Integration test cases to validate the ticket service with invalid requests
    Given a Consumer of Ticket Service is making a call to test scenario "<scenarioType>" to hold seats
    When consumer pass number of seats with value of "<numSeats>" to hold seats
    And consumer pass customer email address with value of "<customerEmail>" to hold seats
    Then ticket service returns only status code of "<statusCode>" to hold seats

    Examples: 
      | scenarioType                		| numSeats		| customerEmail						| statusCode	|
      | If numSeats is zero					| 0				| abc1@gmail.com					| 400			|
      | If numSeats is negative				| -11			| abc1@gmail.com					| 400			|
      | If numSeats is > 33		 			| 34			| abc1@gmail.com					| 400			|
      
  #Scenario 2 : To validate if the POST operation is successful with valid request 
  Scenario Outline: Integration test cases to validate the ticket service with invalid requests
    Given a Consumer of Ticket Service is making a call to test scenario "<scenarioType>" to hold seats
    When consumer pass number of seats with value of "<numSeats>" to hold seats
    And consumer pass customer email address with value of "<customerEmail>" to hold seats
    Then ticket service returns only status code of "<statusCode>" to hold seats

    Examples: 
      | scenarioType                       	| numSeats		| customerEmail						| statusCode	|
      | If numSeats is 10 & valid email		| 10			| abc1@gmail.com					| 200			|
