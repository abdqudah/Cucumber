Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Welcome - Ministry of Labour"

Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: English Langauge for portal
Given user is on login page
And user click on English button
And system should be wait 10 second
Then portal language should be changed


Scenario: Login with correct credentials
Given user is on login page
When user enters username "22333444"
And user enters estimtated "4"
And user enters password "1234"
And user clicks on Login button
And system should be wait 10 second
And user enters a valid otp "1111" and click on submit
Then account name should be displayed


Scenario: Login with incorrect credentials
Given user is on login page
When user enters username "223344"
And user enters estimtated "4"
And user enters password "1234"
And user clicks on Login button
And system should be wait 10 second
Then error message should be displayed as a toast message


Scenario: Back to login page from OTP screen
Given user is on login page
When user enters username "22333444"
And user enters estimtated "4"
And user enters password "1234"
And user clicks on Login button
And system should be wait 10 second
And user clicks on back to login page link
Then user should be redircted to main login page

Scenario: Logging out after login with valid credentials
Given user is on login page
When user enters username "22333444"
And user enters estimtated "4"
And user enters password "1234"
And user clicks on Login button
And system should be wait 10 second
And user enters a valid otp "1111" and click on submit
Then account name should be displayed
And user clicks on the logout button
Then user should be redircted to main login page
 


