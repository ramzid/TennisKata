package com.bdd.tennis.domain;

import java.util.Arrays;

/**
 * 
 * @author dridi
 *
 */
public class Game {

	static final String[] scores = { "0", "15", "30", "40", "ADV", "DEUCE" };
	private TennisPlayer firstPlayer;
	private TennisPlayer secondPlayer;
	private String gameScore;

	public TennisPlayer getWinner() {
		return winner;
	}

	public void setWinner(TennisPlayer winner) {
		this.winner = winner;
	}

	private TennisPlayer winner;

	public Game(TennisPlayer firstPlayer, TennisPlayer secondPlayer, String gameScore) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.setGameScore(gameScore);
	}

	public TennisPlayer getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(TennisPlayer secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public TennisPlayer getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(TennisPlayer firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public String getGameScore() {
		return gameScore;
	}

	public void setGameScore(String gameScore) {
		this.gameScore = gameScore;
	}

	TennisPlayer getSecondPlayer(TennisPlayer player) {
		return getFirstPlayer().equals(player) ? getSecondPlayer() : getFirstPlayer();
	}


	public void incrementPlayerScore(TennisPlayer player1, TennisPlayer player2) {
		int i = Arrays.binarySearch(scores, player1.getPlayerScore());

		if (player1.getPlayerScore().equals("DEUCE") && player2.getPlayerScore().equals("DEUCE")) {

			player1.setPlayerScore("ADV");
			player2.setPlayerScore("40");

		} else if (player1.getPlayerScore().equals("40") && player2.getPlayerScore().equals("ADV")) {

			player1.setPlayerScore("DEUCE");

			player2.setPlayerScore("DEUCE");

		} else if (player1.getPlayerScore().equals("ADV")
				|| (player1.getPlayerScore().equals("40") && (!player2.getPlayerScore().equals("40")))) {

			player1.setWinner(true);
			player1.incrementSetScore();
			if (player1.getPlayerSetScore() == 6 && player2.getPlayerSetScore() <= 4)
				player1.setSetWinner(true);

		}else if ((player1.getPlayerSetScore() == 6 && player2.getPlayerSetScore() == 6)) {
				player1.incrementTieBreakScore();

				if (player1.getPlayerTieBreakScore() > 6
						&& (player1.getPlayerTieBreakScore() - player2.getPlayerTieBreakScore()) > 1)
					player1.setMatchWinner(true);

		} else {

			String newScore = scores[++i];
			player1.setPlayerScore(newScore);
		}

	}}

