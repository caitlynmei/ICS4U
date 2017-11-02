package com.bayviewglen.contiguousSubsequence;

public class ContiguousSubsequence {

	public static void main(String[] args) {

		int[] S = { 5, 15, -30, 10, -5, 40, 10 }; // original list S; input
		int[] sum = new int[S.length]; // holds the optimal sums for each index
		int maxSum = 0; // maximum sum of the optimal contiguous sequence
		int optimalStart = 0; // first index of contiguous sequence
		int optimalEnd = 0; // last index of contiguous sequence

		// starting from first index of list S, checks if next index of S should be part
		// of the optimal contiguous sequence
		for (int i = 0; i < S.length; i++) {
			if (i == 0) {
				sum[i] = S[i];
			} else {
				if (sum[i - 1] + S[i] > S[i]) {
					sum[i] = sum[i - 1] + S[i];
					optimalEnd = i;
				} else {
					sum[i] = S[i];
					optimalStart = i;
				}
			}
			if (maxSum < sum[i]) {
				maxSum = sum[i];
			}
		}

		// printing out answer to console 
		System.out.println("The contiguous subsequence would be: ");

		for (int i = optimalStart; i <= optimalEnd; i++) {
			if (i == optimalEnd) {
				System.out.print("and " + S[i]);
			} else {
				System.out.print(S[i] + ", ");
			}
		}

		System.out.print(", with a sum of " + maxSum + ".");

	}

}
