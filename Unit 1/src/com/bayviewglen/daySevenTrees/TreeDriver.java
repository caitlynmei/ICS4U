package com.bayviewglen.daySevenTrees;

public class TreeDriver {

	public static void main(String[] args) {
		
		BinarySearchTree driver = new BinarySearchTree(); 
		
		driver.add(10);
		driver.add(7);
		driver.add(20);
		driver.add(2);
		driver.add(18);
		driver.add(8);
		
		driver.inorderTraversal(driver.getRoot());
		
		driver.delete(driver.getRoot(), 7);
			
	}

	public void print(BinarySearchTree driver) {
		System.out.println(driver);
	}
	
}
