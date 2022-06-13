@login
Feature: As a User, I want to be to login successfully, so that I can access my account
  Background:
    Given I am on the Username page

  Scenario: User Login is successful
    When I enter valid username details
    And I enter valid password details
    Then I should see the homepage

  Scenario: User Login is unsuccessful username page
    When I enter invalid username details
    Then I should not see the Password page

  Scenario: User Login is unsuccessful password page
    When I enter valid username details
    And I enter invalid password details
    Then I should not see the homepage



