package com.bayviewglen.dayTwoExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchAndDucking {

	public static void main(String[] args) throws FileNotFoundException { // main is ducking it now, and there's no where else to handle it
																		  // get red in console 
		// (1)
		tryCatchMethod();
		
		// (2)
		// duckingMethod(); it was thrown and now we ducked and Eclipse went down like a shot when the exception hit it in the face

		// (3)
		try {
			throwingAnExceptionWithPerfectMechanics();
		} catch (BestExceptionEver ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	
	// (1)
	private static void tryCatchMethod() {
		try {
			Scanner scanner = new Scanner(new File("data/words.dat"));
			
		} catch(FileNotFoundException ex) {
			/* the catch keeps it from crashing */
			System.out.println(ex.getMessage());
			
		} finally {
			// happens always: e.g. clean or reset stuff up 
			System.out.println("finally");
			
		}
		
	}
	
	// (2)
	private static void duckingMethod() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("data/words.dat"));		
	}
	
	// (3)
	private static void throwingAnExceptionWithPerfectMechanics() throws BestExceptionEver {
		throw new BestExceptionEver();
	}

}
