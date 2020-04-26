@debug
Feature: Login
  This feature covers main login functionality.

  @severity=blocker
  Scenario: 01_Login as otus student
  This scenario covers positive login case.

    When I open otus main page
    And I сlick on Login button
    Then I see login page is opened
    When I fill email field
    And I fill password field
    And I сlick on submit button
    Then I see main page opened for logged user
