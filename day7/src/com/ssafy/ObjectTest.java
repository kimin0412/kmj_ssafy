package com.ssafy;

public class ObjectTest {

	public static void main(String[] args) {
//		메모리 값만 비교
//		Reference type 은 변수에 hashcode가 저장됨.
//		******시험에 나옴!!******
		Member m1 = new Member("ssafy", 3, "ssafy@ssafy.com");
		Member m2 = new Member("ssafy", 3, "ssafy@ssafy.com");
		System.out.println("m1.hashcode : "+ m1.hashCode());
		System.out.println("m2.hashcode : "+ m2.hashCode());
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));  //
		
		
		
	}

}
