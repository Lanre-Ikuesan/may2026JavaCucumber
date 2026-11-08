#@ignore
Feature: Create Account

  Background:
    Given I am on the application homepage
    When I click the login/register button

  Scenario: User should be able to create account

    And I click button to continue
    When I enter all the required data
    And I agree to privacy policy
    When I click on continue button
    Then my new account should be created