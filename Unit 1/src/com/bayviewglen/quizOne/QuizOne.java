package com.bayviewglen.quizOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizOne {

	public static void main(String[] args) {

		/*
		 * Create a program that reads a 3 x 3 2D Array of x(s), o(s) and .(s). Assuming
		 * that this is a grid to display a game of tic tac toe.
		 * 
		 * Display to the screen one of the following:
		 * 
		 * 1. X WON 
		 * 2. O WON 
		 * 3. TIE 
		 * 4. Not a Valid game (because the number of Xs and Os
		 * do not differ by 1)
		 * 
		 */
	
		String[][] game = new String[3][3];
		
		readingGame(game);
	
		for (int r=0; r<game.length; r++) {
			for (int c=0; c<game[r].length; c++) {
				System.out.print(game[r][c]);
			}
			System.out.println();
		}
		
		if (checkingValid(game)) {
			if (xWon(game) && oWon(game)) {
				System.out.println("\nNot a valid game.");
			} else if (xWon(game)) {
				System.out.println("\nX WON");
			} else if (oWon(game)) {
				System.out.println("\nO WON");
			} else {
				System.out.println("\nTIE");
			}
		}
		
	}

	private static boolean oWon(String[][] game) {
		String o = "O";
		
		// Horizontal Check
		for (int r=0; r<game.length; r++) {
			for (int c=0; c<game[r].length-2; c++) {
				if ((game[r][c].equals(o)) && (game[r][c+1].equals(o)) && (game[r][c+2].equals(o))){
					return true;
				}
			}
		}
		
		// Vertical Check
		for (int r=0; r<game.length-2; r++) {
			for (int c=0; c<game[r].length; c++) {
				if ((game[r][c].equals(o)) && (game[r+1][c].equals(o)) && (game[r+2][c].equals(o))) {
					return true;
				} 
			}
		}
		
		// Diagonal to Right Corner Check
		for (int r=0; r<game.length-2; r++) {
			for (int c=0; c<game[r].length-2; c++) {
				if ((game[r][c].equals(o)) && (game[r+1][c+1].equals(o)) && (game[r+2][c+2].equals(o))) {
					return true;
				} 
			}
		}
		
		// Diagonal to Left Corner Check
		for (int r=0; r<game.length-2; r++) {
			for (int c=0; c<game[r].length-2; c++) {
				if ((game[r][c+2].equals(o)) && (game[r+1][c+1].equals(o)) && (game[r+2][c].equals(o))) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean xWon(String[][] game) {
		String x = "X";
		
		// Horizontal Check
		for (int r=0; r<game.length; r++) {
			for (int c=0; c<game[r].length-2; c++) {
				if ((game[r][c].equals(x)) && (game[r][c+1].equals(x)) && (game[r][c+2].equals(x))){
					return true;
				} 
			}
		}
		
		// Column Check
		for (int r=0; r<game.length-2; r++) {
			for (int c=0; c<game[r].length; c++) {
				if ((game[r][c].equals(x)) && (game[r+1][c].equals(x)) && (game[r+2][c].equals(x))) {
					return true;
				}
			}
		}
		
		// Diagonal to Right Corner Check
		for (int r=0; r<game.length-2; r++) {
			for (int c=0; c<game[r].length-2; c++) {
				if ((game[r][c].equals(x)) && (game[r+1][c+1].equals(x)) && (game[r+2][c+2].equals(x))) {
					return true;
				} 
			}
		}
		
		// Diagonal to Left Corner Check
		for (int r=0; r<game.length-2; r++) {
			for (int c=0; c<game[r].length-2; c++) {
				if ((game[r][c+2].equals(x)) && (game[r+1][c+1].equals(x)) && (game[r+2][c].equals(x))) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean checkingValid(String[][] game) {
		int countX = 0;
		int countO = 0;
		
		for (int r=0; r<game.length; r++) {
			for (int c=0; c<game[r].length; c++) {
				if (game[r][c].equals("X")) {
					countX++;
				} else if (game[r][c].equals("O")) {
					countO++;
				}
			}
		}
		
		//System.out.println("\nX:" + countX + "\nO:" + countO);
		
		if (Math.abs(countX - countO) == 1) {
			return true;
		} else {
			System.out.println("\nNot a valid game.");
			return false;
		}
	}

	private static void readingGame(String[][] game) {
		String temp = "";
			
		try {
			Scanner input = new Scanner(new File("data/quizOne.dat"));
			for (int r=0; r<game.length; r++) {
				temp = input.nextLine();
				game[r] = temp.split(" ");
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
