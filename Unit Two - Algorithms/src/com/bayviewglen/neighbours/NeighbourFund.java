package com.bayviewglen.neighbours;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NeighbourFund {

	/*
	 * #2
	 * The old song declares "Go ahead and hate your neighbor", and the residents
	 * of Onetinville have taken those words to heart. Every resident hates his
	 * next-door neighbors on both sides. Nobody is willing to live farther away
	 * from the town's well than his neighbors, so the town has been arranged in a
	 * big circle around the well. Unfortunately, the town's well is in disrepair
	 * and needs to be restored. You have been hired to collect donations for the
	 * Save Our Well fund.
	 * 
	 * Each of the town's residents is willing to donate a certain amount, as
	 * specified in the int[] donations, which is listed in clockwise order around
	 * the well. However, nobody is willing to contribute to a fund to which his
	 * neighbor has also contributed. Next-door neighbors are always listed
	 * consecutively in donations, except that the first and last entries in
	 * donations are also for next-door neighbors. You must calculate and return the
	 * maximum amount of donations that can be collected.
	 * 
	 * test case:
	 * { 10, 3, 2, 5, 7, 8 } Returns: 19 
	 * The maximum donation is 19, achieved by
	 * 10+2+7. It would be better to take 10+5+8 except that the 10 and 8 donations
	 * are from neighbors.
	 * 
	 */

	public static void main(String[] args) {
		int[] donations = { 10, 3, 2, 5, 7, 8 }; // original list of donations each neighbour is
		// willing to donate
		int[] backwardsDonations = null; // backwards list of donations each neighbour is willing to donate
		int sum = 0; // max amount of donations collected

		// testing from data file
		// read(donations);

		// checking if donations list is empty and iterating through a backwards list of
		// neighbours
		if (donations != null || donations.length > 0) {

			backwardsDonations = new int[donations.length]; // backwards list of donations each neighbour is willing to
															// donate
			for (int index = 0, i = donations.length - 1; i >= 0; i--) {
				backwardsDonations[index++] = donations[i];
			}
		}

		int[] frontSolutions = new int[donations.length]; // starting from first neighbour on list
		int[] backSolutions = new int[donations.length]; // starting from last neighbour on list

		if (donations.length <= 2 && donations.length != 0) { // 2 or less neighbours, but not 0 neighbours
			for (int i = 0; i < donations.length; i++) {
				if (i == 0) {
					frontSolutions[i] = donations[0];
				} else if (donations.length == 2 && i == 1) {
					if (donations[i] > donations[i - 1]) {
						frontSolutions[i - 1] = donations[i];
					} else {
						frontSolutions[i] = donations[0];
					}
				}
			}
		} else if (donations.length == 3) { // only 3 neighbours
			// starting from front of list
			for (int i = 0; i < donations.length; i++) {
				if (i == 1 && donations[i] > donations[i - 1]) {
					frontSolutions[i] = donations[i];
				} else {
					frontSolutions[i] = donations[0];
				}
			}

			// starting from back of list
			for (int i = 0; i < backwardsDonations.length; i++) {
				if (i == 1 && backwardsDonations[i] > backwardsDonations[i - 1]) {
					backSolutions[i] = backwardsDonations[i];
				} else {
					backSolutions[i] = backwardsDonations[0];
				}
			}

		} else { // more than 3 neighbours
			// starting from front of list
			for (int i = 0; i < donations.length; i++) {
				if (i < 3) { // i == 0 || i == 1 || i == 2
					frontSolutions[i] = donations[0];
				} else if (i == 3 && (donations[i - 1] + donations[i - 3] > donations[i - 1])) {
					frontSolutions[i] = donations[i - 1] + donations[i - 3];
				} else {
					if (donations[i - 1] + frontSolutions[i - 2] > frontSolutions[i - 1]) {
						frontSolutions[i] = donations[i - 1] + frontSolutions[i - 2];
					}
					if ((donations[i - 1] + frontSolutions[i - 3] > frontSolutions[i])
							&& (donations[i - 1] + frontSolutions[i - 3] > frontSolutions[i - 1])) {
						frontSolutions[i] = donations[i - 1] + frontSolutions[i - 3];
					}
				}
			}

			// starting from back of list
			for (int i = 0; i < backwardsDonations.length; i++) {
				if (i < 3) { // i == 0 || i == 1 || i == 2
					backSolutions[i] = backwardsDonations[0];
				} else if (i == 3
						&& backwardsDonations[i - 1] + backwardsDonations[i - 3] > backwardsDonations[i - 1]) {
					backSolutions[i] = backwardsDonations[i - 1] + backwardsDonations[i - 3];
				} else {
					if (backwardsDonations[i - 1] + backSolutions[i - 2] > backSolutions[i - 1]) {
						backSolutions[i] = backwardsDonations[i - 1] + backSolutions[i - 2];
					}
					if ((backwardsDonations[i - 1] + backSolutions[i - 3] > backSolutions[i - 1])
							&& (backwardsDonations[i - 1] + backSolutions[i - 3] > backSolutions[i])) {
						backSolutions[i] = backwardsDonations[i - 1] + backSolutions[i - 3];
					}
				}
			}
		}

		// compare front and back solutions lists --> take largest amount of donations
		for (int i = 0; i < donations.length; i++) {
			sum = 0;
			if (frontSolutions[i] > backSolutions[i]) {
				sum = frontSolutions[i];
			} else if (backSolutions[i] > frontSolutions[i]) {
				sum = backSolutions[i];
			} else {
				sum = frontSolutions[i];
			}
		}

		// printing to console 
		System.out.println("The maximum amount of donations that can be collected is: $" + sum + ".");
	}

	// testing: there are 100000 neighbours in the data file
	private static int[] read(int[] donations) {
		try {
			Scanner input = new Scanner(new File("Data/BadNeighbours.dat"));
			for (int r = 0; r < 100000; r++) {
				donations[r] = input.nextInt();
			}
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			//e.printStackTrace();
		}
		return donations;

	}
}