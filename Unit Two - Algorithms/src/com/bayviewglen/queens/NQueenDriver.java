package com.bayviewglen.queens;

public class NQueenDriver {

	public static void main(String[] args) {
		
		Game driver = new Game();
		
		driver.introMessage();

		int numQueens = driver.getN(); // also dimension of board

		// --- placing queens in stack ---
		Queen first = driver.placeFirstQueen();
		driver.placeQueenOnBoard(first, numQueens);

		// --- creating board ---
		String[][] board = new String[numQueens][numQueens];
		driver.fillBoard(board);

		// --- print filled board ---
		driver.printBoard(board);

		driver.closingMessage();

	}

}
