Feature: Confirmation of purchase

  Scenario: Confirm order for a specific item
    Given I am on the login page
    When I log in with valid credentials
    And I add the "Sauce Labs Bike Light" to the shopping cart
    And I confirm the order in my shopping cart
    Then I should see a confirmation message

  Scenario: Confirm order with problem user
    Given I am on the login page
    When I log in with problem user
    And I add the "Sauce Labs Onesie" to the shopping cart
    And I confirm the order in my shopping cart
    Then I should see a confirmation message

  Scenario: Confirm order with locked out user
    Given I am on the login page
    When I log in with locked out user
    And I add the "Sauce Labs Onesie" to the shopping cart
    And I confirm the order in my shopping cart
    Then I should see a confirmation message

  Scenario: Confirm order with glitch user
    Given I am on the login page
    When I log in with glitch user
    And I add the "Sauce Labs Onesie" to the shopping cart
    And I confirm the order in my shopping cart
    Then I should see a confirmation message
