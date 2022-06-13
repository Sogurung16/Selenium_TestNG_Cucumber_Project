@values
  Feature: As a user, I want a valid representation of events value, so that I can gather the correct data
    Background:
      Given I am on the calendar page

    Scenario: Earnings value is not less than 1
      When I check Earnings number value
      Then the number should not be less than 1

    Scenario: Stock splits value is not less than 1
      When I check Stock splits number value
      Then the number should not be less than 1

    Scenario: IPO pricing value is not less than 1
      When I check IPO pricing number value
      Then the number should not be less than 1

    Scenario: Economic events value is not less than 1
      When I check Economic events number value
      Then the number should not be less than 1