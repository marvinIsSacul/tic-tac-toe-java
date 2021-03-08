package com.tictactoe.board;

import java.util.Arrays;

import com.tictactoe.exception.InvalidPositionException;
import com.tictactoe.type.Player;

public class BoardUsingPlayer extends Board<Player> {
	private static final long serialVersionUID = 1L;

	final private Player [][]board = new Player[ROWS][COLUMNS]; 
	
	private static final int ROWS = 3;
	private static final int COLUMNS = 3;

	public BoardUsingPlayer() {
		super();
	}

	@Override
	public Player getPosition(int row, int column) throws InvalidPositionException {
		assertValidPosition(row, column);
		
		return board[row][column];
	}
	
	@Override
	public Player[] getRowPosition(int row) throws InvalidPositionException {
		if (row >= ROWS || row < 0) {
			throw new InvalidPositionException("Invalid row index: " + row);
		}
		
		return board[row];
	}

	@Override
	public void setPosition(int row, int column, Player player) throws InvalidPositionException {
		assertValidPosition(row, column);
		
		board[row][column] = player;
	}

	@Override
	public boolean isPositionOccupied(int row, int column) throws InvalidPositionException {
		assertValidPosition(row, column);
		
		return board[row][column] != null;
	}

	@Override
	public void clearBoard() {
		for (int i = 0; i < ROWS; ++i)
			for (int j = 0; j < COLUMNS; ++j)
				board[i][j] = null;
	}
	
	private void assertValidPosition(int row, int column) throws InvalidPositionException {
		if (row >= ROWS || row < 0) {
			throw new InvalidPositionException("Invalid row index: " + row);
		}
		
		if (column >= ROWS || column < 0) {
			throw new InvalidPositionException("Invalid column index: " + column);
		}
	}

	@Override
	public boolean checkWin(Player player) {
		// rows
		for (int i = 0; i < ROWS; ++i) {
			if (checkEqual(player, board[i][0], board[i][1], board[i][2])) {
				return true;
			}
		}
		
		// columns
		for (int i = 0; i < COLUMNS; ++i) {
			if (checkEqual(player, board[0][i], board[1][i], board[2][i])) {
				return true;
			}
		}
		
		// top left to bottom right diagonal
		if (checkEqual(player, board[0][0], board[1][1], board[2][2])) {
			return true;
		}
		
		// top right to bottom left diagonal
		if (checkEqual(player, board[0][2], board[1][1], board[2][0])) {
			return true;
		}
		
		return false;
	}
	
	private boolean checkEqual(Player basePlayer, Player ...positions) {
		if (positions.length > 0) {
			return Arrays.stream(positions).allMatch(p -> p == basePlayer);
		}
		
		return false;
	}

	@Override
	public int getRowCount() {
		return ROWS;
	}

	@Override
	public int getColumnCount() {
		return COLUMNS;
	}
}
