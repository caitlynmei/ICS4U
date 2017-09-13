package com.bayviewglen.dayThreeTwoDArrays;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class homeworkOne {

	public static void main(String[] args) throws IOException {

		String[][] questions = new String[8][10];
		
		Scanner input = new Scanner("data/homeworkOne.dat");

		
		
		while (input.hasNext()) {
			for (int row = 0; row < questions.length; row++) {
				for (int column = 0; column < questions[0].length; column++) {
					questions[row][column] = input.next();
				}
			}
		}

	
		/*
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

}
