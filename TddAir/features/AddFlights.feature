Feature: Add Flight
As a administrator
I want to add a flight
so that I can maintain fligth schedules

Scenario Outline: Flight added successfully
When adding a flight with origin <origin>, destination <destination>, miles <miles>, airline <airline>, and number <number>
Then flight <flight number> exists 
 
Examples:
|origin|destination|miles|airline|number|flight number  |
|"DFW" |"ORD"      |900  |"AA"   |720   |"AA720"        |
|"DFW" |"ORD"      |900  |"BA"   |99    |"BA99"         |
|"DFW" |"ORD"      |900  |"AF1"   |0    |"Air Force One"|
 
Scenario: Invalid Origin
When adding a flight with origin "DALLAS", destination "ORD", miles 900, airline "AA", and number 720
Then error "Invalid origin code" is displayed