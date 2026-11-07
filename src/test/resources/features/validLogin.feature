@ignore
Feature: Login

  Scenario: verify that users with valid credentials can login successfully
    Given I am on the home page
    When I enter the correct username
    And I enter the correct password
    When I click the login button
    Then my login should be successful

   #Negative login scenarios
  Scenario Outline: users with invalid or no credentials should not be able to login
    Given I am on the home page
    When I enter the "<username>"
    And I type the "<password>"
    When I click the login button
    Then I should get the correct "<errorMessage>"

    Examples:
      | username                    |password      |errorMessage                                                             |
      | standard_user               |secret_sau    |Epic sadface: Username and password do not match any user in this service |
      | standard_                   |secret_sauce  |Epic sadface: Username and password do not match any user in this service |
      | standard_                   |secret_sau    |Epic sadface: Username and password do not match any user in this service |
      |                             |secret_sauce  |Epic sadface: Username is required                                        |
      |standard_user                |              |Epic sadface: Password is required                                        |
      |                             |              |Epic sadface: Username is required                                        |