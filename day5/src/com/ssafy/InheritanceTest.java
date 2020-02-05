package com.ssafy;

// 상속이란 자식이 부모껄 마음대로 쓰는것.
public class InheritanceTest {

	public static void main(String[] args) {
		System.out.println("====부모 객체 생성====");
		Parent p = new Parent();
		System.out.println("X="+ p.x);
		p.hello();
//		p.goodbye();
//		에러발생 : 부모레퍼런스 통해 절대 자식 호출 불가
		System.out.println("=====자식 객체 생성=====");
		
		Child c = new Child();
		System.out.println("Y="+c.y);
		c.goodBye();
		System.out.println("X="+c.x);
		c.hello();
		
		System.out.println("=====(부모=자식)=====");
//		Child c2 = new Parent();  => 안됨
		Parent p2 = new Child(); //new : 동적 메모리할당 키워드
//		p2 : 주소를 담는 변수(참조변수), 앞으로만 간다. new : 뒤로만 간다. 
		p2.hello();
		p2.print();
//		p2.goodBye();  => 부모 래퍼런스를 통해서 자식호출 불가
		
		
	}
}
