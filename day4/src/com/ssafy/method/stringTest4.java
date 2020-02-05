package com.ssafy.method;

import java.util.Scanner;

public class stringTest4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String msg = s.next();
		char ch = msg.charAt(0);
		if (ch >= '0' && ch <= '9') // 그냥 이렇게 물어보면 됨
			System.out.println("숫자");
		else {
			System.out.println("문자");
		}
		
		Character ch2 = msg.charAt(0);
		System.out.println("숫자냐? " + Character.isDigit(ch2));  //Character는 char의 wrapper 클래스 이다.
		System.out.println("숫자냐? " + Character.isLetter(ch2));
//		Integer 클래스는 int의 wrapper 클래스 이다.
	}
}
