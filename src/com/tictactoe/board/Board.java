package com.tictactoe.board;

import java.io.Serializable;

import com.tictactoe.exception.InvalidPositionException;
import com.tictactoe.type.GameStatus;

public interface Board<T> extends Serializable {
	public T getPosition(int row, int column) throws InvalidPositionException;
	
	public T[] getRowPosition(int row) throws InvalidPositionException;
	
	public boolean setPosition(int row, int column, T value) throws InvalidPositionException;
	
	public boolean isPositionOccupied(int row, int column) throws InvalidPositionException;
	
	public default void resetPosition(int row, int column) throws InvalidPositionException {
		this.setPosition(row, column, null);
	}
	
	public GameStatus getStatus();
	
	public boolean isAnyPositionLeft();
	
	public int getRowCount();
	public int getColumnCount();
	
	public void clearBoard();
}
