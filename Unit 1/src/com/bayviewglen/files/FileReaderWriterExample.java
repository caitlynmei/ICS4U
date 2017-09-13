package com.bayviewglen.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderWriterExample {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(new File("data/fileReaderExample.dat"));
		fw.write("This is a test...\n");
		fw.write("This is another test...\n");
		fw.close();
		
		// ^ put in a for loop, adapt for contacts. 
		
		String str = "Caitlyn : Mei : 535";
		String[] split = str.split(" : "); // , 2
		
		for(String x : split) {
			System.out.println(x);
		}
	
		// Buffered Reader --> faster
		// Below is incorrect... 
		/*FileInputStream fis = new FileInputStream(); 
		BufferedReader fr = new BufferedReader(new InputStreamReader(new File("data/fileReaderExample.dat\""));
		
		fr.close();
		
		String line2;
		while(scanner.hasNext()) {
			line2 = scanner.nextLine();
			System.out.println(line2);
		}*/
		
		// compareable interface		
		
	}

}
