Feature: Register new member
Scenario: User registers with valid userId and Email
When user registers with id "donmc", email "don@improving.com"
Then user with id "donmc" should be saved

Scenario: User tries to register with preexisting userId
When  user registers with preexistingId "donmc",  email "don@improving.com"
Then Error "Duplicate Id" is displayed

Scenario: User enters invalid email
When user enters invalid Email "abcd"
Then Error "Invalid Email" is displayed