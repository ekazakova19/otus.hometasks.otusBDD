
Feature: Personal info
  This feature covers user ability to change personal information

  Background:
    Given My user is logged on
    And I open skill page

  @severity=critical
  Scenario: 01_Change specialization
    This scenario covers a positive case of changing user data

    When I set the following parameters
      | direction      | Data science      |
      | specialization | Big Data engineer |
    When I click on Save and Fill Later
    When I open skill page
    Then I see the following parameters
      | direction      | Data science      |
      | specialization | Big Data engineer |

  @severity=normal
  Scenario: 02_Save when specialization not filled
    This scenario covers a negative case of empty specialization parameter

    When I set the following parameters
      | direction      | Data science      |
    And I click on Save and Fill Later
    Then I see error notification

