package com.ssafy.array;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
//		콘솔창에 출력 
		System.out.println("처음하는");
		System.out.println("java world");
//		printf(String format, Object...데이터)
//		%d : 정수형
//		%f : 실수형  %.소수자리f
//		%c : 문자
//		%s : 객체 or 문자열
//		%b : 논리
		System.out.printf("%d * %d = %d\n",256,357,256*357);
		System.out.printf("%d * %d = %.2f\n",25.6,35.7,25.6*35.7);
		
		ArrayList<String> list = new ArrayList<>();
		if (list instanceof List) {
			List new_name = (List) list;
			
		}
	}
}
