# encoding: UTF-8
Feature: ticket-service-available-seats-function

  #Scenario 1 :  Retrieve the available seats
  Scenario Outline: Integration test cases to validate the ticket service with invalid requests
    Given a Consumer of Ticket Service is making a call to test scenario "<scenarioType>" to retrieve available seats
    Then ticket service returns only status code of "<statusCode>" to retrieve available seats

    Examples: 
      | scenarioType                | statusCode	|
      | Retrieve Available Seats	| 200			|
  