
Feature: Blog
  This feature covers otus blog portal functionality

  Background:
    Given My user is logged on
    And I open post page


  @severity=critical
  Scenario: 01_Open and close search
    This scenario covers working with search box

    When I input "test" in search field
    And I close search box
    Then I don't see search box anymore

  @severity=critical
  Scenario: 02_Find a post in blog
    This scenario covers a positive search case

    When I input "git" in search field
    And I click on search button
    Then I see posts found

  @severity=critical
  Scenario: 03_Add post to favorite
    This scenario covers working with add-to-favorite functionality

    When I click on add to favorite icon for any post
    Then I see the post in my favorite posts

  @severity=critical
  Scenario: 04_Read more post
    This scenario covers a positive case of reading post

    When I click on read more for any post
    Then I see the post page opened
