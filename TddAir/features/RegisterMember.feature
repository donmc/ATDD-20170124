Feature: Register User
As a new User
I want to register with a uniqueID and valid email
So that a user can be registered

Scenario: Successful Registration
When  user register with userid "donmc", email "donmc@improving.com"
Then "donmc" should be saved
And that member should have "Red" status
 
#Scenario: NonUnique UserId
#Given user register with userid "bob", email "donmc@improving.com"
#When  user register with userid "bob", email "donmc@improving.com"
#Then error "Duplicate Id" is displayed  

#Scenario: Invalid emailId
#When  user register with userid "donmc", email "donmc.improving.com"
#Then error "EmailId is Invalid" is displayed