package com.tictactoe.type;

import java.io.Serializable;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name = "";
	private char mark = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getMark() {
		return mark;
	}
	public void setMark(char mark) {
		this.mark = mark;
	}
}
