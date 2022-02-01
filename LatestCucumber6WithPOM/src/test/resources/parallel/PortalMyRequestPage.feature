Feature: My Request Page Feature

Background:
Given user has already logged in to application
|22333444|4|1234|


#@accounts
Scenario: My Request page link
Given user is on Dashboard page
And user clicks on my request tab
Then current URL should be "http://47.254.24.51:81/Mol/#/requests"





#Scenario: Landing page header number
#Given user is on Landing page
#Then header rows should be equal "3"


#Scenario: Landing page operation number
#Given user is on Landing page
#Then operation number should be equal "6"


#Scenario: English Langauge for portal
#Given user is on Landing page
#And user click on English button
#And system should be wait 10 second
#Then landing language should be changed






#@accounts
#Scenario: Accounts section count
#Given user is on Accounts page
#Then user gets accounts section
#|ORDER HISTORY AND DETAILS|
#|MY CREDIT SLIPS|
#|MY ADDRESSES|
#|MY PERSONAL INFORMATION|
#|MY WISHLISTS|
#|Home|
#And accounts section count should be 6

