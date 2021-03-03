package com.tictactoe.board;

import com.tictactoe.exception.InvalidPositionException;
import com.tictactoe.type.Player;

public abstract class Board {
	public abstract Player getPosition(int row, int column) throws InvalidPositionException;
	
	public abstract void setPosition(int row, int column, Player player) throws InvalidPositionException;
	
	public abstract boolean isPositionOccupied(int row, int column) throws InvalidPositionException;
}
