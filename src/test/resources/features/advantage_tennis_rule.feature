Feature: Tennis game


  Scenario Outline: Manage  the specific of the rule DEUCE at the end of a Game
    Given  firstPlayer  score is  "<scorePlayer1>" and secondPlayer  score is "<scorePlayer2>"
    When firstPlayer marks a point
    Then firstPlayer score  become "<scorePlayer1Expected>"
    And the secondPlayer score become  "<scorePlayer2Expected>"

    Examples:
      | scorePlayer1        | scorePlayer1Expected | scorePlayer2 			 | scorePlayer2Expected |
      | 40                  | ADV                  | 40                  | 40                   |
      | 40                  | DEUCE                | ADV                 | DEUCE                |
      | DEUCE               | ADV                  | DEUCE               | 40                   |
      | ADV                 | 0                    | 40                  | 0                    |
