Feature: Login Feature in Leaftaps application

Scenario Outline: Login scenario with valid credentials
Given Set the Environment
And Enter the username as 'demosalesmanager'
And Enter the password as 'crmsfa'
When Click on the login button
Then Verify the login is successful
When Click on the cmsrf link
And Click on Lead
And Click on CreateLead
Given Enter the fname as <fname>
And Enter the lname as <lname>
And Enter the cname as <cname>
And Enter the phno as <phno>
When Click on submit
Then Verify the leadid and verify the fname as <fname>
Examples:
|fname|lname|cname|phno|
|'siva'|'sankari'|'Testleaf'|'992783839'|
