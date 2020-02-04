package com.ssafy.stack;

import java.util.Stack;

public class StackTest_API {

	public static void main(String[] args) {
//		API로 제공하는 자료구조(Stack, LinkedList,...)는 객체만 저장
//		 - toString()가 제공되어 저장된 자료들을 출력한다.
		
//		Stack에 Integer 타입들만 저장하도록 선언
		Stack<Integer> stack = new Stack<Integer>();
		
//		isEmpty() : stack에 데이터가 없으면 true, 있으면 false
		System.out.println(stack.isEmpty());
		
//		size() : stack에 저장된 데이터 개수
		System.out.println(stack.size());
		
//		push() : stack에 데이터를 저장
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		
//		contains(데이터) : 특정 데이터가 stack에 저장되어 있으면 true, 없으면 false
		System.out.println(stack.contains(1));
		System.out.println(stack.contains(3));

//		clear() : 자료구조에 저장된 모든 원소를 제거하는 기능
		stack.clear();
		System.out.println(stack);
		
//		스택이 비어있는 경우 peek(), pop() 을 통해 데이터를 추출하면 EmptyStackException
//		peek() : 맨 끝에 저장한 데이터를 리턴
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		
//		pop() : 맨 끝에 저장한 데이터를 제거 후 리턴
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack);
		
		//stack에서 중간에 삽입하는 것은 좋지 않다. (add함수 사용할떄)
		
//		stack.firstElement(); //큐로 쓸 수 있음
//		stack.get(0); //특정한 위치의 데이터 꺼내오기
		
		
		
		
	}

}
