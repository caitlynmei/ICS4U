package com.bayviewglen.dayFiveStacksQueues;

import java.util.Arrays;

public class Stack {

	Object[] stack;
	int howMany = 0;
	
	public Stack () {
		stack = new Object[10];
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
		return stack[--howMany];

	}
	
	public Object peek() {
		return stack[howMany-1];
	}
	
	public boolean empty() {
		if (howMany == 0) {
			return true;
		}
		
		return false;
	}

}
