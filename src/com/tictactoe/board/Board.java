package com.tictactoe.board;

import com.tictactoe.exception.InvalidPositionException;

public abstract class Board<T> {
	public abstract T getPosition(int row, int column) throws InvalidPositionException;
	
	public abstract void setPosition(int row, int column, T value) throws InvalidPositionException;
	
	public abstract boolean isPositionOccupied(int row, int column) throws InvalidPositionException;
	
	public void resetPosition(int row, int column) throws InvalidPositionException {
		this.setPosition(row, column, null);
	}
	
	public abstract void clearBoard();
	
	public abstract boolean checkWin(T value);
}
