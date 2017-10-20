package com.bayviewglen.queens;

import java.util.Scanner;

public class GameDriver {

	public static void main(String[] args) {
		
		Board gameBoard = new Board();
		introMessage();	
		createBoard(getN(), gameBoard);
		
	}

	private static void createBoard(int n, Board gameBoard) {
		gameBoard = new Board(n);
		
	}

	private static void introMessage() {
		System.out.println("Welcome to Queens!");
		System.out.print("Please enter the dimensions (n) for you board. The board will be n by n: ");
	}
	
	private static int getN() {
		Scanner keyboard = new Scanner(System.in);
		boolean valid = false;
		
		while (!valid) {
			try {
				int n = Integer.parseInt(keyboard.nextLine());
				valid = true;
				return n;
			} catch (NumberFormatException e){
				System.out.print("\nPlease enter a valid number: ");
			}
		}
		return 0;	
	}

}
