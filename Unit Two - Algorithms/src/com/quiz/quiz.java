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
		int[][] data = readingData(); 
		
		/*
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
*/
	}

	private static int[][] readingData() {
		int[][] data = null;
		int[] n = null;
		
		try {
			Scanner input = new Scanner(new File("Data/Quiz.dat"));

			while (input.hasNext()) {
				int numCases = Integer.parseInt(input.nextLine().trim());
				
				data = new int[numCases][];
				n = new int[numCases];
				
				for (int i = 0; i < numCases; i++) {
					n[i] = Integer.parseInt(input.next());
					int temp[] = new int[3];
					for (int j = 0; j < 3; j++) {
						temp[j] = Integer.parseInt(input.next());
						data[i] = temp;
					}
				}
			}
			input.close();
			
			//print(n, data);
			
			int[][] solutions = findSolutions(n, data);
			
			printSolutions(n, solutions);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File note found.");
		}

		return data;
	}

	private static void printSolutions(int[] n, int[][] solutions) {
		for (int r=0; r<solutions.length; r++) {
			System.out.println("Test Case #" + (r+1));
			System.out.print("n: " + n[r] + "\nSolutions: ");
			for (int c=0; c<solutions[0].length; c++) {
				System.out.print(solutions[r][c] + " ");
			}
			System.out.println("\n");
		}
	}

	private static int[][] findSolutions(int[] n, int[][] data) {
		int[][] fullSolutions = new int[data.length][];
		String[][] fullSteps = new String[data.length][];
		for (int r=0; r<data.length; r++) {
			int sum = n[r];
			String[] steps = new String[sum + 1];

			int[] options = new int[4];
			options[0] = 1;
			
			// placing 4 options into an array; "options"
			for (int c=1; c<options.length; c++) {
				options[c] = data[r][c-1];
			}		
			int[] solutions = new int[sum+1]; 
			
			// going through the 4 options
			for (int option : options) {
				for (int i = 2; i <= sum; i++) {
 					solutions[1] = 0;
					if (option == 1) {
						solutions[i] = solutions[i - 1] + 1;
						//steps[i] += "subtract " + option + ", ";
					} else if (i % option == 0) {
						solutions[i] = Math.min(solutions[i], 1 + solutions[i/option]);
						if (solutions[i/option] + 1 < solutions[i]) {
							//steps[i] += "divide by " + option + ", ";
						} else if (solutions[i/option] + 1 <= solutions[i]){
							//steps[i] += "divide " + option + ", ";
						}
					}
 				}
			}
			fullSolutions[r] = solutions;
		}
		return fullSolutions;
	}

	private static void print(int[] n, int[][] data) {
		for (int r=0; r<data.length; r++) {
			System.out.println("Test Case #" + (r+1));
			System.out.print("n: " + n[r] + "\nOptions: ");
			for (int c=0; c<data[0].length; c++) {
				System.out.print(data[r][c] + " ");
			}
			System.out.println("\n");
		}
	}
}
