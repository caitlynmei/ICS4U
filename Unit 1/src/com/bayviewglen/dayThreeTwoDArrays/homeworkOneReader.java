package com.bayviewglen.dayThreeTwoDArrays;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class homeworkOneReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void readingQuestions(String[][] questions) {
		Scanner input = new Scanner("data/homeworkOne.dat");
		
		for (int row = 0; row < questions.length; row++) {
			for (int column = 0; column < questions[0].length; column++) {
				questions[row][column] = input.next();
			}
		}			
	}


}
