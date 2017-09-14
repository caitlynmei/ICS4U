package com.bayviewglen.dayThreeTwoDArrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.bayviewglen.dayTwoExceptions.BestExceptionEver;

public class homeworkOne {

	public static void main(String[] args) throws IOException {

		String[][] questions = new String[8][10];
		
		String[] answers = {"D", "B", "D", "C", "C", "D", "A", "E", "A", "D"}; 

		readingQuestions(questions);
		
		for (String[] arr : questions) {
			for (String i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		
		
		
		//System.out.println("here: " + questions[3][5]); testing 
		
		/*
		 * 
		 * 
		 * 	String[] horses = null;
		try {
			Scanner scannerFile = new Scanner(new File("Input/horses.dat"));
			int numHorses = Integer.parseInt(scannerFile.nextLine()); // take a string and turn it into an int
			horses = new String[numHorses];

			for (int i = 0; i < numHorses; i++) {
				horses[i] = scannerFile.nextLine();
			}
		} catch (FileNotFoundException e) { // in case file isn't there
			e.printStackTrace();
		}

		return horses;
	}
		FileWriter fw = new FileWriter(new File("data/homeworkOne.dat"));
		fw.write("\n");
		fw.write("This is another test...\n");
		fw.close();
		
		for (String[] arr : questions) {
			for (String i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}
		*/

	}

	public static void readingQuestions(String[][] questions) {
		Scanner input = null;
		try {
			input = new Scanner(new File("data/homeworkOne.dat"));
			
			for (int row = 0; row < questions.length; row++) {
				for (int column = 0; column < questions[0].length; column++) {
					questions[row][column] = input.next();
				}
			}		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
			
	}

}
