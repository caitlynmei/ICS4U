package com.bayviewglen.queens;

import java.util.Stack;

public class Board {
	
	private int n; // dimensions
	private Queen[][] board;
	private int filled;
	private Stack<Queen> stack = new Stack<Queen>(); 

	// --- board constructors --- 
	
	public Board () {
		super();
		this.n = 1;
		this.board = new Queen[n][n]; 
		this.filled = 0;
		this.stack = null;
	}
	
	public Board (int n) {
		super();
		this.n = n;
		this.board = new Queen[n][n]; 
	}
	
	// --- 
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public Queen[][] getBoard() {
		return board;
	}

	public void setBoard(Queen[][] board) {
		this.board = board;
	}
	
	
	// --- stack methods --- 
	
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
