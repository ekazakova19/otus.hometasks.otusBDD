
Feature: Otus news subscription
  This feature covers user ability to subscribe otus news

  Background:
    Given  I open otus main page
  @severity=normal
  Scenario: 01_Incorrect email
    This scenario covers a negative case during subscribe

    When I input 'incorrect23' in subscribe email field
    Then I see subscribe button becomes unavailable

    When I input 'correctmail@mail.ru' in subscribe email field
    Then I see subscribe button becomes available

  @severity=critical
  Scenario: 02_Subscribe test
    This scenario covers a positive case during subscribe

    When I input 'correct@mail.ru' in subscribe email field
    When I click on subscribe button
    Then I see 'Вы успешно подписались'
