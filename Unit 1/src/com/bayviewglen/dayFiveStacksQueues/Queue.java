package com.bayviewglen.dayFiveStacksQueues;

import java.util.Arrays;

public class Queue {

	private Object[] queue;
	private int howMany = 0; 
	
	public Queue ( ) {
		queue = new Object[100];
		int howMany = 0;
	}
	
	public void enqueue(Object el) {
		if (howMany < queue.length) {
			queue[++howMany] = el; 
		} else {
			queue = Arrays.copyOf(queue, queue.length + 20);
		}
	}
	
	public Object dequeue(Object el) {
		Object temp = queue[0];
		if (temp == null) {
			throw new NullPointerException();
		}
		//howMany--;
		return temp;
	}
	
	public Object peek() {
		Object temp = queue[0];
		if (temp == null) {
			throw new NullPointerException();
		}
		
		return temp;
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
