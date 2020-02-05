package com.ssafy.method;

public class Test {

	public static void main(String[] args) {
		MethodTest.work(0); 
		MethodTest m = new MethodTest();  //static으로 선언되지 않은 경우 new로 객체 생성 후 호출해야함
		m.mmm();
	}

}
