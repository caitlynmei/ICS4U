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
		
		checkingRow(sudoku);
		
	}

	private static void checkingRow(int[][] sudoku) {
		// rows 
		
	}

	private static void readingSudoku(int[][] sudoku) {
		try {
			Scanner input = new Scanner(new File("data/questionOne.dat"));
			for (int r=0; r<sudoku.length; r++) {
				for (int c=0; c<sudoku[r].length; c++) {
					sudoku[r][c] = input.nextInt();
				}
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}

}
