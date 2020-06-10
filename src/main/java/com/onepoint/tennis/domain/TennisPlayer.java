package com.onepoint.tennis.domain;

/**
 * 
 * @author dridi
 *
 */
public class TennisPlayer {
	private String playerScore = "0";
	private String name;
	private boolean winner;

	private int playerSetScore;
	private boolean setWinner;
	private int playerTieBreakScore;
	private boolean matchWinner;


	public TennisPlayer(String playerScore, String name) {
		this.playerScore = playerScore;
		this.setName(name);
	}

	public TennisPlayer(String playerScore) {
		this.playerScore = playerScore;
	}

	public String getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(String playerScore) {
		this.playerScore = playerScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public int getPlayerSetScore() {
		return playerSetScore;
	}

	public void setPlayerSetScore(int playerSetScore) {
		this.playerSetScore = playerSetScore;
	}

	public void incrementSetScore() {
		playerSetScore++;
	}

	public boolean isSetWinner() {
		return setWinner;
	}

	public void setSetWinner(boolean setWinner) {
		this.setWinner = setWinner;
	}

	public int getPlayerTieBreakScore() {
		return playerTieBreakScore;
	}

	public void setPlayerTieBreakScore(int playerTieBreakScore) {
		this.playerTieBreakScore = playerTieBreakScore;
	}

	  public void incrementTieBreakScore() {
		  playerTieBreakScore++;
	    }

	public boolean isMatchWinner() {
		return matchWinner;
	}

	public void setMatchWinner(boolean matchWinner) {
		this.matchWinner = matchWinner;
	}


}
