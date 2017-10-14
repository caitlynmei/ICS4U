package com.bayviewglen.daySevenTrees;

import com.bayviewglen.contactList.BinarySearchTree;
import com.bayviewglen.contactList.Contact;

public class ContactTreeTesting {

	public static void main(String[] args) {
		
		BinarySearchTree driver = new BinarySearchTree(); 
		
		Contact p1 = new Contact("H", "Maria", "123");
		Contact p2 = new Contact("Stevenson", "Erin", "6478872004");
		Contact p3 = new Contact("Downham", "Devin", "1234445");
		//Contact p4 = new Contact("Flower", "Emmy", "5555");
		//Contact p5 = new Contact("Alexiev", "Chris", "1491625"); 
	
		
		// --- adding ---
		System.out.println("---Adding---");
		driver.add(p1);
		driver.add(p2);
		driver.add(p3);
		//driver.add(p4);
		//driver.add(p5);
		//driver.add(8);
		
		printTree(driver);
		
		// find smallest 
		System.out.println("\nSmallest: " + driver.findSmallest(driver.getRoot()).getFullName());
		
		// find largest
		System.out.println("\nLargest: " + driver.findLargest(driver.getRoot()).getFullName());
		
		// --- search ---
		System.out.println("Searching: " + driver.searchBST(driver.getRoot(), "MEOW"));
		
		// --- deleting ----
	
		driver.delete("HMARIA");
		printTree(driver);
		
		// --- traversals --- 
		//driver.inorderTraversal(driver.getRoot());
			
	}

	// --- printing: for checking only --- 
	
	public static void printTree(BinarySearchTree driver) {
		print(driver);
		printLeft(driver);
		printRight(driver);
		
		//System.out.println("\nLeft\n2nd Left: " + driver.getRoot().getLeft().getLeft().getData().getFullName());
		//System.out.println("2nd Right: " + driver.getRoot().getLeft().getRight().getData().getFullName());

		//System.out.println("\nRight\n2nd Left: " + driver.getRoot().getRight().getLeft().getData().getFullName());
		//System.out.println("2nd Right: " + driver.getRoot().getRight().getRight().getData());

	}
	
	public static void printLeft(BinarySearchTree driver) {
		//System.out.println("Root Left: " + driver.getRoot().getLeft().getData().getFullName());
		
	}
	
	public static void printRight(BinarySearchTree driver) {
		System.out.println("Root Right: " + driver.getRoot().getRight().getData().getFullName());
		
	}

	public static void print(BinarySearchTree driver) {
		
		System.out.println("Root: " + driver.getRoot().getData().getFullName());
		//System.out.println("Phone #: " + driver.getRoot().getData().getPhone());
		
	}
	
}
