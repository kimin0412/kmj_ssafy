package com.ssafy.step05.stack;

import java.util.Stack;

/**
 * @author taehee kim
 */
public class S01_StackAPITest {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>(); // 공백스택 생성
		stack.push("김태희");
		stack.push("이동욱");
		stack.push("이지아");
		
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		
		
		

	}

}
