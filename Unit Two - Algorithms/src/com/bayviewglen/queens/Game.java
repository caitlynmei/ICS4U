package com.bayviewglen.queens;

import java.util.Scanner;
import java.util.Stack;

public class Game {

	private Stack<Queen> stack = new Stack<Queen>();
	private static int filled = 0;

	// --- placing queens on stack (saving board coordinates) ---

	public Queen placeFirstQueen() {
		Queen first = new Queen();
		filled = 0; // or 1?
		stack.push(first);
		return first;
	}

	public void placeQueenOnBoard(Queen first, int numQueens) {
		int row = 0;
		int column = 0;

		Queen current = new Queen();
		Queen previous = new Queen();
		boolean done = false;

		// end placing queens down on board when filled == numQueens

		while (!done) {
			if (!conflict(current, previous)) {
				filled++;
				if (filled == numQueens) {
					done = true;
				} else {			
					current.setRow(++row);//new Queen(row++, column);
					stack.push(current); // shift down one row
								
					if (current != previous) {
						previous = new Queen(row - 1, column);
					}
				}
			} else if (conflict(current, previous) && current.getColumn() < numQueens) {
				current.setColumn(++column); // shift right
				//stack.push(current);
			} else if (conflict(current, previous) && current.getColumn() == numQueens) {
				Queen temp = stack.pop();
				filled--;
				temp.setColumn(temp.getColumn() + 1); // shift right

				// backtracking
				while (temp.getColumn() == numQueens) {
					temp = stack.pop();
					filled--;
				}

				temp.setColumn(temp.getColumn() + 1); // shift right
				stack.push(temp);
				filled++;

			}
		}
	}

	// --- check conflict method ---
	public static boolean conflict(Queen current, Queen previous) {
		if (filled == 1) {
			return false;
		} else if (current.getColumn() == previous.getColumn()) {
			return true;
		} else if (checkSlope(current, previous)) { // checking if queens are on the same diagonal line
			return true;
		} else {
			return false;
		}
	}

	// --- for two queens ---

	// --- compare delta x of 2 queens ---
	public static int compareDeltaX(Queen current, Queen previous) {
		int x1 = previous.getColumn();
		int x2 = current.getColumn();

		int deltaX = Math.abs(x2 - x1);

		return deltaX;
	}

	// --- compare delta y of 2 queens ---
	public static int compareDeltaY(Queen current, Queen previous) {
		int y1 = previous.getRow();
		int y2 = current.getRow();

		int deltaY = Math.abs(y2 - y1);

		return deltaY;
	}

	// --- check slope of queens ---
	public static boolean checkSlope(Queen current, Queen previous) {

		if (compareDeltaX(current, previous) == compareDeltaY(current, previous)) {
			return true;
		}

		return false;
	}

	// --- intro message ---
	public void introMessage() {
		System.out.println("Welcome to nQueens!");
		System.out.print("Please enter the dimensions (n) for you board. The board will be n by n: ");
	}

	// --- get numQueens (dimensions) from user ---
	public int getN() {
		Scanner keyboard = new Scanner(System.in);
		boolean valid = false;

		while (!valid) {
			try {
				int n = Integer.parseInt(keyboard.nextLine());

				if (n == 0) {
					System.out.print("\nPlease enter a valid number (*Hint: NOT 0): ");
					valid = false;
				} else {
					valid = true;
					return n;
				}

			} catch (NumberFormatException e) {
				System.out.print("\nPlease enter a valid number (*Hint: NOT 0 or a letter): ");
			}
		}
		return 0;
	}

	// --- filling game board with Queens ---
	public void fillBoard(String[][] board) {
		while (!stack.isEmpty()) {
			Queen temp = stack.pop();
			for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[0].length; c++) {
					if (r == temp.getRow() && c == temp.getColumn()) {
						board[r][c] = "Q";
					} else {
						board[r][c] = ".";
					}
				}
			}
		}
	}

	public void printBoard(String[][] board) {
		System.out.println("\nOkay, you're personalized chess board is the ready!!\n");

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c]);
			}
			System.out.println();
		}

	}

	public void closingMessage() {
		System.out.println("\nThank you for playing with nQueens. Have a great day! : )");

	}

}
