package com.bayviewglen.dayFourStacks;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

//import com.bayviewglen.dayFiveStacksQueues.Stack;

public class StackApplications {

	public static void main(String[] args) {
		
		testInFix("data/infix.dat");
		testPostFix("data/postfix.dat");

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

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void evaluateInFix(String[] stream) {
		//Stack operators = new Stack();
		//Stack operands = new Stack();
		
		Stack<String> operators = new Stack<String>();
		Stack<Double> operands = new Stack<Double>();
		
		String OPERATORS = "+-*/";
		
		System.out.print("\nInfix Expression: ");
		for (String s : stream) {
			System.out.print(s);
		}
		
		for (String s : stream) {
			if (s.equals("(")){
				operators.push(s);
			} else if (s.equals(")")){
				if (operators.peek().equals("(")) {
					operators.pop();
				} else if (!operators.empty() && OPERATORS.indexOf(operators.peek()) != -1){
					String op = operators.peek();
					if (op.equals("+")) {
						operators.pop();
						operands.push(operands.pop() + operands.pop());
					} else if (op.equals("-")) {
						operators.pop();
						operands.push(operands.pop() - operands.pop());
					} else if (op.equals("*")) {
						operators.pop();
						operands.push(operands.pop() * operands.pop());
					} else if (op.equals("/")) {
						operators.pop();
						operands.push(operands.pop() / operands.pop());
					} else {
						operands.push(Double.parseDouble(s));
					}
				}
			} else if (OPERATORS.indexOf(s) == -1) {
				// these are operands
				String op = operators.peek();
				Double temp = Double.parseDouble(s);
				
				if (op.equals("+")) {
					operators.pop();
					operands.push(operands.pop() + temp);
				} else if (op.equals("-")) {
					operators.pop();
					operands.push(operands.pop() - temp);
				} else if (op.equals("*")) {
					operators.pop();
					operands.push(operands.pop() * temp);
				} else if (op.equals("/")) {
					operators.pop();
					operands.push(operands.pop() / temp);
				} else {
					operands.push(Double.parseDouble(s));
				}
			} else {
				// these are operators
				operators.push(s);
			}
		}
		
		/*
		for (int i=0; i<stream.length; i++) {
			if (numbers.indexOf(stream[i]) == -1) {
				if (stream[i].equals("(")) {
					operators.push(stream[i]);
					//System.out.println("operators " + operators +"\n");
				} else if (stream[i].equals(")") && operators.peek().equals("(")) {
					operators.pop();
					//System.out.println("operators close " + operators+ "\n");
				}else if (stream[i].equals(")") && !operators.peek().equals("(")) {
					String op = operators.pop(); // new 
					// pop two operands and make them doubles
					// do the if staTEMENT AND PUSH THE RESULT TO THE OPERAND STACK
					//System.out.println("operators close " + operators+ "\n");
				} else if (operators.peek().equals("(")) {
					operators.push(stream[i]);
					//System.out.println("operators " + operators +"\n");
				} // add logic for ")" to check if NOT "(" on top
			
			} else {
				double temp = Double.parseDouble(stream[i]);
				if (operators.peek().equals("(")) {
					operands.push(temp);

					//System.out.println("operands " + operands);
					//System.out.println("operators " + operators +"\n");
					
				} else {
					if (operators.peek().equals("*")) {
						operands.push(temp * operands.pop());
						operators.pop();
						
						//System.out.println("operands " + operands);
						//System.out.println("operators " + operators +"\n");
						
					} else if (operators.peek().equals("/")) {
						operands.push(temp / operands.pop());
						operators.pop();
						
						//System.out.println("operands " + operands);
						//System.out.println("operators " + operators +"\n");
						
					} else if (operators.peek().equals("+")) {
						operands.push(temp + operands.pop());
						operators.pop();

						//System.out.println("operands " + operands);
						//System.out.println("operators " + operators +"\n");
						
					} else if (operators.peek().equals("-")) {
						operands.push(temp - operands.pop());
						operators.pop();

						//System.out.println("operands " + operands);
						//System.out.println("operators " + operators +"\n");
						
					}
				}
			}
		}
		
		if (!operators.isEmpty()) {
			if (operators.peek().equals("*")) {
				operands.push(operands.pop() * operands.pop());
				operators.pop();
				
				//System.out.println("operands " + operands);
				//System.out.println("operators " + operators +"\n");
				
			} else if (operators.peek().equals("/")) {
				operands.push(operands.pop() / operands.pop());
				operators.pop();
				
				//System.out.println("operands " + operands);
				//System.out.println("operators " + operators +"\n");
				
			} else if (operators.peek().equals("+")) {
				operands.push(operands.pop() + operands.pop());
				operators.pop();

				//System.out.println("operands " + operands);
				//System.out.println("operators " + operators +"\n");
				
			} else if (operators.peek().equals("-")) {
				operands.push(operands.pop() - operands.pop());
				operators.pop();

				//System.out.println("operands " + operands);
				//System.out.println("operators " + operators +"\n");
				
			}
		}
		
		*/
		System.out.println("\nInfix Expression Result: " + operands.peek());		
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

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void evaluatePostFix(String[] stream) {
		//Stack operands = new Stack();
		Stack<Double> operands = new Stack<Double>();

		System.out.print("\nPostfix Expression: ");
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
		System.out.println("\nPostfix Expression Result: " + operands.peek());
	}
}
