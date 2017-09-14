package com.bayviewglen.dayThreeTwoDArrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.bayviewglen.dayTwoExceptions.BestExceptionEver;

public class HomeworkOne {

	public static void main(String[] args) throws IOException {

		String[][] questions = new String[8][10];
		
		String[] answers = {"D", "B", "D", "C", "C", "D", "A", "E", "A", "D"}; 

		readingQuestions(questions);
		
		/* testing questions array 
		for (String[] arr : questions) {
			for (String i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}*/
		
		int[] marks = new int[8];
		
		checkingAnswers(questions, answers, marks);
		
		for (int i=0; i<questions.length; i++) {
			System.out.println("Student " + i + "\'s correct count is " + marks[i] + ".");
		}
		
		/* testing marks array
		for (int i : marks) {
			System.out.println(i);
		}
		*/
		
		//System.out.println("here: " + questions[3][5]); testing 
		
	}

	public static void readingQuestions(String[][] questions) {
		Scanner input = null;
		try {
			input = new Scanner(new File("data/homeworkOne.dat"));
			
			for (int row = 0; row < questions.length; row++) {
				for (int column = 0; column < questions[row].length; column++) {
					questions[row][column] = input.next();
				}
			}		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void checkingAnswers(String[][] questions, String[] answers, int[] marks) {
		
		for (int r = 0; r<questions.length; r++) {
			for (int c=0; c<questions[r].length; c++) {
				if (questions[r][c].compareTo(answers[c]) == 0) {
					marks[r]++;
				}
			}
		}		
	}

}
