package com.ssafy.method;

public class stringTest2 {
	public static void main(String[] args) {
		int k = 10;
		int k2 = 10;
		String s1 = new String("Hello");
		String s2 = new String("hello");	
		String s3 = "Hello";
		String s4 = "Hello";
		
		System.out.println(k==k2);  //기본형은 값을 비교하지만
		System.out.println(s3==s4);
		System.out.println(s1==s2);  //참조형은 주소값 같은지 물어보는거
		System.out.println(s1==s3);  //이건 주소값 같은지 물어보는거
//		자기 데이터를 비교해야 하니까 클래스마다 equals 메서드가 다름
		System.out.println(s1.equals(s3));  //이건 주소에 있는 값이 같은지 물어보는거
		System.out.println(s1.equals(s4));  //이건 주소에 있는 값이 같은지 물어보는거
		System.out.println(s1.equalsIgnoreCase(s2));
		
	}
}