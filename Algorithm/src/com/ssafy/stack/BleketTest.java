package com.ssafy.stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호검사 - 괄호 짝이 맞으면 OK, 짝이 맞지 않으면 Error를 출력하세요
 * 
 * [입력] 첫줄은 테스트 케이스(T) 수 두번째 줄부터 T줄의 괄호 데이터가 입력된다.
 * 
 * [출력] #테스트케이스번호 결과
 * 
 * [결과] #1 Error #2 Error #3 OK #4 Error #5 Error
 * 
 * @author multicampus
 *
 */
public class BleketTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("blekettest.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 공백과 엔터기준이라 엔터도 가져갈 수 있다.
		sc.nextLine(); // 남아있는 엔터 읽기
		Stack<Character> stack = new Stack<Character>();

		for (int test_case = 0; test_case < T; test_case++) {
			String result = "OK";
			String s = sc.nextLine();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty()) {
						result = "Error";
						break;
					} else
						stack.pop();
				}
			}
//			System.out.println(stack);
			if (!stack.isEmpty())
				result = "Error";

			stack.clear();
			System.out.println("#" + test_case + " " + result);
		}
	}

}

/**
 * 5 (( ) ( )) ( )( )((( ))) ((( )((((( )( )((( )( ))((( )))))) )(
 * 
 */