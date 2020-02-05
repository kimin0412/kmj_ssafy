package com.ssafy;

public class Child extends Parent{
	int y = 500;
	void goodBye() {
		System.out.println("잘가요~!!");
	}
	void print() {  //메서드 재정의는 항상 자식클래스에서 한다. : 오버라이딩 메서드
		System.out.println("자식 프린트~~!!");
	}
}
