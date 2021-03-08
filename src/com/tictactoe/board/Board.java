package com.tictactoe.board;

import java.io.Serializable;

import com.tictactoe.exception.InvalidPositionException;

public abstract class Board<T> implements Serializable {
	public abstract T getPosition(int row, int column) throws InvalidPositionException;
	
	public abstract T[] getRowPosition(int row) throws InvalidPositionException;
	
	public abstract void setPosition(int row, int column, T value) throws InvalidPositionException;
	
	public abstract boolean isPositionOccupied(int row, int column) throws InvalidPositionException;
	
	public void resetPosition(int row, int column) throws InvalidPositionException {
		this.setPosition(row, column, null);
	}
	
	public abstract int getRowCount();
	public abstract int getColumnCount();
	
	public abstract void clearBoard();
	
	public abstract boolean checkWin(T value);
}
