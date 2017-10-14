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
		driver.add(22);
		driver.add(25);
		//driver.add(3);
		
		System.out.println("---Adding---");
		printTree(driver);
		
		// find smallest 
		System.out.println("\nSmallest: " + driver.findSmallest(driver.getRoot()));
		
		// find largest
		System.out.println("\nLargest: " + driver.findLargest(driver.getRoot()));
		
		// search
		System.out.println("\nSearching for 8: " + driver.searchBST(driver.getRoot(), 9));
		
		// deleting 
		System.out.println(driver.delete(20)); // boolean works
		printTree(driver);
		//driver.delete(10);
		
		// traversal 
		//driver.inorderTraversal(driver.getRoot());
		//driver.preorderTraversal(driver.getRoot());
		//driver.postorderTraversal(driver.getRoot());
			
	}

	// --- printing --- 
	
	public static void printTree(BinarySearchTreeTesting driver) {
		print(driver);
		printLeft(driver);
		printRight(driver);
		
		/*
		if (driver.getRoot().getLeft() != null && driver.getRoot().getLeft().getLeft() == null){
			System.out.println("Left: 2nd Left Null");
		} else {
			System.out.println("\nLeft\n2nd Left: " + driver.getRoot().getLeft().getLeft().getData());
		}
		*/
		
		//System.out.println("3rd Right: " + driver.getRoot().getLeft().getLeft().getRight().getData());
		
		System.out.println("\nLeft\n2nd Left: " + driver.getRoot().getLeft().getLeft().getData());
		
		System.out.println("2nd Right: " + driver.getRoot().getLeft().getRight().getData());

		System.out.println("\nRight\n2nd Left: " + driver.getRoot().getRight().getLeft().getData());
		System.out.println("2nd Right: " + driver.getRoot().getRight().getRight().getData());

	}
	
	public static void printLeft(BinarySearchTreeTesting driver) {
		if (driver.getRoot().getLeft() == null) {
			System.out.println("Root Left is null");
		} else {
			System.out.println("Root Left: " + driver.getRoot().getLeft().getData());
		}
		
	}
	
	public static void printRight(BinarySearchTreeTesting driver) {
		if (driver.getRoot().getRight() == null) {
			System.out.println("Root Right is null");
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
