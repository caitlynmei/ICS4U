package com.bayviewglen.dayFiveStacksQueues;

import java.util.Arrays;

public class Queue {

	Object[] queue;
	int howMany = 0; 
	
	public Queue ( ) {
		queue = new Object[10];
	}
	
	public void enqueue(Object el) {
		if (howMany < queue.length) {
			queue[++howMany] = el; 
		} else {
			queue = Arrays.copyOf(queue, queue.length + 20);
		}
	}
	
	public Object dequeue(Object el) {
		howMany--;
		return queue[0];
	}
	
	public Object peek() {
		return queue[0];
	}
	
	public void clear() {
		for (Object o : queue) {
			o = null;
		}
	}
	
	public boolean isEmpty() {
		if (howMany == 0) {
			return true;
		}
		
		return false;
	}
	
}
