Feature: Products

  Scenario: User should be able to sort products
    Given i am logged in to the sauce demo app
    When i locate the sort dropdown field
    And i choose the sort option
    Then the products should be sorted accordingly