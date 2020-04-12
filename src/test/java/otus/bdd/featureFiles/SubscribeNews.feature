Feature: Otus news subscription
  Background:
    Given  I open otus main page

  Scenario: 01_Incorrect email
    When I input 'incorrect23' in subscribe email field
    Then I see subscribe button becomes unavailable

    When I input 'correctmail@mail.ru' in subscribe email field
    Then I see subscribe button becomes available

  @closeDriver
  Scenario: 02_Subscribe test
    When I input 'correct@mail.ru' in subscribe email field
    When I click on subscribe button
    Then I see 'Вы успешно подписались'
