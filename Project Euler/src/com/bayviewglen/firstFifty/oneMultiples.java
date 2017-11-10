package com.bayviewglen.firstFifty;

public class oneMultiples {

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}

		System.out.println("The sum of the multiples of 3 and 5 below 1000 is: " + sum);

	}

}
