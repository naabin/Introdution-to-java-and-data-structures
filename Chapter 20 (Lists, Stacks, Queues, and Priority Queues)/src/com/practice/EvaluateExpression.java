package com.practice;

import java.util.Stack;

public class EvaluateExpression {
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: java EvaluateExpression \"expression\"");
			System.exit(1);
		}
		
		try {
			System.out.println(evaluateExpresssion(args[0]));
		}
		catch(Exception ex) {
			System.out.println("Wrong expression: " + args[0]);
		}
		
		
		
		
		
	}

	private static int evaluateExpresssion(String expression) {
		//Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<>();
		
		//Create operatorStack to store operatorStack
		Stack<Character> operatorStack = new Stack<Character>();
		
		//Insert blanks around (,), + , - , / , and *
		 expression = insertBlanks(expression);
		 
		 //Extract operands and operator
		 String[] tokens = expression.split(" ");
		 
		 //Phase 1: Scan tokens
		 for(String token: tokens) {
			 if(token.length() == 0) {
				 continue;
			 }
			 else if(token.charAt(0) == '+' || token.charAt(0) == '-') {
				 //Process all +, - , * , / in the top of the operator stack
				 while(!operatorStack.isEmpty() && 
						 (operatorStack.peek() == '+' ||
						  operatorStack.peek() == '-' ||
						  operatorStack.peek() == '*' ||
						  operatorStack.peek() == '/'
						 )) {
					 // push the + or - operator into the operator stack
					 processAnOperator(operandStack, operatorStack);
				 }
				 operatorStack.push(token.charAt(0));
			 }
			 else if(token.charAt(0) == '*' || token.charAt(0) == '/') {
				 //Process all *, / in the top of the operator stack
				 while(!operatorStack.isEmpty() && 
						(operatorStack.peek() == '*' ||
						 operatorStack.peek() == '/'
						 )) {
					 processAnOperator(operandStack, operatorStack);
				 }
				 //Push the * or / operator into the operator stack
				 operatorStack.push(token.charAt(0));
			 }
			 else if(token.trim().charAt(0) == '(') {
				 operatorStack.push('(');
			 }
			 else if(token.trim().charAt(0) == ')') {
				 while(operatorStack.peek() != '(') {
					 processAnOperator(operandStack, operatorStack);
				 }
				 operatorStack.pop();
			 }
			 else {
				 operandStack.push(new Integer(token));
			 }
		 }
		 //phase 2: Process all the remaining operators in the stack
		 while(!operatorStack.isEmpty()) {
			 processAnOperator(operandStack, operatorStack);
		 }
		
		return operandStack.pop();
	}
	/**
	 * Process one operator: take an operator from operatorStack
	 * and apply it to the operands in the operandStack
	 * @param operandStack
	 * @param operatorStack
	 */
	public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		
		if(op == '+') {
			operandStack.push(op2 + op1);
		}
		else if(op == '-') {
			operandStack.push(op2 - op1);
		}
		else if(op == '*') {
			operandStack.push(op2 * op1);
		}
		else if(op == '/') {
			operandStack.push(op2 / op1);
		}
	}
	
	
	public static String insertBlanks(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || 
					s.charAt(i) == ')' || 
					s.charAt(i) == '+' ||
					s.charAt(i) == '-' ||
					s.charAt(i) == '*' ||
					s.charAt(i) == '/')
			{
				result += " " + s.charAt(i) + " ";
			}
			else {
				result += s.charAt(i);
			}
		}
		return result;
	}

}
