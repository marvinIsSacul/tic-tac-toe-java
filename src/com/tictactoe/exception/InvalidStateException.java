package com.tictactoe.exception;

public class InvalidStateException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidStateException(String message) {
		super(message);
	}
}
