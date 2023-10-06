Feature: Confirmation of purchase

  Scenario: Confirm order for a specific item
    Given I am on the login page
    When I log in with valid credentials
    And I add the "Sauce Labs Bike Light" to the shopping cart
    And I confirm the order in my shopping cart
    Then I should see a confirmation message
