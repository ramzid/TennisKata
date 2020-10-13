package com.bdd.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bdd.tennis.domain.Game;
import com.bdd.tennis.domain.TennisPlayer;

@Ignore
@SpringBootTest
public class BddKataApplicationTests {

	private TennisPlayer firstPlayer;

	private TennisPlayer secondPlayer;

	private Game game;

	@BeforeEach
	void setup() {

		firstPlayer = new TennisPlayer("0", "ramzi");
		secondPlayer = new TennisPlayer("0", "moez");
		game = new Game(firstPlayer, secondPlayer, "0-0");

	}

	@Test
	void increment_score() {

		firstPlayer.setPlayerScore("0");
		secondPlayer.setPlayerScore("0");

		game.incrementPlayerScore(firstPlayer, secondPlayer);
		game.incrementPlayerScore(firstPlayer, secondPlayer);

		game.incrementPlayerScore(secondPlayer, firstPlayer);
		game.incrementPlayerScore(firstPlayer, secondPlayer);

		game.incrementPlayerScore(secondPlayer, firstPlayer);
		game.incrementPlayerScore(secondPlayer, firstPlayer);

		assertEquals(firstPlayer.getPlayerScore(), "40");
		assertEquals(secondPlayer.getPlayerScore(), "40");
	}

	@Test
	void increment_score_to_ADV() {

		firstPlayer.setPlayerScore("40");
		secondPlayer.setPlayerScore("40");
		game.incrementPlayerScore(firstPlayer, secondPlayer);

		assertEquals(firstPlayer.getPlayerScore(), "ADV");
		assertEquals(secondPlayer.getPlayerScore(), "40");
	}

	@Test
	void increment_score_to_DEUCE() {

		firstPlayer.setPlayerScore("ADV");
		secondPlayer.setPlayerScore("40");
		game.incrementPlayerScore(secondPlayer, firstPlayer);

		assertEquals(firstPlayer.getPlayerScore(), "DEUCE");
		assertEquals(secondPlayer.getPlayerScore(), "DEUCE");
	}

	@Test
	void increment_score_to_ADV_40() {

		firstPlayer.setPlayerScore("DEUCE");
		secondPlayer.setPlayerScore("DEUCE");

		game.incrementPlayerScore(firstPlayer, secondPlayer);
		game.incrementPlayerScore(firstPlayer, secondPlayer);
		assertEquals(firstPlayer.getPlayerScore(), "ADV");
		assertEquals(secondPlayer.getPlayerScore(), "40");
	}

	@Test
	void Increment_player_to_win() {

		firstPlayer.setPlayerScore("40");
		secondPlayer.setPlayerScore("15");
		game.incrementPlayerScore(firstPlayer, secondPlayer);

		Assertions.assertTrue(firstPlayer.isWinner());
		Assertions.assertFalse(secondPlayer.isWinner());
	}

	@Test
	void Increment__player_adv_to_win() {
		firstPlayer.setPlayerScore("ADV");
		secondPlayer.setPlayerScore("40");
		game.incrementPlayerScore(firstPlayer, secondPlayer);

		Assertions.assertTrue(firstPlayer.isWinner());
		Assertions.assertFalse(secondPlayer.isWinner());
	}

	@Test
	void Increment__player_deuce_to_win() {
		firstPlayer.setPlayerScore("DEUCE");
		secondPlayer.setPlayerScore("DEUCE");

		game.incrementPlayerScore(firstPlayer, secondPlayer);
		game.incrementPlayerScore(secondPlayer, firstPlayer);

		Assertions.assertFalse(firstPlayer.isWinner());
		Assertions.assertFalse(secondPlayer.isWinner());

	}
  
	@DisplayName("When we win a game the set score is incremented")
	@Test
	void should_set_mark_point_correctly() {

		firstPlayer.setPlayerScore("40");
		game.incrementPlayerScore(firstPlayer, secondPlayer);

		Assertions.assertTrue(firstPlayer.isWinner());
		Assertions.assertFalse(secondPlayer.isWinner());
		Assertions.assertEquals(1, firstPlayer.getPlayerSetScore());

	}

	@Test
	void player_won_set() {

		firstPlayer.setPlayerSetScore(5);
		secondPlayer.setPlayerSetScore(4);

		firstPlayer.setPlayerScore("40");
		secondPlayer.setPlayerScore("15");

		game.incrementPlayerScore(firstPlayer, secondPlayer);

		Assertions.assertTrue(firstPlayer.isWinner());
		Assertions.assertEquals(6, firstPlayer.getPlayerSetScore());
		Assertions.assertTrue(firstPlayer.isSetWinner());
	}

	@Test
	void player_fail_set() {
		firstPlayer.setPlayerSetScore(5);
		secondPlayer.setPlayerSetScore(5);

		firstPlayer.setPlayerScore("40");
		secondPlayer.setPlayerScore("15");

		game.incrementPlayerScore(firstPlayer, secondPlayer);

		Assertions.assertTrue(firstPlayer.isWinner());
		Assertions.assertEquals(6, firstPlayer.getPlayerSetScore());
		Assertions.assertFalse(firstPlayer.isSetWinner());
	}

	@Test
	void player_fail_set_tie_break() {
		firstPlayer.setPlayerSetScore(6);
		secondPlayer.setPlayerSetScore(6);

		game.incrementPlayerScore(firstPlayer, secondPlayer);

		Assertions.assertFalse(firstPlayer.isMatchWinner());
	}

	@Test
	void player_win_set_tie_break_increment() {

		firstPlayer.setPlayerSetScore(6);
		secondPlayer.setPlayerSetScore(6);

		firstPlayer.setPlayerTieBreakScore(6);
		secondPlayer.setPlayerTieBreakScore(2);

		game.incrementPlayerScore(firstPlayer, secondPlayer);

		Assertions.assertTrue(firstPlayer.isMatchWinner());
	}

}
