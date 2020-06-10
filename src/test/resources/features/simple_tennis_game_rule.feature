#Author: dridi.ramzy@gmail.com
Feature: simple tennis game

  Scenario: Initial
    Given no points have been scored
    Then game score is "0-0"

  Scenario Outline: simple game rule
    When I mark <p1> points to "first player"
    And I mark <p2> points to "second player"
    Then game score <score>

    Examples: 
      | p1 | p2 | score   |
      |  1 |  0 | "15-0"  |
      |  2 |  0 | "30-0"  |
      |  2 |  1 | "30-15" |
      |  3 |  1 | "40-15" |
      |  3 |  2 | "40-30" |
      |  3 |  3 | "40-40" |
