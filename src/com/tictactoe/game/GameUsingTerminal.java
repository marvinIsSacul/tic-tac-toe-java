package com.tictactoe.game;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.tictactoe.board.Board;
import com.tictactoe.board.BoardUsingPlayer;
import com.tictactoe.exception.InvalidPlayerException;
import com.tictactoe.exception.InvalidStateException;
import com.tictactoe.type.Player;

public class GameUsingTerminal extends Game {
	private final Player []players = { null, null };
	private boolean inProgress = false;
	private Date timeStarted;
	private final Board board = new BoardUsingPlayer();
	
	public GameUsingTerminal() {
		super();
	}
	
	@Override
	public void restartGame() {
		endGame();
		startGame();
	}
	
	@Override
	public void endGame() {
		inProgress = false;
	}
	
	@Override
	public void startGame() {
		if (!isInProgress()) {
			timeStarted = new Date();
			board.clearBoard();
		}
	}
	
	@Override
	public boolean isInProgress() {
		return inProgress;
	}

	@Override
	public Player getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getLoser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer1() {
		return players[0];
	}

	@Override
	public Player getPlayer2() {
		return players[1];
	}

	@Override
	public Map<String, Object> getState() {
		final Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("player1", players[0]);
		data.put("player2", players[1]);
		data.put("inProgress", inProgress);
		data.put("timeStarted", timeStarted.toGMTString());
		
		return data;
	}

	@Override
	public void setState(final Map<String, Object> data) throws InvalidStateException {
		final Object rawPlayer1 = data.get("player1");
		if (rawPlayer1 == null) {
			throw new InvalidStateException("Invalid player1");
		}
		
		final Object rawPlayer2 = data.get("player1");
		if (rawPlayer2 == null) {
			throw new InvalidStateException("Invalid player2");
		}
		
		final Object rawInprogress = data.get("inProgress");
		if (rawInprogress == null) {
			throw new InvalidStateException("Invalid inProgress");
		}
		
		final Object rawTimeStarted = data.get("timeStarted");
		if (rawTimeStarted == null) {
			throw new InvalidStateException("Invalid timeStarted");
		}
		
		players[0] = (Player) rawPlayer1;
		players[1] = (Player) rawPlayer2;
		inProgress = (boolean) rawInprogress;
		timeStarted = new Date((String) rawTimeStarted);
	}

	@Override
	public Date getTimeStarted() {
		return timeStarted;
	}

	@Override
	public void setPlayer1(Player player1) throws InvalidPlayerException {
		
	}

	@Override
	public void setPlayer2(Player player2) throws InvalidPlayerException {
		
	}
	
	@Override
	public String toString() {
		return getState().toString();
	}
	
}
