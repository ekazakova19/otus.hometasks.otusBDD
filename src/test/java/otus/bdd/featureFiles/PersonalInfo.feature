@debug
Feature: Personal info

  Background:
    Given My user is logged on
    And I open skill page

  Scenario: 01_Change specialization
    When I set the following parameters
      | direction      | Data science      |
      | specialization | Big Data engineer |
    When I click on Save and Fill Later
    When I open skill page
    Then I see the following parameters
      | direction      | Data science      |
      | specialization | Big Data engineer |


  Scenario: 02_Save when specialization not filled
    When I set the following parameters
      | direction      | Data science      |
    And I click on Save and Fill Later
    Then I see error notification

