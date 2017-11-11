package com.bayviewglen.zigzag;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZigZag {

	/*
	 * #1 
	 * A sequence of numbers is called a zig-zag sequence if the differences
	 * between successive numbers strictly alternate between positive and negative.
	 * The first difference (if one exists) may be either positive or negative. A
	 * sequence with fewer than two elements is trivially a zig-zag sequence.
	 * 
	 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences
	 * (6,-3,5,-7,3) are alternately positive and negative. In contrast, 1,4,7,2,5
	 * and 1,7,4,5,5 are not zig-zag sequences, the first because its first two
	 * differences are positive and the second because its last difference is zero.
	 * 
	 * Given a sequence of integers, sequence, return the length of the longest
	 * subsequence of sequence that is a zig-zag sequence. A subsequence is obtained
	 * by deleting some number of elements (possibly zero) from the original
	 * sequence, leaving the remaining elements in their original order.
	 * 
	 */

	public static void main(String[] args) {

		int[] S = { 5, 100, 99, 99, 99, 0, 5, 2 }; // original sequence
		int[] differences = new int[S.length - 1]; // differences of sequence

		// testing from data file
		// read(S);

		// for tracking the amount of increasing and decreasing differences that make a
		// zig-zag
		int[] increasing = new int[S.length];
		int[] decreasing = new int[S.length];

		// for tracking if the previous difference of sequence is positive or negative
		boolean isPositive = false;
		boolean isNegative = false;

		// for finding the greatest number of zig-zags tracked 
		int longestLength = 0;

		if (S.length < 2 && S.length != 0) {
			longestLength = S.length;
		} else { // S.length >= 2
			for (int i = 0; i < S.length - 1; i++) {
				differences[i] = S[i + 1] - S[i];
			}

			increasing[0] = 1;
			decreasing[0] = 1;

			for (int i = 0; i < differences.length; i++) {
				if (i == 0) {
					if (differences[i] > 0) {
						increasing[i + 1] = increasing[i] + 1;
						decreasing[i + 1] = decreasing[i];
						isPositive = true;
					} else if (differences[i] < 0) {
						decreasing[i + 1] = decreasing[i] + 1;
						increasing[i + 1] = increasing[i];
						isNegative = true;
					}
				} else {
					if (differences[i] > 0 && !isPositive) {
						increasing[i + 1] = decreasing[i] + 1;
						decreasing[i + 1] = decreasing[i];
						isPositive = true;
						isNegative = false;
					} else if (differences[i] < 0 && !isNegative) {
						decreasing[i + 1] = increasing[i] + 1;
						increasing[i + 1] = increasing[i];
						isNegative = true;
						isPositive = false;
					} else {
						increasing[i + 1] = increasing[i];
						decreasing[i + 1] = decreasing[i];
					}
				}
			}

			for (int i = 0; i < S.length; i++) {
				if (increasing[i] > longestLength) {
					longestLength = increasing[i];
				} else if (decreasing[i] > longestLength) {
					longestLength = decreasing[i];
				}
			}
		}

		// printing to console 

		System.out.print("Given the sequence: ");

		for (int i = 0; i < S.length; i++) {
			if (i == S.length - 1) {
				System.out.print("and " + S[i]);
			} else {
				System.out.print(S[i] + ", ");
			}
		}

		System.out
				.print(", the length of the longest subsequence that is a zig-zag sequence is: " + longestLength + ".");
	}

	// testing: there are 1000 numbers in the data file
	public static int[] read(int[] S) {
		try {
			Scanner input = new Scanner(new File("Data/ZigZag.dat"));
			for (int r = 0; r < 1000; r++) {
				S[r] = input.nextInt();
			}
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			//e.printStackTrace();
		}
		return S;

	}

}
