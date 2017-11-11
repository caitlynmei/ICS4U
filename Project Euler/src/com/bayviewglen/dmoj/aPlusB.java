package com.bayviewglen.dmoj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class aPlusB {

	/*
	 * A Plus B
	 * 
	 * Xyene is sitting in math class, on his laptop. Clearly, he is not paying
	 * attention in this situation. However, he gets called on by his math teacher
	 * to do some problems. Since his math teacher did not expect much from Xyene,
	 * he only needs to do some simple addition problems. However, simple for you
	 * and I may not be simple for Xyene, so please help him!
	 * 
	 * Input Specification:
	 * 
	 * The first line will contain an integer NN (1<=N<=100000), the number of
	 * addition problems Xyene needs to do. The next NN lines will each contain two
	 * space-separated integers whose absolute value is less than 1000000000, the
	 * two integers Xyene needs to add.
	 * 
	 * Output Specification:
	 * 
	 * Output NN lines of one integer each, the solutions to the addition problems
	 * in order.
	 */

	public static void main(String[] args) {

		read();
	}

	private static void read() {
		int a = 0;
		int b = 0;

		try {
			Scanner input = new Scanner(new File("DMOJ/aPlusB.dat"));

			while (input.hasNext()) {
				int n = Integer.parseInt(input.nextLine());
				int[] sum = new int[n];

				for (int i = 0; i < n; i++) {
					a = input.nextInt();
					b = input.nextInt();
					sum[i] = a + b;
					System.out.println(sum[i]);
				}
			}
			
			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			//e.printStackTrace();
		}

	}

}
