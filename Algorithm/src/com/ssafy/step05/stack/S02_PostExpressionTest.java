package com.ssafy.step05.stack;

import java.util.Stack;

/**
 * @author taehee kim
 */

public class S02_PostExpressionTest {

	public static void main(String[] args) {
		
		String expression = "6528-*2/+";
		Stack<Integer> stack = new Stack<Integer>();
		
		System.out.println(expression);
		int size = expression.length();		
		for (int i = 0; i < size; i++) {
			char temp = expression.charAt(i);
			
			if(Character.isDigit(temp)) { // 피연산자
				stack.push(temp-'0');
			}else { // 연산자
				int value2 = stack.pop(); // 두번째 피연산자
				int value1 = stack.pop(); // 첫번째 피연산자
				
				switch(temp) {
				case '+':
					stack.push(value1+value2);
					break;
				case '-':
					stack.push(value1-value2);
					break;
				case '*':
					stack.push(value1*value2);
					break;
				case '/':
					stack.push(value1/value2);
					break;
				}
			}
		} // end for
		
		System.out.println(stack.pop());		
	}

}







