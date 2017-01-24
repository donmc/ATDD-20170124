Feature: Add Flight
As a administrator
I want to add a flight
so that I can maintain fligth schedules

Scenario: Flight added successfully
When adding a flight with origin "DFW", destination "ORD", miles 900, airline "AA", and number 720
Then flight "AA720" exists 
 
Scenario: Invalid Origin
When adding a flight with origin "DALLAS", destination "ORD", miles 900, airline "AA", and number 720
Then error "Invalid origin code" is displayed