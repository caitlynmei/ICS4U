package com.bayviewglen.daySixList;

import java.util.NoSuchElementException;

public class LinkedList {

	private IntNode head;
	private IntNode tail;
	private int numNodes;
	
	public LinkedList () {
		head = null;
		tail = null;
		numNodes = 0; 
	}

	// Adds the specified element to the end of this list 
	public boolean add(int x) { // add onto tail
		IntNode temp; // to hold tail?
		
		if (numNodes == 0) {
			addFirst(x); // The linked list is empty. I need to make sure head and tail both points to it. 
		} else if (numNodes >= 1){
			tail = new IntNode(x, tail);
			numNodes += 1;
		} 
		
		return true;
	}
	
	// Inserts the specified element at the specified position in this list 
	// ****HOW DO I ACCESS NODES THAT AREN'T HEAD/TAIL?
	private void add(int index, int value) {
		if (numNodes == 0) {
			addFirst(value);
			// check for empty link -- if they give you one that's out of bounds, throw an exception 
		}
		
		IntNode previous = head;

		for (int i=0; i<numNodes; i++) {
			if (i == index-1) {
				
			}
			previous = previous.getLink();
		}
		
		// use a for loop to iterate 
		
		if (previous.equals(value)) {
			for (int i=0; i<numNodes; i++) {
				previous = new IntNode(value, previous.getLink());
			}
		}
		
		//previousIndex = previousIndex.getLink();
		//previousIndex.getLink() = new IntNode(value, previousIndex.getLink());
	}
	
	// Inserts specified element at the beginning of this list 
	public void addFirst(int x) {
		head = new IntNode(x, head);
		
		if (numNodes == 0) {
			tail = head;
		}
		
		numNodes =+ 1;
	}
	
	// Removes all the elements from this list 
	public void clear() {
		head = null;
		tail = null;
	}
	
	// Returns true if this list contains the specified element 
	// **** SEARCHING FOR NODE OR INT? 
	public boolean contains (int x) {
		IntNode temp = head;
		
		if (numNodes > 0) {
			for (int i=0; i<numNodes; i++) {
				if (x == temp.getData()) {
					// *** but how do I iterate through the list? 
					return true;
				}
			}
		}
		
		return false;
	}
	
	// returns the element at the specified position in this list
	public IntNode get(int index) {
		IntNode temp = null;
		
		if (numNodes >= index) { 
			for (int i=0; i<numNodes; i++) {
				if (i == index) {
					// iterate through nodes... 
					return temp;
				}
			}
		} else { // or (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		}
		
		return temp; // discard 
		
	}
	
	// returns the first element in this list
	public IntNode getFirst() {
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			return head.getLink(); // **** do I return the link?	
		}
	}
	
	// returns the last element in this list
	public IntNode getLast() {
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			return tail.getLink(); // **** do I return the link?	
		}
	}
	
	// retrieves and removes the head of this list
	public int remove() {
		IntNode temp = head;
		
		// reassign head to 2nd link
		// head = 2nd link;
		 
		return temp.getData();
	}
	
	// removes the element at the specified position in this list
	public IntNode remove(int index) {
		//IntNode temp = new IntNode(get(index));
		
		return head; // temp
	}
	
	// removes the 1st occurrence of the specified element in the list 
	// traverse list head to tail 
	public boolean removeFirstOccurrence(IntNode n) {
		IntNode temp = head;
		
		if (numNodes > 0) {
			for (int i=0; i<numNodes; i++) {
				if (n.equals(temp)) { // have to iterate through nodes 
					return true;
				}
			}
		}
		
		return false;
	}
	
	// removes and returns the last element from this list
	public IntNode removeLast(int x) {
		IntNode temp = tail;
		
		if (numNodes > 0) {
			//tail = previous.getLink();
			return temp; 
		} else {
			throw new NoSuchElementException();
		}
		
		// x.previouslink.link.link 
	}
	
	// removes the last occurrence of the specified element in the list 
	// traverse list head to tail 
	public boolean removeLastOccurrence(IntNode n) {
		IntNode temp = tail;
		
		if (numNodes > 0) {
			for (int i = numNodes - 1; i >= 0; i--) { // **** do Linked List start at index 0 or 1?
				if (n.equals(temp)) { // have to iterate through nodes 
					return true;
				}
			}
		}
			
		return false;
	}
	
	// ------ didn't really look at the ones below: ---------
	
	// replaces the element at the specified position in this list with the specified element
	// return element previously stored in the position 
	public IntNode set(int index, int value) {
		
		
		return head;
	}
	
	// returns number of elements in this list 
	public int size() {
		return numNodes;
	}
	
	// returns an array containing all of the elements in this list 
	// in proper sequence (from first to last element)
	public int[] toArray() {
		int[] arr = null;
		
		return arr;
		
	}
	
}
