package com.bayviewglen.dayTwo;

public class Coins {

	public static void main(String[] args) {
		int sum = 11; // user's desired amount
		int[] combinations = new int[sum + 1];
		int[] solutions = new int[sum + 1];

		// coin values
		int[] coins = { 1, 3, 5 };

		getMaxCombos(combinations, coins);

		getMinCombos(solutions, coins);

		System.out.println(
				"There are " + combinations[sum] + " combinations for this amount of money using the coins we have.");
		
		System.out.println(
				"There are " + solutions[sum] + " optimal solutions for this amount of money using the coins we have.");

	}

	private static void getMinCombos(int[] solutions, int[] coins) {		
		// optimal solutions 
		for (int coin : coins) {
			for (int i = 1; i < solutions.length; i++) {
				if (coin == 1) {
					solutions[i] += solutions[i - coin] + 1;
				} else if (i >= coin && solutions[i - coin] + 1 < solutions[i]) {
					solutions[i] = solutions[i - coin] + 1;
				}
			}
		}

	}

	private static void getMaxCombos(int[] combinations, int[] coins) {
		combinations[0] = 1;

		// total amount of combinations
		for (int coin : coins) {
			for (int i = 1; i < combinations.length; i++) {
				if (i >= coin) {
					combinations[i] += combinations[i - coin];
				}
			}
		}

		combinations[0] = 0; // because technically no combos for 0

	}

}
