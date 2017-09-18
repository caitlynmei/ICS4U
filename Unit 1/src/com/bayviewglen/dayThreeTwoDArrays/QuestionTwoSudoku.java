package com.bayviewglen.dayThreeTwoDArrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionTwoSudoku {

	public static void main(String[] args) {

		int[][] sudoku = new int[9][9]; // full 
		int[][] miniSudoku = new int[3][3]; // 3 by 3

		readingSudoku(sudoku);

		// Printing out sudoku
		for (int[] arr : sudoku) {
			for (int i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}

		
		if (checkingRow(sudoku) && checkingColumn(sudoku)) {
			if (checkingMiniSudoku(sudoku, miniSudoku)) {
				System.out.println("\nThis is a valid solution.");
			}
		}

	}

	private static boolean checkingMiniSudoku(int[][] sudoku, int[][] miniSudoku) {
		for (int r = 0; r < sudoku.length; r+=3) {
			for (int c = 0; c < sudoku[r].length; c+=3) {				
				int count = 0;
				
				for (int i = r; i < r+3; i++) {
					for (int j = c; j < c+3; j++) {
						count += sudoku[i][j];
					}
				}
				
				for (int i = 0; i < sudoku.length; i++) {
					if (count != 45) {
						System.out.println("\nThis is not a valid solution.");
						return false;
					}
				}
			}
		}
		
		return true;
		
		/*
		for (int r = 0; r < sudoku.length; r += 3) {
		    for (int c = 0; c < sudoku.length; c += 3) {
		        int[] count = new int[sudoku.length];
		        for (int i = r; i < r + 3; i++) {
		            for (int j = c; j < c + 3; j++) {
		                count[sudoku[i][j]]++;
		            }
		        }
		        for (int i = 0; i < sudoku.length; i++) {
		            if (count[i] != 1) {
		                System.out.println("BAD");
		            }
		        }
		    }
		}*/
	}

	// full sudoku
	private static boolean checkingColumn(int[][] sudoku) {
		int[] count = new int[sudoku.length];
		int temp = 0;
		
		for (int c = 0; c < sudoku[0].length; c++) {
			for (int r = 0; r < sudoku.length-1; r++) {
				temp = sudoku[r][c];
				for (int i = 8; i > r; --i) {
					if (temp == sudoku[i][c]) {
						count[c]++;
					}
				}
			}
			if (count[c] != 0) {
				System.out.println("This is not a valid solution.");
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkingRow(int[][] sudoku) {
		int[] count = new int[sudoku.length];
		int temp = 0;
	
		for (int r = 0; r < sudoku.length; r++) {
			for (int c = 0; c < sudoku[r].length-1; c++) {
				temp = sudoku[r][c];
				for (int i = 8; i > c; --i){
					if (temp == sudoku[r][i]) {
						count[r]++;
					}
				}
			}
			if (count[r] != 0) {
				System.out.println("This is not a valid solution.");
				return false;
			} 			
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
