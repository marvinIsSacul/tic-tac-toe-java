package com.tictactoe.exception;

public class InvalidPlayerException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPlayerException(String message) {
		super(message);
	}
}
