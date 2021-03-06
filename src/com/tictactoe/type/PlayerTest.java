package com.tictactoe.type;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	private Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player();
	}

	@Test
	public void test_setName() {
		player.setName("Martin");
		assertEquals(player.getName(), "Martin");
	}
	
	@Test
	public void test_setMark() {
		player.setMark('X');
		assertEquals(player.getMark(), 'X');
	}

}
