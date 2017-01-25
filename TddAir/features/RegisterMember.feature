Feature: Register new member
Scenario: User registers with valid Id and Email
When user registers with id "1", email "prakash.malluri@realpage.com"
Then user with id "1" should be saved
And user has "Red" status
And user has 0 ytdMiles
And user has 10000 balance miles