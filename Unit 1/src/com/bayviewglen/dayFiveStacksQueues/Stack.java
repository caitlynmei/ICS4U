package com.bayviewglen.dayFiveStacksQueues;

import java.util.Arrays;

public class Stack {

	private Object[] stack;
	private int howMany;
	
	public Stack () {
		stack = new Object[100];
		howMany = 0;
	}
	
	public void push(Object el) {
		Object[] temp;
		
		if (howMany < stack.length) {
			stack[++howMany] = el; 
		} else {
			stack = Arrays.copyOf(stack, stack.length + 20);
		}
	}
	
	public Object pop() {
		Object temp = stack[--howMany];
		
		if (temp == null) {
			throw new NullPointerException();
		}
		
		return temp;
	}
	
	public Object peek() {
		Object temp = stack[howMany-1];
		
		if (temp == null) {
			throw new NullPointerException();
		}
		
		return temp;
	}
	
	public boolean empty() {
		if (howMany == 0) {
			return true;
		}
		
		return false;
	}

}
