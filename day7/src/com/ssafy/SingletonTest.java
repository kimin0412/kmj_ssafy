package com.ssafy;

public class SingletonTest {

	public static void main(String[] args) {
//		생성자를 private으로 선언해서 객체를 직접 생성할 수 없다.
//		MySingleton s = new MySingleton();
		
		MySingleton s1 = MySingleton.getInstance();
		s1.test();
		
		MySingleton s2 = MySingleton.getInstance();
		s2.test();
		
		MySingleton s3 = MySingleton.getInstance();
		s3.test();
		
	}

}
