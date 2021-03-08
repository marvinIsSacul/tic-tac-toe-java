package com.tictactoe.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.tictactoe.board.BoardUsingPlayer;
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
			inProgress = true;
			board.clearBoard();
			turn = Math.random() < 0.5 ? this.getPlayer1() : this.getPlayer2();
			this.getPlayer1().setMark('X');
			this.getPlayer1().setName("Mark");
			this.getPlayer2().setMark('0');
			this.getPlayer2().setName("Rubin");
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
			if (turn == this.getPlayer1()) turn = this.getPlayer2();
			else turn = this.getPlayer1();
		}
		else {
			turn = playerOverride;
		}
		
		return turn;
	}
	
	private boolean playTurn(int position) throws InvalidPositionException {
		for (int row = 0, index = 0; row < board.getRowCount(); ++row)
			for (int column = 0; column < board.getColumnCount(); ++column)
				if (++index == position) {
					try {
						if (board.setPosition(row, column, this.turn)) {
							return true;
						}
						else {
							System.err.println("Position already occupied");
							return false;
						}
					} catch (InvalidPositionException e) {
						break;
					}
				}

		System.err.println("Position out of bounds");
		
		return false;
	}
	
	private String getPlayerMove() {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			final String strInput = reader.readLine();
			
			if (!StringUtils.isNumeric(strInput)) {
				return strInput;
			}
			
			int position = Integer.valueOf(strInput);
			final boolean isMoveValid = playTurn(position);
			
			if (isMoveValid) {
				switch (board.getStatus()) {
				case DRAW:
					System.out.println("Game Drawn - Donkies' Game");
					endGame();
					break;
				case WON:
					System.out.println(this.turn + " has won!!!");
					endGame();
					break;
				case IN_PROGRESS:
					changeTurn(null);
					break;
				}
			}
			
			return strInput;
		} catch (IOException e) {
			System.err.println("Input Error");
		} catch (InvalidPositionException e) {
			System.err.println("");
		}
		
		return "";
	}
	
	private void renderBoardRow(Player []row, boolean isTopBorder) {
		final String border = StringUtils.repeat("=", 19);
		
		if (isTopBorder) System.out.println(border);
	
		System.out.printf(
			"|     |     |     |\n" +
			"|  %c  |  %c  |  %c  |\n" +
			"|     |     |     |\n",
			row[0] == null ? '-' : row[0].getMark(),
			row[1] == null ? '-' : row[1].getMark(),
			row[2] == null ? '-' : row[2].getMark()
		);
		System.out.println(border);
	}
	
	private void renderBoard() {
		final boolean isWindows = System.getProperty("os.name").contains("win");
		
		if (continuousRender) {
			System.out.println("\n");
		} else {
			try {
				Runtime.getRuntime().exec(isWindows ? "cls" : "clear");
			} catch (IOException e) {
				System.err.println("Error clearing console");
			}
		}
		
		
		final String stars = StringUtils.repeat("=", 10);
		final int rows = board.getRowCount();
		
		System.out.println(stars + " TIC TAC TOE " + stars);
		System.out.println(this.getPlayer1() + " vs " + this.getPlayer2());
		System.out.println();
		
		for (int i = 0; i < rows; ++i) {
			final boolean isTopBorder = i == 0;
			
			try {
				renderBoardRow(board.getRowPosition(i), isTopBorder);
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		System.out.println();
		System.out.print("Enter move (exit to quit): ");
	}
	
	public void gameLoop() {
		String input;
		
		startGame();
		
		do {
			renderBoard();
			
			if (!isInProgress()) {
				break;
			}
			
			input = getPlayerMove();
		} while (!input.toLowerCase().equals("exit"));
	}
}
