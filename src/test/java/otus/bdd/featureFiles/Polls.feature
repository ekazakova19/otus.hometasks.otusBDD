
Feature: Polls
  This feature covers functionality of access to the webinar poll.

  @severity=normal
  Scenario: 01_Check access to poll

    When I open the poll link "https://otus.ru/polls/7139/"
    Then I see "Доступ запрещен" text
    When I log in
    And I open the poll link "https://otus.ru/polls/7139/"
    Then I see poll page