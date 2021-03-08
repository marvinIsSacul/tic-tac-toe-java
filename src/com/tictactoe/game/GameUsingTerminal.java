package com.tictactoe.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.tictactoe.board.BoardUsingPlayer;
import com.tictactoe.exception.InvalidPlayerException;
import com.tictactoe.exception.InvalidPositionException;
import com.tictactoe.type.Player;

public class GameUsingTerminal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final Player []players = { new Player(), new Player() };
	private Player turn;
	private boolean inProgress = false;
	private Date timeStarted;
	private final BoardUsingPlayer board = new BoardUsingPlayer();
	private boolean continuousRender = false;
	

	public GameUsingTerminal() {
		super();
	}
	
	private void restartGame() {
		endGame();
		startGame();
	}
	
	private void endGame() {
		inProgress = false;
	}
	
	private void startGame() {
		if (!isInProgress()) {
			board.clearBoard();
			turn = Math.random() < 0.5 ? players[0] : players[1];
			timeStarted = new Date();
		}
	}
	
	private boolean isInProgress() {
		return inProgress;
	}

	private Player getWinner() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Player getLoser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Player getPlayer1() {
		return players[0];
	}
	
	private Player getPlayer2() {
		return players[1];
	}
	
	private Date getTimeStarted() {
		return timeStarted;
	}
	
	private Player changeTurn(Player playerOverride) {
		if (playerOverride == null) {
			if (turn == players[0]) turn = players[1];
			else turn = players[0];
		}
		else {
			turn = playerOverride;
		}
		
		return turn;
	}
	
	private boolean playTurn(int position) {
		return position == 0;
	}
	
	private String getPlayerMove() {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			final String strInput = reader.readLine();
			
			if (!StringUtils.isNumeric(strInput)) {
				return strInput;
			}
			
			int position = Integer.valueOf(strInput);
			
			return strInput;
		} catch (IOException e) {
			System.err.println("Input Error");
		}
		
		return "";
	}
	
	private void renderBoardRow(Player []row, boolean isTopBorder) {
		final String underscores = StringUtils.repeat("_", 13);
		
		if (isTopBorder) System.out.println(underscores);
	//	System.out.printf("|   |   |   |\n");
		System.out.printf(
			"| %c | %c | %c |\n",
			row[0] == null ? '-' : row[0].getMark(),
			row[1] == null ? '-' : row[1].getMark(),
			row[2] == null ? '-' : row[2].getMark()
		);
		//System.out.println(underscores);
	}
	
	private void renderBoard() {
		if (continuousRender) {
			System.out.println("\n");
		} else {
			try {
				Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
				
			}
		}
		
		
		final String stars = StringUtils.repeat("=", 10);
		final int ROWS = 3;
		
		System.out.println(stars + " TIC TAC TOE " + stars);
		
		for (int i = 0; i < ROWS; ++i) {
			final boolean isTopBorder = i == 0;
			
			try {
				renderBoardRow(board.getRowPosition(i), isTopBorder);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println();
		System.out.print("Enter move (exit to quit): ");
		
		System.out.println();
	}
	
	public void gameLoop() {
		String input;
		do {
			renderBoard();
			input = getPlayerMove();
		} while (!input.toLowerCase().equals("exit"));
	}
}
