package com.tictactoe.game;

import java.util.Date;
import java.util.Map;

import com.tictactoe.exception.InvalidPlayerException;
import com.tictactoe.exception.InvalidStateException;
import com.tictactoe.type.Player;

public abstract class Game {
	public abstract void restartGame();
	
	public abstract void endGame();
	
	public abstract void startGame();
	
	public abstract boolean isInProgress();
	
	/**
	 * @return null when there's currently no winner.
	 */
	public abstract Player getWinner();
	
	/**
	 * @return null when there's currently no loser.
	 */
	public abstract Player getLoser();
	
	/**
	 * @return null when there's currently no player set.
	 */
	public abstract Player getPlayer1();
	
	/**
	 * @return null when there's currently no player set.
	 */
	public abstract Player getPlayer2();
	
	public abstract void setPlayer1(Player player1) throws InvalidPlayerException;
	
	public abstract void setPlayer2(Player player2) throws InvalidPlayerException;
	
	public abstract Map<String, Object> getState();

	/**
	 * @throws InvalidStateException
	 */
	public abstract void setState(Map<String, Object> state) throws InvalidStateException;
	
	public abstract Date getTimeStarted();
	
	public long getElapsedTime() {
		return (long) getTimeStarted().toInstant().getNano() - System.nanoTime();
	}
}
