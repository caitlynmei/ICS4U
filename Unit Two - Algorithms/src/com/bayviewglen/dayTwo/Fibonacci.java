package com.bayviewglen.dayTwo;

public class Fibonacci {

	public static void main(String[] args) {
		int Fibonacci = 30; // 1, 1, 2, 3, 5 ... 
		int[] solutions = new int[Fibonacci + 1];

		solutions[1] = 1;

		if (Fibonacci > 2) {
			solutions[2] = 1;
		}

		for (int i = 3; i < solutions.length; i++) {
			solutions[i] = solutions[i - 1] + solutions[i - 2];
		}

		System.out.println("The " + Fibonacci + "th (st/nd/rd) number in the Fibonacci Sequence is: " + solutions[Fibonacci]);
		
	}

}
