package com.bayviewglen.dayThreeTwoDArrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class questionOne {

	public static void main(String[] args) {

		int[][] sudoku = new int[9][9];

		readingSudoku(sudoku);

		// checking
		for (int[] arr : sudoku) {
			for (int i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}

		if (checkingRow(sudoku) && checkingColumn(sudoku)) {
			System.out.println("This is a valid solution.");
		}

	}

	private static boolean checkingColumn(int[][] sudoku) {
		System.out.println("Columns");
		
		int[] count = new int[sudoku.length];
		int temp = 0;
		
		for (int c = 0; c < sudoku[0].length; c++) {
			for (int r = 0; r < sudoku.length-1; r++) {
				temp = sudoku[r][c];
				for (int i = 8; i > r; --i) {
					System.out.println(temp + " : " + sudoku[i][c]);
					if (temp == sudoku[i][c]) {
						count[c]++;
					}
				}
				System.out.println();
			}
			System.out.println();
			if (count[c] != 0) {
				System.out.println("This is not a valid solution.");
				return false;
			}
		}
		return true;
	}

	/*
	 * private static int sequentialSearch(int[] numbers, int findMe){
		for (int i=0; i<numbers.length; ++i){
			if (numbers[i] == findMe)
				return i;
		}
		
		return -1;
	}
	 */
	
	private static boolean checkingRow(int[][] sudoku) {
		int[] count = new int[sudoku.length];
		int temp = 0;
	
		System.out.println();
		
		for (int r = 0; r < sudoku.length; r++) {
			for (int c = 0; c < sudoku[r].length-1; c++) {
				temp = sudoku[r][c];
				for (int i = 8; i > c; --i){
				//for (int i=1; i< sudoku[r].length-c-1; ++i){
					System.out.println(temp + " : " + sudoku[r][i]);
					if (temp == sudoku[r][i]) {
						count[r]++;
					}
				}
				System.out.println();
				
				//System.out.println(sudoku[tempR][tempC] + " : " + sudoku[r][c+1]);
				/*if (sudoku[r][tempC] == sudoku[r][c+1]) {
					count[r]++;
				}*/
			}
			System.out.println();
			if (count[r] != 0) {
				System.out.println("This is not a valid solution.");
				return false;
			} 			
			//tempC++;
		}
		return true;

	}

	private static void readingSudoku(int[][] sudoku) {
		try {
			Scanner input = new Scanner(new File("data/questionOne.dat"));
			for (int r = 0; r < sudoku.length; r++) {
				for (int c = 0; c < sudoku[r].length; c++) {
					sudoku[r][c] = input.nextInt();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
