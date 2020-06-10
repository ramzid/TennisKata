Feature: Tennis game with tie break rule

  Scenario Outline: Manage the tie break  rule game
    Given new tennisGame for a new set with firstPlayer  set score is  <setScoreFirstPlayer> and secondPlayer set score is <setScoreSecondPlayer>
    And firstPlayer  tieBreak score is <firstPlayerTieBreakScore> and secondPlayer  tieBreak score is <secondPlayerTieBreakScore>
    When firstPlayer marks a point
    Then firstPlayer tieBreak score become <firstPlayerTieBreakScoreExpected>
    And secondPlayer tieBreak score  become <secondPlayerTieBreakScoreExpected>
    
 	Examples:
 	
      | setScoreFirstPlayer | setScoreSecondPlayer | firstPlayerTieBreakScore 	| secondPlayerTieBreakScore |firstPlayerTieBreakScoreExpected   |secondPlayerTieBreakScoreExpected  |
      | 6                  | 6                     | 6                          | 2                         |7                                  | 2                                 |
     
      