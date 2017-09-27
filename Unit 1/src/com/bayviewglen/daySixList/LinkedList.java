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
		if (numNodes == 0) {
			addFirst(x); // The linked list is empty. I need to make sure head and tail both points to it. 
		} else if (numNodes >= 1){
			tail = new IntNode(x, tail);
			numNodes += 1;
		} 
		
		return true;
	}
	
	// Inserts the specified element at the specified position in this list 
	public void add(int index, int value) {
		if (numNodes == 0) {
			addFirst(value);
			// check for empty link -- if they give you one that's out of bounds, throw an exception 
		} else {		
			if (index < numNodes){
				IntNode previous = head;
				
				for (int i=0; i<index; i++) {
					previous = previous.getLink();
				}
					
				// create new node and insert it as you are at the correct spot now
				// Notes: .getLink() points to the next link
				// 		  .setLink() sets the new reference link 
				
				previous.setLink(new IntNode(value, previous.getLink()));
				numNodes += 1;
			} else {
				throw new IndexOutOfBoundsException();
			}
		}
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
	public boolean contains (int value) {
		IntNode previous = head;
		
		if (numNodes > 0) {
			for (int i=0; i<numNodes; i++) {
				if (value == previous.getData()) {
					return true;
				}
				previous = previous.getLink();
			}
		}
		
		return false;
	}
	
	// returns the element at the specified position in this list
	public int get(int index) {
		IntNode previous = head;
		
		if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException();
		} else { // (numNodes > index) 
			for (int i=0; i<index; i++) {
				previous = previous.getLink();
			}
			return previous.getData();
		}		
	}
	
	// returns the first element in this list
	public int getFirst() {
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			return head.getData(); 	
		}
	}
	
	// returns the last element in this list
	public int getLast() {
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			return tail.getData();	
		}
	}
	
	// retrieves and removes the head of this list
	public int remove() {
		IntNode temp = head;
		IntNode secondLink = head.getLink(); // 2nd link in list
		head = secondLink;
		
		numNodes -= 1;
		return temp.getData();
	}
	
	// removes the element at the specified position in this list
	public int remove(int index) {
		IntNode previous = head;
		int temp = 0;
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		} else { // (numNodes >= index) 
			for (int i=0; i<index; i++) {
				temp = previous.getData();
				previous = previous.getLink();
			}
			previous.setLink(new IntNode(previous.getData(), previous.getLink()));
		}
		
		return temp; 
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
	
	// replaces the element at the specified position in this list with the specified element
	// return element previously stored in the position 
	public int set(int index, int value) {
		IntNode previous = head;
		int temp = 0;
		
		for (int i=0; i<index; i++) {
			if (i<index-1) {
				temp = previous.getData();
			}
			previous = previous.getLink();
		}
		
		previous.setData(value);
		
		return temp;
	}
	
	// ------ didn't really look at the ones below: ---------
	
	
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
