package com.bayviewglen.neighbours;

public class NeighbourFund {

	/*
	 * 2. The old song declares "Go ahead and hate your neighbor", and the residents
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
	 * { 10, 3, 2, 5, 7, 8 } Returns: 19 The maximum donation is 19, achieved by
	 * 10+2+7. It would be better to take 10+5+8 except that the 10 and 8 donations
	 * are from neighbors.
	 * 
	 */

	public static void main(String[] args) {
		int[] donations = {10, 3, 2, 5, 7, 8};
		int maxCollected = 0; // max number of donations that can be collected 
		int maxAmount = 0; // max amount of donations collected 
		int[] combinations = new int[donations.length];
		
		
		maxCollected = donations.length / 2; // num of neighbours that are willing to donate 
		
		for (int i=0; i<donations.length; i++) {
			for (int j=0; j<donations.length; j++) {
				//if ()
			}
		}
		
	}
	
	
	
	

}