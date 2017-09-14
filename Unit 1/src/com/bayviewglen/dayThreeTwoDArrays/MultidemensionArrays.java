package com.bayviewglen.dayThreeTwoDArrays;

public class MultidemensionArrays {

	public static void main(String[] args) {
		char[][] words = new char[3][];

		
		words[0] = "cipher".toCharArray();
		words[1] = "hiccup".toCharArray();
		words[2] = "laughable".toCharArray();
		words[1] = words[2]; // we did not change the size of the array held hiccup, we pointed to a new array instead 
				
		
		// adding 2 onto each char (to ASCII number) 
		for (int i=0; i<words.length; i++) {
			for (int j=0; j<words[i].length; j++) {
				words[i][j] += 2;
			}
		}	
		
		// modified "laughable" in words[1], by 2
		// modified the new version in words[2], by 2, thus overall by 4 
		
		
		for (char[] arr : words) {
			for (char i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		/*
		for (char[] arr : words) {
			for (char i : arr) {
				i += 2;
			}
		}	
		*/
		
		// words[0] = {'c', 'i', 'p', 'h', 'e', 'r'}; <-- doesn't work
		
		
		
	}

}
