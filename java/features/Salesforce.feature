Feature: AccountName creation feature in salesfroce
Scenario: To verify the Account Name of the salesforce
Given Set the Environments
When Click on toggele button
And Click on Viewall
And Click on Sales from Applauncher
And Click on Accounts tab
And  New button
Given name as account name
Given  Ownership as Public
When Click on Save
Then Verify Account Name


