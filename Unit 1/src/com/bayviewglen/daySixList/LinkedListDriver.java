package com.bayviewglen.daySixList;

public class LinkedListDriver {

	public static void main(String[] args) {
		
		LinkedList driver = new LinkedList();
		print(driver);
		
		// ---- add methods ----
		
		// addFirst(int value) OK
		driver.addFirst(1);
		print(driver);
		
		driver.addFirst(2);
		print(driver);
		
		driver.addFirst(3);
		print(driver);
		
		// add(int value) ****
		//driver.add(10); // returns true
		//print(driver);
		
		// add(int index, int value) OK
		driver.add(1, 4);
		System.out.print("add at index: ");
		print(driver);
		
		// clear() OK
		//driver.clear();
		//print(driver);
		
		// contains(int value) OK
		//System.out.println("contains: " + driver.contains(6));
		
		// get(int index) OK
		//System.out.println("get: " + driver.get(2));
		
		// getFirst() OK
		//System.out.println("getFirst: " + driver.getFirst());

		// getLast() OK
		//System.out.println("getLast : " + driver.getLast());

		// remove() OK
		//System.out.println(driver.remove());
		
		// remove(int index) OK
		//driver.remove(2);
		//print(driver);
		
		// removeFirstOccurrence(int value) OK
		//driver.removeFirstOccurrence(2); // boolean works
		//print(driver);
		
		// removeLast(); OK
		//driver.removeLast();
		//print(driver);
		
		
		
	}

	public static void print(LinkedList driver) {
		System.out.println("Linked List: ");
		
		if (driver.size() == 0) {
			System.out.println("Null");
		}
		
		for (int i=0; i<driver.size(); i++) {
			//System.out.println(driver.getData());
			System.out.print(driver.get(i));
		}
		System.out.println();
	}
	
}
