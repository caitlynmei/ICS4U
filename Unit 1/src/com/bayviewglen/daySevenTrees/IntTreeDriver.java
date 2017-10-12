package com.bayviewglen.daySevenTrees;

public class IntTreeDriver {

	public static void main(String[] args) {
		
		BinarySearchTreeTesting driver = new BinarySearchTreeTesting(); 
		
		// adding
		
		driver.add(10);
		driver.add(7);
		driver.add(20);
		driver.add(2);
		driver.add(18);
		driver.add(8);
		
		System.out.println("---Adding---");
		printTree(driver);
		
		// find smallest 
		System.out.println("\nSmallest: " + driver.findSmallest(driver.getRoot()));
		
		// find largest
		System.out.println("\nLargest: " + driver.findLargest(driver.getRoot()));
		
		// search
		//System.out.println("\nSearching for 8: " + driver.searchBST(driver.getRoot(), 8));
		
		// deleting 
		
		System.out.println(driver.delete(7)); // boolean works
		printTree(driver);
		//driver.delete(10);
		
		//System.out.println("Delete: 7");
		//driver.delete(7);
		//printTree(driver);
		
		//System.out.println("\nDeleting");
		//printRight(driver);
		
		//driver.inorderTraversal(driver.getRoot());
			
	}

	// --- printing --- 
	
	public static void printTree(BinarySearchTreeTesting driver) {
		print(driver);
		printLeft(driver);
		printRight(driver);
		
		System.out.println("\nLeft\n2nd Left: " + driver.getRoot().getLeft().getLeft().getData());
		System.out.println("2nd Right: " + driver.getRoot().getLeft().getRight().getData());

		System.out.println("\nRight\n2nd Left: " + driver.getRoot().getRight().getLeft().getData());
		//System.out.println("2nd Right: " + driver.getRoot().getRight().getRight().getData());

	}
	
	public static void printLeft(BinarySearchTreeTesting driver) {
		if (driver.getRoot() == null) {
			System.out.println("Root is null");
		} else {
			System.out.println("Root Left: " + driver.getRoot().getLeft().getData());
		}
		
	}
	
	public static void printRight(BinarySearchTreeTesting driver) {
		if (driver.getRoot() == null) {
			System.out.println("Root is null");
		} else {
			System.out.println("Root Right: " + driver.getRoot().getRight().getData());
		}
		
	}

	public static void print(BinarySearchTreeTesting driver) {
		
		if (driver.getRoot() == null) {
			System.out.println("Root is null");
		} else {
			System.out.println("Root: " + driver.getRoot().getData());
		}
	}
	
}
