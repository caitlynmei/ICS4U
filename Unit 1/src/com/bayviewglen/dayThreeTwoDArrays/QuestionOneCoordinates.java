package com.bayviewglen.dayThreeTwoDArrays;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionOneCoordinates {

	public static void main(String[] args) {
	
		Point2D[] points = readCoordinates();	
		
		//double points[1]
		

		// checking 
		for (int i=0; i< points.length; i++) {
			System.out.print(points[i].getX() + ", " + points[i].getY() + "\n");
		} 
	
	}

	private static Point2D[] readCoordinates() {
		Point2D[] points = null;
		try {
			Scanner scanner = new Scanner(new File("data/questionOneCoordinates.dat"));
			points = new Point2D[Integer.parseInt(scanner.nextLine())];
			
			for(int i = 0; i < points.length; i++) {
				points[i] = new Point2D.Double(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return points;
	}

}
