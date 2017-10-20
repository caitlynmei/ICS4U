package com.bayviewglen.queens;

import java.util.Stack;

public class GameNBoard {

	private Stack<Queen> stack = new Stack<Queen>(); 
	private int filled;
	
	public GameNBoard() {
		filled = 0;
		stack = null;
	}
	
	public void addFirstToStack (Queen q) {
		stack.push(q);
		filled++;
	}
	
	public void addToStack (Queen q) {
		if (stack == null) {
			addFirstToStack(q);
		}
	}
	
	public Queen popFromStack () {
		filled--;
		return stack.pop();	
	}
	
}
