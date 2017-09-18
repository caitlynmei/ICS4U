package com.bayviewglen.dayThreeTwoDArrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionOneCoordinates {

	public static void main(String[] args) {
		
		double[][] coordinates = new double[8][2];
		String[][] reading = new String[8][2];
		
		readCoordinates(reading, coordinates);
		
		// checking 
		/* 
		for (String[] arr : reading) {
			for (String str : arr) {
				System.out.print(str + " ");
			}
			System.out.println();
		}*/
		
		for (double[] arr : coordinates) {
			for (double i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}

	}

	private static void readCoordinates(String[][] reading, double[][] coordinates) {
		String temp = "";

		try {
			Scanner input = new Scanner(new File("data/questionOneCoordinates.dat"));
			for (int r=0; r<reading.length; r++) {
				temp = input.nextLine();
				reading[r] = temp.split(" ");
			}
		
			for (int r = 0; r < coordinates.length; r++) {
				for (int c = 0; c < coordinates[r].length; c++) {
					coordinates[r][c] = Double.parseDouble(reading[r][c]);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
}
