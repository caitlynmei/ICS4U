package com.bayviewglen.dayThreeTwoDArrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionTwo {

	public static void main(String[] args) {
		
		double[][] coordinates = new double[8][8];
		String[][] reading = new String[8][];
		
		readCoordinates(reading, coordinates);
		
		for (String[] arr : reading) {
			for (String i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		/*
		for (double[] arr : coordinates) {
			for (double i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}*/

	}

	private static void readCoordinates(String[][] reading, double[][] coordinates) {
		String x;
		//String[] str = new String[reading.length];
		
		try {
			Scanner input = new Scanner(new File("data/questionTwo.dat"));
			
			/*String str = "Caitlyn : Mei : 535";
			String[] split = str.split(" : "); // , 2
			 */
			
			for (int r = 0; r < reading.length; r++) {
				for (int c = 0; c < reading[r].length; c++) {
					x = input.nextLine();
					System.out.println(x);
					
					reading = x.split(" "); 
					
					/* checking
					for (String i : str) {
						System.out.println(i);
					} */
					
				}
				
			}
			
			/*
			for (int r = 0; r < coordinates.length; r++) {
				for (int c = 0; c < coordinates[r].length; c++) {
					coordinates[r][c] = Double.parseDouble(reading[r][c]);
				}
			}*/
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
}
