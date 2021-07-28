Feature: Google Search
  Scenario: Search Testing keyword in google website
    Given I navigate to google website
    When I enter Testing keyword in search box
    And I press enter
    Then Results page should show Testing details
