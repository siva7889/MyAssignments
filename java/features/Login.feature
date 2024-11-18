Feature: Login Feature in Leaftaps application

Scenario: Login scenario with valid credentials

Given Set the Environment
And Enter the username as 'demosalesmanager'
And Enter the password as 'crmsfa'
When Click on the login button
Then Verify the login is successful

Scenario: Login scenario with invalid credentials
Given Set the Environment
And Enter the username as demo123
And Enter the password as crmsfa
When Click on the login button
Then Verify the login is Unsuccessful