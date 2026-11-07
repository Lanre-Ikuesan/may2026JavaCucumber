@ignore
Feature: Home page

  Scenario: Homepage should contain the vital elements

    Given I have launched my browser
    When I enter the application url
    And I see the application logo
    And i see the username and password field
    Then I should see a login buttonj



