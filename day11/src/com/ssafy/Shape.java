package com.ssafy;

public abstract class Shape {
//	void draw(); //영역괄호 있어야 한다고 오류남
	abstract void draw(); // 선언된 메소드 ==> 자식 클래스에게 강제하는 역할

	public void hello() { // 정의된 메서드 ==> 자식에게 상속
		System.out.println("봉쥬르~~!");
	}
}

class Triangle extends Shape {

	@Override
	void draw() {
		System.out.println("삼각형 그리기");
	}

}

class Rectangle extends Shape {

	@Override
	void draw() {
		System.out.println("사각형 그리기");
	}
}

class Circle extends Shape {

	@Override
	void draw() {
		System.out.println("원 그리기");
	}
}