package com.ssafy;

class A{
	void hello() {
		System.out.println("안녕하세요~~~!");
	}
}

class Child extends A{
	void hello() {
		System.out.println("봉쥬르~!");
	}
}
public class AnonymousTest {
	public static void main(String[] args) {
		//hello 메소드를 호출 하시오!
		A a = new A();
		a.hello();
		System.out.println("==================");
		A a2 = new A() //new A() ----> extends A ----> 무명의 내부 클래스!! (new는 메모리 할당 키워드가 아님 새로운)
																	//anonymous innerClass
		{//클래스 시작
			@Override
			void hello() {
				System.out.println("신짜오~!!");
			}
		};//클래스 끝
		a2.hello();
		
		A a3 = new Child();
		a3.hello();
		
		
	}//main

}
