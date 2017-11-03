package com.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class quiz {

	/*
	 * Dynamic Programming Quiz
	 * 
	 * Given a number what are the fewest number of steps that can be taken to bring
	 * that number to 1 given a set of options that can be taken.
	 * 
	 * There will always be 3 options including the ability to subtract 1 from the
	 * number. The starting value and the 3 options (which you can divide the
	 * current n if possible) will be supplied in a file. The test file will contain
	 * x test cases and as a result will contain 2x lines. Where the first line is n
	 * and the second line is the 3 options in which you can use to divide and make
	 * your starting value smaller. [10T Marks]
	 * 
	 * The test file you should use for your testing should be created using the
	 * following test cases. State what steps were taken to achieve this. [5T Marks]
	 * 
	 * 10 3 4 5 200 10 4 25 1728 2 3 6 65 1 1 1 85 4 7 9 123 1 2 3 999 999 100 1
	 */

	public static void main(String[] args) {
		int[] factors = new int[4]; // the 4 options to get to 1
		readingNumbers(factors);

		int[] data = new int[4];
		int sum = data[0];
		String[] steps = new String[sum + 1];

		int[] solutions = new int[sum + 1];

		for (int num : data) {
			System.out.print(num + " ");
		}

		factors[0] = 1;
		for (int i = 1; i < data.length; i++) {
			factors[i] = data[i];
		}

		// going through the 4 options
		for (int factor : factors) {
			for (int i = 1; i < solutions.length; i++) {
				solutions[1] = 0;
				if (factor == 1) {
					solutions[i] = solutions[i - 1] + 1;
					steps[i] += "subtract " + factor;
				} else if (i >= factor && i % factor != 0 && solutions[i / factor] + 1 > solutions[i]) { // factor can't
																											// be a
																											// multiple
																											// of i or
																											// else you
																											// get to 0
					solutions[i] = solutions[i / factor] + 1;
					steps[i] = "divide by " + factor;
				}
			}
		}

		System.out.println("The steps taken to reach " + sum + " were: ");

		// okay, I know the printing steps part doesn't work, but I would have created
		// an individual counter per factor, and in the end use that to tell me how many
		// times I used each factor.

		for (int i = 0; i < steps.length; i++) {
			if (i == steps.length - 1) {
				System.out.println("and " + steps[i]);
			}
			System.out.print(steps[i] + ", ");
		}

		System.out.print(", using " + solutions[sum] + " steps.");

	}

	private static void readingNumbers(int[] data) {
		int temp = 0;

		try {
			Scanner input = new Scanner(new File("Quiz.dat"));
			for (int i = 0; i < 4; i++) { // assuming it gives me the next 4 numbers , so just one case
				data[i] = input.nextInt();
			}

			/*
			 * for (int r = 0; r < solutions.length; r++) { temp = input.nextLine();
			 * solutions[r] = temp.split(" "); }
			 */

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
