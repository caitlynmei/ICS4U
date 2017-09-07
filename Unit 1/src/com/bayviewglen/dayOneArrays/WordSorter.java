package com.bayviewglen.dayOneArrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WordSorter {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String[] allWords = new String[1000];
		int wordCount = 0;
		
		Scanner input = new Scanner(new File("Data/words.dat"));
		
		while (input.hasNext()) {
			String word = input.next();
			allWords[wordCount] = word;
			wordCount++;
		}
		
		input.close();
		allWords = truncateArray(allWords, wordCount);
		Arrays.sort(allWords);
		
		for (int i=0; i<wordCount; i++) {
			System.out.println(allWords[i]);
		}
				
		allWords = removeMiddleWord(allWords);
		System.out.println("----\n");
		
		for (int i=0; i<allWords.length-1; i++) {
			System.out.println(allWords[i]);
		}
		
	}
	
	private static String[] truncateArray(String[] allWords, int wordCount) {
		
		String[] temp = new String[wordCount];
		
		for (int i=0; i<wordCount; i++) {
			temp[i] = allWords[i];
		}
		
		return temp;
	}

	private static String[] removeMiddleWord(String[] allWords) {
		
		String[] temp = new String[allWords.length-1];
		//int midIndex = allWords.length/2;
		
		for (int i=0; i<allWords.length; i++) {
			if (i > allWords.length/2) {
				temp[i-1] = allWords[i];
			} else if (i < allWords.length/2){
				temp[i] = allWords[i];
			}
		}
		
		return temp;
	}
	
}
