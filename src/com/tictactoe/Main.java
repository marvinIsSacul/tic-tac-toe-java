package com.tictactoe;

import com.tictactoe.game.GameUsingTerminal;

public class Main {

	public static void main(String[] args) {
		GameUsingTerminal game = new GameUsingTerminal();
		
		System.out.println("Starting Tic Tac Toe...\n");
		
		game.gameLoop();
		
		System.out.println("\nEnding Tic Tac Toe...");
	}

}
