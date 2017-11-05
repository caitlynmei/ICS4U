package com.bayviewglen.zigzag;

public class ZigZag {

	/*
	 * 1. A sequence of numbers is called a zig-zag sequence if the differences
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

		int[] S = { 1, 4, 3, -7, 2 }; // original sequence
		int[] increasing = new int[S.length]; // differences
		int[] decreasing = new int[S.length]; // differences
		int optimalStart = 0; // first index of zig-zag sequence
		int optimalEnd = 0; // last index of zig-zag sequence
		int longestLength = 0;

		boolean isPositive = false;

		 int increasingStart = 0;
		// int increasingEnd = 0;
		 int decreasingStart = 0;
		// int decreasingEnd = 0;

		if (S.length < 2 && S.length != 0) { // check if S.length = null works
			longestLength = S.length;
		} else { // S.length >= 2
			for (int i = 0; i < S.length; i++) {
				if (i == 0) {
					increasing[i] = 1;
					decreasing[i] = 1;
				} else {
					if (i == 1) {
						if (S[i] - S[i - 1] > 0) { // if zig-zag is positive
							//isPositive = true;
							increasingStart = i;
							increasing[i] = increasing[i - 1] + 1;
							decreasing[i] = decreasing[i - 1];
						} else if (S[i] - S[i - 1] < 0) { // if zig-zag is negative
							//isPositive = false;
							decreasingStart = i;
							decreasing[i] = decreasing[i - 1] + 1;
							increasing[i] = increasing[i - 1];
						}
						
					} else {
						if (S[i] - S[i - 1] > 0 && isPositive) { // if zig-zag is positive
							isPositive = true;
							increasingStart = i;
							increasing[i] = increasing[i - 1] + 1;
							decreasing[i] = decreasing[i - 1];

						} else if (S[i] - S[i - 1] < 0 && !isPositive) { // if zig-zag is negative
							isPositive = false;
							decreasingStart = i;
							decreasing[i] = decreasing[i - 1] + 1;
							increasing[i] = increasing[i - 1];
							
						}
					}
				}
			}
		}

	}

}
