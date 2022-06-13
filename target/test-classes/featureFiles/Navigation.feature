@navigation
Feature: As a user, I want to navigate to the calendar page, so that I can check on finance data
  Scenario: Successful Navigation to the Calendar page
    Given I am on the Yahoo landing page
    And I go to the Username page
    And I go to the Password page
    And I go to the Home page
    And I go to the Finance page
    When I go to the Calendar page
    Then I should be on the Calendar page