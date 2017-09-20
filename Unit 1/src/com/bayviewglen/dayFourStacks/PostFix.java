package com.bayviewglen.dayFourStacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class PostFix {

	public static void main(String[] args) {
		
		testPostFix("data/postfix.dat");
		testInFix("data/infix.dat");
		
		
	}

	private static void testInFix(String fileName) {
		File f = new File(fileName);
		Scanner input;
		
		try {
			input = new Scanner(f);
			while (input.hasNext()) {
				String expression = input.nextLine();
				evaluateInFix(expression.split(" "));
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	private static void evaluateInFix(String[] stream) {
		Stack<String> operators = new Stack<String>();
		Stack<Double> operands = new Stack<Double>();
		
		String numbers = "0123456789";
		String operators1 = "*/+-";
		
		for (String s : stream) {
			System.out.print(s);
		}
		
		for (int i=0; i<stream.length; i++) {
			if (operators.indexOf(stream[i]) != -1){
				operands.push(Double.parseDouble(stream[i]));
				System.out.println(operands);
			} else {
				if (stream[i].equals("*")) {
					operands.push(operands.pop() * operands.pop());
				} else if (stream[i].equals("/")) {
					operands.push(operands.pop() / operands.pop());
				} else if (stream[i].equals("+")) {
					operands.push(operands.pop() + operands.pop());
				} else if (stream[i].equals("-")) {
					operands.push(operands.pop() - operands.pop());
				}
			}
						
			//System.out.print(s);
		}
		
		
	}
	
	private static void testPostFix(String fileName) {
		File f = new File(fileName);
		Scanner input;
		try {
			input = new Scanner(f);
			while (input.hasNext()) {
				String expression = input.nextLine();
				evaluatePostFix(expression.split(" "));
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}		
	}

	private static void evaluatePostFix(String[] stream) {
		Stack<Double> operands = new Stack<Double>();
		//String numbers = "0123456789";
		//String operators = "*/+-";
		
		for (String s : stream) {
			System.out.print(s);
		}
	
		for (String s : stream) {
			if (s.equals("*")) {
				operands.push(operands.pop() * operands.pop());
			} else if (s.equals("/")) {
				operands.push(operands.pop() / operands.pop());
			} else if (s.equals("+")) {
				operands.push(operands.pop() + operands.pop());
			} else if (s.equals("-")) {
				operands.push(operands.pop() - operands.pop());
			} else {
				operands.push(Double.parseDouble(s));
			}
		}
		operands.peek();
		//System.out.println(operands);
	}
}
