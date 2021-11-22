Feature: check the facebok

  Background: 
    Given user has already logged in to application
      | username                     | password       |
      | dec2020secondbatch@gmail.com | Selenium@12345 |

  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"
