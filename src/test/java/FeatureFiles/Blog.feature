Feature: Blog

  Background:
    Given My user is logged on
    And I open post page

  Scenario: 01_Open and close search
    When I input "test" in search field
    And I close search box
    Then I don't see search box anymore

  Scenario: 02_Find a post in blog
    When I input "git" in search field
    And I click on search button
    Then I see posts found

  Scenario: 03_Add post to favorite
    When I click on add to favorite icon for any post
    Then I see the post in my favorite posts

  Scenario: 04_Read more post
    When I click on read more for any post
    Then I see the post page opened
