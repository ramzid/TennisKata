package com.bdd.tennis.bdd.stepdefs;

import com.bdd.tennis.domain.Game;
import com.bdd.tennis.domain.TennisPlayer;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class TennisGameSteps {

	private TennisPlayer firstPlayer;
	private TennisPlayer secondPlayer;
	private Game game;

	@Before
	public void setUp() {
		firstPlayer = new TennisPlayer("0", "first player");
		secondPlayer = new TennisPlayer("0", "second player");
		game = new Game(firstPlayer, secondPlayer, "0-0");
	}

	@Given("^no points have been scored$")
	public void no_points_have_been_scored() {
		// Write code here that turns the phrase above into concrete actions
		firstPlayer.setPlayerScore("0");
		secondPlayer.setPlayerScore("0");
	}

	@Then("^game score is \"([^\"]*)\"$")
	public void game_score_is(String gameScore)  {
		// Write code here that turns the phrase above into concrete actions
		game = new Game(firstPlayer, secondPlayer, "0-0");

	}

	@When("^I mark (\\d+) points to \"([^\"]*)\"$")
	public void i_mark_points_to(int p, String tennisPlayer)  {
		// Write code here that turns the phrase above into concrete actions

		if (tennisPlayer.equals(firstPlayer.getName()))
			for (int i = 0; i < p; i++) {
				game.incrementPlayerScore(firstPlayer, secondPlayer);
			}

		if (tennisPlayer.equals(secondPlayer.getName()))
			for (int i = 0; i < p; i++) {
				game.incrementPlayerScore(secondPlayer, firstPlayer);
			}

	}

	@Then("^game score \"([^\"]*)\"$")
	public void game_score(String gameScore) {
		// Write code here that turns the phrase above into concrete actions
		game.setGameScore(gameScore);

	}
	@Given("new tennisGame for a new set with firstPlayer  set score is  {int} and secondPlayer set score is  {int}")
	public void tennisGame_for_a_new_set_with_firstPlayer_set_score_is_and_secondPlayer_set_score_is(Integer firstPlayerSetScore, Integer secondPlayerSetScore) {
	    // Write code here that turns the phrase above into concrete actions
		firstPlayer.setPlayerSetScore(firstPlayerSetScore);
		secondPlayer.setPlayerSetScore(secondPlayerSetScore);
	}

	@Given("firstPlayer gameScore is ADV  and secondPlayer  gameScore is {int}")
	public void firstplayer_gameScore_is_ADV_and_secondPlayer_gameScore_is(Integer gameScore) {
	    // Write code here that turns the phrase above into concrete actions
		firstPlayer.setPlayerScore("ADV");
		secondPlayer.setPlayerSetScore(gameScore);
	}

	@When("firstPlayer marks another point")
	public void firstplayer_marks_another_point() {
	    // Write code here that turns the phrase above into concrete actions
		game.incrementPlayerScore(firstPlayer, secondPlayer);
	}

	@Then("firstPlayer won the game")
	public void firstplayer_won_the_game() {
	    // Write code here that turns the phrase above into concrete actions
		firstPlayer.setWinner(true);
	}

	@Then("firstPlayer set score should be {int}")
	public void firstplayer_set_score_should_be(Integer setScore) {
	    // Write code here that turns the phrase above into concrete actions
		firstPlayer.setPlayerSetScore(setScore);
	}

	@Then("secondPlayer set score should be {int}")
	public void secondplayer_set_score_should_be(Integer setScore) {
	    // Write code here that turns the phrase above into concrete actions
		secondPlayer.setPlayerSetScore(setScore);
	}

	@Given("^firstPlayer  score is  \"([^\"]*)\" and secondPlayer  score is \"([^\"]*)\"$")
	public void firstplayer_score_is_and_secondPlayer_score_is(String scorePlayer1, String scorePlayer2)			 {
		// Write code here that turns the phrase above into concrete actions
		firstPlayer.setPlayerScore(scorePlayer1);
		secondPlayer.setPlayerScore(scorePlayer2);
	}

	@When("^firstPlayer marks a point$")
	public void firstplayer_marks_a_point() {
		// Write code here that turns the phrase above into concrete actions
		game.incrementPlayerScore(firstPlayer, secondPlayer);
	}

	@Then("^firstPlayer score  become \"([^\"]*)\"$")
	public void firstplayer_score_become(String scorePlayer1) {
		// Write code here that turns the phrase above into concrete actions
		firstPlayer.setPlayerScore(scorePlayer1);
	}

	@Then("^the secondPlayer score become  \"([^\"]*)\"$")
	public void the_secondPlayer_score_become(String scorePlayer2)  {
		// Write code here that turns the phrase above into concrete actions
		secondPlayer.setPlayerScore(scorePlayer2);
	}
	
	

@Given("new tennisGame for a new set with firstPlayer  set score is  {int} and secondPlayer set score is {int}")
public void new_tennisGame_for_a_new_set_with_firstPlayer_set_score_is_and_secondPlayer_set_score_is(Integer firstPlayrSetScore, Integer secondPlayrSetScore) {
    // Write code here that turns the phrase above into concrete actions
    firstPlayer.setPlayerSetScore(firstPlayrSetScore);
    secondPlayer.setPlayerSetScore(secondPlayrSetScore);
}

@Given("firstPlayer  tieBreak score is {int} and secondPlayer  tieBreak score is {int}")
public void firstplayer_tieBreak_score_is_and_secondPlayer_tieBreak_score_is(Integer player1TieBreak, Integer player2TieBreak) {
    // Write code here that turns the phrase above into concrete actions
    firstPlayer.setPlayerTieBreakScore(player1TieBreak);
    secondPlayer.setPlayerTieBreakScore(player2TieBreak);

}

@Then("firstPlayer tieBreak score become {int}")
public void firstplayer_tieBreak_score_become(Integer firstPlayerTieBreakScore) {
    // Write code here that turns the phrase above into concrete actions
    firstPlayer.setPlayerTieBreakScore(firstPlayerTieBreakScore);
}

@Then("secondPlayer tieBreak score  become {int}")
public void secondplayer_tieBreak_score_become(Integer secondPlayerTieBreakScore) {
    // Write code here that turns the phrase above into concrete actions
   secondPlayer.setPlayerTieBreakScore(secondPlayerTieBreakScore);
}


}
