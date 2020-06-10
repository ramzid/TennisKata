Feature: Tennis game


  Scenario Outline: Manage the set rule game
    Given new tennisGame for a new set with firstPlayer  set score is  <setScoreFirstPlayer> and secondPlayer set score is  <setScoreSecondPlayer>
    And firstPlayer gameScore is ADV  and secondPlayer  gameScore is 40
    When firstPlayer marks a point
    Then firstPlayer won the game 
    And firstPlayer set score should be <setScoreFirstPlayerExpected>
    And secondPlayer set score should be <setScoreSecondPlayerExpected>
   
    Examples:
      | setScoreFirstPlayer | setScoreFirstPlayerExpected     | setScoreSecondPlayer  | setScoreSecondPlayerExpected|
      | 0                   | 1                              	| 0                     | 0                           |                                                                   
      | 5                   | 0                               | 4      								| 0                           |                                                       
      | 6                   | 6                               | 6      								| 6                           |                                                                  
      | 6                   | 7                               | 5     								| 5                           |                                

