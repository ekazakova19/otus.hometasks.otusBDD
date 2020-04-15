
Feature: Login

  @cookies
  Scenario: 01_Login as otus student
    When I open otus main page
    And I сlick on Login button
    Then I see login page is opened
    When I fill email field
    And I fill password field
    And I сlick on submit button
    Then I see main page opened for logged user
