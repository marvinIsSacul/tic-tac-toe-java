package com.tictactoe.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.exception.InvalidPositionException;
import com.tictactoe.type.*;

public class BoardUsingPlayerTest {

	private final BoardUsingPlayer board = new BoardUsingPlayer();
	private final Player player = new Player();
	
	@Before
	public void setUp() throws Exception {
		player.setName("Player");
		player.setMark('X');
	}

	@Test
	void test() throws InvalidPositionException {
		board.setPosition(0, 0, player);
		assertEquals(board.getPosition(0, 0), player);
	}

}

