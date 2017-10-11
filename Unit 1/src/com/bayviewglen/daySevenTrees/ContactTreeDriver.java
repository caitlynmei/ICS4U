package com.bayviewglen.daySevenTrees;

public class ContactTreeDriver {

	public static void main(String[] args) {
		
		BinarySearchTree driver = new BinarySearchTree(); 
		
		Contact p1 = new Contact("Erin", "Stevenson", "6478872004");
		
		// adding
		
		driver.add(p1);
		//driver.add(7);
		//driver.add(20);
		//driver.add(2);
		//driver.add(18);
		//driver.add(8);
		
		System.out.println("---Adding---");
		printTree(driver);
		
		// find smallest 
		System.out.println("\nSmallest: " + driver.findSmallest(driver.getRoot()));
		
		// find largest
		System.out.println("\nLargest: " + driver.findLargest(driver.getRoot()));
		
		// search
		//System.out.println("\nSearching for 8: " + driver.searchBST(driver.getRoot(), 8));
		
		// deleting 
		
		//System.out.println(driver.delete(1)); // boolean works
		//driver.delete(10);
		
		System.out.println("Delete: 7");
		//driver.delete(7);
		printTree(driver);
		
		//System.out.println("\nDeleting");
		//printRight(driver);
		
		//driver.inorderTraversal(driver.getRoot());
			
	}

	// --- printing --- 
	
	public static void printTree(BinarySearchTree driver) {
		print(driver);
		printLeft(driver);
		printRight(driver);
		
		System.out.println("\nLeft\n2nd Left: " + driver.getRoot().getLeft().getLeft().getData().getFullName());
		System.out.println("2nd Right: " + driver.getRoot().getLeft().getRight().getData().getFullName());

		System.out.println("\nRight\n2nd Left: " + driver.getRoot().getRight().getLeft().getData().getFullName());
		//System.out.println("2nd Right: " + driver.getRoot().getRight().getRight().getData());

	}
	
	public static void printLeft(BinarySearchTree driver) {
		System.out.println("Root Left: " + driver.getRoot().getLeft().getData().getFullName());
		
	}
	
	public static void printRight(BinarySearchTree driver) {
		System.out.println("Root Right: " + driver.getRoot().getRight().getData().getFullName());
		
	}

	public static void print(BinarySearchTree driver) {
		
		System.out.println("Root: " + driver.getRoot().getData().getFullName());
		System.out.println("Phone #: " + driver.getRoot().getData().getPhone());
		
	}
	
}
