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
		
		if (index < 0 || index >= numNodes) {
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
		
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {			
			IntNode temp = head;
			
			if (numNodes == 1) {
				clear();
			} else {
				IntNode secondLink = head.getLink(); // 2nd link in list
				head = secondLink;
			}
			
			numNodes--;
			return temp.getData();
		}
	}
	
	// **** being stupid about the returns 
	// Removes the element at the specified position in this list
	// Returns the element that was removed from the list.
	public int remove(int index) {
		
		int temp = get(index);
		
		if (index < 0 || index >= numNodes) {
			throw new IndexOutOfBoundsException();
		} else {  // (numNodes > index) 
			if (index == 0){ // if index is head 
				if (numNodes == 1) {
					clear();
				} else {
					IntNode secondLink = head.getLink(); // 2nd link in list
					head = secondLink;
				}
			} else if (index == numNodes-1) { // if index is tail
				if (numNodes == 1) {
					clear();
				} else {
					IntNode previous = head;
					IntNode secondLast = head;
					
					for (int i=0; i<numNodes; i++) {
						if (i == numNodes-2) {
							secondLast = previous;
							break;
						}
						previous = previous.getLink();
					}
					tail = secondLast;
				}
			} else {
				IntNode previous = head;
				IntNode next = previous;
				for (int i=0; i<index; i++) {
					previous = previous.getLink();
				}
				next = previous.getLink();
				previous.setLink(next.getLink());

			}
			numNodes--;
			return temp; 
		}
	}
	
	// removes the 1st occurrence of the specified element in the list 
	// traverse list head to tail 
	public boolean removeFirstOccurrence(int value) {
		int removeIndex = 0; // index for element that will be removed 
		boolean valid = false;
		
		if (numNodes > 0 && contains(value)) {			
			IntNode previous = head;
			for (int i=0; i<numNodes; i++) {
				if (value == previous.getData()) {
					removeIndex = i;
					valid = true;
					break;
				}
				previous = previous.getLink();
			}
		}
		
		if (valid) {
			if (removeIndex == 0) { // if 1st occurrence is the head
				if (numNodes == 1) {
					clear();
				} else {
					IntNode secondLink = head.getLink(); // 2nd link in list
					head = secondLink;
				}
			} else if(removeIndex == numNodes-1){ // if 1st occurrence is the tail 
				if (numNodes == 1) {
					clear();
				} else {
					IntNode previous = head;
					IntNode secondLast = head;
					
					for (int i=0; i<numNodes; i++) {
						if (i == numNodes-2) {
							secondLast = previous;
							break;
						}
						previous = previous.getLink();
					}
					tail = secondLast;
				}
			} else {
				IntNode previous = head;
				for (int i=0; i<removeIndex-1; i++) {
					previous = previous.getLink();
				}
				previous.setLink(null);	
			}
			numNodes--;
		}
		
		return valid;
	}
	
	// removes and returns the last element from this list
	public int removeLast() {
		int temp = tail.getData();
		
		if (numNodes > 0) {
			if (numNodes == 1) {
				clear();
			} else {
				IntNode previous = head;
				IntNode secondLast = head;
				
				for (int i=0; i<numNodes; i++) {
					if (i == numNodes-2) {
						secondLast = previous;
						break;
					}
					previous = previous.getLink();
				}
				tail = secondLast;
			}
			numNodes--;
			return temp; 
			
		} else {
			throw new NoSuchElementException();
		}
	}
	
	// removes the last occurrence of the specified element in the list 
	// traverse list head to tail 
	// if the list does not contain the element, it is unchanged.
	public boolean removeLastOccurrence(int value) {
		int removeIndex = 0;
		boolean valid = false;
		
		if (numNodes > 0 && contains(value)) {
			for (int i = numNodes - 1; i >= 0; i--) {
				if (value == get(i)) { 
					removeIndex = i;
					valid = true;
					break;
				}
			}
		}
		
		if (valid) {
			if (removeIndex == 0) { // if last occurrence is the head
				if (numNodes == 1) {
					clear();
				} else {
					IntNode secondLink = head.getLink(); // 2nd link in list
					head = secondLink;
				}
			} else if(removeIndex == numNodes-1){ // if last occurrence is the tail 
				if (numNodes == 1) {
					clear();
				} else {
					IntNode previous = head;
					IntNode secondLast = head;
					
					for (int i=0; i<numNodes; i++) {
						if (i == numNodes-2) {
							secondLast = previous;
							break;
						}
						previous = previous.getLink();
					}
					tail = secondLast;
				}
			} else {
				IntNode previous = head;
				for (int i=0; i<removeIndex-1; i++) {
					previous = previous.getLink();
				}
				previous.setLink(null);	
			}
			numNodes--;
		}
		
		return valid;
	}
	
	// replaces the element at the specified position in this list with the specified element
	// return element previously stored in the position 
	public int set(int index, int value) {
		IntNode previous = head;
		int temp = 0;
		
		if (index < 0 || index >= numNodes) {
			throw new IndexOutOfBoundsException();
		} else {
			for (int i=0; i<index; i++) {
				if (i<index-1) {
					temp = previous.getData();
				}
				previous = previous.getLink();
			}
			previous.setData(value);
			return temp;
		}
	}
	
	// returns number of elements in this list 
	public int size() {
		return numNodes;
	}
		
	// returns an array containing all of the elements in this list 
	// in proper sequence (from first to last element)
	public int[] toArray() {
		int[] arr = null;
		
		for (int i=0; i<numNodes; i++) {
			arr[i] = get(i);
		}
		
		return arr;
	}
}
