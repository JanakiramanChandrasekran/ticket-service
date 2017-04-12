# encoding: UTF-8
Feature: ticket-service-reserve-seats-function

  #Scenario 1 : To validate if the POST operation to reserve seats errors out if invalid data request 
  Scenario Outline: Integration test cases to validate the ticket service with invalid requests
    Given a Consumer of Ticket Service is making a call to test scenario "<scenarioType>" to reserve seats
    When consumer pass number of seats with value of "<seatHoldId>" to reserve seats
    And consumer pass customer email address with value of "<customerEmail>" to reserve seats
    Then ticket service returns only status code of "<statusCode>" to reserve seats

    Examples: 
      | scenarioType				| seatHoldId	| customerEmail						| statusCode	|
      | If seatHoldId is zero		| 0				| abc1@gmail.com					| 400			|
      | If seatHoldId is negative	| -11			| abc1@gmail.com					| 400			|
   