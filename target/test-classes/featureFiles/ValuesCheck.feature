@values
Feature: As a user, I want a valid representation of events, so that I can gather the correct data figures
  Background:
    Given I am on the calendar page

  Scenario: Earnings value is not less than 1
    When I check Earnings number value
    Then the earnings number should not be less than 1

  Scenario: Stock splits value is not less than 1
    When I check Stock splits number value
    Then the stock splits number should not be less than 1

  Scenario: IPO pricing value is not less than 1
    When I check IPO pricing number value
    Then the ipo pricing number should not be less than 1

  Scenario: Economic events value is not less than 1
    When I check Economic events number value
    Then the economic events should not be less than 1

  Scenario: Earnings string spelling is correct
    When I check Earnings spelling
    Then the Earnings spelling should be correct

  Scenario: Stock splits string spelling is correct
    When I check Stock splits spelling
    Then the Stock splits spelling should be correct

  Scenario: IPO pricing string spelling is correct
    When I check IPO pricing spelling
    Then the IPO pricing spelling should be correct

  Scenario: Economic events string spelling is correct
    When I check Economic events spelling
    Then the Economic events spelling should be correct

  Scenario: Date Displayed is correct
    When I check the date field
    Then the date should be correct

  Scenario: Earnings is clickable
    Then Earnings should be clickable

  Scenario: Stock splits is clickable
    Then Stock splits should be clickable

  Scenario: IPO pricing is clickable
    Then IPO pricing should be clickable

  Scenario: Economic events is clickable
    Then Economic events should be clickable

  Scenario: Earnings font is correct size
    When I check Earnings text font size
    Then Earnings font size should be correct

  Scenario: Stock splits font is correct size
    When I check Stock splits text font size
    Then Stock splits font size should be correct

  Scenario: IPO pricing font is correct size
    When I check IPO pricing text font size
    Then IPO pricing font size should be correct

  Scenario: Economic events font is correct size
    When I check Economic events text font size
    Then Economic events font size should be correct

  Scenario: Earnings background colour is correct
    When I check Earnings background colour
    Then Earnings background colour should be correct

  Scenario: Stock splits background colour is correct
    When I check Stock splits background colour
    Then Stock splits background colour should be correct

  Scenario: IPO pricing background colour is correct
    When I check IPO pricing background colour
    Then IPO pricing background colour should be correct

  Scenario: Economic events background colour is correct
    When I check Economic events background colour
    Then Economic events background colour should be correct